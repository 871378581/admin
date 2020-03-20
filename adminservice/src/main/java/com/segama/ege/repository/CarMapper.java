package com.segama.ege.repository;

import com.segama.ege.entity.Car;
import com.segama.ege.entity.CarExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface CarMapper {
    @SelectProvider(type=CarSqlProvider.class, method="countByExample")
    int countByExample(CarExample example);

    @DeleteProvider(type=CarSqlProvider.class, method="deleteByExample")
    int deleteByExample(CarExample example);

    @Delete({
        "delete from `car`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `car` (`user_id`, `plate`, ",
        "`car_type_id`, `car_type_name`, ",
        "`car_type_color`, `car_logo_url`, ",
        "`gmt_last_maintenance`, `membership_card_id`, ",
        "`car_status`, `gmt_activate`, ",
        "`gmt_take_effect`, `gmt_lose_effect`, ",
        "`gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`, ",
        "`version`, `is_default`, ",
        "`color`, `vin`, `card_level`, ",
        "`last_maintenance_miles`, `next_maintenance_miles`, ",
        "`curr_maintenance_miles`, `car_type_image`, ",
        "`car_type_code`, `car_brand_code`)",
        "values (#{user_id,jdbcType=VARCHAR}, #{plate,jdbcType=VARCHAR}, ",
        "#{car_type_id,jdbcType=BIGINT}, #{car_type_name,jdbcType=VARCHAR}, ",
        "#{car_type_color,jdbcType=VARCHAR}, #{car_logo_url,jdbcType=VARCHAR}, ",
        "#{gmt_last_maintenance,jdbcType=TIMESTAMP}, #{membership_card_id,jdbcType=VARCHAR}, ",
        "#{car_status,jdbcType=VARCHAR}, #{gmt_activate,jdbcType=TIMESTAMP}, ",
        "#{gmt_take_effect,jdbcType=TIMESTAMP}, #{gmt_lose_effect,jdbcType=TIMESTAMP}, ",
        "#{gmt_create,jdbcType=TIMESTAMP}, #{gmt_modify,jdbcType=TIMESTAMP}, ",
        "#{creator_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR}, ",
        "#{version,jdbcType=INTEGER}, #{is_default,jdbcType=BIT}, ",
        "#{color,jdbcType=VARCHAR}, #{vin,jdbcType=VARCHAR}, #{card_level,jdbcType=VARCHAR}, ",
        "#{last_maintenance_miles,jdbcType=VARCHAR}, #{next_maintenance_miles,jdbcType=VARCHAR}, ",
        "#{curr_maintenance_miles,jdbcType=VARCHAR}, #{car_type_image,jdbcType=VARCHAR}, ",
        "#{car_type_code,jdbcType=VARCHAR}, #{car_brand_code,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Car record);

    @InsertProvider(type=CarSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(Car record);

    @SelectProvider(type=CarSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="plate", property="plate", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_type_id", property="car_type_id", jdbcType=JdbcType.BIGINT),
        @Result(column="car_type_name", property="car_type_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_type_color", property="car_type_color", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_logo_url", property="car_logo_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_last_maintenance", property="gmt_last_maintenance", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="membership_card_id", property="membership_card_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_status", property="car_status", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_activate", property="gmt_activate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_take_effect", property="gmt_take_effect", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_lose_effect", property="gmt_lose_effect", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="is_default", property="is_default", jdbcType=JdbcType.BIT),
        @Result(column="color", property="color", jdbcType=JdbcType.VARCHAR),
        @Result(column="vin", property="vin", jdbcType=JdbcType.VARCHAR),
        @Result(column="card_level", property="card_level", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_maintenance_miles", property="last_maintenance_miles", jdbcType=JdbcType.VARCHAR),
        @Result(column="next_maintenance_miles", property="next_maintenance_miles", jdbcType=JdbcType.VARCHAR),
        @Result(column="curr_maintenance_miles", property="curr_maintenance_miles", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_type_image", property="car_type_image", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_type_code", property="car_type_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_brand_code", property="car_brand_code", jdbcType=JdbcType.VARCHAR)
    })
    List<Car> selectByExample(CarExample example);

    @Select({
        "select",
        "`id`, `user_id`, `plate`, `car_type_id`, `car_type_name`, `car_type_color`, ",
        "`car_logo_url`, `gmt_last_maintenance`, `membership_card_id`, `car_status`, ",
        "`gmt_activate`, `gmt_take_effect`, `gmt_lose_effect`, `gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`, `version`, `is_default`, `color`, `vin`, ",
        "`card_level`, `last_maintenance_miles`, `next_maintenance_miles`, `curr_maintenance_miles`, ",
        "`car_type_image`, `car_type_code`, `car_brand_code`",
        "from `car`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="plate", property="plate", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_type_id", property="car_type_id", jdbcType=JdbcType.BIGINT),
        @Result(column="car_type_name", property="car_type_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_type_color", property="car_type_color", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_logo_url", property="car_logo_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_last_maintenance", property="gmt_last_maintenance", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="membership_card_id", property="membership_card_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_status", property="car_status", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_activate", property="gmt_activate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_take_effect", property="gmt_take_effect", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_lose_effect", property="gmt_lose_effect", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="is_default", property="is_default", jdbcType=JdbcType.BIT),
        @Result(column="color", property="color", jdbcType=JdbcType.VARCHAR),
        @Result(column="vin", property="vin", jdbcType=JdbcType.VARCHAR),
        @Result(column="card_level", property="card_level", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_maintenance_miles", property="last_maintenance_miles", jdbcType=JdbcType.VARCHAR),
        @Result(column="next_maintenance_miles", property="next_maintenance_miles", jdbcType=JdbcType.VARCHAR),
        @Result(column="curr_maintenance_miles", property="curr_maintenance_miles", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_type_image", property="car_type_image", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_type_code", property="car_type_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_brand_code", property="car_brand_code", jdbcType=JdbcType.VARCHAR)
    })
    Car selectByPrimaryKey(Long id);

    @UpdateProvider(type=CarSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Car record, @Param("example") CarExample example);

    @UpdateProvider(type=CarSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Car record, @Param("example") CarExample example);

    @UpdateProvider(type=CarSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Car record);

    @Update({
        "update `car`",
        "set `user_id` = #{user_id,jdbcType=VARCHAR},",
          "`plate` = #{plate,jdbcType=VARCHAR},",
          "`car_type_id` = #{car_type_id,jdbcType=BIGINT},",
          "`car_type_name` = #{car_type_name,jdbcType=VARCHAR},",
          "`car_type_color` = #{car_type_color,jdbcType=VARCHAR},",
          "`car_logo_url` = #{car_logo_url,jdbcType=VARCHAR},",
          "`gmt_last_maintenance` = #{gmt_last_maintenance,jdbcType=TIMESTAMP},",
          "`membership_card_id` = #{membership_card_id,jdbcType=VARCHAR},",
          "`car_status` = #{car_status,jdbcType=VARCHAR},",
          "`gmt_activate` = #{gmt_activate,jdbcType=TIMESTAMP},",
          "`gmt_take_effect` = #{gmt_take_effect,jdbcType=TIMESTAMP},",
          "`gmt_lose_effect` = #{gmt_lose_effect,jdbcType=TIMESTAMP},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`version` = #{version,jdbcType=INTEGER},",
          "`is_default` = #{is_default,jdbcType=BIT},",
          "`color` = #{color,jdbcType=VARCHAR},",
          "`vin` = #{vin,jdbcType=VARCHAR},",
          "`card_level` = #{card_level,jdbcType=VARCHAR},",
          "`last_maintenance_miles` = #{last_maintenance_miles,jdbcType=VARCHAR},",
          "`next_maintenance_miles` = #{next_maintenance_miles,jdbcType=VARCHAR},",
          "`curr_maintenance_miles` = #{curr_maintenance_miles,jdbcType=VARCHAR},",
          "`car_type_image` = #{car_type_image,jdbcType=VARCHAR},",
          "`car_type_code` = #{car_type_code,jdbcType=VARCHAR},",
          "`car_brand_code` = #{car_brand_code,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Car record);
}
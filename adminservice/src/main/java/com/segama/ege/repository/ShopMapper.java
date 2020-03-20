package com.segama.ege.repository;

import com.segama.ege.entity.Shop;
import com.segama.ege.entity.ShopExample;
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

public interface ShopMapper {
    @SelectProvider(type=ShopSqlProvider.class, method="countByExample")
    int countByExample(ShopExample example);

    @DeleteProvider(type=ShopSqlProvider.class, method="deleteByExample")
    int deleteByExample(ShopExample example);

    @Delete({
        "delete from `shop`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `shop` (`enterprise_name`, `person_liable_name`, ",
        "`phone`, `mobile`, `address`, ",
        "`business_license_img_url`, `door_img_url`, ",
        "`logo_img_url`, `introduce`, ",
        "`service`, `score`, ",
        "`is_disable`, `workstation_num`, ",
        "`business_hour_start`, `business_hour_end`, ",
        "`gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`, ",
        "`longitude`, `latitude`, ",
        "`version`, `is_recommend`, ",
        "`gmt_recommend`, `disable_reason`, ",
        "`disable_days`, `small_img_url`, ",
        "`miles_last_maintenance`, `capital_account_id`, ",
        "`capital_account_str`, `evaluate_tags`)",
        "values (#{enterprise_name,jdbcType=VARCHAR}, #{person_liable_name,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{mobile,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{business_license_img_url,jdbcType=VARCHAR}, #{door_img_url,jdbcType=VARCHAR}, ",
        "#{logo_img_url,jdbcType=VARCHAR}, #{introduce,jdbcType=VARCHAR}, ",
        "#{service,jdbcType=VARCHAR}, #{score,jdbcType=VARCHAR}, ",
        "#{is_disable,jdbcType=BIT}, #{workstation_num,jdbcType=BIGINT}, ",
        "#{business_hour_start,jdbcType=VARCHAR}, #{business_hour_end,jdbcType=VARCHAR}, ",
        "#{gmt_create,jdbcType=TIMESTAMP}, #{gmt_modify,jdbcType=TIMESTAMP}, ",
        "#{creator_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR}, ",
        "#{longitude,jdbcType=DECIMAL}, #{latitude,jdbcType=DECIMAL}, ",
        "#{version,jdbcType=INTEGER}, #{is_recommend,jdbcType=BIT}, ",
        "#{gmt_recommend,jdbcType=TIMESTAMP}, #{disable_reason,jdbcType=VARCHAR}, ",
        "#{disable_days,jdbcType=INTEGER}, #{small_img_url,jdbcType=VARCHAR}, ",
        "#{miles_last_maintenance,jdbcType=VARCHAR}, #{capital_account_id,jdbcType=BIGINT}, ",
        "#{capital_account_str,jdbcType=VARCHAR}, #{evaluate_tags,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Shop record);

    @InsertProvider(type=ShopSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(Shop record);

    @SelectProvider(type=ShopSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="enterprise_name", property="enterprise_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="person_liable_name", property="person_liable_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_license_img_url", property="business_license_img_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="door_img_url", property="door_img_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="logo_img_url", property="logo_img_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="introduce", property="introduce", jdbcType=JdbcType.VARCHAR),
        @Result(column="service", property="service", jdbcType=JdbcType.VARCHAR),
        @Result(column="score", property="score", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_disable", property="is_disable", jdbcType=JdbcType.BIT),
        @Result(column="workstation_num", property="workstation_num", jdbcType=JdbcType.BIGINT),
        @Result(column="business_hour_start", property="business_hour_start", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_hour_end", property="business_hour_end", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="longitude", property="longitude", jdbcType=JdbcType.DECIMAL),
        @Result(column="latitude", property="latitude", jdbcType=JdbcType.DECIMAL),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="is_recommend", property="is_recommend", jdbcType=JdbcType.BIT),
        @Result(column="gmt_recommend", property="gmt_recommend", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="disable_reason", property="disable_reason", jdbcType=JdbcType.VARCHAR),
        @Result(column="disable_days", property="disable_days", jdbcType=JdbcType.INTEGER),
        @Result(column="small_img_url", property="small_img_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="miles_last_maintenance", property="miles_last_maintenance", jdbcType=JdbcType.VARCHAR),
        @Result(column="capital_account_id", property="capital_account_id", jdbcType=JdbcType.BIGINT),
        @Result(column="capital_account_str", property="capital_account_str", jdbcType=JdbcType.VARCHAR),
        @Result(column="evaluate_tags", property="evaluate_tags", jdbcType=JdbcType.VARCHAR)
    })
    List<Shop> selectByExample(ShopExample example);

    @Select({
        "select",
        "`id`, `enterprise_name`, `person_liable_name`, `phone`, `mobile`, `address`, ",
        "`business_license_img_url`, `door_img_url`, `logo_img_url`, `introduce`, `service`, ",
        "`score`, `is_disable`, `workstation_num`, `business_hour_start`, `business_hour_end`, ",
        "`gmt_create`, `gmt_modify`, `creator_account`, `modifier_account`, `longitude`, ",
        "`latitude`, `version`, `is_recommend`, `gmt_recommend`, `disable_reason`, `disable_days`, ",
        "`small_img_url`, `miles_last_maintenance`, `capital_account_id`, `capital_account_str`, ",
        "`evaluate_tags`",
        "from `shop`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="enterprise_name", property="enterprise_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="person_liable_name", property="person_liable_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_license_img_url", property="business_license_img_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="door_img_url", property="door_img_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="logo_img_url", property="logo_img_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="introduce", property="introduce", jdbcType=JdbcType.VARCHAR),
        @Result(column="service", property="service", jdbcType=JdbcType.VARCHAR),
        @Result(column="score", property="score", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_disable", property="is_disable", jdbcType=JdbcType.BIT),
        @Result(column="workstation_num", property="workstation_num", jdbcType=JdbcType.BIGINT),
        @Result(column="business_hour_start", property="business_hour_start", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_hour_end", property="business_hour_end", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="longitude", property="longitude", jdbcType=JdbcType.DECIMAL),
        @Result(column="latitude", property="latitude", jdbcType=JdbcType.DECIMAL),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="is_recommend", property="is_recommend", jdbcType=JdbcType.BIT),
        @Result(column="gmt_recommend", property="gmt_recommend", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="disable_reason", property="disable_reason", jdbcType=JdbcType.VARCHAR),
        @Result(column="disable_days", property="disable_days", jdbcType=JdbcType.INTEGER),
        @Result(column="small_img_url", property="small_img_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="miles_last_maintenance", property="miles_last_maintenance", jdbcType=JdbcType.VARCHAR),
        @Result(column="capital_account_id", property="capital_account_id", jdbcType=JdbcType.BIGINT),
        @Result(column="capital_account_str", property="capital_account_str", jdbcType=JdbcType.VARCHAR),
        @Result(column="evaluate_tags", property="evaluate_tags", jdbcType=JdbcType.VARCHAR)
    })
    Shop selectByPrimaryKey(Long id);

    @UpdateProvider(type=ShopSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Shop record, @Param("example") ShopExample example);

    @UpdateProvider(type=ShopSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Shop record, @Param("example") ShopExample example);

    @UpdateProvider(type=ShopSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Shop record);

    @Update({
        "update `shop`",
        "set `enterprise_name` = #{enterprise_name,jdbcType=VARCHAR},",
          "`person_liable_name` = #{person_liable_name,jdbcType=VARCHAR},",
          "`phone` = #{phone,jdbcType=VARCHAR},",
          "`mobile` = #{mobile,jdbcType=VARCHAR},",
          "`address` = #{address,jdbcType=VARCHAR},",
          "`business_license_img_url` = #{business_license_img_url,jdbcType=VARCHAR},",
          "`door_img_url` = #{door_img_url,jdbcType=VARCHAR},",
          "`logo_img_url` = #{logo_img_url,jdbcType=VARCHAR},",
          "`introduce` = #{introduce,jdbcType=VARCHAR},",
          "`service` = #{service,jdbcType=VARCHAR},",
          "`score` = #{score,jdbcType=VARCHAR},",
          "`is_disable` = #{is_disable,jdbcType=BIT},",
          "`workstation_num` = #{workstation_num,jdbcType=BIGINT},",
          "`business_hour_start` = #{business_hour_start,jdbcType=VARCHAR},",
          "`business_hour_end` = #{business_hour_end,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`longitude` = #{longitude,jdbcType=DECIMAL},",
          "`latitude` = #{latitude,jdbcType=DECIMAL},",
          "`version` = #{version,jdbcType=INTEGER},",
          "`is_recommend` = #{is_recommend,jdbcType=BIT},",
          "`gmt_recommend` = #{gmt_recommend,jdbcType=TIMESTAMP},",
          "`disable_reason` = #{disable_reason,jdbcType=VARCHAR},",
          "`disable_days` = #{disable_days,jdbcType=INTEGER},",
          "`small_img_url` = #{small_img_url,jdbcType=VARCHAR},",
          "`miles_last_maintenance` = #{miles_last_maintenance,jdbcType=VARCHAR},",
          "`capital_account_id` = #{capital_account_id,jdbcType=BIGINT},",
          "`capital_account_str` = #{capital_account_str,jdbcType=VARCHAR},",
          "`evaluate_tags` = #{evaluate_tags,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Shop record);
}
package com.segama.ege.repository;

import com.segama.ege.entity.CarType;
import com.segama.ege.entity.CarTypeExample;
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

public interface CarTypeMapper {
    @SelectProvider(type=CarTypeSqlProvider.class, method="countByExample")
    int countByExample(CarTypeExample example);

    @DeleteProvider(type=CarTypeSqlProvider.class, method="deleteByExample")
    int deleteByExample(CarTypeExample example);

    @Delete({
        "delete from `car_type`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `car_type` (`brand`, `brand_code`, ",
        "`car_type`, `car_type_code`, ",
        "`car_style`, `car_style_code`, ",
        "`brand_first_letter`, `category_code`, ",
        "`category_name`, `category_level`, ",
        "`parent_category_code`, `logo_url`, ",
        "`gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`)",
        "values (#{brand,jdbcType=VARCHAR}, #{brand_code,jdbcType=VARCHAR}, ",
        "#{car_type,jdbcType=VARCHAR}, #{car_type_code,jdbcType=VARCHAR}, ",
        "#{car_style,jdbcType=VARCHAR}, #{car_style_code,jdbcType=VARCHAR}, ",
        "#{brand_first_letter,jdbcType=VARCHAR}, #{category_code,jdbcType=VARCHAR}, ",
        "#{category_name,jdbcType=VARCHAR}, #{category_level,jdbcType=BIGINT}, ",
        "#{parent_category_code,jdbcType=VARCHAR}, #{logo_url,jdbcType=VARCHAR}, ",
        "#{gmt_create,jdbcType=TIMESTAMP}, #{gmt_modify,jdbcType=TIMESTAMP}, ",
        "#{creator_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(CarType record);

    @InsertProvider(type=CarTypeSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(CarType record);

    @SelectProvider(type=CarTypeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="brand", property="brand", jdbcType=JdbcType.VARCHAR),
        @Result(column="brand_code", property="brand_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_type", property="car_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_type_code", property="car_type_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_style", property="car_style", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_style_code", property="car_style_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="brand_first_letter", property="brand_first_letter", jdbcType=JdbcType.VARCHAR),
        @Result(column="category_code", property="category_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="category_name", property="category_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="category_level", property="category_level", jdbcType=JdbcType.BIGINT),
        @Result(column="parent_category_code", property="parent_category_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="logo_url", property="logo_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR)
    })
    List<CarType> selectByExample(CarTypeExample example);

    @Select({
        "select",
        "`id`, `brand`, `brand_code`, `car_type`, `car_type_code`, `car_style`, `car_style_code`, ",
        "`brand_first_letter`, `category_code`, `category_name`, `category_level`, `parent_category_code`, ",
        "`logo_url`, `gmt_create`, `gmt_modify`, `creator_account`, `modifier_account`",
        "from `car_type`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="brand", property="brand", jdbcType=JdbcType.VARCHAR),
        @Result(column="brand_code", property="brand_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_type", property="car_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_type_code", property="car_type_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_style", property="car_style", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_style_code", property="car_style_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="brand_first_letter", property="brand_first_letter", jdbcType=JdbcType.VARCHAR),
        @Result(column="category_code", property="category_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="category_name", property="category_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="category_level", property="category_level", jdbcType=JdbcType.BIGINT),
        @Result(column="parent_category_code", property="parent_category_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="logo_url", property="logo_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR)
    })
    CarType selectByPrimaryKey(Long id);

    @UpdateProvider(type=CarTypeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CarType record, @Param("example") CarTypeExample example);

    @UpdateProvider(type=CarTypeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CarType record, @Param("example") CarTypeExample example);

    @UpdateProvider(type=CarTypeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CarType record);

    @Update({
        "update `car_type`",
        "set `brand` = #{brand,jdbcType=VARCHAR},",
          "`brand_code` = #{brand_code,jdbcType=VARCHAR},",
          "`car_type` = #{car_type,jdbcType=VARCHAR},",
          "`car_type_code` = #{car_type_code,jdbcType=VARCHAR},",
          "`car_style` = #{car_style,jdbcType=VARCHAR},",
          "`car_style_code` = #{car_style_code,jdbcType=VARCHAR},",
          "`brand_first_letter` = #{brand_first_letter,jdbcType=VARCHAR},",
          "`category_code` = #{category_code,jdbcType=VARCHAR},",
          "`category_name` = #{category_name,jdbcType=VARCHAR},",
          "`category_level` = #{category_level,jdbcType=BIGINT},",
          "`parent_category_code` = #{parent_category_code,jdbcType=VARCHAR},",
          "`logo_url` = #{logo_url,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CarType record);
}
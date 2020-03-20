package com.segama.ege.repository;

import com.segama.ege.entity.ProvCityArea;
import com.segama.ege.entity.ProvCityAreaExample;
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

public interface ProvCityAreaMapper {
    @SelectProvider(type=ProvCityAreaSqlProvider.class, method="countByExample")
    int countByExample(ProvCityAreaExample example);

    @DeleteProvider(type=ProvCityAreaSqlProvider.class, method="deleteByExample")
    int deleteByExample(ProvCityAreaExample example);

    @Delete({
        "delete from `prov_city_area`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `prov_city_area` (`code`, `parent_code`, ",
        "`code_name`, `type`, ",
        "`is_disable`, `gmt_create`, ",
        "`gmt_modify`, `creator_account`, ",
        "`modifier_account`)",
        "values (#{code,jdbcType=VARCHAR}, #{parent_code,jdbcType=VARCHAR}, ",
        "#{code_name,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR}, ",
        "#{is_disable,jdbcType=BIT}, #{gmt_create,jdbcType=TIMESTAMP}, ",
        "#{gmt_modify,jdbcType=TIMESTAMP}, #{creator_account,jdbcType=VARCHAR}, ",
        "#{modifier_account,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ProvCityArea record);

    @InsertProvider(type=ProvCityAreaSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ProvCityArea record);

    @SelectProvider(type=ProvCityAreaSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_code", property="parent_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="code_name", property="code_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_disable", property="is_disable", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR)
    })
    List<ProvCityArea> selectByExample(ProvCityAreaExample example);

    @Select({
        "select",
        "`id`, `code`, `parent_code`, `code_name`, `type`, `is_disable`, `gmt_create`, ",
        "`gmt_modify`, `creator_account`, `modifier_account`",
        "from `prov_city_area`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_code", property="parent_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="code_name", property="code_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_disable", property="is_disable", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR)
    })
    ProvCityArea selectByPrimaryKey(Long id);

    @UpdateProvider(type=ProvCityAreaSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ProvCityArea record, @Param("example") ProvCityAreaExample example);

    @UpdateProvider(type=ProvCityAreaSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ProvCityArea record, @Param("example") ProvCityAreaExample example);

    @UpdateProvider(type=ProvCityAreaSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProvCityArea record);

    @Update({
        "update `prov_city_area`",
        "set `code` = #{code,jdbcType=VARCHAR},",
          "`parent_code` = #{parent_code,jdbcType=VARCHAR},",
          "`code_name` = #{code_name,jdbcType=VARCHAR},",
          "`type` = #{type,jdbcType=VARCHAR},",
          "`is_disable` = #{is_disable,jdbcType=BIT},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ProvCityArea record);
}
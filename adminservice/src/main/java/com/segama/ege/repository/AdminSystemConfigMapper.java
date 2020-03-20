package com.segama.ege.repository;

import com.segama.ege.entity.AdminSystemConfig;
import com.segama.ege.entity.AdminSystemConfigExample;
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

public interface AdminSystemConfigMapper {
    @SelectProvider(type=AdminSystemConfigSqlProvider.class, method="countByExample")
    int countByExample(AdminSystemConfigExample example);

    @DeleteProvider(type=AdminSystemConfigSqlProvider.class, method="deleteByExample")
    int deleteByExample(AdminSystemConfigExample example);

    @Delete({
        "delete from `admin_system_config`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `admin_system_config` (`key`, `value`, ",
        "`gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`, ",
        "`description`, `version`)",
        "values (#{key,jdbcType=VARCHAR}, #{value,jdbcType=VARCHAR}, ",
        "#{gmt_create,jdbcType=TIMESTAMP}, #{gmt_modify,jdbcType=TIMESTAMP}, ",
        "#{creator_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{version,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(AdminSystemConfig record);

    @InsertProvider(type=AdminSystemConfigSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(AdminSystemConfig record);

    @SelectProvider(type=AdminSystemConfigSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="key", property="key", jdbcType=JdbcType.VARCHAR),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER)
    })
    List<AdminSystemConfig> selectByExample(AdminSystemConfigExample example);

    @Select({
        "select",
        "`id`, `key`, `value`, `gmt_create`, `gmt_modify`, `creator_account`, `modifier_account`, ",
        "`description`, `version`",
        "from `admin_system_config`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="key", property="key", jdbcType=JdbcType.VARCHAR),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER)
    })
    AdminSystemConfig selectByPrimaryKey(Long id);

    @UpdateProvider(type=AdminSystemConfigSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AdminSystemConfig record, @Param("example") AdminSystemConfigExample example);

    @UpdateProvider(type=AdminSystemConfigSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AdminSystemConfig record, @Param("example") AdminSystemConfigExample example);

    @UpdateProvider(type=AdminSystemConfigSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AdminSystemConfig record);

    @Update({
        "update `admin_system_config`",
        "set `key` = #{key,jdbcType=VARCHAR},",
          "`value` = #{value,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`description` = #{description,jdbcType=VARCHAR},",
          "`version` = #{version,jdbcType=INTEGER}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AdminSystemConfig record);
}
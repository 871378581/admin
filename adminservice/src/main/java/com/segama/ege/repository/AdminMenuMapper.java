package com.segama.ege.repository;

import com.segama.ege.entity.AdminMenu;
import com.segama.ege.entity.AdminMenuExample;
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

public interface AdminMenuMapper {
    @SelectProvider(type=AdminMenuSqlProvider.class, method="countByExample")
    int countByExample(AdminMenuExample example);

    @DeleteProvider(type=AdminMenuSqlProvider.class, method="deleteByExample")
    int deleteByExample(AdminMenuExample example);

    @Delete({
        "delete from `admin_menu`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `admin_menu` (`menu_name`, `gmt_create`, ",
        "`gmt_modify`, `creator_account`, ",
        "`modifier_account`, `url`, ",
        "`group`, `version`)",
        "values (#{menu_name,jdbcType=VARCHAR}, #{gmt_create,jdbcType=TIMESTAMP}, ",
        "#{gmt_modify,jdbcType=TIMESTAMP}, #{creator_account,jdbcType=VARCHAR}, ",
        "#{modifier_account,jdbcType=VARCHAR}, #{url,jdbcType=VARCHAR}, ",
        "#{group,jdbcType=VARCHAR}, #{version,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(AdminMenu record);

    @InsertProvider(type=AdminMenuSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(AdminMenu record);

    @SelectProvider(type=AdminMenuSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="menu_name", property="menu_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="group", property="group", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER)
    })
    List<AdminMenu> selectByExample(AdminMenuExample example);

    @Select({
        "select",
        "`id`, `menu_name`, `gmt_create`, `gmt_modify`, `creator_account`, `modifier_account`, ",
        "`url`, `group`, `version`",
        "from `admin_menu`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="menu_name", property="menu_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="group", property="group", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER)
    })
    AdminMenu selectByPrimaryKey(Long id);

    @UpdateProvider(type=AdminMenuSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AdminMenu record, @Param("example") AdminMenuExample example);

    @UpdateProvider(type=AdminMenuSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AdminMenu record, @Param("example") AdminMenuExample example);

    @UpdateProvider(type=AdminMenuSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AdminMenu record);

    @Update({
        "update `admin_menu`",
        "set `menu_name` = #{menu_name,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`url` = #{url,jdbcType=VARCHAR},",
          "`group` = #{group,jdbcType=VARCHAR},",
          "`version` = #{version,jdbcType=INTEGER}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AdminMenu record);
}
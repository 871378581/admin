package com.segama.ege.repository;

import com.segama.ege.entity.AdminMenuGroup;
import com.segama.ege.entity.AdminMenuGroupExample;
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

public interface AdminMenuGroupMapper {
    @SelectProvider(type=AdminMenuGroupSqlProvider.class, method="countByExample")
    int countByExample(AdminMenuGroupExample example);

    @DeleteProvider(type=AdminMenuGroupSqlProvider.class, method="deleteByExample")
    int deleteByExample(AdminMenuGroupExample example);

    @Delete({
        "delete from `admin_menu_group`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `admin_menu_group` (`gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`, ",
        "`group`, `sort`, `icon`)",
        "values (#{gmt_create,jdbcType=TIMESTAMP}, #{gmt_modify,jdbcType=TIMESTAMP}, ",
        "#{creator_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR}, ",
        "#{group,jdbcType=VARCHAR}, #{sort,jdbcType=BIGINT}, #{icon,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(AdminMenuGroup record);

    @InsertProvider(type=AdminMenuGroupSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(AdminMenuGroup record);

    @SelectProvider(type=AdminMenuGroupSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="group", property="group", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.BIGINT),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR)
    })
    List<AdminMenuGroup> selectByExample(AdminMenuGroupExample example);

    @Select({
        "select",
        "`id`, `gmt_create`, `gmt_modify`, `creator_account`, `modifier_account`, `group`, ",
        "`sort`, `icon`",
        "from `admin_menu_group`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="group", property="group", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.BIGINT),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR)
    })
    AdminMenuGroup selectByPrimaryKey(Long id);

    @UpdateProvider(type=AdminMenuGroupSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AdminMenuGroup record, @Param("example") AdminMenuGroupExample example);

    @UpdateProvider(type=AdminMenuGroupSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AdminMenuGroup record, @Param("example") AdminMenuGroupExample example);

    @UpdateProvider(type=AdminMenuGroupSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AdminMenuGroup record);

    @Update({
        "update `admin_menu_group`",
        "set `gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`group` = #{group,jdbcType=VARCHAR},",
          "`sort` = #{sort,jdbcType=BIGINT},",
          "`icon` = #{icon,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AdminMenuGroup record);
}
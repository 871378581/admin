package com.segama.ege.repository;

import com.segama.ege.entity.AdminRoleMenuRelation;
import com.segama.ege.entity.AdminRoleMenuRelationExample;
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

public interface AdminRoleMenuRelationMapper {
    @SelectProvider(type=AdminRoleMenuRelationSqlProvider.class, method="countByExample")
    int countByExample(AdminRoleMenuRelationExample example);

    @DeleteProvider(type=AdminRoleMenuRelationSqlProvider.class, method="deleteByExample")
    int deleteByExample(AdminRoleMenuRelationExample example);

    @Delete({
        "delete from `admin_role_menu_relation`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `admin_role_menu_relation` (`menu_id`, `role_id`, ",
        "`menu_name`, `role_name`, ",
        "`gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`, ",
        "`description`, `version`)",
        "values (#{menu_id,jdbcType=BIGINT}, #{role_id,jdbcType=BIGINT}, ",
        "#{menu_name,jdbcType=VARCHAR}, #{role_name,jdbcType=VARCHAR}, ",
        "#{gmt_create,jdbcType=TIMESTAMP}, #{gmt_modify,jdbcType=TIMESTAMP}, ",
        "#{creator_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{version,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(AdminRoleMenuRelation record);

    @InsertProvider(type=AdminRoleMenuRelationSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(AdminRoleMenuRelation record);

    @SelectProvider(type=AdminRoleMenuRelationSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="menu_id", property="menu_id", jdbcType=JdbcType.BIGINT),
        @Result(column="role_id", property="role_id", jdbcType=JdbcType.BIGINT),
        @Result(column="menu_name", property="menu_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_name", property="role_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER)
    })
    List<AdminRoleMenuRelation> selectByExample(AdminRoleMenuRelationExample example);

    @Select({
        "select",
        "`id`, `menu_id`, `role_id`, `menu_name`, `role_name`, `gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`, `description`, `version`",
        "from `admin_role_menu_relation`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="menu_id", property="menu_id", jdbcType=JdbcType.BIGINT),
        @Result(column="role_id", property="role_id", jdbcType=JdbcType.BIGINT),
        @Result(column="menu_name", property="menu_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_name", property="role_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER)
    })
    AdminRoleMenuRelation selectByPrimaryKey(Long id);

    @UpdateProvider(type=AdminRoleMenuRelationSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AdminRoleMenuRelation record, @Param("example") AdminRoleMenuRelationExample example);

    @UpdateProvider(type=AdminRoleMenuRelationSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AdminRoleMenuRelation record, @Param("example") AdminRoleMenuRelationExample example);

    @UpdateProvider(type=AdminRoleMenuRelationSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AdminRoleMenuRelation record);

    @Update({
        "update `admin_role_menu_relation`",
        "set `menu_id` = #{menu_id,jdbcType=BIGINT},",
          "`role_id` = #{role_id,jdbcType=BIGINT},",
          "`menu_name` = #{menu_name,jdbcType=VARCHAR},",
          "`role_name` = #{role_name,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`description` = #{description,jdbcType=VARCHAR},",
          "`version` = #{version,jdbcType=INTEGER}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AdminRoleMenuRelation record);
}
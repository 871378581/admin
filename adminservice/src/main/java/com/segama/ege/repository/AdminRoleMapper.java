package com.segama.ege.repository;

import com.segama.ege.entity.AdminRole;
import com.segama.ege.entity.AdminRoleExample;
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

public interface AdminRoleMapper {
    @SelectProvider(type=AdminRoleSqlProvider.class, method="countByExample")
    int countByExample(AdminRoleExample example);

    @DeleteProvider(type=AdminRoleSqlProvider.class, method="deleteByExample")
    int deleteByExample(AdminRoleExample example);

    @Delete({
        "delete from `admin_role`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `admin_role` (`role_name`, `gmt_create`, ",
        "`gmt_modify`, `creator_account`, ",
        "`modifier_account`, `description`, ",
        "`version`)",
        "values (#{role_name,jdbcType=VARCHAR}, #{gmt_create,jdbcType=TIMESTAMP}, ",
        "#{gmt_modify,jdbcType=TIMESTAMP}, #{creator_account,jdbcType=VARCHAR}, ",
        "#{modifier_account,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{version,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(AdminRole record);

    @InsertProvider(type=AdminRoleSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(AdminRole record);

    @SelectProvider(type=AdminRoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="role_name", property="role_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER)
    })
    List<AdminRole> selectByExample(AdminRoleExample example);

    @Select({
        "select",
        "`id`, `role_name`, `gmt_create`, `gmt_modify`, `creator_account`, `modifier_account`, ",
        "`description`, `version`",
        "from `admin_role`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="role_name", property="role_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER)
    })
    AdminRole selectByPrimaryKey(Long id);

    @UpdateProvider(type=AdminRoleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AdminRole record, @Param("example") AdminRoleExample example);

    @UpdateProvider(type=AdminRoleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AdminRole record, @Param("example") AdminRoleExample example);

    @UpdateProvider(type=AdminRoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AdminRole record);

    @Update({
        "update `admin_role`",
        "set `role_name` = #{role_name,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`description` = #{description,jdbcType=VARCHAR},",
          "`version` = #{version,jdbcType=INTEGER}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AdminRole record);
}
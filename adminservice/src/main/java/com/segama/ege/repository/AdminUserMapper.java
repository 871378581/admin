package com.segama.ege.repository;

import com.segama.ege.entity.AdminUser;
import com.segama.ege.entity.AdminUserExample;
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

public interface AdminUserMapper {
    @SelectProvider(type=AdminUserSqlProvider.class, method="countByExample")
    int countByExample(AdminUserExample example);

    @DeleteProvider(type=AdminUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(AdminUserExample example);

    @Delete({
        "delete from `admin_user`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `admin_user` (`gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`, ",
        "`account`, `password`, ",
        "`version`, `token`, ",
        "`expire_time`)",
        "values (#{gmt_create,jdbcType=TIMESTAMP}, #{gmt_modify,jdbcType=TIMESTAMP}, ",
        "#{creator_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR}, ",
        "#{account,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{version,jdbcType=INTEGER}, #{token,jdbcType=VARCHAR}, ",
        "#{expire_time,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(AdminUser record);

    @InsertProvider(type=AdminUserSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(AdminUser record);

    @SelectProvider(type=AdminUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="token", property="token", jdbcType=JdbcType.VARCHAR),
        @Result(column="expire_time", property="expire_time", jdbcType=JdbcType.TIMESTAMP)
    })
    List<AdminUser> selectByExample(AdminUserExample example);

    @Select({
        "select",
        "`id`, `gmt_create`, `gmt_modify`, `creator_account`, `modifier_account`, `account`, ",
        "`password`, `version`, `token`, `expire_time`",
        "from `admin_user`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="token", property="token", jdbcType=JdbcType.VARCHAR),
        @Result(column="expire_time", property="expire_time", jdbcType=JdbcType.TIMESTAMP)
    })
    AdminUser selectByPrimaryKey(Long id);

    @UpdateProvider(type=AdminUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") AdminUser record, @Param("example") AdminUserExample example);

    @UpdateProvider(type=AdminUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") AdminUser record, @Param("example") AdminUserExample example);

    @UpdateProvider(type=AdminUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(AdminUser record);

    @Update({
        "update `admin_user`",
        "set `gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`account` = #{account,jdbcType=VARCHAR},",
          "`password` = #{password,jdbcType=VARCHAR},",
          "`version` = #{version,jdbcType=INTEGER},",
          "`token` = #{token,jdbcType=VARCHAR},",
          "`expire_time` = #{expire_time,jdbcType=TIMESTAMP}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AdminUser record);
}
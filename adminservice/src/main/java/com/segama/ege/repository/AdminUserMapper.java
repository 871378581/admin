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
        "`expire_time`, `channel_code`, ",
        "`channel_name`, `main_body`, ",
        "`contacter`, `contacter_phone`, ",
        "`status`, `channel_type`, ",
        "`jieru_way`, `meiti_type`, ",
        "`meiti_pwd`, `meiti_account`, ",
        "`account_id`, `bank_card`, ",
        "`open_bank_area`, `real_name`, ",
        "`description`, `parent_account`)",
        "values (#{gmt_create,jdbcType=TIMESTAMP}, #{gmt_modify,jdbcType=TIMESTAMP}, ",
        "#{creator_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR}, ",
        "#{account,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{version,jdbcType=INTEGER}, #{token,jdbcType=VARCHAR}, ",
        "#{expire_time,jdbcType=TIMESTAMP}, #{channel_code,jdbcType=VARCHAR}, ",
        "#{channel_name,jdbcType=VARCHAR}, #{main_body,jdbcType=VARCHAR}, ",
        "#{contacter,jdbcType=VARCHAR}, #{contacter_phone,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER}, #{channel_type,jdbcType=INTEGER}, ",
        "#{jieru_way,jdbcType=VARCHAR}, #{meiti_type,jdbcType=VARCHAR}, ",
        "#{meiti_pwd,jdbcType=VARCHAR}, #{meiti_account,jdbcType=VARCHAR}, ",
        "#{account_id,jdbcType=VARCHAR}, #{bank_card,jdbcType=VARCHAR}, ",
        "#{open_bank_area,jdbcType=VARCHAR}, #{real_name,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{parent_account,jdbcType=VARCHAR})"
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
        @Result(column="expire_time", property="expire_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="channel_code", property="channel_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_name", property="channel_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="main_body", property="main_body", jdbcType=JdbcType.VARCHAR),
        @Result(column="contacter", property="contacter", jdbcType=JdbcType.VARCHAR),
        @Result(column="contacter_phone", property="contacter_phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="channel_type", property="channel_type", jdbcType=JdbcType.INTEGER),
        @Result(column="jieru_way", property="jieru_way", jdbcType=JdbcType.VARCHAR),
        @Result(column="meiti_type", property="meiti_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="meiti_pwd", property="meiti_pwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="meiti_account", property="meiti_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_id", property="account_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_card", property="bank_card", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_bank_area", property="open_bank_area", jdbcType=JdbcType.VARCHAR),
        @Result(column="real_name", property="real_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_account", property="parent_account", jdbcType=JdbcType.VARCHAR)
    })
    List<AdminUser> selectByExample(AdminUserExample example);

    @Select({
        "select",
        "`id`, `gmt_create`, `gmt_modify`, `creator_account`, `modifier_account`, `account`, ",
        "`password`, `version`, `token`, `expire_time`, `channel_code`, `channel_name`, ",
        "`main_body`, `contacter`, `contacter_phone`, `status`, `channel_type`, `jieru_way`, ",
        "`meiti_type`, `meiti_pwd`, `meiti_account`, `account_id`, `bank_card`, `open_bank_area`, ",
        "`real_name`, `description`, `parent_account`",
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
        @Result(column="expire_time", property="expire_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="channel_code", property="channel_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_name", property="channel_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="main_body", property="main_body", jdbcType=JdbcType.VARCHAR),
        @Result(column="contacter", property="contacter", jdbcType=JdbcType.VARCHAR),
        @Result(column="contacter_phone", property="contacter_phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="channel_type", property="channel_type", jdbcType=JdbcType.INTEGER),
        @Result(column="jieru_way", property="jieru_way", jdbcType=JdbcType.VARCHAR),
        @Result(column="meiti_type", property="meiti_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="meiti_pwd", property="meiti_pwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="meiti_account", property="meiti_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_id", property="account_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_card", property="bank_card", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_bank_area", property="open_bank_area", jdbcType=JdbcType.VARCHAR),
        @Result(column="real_name", property="real_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_account", property="parent_account", jdbcType=JdbcType.VARCHAR)
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
          "`expire_time` = #{expire_time,jdbcType=TIMESTAMP},",
          "`channel_code` = #{channel_code,jdbcType=VARCHAR},",
          "`channel_name` = #{channel_name,jdbcType=VARCHAR},",
          "`main_body` = #{main_body,jdbcType=VARCHAR},",
          "`contacter` = #{contacter,jdbcType=VARCHAR},",
          "`contacter_phone` = #{contacter_phone,jdbcType=VARCHAR},",
          "`status` = #{status,jdbcType=INTEGER},",
          "`channel_type` = #{channel_type,jdbcType=INTEGER},",
          "`jieru_way` = #{jieru_way,jdbcType=VARCHAR},",
          "`meiti_type` = #{meiti_type,jdbcType=VARCHAR},",
          "`meiti_pwd` = #{meiti_pwd,jdbcType=VARCHAR},",
          "`meiti_account` = #{meiti_account,jdbcType=VARCHAR},",
          "`account_id` = #{account_id,jdbcType=VARCHAR},",
          "`bank_card` = #{bank_card,jdbcType=VARCHAR},",
          "`open_bank_area` = #{open_bank_area,jdbcType=VARCHAR},",
          "`real_name` = #{real_name,jdbcType=VARCHAR},",
          "`description` = #{description,jdbcType=VARCHAR},",
          "`parent_account` = #{parent_account,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(AdminUser record);
}
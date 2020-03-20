package com.segama.ege.repository;

import com.segama.ege.entity.WxUserLoginLog;
import com.segama.ege.entity.WxUserLoginLogExample;
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

public interface WxUserLoginLogMapper {
    @SelectProvider(type=WxUserLoginLogSqlProvider.class, method="countByExample")
    int countByExample(WxUserLoginLogExample example);

    @DeleteProvider(type=WxUserLoginLogSqlProvider.class, method="deleteByExample")
    int deleteByExample(WxUserLoginLogExample example);

    @Delete({
        "delete from `wx_user_login_log`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `wx_user_login_log` (`user_id`, `gmt_login`, ",
        "`login_longitude`, `login_latitude`, ",
        "`gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`)",
        "values (#{user_id,jdbcType=VARCHAR}, #{gmt_login,jdbcType=TIMESTAMP}, ",
        "#{login_longitude,jdbcType=DECIMAL}, #{login_latitude,jdbcType=DECIMAL}, ",
        "#{gmt_create,jdbcType=TIMESTAMP}, #{gmt_modify,jdbcType=TIMESTAMP}, ",
        "#{creator_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(WxUserLoginLog record);

    @InsertProvider(type=WxUserLoginLogSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(WxUserLoginLog record);

    @SelectProvider(type=WxUserLoginLogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_login", property="gmt_login", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="login_longitude", property="login_longitude", jdbcType=JdbcType.DECIMAL),
        @Result(column="login_latitude", property="login_latitude", jdbcType=JdbcType.DECIMAL),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR)
    })
    List<WxUserLoginLog> selectByExample(WxUserLoginLogExample example);

    @Select({
        "select",
        "`id`, `user_id`, `gmt_login`, `login_longitude`, `login_latitude`, `gmt_create`, ",
        "`gmt_modify`, `creator_account`, `modifier_account`",
        "from `wx_user_login_log`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_login", property="gmt_login", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="login_longitude", property="login_longitude", jdbcType=JdbcType.DECIMAL),
        @Result(column="login_latitude", property="login_latitude", jdbcType=JdbcType.DECIMAL),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR)
    })
    WxUserLoginLog selectByPrimaryKey(Long id);

    @UpdateProvider(type=WxUserLoginLogSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") WxUserLoginLog record, @Param("example") WxUserLoginLogExample example);

    @UpdateProvider(type=WxUserLoginLogSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") WxUserLoginLog record, @Param("example") WxUserLoginLogExample example);

    @UpdateProvider(type=WxUserLoginLogSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(WxUserLoginLog record);

    @Update({
        "update `wx_user_login_log`",
        "set `user_id` = #{user_id,jdbcType=VARCHAR},",
          "`gmt_login` = #{gmt_login,jdbcType=TIMESTAMP},",
          "`login_longitude` = #{login_longitude,jdbcType=DECIMAL},",
          "`login_latitude` = #{login_latitude,jdbcType=DECIMAL},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(WxUserLoginLog record);
}
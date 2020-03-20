package com.segama.ege.repository;

import com.segama.ege.entity.WxUser;
import com.segama.ege.entity.WxUserExample;
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

public interface WxUserMapper {
    @SelectProvider(type=WxUserSqlProvider.class, method="countByExample")
    int countByExample(WxUserExample example);

    @DeleteProvider(type=WxUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(WxUserExample example);

    @Delete({
        "delete from `wx_user`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `wx_user` (`user_id`, `nick_name`, ",
        "`user_head`, `token_id`, ",
        "`user_name`, `birth`, ",
        "`sex`, `id_card`, `has_bind_phone`, ",
        "`phone`, `gmt_register`, ",
        "`place_city`, `last_longitude`, ",
        "`last_latitude`, `gmt_create`, ",
        "`gmt_modify`, `creator_account`, ",
        "`modifier_account`, `version`, ",
        "`membership_level`, `job`, ",
        "`code_expired_at`, `code`, ",
        "`default_plate`, `default_car_tye`, ",
        "`has_default_car`, `card_level`, ",
        "`capital_account_id`, `account`, ",
        "`capital_account_str`, `user_type`)",
        "values (#{user_id,jdbcType=VARCHAR}, #{nick_name,jdbcType=VARCHAR}, ",
        "#{user_head,jdbcType=VARCHAR}, #{token_id,jdbcType=VARCHAR}, ",
        "#{user_name,jdbcType=VARCHAR}, #{birth,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=VARCHAR}, #{id_card,jdbcType=VARCHAR}, #{has_bind_phone,jdbcType=BIT}, ",
        "#{phone,jdbcType=VARCHAR}, #{gmt_register,jdbcType=TIMESTAMP}, ",
        "#{place_city,jdbcType=VARCHAR}, #{last_longitude,jdbcType=DECIMAL}, ",
        "#{last_latitude,jdbcType=DECIMAL}, #{gmt_create,jdbcType=TIMESTAMP}, ",
        "#{gmt_modify,jdbcType=TIMESTAMP}, #{creator_account,jdbcType=VARCHAR}, ",
        "#{modifier_account,jdbcType=VARCHAR}, #{version,jdbcType=INTEGER}, ",
        "#{membership_level,jdbcType=VARCHAR}, #{job,jdbcType=VARCHAR}, ",
        "#{code_expired_at,jdbcType=TIMESTAMP}, #{code,jdbcType=VARCHAR}, ",
        "#{default_plate,jdbcType=VARCHAR}, #{default_car_tye,jdbcType=VARCHAR}, ",
        "#{has_default_car,jdbcType=BIT}, #{card_level,jdbcType=VARCHAR}, ",
        "#{capital_account_id,jdbcType=BIGINT}, #{account,jdbcType=VARCHAR}, ",
        "#{capital_account_str,jdbcType=VARCHAR}, #{user_type,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(WxUser record);

    @InsertProvider(type=WxUserSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(WxUser record);

    @SelectProvider(type=WxUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="nick_name", property="nick_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_head", property="user_head", jdbcType=JdbcType.VARCHAR),
        @Result(column="token_id", property="token_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="user_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="birth", property="birth", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_card", property="id_card", jdbcType=JdbcType.VARCHAR),
        @Result(column="has_bind_phone", property="has_bind_phone", jdbcType=JdbcType.BIT),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_register", property="gmt_register", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="place_city", property="place_city", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_longitude", property="last_longitude", jdbcType=JdbcType.DECIMAL),
        @Result(column="last_latitude", property="last_latitude", jdbcType=JdbcType.DECIMAL),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="membership_level", property="membership_level", jdbcType=JdbcType.VARCHAR),
        @Result(column="job", property="job", jdbcType=JdbcType.VARCHAR),
        @Result(column="code_expired_at", property="code_expired_at", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="default_plate", property="default_plate", jdbcType=JdbcType.VARCHAR),
        @Result(column="default_car_tye", property="default_car_tye", jdbcType=JdbcType.VARCHAR),
        @Result(column="has_default_car", property="has_default_car", jdbcType=JdbcType.BIT),
        @Result(column="card_level", property="card_level", jdbcType=JdbcType.VARCHAR),
        @Result(column="capital_account_id", property="capital_account_id", jdbcType=JdbcType.BIGINT),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="capital_account_str", property="capital_account_str", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_type", property="user_type", jdbcType=JdbcType.INTEGER)
    })
    List<WxUser> selectByExample(WxUserExample example);

    @Select({
        "select",
        "`id`, `user_id`, `nick_name`, `user_head`, `token_id`, `user_name`, `birth`, ",
        "`sex`, `id_card`, `has_bind_phone`, `phone`, `gmt_register`, `place_city`, `last_longitude`, ",
        "`last_latitude`, `gmt_create`, `gmt_modify`, `creator_account`, `modifier_account`, ",
        "`version`, `membership_level`, `job`, `code_expired_at`, `code`, `default_plate`, ",
        "`default_car_tye`, `has_default_car`, `card_level`, `capital_account_id`, `account`, ",
        "`capital_account_str`, `user_type`",
        "from `wx_user`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="nick_name", property="nick_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_head", property="user_head", jdbcType=JdbcType.VARCHAR),
        @Result(column="token_id", property="token_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="user_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="birth", property="birth", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_card", property="id_card", jdbcType=JdbcType.VARCHAR),
        @Result(column="has_bind_phone", property="has_bind_phone", jdbcType=JdbcType.BIT),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_register", property="gmt_register", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="place_city", property="place_city", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_longitude", property="last_longitude", jdbcType=JdbcType.DECIMAL),
        @Result(column="last_latitude", property="last_latitude", jdbcType=JdbcType.DECIMAL),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="membership_level", property="membership_level", jdbcType=JdbcType.VARCHAR),
        @Result(column="job", property="job", jdbcType=JdbcType.VARCHAR),
        @Result(column="code_expired_at", property="code_expired_at", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="default_plate", property="default_plate", jdbcType=JdbcType.VARCHAR),
        @Result(column="default_car_tye", property="default_car_tye", jdbcType=JdbcType.VARCHAR),
        @Result(column="has_default_car", property="has_default_car", jdbcType=JdbcType.BIT),
        @Result(column="card_level", property="card_level", jdbcType=JdbcType.VARCHAR),
        @Result(column="capital_account_id", property="capital_account_id", jdbcType=JdbcType.BIGINT),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="capital_account_str", property="capital_account_str", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_type", property="user_type", jdbcType=JdbcType.INTEGER)
    })
    WxUser selectByPrimaryKey(Long id);

    @UpdateProvider(type=WxUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") WxUser record, @Param("example") WxUserExample example);

    @UpdateProvider(type=WxUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") WxUser record, @Param("example") WxUserExample example);

    @UpdateProvider(type=WxUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(WxUser record);

    @Update({
        "update `wx_user`",
        "set `user_id` = #{user_id,jdbcType=VARCHAR},",
          "`nick_name` = #{nick_name,jdbcType=VARCHAR},",
          "`user_head` = #{user_head,jdbcType=VARCHAR},",
          "`token_id` = #{token_id,jdbcType=VARCHAR},",
          "`user_name` = #{user_name,jdbcType=VARCHAR},",
          "`birth` = #{birth,jdbcType=VARCHAR},",
          "`sex` = #{sex,jdbcType=VARCHAR},",
          "`id_card` = #{id_card,jdbcType=VARCHAR},",
          "`has_bind_phone` = #{has_bind_phone,jdbcType=BIT},",
          "`phone` = #{phone,jdbcType=VARCHAR},",
          "`gmt_register` = #{gmt_register,jdbcType=TIMESTAMP},",
          "`place_city` = #{place_city,jdbcType=VARCHAR},",
          "`last_longitude` = #{last_longitude,jdbcType=DECIMAL},",
          "`last_latitude` = #{last_latitude,jdbcType=DECIMAL},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`version` = #{version,jdbcType=INTEGER},",
          "`membership_level` = #{membership_level,jdbcType=VARCHAR},",
          "`job` = #{job,jdbcType=VARCHAR},",
          "`code_expired_at` = #{code_expired_at,jdbcType=TIMESTAMP},",
          "`code` = #{code,jdbcType=VARCHAR},",
          "`default_plate` = #{default_plate,jdbcType=VARCHAR},",
          "`default_car_tye` = #{default_car_tye,jdbcType=VARCHAR},",
          "`has_default_car` = #{has_default_car,jdbcType=BIT},",
          "`card_level` = #{card_level,jdbcType=VARCHAR},",
          "`capital_account_id` = #{capital_account_id,jdbcType=BIGINT},",
          "`account` = #{account,jdbcType=VARCHAR},",
          "`capital_account_str` = #{capital_account_str,jdbcType=VARCHAR},",
          "`user_type` = #{user_type,jdbcType=INTEGER}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(WxUser record);
}
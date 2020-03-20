package com.segama.ege.repository;

import com.segama.ege.entity.MembershipcardBindCarLog;
import com.segama.ege.entity.MembershipcardBindCarLogExample;
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

public interface MembershipcardBindCarLogMapper {
    @SelectProvider(type=MembershipcardBindCarLogSqlProvider.class, method="countByExample")
    int countByExample(MembershipcardBindCarLogExample example);

    @DeleteProvider(type=MembershipcardBindCarLogSqlProvider.class, method="deleteByExample")
    int deleteByExample(MembershipcardBindCarLogExample example);

    @Delete({
        "delete from `membershipCard_bind_car_log`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `membershipCard_bind_car_log` (`user_id`, `plate`, ",
        "`membership_card_id`, `status`, ",
        "`gmt_bind`, `gmt_activate`, ",
        "`gmt_take_effect`, `gmt_lose_effect`, ",
        "`gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`, ",
        "`version`)",
        "values (#{user_id,jdbcType=VARCHAR}, #{plate,jdbcType=VARCHAR}, ",
        "#{membership_card_id,jdbcType=VARCHAR}, #{status,jdbcType=VARCHAR}, ",
        "#{gmt_bind,jdbcType=TIMESTAMP}, #{gmt_activate,jdbcType=TIMESTAMP}, ",
        "#{gmt_take_effect,jdbcType=TIMESTAMP}, #{gmt_lose_effect,jdbcType=TIMESTAMP}, ",
        "#{gmt_create,jdbcType=TIMESTAMP}, #{gmt_modify,jdbcType=TIMESTAMP}, ",
        "#{creator_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR}, ",
        "#{version,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(MembershipcardBindCarLog record);

    @InsertProvider(type=MembershipcardBindCarLogSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(MembershipcardBindCarLog record);

    @SelectProvider(type=MembershipcardBindCarLogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="plate", property="plate", jdbcType=JdbcType.VARCHAR),
        @Result(column="membership_card_id", property="membership_card_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_bind", property="gmt_bind", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_activate", property="gmt_activate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_take_effect", property="gmt_take_effect", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_lose_effect", property="gmt_lose_effect", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER)
    })
    List<MembershipcardBindCarLog> selectByExample(MembershipcardBindCarLogExample example);

    @Select({
        "select",
        "`id`, `user_id`, `plate`, `membership_card_id`, `status`, `gmt_bind`, `gmt_activate`, ",
        "`gmt_take_effect`, `gmt_lose_effect`, `gmt_create`, `gmt_modify`, `creator_account`, ",
        "`modifier_account`, `version`",
        "from `membershipCard_bind_car_log`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="plate", property="plate", jdbcType=JdbcType.VARCHAR),
        @Result(column="membership_card_id", property="membership_card_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_bind", property="gmt_bind", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_activate", property="gmt_activate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_take_effect", property="gmt_take_effect", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_lose_effect", property="gmt_lose_effect", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER)
    })
    MembershipcardBindCarLog selectByPrimaryKey(Long id);

    @UpdateProvider(type=MembershipcardBindCarLogSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") MembershipcardBindCarLog record, @Param("example") MembershipcardBindCarLogExample example);

    @UpdateProvider(type=MembershipcardBindCarLogSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") MembershipcardBindCarLog record, @Param("example") MembershipcardBindCarLogExample example);

    @UpdateProvider(type=MembershipcardBindCarLogSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MembershipcardBindCarLog record);

    @Update({
        "update `membershipCard_bind_car_log`",
        "set `user_id` = #{user_id,jdbcType=VARCHAR},",
          "`plate` = #{plate,jdbcType=VARCHAR},",
          "`membership_card_id` = #{membership_card_id,jdbcType=VARCHAR},",
          "`status` = #{status,jdbcType=VARCHAR},",
          "`gmt_bind` = #{gmt_bind,jdbcType=TIMESTAMP},",
          "`gmt_activate` = #{gmt_activate,jdbcType=TIMESTAMP},",
          "`gmt_take_effect` = #{gmt_take_effect,jdbcType=TIMESTAMP},",
          "`gmt_lose_effect` = #{gmt_lose_effect,jdbcType=TIMESTAMP},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`version` = #{version,jdbcType=INTEGER}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(MembershipcardBindCarLog record);
}
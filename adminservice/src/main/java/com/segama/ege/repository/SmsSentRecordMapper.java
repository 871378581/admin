package com.segama.ege.repository;

import com.segama.ege.entity.SmsSentRecord;
import com.segama.ege.entity.SmsSentRecordExample;
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

public interface SmsSentRecordMapper {
    @SelectProvider(type=SmsSentRecordSqlProvider.class, method="countByExample")
    int countByExample(SmsSentRecordExample example);

    @DeleteProvider(type=SmsSentRecordSqlProvider.class, method="deleteByExample")
    int deleteByExample(SmsSentRecordExample example);

    @Delete({
        "delete from `sms_sent_record`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `sms_sent_record` (`user_id`, `time_in_min`, ",
        "`content`, `mobile_phone`, ",
        "`gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`, ",
        "`version`)",
        "values (#{user_id,jdbcType=VARCHAR}, #{time_in_min,jdbcType=VARCHAR}, ",
        "#{content,jdbcType=VARCHAR}, #{mobile_phone,jdbcType=VARCHAR}, ",
        "#{gmt_create,jdbcType=TIMESTAMP}, #{gmt_modify,jdbcType=TIMESTAMP}, ",
        "#{creator_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR}, ",
        "#{version,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(SmsSentRecord record);

    @InsertProvider(type=SmsSentRecordSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(SmsSentRecord record);

    @SelectProvider(type=SmsSentRecordSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="time_in_min", property="time_in_min", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile_phone", property="mobile_phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER)
    })
    List<SmsSentRecord> selectByExample(SmsSentRecordExample example);

    @Select({
        "select",
        "`id`, `user_id`, `time_in_min`, `content`, `mobile_phone`, `gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`, `version`",
        "from `sms_sent_record`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="time_in_min", property="time_in_min", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile_phone", property="mobile_phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER)
    })
    SmsSentRecord selectByPrimaryKey(Long id);

    @UpdateProvider(type=SmsSentRecordSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SmsSentRecord record, @Param("example") SmsSentRecordExample example);

    @UpdateProvider(type=SmsSentRecordSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SmsSentRecord record, @Param("example") SmsSentRecordExample example);

    @UpdateProvider(type=SmsSentRecordSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SmsSentRecord record);

    @Update({
        "update `sms_sent_record`",
        "set `user_id` = #{user_id,jdbcType=VARCHAR},",
          "`time_in_min` = #{time_in_min,jdbcType=VARCHAR},",
          "`content` = #{content,jdbcType=VARCHAR},",
          "`mobile_phone` = #{mobile_phone,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`version` = #{version,jdbcType=INTEGER}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SmsSentRecord record);
}
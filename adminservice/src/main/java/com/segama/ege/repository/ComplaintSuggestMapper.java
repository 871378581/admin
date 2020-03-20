package com.segama.ege.repository;

import com.segama.ege.entity.ComplaintSuggest;
import com.segama.ege.entity.ComplaintSuggestExample;
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

public interface ComplaintSuggestMapper {
    @SelectProvider(type=ComplaintSuggestSqlProvider.class, method="countByExample")
    int countByExample(ComplaintSuggestExample example);

    @DeleteProvider(type=ComplaintSuggestSqlProvider.class, method="deleteByExample")
    int deleteByExample(ComplaintSuggestExample example);

    @Delete({
        "delete from `complaint_suggest`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `complaint_suggest` (`user_name`, `suggest_desc`, ",
        "`status`, `respond_message`, ",
        "`process_time`, `gmt_create`, ",
        "`gmt_modify`, `creator_account`, ",
        "`modifier_account`, `user_id`, ",
        "`phone`)",
        "values (#{user_name,jdbcType=VARCHAR}, #{suggest_desc,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=VARCHAR}, #{respond_message,jdbcType=VARCHAR}, ",
        "#{process_time,jdbcType=TIMESTAMP}, #{gmt_create,jdbcType=TIMESTAMP}, ",
        "#{gmt_modify,jdbcType=TIMESTAMP}, #{creator_account,jdbcType=VARCHAR}, ",
        "#{modifier_account,jdbcType=VARCHAR}, #{user_id,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ComplaintSuggest record);

    @InsertProvider(type=ComplaintSuggestSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ComplaintSuggest record);

    @SelectProvider(type=ComplaintSuggestSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_name", property="user_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="suggest_desc", property="suggest_desc", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="respond_message", property="respond_message", jdbcType=JdbcType.VARCHAR),
        @Result(column="process_time", property="process_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR)
    })
    List<ComplaintSuggest> selectByExample(ComplaintSuggestExample example);

    @Select({
        "select",
        "`id`, `user_name`, `suggest_desc`, `status`, `respond_message`, `process_time`, ",
        "`gmt_create`, `gmt_modify`, `creator_account`, `modifier_account`, `user_id`, ",
        "`phone`",
        "from `complaint_suggest`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_name", property="user_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="suggest_desc", property="suggest_desc", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="respond_message", property="respond_message", jdbcType=JdbcType.VARCHAR),
        @Result(column="process_time", property="process_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR)
    })
    ComplaintSuggest selectByPrimaryKey(Long id);

    @UpdateProvider(type=ComplaintSuggestSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ComplaintSuggest record, @Param("example") ComplaintSuggestExample example);

    @UpdateProvider(type=ComplaintSuggestSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ComplaintSuggest record, @Param("example") ComplaintSuggestExample example);

    @UpdateProvider(type=ComplaintSuggestSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ComplaintSuggest record);

    @Update({
        "update `complaint_suggest`",
        "set `user_name` = #{user_name,jdbcType=VARCHAR},",
          "`suggest_desc` = #{suggest_desc,jdbcType=VARCHAR},",
          "`status` = #{status,jdbcType=VARCHAR},",
          "`respond_message` = #{respond_message,jdbcType=VARCHAR},",
          "`process_time` = #{process_time,jdbcType=TIMESTAMP},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`user_id` = #{user_id,jdbcType=VARCHAR},",
          "`phone` = #{phone,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ComplaintSuggest record);
}
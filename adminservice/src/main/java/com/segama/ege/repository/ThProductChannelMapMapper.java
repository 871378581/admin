package com.segama.ege.repository;

import com.segama.ege.entity.ThProductChannelMap;
import com.segama.ege.entity.ThProductChannelMapExample;
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

public interface ThProductChannelMapMapper {
    @SelectProvider(type=ThProductChannelMapSqlProvider.class, method="countByExample")
    int countByExample(ThProductChannelMapExample example);

    @DeleteProvider(type=ThProductChannelMapSqlProvider.class, method="deleteByExample")
    int deleteByExample(ThProductChannelMapExample example);

    @Delete({
        "delete from `th_product_channel_map`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `th_product_channel_map` (`biz_code`, `product_code`, ",
        "`product_name`, `product_onwer_account`, ",
        "`gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`, ",
        "`description`)",
        "values (#{biz_code,jdbcType=VARCHAR}, #{product_code,jdbcType=VARCHAR}, ",
        "#{product_name,jdbcType=VARCHAR}, #{product_onwer_account,jdbcType=VARCHAR}, ",
        "#{gmt_create,jdbcType=TIMESTAMP}, #{gmt_modify,jdbcType=TIMESTAMP}, ",
        "#{creator_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ThProductChannelMap record);

    @InsertProvider(type=ThProductChannelMapSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ThProductChannelMap record);

    @SelectProvider(type=ThProductChannelMapSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="biz_code", property="biz_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_code", property="product_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_name", property="product_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_onwer_account", property="product_onwer_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    List<ThProductChannelMap> selectByExample(ThProductChannelMapExample example);

    @Select({
        "select",
        "`id`, `biz_code`, `product_code`, `product_name`, `product_onwer_account`, `gmt_create`, ",
        "`gmt_modify`, `creator_account`, `modifier_account`, `description`",
        "from `th_product_channel_map`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="biz_code", property="biz_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_code", property="product_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_name", property="product_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_onwer_account", property="product_onwer_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    ThProductChannelMap selectByPrimaryKey(Long id);

    @UpdateProvider(type=ThProductChannelMapSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ThProductChannelMap record, @Param("example") ThProductChannelMapExample example);

    @UpdateProvider(type=ThProductChannelMapSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ThProductChannelMap record, @Param("example") ThProductChannelMapExample example);

    @UpdateProvider(type=ThProductChannelMapSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ThProductChannelMap record);

    @Update({
        "update `th_product_channel_map`",
        "set `biz_code` = #{biz_code,jdbcType=VARCHAR},",
          "`product_code` = #{product_code,jdbcType=VARCHAR},",
          "`product_name` = #{product_name,jdbcType=VARCHAR},",
          "`product_onwer_account` = #{product_onwer_account,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`description` = #{description,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ThProductChannelMap record);
}
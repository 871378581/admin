package com.segama.ege.repository;

import com.segama.ege.entity.ThOrderForJinrongManage;
import com.segama.ege.entity.ThOrderForJinrongManageExample;
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

public interface ThOrderForJinrongManageMapper {
    @SelectProvider(type=ThOrderForJinrongManageSqlProvider.class, method="countByExample")
    int countByExample(ThOrderForJinrongManageExample example);

    @DeleteProvider(type=ThOrderForJinrongManageSqlProvider.class, method="deleteByExample")
    int deleteByExample(ThOrderForJinrongManageExample example);

    @Delete({
        "delete from `th_order_for_jinrong_manage`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `th_order_for_jinrong_manage` (`operate_type`, `order_code`, ",
        "`order_time`, `product_name`, ",
        "`channel_account`, `channel_code`, ",
        "`zhuce`, `xinhu`, `jinjian`, ",
        "`jihuo`, `shouxin`, ",
        "`heka`, `xiakuan`, `xiakuan_amt`, ",
        "`gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`, ",
        "`description`, `picihao`, ",
        "`zhuce_bak`, `xinhu_bak`, ",
        "`jinjian_bak`, `jihuo_bak`, ",
        "`shouxin_bak`, `heka_bak`, ",
        "`xiakuan_bak`, `xiakuan_amt_bak`, ",
        "`show_btn`)",
        "values (#{operate_type,jdbcType=VARCHAR}, #{order_code,jdbcType=VARCHAR}, ",
        "#{order_time,jdbcType=VARCHAR}, #{product_name,jdbcType=VARCHAR}, ",
        "#{channel_account,jdbcType=VARCHAR}, #{channel_code,jdbcType=VARCHAR}, ",
        "#{zhuce,jdbcType=VARCHAR}, #{xinhu,jdbcType=VARCHAR}, #{jinjian,jdbcType=VARCHAR}, ",
        "#{jihuo,jdbcType=VARCHAR}, #{shouxin,jdbcType=VARCHAR}, ",
        "#{heka,jdbcType=VARCHAR}, #{xiakuan,jdbcType=VARCHAR}, #{xiakuan_amt,jdbcType=VARCHAR}, ",
        "#{gmt_create,jdbcType=TIMESTAMP}, #{gmt_modify,jdbcType=TIMESTAMP}, ",
        "#{creator_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{picihao,jdbcType=VARCHAR}, ",
        "#{zhuce_bak,jdbcType=VARCHAR}, #{xinhu_bak,jdbcType=VARCHAR}, ",
        "#{jinjian_bak,jdbcType=VARCHAR}, #{jihuo_bak,jdbcType=VARCHAR}, ",
        "#{shouxin_bak,jdbcType=VARCHAR}, #{heka_bak,jdbcType=VARCHAR}, ",
        "#{xiakuan_bak,jdbcType=VARCHAR}, #{xiakuan_amt_bak,jdbcType=VARCHAR}, ",
        "#{show_btn,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ThOrderForJinrongManage record);

    @InsertProvider(type=ThOrderForJinrongManageSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ThOrderForJinrongManage record);

    @SelectProvider(type=ThOrderForJinrongManageSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="operate_type", property="operate_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_code", property="order_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_time", property="order_time", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_name", property="product_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_account", property="channel_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_code", property="channel_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="zhuce", property="zhuce", jdbcType=JdbcType.VARCHAR),
        @Result(column="xinhu", property="xinhu", jdbcType=JdbcType.VARCHAR),
        @Result(column="jinjian", property="jinjian", jdbcType=JdbcType.VARCHAR),
        @Result(column="jihuo", property="jihuo", jdbcType=JdbcType.VARCHAR),
        @Result(column="shouxin", property="shouxin", jdbcType=JdbcType.VARCHAR),
        @Result(column="heka", property="heka", jdbcType=JdbcType.VARCHAR),
        @Result(column="xiakuan", property="xiakuan", jdbcType=JdbcType.VARCHAR),
        @Result(column="xiakuan_amt", property="xiakuan_amt", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="picihao", property="picihao", jdbcType=JdbcType.VARCHAR),
        @Result(column="zhuce_bak", property="zhuce_bak", jdbcType=JdbcType.VARCHAR),
        @Result(column="xinhu_bak", property="xinhu_bak", jdbcType=JdbcType.VARCHAR),
        @Result(column="jinjian_bak", property="jinjian_bak", jdbcType=JdbcType.VARCHAR),
        @Result(column="jihuo_bak", property="jihuo_bak", jdbcType=JdbcType.VARCHAR),
        @Result(column="shouxin_bak", property="shouxin_bak", jdbcType=JdbcType.VARCHAR),
        @Result(column="heka_bak", property="heka_bak", jdbcType=JdbcType.VARCHAR),
        @Result(column="xiakuan_bak", property="xiakuan_bak", jdbcType=JdbcType.VARCHAR),
        @Result(column="xiakuan_amt_bak", property="xiakuan_amt_bak", jdbcType=JdbcType.VARCHAR),
        @Result(column="show_btn", property="show_btn", jdbcType=JdbcType.INTEGER)
    })
    List<ThOrderForJinrongManage> selectByExample(ThOrderForJinrongManageExample example);

    @Select({
        "select",
        "`id`, `operate_type`, `order_code`, `order_time`, `product_name`, `channel_account`, ",
        "`channel_code`, `zhuce`, `xinhu`, `jinjian`, `jihuo`, `shouxin`, `heka`, `xiakuan`, ",
        "`xiakuan_amt`, `gmt_create`, `gmt_modify`, `creator_account`, `modifier_account`, ",
        "`description`, `picihao`, `zhuce_bak`, `xinhu_bak`, `jinjian_bak`, `jihuo_bak`, ",
        "`shouxin_bak`, `heka_bak`, `xiakuan_bak`, `xiakuan_amt_bak`, `show_btn`",
        "from `th_order_for_jinrong_manage`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="operate_type", property="operate_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_code", property="order_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_time", property="order_time", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_name", property="product_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_account", property="channel_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_code", property="channel_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="zhuce", property="zhuce", jdbcType=JdbcType.VARCHAR),
        @Result(column="xinhu", property="xinhu", jdbcType=JdbcType.VARCHAR),
        @Result(column="jinjian", property="jinjian", jdbcType=JdbcType.VARCHAR),
        @Result(column="jihuo", property="jihuo", jdbcType=JdbcType.VARCHAR),
        @Result(column="shouxin", property="shouxin", jdbcType=JdbcType.VARCHAR),
        @Result(column="heka", property="heka", jdbcType=JdbcType.VARCHAR),
        @Result(column="xiakuan", property="xiakuan", jdbcType=JdbcType.VARCHAR),
        @Result(column="xiakuan_amt", property="xiakuan_amt", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="picihao", property="picihao", jdbcType=JdbcType.VARCHAR),
        @Result(column="zhuce_bak", property="zhuce_bak", jdbcType=JdbcType.VARCHAR),
        @Result(column="xinhu_bak", property="xinhu_bak", jdbcType=JdbcType.VARCHAR),
        @Result(column="jinjian_bak", property="jinjian_bak", jdbcType=JdbcType.VARCHAR),
        @Result(column="jihuo_bak", property="jihuo_bak", jdbcType=JdbcType.VARCHAR),
        @Result(column="shouxin_bak", property="shouxin_bak", jdbcType=JdbcType.VARCHAR),
        @Result(column="heka_bak", property="heka_bak", jdbcType=JdbcType.VARCHAR),
        @Result(column="xiakuan_bak", property="xiakuan_bak", jdbcType=JdbcType.VARCHAR),
        @Result(column="xiakuan_amt_bak", property="xiakuan_amt_bak", jdbcType=JdbcType.VARCHAR),
        @Result(column="show_btn", property="show_btn", jdbcType=JdbcType.INTEGER)
    })
    ThOrderForJinrongManage selectByPrimaryKey(Long id);

    @UpdateProvider(type=ThOrderForJinrongManageSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ThOrderForJinrongManage record, @Param("example") ThOrderForJinrongManageExample example);

    @UpdateProvider(type=ThOrderForJinrongManageSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ThOrderForJinrongManage record, @Param("example") ThOrderForJinrongManageExample example);

    @UpdateProvider(type=ThOrderForJinrongManageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ThOrderForJinrongManage record);

    @Update({
        "update `th_order_for_jinrong_manage`",
        "set `operate_type` = #{operate_type,jdbcType=VARCHAR},",
          "`order_code` = #{order_code,jdbcType=VARCHAR},",
          "`order_time` = #{order_time,jdbcType=VARCHAR},",
          "`product_name` = #{product_name,jdbcType=VARCHAR},",
          "`channel_account` = #{channel_account,jdbcType=VARCHAR},",
          "`channel_code` = #{channel_code,jdbcType=VARCHAR},",
          "`zhuce` = #{zhuce,jdbcType=VARCHAR},",
          "`xinhu` = #{xinhu,jdbcType=VARCHAR},",
          "`jinjian` = #{jinjian,jdbcType=VARCHAR},",
          "`jihuo` = #{jihuo,jdbcType=VARCHAR},",
          "`shouxin` = #{shouxin,jdbcType=VARCHAR},",
          "`heka` = #{heka,jdbcType=VARCHAR},",
          "`xiakuan` = #{xiakuan,jdbcType=VARCHAR},",
          "`xiakuan_amt` = #{xiakuan_amt,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`description` = #{description,jdbcType=VARCHAR},",
          "`picihao` = #{picihao,jdbcType=VARCHAR},",
          "`zhuce_bak` = #{zhuce_bak,jdbcType=VARCHAR},",
          "`xinhu_bak` = #{xinhu_bak,jdbcType=VARCHAR},",
          "`jinjian_bak` = #{jinjian_bak,jdbcType=VARCHAR},",
          "`jihuo_bak` = #{jihuo_bak,jdbcType=VARCHAR},",
          "`shouxin_bak` = #{shouxin_bak,jdbcType=VARCHAR},",
          "`heka_bak` = #{heka_bak,jdbcType=VARCHAR},",
          "`xiakuan_bak` = #{xiakuan_bak,jdbcType=VARCHAR},",
          "`xiakuan_amt_bak` = #{xiakuan_amt_bak,jdbcType=VARCHAR},",
          "`show_btn` = #{show_btn,jdbcType=INTEGER}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ThOrderForJinrongManage record);
}
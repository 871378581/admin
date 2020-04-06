package com.segama.ege.repository;

import com.segama.ege.entity.ThUrlManage;
import com.segama.ege.entity.ThUrlManageExample;
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

public interface ThUrlManageMapper {
    @SelectProvider(type=ThUrlManageSqlProvider.class, method="countByExample")
    int countByExample(ThUrlManageExample example);

    @DeleteProvider(type=ThUrlManageSqlProvider.class, method="deleteByExample")
    int deleteByExample(ThUrlManageExample example);

    @Delete({
        "delete from `th_url_manage`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `th_url_manage` (`business_name`, `url_code`, ",
        "`share_url_code`, `open_ticket_main_body`, ",
        "`product_name`, `product_code`, ",
        "`product_type`, `product_qudao_code`, ",
        "`url`, `url_status`, ",
        "`biz_line`, `channel_code`, ",
        "`youxiao_time`, `gmt_create`, ",
        "`gmt_modify`, `creator_account`, ",
        "`owner_account`, `modifier_account`, ",
        "`description`, `shifou_2_kaifa`, ",
        "`owner_1_account`, `show_a_fenpei`, ",
        "`business_code`)",
        "values (#{business_name,jdbcType=VARCHAR}, #{url_code,jdbcType=VARCHAR}, ",
        "#{share_url_code,jdbcType=VARCHAR}, #{open_ticket_main_body,jdbcType=VARCHAR}, ",
        "#{product_name,jdbcType=VARCHAR}, #{product_code,jdbcType=VARCHAR}, ",
        "#{product_type,jdbcType=VARCHAR}, #{product_qudao_code,jdbcType=VARCHAR}, ",
        "#{url,jdbcType=VARCHAR}, #{url_status,jdbcType=INTEGER}, ",
        "#{biz_line,jdbcType=VARCHAR}, #{channel_code,jdbcType=VARCHAR}, ",
        "#{youxiao_time,jdbcType=VARCHAR}, #{gmt_create,jdbcType=TIMESTAMP}, ",
        "#{gmt_modify,jdbcType=TIMESTAMP}, #{creator_account,jdbcType=VARCHAR}, ",
        "#{owner_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{shifou_2_kaifa,jdbcType=VARCHAR}, ",
        "#{owner_1_account,jdbcType=VARCHAR}, #{show_a_fenpei,jdbcType=VARCHAR}, ",
        "#{business_code,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ThUrlManage record);

    @InsertProvider(type=ThUrlManageSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ThUrlManage record);

    @SelectProvider(type=ThUrlManageSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="business_name", property="business_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="url_code", property="url_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="share_url_code", property="share_url_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_ticket_main_body", property="open_ticket_main_body", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_name", property="product_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_code", property="product_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_type", property="product_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_qudao_code", property="product_qudao_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="url_status", property="url_status", jdbcType=JdbcType.INTEGER),
        @Result(column="biz_line", property="biz_line", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_code", property="channel_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="youxiao_time", property="youxiao_time", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="owner_account", property="owner_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="shifou_2_kaifa", property="shifou_2_kaifa", jdbcType=JdbcType.VARCHAR),
        @Result(column="owner_1_account", property="owner_1_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="show_a_fenpei", property="show_a_fenpei", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_code", property="business_code", jdbcType=JdbcType.VARCHAR)
    })
    List<ThUrlManage> selectByExample(ThUrlManageExample example);

    @Select({
        "select",
        "`id`, `business_name`, `url_code`, `share_url_code`, `open_ticket_main_body`, ",
        "`product_name`, `product_code`, `product_type`, `product_qudao_code`, `url`, ",
        "`url_status`, `biz_line`, `channel_code`, `youxiao_time`, `gmt_create`, `gmt_modify`, ",
        "`creator_account`, `owner_account`, `modifier_account`, `description`, `shifou_2_kaifa`, ",
        "`owner_1_account`, `show_a_fenpei`, `business_code`",
        "from `th_url_manage`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="business_name", property="business_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="url_code", property="url_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="share_url_code", property="share_url_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_ticket_main_body", property="open_ticket_main_body", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_name", property="product_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_code", property="product_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_type", property="product_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_qudao_code", property="product_qudao_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="url_status", property="url_status", jdbcType=JdbcType.INTEGER),
        @Result(column="biz_line", property="biz_line", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_code", property="channel_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="youxiao_time", property="youxiao_time", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="owner_account", property="owner_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="shifou_2_kaifa", property="shifou_2_kaifa", jdbcType=JdbcType.VARCHAR),
        @Result(column="owner_1_account", property="owner_1_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="show_a_fenpei", property="show_a_fenpei", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_code", property="business_code", jdbcType=JdbcType.VARCHAR)
    })
    ThUrlManage selectByPrimaryKey(Long id);

    @UpdateProvider(type=ThUrlManageSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ThUrlManage record, @Param("example") ThUrlManageExample example);

    @UpdateProvider(type=ThUrlManageSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ThUrlManage record, @Param("example") ThUrlManageExample example);

    @UpdateProvider(type=ThUrlManageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ThUrlManage record);

    @Update({
        "update `th_url_manage`",
        "set `business_name` = #{business_name,jdbcType=VARCHAR},",
          "`url_code` = #{url_code,jdbcType=VARCHAR},",
          "`share_url_code` = #{share_url_code,jdbcType=VARCHAR},",
          "`open_ticket_main_body` = #{open_ticket_main_body,jdbcType=VARCHAR},",
          "`product_name` = #{product_name,jdbcType=VARCHAR},",
          "`product_code` = #{product_code,jdbcType=VARCHAR},",
          "`product_type` = #{product_type,jdbcType=VARCHAR},",
          "`product_qudao_code` = #{product_qudao_code,jdbcType=VARCHAR},",
          "`url` = #{url,jdbcType=VARCHAR},",
          "`url_status` = #{url_status,jdbcType=INTEGER},",
          "`biz_line` = #{biz_line,jdbcType=VARCHAR},",
          "`channel_code` = #{channel_code,jdbcType=VARCHAR},",
          "`youxiao_time` = #{youxiao_time,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`owner_account` = #{owner_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`description` = #{description,jdbcType=VARCHAR},",
          "`shifou_2_kaifa` = #{shifou_2_kaifa,jdbcType=VARCHAR},",
          "`owner_1_account` = #{owner_1_account,jdbcType=VARCHAR},",
          "`show_a_fenpei` = #{show_a_fenpei,jdbcType=VARCHAR},",
          "`business_code` = #{business_code,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ThUrlManage record);
}
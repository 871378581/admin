package com.segama.ege.repository;

import com.segama.ege.entity.ThProductManage;
import com.segama.ege.entity.ThProductManageExample;
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

public interface ThProductManageMapper {
    @SelectProvider(type=ThProductManageSqlProvider.class, method="countByExample")
    int countByExample(ThProductManageExample example);

    @DeleteProvider(type=ThProductManageSqlProvider.class, method="deleteByExample")
    int deleteByExample(ThProductManageExample example);

    @Delete({
        "delete from `th_product_manage`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `th_product_manage` (`business_name`, `product_name`, ",
        "`product_code`, `product_type`, ",
        "`url`, `product_status`, ",
        "`gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`, ",
        "`description`, `source_url`, ",
        "`business_code`, `type`, ",
        "`shifou_2_kaifa`, `settle_mode`, ",
        "`settle_column`, `settle_value`, ",
        "`channel_code`, `template_code`)",
        "values (#{business_name,jdbcType=VARCHAR}, #{product_name,jdbcType=VARCHAR}, ",
        "#{product_code,jdbcType=VARCHAR}, #{product_type,jdbcType=VARCHAR}, ",
        "#{url,jdbcType=VARCHAR}, #{product_status,jdbcType=INTEGER}, ",
        "#{gmt_create,jdbcType=TIMESTAMP}, #{gmt_modify,jdbcType=TIMESTAMP}, ",
        "#{creator_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{source_url,jdbcType=VARCHAR}, ",
        "#{business_code,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR}, ",
        "#{shifou_2_kaifa,jdbcType=VARCHAR}, #{settle_mode,jdbcType=VARCHAR}, ",
        "#{settle_column,jdbcType=VARCHAR}, #{settle_value,jdbcType=VARCHAR}, ",
        "#{channel_code,jdbcType=VARCHAR}, #{template_code,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ThProductManage record);

    @InsertProvider(type=ThProductManageSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ThProductManage record);

    @SelectProvider(type=ThProductManageSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="business_name", property="business_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_name", property="product_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_code", property="product_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_type", property="product_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_status", property="product_status", jdbcType=JdbcType.INTEGER),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="source_url", property="source_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_code", property="business_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="shifou_2_kaifa", property="shifou_2_kaifa", jdbcType=JdbcType.VARCHAR),
        @Result(column="settle_mode", property="settle_mode", jdbcType=JdbcType.VARCHAR),
        @Result(column="settle_column", property="settle_column", jdbcType=JdbcType.VARCHAR),
        @Result(column="settle_value", property="settle_value", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_code", property="channel_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="template_code", property="template_code", jdbcType=JdbcType.VARCHAR)
    })
    List<ThProductManage> selectByExample(ThProductManageExample example);

    @Select({
        "select",
        "`id`, `business_name`, `product_name`, `product_code`, `product_type`, `url`, ",
        "`product_status`, `gmt_create`, `gmt_modify`, `creator_account`, `modifier_account`, ",
        "`description`, `source_url`, `business_code`, `type`, `shifou_2_kaifa`, `settle_mode`, ",
        "`settle_column`, `settle_value`, `channel_code`, `template_code`",
        "from `th_product_manage`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="business_name", property="business_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_name", property="product_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_code", property="product_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_type", property="product_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_status", property="product_status", jdbcType=JdbcType.INTEGER),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="source_url", property="source_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_code", property="business_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="shifou_2_kaifa", property="shifou_2_kaifa", jdbcType=JdbcType.VARCHAR),
        @Result(column="settle_mode", property="settle_mode", jdbcType=JdbcType.VARCHAR),
        @Result(column="settle_column", property="settle_column", jdbcType=JdbcType.VARCHAR),
        @Result(column="settle_value", property="settle_value", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_code", property="channel_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="template_code", property="template_code", jdbcType=JdbcType.VARCHAR)
    })
    ThProductManage selectByPrimaryKey(Long id);

    @UpdateProvider(type=ThProductManageSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ThProductManage record, @Param("example") ThProductManageExample example);

    @UpdateProvider(type=ThProductManageSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ThProductManage record, @Param("example") ThProductManageExample example);

    @UpdateProvider(type=ThProductManageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ThProductManage record);

    @Update({
        "update `th_product_manage`",
        "set `business_name` = #{business_name,jdbcType=VARCHAR},",
          "`product_name` = #{product_name,jdbcType=VARCHAR},",
          "`product_code` = #{product_code,jdbcType=VARCHAR},",
          "`product_type` = #{product_type,jdbcType=VARCHAR},",
          "`url` = #{url,jdbcType=VARCHAR},",
          "`product_status` = #{product_status,jdbcType=INTEGER},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`description` = #{description,jdbcType=VARCHAR},",
          "`source_url` = #{source_url,jdbcType=VARCHAR},",
          "`business_code` = #{business_code,jdbcType=VARCHAR},",
          "`type` = #{type,jdbcType=VARCHAR},",
          "`shifou_2_kaifa` = #{shifou_2_kaifa,jdbcType=VARCHAR},",
          "`settle_mode` = #{settle_mode,jdbcType=VARCHAR},",
          "`settle_column` = #{settle_column,jdbcType=VARCHAR},",
          "`settle_value` = #{settle_value,jdbcType=VARCHAR},",
          "`channel_code` = #{channel_code,jdbcType=VARCHAR},",
          "`template_code` = #{template_code,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ThProductManage record);
}
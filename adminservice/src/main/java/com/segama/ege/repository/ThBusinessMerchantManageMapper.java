package com.segama.ege.repository;

import com.segama.ege.entity.ThBusinessMerchantManage;
import com.segama.ege.entity.ThBusinessMerchantManageExample;
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

public interface ThBusinessMerchantManageMapper {
    @SelectProvider(type=ThBusinessMerchantManageSqlProvider.class, method="countByExample")
    int countByExample(ThBusinessMerchantManageExample example);

    @DeleteProvider(type=ThBusinessMerchantManageSqlProvider.class, method="deleteByExample")
    int deleteByExample(ThBusinessMerchantManageExample example);

    @Delete({
        "delete from `th_business_merchant_manage`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `th_business_merchant_manage` (`business_name`, `business_short_name`, ",
        "`business_code`, `contact_phone`, ",
        "`contact_name`, `contact_email`, ",
        "`business_status`, `description`, ",
        "`gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`)",
        "values (#{business_name,jdbcType=VARCHAR}, #{business_short_name,jdbcType=VARCHAR}, ",
        "#{business_code,jdbcType=VARCHAR}, #{contact_phone,jdbcType=VARCHAR}, ",
        "#{contact_name,jdbcType=VARCHAR}, #{contact_email,jdbcType=VARCHAR}, ",
        "#{business_status,jdbcType=INTEGER}, #{description,jdbcType=VARCHAR}, ",
        "#{gmt_create,jdbcType=TIMESTAMP}, #{gmt_modify,jdbcType=TIMESTAMP}, ",
        "#{creator_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ThBusinessMerchantManage record);

    @InsertProvider(type=ThBusinessMerchantManageSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ThBusinessMerchantManage record);

    @SelectProvider(type=ThBusinessMerchantManageSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="business_name", property="business_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_short_name", property="business_short_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_code", property="business_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_phone", property="contact_phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_name", property="contact_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_email", property="contact_email", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_status", property="business_status", jdbcType=JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR)
    })
    List<ThBusinessMerchantManage> selectByExample(ThBusinessMerchantManageExample example);

    @Select({
        "select",
        "`id`, `business_name`, `business_short_name`, `business_code`, `contact_phone`, ",
        "`contact_name`, `contact_email`, `business_status`, `description`, `gmt_create`, ",
        "`gmt_modify`, `creator_account`, `modifier_account`",
        "from `th_business_merchant_manage`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="business_name", property="business_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_short_name", property="business_short_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_code", property="business_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_phone", property="contact_phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_name", property="contact_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_email", property="contact_email", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_status", property="business_status", jdbcType=JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR)
    })
    ThBusinessMerchantManage selectByPrimaryKey(Long id);

    @UpdateProvider(type=ThBusinessMerchantManageSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ThBusinessMerchantManage record, @Param("example") ThBusinessMerchantManageExample example);

    @UpdateProvider(type=ThBusinessMerchantManageSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ThBusinessMerchantManage record, @Param("example") ThBusinessMerchantManageExample example);

    @UpdateProvider(type=ThBusinessMerchantManageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ThBusinessMerchantManage record);

    @Update({
        "update `th_business_merchant_manage`",
        "set `business_name` = #{business_name,jdbcType=VARCHAR},",
          "`business_short_name` = #{business_short_name,jdbcType=VARCHAR},",
          "`business_code` = #{business_code,jdbcType=VARCHAR},",
          "`contact_phone` = #{contact_phone,jdbcType=VARCHAR},",
          "`contact_name` = #{contact_name,jdbcType=VARCHAR},",
          "`contact_email` = #{contact_email,jdbcType=VARCHAR},",
          "`business_status` = #{business_status,jdbcType=INTEGER},",
          "`description` = #{description,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ThBusinessMerchantManage record);
}
package com.segama.ege.repository;

import com.segama.ege.entity.ThSaleExtensionManage;
import com.segama.ege.entity.ThSaleExtensionManageExample;
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

public interface ThSaleExtensionManageMapper {
    @SelectProvider(type=ThSaleExtensionManageSqlProvider.class, method="countByExample")
    int countByExample(ThSaleExtensionManageExample example);

    @DeleteProvider(type=ThSaleExtensionManageSqlProvider.class, method="deleteByExample")
    int deleteByExample(ThSaleExtensionManageExample example);

    @Delete({
        "delete from `th_sale_extension_manage`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `th_sale_extension_manage` (`code`, `share_url_code`, ",
        "`product_name`, `product_code`, ",
        "`request_url`, `source_url`, ",
        "`phone`, `owner_account`, ",
        "`create_account`, `user_name`, ",
        "`address`, `gmt_create`)",
        "values (#{code,jdbcType=VARCHAR}, #{share_url_code,jdbcType=VARCHAR}, ",
        "#{product_name,jdbcType=VARCHAR}, #{product_code,jdbcType=VARCHAR}, ",
        "#{request_url,jdbcType=VARCHAR}, #{source_url,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{owner_account,jdbcType=VARCHAR}, ",
        "#{create_account,jdbcType=VARCHAR}, #{user_name,jdbcType=VARCHAR}, ",
        "#{address,jdbcType=VARCHAR}, #{gmt_create,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ThSaleExtensionManage record);

    @InsertProvider(type=ThSaleExtensionManageSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ThSaleExtensionManage record);

    @SelectProvider(type=ThSaleExtensionManageSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="share_url_code", property="share_url_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_name", property="product_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_code", property="product_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="request_url", property="request_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="source_url", property="source_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="owner_account", property="owner_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_account", property="create_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="user_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ThSaleExtensionManage> selectByExample(ThSaleExtensionManageExample example);

    @Select({
        "select",
        "`id`, `code`, `share_url_code`, `product_name`, `product_code`, `request_url`, ",
        "`source_url`, `phone`, `owner_account`, `create_account`, `user_name`, `address`, ",
        "`gmt_create`",
        "from `th_sale_extension_manage`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="share_url_code", property="share_url_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_name", property="product_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_code", property="product_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="request_url", property="request_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="source_url", property="source_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="owner_account", property="owner_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_account", property="create_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="user_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP)
    })
    ThSaleExtensionManage selectByPrimaryKey(Long id);

    @UpdateProvider(type=ThSaleExtensionManageSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ThSaleExtensionManage record, @Param("example") ThSaleExtensionManageExample example);

    @UpdateProvider(type=ThSaleExtensionManageSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ThSaleExtensionManage record, @Param("example") ThSaleExtensionManageExample example);

    @UpdateProvider(type=ThSaleExtensionManageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ThSaleExtensionManage record);

    @Update({
        "update `th_sale_extension_manage`",
        "set `code` = #{code,jdbcType=VARCHAR},",
          "`share_url_code` = #{share_url_code,jdbcType=VARCHAR},",
          "`product_name` = #{product_name,jdbcType=VARCHAR},",
          "`product_code` = #{product_code,jdbcType=VARCHAR},",
          "`request_url` = #{request_url,jdbcType=VARCHAR},",
          "`source_url` = #{source_url,jdbcType=VARCHAR},",
          "`phone` = #{phone,jdbcType=VARCHAR},",
          "`owner_account` = #{owner_account,jdbcType=VARCHAR},",
          "`create_account` = #{create_account,jdbcType=VARCHAR},",
          "`user_name` = #{user_name,jdbcType=VARCHAR},",
          "`address` = #{address,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ThSaleExtensionManage record);
}
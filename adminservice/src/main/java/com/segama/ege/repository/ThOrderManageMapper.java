package com.segama.ege.repository;

import com.segama.ege.entity.ThOrderManage;
import com.segama.ege.entity.ThOrderManageExample;
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

public interface ThOrderManageMapper {
    @SelectProvider(type=ThOrderManageSqlProvider.class, method="countByExample")
    int countByExample(ThOrderManageExample example);

    @DeleteProvider(type=ThOrderManageSqlProvider.class, method="deleteByExample")
    int deleteByExample(ThOrderManageExample example);

    @Delete({
        "delete from `th_order_manage`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `th_order_manage` (`operate_type`, `order_code`, ",
        "`order_time`, `order_phone_number`, ",
        "`prov`, `city`, `order_status`, ",
        "`customer_name`, `certificate_type`, ",
        "`certificate_num`, `customer_contact_num`, ",
        "`good_name`, `address`, ",
        "`active_status`, `cudian_code`, ",
        "`shoucong_amt`, `shoucong_time`, ",
        "`xiehaozhuanwang_type`, `zhuanhualvtichu_reason`, ",
        "`gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`, ",
        "`description`, `channel_account`, ",
        "`channel_code`, `picihao`, ",
        "`show_btn`, `order_id`)",
        "values (#{operate_type,jdbcType=VARCHAR}, #{order_code,jdbcType=VARCHAR}, ",
        "#{order_time,jdbcType=VARCHAR}, #{order_phone_number,jdbcType=VARCHAR}, ",
        "#{prov,jdbcType=VARCHAR}, #{city,jdbcType=VARCHAR}, #{order_status,jdbcType=VARCHAR}, ",
        "#{customer_name,jdbcType=VARCHAR}, #{certificate_type,jdbcType=VARCHAR}, ",
        "#{certificate_num,jdbcType=VARCHAR}, #{customer_contact_num,jdbcType=VARCHAR}, ",
        "#{good_name,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{active_status,jdbcType=VARCHAR}, #{cudian_code,jdbcType=VARCHAR}, ",
        "#{shoucong_amt,jdbcType=VARCHAR}, #{shoucong_time,jdbcType=VARCHAR}, ",
        "#{xiehaozhuanwang_type,jdbcType=VARCHAR}, #{zhuanhualvtichu_reason,jdbcType=VARCHAR}, ",
        "#{gmt_create,jdbcType=TIMESTAMP}, #{gmt_modify,jdbcType=TIMESTAMP}, ",
        "#{creator_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{channel_account,jdbcType=VARCHAR}, ",
        "#{channel_code,jdbcType=VARCHAR}, #{picihao,jdbcType=VARCHAR}, ",
        "#{show_btn,jdbcType=INTEGER}, #{order_id,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ThOrderManage record);

    @InsertProvider(type=ThOrderManageSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ThOrderManage record);

    @SelectProvider(type=ThOrderManageSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="operate_type", property="operate_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_code", property="order_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_time", property="order_time", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_phone_number", property="order_phone_number", jdbcType=JdbcType.VARCHAR),
        @Result(column="prov", property="prov", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_status", property="order_status", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_name", property="customer_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="certificate_type", property="certificate_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="certificate_num", property="certificate_num", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_contact_num", property="customer_contact_num", jdbcType=JdbcType.VARCHAR),
        @Result(column="good_name", property="good_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="active_status", property="active_status", jdbcType=JdbcType.VARCHAR),
        @Result(column="cudian_code", property="cudian_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="shoucong_amt", property="shoucong_amt", jdbcType=JdbcType.VARCHAR),
        @Result(column="shoucong_time", property="shoucong_time", jdbcType=JdbcType.VARCHAR),
        @Result(column="xiehaozhuanwang_type", property="xiehaozhuanwang_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="zhuanhualvtichu_reason", property="zhuanhualvtichu_reason", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_account", property="channel_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_code", property="channel_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="picihao", property="picihao", jdbcType=JdbcType.VARCHAR),
        @Result(column="show_btn", property="show_btn", jdbcType=JdbcType.INTEGER),
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.VARCHAR)
    })
    List<ThOrderManage> selectByExample(ThOrderManageExample example);

    @Select({
        "select",
        "`id`, `operate_type`, `order_code`, `order_time`, `order_phone_number`, `prov`, ",
        "`city`, `order_status`, `customer_name`, `certificate_type`, `certificate_num`, ",
        "`customer_contact_num`, `good_name`, `address`, `active_status`, `cudian_code`, ",
        "`shoucong_amt`, `shoucong_time`, `xiehaozhuanwang_type`, `zhuanhualvtichu_reason`, ",
        "`gmt_create`, `gmt_modify`, `creator_account`, `modifier_account`, `description`, ",
        "`channel_account`, `channel_code`, `picihao`, `show_btn`, `order_id`",
        "from `th_order_manage`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="operate_type", property="operate_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_code", property="order_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_time", property="order_time", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_phone_number", property="order_phone_number", jdbcType=JdbcType.VARCHAR),
        @Result(column="prov", property="prov", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_status", property="order_status", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_name", property="customer_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="certificate_type", property="certificate_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="certificate_num", property="certificate_num", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_contact_num", property="customer_contact_num", jdbcType=JdbcType.VARCHAR),
        @Result(column="good_name", property="good_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="active_status", property="active_status", jdbcType=JdbcType.VARCHAR),
        @Result(column="cudian_code", property="cudian_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="shoucong_amt", property="shoucong_amt", jdbcType=JdbcType.VARCHAR),
        @Result(column="shoucong_time", property="shoucong_time", jdbcType=JdbcType.VARCHAR),
        @Result(column="xiehaozhuanwang_type", property="xiehaozhuanwang_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="zhuanhualvtichu_reason", property="zhuanhualvtichu_reason", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_account", property="channel_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_code", property="channel_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="picihao", property="picihao", jdbcType=JdbcType.VARCHAR),
        @Result(column="show_btn", property="show_btn", jdbcType=JdbcType.INTEGER),
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.VARCHAR)
    })
    ThOrderManage selectByPrimaryKey(Long id);

    @UpdateProvider(type=ThOrderManageSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ThOrderManage record, @Param("example") ThOrderManageExample example);

    @UpdateProvider(type=ThOrderManageSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ThOrderManage record, @Param("example") ThOrderManageExample example);

    @UpdateProvider(type=ThOrderManageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ThOrderManage record);

    @Update({
        "update `th_order_manage`",
        "set `operate_type` = #{operate_type,jdbcType=VARCHAR},",
          "`order_code` = #{order_code,jdbcType=VARCHAR},",
          "`order_time` = #{order_time,jdbcType=VARCHAR},",
          "`order_phone_number` = #{order_phone_number,jdbcType=VARCHAR},",
          "`prov` = #{prov,jdbcType=VARCHAR},",
          "`city` = #{city,jdbcType=VARCHAR},",
          "`order_status` = #{order_status,jdbcType=VARCHAR},",
          "`customer_name` = #{customer_name,jdbcType=VARCHAR},",
          "`certificate_type` = #{certificate_type,jdbcType=VARCHAR},",
          "`certificate_num` = #{certificate_num,jdbcType=VARCHAR},",
          "`customer_contact_num` = #{customer_contact_num,jdbcType=VARCHAR},",
          "`good_name` = #{good_name,jdbcType=VARCHAR},",
          "`address` = #{address,jdbcType=VARCHAR},",
          "`active_status` = #{active_status,jdbcType=VARCHAR},",
          "`cudian_code` = #{cudian_code,jdbcType=VARCHAR},",
          "`shoucong_amt` = #{shoucong_amt,jdbcType=VARCHAR},",
          "`shoucong_time` = #{shoucong_time,jdbcType=VARCHAR},",
          "`xiehaozhuanwang_type` = #{xiehaozhuanwang_type,jdbcType=VARCHAR},",
          "`zhuanhualvtichu_reason` = #{zhuanhualvtichu_reason,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`description` = #{description,jdbcType=VARCHAR},",
          "`channel_account` = #{channel_account,jdbcType=VARCHAR},",
          "`channel_code` = #{channel_code,jdbcType=VARCHAR},",
          "`picihao` = #{picihao,jdbcType=VARCHAR},",
          "`show_btn` = #{show_btn,jdbcType=INTEGER},",
          "`order_id` = #{order_id,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ThOrderManage record);
}
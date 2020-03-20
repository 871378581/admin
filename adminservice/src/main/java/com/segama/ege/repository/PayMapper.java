package com.segama.ege.repository;

import com.segama.ege.entity.Pay;
import com.segama.ege.entity.PayExample;
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

public interface PayMapper {
    @SelectProvider(type=PaySqlProvider.class, method="countByExample")
    int countByExample(PayExample example);

    @DeleteProvider(type=PaySqlProvider.class, method="deleteByExample")
    int deleteByExample(PayExample example);

    @Delete({
        "delete from `pay`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `pay` (`order_id`, `order_string_id`, ",
        "`pay_string_id`, `pay_status`, ",
        "`before_discount_fee`, `coupon_ids`, ",
        "`discount_fee`, `pay_mode`, ",
        "`final_fee`, `gmt_pay_create`, ",
        "`gmt_pay_finish`, `gmt_create`, ",
        "`gmt_modify`, `creator_account`, ",
        "`modifier_account`)",
        "values (#{order_id,jdbcType=BIGINT}, #{order_string_id,jdbcType=VARCHAR}, ",
        "#{pay_string_id,jdbcType=VARCHAR}, #{pay_status,jdbcType=VARCHAR}, ",
        "#{before_discount_fee,jdbcType=VARCHAR}, #{coupon_ids,jdbcType=VARCHAR}, ",
        "#{discount_fee,jdbcType=VARCHAR}, #{pay_mode,jdbcType=VARCHAR}, ",
        "#{final_fee,jdbcType=VARCHAR}, #{gmt_pay_create,jdbcType=TIMESTAMP}, ",
        "#{gmt_pay_finish,jdbcType=TIMESTAMP}, #{gmt_create,jdbcType=TIMESTAMP}, ",
        "#{gmt_modify,jdbcType=TIMESTAMP}, #{creator_account,jdbcType=VARCHAR}, ",
        "#{modifier_account,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Pay record);

    @InsertProvider(type=PaySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(Pay record);

    @SelectProvider(type=PaySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.BIGINT),
        @Result(column="order_string_id", property="order_string_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_string_id", property="pay_string_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_status", property="pay_status", jdbcType=JdbcType.VARCHAR),
        @Result(column="before_discount_fee", property="before_discount_fee", jdbcType=JdbcType.VARCHAR),
        @Result(column="coupon_ids", property="coupon_ids", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_fee", property="discount_fee", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_mode", property="pay_mode", jdbcType=JdbcType.VARCHAR),
        @Result(column="final_fee", property="final_fee", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_pay_create", property="gmt_pay_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_pay_finish", property="gmt_pay_finish", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR)
    })
    List<Pay> selectByExample(PayExample example);

    @Select({
        "select",
        "`id`, `order_id`, `order_string_id`, `pay_string_id`, `pay_status`, `before_discount_fee`, ",
        "`coupon_ids`, `discount_fee`, `pay_mode`, `final_fee`, `gmt_pay_create`, `gmt_pay_finish`, ",
        "`gmt_create`, `gmt_modify`, `creator_account`, `modifier_account`",
        "from `pay`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.BIGINT),
        @Result(column="order_string_id", property="order_string_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_string_id", property="pay_string_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_status", property="pay_status", jdbcType=JdbcType.VARCHAR),
        @Result(column="before_discount_fee", property="before_discount_fee", jdbcType=JdbcType.VARCHAR),
        @Result(column="coupon_ids", property="coupon_ids", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_fee", property="discount_fee", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_mode", property="pay_mode", jdbcType=JdbcType.VARCHAR),
        @Result(column="final_fee", property="final_fee", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_pay_create", property="gmt_pay_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_pay_finish", property="gmt_pay_finish", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR)
    })
    Pay selectByPrimaryKey(Long id);

    @UpdateProvider(type=PaySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Pay record, @Param("example") PayExample example);

    @UpdateProvider(type=PaySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Pay record, @Param("example") PayExample example);

    @UpdateProvider(type=PaySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Pay record);

    @Update({
        "update `pay`",
        "set `order_id` = #{order_id,jdbcType=BIGINT},",
          "`order_string_id` = #{order_string_id,jdbcType=VARCHAR},",
          "`pay_string_id` = #{pay_string_id,jdbcType=VARCHAR},",
          "`pay_status` = #{pay_status,jdbcType=VARCHAR},",
          "`before_discount_fee` = #{before_discount_fee,jdbcType=VARCHAR},",
          "`coupon_ids` = #{coupon_ids,jdbcType=VARCHAR},",
          "`discount_fee` = #{discount_fee,jdbcType=VARCHAR},",
          "`pay_mode` = #{pay_mode,jdbcType=VARCHAR},",
          "`final_fee` = #{final_fee,jdbcType=VARCHAR},",
          "`gmt_pay_create` = #{gmt_pay_create,jdbcType=TIMESTAMP},",
          "`gmt_pay_finish` = #{gmt_pay_finish,jdbcType=TIMESTAMP},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Pay record);
}
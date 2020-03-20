package com.segama.ege.repository;

import com.segama.ege.entity.CapitalFlow;
import com.segama.ege.entity.CapitalFlowExample;
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

public interface CapitalFlowMapper {
    @SelectProvider(type=CapitalFlowSqlProvider.class, method="countByExample")
    int countByExample(CapitalFlowExample example);

    @DeleteProvider(type=CapitalFlowSqlProvider.class, method="deleteByExample")
    int deleteByExample(CapitalFlowExample example);

    @Delete({
        "delete from `capital_flow`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `capital_flow` (`shop_id`, `account`, ",
        "`real_name`, `amount`, ",
        "`description`, `order_string_id`, ",
        "`bank_card_num`, `payee`, ",
        "`opening_bank`, `operate_type`, ",
        "`order_id`, `verify_id`, ",
        "`gmt_create`, `total_amount`, ",
        "`freezing_amount`, `available_amount`, ",
        "`shop_name`)",
        "values (#{shop_id,jdbcType=BIGINT}, #{account,jdbcType=VARCHAR}, ",
        "#{real_name,jdbcType=VARCHAR}, #{amount,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{order_string_id,jdbcType=VARCHAR}, ",
        "#{bank_card_num,jdbcType=VARCHAR}, #{payee,jdbcType=VARCHAR}, ",
        "#{opening_bank,jdbcType=VARCHAR}, #{operate_type,jdbcType=BIGINT}, ",
        "#{order_id,jdbcType=BIGINT}, #{verify_id,jdbcType=BIGINT}, ",
        "#{gmt_create,jdbcType=TIMESTAMP}, #{total_amount,jdbcType=VARCHAR}, ",
        "#{freezing_amount,jdbcType=VARCHAR}, #{available_amount,jdbcType=VARCHAR}, ",
        "#{shop_name,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(CapitalFlow record);

    @InsertProvider(type=CapitalFlowSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(CapitalFlow record);

    @SelectProvider(type=CapitalFlowSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="shop_id", property="shop_id", jdbcType=JdbcType.BIGINT),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="real_name", property="real_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="amount", property="amount", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_string_id", property="order_string_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_card_num", property="bank_card_num", jdbcType=JdbcType.VARCHAR),
        @Result(column="payee", property="payee", jdbcType=JdbcType.VARCHAR),
        @Result(column="opening_bank", property="opening_bank", jdbcType=JdbcType.VARCHAR),
        @Result(column="operate_type", property="operate_type", jdbcType=JdbcType.BIGINT),
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.BIGINT),
        @Result(column="verify_id", property="verify_id", jdbcType=JdbcType.BIGINT),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="total_amount", property="total_amount", jdbcType=JdbcType.VARCHAR),
        @Result(column="freezing_amount", property="freezing_amount", jdbcType=JdbcType.VARCHAR),
        @Result(column="available_amount", property="available_amount", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_name", property="shop_name", jdbcType=JdbcType.VARCHAR)
    })
    List<CapitalFlow> selectByExample(CapitalFlowExample example);

    @Select({
        "select",
        "`id`, `shop_id`, `account`, `real_name`, `amount`, `description`, `order_string_id`, ",
        "`bank_card_num`, `payee`, `opening_bank`, `operate_type`, `order_id`, `verify_id`, ",
        "`gmt_create`, `total_amount`, `freezing_amount`, `available_amount`, `shop_name`",
        "from `capital_flow`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="shop_id", property="shop_id", jdbcType=JdbcType.BIGINT),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="real_name", property="real_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="amount", property="amount", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_string_id", property="order_string_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_card_num", property="bank_card_num", jdbcType=JdbcType.VARCHAR),
        @Result(column="payee", property="payee", jdbcType=JdbcType.VARCHAR),
        @Result(column="opening_bank", property="opening_bank", jdbcType=JdbcType.VARCHAR),
        @Result(column="operate_type", property="operate_type", jdbcType=JdbcType.BIGINT),
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.BIGINT),
        @Result(column="verify_id", property="verify_id", jdbcType=JdbcType.BIGINT),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="total_amount", property="total_amount", jdbcType=JdbcType.VARCHAR),
        @Result(column="freezing_amount", property="freezing_amount", jdbcType=JdbcType.VARCHAR),
        @Result(column="available_amount", property="available_amount", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_name", property="shop_name", jdbcType=JdbcType.VARCHAR)
    })
    CapitalFlow selectByPrimaryKey(Long id);

    @UpdateProvider(type=CapitalFlowSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CapitalFlow record, @Param("example") CapitalFlowExample example);

    @UpdateProvider(type=CapitalFlowSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CapitalFlow record, @Param("example") CapitalFlowExample example);

    @UpdateProvider(type=CapitalFlowSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CapitalFlow record);

    @Update({
        "update `capital_flow`",
        "set `shop_id` = #{shop_id,jdbcType=BIGINT},",
          "`account` = #{account,jdbcType=VARCHAR},",
          "`real_name` = #{real_name,jdbcType=VARCHAR},",
          "`amount` = #{amount,jdbcType=VARCHAR},",
          "`description` = #{description,jdbcType=VARCHAR},",
          "`order_string_id` = #{order_string_id,jdbcType=VARCHAR},",
          "`bank_card_num` = #{bank_card_num,jdbcType=VARCHAR},",
          "`payee` = #{payee,jdbcType=VARCHAR},",
          "`opening_bank` = #{opening_bank,jdbcType=VARCHAR},",
          "`operate_type` = #{operate_type,jdbcType=BIGINT},",
          "`order_id` = #{order_id,jdbcType=BIGINT},",
          "`verify_id` = #{verify_id,jdbcType=BIGINT},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`total_amount` = #{total_amount,jdbcType=VARCHAR},",
          "`freezing_amount` = #{freezing_amount,jdbcType=VARCHAR},",
          "`available_amount` = #{available_amount,jdbcType=VARCHAR},",
          "`shop_name` = #{shop_name,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CapitalFlow record);
}
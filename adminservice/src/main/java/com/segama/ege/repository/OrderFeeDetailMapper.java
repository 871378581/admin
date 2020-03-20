package com.segama.ege.repository;

import com.segama.ege.entity.OrderFeeDetail;
import com.segama.ege.entity.OrderFeeDetailExample;
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

public interface OrderFeeDetailMapper {
    @SelectProvider(type=OrderFeeDetailSqlProvider.class, method="countByExample")
    int countByExample(OrderFeeDetailExample example);

    @DeleteProvider(type=OrderFeeDetailSqlProvider.class, method="deleteByExample")
    int deleteByExample(OrderFeeDetailExample example);

    @Delete({
        "delete from `order_fee_detail`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `order_fee_detail` (`order_id`, `order_string_id`, ",
        "`each_item_id`, `each_item`, ",
        "`each_fee`, `gmt_create`, ",
        "`gmt_modify`, `creator_account`, ",
        "`modifier_account`, `pay_id`)",
        "values (#{order_id,jdbcType=BIGINT}, #{order_string_id,jdbcType=VARCHAR}, ",
        "#{each_item_id,jdbcType=BIGINT}, #{each_item,jdbcType=VARCHAR}, ",
        "#{each_fee,jdbcType=VARCHAR}, #{gmt_create,jdbcType=TIMESTAMP}, ",
        "#{gmt_modify,jdbcType=TIMESTAMP}, #{creator_account,jdbcType=VARCHAR}, ",
        "#{modifier_account,jdbcType=VARCHAR}, #{pay_id,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(OrderFeeDetail record);

    @InsertProvider(type=OrderFeeDetailSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(OrderFeeDetail record);

    @SelectProvider(type=OrderFeeDetailSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.BIGINT),
        @Result(column="order_string_id", property="order_string_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="each_item_id", property="each_item_id", jdbcType=JdbcType.BIGINT),
        @Result(column="each_item", property="each_item", jdbcType=JdbcType.VARCHAR),
        @Result(column="each_fee", property="each_fee", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_id", property="pay_id", jdbcType=JdbcType.BIGINT)
    })
    List<OrderFeeDetail> selectByExample(OrderFeeDetailExample example);

    @Select({
        "select",
        "`id`, `order_id`, `order_string_id`, `each_item_id`, `each_item`, `each_fee`, ",
        "`gmt_create`, `gmt_modify`, `creator_account`, `modifier_account`, `pay_id`",
        "from `order_fee_detail`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.BIGINT),
        @Result(column="order_string_id", property="order_string_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="each_item_id", property="each_item_id", jdbcType=JdbcType.BIGINT),
        @Result(column="each_item", property="each_item", jdbcType=JdbcType.VARCHAR),
        @Result(column="each_fee", property="each_fee", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_id", property="pay_id", jdbcType=JdbcType.BIGINT)
    })
    OrderFeeDetail selectByPrimaryKey(Long id);

    @UpdateProvider(type=OrderFeeDetailSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") OrderFeeDetail record, @Param("example") OrderFeeDetailExample example);

    @UpdateProvider(type=OrderFeeDetailSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") OrderFeeDetail record, @Param("example") OrderFeeDetailExample example);

    @UpdateProvider(type=OrderFeeDetailSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(OrderFeeDetail record);

    @Update({
        "update `order_fee_detail`",
        "set `order_id` = #{order_id,jdbcType=BIGINT},",
          "`order_string_id` = #{order_string_id,jdbcType=VARCHAR},",
          "`each_item_id` = #{each_item_id,jdbcType=BIGINT},",
          "`each_item` = #{each_item,jdbcType=VARCHAR},",
          "`each_fee` = #{each_fee,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`pay_id` = #{pay_id,jdbcType=BIGINT}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(OrderFeeDetail record);
}
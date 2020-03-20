package com.segama.ege.repository;

import com.segama.ege.entity.ShopEvaluateDetail;
import com.segama.ege.entity.ShopEvaluateDetailExample;
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

public interface ShopEvaluateDetailMapper {
    @SelectProvider(type=ShopEvaluateDetailSqlProvider.class, method="countByExample")
    int countByExample(ShopEvaluateDetailExample example);

    @DeleteProvider(type=ShopEvaluateDetailSqlProvider.class, method="deleteByExample")
    int deleteByExample(ShopEvaluateDetailExample example);

    @Delete({
        "delete from `shop_evaluate_detail`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `shop_evaluate_detail` (`user_id`, `nick_name`, ",
        "`car_type`, `gmt_repair`, ",
        "`evaluate_score`, `evaluate_content`, ",
        "`gmt_evaluate_commit`, `is_invalid`, ",
        "`gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`, ",
        "`shop_id`, `version`, ",
        "`order_id`, `user_head`)",
        "values (#{user_id,jdbcType=VARCHAR}, #{nick_name,jdbcType=VARCHAR}, ",
        "#{car_type,jdbcType=VARCHAR}, #{gmt_repair,jdbcType=TIMESTAMP}, ",
        "#{evaluate_score,jdbcType=VARCHAR}, #{evaluate_content,jdbcType=VARCHAR}, ",
        "#{gmt_evaluate_commit,jdbcType=TIMESTAMP}, #{is_invalid,jdbcType=BIT}, ",
        "#{gmt_create,jdbcType=TIMESTAMP}, #{gmt_modify,jdbcType=TIMESTAMP}, ",
        "#{creator_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR}, ",
        "#{shop_id,jdbcType=BIGINT}, #{version,jdbcType=INTEGER}, ",
        "#{order_id,jdbcType=BIGINT}, #{user_head,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ShopEvaluateDetail record);

    @InsertProvider(type=ShopEvaluateDetailSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ShopEvaluateDetail record);

    @SelectProvider(type=ShopEvaluateDetailSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="nick_name", property="nick_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_type", property="car_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_repair", property="gmt_repair", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="evaluate_score", property="evaluate_score", jdbcType=JdbcType.VARCHAR),
        @Result(column="evaluate_content", property="evaluate_content", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_evaluate_commit", property="gmt_evaluate_commit", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_invalid", property="is_invalid", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_id", property="shop_id", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.BIGINT),
        @Result(column="user_head", property="user_head", jdbcType=JdbcType.VARCHAR)
    })
    List<ShopEvaluateDetail> selectByExample(ShopEvaluateDetailExample example);

    @Select({
        "select",
        "`id`, `user_id`, `nick_name`, `car_type`, `gmt_repair`, `evaluate_score`, `evaluate_content`, ",
        "`gmt_evaluate_commit`, `is_invalid`, `gmt_create`, `gmt_modify`, `creator_account`, ",
        "`modifier_account`, `shop_id`, `version`, `order_id`, `user_head`",
        "from `shop_evaluate_detail`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="nick_name", property="nick_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_type", property="car_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_repair", property="gmt_repair", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="evaluate_score", property="evaluate_score", jdbcType=JdbcType.VARCHAR),
        @Result(column="evaluate_content", property="evaluate_content", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_evaluate_commit", property="gmt_evaluate_commit", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_invalid", property="is_invalid", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_id", property="shop_id", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.BIGINT),
        @Result(column="user_head", property="user_head", jdbcType=JdbcType.VARCHAR)
    })
    ShopEvaluateDetail selectByPrimaryKey(Long id);

    @UpdateProvider(type=ShopEvaluateDetailSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ShopEvaluateDetail record, @Param("example") ShopEvaluateDetailExample example);

    @UpdateProvider(type=ShopEvaluateDetailSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ShopEvaluateDetail record, @Param("example") ShopEvaluateDetailExample example);

    @UpdateProvider(type=ShopEvaluateDetailSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ShopEvaluateDetail record);

    @Update({
        "update `shop_evaluate_detail`",
        "set `user_id` = #{user_id,jdbcType=VARCHAR},",
          "`nick_name` = #{nick_name,jdbcType=VARCHAR},",
          "`car_type` = #{car_type,jdbcType=VARCHAR},",
          "`gmt_repair` = #{gmt_repair,jdbcType=TIMESTAMP},",
          "`evaluate_score` = #{evaluate_score,jdbcType=VARCHAR},",
          "`evaluate_content` = #{evaluate_content,jdbcType=VARCHAR},",
          "`gmt_evaluate_commit` = #{gmt_evaluate_commit,jdbcType=TIMESTAMP},",
          "`is_invalid` = #{is_invalid,jdbcType=BIT},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`shop_id` = #{shop_id,jdbcType=BIGINT},",
          "`version` = #{version,jdbcType=INTEGER},",
          "`order_id` = #{order_id,jdbcType=BIGINT},",
          "`user_head` = #{user_head,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ShopEvaluateDetail record);
}
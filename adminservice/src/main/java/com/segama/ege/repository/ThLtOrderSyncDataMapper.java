package com.segama.ege.repository;

import com.segama.ege.entity.ThLtOrderSyncData;
import com.segama.ege.entity.ThLtOrderSyncDataExample;
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

public interface ThLtOrderSyncDataMapper {
    @SelectProvider(type=ThLtOrderSyncDataSqlProvider.class, method="countByExample")
    int countByExample(ThLtOrderSyncDataExample example);

    @DeleteProvider(type=ThLtOrderSyncDataSqlProvider.class, method="deleteByExample")
    int deleteByExample(ThLtOrderSyncDataExample example);

    @Delete({
        "delete from `th_lt_order_sync_data`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `th_lt_order_sync_data` (`code`, `channel_code`, ",
        "`extend`, `city_name`, ",
        "`pacakge_code`, `pacakge_name`, ",
        "`contract_period`, `discount_amount`, ",
        "`access_name`, `id_number`, ",
        "`addressee`, `addressee_phone`, ",
        "`district_name`, `address`, ",
        "`selected_phone_num`, `freeze`, ",
        "`freeze_amount`, `order_create_time`, ",
        "`gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`, ",
        "`description`)",
        "values (#{code,jdbcType=VARCHAR}, #{channel_code,jdbcType=VARCHAR}, ",
        "#{extend,jdbcType=VARCHAR}, #{city_name,jdbcType=VARCHAR}, ",
        "#{pacakge_code,jdbcType=VARCHAR}, #{pacakge_name,jdbcType=VARCHAR}, ",
        "#{contract_period,jdbcType=VARCHAR}, #{discount_amount,jdbcType=VARCHAR}, ",
        "#{access_name,jdbcType=VARCHAR}, #{id_number,jdbcType=VARCHAR}, ",
        "#{addressee,jdbcType=VARCHAR}, #{addressee_phone,jdbcType=VARCHAR}, ",
        "#{district_name,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{selected_phone_num,jdbcType=VARCHAR}, #{freeze,jdbcType=VARCHAR}, ",
        "#{freeze_amount,jdbcType=VARCHAR}, #{order_create_time,jdbcType=VARCHAR}, ",
        "#{gmt_create,jdbcType=TIMESTAMP}, #{gmt_modify,jdbcType=TIMESTAMP}, ",
        "#{creator_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ThLtOrderSyncData record);

    @InsertProvider(type=ThLtOrderSyncDataSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ThLtOrderSyncData record);

    @SelectProvider(type=ThLtOrderSyncDataSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_code", property="channel_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="extend", property="extend", jdbcType=JdbcType.VARCHAR),
        @Result(column="city_name", property="city_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="pacakge_code", property="pacakge_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="pacakge_name", property="pacakge_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="contract_period", property="contract_period", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_amount", property="discount_amount", jdbcType=JdbcType.VARCHAR),
        @Result(column="access_name", property="access_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_number", property="id_number", jdbcType=JdbcType.VARCHAR),
        @Result(column="addressee", property="addressee", jdbcType=JdbcType.VARCHAR),
        @Result(column="addressee_phone", property="addressee_phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="district_name", property="district_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="selected_phone_num", property="selected_phone_num", jdbcType=JdbcType.VARCHAR),
        @Result(column="freeze", property="freeze", jdbcType=JdbcType.VARCHAR),
        @Result(column="freeze_amount", property="freeze_amount", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_create_time", property="order_create_time", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    List<ThLtOrderSyncData> selectByExample(ThLtOrderSyncDataExample example);

    @Select({
        "select",
        "`id`, `code`, `channel_code`, `extend`, `city_name`, `pacakge_code`, `pacakge_name`, ",
        "`contract_period`, `discount_amount`, `access_name`, `id_number`, `addressee`, ",
        "`addressee_phone`, `district_name`, `address`, `selected_phone_num`, `freeze`, ",
        "`freeze_amount`, `order_create_time`, `gmt_create`, `gmt_modify`, `creator_account`, ",
        "`modifier_account`, `description`",
        "from `th_lt_order_sync_data`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_code", property="channel_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="extend", property="extend", jdbcType=JdbcType.VARCHAR),
        @Result(column="city_name", property="city_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="pacakge_code", property="pacakge_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="pacakge_name", property="pacakge_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="contract_period", property="contract_period", jdbcType=JdbcType.VARCHAR),
        @Result(column="discount_amount", property="discount_amount", jdbcType=JdbcType.VARCHAR),
        @Result(column="access_name", property="access_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_number", property="id_number", jdbcType=JdbcType.VARCHAR),
        @Result(column="addressee", property="addressee", jdbcType=JdbcType.VARCHAR),
        @Result(column="addressee_phone", property="addressee_phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="district_name", property="district_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="selected_phone_num", property="selected_phone_num", jdbcType=JdbcType.VARCHAR),
        @Result(column="freeze", property="freeze", jdbcType=JdbcType.VARCHAR),
        @Result(column="freeze_amount", property="freeze_amount", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_create_time", property="order_create_time", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    ThLtOrderSyncData selectByPrimaryKey(Long id);

    @UpdateProvider(type=ThLtOrderSyncDataSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ThLtOrderSyncData record, @Param("example") ThLtOrderSyncDataExample example);

    @UpdateProvider(type=ThLtOrderSyncDataSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ThLtOrderSyncData record, @Param("example") ThLtOrderSyncDataExample example);

    @UpdateProvider(type=ThLtOrderSyncDataSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ThLtOrderSyncData record);

    @Update({
        "update `th_lt_order_sync_data`",
        "set `code` = #{code,jdbcType=VARCHAR},",
          "`channel_code` = #{channel_code,jdbcType=VARCHAR},",
          "`extend` = #{extend,jdbcType=VARCHAR},",
          "`city_name` = #{city_name,jdbcType=VARCHAR},",
          "`pacakge_code` = #{pacakge_code,jdbcType=VARCHAR},",
          "`pacakge_name` = #{pacakge_name,jdbcType=VARCHAR},",
          "`contract_period` = #{contract_period,jdbcType=VARCHAR},",
          "`discount_amount` = #{discount_amount,jdbcType=VARCHAR},",
          "`access_name` = #{access_name,jdbcType=VARCHAR},",
          "`id_number` = #{id_number,jdbcType=VARCHAR},",
          "`addressee` = #{addressee,jdbcType=VARCHAR},",
          "`addressee_phone` = #{addressee_phone,jdbcType=VARCHAR},",
          "`district_name` = #{district_name,jdbcType=VARCHAR},",
          "`address` = #{address,jdbcType=VARCHAR},",
          "`selected_phone_num` = #{selected_phone_num,jdbcType=VARCHAR},",
          "`freeze` = #{freeze,jdbcType=VARCHAR},",
          "`freeze_amount` = #{freeze_amount,jdbcType=VARCHAR},",
          "`order_create_time` = #{order_create_time,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`description` = #{description,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ThLtOrderSyncData record);
}
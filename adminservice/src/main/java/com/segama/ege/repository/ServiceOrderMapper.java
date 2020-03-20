package com.segama.ege.repository;

import com.segama.ege.entity.ServiceOrder;
import com.segama.ege.entity.ServiceOrderExample;
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

public interface ServiceOrderMapper {
    @SelectProvider(type=ServiceOrderSqlProvider.class, method="countByExample")
    int countByExample(ServiceOrderExample example);

    @DeleteProvider(type=ServiceOrderSqlProvider.class, method="deleteByExample")
    int deleteByExample(ServiceOrderExample example);

    @Delete({
        "delete from `service_order`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `service_order` (`order_string_id`, `user_id`, ",
        "`user_name`, `car_id`, ",
        "`car_plate`, `car_type_name`, ",
        "`shop_id`, `shop_name`, ",
        "`oil_id`, `oil_brand`, ",
        "`service_item`, `order_status`, ",
        "`service_pacakge_id`, `report_id`, ",
        "`estimated_fee`, `final_fee`, ",
        "`pay_id`, `order_qr_code`, ",
        "`gmt_create`, `gmt_confirm`, ",
        "`gmt_service_date`, `gmt_change_service_date`, ",
        "`gmt_actual_service`, `gmt_pay`, ",
        "`gmt_evaluate`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`, ",
        "`car_logo_url`, `evaluate_id`, ",
        "`longitude`, `latitude`, ",
        "`gmt_service_begin_time`, `gmt_service_end_time`, ",
        "`gmt_change_service_end_time`, `gmt_change_service_begin_time`, ",
        "`child_status`, `shop_user_id`, ",
        "`shop_user_account`, `shop_user_name`, ",
        "`curr_maintenance_miles`, `car_front_photo_url`, ",
        "`car_dashboard_photo_url`, `order_type`, ",
        "`verify_remark`, `settle`, ",
        "`settle_amount`, `verify_account`, ",
        "`card_level`)",
        "values (#{order_string_id,jdbcType=VARCHAR}, #{user_id,jdbcType=VARCHAR}, ",
        "#{user_name,jdbcType=VARCHAR}, #{car_id,jdbcType=BIGINT}, ",
        "#{car_plate,jdbcType=VARCHAR}, #{car_type_name,jdbcType=VARCHAR}, ",
        "#{shop_id,jdbcType=BIGINT}, #{shop_name,jdbcType=VARCHAR}, ",
        "#{oil_id,jdbcType=BIGINT}, #{oil_brand,jdbcType=VARCHAR}, ",
        "#{service_item,jdbcType=VARCHAR}, #{order_status,jdbcType=VARCHAR}, ",
        "#{service_pacakge_id,jdbcType=BIGINT}, #{report_id,jdbcType=BIGINT}, ",
        "#{estimated_fee,jdbcType=VARCHAR}, #{final_fee,jdbcType=VARCHAR}, ",
        "#{pay_id,jdbcType=BIGINT}, #{order_qr_code,jdbcType=VARCHAR}, ",
        "#{gmt_create,jdbcType=TIMESTAMP}, #{gmt_confirm,jdbcType=TIMESTAMP}, ",
        "#{gmt_service_date,jdbcType=VARCHAR}, #{gmt_change_service_date,jdbcType=VARCHAR}, ",
        "#{gmt_actual_service,jdbcType=TIMESTAMP}, #{gmt_pay,jdbcType=TIMESTAMP}, ",
        "#{gmt_evaluate,jdbcType=TIMESTAMP}, #{gmt_modify,jdbcType=TIMESTAMP}, ",
        "#{creator_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR}, ",
        "#{car_logo_url,jdbcType=VARCHAR}, #{evaluate_id,jdbcType=BIGINT}, ",
        "#{longitude,jdbcType=DECIMAL}, #{latitude,jdbcType=DECIMAL}, ",
        "#{gmt_service_begin_time,jdbcType=VARCHAR}, #{gmt_service_end_time,jdbcType=VARCHAR}, ",
        "#{gmt_change_service_end_time,jdbcType=VARCHAR}, #{gmt_change_service_begin_time,jdbcType=VARCHAR}, ",
        "#{child_status,jdbcType=VARCHAR}, #{shop_user_id,jdbcType=BIGINT}, ",
        "#{shop_user_account,jdbcType=VARCHAR}, #{shop_user_name,jdbcType=VARCHAR}, ",
        "#{curr_maintenance_miles,jdbcType=VARCHAR}, #{car_front_photo_url,jdbcType=VARCHAR}, ",
        "#{car_dashboard_photo_url,jdbcType=VARCHAR}, #{order_type,jdbcType=INTEGER}, ",
        "#{verify_remark,jdbcType=VARCHAR}, #{settle,jdbcType=INTEGER}, ",
        "#{settle_amount,jdbcType=VARCHAR}, #{verify_account,jdbcType=VARCHAR}, ",
        "#{card_level,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ServiceOrder record);

    @InsertProvider(type=ServiceOrderSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ServiceOrder record);

    @SelectProvider(type=ServiceOrderSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_string_id", property="order_string_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="user_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_id", property="car_id", jdbcType=JdbcType.BIGINT),
        @Result(column="car_plate", property="car_plate", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_type_name", property="car_type_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_id", property="shop_id", jdbcType=JdbcType.BIGINT),
        @Result(column="shop_name", property="shop_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="oil_id", property="oil_id", jdbcType=JdbcType.BIGINT),
        @Result(column="oil_brand", property="oil_brand", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_item", property="service_item", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_status", property="order_status", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_pacakge_id", property="service_pacakge_id", jdbcType=JdbcType.BIGINT),
        @Result(column="report_id", property="report_id", jdbcType=JdbcType.BIGINT),
        @Result(column="estimated_fee", property="estimated_fee", jdbcType=JdbcType.VARCHAR),
        @Result(column="final_fee", property="final_fee", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_id", property="pay_id", jdbcType=JdbcType.BIGINT),
        @Result(column="order_qr_code", property="order_qr_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_confirm", property="gmt_confirm", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_service_date", property="gmt_service_date", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_change_service_date", property="gmt_change_service_date", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_actual_service", property="gmt_actual_service", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_pay", property="gmt_pay", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_evaluate", property="gmt_evaluate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_logo_url", property="car_logo_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="evaluate_id", property="evaluate_id", jdbcType=JdbcType.BIGINT),
        @Result(column="longitude", property="longitude", jdbcType=JdbcType.DECIMAL),
        @Result(column="latitude", property="latitude", jdbcType=JdbcType.DECIMAL),
        @Result(column="gmt_service_begin_time", property="gmt_service_begin_time", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_service_end_time", property="gmt_service_end_time", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_change_service_end_time", property="gmt_change_service_end_time", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_change_service_begin_time", property="gmt_change_service_begin_time", jdbcType=JdbcType.VARCHAR),
        @Result(column="child_status", property="child_status", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_user_id", property="shop_user_id", jdbcType=JdbcType.BIGINT),
        @Result(column="shop_user_account", property="shop_user_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_user_name", property="shop_user_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="curr_maintenance_miles", property="curr_maintenance_miles", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_front_photo_url", property="car_front_photo_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_dashboard_photo_url", property="car_dashboard_photo_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_type", property="order_type", jdbcType=JdbcType.INTEGER),
        @Result(column="verify_remark", property="verify_remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="settle", property="settle", jdbcType=JdbcType.INTEGER),
        @Result(column="settle_amount", property="settle_amount", jdbcType=JdbcType.VARCHAR),
        @Result(column="verify_account", property="verify_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="card_level", property="card_level", jdbcType=JdbcType.VARCHAR)
    })
    List<ServiceOrder> selectByExample(ServiceOrderExample example);

    @Select({
        "select",
        "`id`, `order_string_id`, `user_id`, `user_name`, `car_id`, `car_plate`, `car_type_name`, ",
        "`shop_id`, `shop_name`, `oil_id`, `oil_brand`, `service_item`, `order_status`, ",
        "`service_pacakge_id`, `report_id`, `estimated_fee`, `final_fee`, `pay_id`, `order_qr_code`, ",
        "`gmt_create`, `gmt_confirm`, `gmt_service_date`, `gmt_change_service_date`, ",
        "`gmt_actual_service`, `gmt_pay`, `gmt_evaluate`, `gmt_modify`, `creator_account`, ",
        "`modifier_account`, `car_logo_url`, `evaluate_id`, `longitude`, `latitude`, ",
        "`gmt_service_begin_time`, `gmt_service_end_time`, `gmt_change_service_end_time`, ",
        "`gmt_change_service_begin_time`, `child_status`, `shop_user_id`, `shop_user_account`, ",
        "`shop_user_name`, `curr_maintenance_miles`, `car_front_photo_url`, `car_dashboard_photo_url`, ",
        "`order_type`, `verify_remark`, `settle`, `settle_amount`, `verify_account`, ",
        "`card_level`",
        "from `service_order`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_string_id", property="order_string_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="user_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_id", property="car_id", jdbcType=JdbcType.BIGINT),
        @Result(column="car_plate", property="car_plate", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_type_name", property="car_type_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_id", property="shop_id", jdbcType=JdbcType.BIGINT),
        @Result(column="shop_name", property="shop_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="oil_id", property="oil_id", jdbcType=JdbcType.BIGINT),
        @Result(column="oil_brand", property="oil_brand", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_item", property="service_item", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_status", property="order_status", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_pacakge_id", property="service_pacakge_id", jdbcType=JdbcType.BIGINT),
        @Result(column="report_id", property="report_id", jdbcType=JdbcType.BIGINT),
        @Result(column="estimated_fee", property="estimated_fee", jdbcType=JdbcType.VARCHAR),
        @Result(column="final_fee", property="final_fee", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_id", property="pay_id", jdbcType=JdbcType.BIGINT),
        @Result(column="order_qr_code", property="order_qr_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_confirm", property="gmt_confirm", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_service_date", property="gmt_service_date", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_change_service_date", property="gmt_change_service_date", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_actual_service", property="gmt_actual_service", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_pay", property="gmt_pay", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_evaluate", property="gmt_evaluate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_logo_url", property="car_logo_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="evaluate_id", property="evaluate_id", jdbcType=JdbcType.BIGINT),
        @Result(column="longitude", property="longitude", jdbcType=JdbcType.DECIMAL),
        @Result(column="latitude", property="latitude", jdbcType=JdbcType.DECIMAL),
        @Result(column="gmt_service_begin_time", property="gmt_service_begin_time", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_service_end_time", property="gmt_service_end_time", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_change_service_end_time", property="gmt_change_service_end_time", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_change_service_begin_time", property="gmt_change_service_begin_time", jdbcType=JdbcType.VARCHAR),
        @Result(column="child_status", property="child_status", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_user_id", property="shop_user_id", jdbcType=JdbcType.BIGINT),
        @Result(column="shop_user_account", property="shop_user_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_user_name", property="shop_user_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="curr_maintenance_miles", property="curr_maintenance_miles", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_front_photo_url", property="car_front_photo_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_dashboard_photo_url", property="car_dashboard_photo_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_type", property="order_type", jdbcType=JdbcType.INTEGER),
        @Result(column="verify_remark", property="verify_remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="settle", property="settle", jdbcType=JdbcType.INTEGER),
        @Result(column="settle_amount", property="settle_amount", jdbcType=JdbcType.VARCHAR),
        @Result(column="verify_account", property="verify_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="card_level", property="card_level", jdbcType=JdbcType.VARCHAR)
    })
    ServiceOrder selectByPrimaryKey(Long id);

    @UpdateProvider(type=ServiceOrderSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ServiceOrder record, @Param("example") ServiceOrderExample example);

    @UpdateProvider(type=ServiceOrderSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ServiceOrder record, @Param("example") ServiceOrderExample example);

    @UpdateProvider(type=ServiceOrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ServiceOrder record);

    @Update({
        "update `service_order`",
        "set `order_string_id` = #{order_string_id,jdbcType=VARCHAR},",
          "`user_id` = #{user_id,jdbcType=VARCHAR},",
          "`user_name` = #{user_name,jdbcType=VARCHAR},",
          "`car_id` = #{car_id,jdbcType=BIGINT},",
          "`car_plate` = #{car_plate,jdbcType=VARCHAR},",
          "`car_type_name` = #{car_type_name,jdbcType=VARCHAR},",
          "`shop_id` = #{shop_id,jdbcType=BIGINT},",
          "`shop_name` = #{shop_name,jdbcType=VARCHAR},",
          "`oil_id` = #{oil_id,jdbcType=BIGINT},",
          "`oil_brand` = #{oil_brand,jdbcType=VARCHAR},",
          "`service_item` = #{service_item,jdbcType=VARCHAR},",
          "`order_status` = #{order_status,jdbcType=VARCHAR},",
          "`service_pacakge_id` = #{service_pacakge_id,jdbcType=BIGINT},",
          "`report_id` = #{report_id,jdbcType=BIGINT},",
          "`estimated_fee` = #{estimated_fee,jdbcType=VARCHAR},",
          "`final_fee` = #{final_fee,jdbcType=VARCHAR},",
          "`pay_id` = #{pay_id,jdbcType=BIGINT},",
          "`order_qr_code` = #{order_qr_code,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_confirm` = #{gmt_confirm,jdbcType=TIMESTAMP},",
          "`gmt_service_date` = #{gmt_service_date,jdbcType=VARCHAR},",
          "`gmt_change_service_date` = #{gmt_change_service_date,jdbcType=VARCHAR},",
          "`gmt_actual_service` = #{gmt_actual_service,jdbcType=TIMESTAMP},",
          "`gmt_pay` = #{gmt_pay,jdbcType=TIMESTAMP},",
          "`gmt_evaluate` = #{gmt_evaluate,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`car_logo_url` = #{car_logo_url,jdbcType=VARCHAR},",
          "`evaluate_id` = #{evaluate_id,jdbcType=BIGINT},",
          "`longitude` = #{longitude,jdbcType=DECIMAL},",
          "`latitude` = #{latitude,jdbcType=DECIMAL},",
          "`gmt_service_begin_time` = #{gmt_service_begin_time,jdbcType=VARCHAR},",
          "`gmt_service_end_time` = #{gmt_service_end_time,jdbcType=VARCHAR},",
          "`gmt_change_service_end_time` = #{gmt_change_service_end_time,jdbcType=VARCHAR},",
          "`gmt_change_service_begin_time` = #{gmt_change_service_begin_time,jdbcType=VARCHAR},",
          "`child_status` = #{child_status,jdbcType=VARCHAR},",
          "`shop_user_id` = #{shop_user_id,jdbcType=BIGINT},",
          "`shop_user_account` = #{shop_user_account,jdbcType=VARCHAR},",
          "`shop_user_name` = #{shop_user_name,jdbcType=VARCHAR},",
          "`curr_maintenance_miles` = #{curr_maintenance_miles,jdbcType=VARCHAR},",
          "`car_front_photo_url` = #{car_front_photo_url,jdbcType=VARCHAR},",
          "`car_dashboard_photo_url` = #{car_dashboard_photo_url,jdbcType=VARCHAR},",
          "`order_type` = #{order_type,jdbcType=INTEGER},",
          "`verify_remark` = #{verify_remark,jdbcType=VARCHAR},",
          "`settle` = #{settle,jdbcType=INTEGER},",
          "`settle_amount` = #{settle_amount,jdbcType=VARCHAR},",
          "`verify_account` = #{verify_account,jdbcType=VARCHAR},",
          "`card_level` = #{card_level,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ServiceOrder record);
}
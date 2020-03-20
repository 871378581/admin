package com.segama.ege.repository;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.segama.ege.entity.ServiceOrder;
import com.segama.ege.entity.ServiceOrderExample.Criteria;
import com.segama.ege.entity.ServiceOrderExample.Criterion;
import com.segama.ege.entity.ServiceOrderExample;
import java.util.List;
import java.util.Map;

public class ServiceOrderSqlProvider {

    public String countByExample(ServiceOrderExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("`service_order`");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ServiceOrderExample example) {
        BEGIN();
        DELETE_FROM("`service_order`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(ServiceOrder record) {
        BEGIN();
        INSERT_INTO("`service_order`");
        
        if (record.getOrder_string_id() != null) {
            VALUES("`order_string_id`", "#{order_string_id,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_id() != null) {
            VALUES("`user_id`", "#{user_id,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_name() != null) {
            VALUES("`user_name`", "#{user_name,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_id() != null) {
            VALUES("`car_id`", "#{car_id,jdbcType=BIGINT}");
        }
        
        if (record.getCar_plate() != null) {
            VALUES("`car_plate`", "#{car_plate,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_type_name() != null) {
            VALUES("`car_type_name`", "#{car_type_name,jdbcType=VARCHAR}");
        }
        
        if (record.getShop_id() != null) {
            VALUES("`shop_id`", "#{shop_id,jdbcType=BIGINT}");
        }
        
        if (record.getShop_name() != null) {
            VALUES("`shop_name`", "#{shop_name,jdbcType=VARCHAR}");
        }
        
        if (record.getOil_id() != null) {
            VALUES("`oil_id`", "#{oil_id,jdbcType=BIGINT}");
        }
        
        if (record.getOil_brand() != null) {
            VALUES("`oil_brand`", "#{oil_brand,jdbcType=VARCHAR}");
        }
        
        if (record.getService_item() != null) {
            VALUES("`service_item`", "#{service_item,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_status() != null) {
            VALUES("`order_status`", "#{order_status,jdbcType=VARCHAR}");
        }
        
        if (record.getService_pacakge_id() != null) {
            VALUES("`service_pacakge_id`", "#{service_pacakge_id,jdbcType=BIGINT}");
        }
        
        if (record.getReport_id() != null) {
            VALUES("`report_id`", "#{report_id,jdbcType=BIGINT}");
        }
        
        if (record.getEstimated_fee() != null) {
            VALUES("`estimated_fee`", "#{estimated_fee,jdbcType=VARCHAR}");
        }
        
        if (record.getFinal_fee() != null) {
            VALUES("`final_fee`", "#{final_fee,jdbcType=VARCHAR}");
        }
        
        if (record.getPay_id() != null) {
            VALUES("`pay_id`", "#{pay_id,jdbcType=BIGINT}");
        }
        
        if (record.getOrder_qr_code() != null) {
            VALUES("`order_qr_code`", "#{order_qr_code,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_create() != null) {
            VALUES("`gmt_create`", "#{gmt_create,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmt_confirm() != null) {
            VALUES("`gmt_confirm`", "#{gmt_confirm,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmt_service_date() != null) {
            VALUES("`gmt_service_date`", "#{gmt_service_date,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_change_service_date() != null) {
            VALUES("`gmt_change_service_date`", "#{gmt_change_service_date,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_actual_service() != null) {
            VALUES("`gmt_actual_service`", "#{gmt_actual_service,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmt_pay() != null) {
            VALUES("`gmt_pay`", "#{gmt_pay,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmt_evaluate() != null) {
            VALUES("`gmt_evaluate`", "#{gmt_evaluate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmt_modify() != null) {
            VALUES("`gmt_modify`", "#{gmt_modify,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreator_account() != null) {
            VALUES("`creator_account`", "#{creator_account,jdbcType=VARCHAR}");
        }
        
        if (record.getModifier_account() != null) {
            VALUES("`modifier_account`", "#{modifier_account,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_logo_url() != null) {
            VALUES("`car_logo_url`", "#{car_logo_url,jdbcType=VARCHAR}");
        }
        
        if (record.getEvaluate_id() != null) {
            VALUES("`evaluate_id`", "#{evaluate_id,jdbcType=BIGINT}");
        }
        
        if (record.getLongitude() != null) {
            VALUES("`longitude`", "#{longitude,jdbcType=DECIMAL}");
        }
        
        if (record.getLatitude() != null) {
            VALUES("`latitude`", "#{latitude,jdbcType=DECIMAL}");
        }
        
        if (record.getGmt_service_begin_time() != null) {
            VALUES("`gmt_service_begin_time`", "#{gmt_service_begin_time,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_service_end_time() != null) {
            VALUES("`gmt_service_end_time`", "#{gmt_service_end_time,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_change_service_end_time() != null) {
            VALUES("`gmt_change_service_end_time`", "#{gmt_change_service_end_time,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_change_service_begin_time() != null) {
            VALUES("`gmt_change_service_begin_time`", "#{gmt_change_service_begin_time,jdbcType=VARCHAR}");
        }
        
        if (record.getChild_status() != null) {
            VALUES("`child_status`", "#{child_status,jdbcType=VARCHAR}");
        }
        
        if (record.getShop_user_id() != null) {
            VALUES("`shop_user_id`", "#{shop_user_id,jdbcType=BIGINT}");
        }
        
        if (record.getShop_user_account() != null) {
            VALUES("`shop_user_account`", "#{shop_user_account,jdbcType=VARCHAR}");
        }
        
        if (record.getShop_user_name() != null) {
            VALUES("`shop_user_name`", "#{shop_user_name,jdbcType=VARCHAR}");
        }
        
        if (record.getCurr_maintenance_miles() != null) {
            VALUES("`curr_maintenance_miles`", "#{curr_maintenance_miles,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_front_photo_url() != null) {
            VALUES("`car_front_photo_url`", "#{car_front_photo_url,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_dashboard_photo_url() != null) {
            VALUES("`car_dashboard_photo_url`", "#{car_dashboard_photo_url,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_type() != null) {
            VALUES("`order_type`", "#{order_type,jdbcType=INTEGER}");
        }
        
        if (record.getVerify_remark() != null) {
            VALUES("`verify_remark`", "#{verify_remark,jdbcType=VARCHAR}");
        }
        
        if (record.getSettle() != null) {
            VALUES("`settle`", "#{settle,jdbcType=INTEGER}");
        }
        
        if (record.getSettle_amount() != null) {
            VALUES("`settle_amount`", "#{settle_amount,jdbcType=VARCHAR}");
        }
        
        if (record.getVerify_account() != null) {
            VALUES("`verify_account`", "#{verify_account,jdbcType=VARCHAR}");
        }
        
        if (record.getCard_level() != null) {
            VALUES("`card_level`", "#{card_level,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(ServiceOrderExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("`id`");
        } else {
            SELECT("`id`");
        }
        SELECT("`order_string_id`");
        SELECT("`user_id`");
        SELECT("`user_name`");
        SELECT("`car_id`");
        SELECT("`car_plate`");
        SELECT("`car_type_name`");
        SELECT("`shop_id`");
        SELECT("`shop_name`");
        SELECT("`oil_id`");
        SELECT("`oil_brand`");
        SELECT("`service_item`");
        SELECT("`order_status`");
        SELECT("`service_pacakge_id`");
        SELECT("`report_id`");
        SELECT("`estimated_fee`");
        SELECT("`final_fee`");
        SELECT("`pay_id`");
        SELECT("`order_qr_code`");
        SELECT("`gmt_create`");
        SELECT("`gmt_confirm`");
        SELECT("`gmt_service_date`");
        SELECT("`gmt_change_service_date`");
        SELECT("`gmt_actual_service`");
        SELECT("`gmt_pay`");
        SELECT("`gmt_evaluate`");
        SELECT("`gmt_modify`");
        SELECT("`creator_account`");
        SELECT("`modifier_account`");
        SELECT("`car_logo_url`");
        SELECT("`evaluate_id`");
        SELECT("`longitude`");
        SELECT("`latitude`");
        SELECT("`gmt_service_begin_time`");
        SELECT("`gmt_service_end_time`");
        SELECT("`gmt_change_service_end_time`");
        SELECT("`gmt_change_service_begin_time`");
        SELECT("`child_status`");
        SELECT("`shop_user_id`");
        SELECT("`shop_user_account`");
        SELECT("`shop_user_name`");
        SELECT("`curr_maintenance_miles`");
        SELECT("`car_front_photo_url`");
        SELECT("`car_dashboard_photo_url`");
        SELECT("`order_type`");
        SELECT("`verify_remark`");
        SELECT("`settle`");
        SELECT("`settle_amount`");
        SELECT("`verify_account`");
        SELECT("`card_level`");
        FROM("`service_order`");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        String returnValue=SQL();
        if(example != null && example.getPageIndex()!=null && example.getPageCount() != null){
            int pageCount = example.getPageCount();
            int pageStart = (example.getPageIndex() - 1)*pageCount;
            returnValue += String.format(" limit %1$d,%2$d", pageStart, pageCount);
        }
        return returnValue;
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ServiceOrder record = (ServiceOrder) parameter.get("record");
        ServiceOrderExample example = (ServiceOrderExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`service_order`");
        
        if (record.getId() != null) {
            SET("`id` = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getOrder_string_id() != null) {
            SET("`order_string_id` = #{record.order_string_id,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_id() != null) {
            SET("`user_id` = #{record.user_id,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_name() != null) {
            SET("`user_name` = #{record.user_name,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_id() != null) {
            SET("`car_id` = #{record.car_id,jdbcType=BIGINT}");
        }
        
        if (record.getCar_plate() != null) {
            SET("`car_plate` = #{record.car_plate,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_type_name() != null) {
            SET("`car_type_name` = #{record.car_type_name,jdbcType=VARCHAR}");
        }
        
        if (record.getShop_id() != null) {
            SET("`shop_id` = #{record.shop_id,jdbcType=BIGINT}");
        }
        
        if (record.getShop_name() != null) {
            SET("`shop_name` = #{record.shop_name,jdbcType=VARCHAR}");
        }
        
        if (record.getOil_id() != null) {
            SET("`oil_id` = #{record.oil_id,jdbcType=BIGINT}");
        }
        
        if (record.getOil_brand() != null) {
            SET("`oil_brand` = #{record.oil_brand,jdbcType=VARCHAR}");
        }
        
        if (record.getService_item() != null) {
            SET("`service_item` = #{record.service_item,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_status() != null) {
            SET("`order_status` = #{record.order_status,jdbcType=VARCHAR}");
        }
        
        if (record.getService_pacakge_id() != null) {
            SET("`service_pacakge_id` = #{record.service_pacakge_id,jdbcType=BIGINT}");
        }
        
        if (record.getReport_id() != null) {
            SET("`report_id` = #{record.report_id,jdbcType=BIGINT}");
        }
        
        if (record.getEstimated_fee() != null) {
            SET("`estimated_fee` = #{record.estimated_fee,jdbcType=VARCHAR}");
        }
        
        if (record.getFinal_fee() != null) {
            SET("`final_fee` = #{record.final_fee,jdbcType=VARCHAR}");
        }
        
        if (record.getPay_id() != null) {
            SET("`pay_id` = #{record.pay_id,jdbcType=BIGINT}");
        }
        
        if (record.getOrder_qr_code() != null) {
            SET("`order_qr_code` = #{record.order_qr_code,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_create() != null) {
            SET("`gmt_create` = #{record.gmt_create,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmt_confirm() != null) {
            SET("`gmt_confirm` = #{record.gmt_confirm,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmt_service_date() != null) {
            SET("`gmt_service_date` = #{record.gmt_service_date,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_change_service_date() != null) {
            SET("`gmt_change_service_date` = #{record.gmt_change_service_date,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_actual_service() != null) {
            SET("`gmt_actual_service` = #{record.gmt_actual_service,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmt_pay() != null) {
            SET("`gmt_pay` = #{record.gmt_pay,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmt_evaluate() != null) {
            SET("`gmt_evaluate` = #{record.gmt_evaluate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmt_modify() != null) {
            SET("`gmt_modify` = #{record.gmt_modify,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreator_account() != null) {
            SET("`creator_account` = #{record.creator_account,jdbcType=VARCHAR}");
        }
        
        if (record.getModifier_account() != null) {
            SET("`modifier_account` = #{record.modifier_account,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_logo_url() != null) {
            SET("`car_logo_url` = #{record.car_logo_url,jdbcType=VARCHAR}");
        }
        
        if (record.getEvaluate_id() != null) {
            SET("`evaluate_id` = #{record.evaluate_id,jdbcType=BIGINT}");
        }
        
        if (record.getLongitude() != null) {
            SET("`longitude` = #{record.longitude,jdbcType=DECIMAL}");
        }
        
        if (record.getLatitude() != null) {
            SET("`latitude` = #{record.latitude,jdbcType=DECIMAL}");
        }
        
        if (record.getGmt_service_begin_time() != null) {
            SET("`gmt_service_begin_time` = #{record.gmt_service_begin_time,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_service_end_time() != null) {
            SET("`gmt_service_end_time` = #{record.gmt_service_end_time,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_change_service_end_time() != null) {
            SET("`gmt_change_service_end_time` = #{record.gmt_change_service_end_time,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_change_service_begin_time() != null) {
            SET("`gmt_change_service_begin_time` = #{record.gmt_change_service_begin_time,jdbcType=VARCHAR}");
        }
        
        if (record.getChild_status() != null) {
            SET("`child_status` = #{record.child_status,jdbcType=VARCHAR}");
        }
        
        if (record.getShop_user_id() != null) {
            SET("`shop_user_id` = #{record.shop_user_id,jdbcType=BIGINT}");
        }
        
        if (record.getShop_user_account() != null) {
            SET("`shop_user_account` = #{record.shop_user_account,jdbcType=VARCHAR}");
        }
        
        if (record.getShop_user_name() != null) {
            SET("`shop_user_name` = #{record.shop_user_name,jdbcType=VARCHAR}");
        }
        
        if (record.getCurr_maintenance_miles() != null) {
            SET("`curr_maintenance_miles` = #{record.curr_maintenance_miles,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_front_photo_url() != null) {
            SET("`car_front_photo_url` = #{record.car_front_photo_url,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_dashboard_photo_url() != null) {
            SET("`car_dashboard_photo_url` = #{record.car_dashboard_photo_url,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_type() != null) {
            SET("`order_type` = #{record.order_type,jdbcType=INTEGER}");
        }
        
        if (record.getVerify_remark() != null) {
            SET("`verify_remark` = #{record.verify_remark,jdbcType=VARCHAR}");
        }
        
        if (record.getSettle() != null) {
            SET("`settle` = #{record.settle,jdbcType=INTEGER}");
        }
        
        if (record.getSettle_amount() != null) {
            SET("`settle_amount` = #{record.settle_amount,jdbcType=VARCHAR}");
        }
        
        if (record.getVerify_account() != null) {
            SET("`verify_account` = #{record.verify_account,jdbcType=VARCHAR}");
        }
        
        if (record.getCard_level() != null) {
            SET("`card_level` = #{record.card_level,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`service_order`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`order_string_id` = #{record.order_string_id,jdbcType=VARCHAR}");
        SET("`user_id` = #{record.user_id,jdbcType=VARCHAR}");
        SET("`user_name` = #{record.user_name,jdbcType=VARCHAR}");
        SET("`car_id` = #{record.car_id,jdbcType=BIGINT}");
        SET("`car_plate` = #{record.car_plate,jdbcType=VARCHAR}");
        SET("`car_type_name` = #{record.car_type_name,jdbcType=VARCHAR}");
        SET("`shop_id` = #{record.shop_id,jdbcType=BIGINT}");
        SET("`shop_name` = #{record.shop_name,jdbcType=VARCHAR}");
        SET("`oil_id` = #{record.oil_id,jdbcType=BIGINT}");
        SET("`oil_brand` = #{record.oil_brand,jdbcType=VARCHAR}");
        SET("`service_item` = #{record.service_item,jdbcType=VARCHAR}");
        SET("`order_status` = #{record.order_status,jdbcType=VARCHAR}");
        SET("`service_pacakge_id` = #{record.service_pacakge_id,jdbcType=BIGINT}");
        SET("`report_id` = #{record.report_id,jdbcType=BIGINT}");
        SET("`estimated_fee` = #{record.estimated_fee,jdbcType=VARCHAR}");
        SET("`final_fee` = #{record.final_fee,jdbcType=VARCHAR}");
        SET("`pay_id` = #{record.pay_id,jdbcType=BIGINT}");
        SET("`order_qr_code` = #{record.order_qr_code,jdbcType=VARCHAR}");
        SET("`gmt_create` = #{record.gmt_create,jdbcType=TIMESTAMP}");
        SET("`gmt_confirm` = #{record.gmt_confirm,jdbcType=TIMESTAMP}");
        SET("`gmt_service_date` = #{record.gmt_service_date,jdbcType=VARCHAR}");
        SET("`gmt_change_service_date` = #{record.gmt_change_service_date,jdbcType=VARCHAR}");
        SET("`gmt_actual_service` = #{record.gmt_actual_service,jdbcType=TIMESTAMP}");
        SET("`gmt_pay` = #{record.gmt_pay,jdbcType=TIMESTAMP}");
        SET("`gmt_evaluate` = #{record.gmt_evaluate,jdbcType=TIMESTAMP}");
        SET("`gmt_modify` = #{record.gmt_modify,jdbcType=TIMESTAMP}");
        SET("`creator_account` = #{record.creator_account,jdbcType=VARCHAR}");
        SET("`modifier_account` = #{record.modifier_account,jdbcType=VARCHAR}");
        SET("`car_logo_url` = #{record.car_logo_url,jdbcType=VARCHAR}");
        SET("`evaluate_id` = #{record.evaluate_id,jdbcType=BIGINT}");
        SET("`longitude` = #{record.longitude,jdbcType=DECIMAL}");
        SET("`latitude` = #{record.latitude,jdbcType=DECIMAL}");
        SET("`gmt_service_begin_time` = #{record.gmt_service_begin_time,jdbcType=VARCHAR}");
        SET("`gmt_service_end_time` = #{record.gmt_service_end_time,jdbcType=VARCHAR}");
        SET("`gmt_change_service_end_time` = #{record.gmt_change_service_end_time,jdbcType=VARCHAR}");
        SET("`gmt_change_service_begin_time` = #{record.gmt_change_service_begin_time,jdbcType=VARCHAR}");
        SET("`child_status` = #{record.child_status,jdbcType=VARCHAR}");
        SET("`shop_user_id` = #{record.shop_user_id,jdbcType=BIGINT}");
        SET("`shop_user_account` = #{record.shop_user_account,jdbcType=VARCHAR}");
        SET("`shop_user_name` = #{record.shop_user_name,jdbcType=VARCHAR}");
        SET("`curr_maintenance_miles` = #{record.curr_maintenance_miles,jdbcType=VARCHAR}");
        SET("`car_front_photo_url` = #{record.car_front_photo_url,jdbcType=VARCHAR}");
        SET("`car_dashboard_photo_url` = #{record.car_dashboard_photo_url,jdbcType=VARCHAR}");
        SET("`order_type` = #{record.order_type,jdbcType=INTEGER}");
        SET("`verify_remark` = #{record.verify_remark,jdbcType=VARCHAR}");
        SET("`settle` = #{record.settle,jdbcType=INTEGER}");
        SET("`settle_amount` = #{record.settle_amount,jdbcType=VARCHAR}");
        SET("`verify_account` = #{record.verify_account,jdbcType=VARCHAR}");
        SET("`card_level` = #{record.card_level,jdbcType=VARCHAR}");
        
        ServiceOrderExample example = (ServiceOrderExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(ServiceOrder record) {
        BEGIN();
        UPDATE("`service_order`");
        
        if (record.getOrder_string_id() != null) {
            SET("`order_string_id` = #{order_string_id,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_id() != null) {
            SET("`user_id` = #{user_id,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_name() != null) {
            SET("`user_name` = #{user_name,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_id() != null) {
            SET("`car_id` = #{car_id,jdbcType=BIGINT}");
        }
        
        if (record.getCar_plate() != null) {
            SET("`car_plate` = #{car_plate,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_type_name() != null) {
            SET("`car_type_name` = #{car_type_name,jdbcType=VARCHAR}");
        }
        
        if (record.getShop_id() != null) {
            SET("`shop_id` = #{shop_id,jdbcType=BIGINT}");
        }
        
        if (record.getShop_name() != null) {
            SET("`shop_name` = #{shop_name,jdbcType=VARCHAR}");
        }
        
        if (record.getOil_id() != null) {
            SET("`oil_id` = #{oil_id,jdbcType=BIGINT}");
        }
        
        if (record.getOil_brand() != null) {
            SET("`oil_brand` = #{oil_brand,jdbcType=VARCHAR}");
        }
        
        if (record.getService_item() != null) {
            SET("`service_item` = #{service_item,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_status() != null) {
            SET("`order_status` = #{order_status,jdbcType=VARCHAR}");
        }
        
        if (record.getService_pacakge_id() != null) {
            SET("`service_pacakge_id` = #{service_pacakge_id,jdbcType=BIGINT}");
        }
        
        if (record.getReport_id() != null) {
            SET("`report_id` = #{report_id,jdbcType=BIGINT}");
        }
        
        if (record.getEstimated_fee() != null) {
            SET("`estimated_fee` = #{estimated_fee,jdbcType=VARCHAR}");
        }
        
        if (record.getFinal_fee() != null) {
            SET("`final_fee` = #{final_fee,jdbcType=VARCHAR}");
        }
        
        if (record.getPay_id() != null) {
            SET("`pay_id` = #{pay_id,jdbcType=BIGINT}");
        }
        
        if (record.getOrder_qr_code() != null) {
            SET("`order_qr_code` = #{order_qr_code,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_create() != null) {
            SET("`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmt_confirm() != null) {
            SET("`gmt_confirm` = #{gmt_confirm,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmt_service_date() != null) {
            SET("`gmt_service_date` = #{gmt_service_date,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_change_service_date() != null) {
            SET("`gmt_change_service_date` = #{gmt_change_service_date,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_actual_service() != null) {
            SET("`gmt_actual_service` = #{gmt_actual_service,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmt_pay() != null) {
            SET("`gmt_pay` = #{gmt_pay,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmt_evaluate() != null) {
            SET("`gmt_evaluate` = #{gmt_evaluate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmt_modify() != null) {
            SET("`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreator_account() != null) {
            SET("`creator_account` = #{creator_account,jdbcType=VARCHAR}");
        }
        
        if (record.getModifier_account() != null) {
            SET("`modifier_account` = #{modifier_account,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_logo_url() != null) {
            SET("`car_logo_url` = #{car_logo_url,jdbcType=VARCHAR}");
        }
        
        if (record.getEvaluate_id() != null) {
            SET("`evaluate_id` = #{evaluate_id,jdbcType=BIGINT}");
        }
        
        if (record.getLongitude() != null) {
            SET("`longitude` = #{longitude,jdbcType=DECIMAL}");
        }
        
        if (record.getLatitude() != null) {
            SET("`latitude` = #{latitude,jdbcType=DECIMAL}");
        }
        
        if (record.getGmt_service_begin_time() != null) {
            SET("`gmt_service_begin_time` = #{gmt_service_begin_time,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_service_end_time() != null) {
            SET("`gmt_service_end_time` = #{gmt_service_end_time,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_change_service_end_time() != null) {
            SET("`gmt_change_service_end_time` = #{gmt_change_service_end_time,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_change_service_begin_time() != null) {
            SET("`gmt_change_service_begin_time` = #{gmt_change_service_begin_time,jdbcType=VARCHAR}");
        }
        
        if (record.getChild_status() != null) {
            SET("`child_status` = #{child_status,jdbcType=VARCHAR}");
        }
        
        if (record.getShop_user_id() != null) {
            SET("`shop_user_id` = #{shop_user_id,jdbcType=BIGINT}");
        }
        
        if (record.getShop_user_account() != null) {
            SET("`shop_user_account` = #{shop_user_account,jdbcType=VARCHAR}");
        }
        
        if (record.getShop_user_name() != null) {
            SET("`shop_user_name` = #{shop_user_name,jdbcType=VARCHAR}");
        }
        
        if (record.getCurr_maintenance_miles() != null) {
            SET("`curr_maintenance_miles` = #{curr_maintenance_miles,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_front_photo_url() != null) {
            SET("`car_front_photo_url` = #{car_front_photo_url,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_dashboard_photo_url() != null) {
            SET("`car_dashboard_photo_url` = #{car_dashboard_photo_url,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_type() != null) {
            SET("`order_type` = #{order_type,jdbcType=INTEGER}");
        }
        
        if (record.getVerify_remark() != null) {
            SET("`verify_remark` = #{verify_remark,jdbcType=VARCHAR}");
        }
        
        if (record.getSettle() != null) {
            SET("`settle` = #{settle,jdbcType=INTEGER}");
        }
        
        if (record.getSettle_amount() != null) {
            SET("`settle_amount` = #{settle_amount,jdbcType=VARCHAR}");
        }
        
        if (record.getVerify_account() != null) {
            SET("`verify_account` = #{verify_account,jdbcType=VARCHAR}");
        }
        
        if (record.getCard_level() != null) {
            SET("`card_level` = #{card_level,jdbcType=VARCHAR}");
        }
        
        WHERE("`id` = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(ServiceOrderExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}
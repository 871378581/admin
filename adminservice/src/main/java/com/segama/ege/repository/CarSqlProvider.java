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

import com.segama.ege.entity.Car;
import com.segama.ege.entity.CarExample.Criteria;
import com.segama.ege.entity.CarExample.Criterion;
import com.segama.ege.entity.CarExample;
import java.util.List;
import java.util.Map;

public class CarSqlProvider {

    public String countByExample(CarExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("`car`");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(CarExample example) {
        BEGIN();
        DELETE_FROM("`car`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Car record) {
        BEGIN();
        INSERT_INTO("`car`");
        
        if (record.getUser_id() != null) {
            VALUES("`user_id`", "#{user_id,jdbcType=VARCHAR}");
        }
        
        if (record.getPlate() != null) {
            VALUES("`plate`", "#{plate,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_type_id() != null) {
            VALUES("`car_type_id`", "#{car_type_id,jdbcType=BIGINT}");
        }
        
        if (record.getCar_type_name() != null) {
            VALUES("`car_type_name`", "#{car_type_name,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_type_color() != null) {
            VALUES("`car_type_color`", "#{car_type_color,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_logo_url() != null) {
            VALUES("`car_logo_url`", "#{car_logo_url,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_last_maintenance() != null) {
            VALUES("`gmt_last_maintenance`", "#{gmt_last_maintenance,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMembership_card_id() != null) {
            VALUES("`membership_card_id`", "#{membership_card_id,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_status() != null) {
            VALUES("`car_status`", "#{car_status,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_activate() != null) {
            VALUES("`gmt_activate`", "#{gmt_activate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmt_take_effect() != null) {
            VALUES("`gmt_take_effect`", "#{gmt_take_effect,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmt_lose_effect() != null) {
            VALUES("`gmt_lose_effect`", "#{gmt_lose_effect,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmt_create() != null) {
            VALUES("`gmt_create`", "#{gmt_create,jdbcType=TIMESTAMP}");
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
        
        if (record.getVersion() != null) {
            VALUES("`version`", "#{version,jdbcType=INTEGER}");
        }
        
        if (record.getIs_default() != null) {
            VALUES("`is_default`", "#{is_default,jdbcType=BIT}");
        }
        
        if (record.getColor() != null) {
            VALUES("`color`", "#{color,jdbcType=VARCHAR}");
        }
        
        if (record.getVin() != null) {
            VALUES("`vin`", "#{vin,jdbcType=VARCHAR}");
        }
        
        if (record.getCard_level() != null) {
            VALUES("`card_level`", "#{card_level,jdbcType=VARCHAR}");
        }
        
        if (record.getLast_maintenance_miles() != null) {
            VALUES("`last_maintenance_miles`", "#{last_maintenance_miles,jdbcType=VARCHAR}");
        }
        
        if (record.getNext_maintenance_miles() != null) {
            VALUES("`next_maintenance_miles`", "#{next_maintenance_miles,jdbcType=VARCHAR}");
        }
        
        if (record.getCurr_maintenance_miles() != null) {
            VALUES("`curr_maintenance_miles`", "#{curr_maintenance_miles,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_type_image() != null) {
            VALUES("`car_type_image`", "#{car_type_image,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_type_code() != null) {
            VALUES("`car_type_code`", "#{car_type_code,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_brand_code() != null) {
            VALUES("`car_brand_code`", "#{car_brand_code,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(CarExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("`id`");
        } else {
            SELECT("`id`");
        }
        SELECT("`user_id`");
        SELECT("`plate`");
        SELECT("`car_type_id`");
        SELECT("`car_type_name`");
        SELECT("`car_type_color`");
        SELECT("`car_logo_url`");
        SELECT("`gmt_last_maintenance`");
        SELECT("`membership_card_id`");
        SELECT("`car_status`");
        SELECT("`gmt_activate`");
        SELECT("`gmt_take_effect`");
        SELECT("`gmt_lose_effect`");
        SELECT("`gmt_create`");
        SELECT("`gmt_modify`");
        SELECT("`creator_account`");
        SELECT("`modifier_account`");
        SELECT("`version`");
        SELECT("`is_default`");
        SELECT("`color`");
        SELECT("`vin`");
        SELECT("`card_level`");
        SELECT("`last_maintenance_miles`");
        SELECT("`next_maintenance_miles`");
        SELECT("`curr_maintenance_miles`");
        SELECT("`car_type_image`");
        SELECT("`car_type_code`");
        SELECT("`car_brand_code`");
        FROM("`car`");
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
        Car record = (Car) parameter.get("record");
        CarExample example = (CarExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`car`");
        
        if (record.getId() != null) {
            SET("`id` = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getUser_id() != null) {
            SET("`user_id` = #{record.user_id,jdbcType=VARCHAR}");
        }
        
        if (record.getPlate() != null) {
            SET("`plate` = #{record.plate,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_type_id() != null) {
            SET("`car_type_id` = #{record.car_type_id,jdbcType=BIGINT}");
        }
        
        if (record.getCar_type_name() != null) {
            SET("`car_type_name` = #{record.car_type_name,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_type_color() != null) {
            SET("`car_type_color` = #{record.car_type_color,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_logo_url() != null) {
            SET("`car_logo_url` = #{record.car_logo_url,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_last_maintenance() != null) {
            SET("`gmt_last_maintenance` = #{record.gmt_last_maintenance,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMembership_card_id() != null) {
            SET("`membership_card_id` = #{record.membership_card_id,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_status() != null) {
            SET("`car_status` = #{record.car_status,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_activate() != null) {
            SET("`gmt_activate` = #{record.gmt_activate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmt_take_effect() != null) {
            SET("`gmt_take_effect` = #{record.gmt_take_effect,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmt_lose_effect() != null) {
            SET("`gmt_lose_effect` = #{record.gmt_lose_effect,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmt_create() != null) {
            SET("`gmt_create` = #{record.gmt_create,jdbcType=TIMESTAMP}");
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
        
        if (record.getVersion() != null) {
            SET("`version` = #{record.version,jdbcType=INTEGER}");
        }
        
        if (record.getIs_default() != null) {
            SET("`is_default` = #{record.is_default,jdbcType=BIT}");
        }
        
        if (record.getColor() != null) {
            SET("`color` = #{record.color,jdbcType=VARCHAR}");
        }
        
        if (record.getVin() != null) {
            SET("`vin` = #{record.vin,jdbcType=VARCHAR}");
        }
        
        if (record.getCard_level() != null) {
            SET("`card_level` = #{record.card_level,jdbcType=VARCHAR}");
        }
        
        if (record.getLast_maintenance_miles() != null) {
            SET("`last_maintenance_miles` = #{record.last_maintenance_miles,jdbcType=VARCHAR}");
        }
        
        if (record.getNext_maintenance_miles() != null) {
            SET("`next_maintenance_miles` = #{record.next_maintenance_miles,jdbcType=VARCHAR}");
        }
        
        if (record.getCurr_maintenance_miles() != null) {
            SET("`curr_maintenance_miles` = #{record.curr_maintenance_miles,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_type_image() != null) {
            SET("`car_type_image` = #{record.car_type_image,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_type_code() != null) {
            SET("`car_type_code` = #{record.car_type_code,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_brand_code() != null) {
            SET("`car_brand_code` = #{record.car_brand_code,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`car`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`user_id` = #{record.user_id,jdbcType=VARCHAR}");
        SET("`plate` = #{record.plate,jdbcType=VARCHAR}");
        SET("`car_type_id` = #{record.car_type_id,jdbcType=BIGINT}");
        SET("`car_type_name` = #{record.car_type_name,jdbcType=VARCHAR}");
        SET("`car_type_color` = #{record.car_type_color,jdbcType=VARCHAR}");
        SET("`car_logo_url` = #{record.car_logo_url,jdbcType=VARCHAR}");
        SET("`gmt_last_maintenance` = #{record.gmt_last_maintenance,jdbcType=TIMESTAMP}");
        SET("`membership_card_id` = #{record.membership_card_id,jdbcType=VARCHAR}");
        SET("`car_status` = #{record.car_status,jdbcType=VARCHAR}");
        SET("`gmt_activate` = #{record.gmt_activate,jdbcType=TIMESTAMP}");
        SET("`gmt_take_effect` = #{record.gmt_take_effect,jdbcType=TIMESTAMP}");
        SET("`gmt_lose_effect` = #{record.gmt_lose_effect,jdbcType=TIMESTAMP}");
        SET("`gmt_create` = #{record.gmt_create,jdbcType=TIMESTAMP}");
        SET("`gmt_modify` = #{record.gmt_modify,jdbcType=TIMESTAMP}");
        SET("`creator_account` = #{record.creator_account,jdbcType=VARCHAR}");
        SET("`modifier_account` = #{record.modifier_account,jdbcType=VARCHAR}");
        SET("`version` = #{record.version,jdbcType=INTEGER}");
        SET("`is_default` = #{record.is_default,jdbcType=BIT}");
        SET("`color` = #{record.color,jdbcType=VARCHAR}");
        SET("`vin` = #{record.vin,jdbcType=VARCHAR}");
        SET("`card_level` = #{record.card_level,jdbcType=VARCHAR}");
        SET("`last_maintenance_miles` = #{record.last_maintenance_miles,jdbcType=VARCHAR}");
        SET("`next_maintenance_miles` = #{record.next_maintenance_miles,jdbcType=VARCHAR}");
        SET("`curr_maintenance_miles` = #{record.curr_maintenance_miles,jdbcType=VARCHAR}");
        SET("`car_type_image` = #{record.car_type_image,jdbcType=VARCHAR}");
        SET("`car_type_code` = #{record.car_type_code,jdbcType=VARCHAR}");
        SET("`car_brand_code` = #{record.car_brand_code,jdbcType=VARCHAR}");
        
        CarExample example = (CarExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Car record) {
        BEGIN();
        UPDATE("`car`");
        
        if (record.getUser_id() != null) {
            SET("`user_id` = #{user_id,jdbcType=VARCHAR}");
        }
        
        if (record.getPlate() != null) {
            SET("`plate` = #{plate,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_type_id() != null) {
            SET("`car_type_id` = #{car_type_id,jdbcType=BIGINT}");
        }
        
        if (record.getCar_type_name() != null) {
            SET("`car_type_name` = #{car_type_name,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_type_color() != null) {
            SET("`car_type_color` = #{car_type_color,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_logo_url() != null) {
            SET("`car_logo_url` = #{car_logo_url,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_last_maintenance() != null) {
            SET("`gmt_last_maintenance` = #{gmt_last_maintenance,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMembership_card_id() != null) {
            SET("`membership_card_id` = #{membership_card_id,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_status() != null) {
            SET("`car_status` = #{car_status,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_activate() != null) {
            SET("`gmt_activate` = #{gmt_activate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmt_take_effect() != null) {
            SET("`gmt_take_effect` = #{gmt_take_effect,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmt_lose_effect() != null) {
            SET("`gmt_lose_effect` = #{gmt_lose_effect,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmt_create() != null) {
            SET("`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP}");
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
        
        if (record.getVersion() != null) {
            SET("`version` = #{version,jdbcType=INTEGER}");
        }
        
        if (record.getIs_default() != null) {
            SET("`is_default` = #{is_default,jdbcType=BIT}");
        }
        
        if (record.getColor() != null) {
            SET("`color` = #{color,jdbcType=VARCHAR}");
        }
        
        if (record.getVin() != null) {
            SET("`vin` = #{vin,jdbcType=VARCHAR}");
        }
        
        if (record.getCard_level() != null) {
            SET("`card_level` = #{card_level,jdbcType=VARCHAR}");
        }
        
        if (record.getLast_maintenance_miles() != null) {
            SET("`last_maintenance_miles` = #{last_maintenance_miles,jdbcType=VARCHAR}");
        }
        
        if (record.getNext_maintenance_miles() != null) {
            SET("`next_maintenance_miles` = #{next_maintenance_miles,jdbcType=VARCHAR}");
        }
        
        if (record.getCurr_maintenance_miles() != null) {
            SET("`curr_maintenance_miles` = #{curr_maintenance_miles,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_type_image() != null) {
            SET("`car_type_image` = #{car_type_image,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_type_code() != null) {
            SET("`car_type_code` = #{car_type_code,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_brand_code() != null) {
            SET("`car_brand_code` = #{car_brand_code,jdbcType=VARCHAR}");
        }
        
        WHERE("`id` = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(CarExample example, boolean includeExamplePhrase) {
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
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

import com.segama.ege.entity.Shop;
import com.segama.ege.entity.ShopExample.Criteria;
import com.segama.ege.entity.ShopExample.Criterion;
import com.segama.ege.entity.ShopExample;
import java.util.List;
import java.util.Map;

public class ShopSqlProvider {

    public String countByExample(ShopExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("`shop`");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ShopExample example) {
        BEGIN();
        DELETE_FROM("`shop`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(Shop record) {
        BEGIN();
        INSERT_INTO("`shop`");
        
        if (record.getEnterprise_name() != null) {
            VALUES("`enterprise_name`", "#{enterprise_name,jdbcType=VARCHAR}");
        }
        
        if (record.getPerson_liable_name() != null) {
            VALUES("`person_liable_name`", "#{person_liable_name,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            VALUES("`phone`", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            VALUES("`mobile`", "#{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            VALUES("`address`", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getBusiness_license_img_url() != null) {
            VALUES("`business_license_img_url`", "#{business_license_img_url,jdbcType=VARCHAR}");
        }
        
        if (record.getDoor_img_url() != null) {
            VALUES("`door_img_url`", "#{door_img_url,jdbcType=VARCHAR}");
        }
        
        if (record.getLogo_img_url() != null) {
            VALUES("`logo_img_url`", "#{logo_img_url,jdbcType=VARCHAR}");
        }
        
        if (record.getIntroduce() != null) {
            VALUES("`introduce`", "#{introduce,jdbcType=VARCHAR}");
        }
        
        if (record.getService() != null) {
            VALUES("`service`", "#{service,jdbcType=VARCHAR}");
        }
        
        if (record.getScore() != null) {
            VALUES("`score`", "#{score,jdbcType=VARCHAR}");
        }
        
        if (record.getIs_disable() != null) {
            VALUES("`is_disable`", "#{is_disable,jdbcType=BIT}");
        }
        
        if (record.getWorkstation_num() != null) {
            VALUES("`workstation_num`", "#{workstation_num,jdbcType=BIGINT}");
        }
        
        if (record.getBusiness_hour_start() != null) {
            VALUES("`business_hour_start`", "#{business_hour_start,jdbcType=VARCHAR}");
        }
        
        if (record.getBusiness_hour_end() != null) {
            VALUES("`business_hour_end`", "#{business_hour_end,jdbcType=VARCHAR}");
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
        
        if (record.getLongitude() != null) {
            VALUES("`longitude`", "#{longitude,jdbcType=DECIMAL}");
        }
        
        if (record.getLatitude() != null) {
            VALUES("`latitude`", "#{latitude,jdbcType=DECIMAL}");
        }
        
        if (record.getVersion() != null) {
            VALUES("`version`", "#{version,jdbcType=INTEGER}");
        }
        
        if (record.getIs_recommend() != null) {
            VALUES("`is_recommend`", "#{is_recommend,jdbcType=BIT}");
        }
        
        if (record.getGmt_recommend() != null) {
            VALUES("`gmt_recommend`", "#{gmt_recommend,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDisable_reason() != null) {
            VALUES("`disable_reason`", "#{disable_reason,jdbcType=VARCHAR}");
        }
        
        if (record.getDisable_days() != null) {
            VALUES("`disable_days`", "#{disable_days,jdbcType=INTEGER}");
        }
        
        if (record.getSmall_img_url() != null) {
            VALUES("`small_img_url`", "#{small_img_url,jdbcType=VARCHAR}");
        }
        
        if (record.getMiles_last_maintenance() != null) {
            VALUES("`miles_last_maintenance`", "#{miles_last_maintenance,jdbcType=VARCHAR}");
        }
        
        if (record.getCapital_account_id() != null) {
            VALUES("`capital_account_id`", "#{capital_account_id,jdbcType=BIGINT}");
        }
        
        if (record.getCapital_account_str() != null) {
            VALUES("`capital_account_str`", "#{capital_account_str,jdbcType=VARCHAR}");
        }
        
        if (record.getEvaluate_tags() != null) {
            VALUES("`evaluate_tags`", "#{evaluate_tags,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(ShopExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("`id`");
        } else {
            SELECT("`id`");
        }
        SELECT("`enterprise_name`");
        SELECT("`person_liable_name`");
        SELECT("`phone`");
        SELECT("`mobile`");
        SELECT("`address`");
        SELECT("`business_license_img_url`");
        SELECT("`door_img_url`");
        SELECT("`logo_img_url`");
        SELECT("`introduce`");
        SELECT("`service`");
        SELECT("`score`");
        SELECT("`is_disable`");
        SELECT("`workstation_num`");
        SELECT("`business_hour_start`");
        SELECT("`business_hour_end`");
        SELECT("`gmt_create`");
        SELECT("`gmt_modify`");
        SELECT("`creator_account`");
        SELECT("`modifier_account`");
        SELECT("`longitude`");
        SELECT("`latitude`");
        SELECT("`version`");
        SELECT("`is_recommend`");
        SELECT("`gmt_recommend`");
        SELECT("`disable_reason`");
        SELECT("`disable_days`");
        SELECT("`small_img_url`");
        SELECT("`miles_last_maintenance`");
        SELECT("`capital_account_id`");
        SELECT("`capital_account_str`");
        SELECT("`evaluate_tags`");
        FROM("`shop`");
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
        Shop record = (Shop) parameter.get("record");
        ShopExample example = (ShopExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`shop`");
        
        if (record.getId() != null) {
            SET("`id` = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getEnterprise_name() != null) {
            SET("`enterprise_name` = #{record.enterprise_name,jdbcType=VARCHAR}");
        }
        
        if (record.getPerson_liable_name() != null) {
            SET("`person_liable_name` = #{record.person_liable_name,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            SET("`phone` = #{record.phone,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            SET("`mobile` = #{record.mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            SET("`address` = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getBusiness_license_img_url() != null) {
            SET("`business_license_img_url` = #{record.business_license_img_url,jdbcType=VARCHAR}");
        }
        
        if (record.getDoor_img_url() != null) {
            SET("`door_img_url` = #{record.door_img_url,jdbcType=VARCHAR}");
        }
        
        if (record.getLogo_img_url() != null) {
            SET("`logo_img_url` = #{record.logo_img_url,jdbcType=VARCHAR}");
        }
        
        if (record.getIntroduce() != null) {
            SET("`introduce` = #{record.introduce,jdbcType=VARCHAR}");
        }
        
        if (record.getService() != null) {
            SET("`service` = #{record.service,jdbcType=VARCHAR}");
        }
        
        if (record.getScore() != null) {
            SET("`score` = #{record.score,jdbcType=VARCHAR}");
        }
        
        if (record.getIs_disable() != null) {
            SET("`is_disable` = #{record.is_disable,jdbcType=BIT}");
        }
        
        if (record.getWorkstation_num() != null) {
            SET("`workstation_num` = #{record.workstation_num,jdbcType=BIGINT}");
        }
        
        if (record.getBusiness_hour_start() != null) {
            SET("`business_hour_start` = #{record.business_hour_start,jdbcType=VARCHAR}");
        }
        
        if (record.getBusiness_hour_end() != null) {
            SET("`business_hour_end` = #{record.business_hour_end,jdbcType=VARCHAR}");
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
        
        if (record.getLongitude() != null) {
            SET("`longitude` = #{record.longitude,jdbcType=DECIMAL}");
        }
        
        if (record.getLatitude() != null) {
            SET("`latitude` = #{record.latitude,jdbcType=DECIMAL}");
        }
        
        if (record.getVersion() != null) {
            SET("`version` = #{record.version,jdbcType=INTEGER}");
        }
        
        if (record.getIs_recommend() != null) {
            SET("`is_recommend` = #{record.is_recommend,jdbcType=BIT}");
        }
        
        if (record.getGmt_recommend() != null) {
            SET("`gmt_recommend` = #{record.gmt_recommend,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDisable_reason() != null) {
            SET("`disable_reason` = #{record.disable_reason,jdbcType=VARCHAR}");
        }
        
        if (record.getDisable_days() != null) {
            SET("`disable_days` = #{record.disable_days,jdbcType=INTEGER}");
        }
        
        if (record.getSmall_img_url() != null) {
            SET("`small_img_url` = #{record.small_img_url,jdbcType=VARCHAR}");
        }
        
        if (record.getMiles_last_maintenance() != null) {
            SET("`miles_last_maintenance` = #{record.miles_last_maintenance,jdbcType=VARCHAR}");
        }
        
        if (record.getCapital_account_id() != null) {
            SET("`capital_account_id` = #{record.capital_account_id,jdbcType=BIGINT}");
        }
        
        if (record.getCapital_account_str() != null) {
            SET("`capital_account_str` = #{record.capital_account_str,jdbcType=VARCHAR}");
        }
        
        if (record.getEvaluate_tags() != null) {
            SET("`evaluate_tags` = #{record.evaluate_tags,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`shop`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`enterprise_name` = #{record.enterprise_name,jdbcType=VARCHAR}");
        SET("`person_liable_name` = #{record.person_liable_name,jdbcType=VARCHAR}");
        SET("`phone` = #{record.phone,jdbcType=VARCHAR}");
        SET("`mobile` = #{record.mobile,jdbcType=VARCHAR}");
        SET("`address` = #{record.address,jdbcType=VARCHAR}");
        SET("`business_license_img_url` = #{record.business_license_img_url,jdbcType=VARCHAR}");
        SET("`door_img_url` = #{record.door_img_url,jdbcType=VARCHAR}");
        SET("`logo_img_url` = #{record.logo_img_url,jdbcType=VARCHAR}");
        SET("`introduce` = #{record.introduce,jdbcType=VARCHAR}");
        SET("`service` = #{record.service,jdbcType=VARCHAR}");
        SET("`score` = #{record.score,jdbcType=VARCHAR}");
        SET("`is_disable` = #{record.is_disable,jdbcType=BIT}");
        SET("`workstation_num` = #{record.workstation_num,jdbcType=BIGINT}");
        SET("`business_hour_start` = #{record.business_hour_start,jdbcType=VARCHAR}");
        SET("`business_hour_end` = #{record.business_hour_end,jdbcType=VARCHAR}");
        SET("`gmt_create` = #{record.gmt_create,jdbcType=TIMESTAMP}");
        SET("`gmt_modify` = #{record.gmt_modify,jdbcType=TIMESTAMP}");
        SET("`creator_account` = #{record.creator_account,jdbcType=VARCHAR}");
        SET("`modifier_account` = #{record.modifier_account,jdbcType=VARCHAR}");
        SET("`longitude` = #{record.longitude,jdbcType=DECIMAL}");
        SET("`latitude` = #{record.latitude,jdbcType=DECIMAL}");
        SET("`version` = #{record.version,jdbcType=INTEGER}");
        SET("`is_recommend` = #{record.is_recommend,jdbcType=BIT}");
        SET("`gmt_recommend` = #{record.gmt_recommend,jdbcType=TIMESTAMP}");
        SET("`disable_reason` = #{record.disable_reason,jdbcType=VARCHAR}");
        SET("`disable_days` = #{record.disable_days,jdbcType=INTEGER}");
        SET("`small_img_url` = #{record.small_img_url,jdbcType=VARCHAR}");
        SET("`miles_last_maintenance` = #{record.miles_last_maintenance,jdbcType=VARCHAR}");
        SET("`capital_account_id` = #{record.capital_account_id,jdbcType=BIGINT}");
        SET("`capital_account_str` = #{record.capital_account_str,jdbcType=VARCHAR}");
        SET("`evaluate_tags` = #{record.evaluate_tags,jdbcType=VARCHAR}");
        
        ShopExample example = (ShopExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(Shop record) {
        BEGIN();
        UPDATE("`shop`");
        
        if (record.getEnterprise_name() != null) {
            SET("`enterprise_name` = #{enterprise_name,jdbcType=VARCHAR}");
        }
        
        if (record.getPerson_liable_name() != null) {
            SET("`person_liable_name` = #{person_liable_name,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            SET("`phone` = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            SET("`mobile` = #{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            SET("`address` = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getBusiness_license_img_url() != null) {
            SET("`business_license_img_url` = #{business_license_img_url,jdbcType=VARCHAR}");
        }
        
        if (record.getDoor_img_url() != null) {
            SET("`door_img_url` = #{door_img_url,jdbcType=VARCHAR}");
        }
        
        if (record.getLogo_img_url() != null) {
            SET("`logo_img_url` = #{logo_img_url,jdbcType=VARCHAR}");
        }
        
        if (record.getIntroduce() != null) {
            SET("`introduce` = #{introduce,jdbcType=VARCHAR}");
        }
        
        if (record.getService() != null) {
            SET("`service` = #{service,jdbcType=VARCHAR}");
        }
        
        if (record.getScore() != null) {
            SET("`score` = #{score,jdbcType=VARCHAR}");
        }
        
        if (record.getIs_disable() != null) {
            SET("`is_disable` = #{is_disable,jdbcType=BIT}");
        }
        
        if (record.getWorkstation_num() != null) {
            SET("`workstation_num` = #{workstation_num,jdbcType=BIGINT}");
        }
        
        if (record.getBusiness_hour_start() != null) {
            SET("`business_hour_start` = #{business_hour_start,jdbcType=VARCHAR}");
        }
        
        if (record.getBusiness_hour_end() != null) {
            SET("`business_hour_end` = #{business_hour_end,jdbcType=VARCHAR}");
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
        
        if (record.getLongitude() != null) {
            SET("`longitude` = #{longitude,jdbcType=DECIMAL}");
        }
        
        if (record.getLatitude() != null) {
            SET("`latitude` = #{latitude,jdbcType=DECIMAL}");
        }
        
        if (record.getVersion() != null) {
            SET("`version` = #{version,jdbcType=INTEGER}");
        }
        
        if (record.getIs_recommend() != null) {
            SET("`is_recommend` = #{is_recommend,jdbcType=BIT}");
        }
        
        if (record.getGmt_recommend() != null) {
            SET("`gmt_recommend` = #{gmt_recommend,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDisable_reason() != null) {
            SET("`disable_reason` = #{disable_reason,jdbcType=VARCHAR}");
        }
        
        if (record.getDisable_days() != null) {
            SET("`disable_days` = #{disable_days,jdbcType=INTEGER}");
        }
        
        if (record.getSmall_img_url() != null) {
            SET("`small_img_url` = #{small_img_url,jdbcType=VARCHAR}");
        }
        
        if (record.getMiles_last_maintenance() != null) {
            SET("`miles_last_maintenance` = #{miles_last_maintenance,jdbcType=VARCHAR}");
        }
        
        if (record.getCapital_account_id() != null) {
            SET("`capital_account_id` = #{capital_account_id,jdbcType=BIGINT}");
        }
        
        if (record.getCapital_account_str() != null) {
            SET("`capital_account_str` = #{capital_account_str,jdbcType=VARCHAR}");
        }
        
        if (record.getEvaluate_tags() != null) {
            SET("`evaluate_tags` = #{evaluate_tags,jdbcType=VARCHAR}");
        }
        
        WHERE("`id` = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(ShopExample example, boolean includeExamplePhrase) {
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
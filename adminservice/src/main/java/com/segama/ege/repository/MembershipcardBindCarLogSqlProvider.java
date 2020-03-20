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

import com.segama.ege.entity.MembershipcardBindCarLog;
import com.segama.ege.entity.MembershipcardBindCarLogExample.Criteria;
import com.segama.ege.entity.MembershipcardBindCarLogExample.Criterion;
import com.segama.ege.entity.MembershipcardBindCarLogExample;
import java.util.List;
import java.util.Map;

public class MembershipcardBindCarLogSqlProvider {

    public String countByExample(MembershipcardBindCarLogExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("`membershipCard_bind_car_log`");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(MembershipcardBindCarLogExample example) {
        BEGIN();
        DELETE_FROM("`membershipCard_bind_car_log`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(MembershipcardBindCarLog record) {
        BEGIN();
        INSERT_INTO("`membershipCard_bind_car_log`");
        
        if (record.getUser_id() != null) {
            VALUES("`user_id`", "#{user_id,jdbcType=VARCHAR}");
        }
        
        if (record.getPlate() != null) {
            VALUES("`plate`", "#{plate,jdbcType=VARCHAR}");
        }
        
        if (record.getMembership_card_id() != null) {
            VALUES("`membership_card_id`", "#{membership_card_id,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("`status`", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_bind() != null) {
            VALUES("`gmt_bind`", "#{gmt_bind,jdbcType=TIMESTAMP}");
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
        
        return SQL();
    }

    public String selectByExample(MembershipcardBindCarLogExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("`id`");
        } else {
            SELECT("`id`");
        }
        SELECT("`user_id`");
        SELECT("`plate`");
        SELECT("`membership_card_id`");
        SELECT("`status`");
        SELECT("`gmt_bind`");
        SELECT("`gmt_activate`");
        SELECT("`gmt_take_effect`");
        SELECT("`gmt_lose_effect`");
        SELECT("`gmt_create`");
        SELECT("`gmt_modify`");
        SELECT("`creator_account`");
        SELECT("`modifier_account`");
        SELECT("`version`");
        FROM("`membershipCard_bind_car_log`");
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
        MembershipcardBindCarLog record = (MembershipcardBindCarLog) parameter.get("record");
        MembershipcardBindCarLogExample example = (MembershipcardBindCarLogExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`membershipCard_bind_car_log`");
        
        if (record.getId() != null) {
            SET("`id` = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getUser_id() != null) {
            SET("`user_id` = #{record.user_id,jdbcType=VARCHAR}");
        }
        
        if (record.getPlate() != null) {
            SET("`plate` = #{record.plate,jdbcType=VARCHAR}");
        }
        
        if (record.getMembership_card_id() != null) {
            SET("`membership_card_id` = #{record.membership_card_id,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("`status` = #{record.status,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_bind() != null) {
            SET("`gmt_bind` = #{record.gmt_bind,jdbcType=TIMESTAMP}");
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
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`membershipCard_bind_car_log`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`user_id` = #{record.user_id,jdbcType=VARCHAR}");
        SET("`plate` = #{record.plate,jdbcType=VARCHAR}");
        SET("`membership_card_id` = #{record.membership_card_id,jdbcType=VARCHAR}");
        SET("`status` = #{record.status,jdbcType=VARCHAR}");
        SET("`gmt_bind` = #{record.gmt_bind,jdbcType=TIMESTAMP}");
        SET("`gmt_activate` = #{record.gmt_activate,jdbcType=TIMESTAMP}");
        SET("`gmt_take_effect` = #{record.gmt_take_effect,jdbcType=TIMESTAMP}");
        SET("`gmt_lose_effect` = #{record.gmt_lose_effect,jdbcType=TIMESTAMP}");
        SET("`gmt_create` = #{record.gmt_create,jdbcType=TIMESTAMP}");
        SET("`gmt_modify` = #{record.gmt_modify,jdbcType=TIMESTAMP}");
        SET("`creator_account` = #{record.creator_account,jdbcType=VARCHAR}");
        SET("`modifier_account` = #{record.modifier_account,jdbcType=VARCHAR}");
        SET("`version` = #{record.version,jdbcType=INTEGER}");
        
        MembershipcardBindCarLogExample example = (MembershipcardBindCarLogExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(MembershipcardBindCarLog record) {
        BEGIN();
        UPDATE("`membershipCard_bind_car_log`");
        
        if (record.getUser_id() != null) {
            SET("`user_id` = #{user_id,jdbcType=VARCHAR}");
        }
        
        if (record.getPlate() != null) {
            SET("`plate` = #{plate,jdbcType=VARCHAR}");
        }
        
        if (record.getMembership_card_id() != null) {
            SET("`membership_card_id` = #{membership_card_id,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("`status` = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_bind() != null) {
            SET("`gmt_bind` = #{gmt_bind,jdbcType=TIMESTAMP}");
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
        
        WHERE("`id` = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(MembershipcardBindCarLogExample example, boolean includeExamplePhrase) {
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
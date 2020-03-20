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

import com.segama.ege.entity.MembershipCard;
import com.segama.ege.entity.MembershipCardExample.Criteria;
import com.segama.ege.entity.MembershipCardExample.Criterion;
import com.segama.ege.entity.MembershipCardExample;
import java.util.List;
import java.util.Map;

public class MembershipCardSqlProvider {

    public String countByExample(MembershipCardExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("`membership_card`");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(MembershipCardExample example) {
        BEGIN();
        DELETE_FROM("`membership_card`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(MembershipCard record) {
        BEGIN();
        INSERT_INTO("`membership_card`");
        
        if (record.getCard_id() != null) {
            VALUES("`card_id`", "#{card_id,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            VALUES("`password`", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getBatch_num() != null) {
            VALUES("`batch_num`", "#{batch_num,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("`status`", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getEffective_days() != null) {
            VALUES("`effective_days`", "#{effective_days,jdbcType=INTEGER}");
        }
        
        if (record.getEffective_date() != null) {
            VALUES("`effective_date`", "#{effective_date,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExpire_date() != null) {
            VALUES("`expire_date`", "#{expire_date,jdbcType=TIMESTAMP}");
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
        
        if (record.getTake_effect_type() != null) {
            VALUES("`take_effect_type`", "#{take_effect_type,jdbcType=VARCHAR}");
        }
        
        if (record.getCard_level() != null) {
            VALUES("`card_level`", "#{card_level,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(MembershipCardExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("`id`");
        } else {
            SELECT("`id`");
        }
        SELECT("`card_id`");
        SELECT("`password`");
        SELECT("`batch_num`");
        SELECT("`status`");
        SELECT("`effective_days`");
        SELECT("`effective_date`");
        SELECT("`expire_date`");
        SELECT("`gmt_create`");
        SELECT("`gmt_modify`");
        SELECT("`creator_account`");
        SELECT("`modifier_account`");
        SELECT("`take_effect_type`");
        SELECT("`card_level`");
        FROM("`membership_card`");
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
        MembershipCard record = (MembershipCard) parameter.get("record");
        MembershipCardExample example = (MembershipCardExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`membership_card`");
        
        if (record.getId() != null) {
            SET("`id` = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getCard_id() != null) {
            SET("`card_id` = #{record.card_id,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            SET("`password` = #{record.password,jdbcType=VARCHAR}");
        }
        
        if (record.getBatch_num() != null) {
            SET("`batch_num` = #{record.batch_num,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("`status` = #{record.status,jdbcType=VARCHAR}");
        }
        
        if (record.getEffective_days() != null) {
            SET("`effective_days` = #{record.effective_days,jdbcType=INTEGER}");
        }
        
        if (record.getEffective_date() != null) {
            SET("`effective_date` = #{record.effective_date,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExpire_date() != null) {
            SET("`expire_date` = #{record.expire_date,jdbcType=TIMESTAMP}");
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
        
        if (record.getTake_effect_type() != null) {
            SET("`take_effect_type` = #{record.take_effect_type,jdbcType=VARCHAR}");
        }
        
        if (record.getCard_level() != null) {
            SET("`card_level` = #{record.card_level,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`membership_card`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`card_id` = #{record.card_id,jdbcType=VARCHAR}");
        SET("`password` = #{record.password,jdbcType=VARCHAR}");
        SET("`batch_num` = #{record.batch_num,jdbcType=VARCHAR}");
        SET("`status` = #{record.status,jdbcType=VARCHAR}");
        SET("`effective_days` = #{record.effective_days,jdbcType=INTEGER}");
        SET("`effective_date` = #{record.effective_date,jdbcType=TIMESTAMP}");
        SET("`expire_date` = #{record.expire_date,jdbcType=TIMESTAMP}");
        SET("`gmt_create` = #{record.gmt_create,jdbcType=TIMESTAMP}");
        SET("`gmt_modify` = #{record.gmt_modify,jdbcType=TIMESTAMP}");
        SET("`creator_account` = #{record.creator_account,jdbcType=VARCHAR}");
        SET("`modifier_account` = #{record.modifier_account,jdbcType=VARCHAR}");
        SET("`take_effect_type` = #{record.take_effect_type,jdbcType=VARCHAR}");
        SET("`card_level` = #{record.card_level,jdbcType=VARCHAR}");
        
        MembershipCardExample example = (MembershipCardExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(MembershipCard record) {
        BEGIN();
        UPDATE("`membership_card`");
        
        if (record.getCard_id() != null) {
            SET("`card_id` = #{card_id,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            SET("`password` = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getBatch_num() != null) {
            SET("`batch_num` = #{batch_num,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("`status` = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getEffective_days() != null) {
            SET("`effective_days` = #{effective_days,jdbcType=INTEGER}");
        }
        
        if (record.getEffective_date() != null) {
            SET("`effective_date` = #{effective_date,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExpire_date() != null) {
            SET("`expire_date` = #{expire_date,jdbcType=TIMESTAMP}");
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
        
        if (record.getTake_effect_type() != null) {
            SET("`take_effect_type` = #{take_effect_type,jdbcType=VARCHAR}");
        }
        
        if (record.getCard_level() != null) {
            SET("`card_level` = #{card_level,jdbcType=VARCHAR}");
        }
        
        WHERE("`id` = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(MembershipCardExample example, boolean includeExamplePhrase) {
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
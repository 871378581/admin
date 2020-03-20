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

import com.segama.ege.entity.ShopEvaluateDetail;
import com.segama.ege.entity.ShopEvaluateDetailExample.Criteria;
import com.segama.ege.entity.ShopEvaluateDetailExample.Criterion;
import com.segama.ege.entity.ShopEvaluateDetailExample;
import java.util.List;
import java.util.Map;

public class ShopEvaluateDetailSqlProvider {

    public String countByExample(ShopEvaluateDetailExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("`shop_evaluate_detail`");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ShopEvaluateDetailExample example) {
        BEGIN();
        DELETE_FROM("`shop_evaluate_detail`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(ShopEvaluateDetail record) {
        BEGIN();
        INSERT_INTO("`shop_evaluate_detail`");
        
        if (record.getUser_id() != null) {
            VALUES("`user_id`", "#{user_id,jdbcType=VARCHAR}");
        }
        
        if (record.getNick_name() != null) {
            VALUES("`nick_name`", "#{nick_name,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_type() != null) {
            VALUES("`car_type`", "#{car_type,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_repair() != null) {
            VALUES("`gmt_repair`", "#{gmt_repair,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEvaluate_score() != null) {
            VALUES("`evaluate_score`", "#{evaluate_score,jdbcType=VARCHAR}");
        }
        
        if (record.getEvaluate_content() != null) {
            VALUES("`evaluate_content`", "#{evaluate_content,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_evaluate_commit() != null) {
            VALUES("`gmt_evaluate_commit`", "#{gmt_evaluate_commit,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIs_invalid() != null) {
            VALUES("`is_invalid`", "#{is_invalid,jdbcType=BIT}");
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
        
        if (record.getShop_id() != null) {
            VALUES("`shop_id`", "#{shop_id,jdbcType=BIGINT}");
        }
        
        if (record.getVersion() != null) {
            VALUES("`version`", "#{version,jdbcType=INTEGER}");
        }
        
        if (record.getOrder_id() != null) {
            VALUES("`order_id`", "#{order_id,jdbcType=BIGINT}");
        }
        
        if (record.getUser_head() != null) {
            VALUES("`user_head`", "#{user_head,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(ShopEvaluateDetailExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("`id`");
        } else {
            SELECT("`id`");
        }
        SELECT("`user_id`");
        SELECT("`nick_name`");
        SELECT("`car_type`");
        SELECT("`gmt_repair`");
        SELECT("`evaluate_score`");
        SELECT("`evaluate_content`");
        SELECT("`gmt_evaluate_commit`");
        SELECT("`is_invalid`");
        SELECT("`gmt_create`");
        SELECT("`gmt_modify`");
        SELECT("`creator_account`");
        SELECT("`modifier_account`");
        SELECT("`shop_id`");
        SELECT("`version`");
        SELECT("`order_id`");
        SELECT("`user_head`");
        FROM("`shop_evaluate_detail`");
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
        ShopEvaluateDetail record = (ShopEvaluateDetail) parameter.get("record");
        ShopEvaluateDetailExample example = (ShopEvaluateDetailExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`shop_evaluate_detail`");
        
        if (record.getId() != null) {
            SET("`id` = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getUser_id() != null) {
            SET("`user_id` = #{record.user_id,jdbcType=VARCHAR}");
        }
        
        if (record.getNick_name() != null) {
            SET("`nick_name` = #{record.nick_name,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_type() != null) {
            SET("`car_type` = #{record.car_type,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_repair() != null) {
            SET("`gmt_repair` = #{record.gmt_repair,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEvaluate_score() != null) {
            SET("`evaluate_score` = #{record.evaluate_score,jdbcType=VARCHAR}");
        }
        
        if (record.getEvaluate_content() != null) {
            SET("`evaluate_content` = #{record.evaluate_content,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_evaluate_commit() != null) {
            SET("`gmt_evaluate_commit` = #{record.gmt_evaluate_commit,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIs_invalid() != null) {
            SET("`is_invalid` = #{record.is_invalid,jdbcType=BIT}");
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
        
        if (record.getShop_id() != null) {
            SET("`shop_id` = #{record.shop_id,jdbcType=BIGINT}");
        }
        
        if (record.getVersion() != null) {
            SET("`version` = #{record.version,jdbcType=INTEGER}");
        }
        
        if (record.getOrder_id() != null) {
            SET("`order_id` = #{record.order_id,jdbcType=BIGINT}");
        }
        
        if (record.getUser_head() != null) {
            SET("`user_head` = #{record.user_head,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`shop_evaluate_detail`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`user_id` = #{record.user_id,jdbcType=VARCHAR}");
        SET("`nick_name` = #{record.nick_name,jdbcType=VARCHAR}");
        SET("`car_type` = #{record.car_type,jdbcType=VARCHAR}");
        SET("`gmt_repair` = #{record.gmt_repair,jdbcType=TIMESTAMP}");
        SET("`evaluate_score` = #{record.evaluate_score,jdbcType=VARCHAR}");
        SET("`evaluate_content` = #{record.evaluate_content,jdbcType=VARCHAR}");
        SET("`gmt_evaluate_commit` = #{record.gmt_evaluate_commit,jdbcType=TIMESTAMP}");
        SET("`is_invalid` = #{record.is_invalid,jdbcType=BIT}");
        SET("`gmt_create` = #{record.gmt_create,jdbcType=TIMESTAMP}");
        SET("`gmt_modify` = #{record.gmt_modify,jdbcType=TIMESTAMP}");
        SET("`creator_account` = #{record.creator_account,jdbcType=VARCHAR}");
        SET("`modifier_account` = #{record.modifier_account,jdbcType=VARCHAR}");
        SET("`shop_id` = #{record.shop_id,jdbcType=BIGINT}");
        SET("`version` = #{record.version,jdbcType=INTEGER}");
        SET("`order_id` = #{record.order_id,jdbcType=BIGINT}");
        SET("`user_head` = #{record.user_head,jdbcType=VARCHAR}");
        
        ShopEvaluateDetailExample example = (ShopEvaluateDetailExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(ShopEvaluateDetail record) {
        BEGIN();
        UPDATE("`shop_evaluate_detail`");
        
        if (record.getUser_id() != null) {
            SET("`user_id` = #{user_id,jdbcType=VARCHAR}");
        }
        
        if (record.getNick_name() != null) {
            SET("`nick_name` = #{nick_name,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_type() != null) {
            SET("`car_type` = #{car_type,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_repair() != null) {
            SET("`gmt_repair` = #{gmt_repair,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEvaluate_score() != null) {
            SET("`evaluate_score` = #{evaluate_score,jdbcType=VARCHAR}");
        }
        
        if (record.getEvaluate_content() != null) {
            SET("`evaluate_content` = #{evaluate_content,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_evaluate_commit() != null) {
            SET("`gmt_evaluate_commit` = #{gmt_evaluate_commit,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIs_invalid() != null) {
            SET("`is_invalid` = #{is_invalid,jdbcType=BIT}");
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
        
        if (record.getShop_id() != null) {
            SET("`shop_id` = #{shop_id,jdbcType=BIGINT}");
        }
        
        if (record.getVersion() != null) {
            SET("`version` = #{version,jdbcType=INTEGER}");
        }
        
        if (record.getOrder_id() != null) {
            SET("`order_id` = #{order_id,jdbcType=BIGINT}");
        }
        
        if (record.getUser_head() != null) {
            SET("`user_head` = #{user_head,jdbcType=VARCHAR}");
        }
        
        WHERE("`id` = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(ShopEvaluateDetailExample example, boolean includeExamplePhrase) {
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
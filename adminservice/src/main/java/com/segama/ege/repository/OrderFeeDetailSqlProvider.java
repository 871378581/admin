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

import com.segama.ege.entity.OrderFeeDetail;
import com.segama.ege.entity.OrderFeeDetailExample.Criteria;
import com.segama.ege.entity.OrderFeeDetailExample.Criterion;
import com.segama.ege.entity.OrderFeeDetailExample;
import java.util.List;
import java.util.Map;

public class OrderFeeDetailSqlProvider {

    public String countByExample(OrderFeeDetailExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("`order_fee_detail`");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(OrderFeeDetailExample example) {
        BEGIN();
        DELETE_FROM("`order_fee_detail`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(OrderFeeDetail record) {
        BEGIN();
        INSERT_INTO("`order_fee_detail`");
        
        if (record.getOrder_id() != null) {
            VALUES("`order_id`", "#{order_id,jdbcType=BIGINT}");
        }
        
        if (record.getOrder_string_id() != null) {
            VALUES("`order_string_id`", "#{order_string_id,jdbcType=VARCHAR}");
        }
        
        if (record.getEach_item_id() != null) {
            VALUES("`each_item_id`", "#{each_item_id,jdbcType=BIGINT}");
        }
        
        if (record.getEach_item() != null) {
            VALUES("`each_item`", "#{each_item,jdbcType=VARCHAR}");
        }
        
        if (record.getEach_fee() != null) {
            VALUES("`each_fee`", "#{each_fee,jdbcType=VARCHAR}");
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
        
        if (record.getPay_id() != null) {
            VALUES("`pay_id`", "#{pay_id,jdbcType=BIGINT}");
        }
        
        return SQL();
    }

    public String selectByExample(OrderFeeDetailExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("`id`");
        } else {
            SELECT("`id`");
        }
        SELECT("`order_id`");
        SELECT("`order_string_id`");
        SELECT("`each_item_id`");
        SELECT("`each_item`");
        SELECT("`each_fee`");
        SELECT("`gmt_create`");
        SELECT("`gmt_modify`");
        SELECT("`creator_account`");
        SELECT("`modifier_account`");
        SELECT("`pay_id`");
        FROM("`order_fee_detail`");
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
        OrderFeeDetail record = (OrderFeeDetail) parameter.get("record");
        OrderFeeDetailExample example = (OrderFeeDetailExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`order_fee_detail`");
        
        if (record.getId() != null) {
            SET("`id` = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getOrder_id() != null) {
            SET("`order_id` = #{record.order_id,jdbcType=BIGINT}");
        }
        
        if (record.getOrder_string_id() != null) {
            SET("`order_string_id` = #{record.order_string_id,jdbcType=VARCHAR}");
        }
        
        if (record.getEach_item_id() != null) {
            SET("`each_item_id` = #{record.each_item_id,jdbcType=BIGINT}");
        }
        
        if (record.getEach_item() != null) {
            SET("`each_item` = #{record.each_item,jdbcType=VARCHAR}");
        }
        
        if (record.getEach_fee() != null) {
            SET("`each_fee` = #{record.each_fee,jdbcType=VARCHAR}");
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
        
        if (record.getPay_id() != null) {
            SET("`pay_id` = #{record.pay_id,jdbcType=BIGINT}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`order_fee_detail`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`order_id` = #{record.order_id,jdbcType=BIGINT}");
        SET("`order_string_id` = #{record.order_string_id,jdbcType=VARCHAR}");
        SET("`each_item_id` = #{record.each_item_id,jdbcType=BIGINT}");
        SET("`each_item` = #{record.each_item,jdbcType=VARCHAR}");
        SET("`each_fee` = #{record.each_fee,jdbcType=VARCHAR}");
        SET("`gmt_create` = #{record.gmt_create,jdbcType=TIMESTAMP}");
        SET("`gmt_modify` = #{record.gmt_modify,jdbcType=TIMESTAMP}");
        SET("`creator_account` = #{record.creator_account,jdbcType=VARCHAR}");
        SET("`modifier_account` = #{record.modifier_account,jdbcType=VARCHAR}");
        SET("`pay_id` = #{record.pay_id,jdbcType=BIGINT}");
        
        OrderFeeDetailExample example = (OrderFeeDetailExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(OrderFeeDetail record) {
        BEGIN();
        UPDATE("`order_fee_detail`");
        
        if (record.getOrder_id() != null) {
            SET("`order_id` = #{order_id,jdbcType=BIGINT}");
        }
        
        if (record.getOrder_string_id() != null) {
            SET("`order_string_id` = #{order_string_id,jdbcType=VARCHAR}");
        }
        
        if (record.getEach_item_id() != null) {
            SET("`each_item_id` = #{each_item_id,jdbcType=BIGINT}");
        }
        
        if (record.getEach_item() != null) {
            SET("`each_item` = #{each_item,jdbcType=VARCHAR}");
        }
        
        if (record.getEach_fee() != null) {
            SET("`each_fee` = #{each_fee,jdbcType=VARCHAR}");
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
        
        if (record.getPay_id() != null) {
            SET("`pay_id` = #{pay_id,jdbcType=BIGINT}");
        }
        
        WHERE("`id` = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(OrderFeeDetailExample example, boolean includeExamplePhrase) {
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
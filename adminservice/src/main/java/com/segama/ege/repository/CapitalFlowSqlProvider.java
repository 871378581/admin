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

import com.segama.ege.entity.CapitalFlow;
import com.segama.ege.entity.CapitalFlowExample.Criteria;
import com.segama.ege.entity.CapitalFlowExample.Criterion;
import com.segama.ege.entity.CapitalFlowExample;
import java.util.List;
import java.util.Map;

public class CapitalFlowSqlProvider {

    public String countByExample(CapitalFlowExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("`capital_flow`");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(CapitalFlowExample example) {
        BEGIN();
        DELETE_FROM("`capital_flow`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(CapitalFlow record) {
        BEGIN();
        INSERT_INTO("`capital_flow`");
        
        if (record.getShop_id() != null) {
            VALUES("`shop_id`", "#{shop_id,jdbcType=BIGINT}");
        }
        
        if (record.getAccount() != null) {
            VALUES("`account`", "#{account,jdbcType=VARCHAR}");
        }
        
        if (record.getReal_name() != null) {
            VALUES("`real_name`", "#{real_name,jdbcType=VARCHAR}");
        }
        
        if (record.getAmount() != null) {
            VALUES("`amount`", "#{amount,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            VALUES("`description`", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_string_id() != null) {
            VALUES("`order_string_id`", "#{order_string_id,jdbcType=VARCHAR}");
        }
        
        if (record.getBank_card_num() != null) {
            VALUES("`bank_card_num`", "#{bank_card_num,jdbcType=VARCHAR}");
        }
        
        if (record.getPayee() != null) {
            VALUES("`payee`", "#{payee,jdbcType=VARCHAR}");
        }
        
        if (record.getOpening_bank() != null) {
            VALUES("`opening_bank`", "#{opening_bank,jdbcType=VARCHAR}");
        }
        
        if (record.getOperate_type() != null) {
            VALUES("`operate_type`", "#{operate_type,jdbcType=BIGINT}");
        }
        
        if (record.getOrder_id() != null) {
            VALUES("`order_id`", "#{order_id,jdbcType=BIGINT}");
        }
        
        if (record.getVerify_id() != null) {
            VALUES("`verify_id`", "#{verify_id,jdbcType=BIGINT}");
        }
        
        if (record.getGmt_create() != null) {
            VALUES("`gmt_create`", "#{gmt_create,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTotal_amount() != null) {
            VALUES("`total_amount`", "#{total_amount,jdbcType=VARCHAR}");
        }
        
        if (record.getFreezing_amount() != null) {
            VALUES("`freezing_amount`", "#{freezing_amount,jdbcType=VARCHAR}");
        }
        
        if (record.getAvailable_amount() != null) {
            VALUES("`available_amount`", "#{available_amount,jdbcType=VARCHAR}");
        }
        
        if (record.getShop_name() != null) {
            VALUES("`shop_name`", "#{shop_name,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(CapitalFlowExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("`id`");
        } else {
            SELECT("`id`");
        }
        SELECT("`shop_id`");
        SELECT("`account`");
        SELECT("`real_name`");
        SELECT("`amount`");
        SELECT("`description`");
        SELECT("`order_string_id`");
        SELECT("`bank_card_num`");
        SELECT("`payee`");
        SELECT("`opening_bank`");
        SELECT("`operate_type`");
        SELECT("`order_id`");
        SELECT("`verify_id`");
        SELECT("`gmt_create`");
        SELECT("`total_amount`");
        SELECT("`freezing_amount`");
        SELECT("`available_amount`");
        SELECT("`shop_name`");
        FROM("`capital_flow`");
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
        CapitalFlow record = (CapitalFlow) parameter.get("record");
        CapitalFlowExample example = (CapitalFlowExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`capital_flow`");
        
        if (record.getId() != null) {
            SET("`id` = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getShop_id() != null) {
            SET("`shop_id` = #{record.shop_id,jdbcType=BIGINT}");
        }
        
        if (record.getAccount() != null) {
            SET("`account` = #{record.account,jdbcType=VARCHAR}");
        }
        
        if (record.getReal_name() != null) {
            SET("`real_name` = #{record.real_name,jdbcType=VARCHAR}");
        }
        
        if (record.getAmount() != null) {
            SET("`amount` = #{record.amount,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            SET("`description` = #{record.description,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_string_id() != null) {
            SET("`order_string_id` = #{record.order_string_id,jdbcType=VARCHAR}");
        }
        
        if (record.getBank_card_num() != null) {
            SET("`bank_card_num` = #{record.bank_card_num,jdbcType=VARCHAR}");
        }
        
        if (record.getPayee() != null) {
            SET("`payee` = #{record.payee,jdbcType=VARCHAR}");
        }
        
        if (record.getOpening_bank() != null) {
            SET("`opening_bank` = #{record.opening_bank,jdbcType=VARCHAR}");
        }
        
        if (record.getOperate_type() != null) {
            SET("`operate_type` = #{record.operate_type,jdbcType=BIGINT}");
        }
        
        if (record.getOrder_id() != null) {
            SET("`order_id` = #{record.order_id,jdbcType=BIGINT}");
        }
        
        if (record.getVerify_id() != null) {
            SET("`verify_id` = #{record.verify_id,jdbcType=BIGINT}");
        }
        
        if (record.getGmt_create() != null) {
            SET("`gmt_create` = #{record.gmt_create,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTotal_amount() != null) {
            SET("`total_amount` = #{record.total_amount,jdbcType=VARCHAR}");
        }
        
        if (record.getFreezing_amount() != null) {
            SET("`freezing_amount` = #{record.freezing_amount,jdbcType=VARCHAR}");
        }
        
        if (record.getAvailable_amount() != null) {
            SET("`available_amount` = #{record.available_amount,jdbcType=VARCHAR}");
        }
        
        if (record.getShop_name() != null) {
            SET("`shop_name` = #{record.shop_name,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`capital_flow`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`shop_id` = #{record.shop_id,jdbcType=BIGINT}");
        SET("`account` = #{record.account,jdbcType=VARCHAR}");
        SET("`real_name` = #{record.real_name,jdbcType=VARCHAR}");
        SET("`amount` = #{record.amount,jdbcType=VARCHAR}");
        SET("`description` = #{record.description,jdbcType=VARCHAR}");
        SET("`order_string_id` = #{record.order_string_id,jdbcType=VARCHAR}");
        SET("`bank_card_num` = #{record.bank_card_num,jdbcType=VARCHAR}");
        SET("`payee` = #{record.payee,jdbcType=VARCHAR}");
        SET("`opening_bank` = #{record.opening_bank,jdbcType=VARCHAR}");
        SET("`operate_type` = #{record.operate_type,jdbcType=BIGINT}");
        SET("`order_id` = #{record.order_id,jdbcType=BIGINT}");
        SET("`verify_id` = #{record.verify_id,jdbcType=BIGINT}");
        SET("`gmt_create` = #{record.gmt_create,jdbcType=TIMESTAMP}");
        SET("`total_amount` = #{record.total_amount,jdbcType=VARCHAR}");
        SET("`freezing_amount` = #{record.freezing_amount,jdbcType=VARCHAR}");
        SET("`available_amount` = #{record.available_amount,jdbcType=VARCHAR}");
        SET("`shop_name` = #{record.shop_name,jdbcType=VARCHAR}");
        
        CapitalFlowExample example = (CapitalFlowExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(CapitalFlow record) {
        BEGIN();
        UPDATE("`capital_flow`");
        
        if (record.getShop_id() != null) {
            SET("`shop_id` = #{shop_id,jdbcType=BIGINT}");
        }
        
        if (record.getAccount() != null) {
            SET("`account` = #{account,jdbcType=VARCHAR}");
        }
        
        if (record.getReal_name() != null) {
            SET("`real_name` = #{real_name,jdbcType=VARCHAR}");
        }
        
        if (record.getAmount() != null) {
            SET("`amount` = #{amount,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            SET("`description` = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_string_id() != null) {
            SET("`order_string_id` = #{order_string_id,jdbcType=VARCHAR}");
        }
        
        if (record.getBank_card_num() != null) {
            SET("`bank_card_num` = #{bank_card_num,jdbcType=VARCHAR}");
        }
        
        if (record.getPayee() != null) {
            SET("`payee` = #{payee,jdbcType=VARCHAR}");
        }
        
        if (record.getOpening_bank() != null) {
            SET("`opening_bank` = #{opening_bank,jdbcType=VARCHAR}");
        }
        
        if (record.getOperate_type() != null) {
            SET("`operate_type` = #{operate_type,jdbcType=BIGINT}");
        }
        
        if (record.getOrder_id() != null) {
            SET("`order_id` = #{order_id,jdbcType=BIGINT}");
        }
        
        if (record.getVerify_id() != null) {
            SET("`verify_id` = #{verify_id,jdbcType=BIGINT}");
        }
        
        if (record.getGmt_create() != null) {
            SET("`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTotal_amount() != null) {
            SET("`total_amount` = #{total_amount,jdbcType=VARCHAR}");
        }
        
        if (record.getFreezing_amount() != null) {
            SET("`freezing_amount` = #{freezing_amount,jdbcType=VARCHAR}");
        }
        
        if (record.getAvailable_amount() != null) {
            SET("`available_amount` = #{available_amount,jdbcType=VARCHAR}");
        }
        
        if (record.getShop_name() != null) {
            SET("`shop_name` = #{shop_name,jdbcType=VARCHAR}");
        }
        
        WHERE("`id` = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(CapitalFlowExample example, boolean includeExamplePhrase) {
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
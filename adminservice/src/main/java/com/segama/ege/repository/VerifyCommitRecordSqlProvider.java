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

import com.segama.ege.entity.VerifyCommitRecord;
import com.segama.ege.entity.VerifyCommitRecordExample.Criteria;
import com.segama.ege.entity.VerifyCommitRecordExample.Criterion;
import com.segama.ege.entity.VerifyCommitRecordExample;
import java.util.List;
import java.util.Map;

public class VerifyCommitRecordSqlProvider {

    public String countByExample(VerifyCommitRecordExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("`verify_commit_record`");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(VerifyCommitRecordExample example) {
        BEGIN();
        DELETE_FROM("`verify_commit_record`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(VerifyCommitRecord record) {
        BEGIN();
        INSERT_INTO("`verify_commit_record`");
        
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
        
        if (record.getVerify_account() != null) {
            VALUES("`verify_account`", "#{verify_account,jdbcType=VARCHAR}");
        }
        
        if (record.getShop_id() != null) {
            VALUES("`shop_id`", "#{shop_id,jdbcType=BIGINT}");
        }
        
        if (record.getShop_name() != null) {
            VALUES("`shop_name`", "#{shop_name,jdbcType=VARCHAR}");
        }
        
        if (record.getOperate_type() != null) {
            VALUES("`operate_type`", "#{operate_type,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            VALUES("`status`", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            VALUES("`remark`", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getPayment_voucher() != null) {
            VALUES("`payment_voucher`", "#{payment_voucher,jdbcType=VARCHAR}");
        }
        
        if (record.getAmount() != null) {
            VALUES("`amount`", "#{amount,jdbcType=VARCHAR}");
        }
        
        if (record.getTarget_json() != null) {
            VALUES("`target_json`", "#{target_json,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getChange_json() != null) {
            VALUES("`change_json`", "#{change_json,jdbcType=LONGVARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExampleWithBLOBs(VerifyCommitRecordExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("`id`");
        } else {
            SELECT("`id`");
        }
        SELECT("`gmt_create`");
        SELECT("`gmt_modify`");
        SELECT("`creator_account`");
        SELECT("`modifier_account`");
        SELECT("`verify_account`");
        SELECT("`shop_id`");
        SELECT("`shop_name`");
        SELECT("`operate_type`");
        SELECT("`status`");
        SELECT("`remark`");
        SELECT("`payment_voucher`");
        SELECT("`amount`");
        SELECT("`target_json`");
        SELECT("`change_json`");
        FROM("`verify_commit_record`");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String selectByExample(VerifyCommitRecordExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("`id`");
        } else {
            SELECT("`id`");
        }
        SELECT("`gmt_create`");
        SELECT("`gmt_modify`");
        SELECT("`creator_account`");
        SELECT("`modifier_account`");
        SELECT("`verify_account`");
        SELECT("`shop_id`");
        SELECT("`shop_name`");
        SELECT("`operate_type`");
        SELECT("`status`");
        SELECT("`remark`");
        SELECT("`payment_voucher`");
        SELECT("`amount`");
        FROM("`verify_commit_record`");
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
        VerifyCommitRecord record = (VerifyCommitRecord) parameter.get("record");
        VerifyCommitRecordExample example = (VerifyCommitRecordExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`verify_commit_record`");
        
        if (record.getId() != null) {
            SET("`id` = #{record.id,jdbcType=BIGINT}");
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
        
        if (record.getVerify_account() != null) {
            SET("`verify_account` = #{record.verify_account,jdbcType=VARCHAR}");
        }
        
        if (record.getShop_id() != null) {
            SET("`shop_id` = #{record.shop_id,jdbcType=BIGINT}");
        }
        
        if (record.getShop_name() != null) {
            SET("`shop_name` = #{record.shop_name,jdbcType=VARCHAR}");
        }
        
        if (record.getOperate_type() != null) {
            SET("`operate_type` = #{record.operate_type,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            SET("`status` = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            SET("`remark` = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getPayment_voucher() != null) {
            SET("`payment_voucher` = #{record.payment_voucher,jdbcType=VARCHAR}");
        }
        
        if (record.getAmount() != null) {
            SET("`amount` = #{record.amount,jdbcType=VARCHAR}");
        }
        
        if (record.getTarget_json() != null) {
            SET("`target_json` = #{record.target_json,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getChange_json() != null) {
            SET("`change_json` = #{record.change_json,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`verify_commit_record`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`gmt_create` = #{record.gmt_create,jdbcType=TIMESTAMP}");
        SET("`gmt_modify` = #{record.gmt_modify,jdbcType=TIMESTAMP}");
        SET("`creator_account` = #{record.creator_account,jdbcType=VARCHAR}");
        SET("`modifier_account` = #{record.modifier_account,jdbcType=VARCHAR}");
        SET("`verify_account` = #{record.verify_account,jdbcType=VARCHAR}");
        SET("`shop_id` = #{record.shop_id,jdbcType=BIGINT}");
        SET("`shop_name` = #{record.shop_name,jdbcType=VARCHAR}");
        SET("`operate_type` = #{record.operate_type,jdbcType=INTEGER}");
        SET("`status` = #{record.status,jdbcType=INTEGER}");
        SET("`remark` = #{record.remark,jdbcType=VARCHAR}");
        SET("`payment_voucher` = #{record.payment_voucher,jdbcType=VARCHAR}");
        SET("`amount` = #{record.amount,jdbcType=VARCHAR}");
        SET("`target_json` = #{record.target_json,jdbcType=LONGVARCHAR}");
        SET("`change_json` = #{record.change_json,jdbcType=LONGVARCHAR}");
        
        VerifyCommitRecordExample example = (VerifyCommitRecordExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`verify_commit_record`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`gmt_create` = #{record.gmt_create,jdbcType=TIMESTAMP}");
        SET("`gmt_modify` = #{record.gmt_modify,jdbcType=TIMESTAMP}");
        SET("`creator_account` = #{record.creator_account,jdbcType=VARCHAR}");
        SET("`modifier_account` = #{record.modifier_account,jdbcType=VARCHAR}");
        SET("`verify_account` = #{record.verify_account,jdbcType=VARCHAR}");
        SET("`shop_id` = #{record.shop_id,jdbcType=BIGINT}");
        SET("`shop_name` = #{record.shop_name,jdbcType=VARCHAR}");
        SET("`operate_type` = #{record.operate_type,jdbcType=INTEGER}");
        SET("`status` = #{record.status,jdbcType=INTEGER}");
        SET("`remark` = #{record.remark,jdbcType=VARCHAR}");
        SET("`payment_voucher` = #{record.payment_voucher,jdbcType=VARCHAR}");
        SET("`amount` = #{record.amount,jdbcType=VARCHAR}");
        
        VerifyCommitRecordExample example = (VerifyCommitRecordExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(VerifyCommitRecord record) {
        BEGIN();
        UPDATE("`verify_commit_record`");
        
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
        
        if (record.getVerify_account() != null) {
            SET("`verify_account` = #{verify_account,jdbcType=VARCHAR}");
        }
        
        if (record.getShop_id() != null) {
            SET("`shop_id` = #{shop_id,jdbcType=BIGINT}");
        }
        
        if (record.getShop_name() != null) {
            SET("`shop_name` = #{shop_name,jdbcType=VARCHAR}");
        }
        
        if (record.getOperate_type() != null) {
            SET("`operate_type` = #{operate_type,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            SET("`status` = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getRemark() != null) {
            SET("`remark` = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getPayment_voucher() != null) {
            SET("`payment_voucher` = #{payment_voucher,jdbcType=VARCHAR}");
        }
        
        if (record.getAmount() != null) {
            SET("`amount` = #{amount,jdbcType=VARCHAR}");
        }
        
        if (record.getTarget_json() != null) {
            SET("`target_json` = #{target_json,jdbcType=LONGVARCHAR}");
        }
        
        if (record.getChange_json() != null) {
            SET("`change_json` = #{change_json,jdbcType=LONGVARCHAR}");
        }
        
        WHERE("`id` = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(VerifyCommitRecordExample example, boolean includeExamplePhrase) {
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
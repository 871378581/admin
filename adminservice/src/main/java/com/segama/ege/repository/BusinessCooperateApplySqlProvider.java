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

import com.segama.ege.entity.BusinessCooperateApply;
import com.segama.ege.entity.BusinessCooperateApplyExample.Criteria;
import com.segama.ege.entity.BusinessCooperateApplyExample.Criterion;
import com.segama.ege.entity.BusinessCooperateApplyExample;
import java.util.List;
import java.util.Map;

public class BusinessCooperateApplySqlProvider {

    public String countByExample(BusinessCooperateApplyExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("`business_cooperate_apply`");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(BusinessCooperateApplyExample example) {
        BEGIN();
        DELETE_FROM("`business_cooperate_apply`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(BusinessCooperateApply record) {
        BEGIN();
        INSERT_INTO("`business_cooperate_apply`");
        
        if (record.getUser_name() != null) {
            VALUES("`user_name`", "#{user_name,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone_num() != null) {
            VALUES("`phone_num`", "#{phone_num,jdbcType=VARCHAR}");
        }
        
        if (record.getExpect_contact_time() != null) {
            VALUES("`expect_contact_time`", "#{expect_contact_time,jdbcType=VARCHAR}");
        }
        
        if (record.getProject_description() != null) {
            VALUES("`project_description`", "#{project_description,jdbcType=VARCHAR}");
        }
        
        if (record.getContacter_status() != null) {
            VALUES("`contacter_status`", "#{contacter_status,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            VALUES("`remark`", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getOperator() != null) {
            VALUES("`operator`", "#{operator,jdbcType=VARCHAR}");
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
        
        if (record.getUser_id() != null) {
            VALUES("`user_id`", "#{user_id,jdbcType=VARCHAR}");
        }
        
        if (record.getShop_name() != null) {
            VALUES("`shop_name`", "#{shop_name,jdbcType=VARCHAR}");
        }
        
        if (record.getShop_area_size() != null) {
            VALUES("`shop_area_size`", "#{shop_area_size,jdbcType=VARCHAR}");
        }
        
        if (record.getShop_address() != null) {
            VALUES("`shop_address`", "#{shop_address,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchant_type() != null) {
            VALUES("`merchant_type`", "#{merchant_type,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(BusinessCooperateApplyExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("`id`");
        } else {
            SELECT("`id`");
        }
        SELECT("`user_name`");
        SELECT("`phone_num`");
        SELECT("`expect_contact_time`");
        SELECT("`project_description`");
        SELECT("`contacter_status`");
        SELECT("`remark`");
        SELECT("`operator`");
        SELECT("`gmt_create`");
        SELECT("`gmt_modify`");
        SELECT("`creator_account`");
        SELECT("`modifier_account`");
        SELECT("`user_id`");
        SELECT("`shop_name`");
        SELECT("`shop_area_size`");
        SELECT("`shop_address`");
        SELECT("`merchant_type`");
        FROM("`business_cooperate_apply`");
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
        BusinessCooperateApply record = (BusinessCooperateApply) parameter.get("record");
        BusinessCooperateApplyExample example = (BusinessCooperateApplyExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`business_cooperate_apply`");
        
        if (record.getId() != null) {
            SET("`id` = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getUser_name() != null) {
            SET("`user_name` = #{record.user_name,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone_num() != null) {
            SET("`phone_num` = #{record.phone_num,jdbcType=VARCHAR}");
        }
        
        if (record.getExpect_contact_time() != null) {
            SET("`expect_contact_time` = #{record.expect_contact_time,jdbcType=VARCHAR}");
        }
        
        if (record.getProject_description() != null) {
            SET("`project_description` = #{record.project_description,jdbcType=VARCHAR}");
        }
        
        if (record.getContacter_status() != null) {
            SET("`contacter_status` = #{record.contacter_status,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("`remark` = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getOperator() != null) {
            SET("`operator` = #{record.operator,jdbcType=VARCHAR}");
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
        
        if (record.getUser_id() != null) {
            SET("`user_id` = #{record.user_id,jdbcType=VARCHAR}");
        }
        
        if (record.getShop_name() != null) {
            SET("`shop_name` = #{record.shop_name,jdbcType=VARCHAR}");
        }
        
        if (record.getShop_area_size() != null) {
            SET("`shop_area_size` = #{record.shop_area_size,jdbcType=VARCHAR}");
        }
        
        if (record.getShop_address() != null) {
            SET("`shop_address` = #{record.shop_address,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchant_type() != null) {
            SET("`merchant_type` = #{record.merchant_type,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`business_cooperate_apply`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`user_name` = #{record.user_name,jdbcType=VARCHAR}");
        SET("`phone_num` = #{record.phone_num,jdbcType=VARCHAR}");
        SET("`expect_contact_time` = #{record.expect_contact_time,jdbcType=VARCHAR}");
        SET("`project_description` = #{record.project_description,jdbcType=VARCHAR}");
        SET("`contacter_status` = #{record.contacter_status,jdbcType=VARCHAR}");
        SET("`remark` = #{record.remark,jdbcType=VARCHAR}");
        SET("`operator` = #{record.operator,jdbcType=VARCHAR}");
        SET("`gmt_create` = #{record.gmt_create,jdbcType=TIMESTAMP}");
        SET("`gmt_modify` = #{record.gmt_modify,jdbcType=TIMESTAMP}");
        SET("`creator_account` = #{record.creator_account,jdbcType=VARCHAR}");
        SET("`modifier_account` = #{record.modifier_account,jdbcType=VARCHAR}");
        SET("`user_id` = #{record.user_id,jdbcType=VARCHAR}");
        SET("`shop_name` = #{record.shop_name,jdbcType=VARCHAR}");
        SET("`shop_area_size` = #{record.shop_area_size,jdbcType=VARCHAR}");
        SET("`shop_address` = #{record.shop_address,jdbcType=VARCHAR}");
        SET("`merchant_type` = #{record.merchant_type,jdbcType=VARCHAR}");
        
        BusinessCooperateApplyExample example = (BusinessCooperateApplyExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(BusinessCooperateApply record) {
        BEGIN();
        UPDATE("`business_cooperate_apply`");
        
        if (record.getUser_name() != null) {
            SET("`user_name` = #{user_name,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone_num() != null) {
            SET("`phone_num` = #{phone_num,jdbcType=VARCHAR}");
        }
        
        if (record.getExpect_contact_time() != null) {
            SET("`expect_contact_time` = #{expect_contact_time,jdbcType=VARCHAR}");
        }
        
        if (record.getProject_description() != null) {
            SET("`project_description` = #{project_description,jdbcType=VARCHAR}");
        }
        
        if (record.getContacter_status() != null) {
            SET("`contacter_status` = #{contacter_status,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("`remark` = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getOperator() != null) {
            SET("`operator` = #{operator,jdbcType=VARCHAR}");
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
        
        if (record.getUser_id() != null) {
            SET("`user_id` = #{user_id,jdbcType=VARCHAR}");
        }
        
        if (record.getShop_name() != null) {
            SET("`shop_name` = #{shop_name,jdbcType=VARCHAR}");
        }
        
        if (record.getShop_area_size() != null) {
            SET("`shop_area_size` = #{shop_area_size,jdbcType=VARCHAR}");
        }
        
        if (record.getShop_address() != null) {
            SET("`shop_address` = #{shop_address,jdbcType=VARCHAR}");
        }
        
        if (record.getMerchant_type() != null) {
            SET("`merchant_type` = #{merchant_type,jdbcType=VARCHAR}");
        }
        
        WHERE("`id` = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(BusinessCooperateApplyExample example, boolean includeExamplePhrase) {
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
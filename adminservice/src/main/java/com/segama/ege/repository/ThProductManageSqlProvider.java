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

import com.segama.ege.entity.ThProductManage;
import com.segama.ege.entity.ThProductManageExample.Criteria;
import com.segama.ege.entity.ThProductManageExample.Criterion;
import com.segama.ege.entity.ThProductManageExample;
import java.util.List;
import java.util.Map;

public class ThProductManageSqlProvider {

    public String countByExample(ThProductManageExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("`th_product_manage`");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ThProductManageExample example) {
        BEGIN();
        DELETE_FROM("`th_product_manage`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(ThProductManage record) {
        BEGIN();
        INSERT_INTO("`th_product_manage`");
        
        if (record.getBusiness_name() != null) {
            VALUES("`business_name`", "#{business_name,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_name() != null) {
            VALUES("`product_name`", "#{product_name,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_code() != null) {
            VALUES("`product_code`", "#{product_code,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_type() != null) {
            VALUES("`product_type`", "#{product_type,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            VALUES("`url`", "#{url,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_status() != null) {
            VALUES("`product_status`", "#{product_status,jdbcType=INTEGER}");
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
        
        if (record.getDescription() != null) {
            VALUES("`description`", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getSource_url() != null) {
            VALUES("`source_url`", "#{source_url,jdbcType=VARCHAR}");
        }
        
        if (record.getBusiness_code() != null) {
            VALUES("`business_code`", "#{business_code,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            VALUES("`type`", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getShifou_2_kaifa() != null) {
            VALUES("`shifou_2_kaifa`", "#{shifou_2_kaifa,jdbcType=VARCHAR}");
        }
        
        if (record.getSettle_mode() != null) {
            VALUES("`settle_mode`", "#{settle_mode,jdbcType=VARCHAR}");
        }
        
        if (record.getSettle_column() != null) {
            VALUES("`settle_column`", "#{settle_column,jdbcType=VARCHAR}");
        }
        
        if (record.getSettle_value() != null) {
            VALUES("`settle_value`", "#{settle_value,jdbcType=VARCHAR}");
        }
        
        if (record.getChannel_code() != null) {
            VALUES("`channel_code`", "#{channel_code,jdbcType=VARCHAR}");
        }
        
        if (record.getTemplate_code() != null) {
            VALUES("`template_code`", "#{template_code,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(ThProductManageExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("`id`");
        } else {
            SELECT("`id`");
        }
        SELECT("`business_name`");
        SELECT("`product_name`");
        SELECT("`product_code`");
        SELECT("`product_type`");
        SELECT("`url`");
        SELECT("`product_status`");
        SELECT("`gmt_create`");
        SELECT("`gmt_modify`");
        SELECT("`creator_account`");
        SELECT("`modifier_account`");
        SELECT("`description`");
        SELECT("`source_url`");
        SELECT("`business_code`");
        SELECT("`type`");
        SELECT("`shifou_2_kaifa`");
        SELECT("`settle_mode`");
        SELECT("`settle_column`");
        SELECT("`settle_value`");
        SELECT("`channel_code`");
        SELECT("`template_code`");
        FROM("`th_product_manage`");
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
        ThProductManage record = (ThProductManage) parameter.get("record");
        ThProductManageExample example = (ThProductManageExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`th_product_manage`");
        
        if (record.getId() != null) {
            SET("`id` = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getBusiness_name() != null) {
            SET("`business_name` = #{record.business_name,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_name() != null) {
            SET("`product_name` = #{record.product_name,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_code() != null) {
            SET("`product_code` = #{record.product_code,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_type() != null) {
            SET("`product_type` = #{record.product_type,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            SET("`url` = #{record.url,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_status() != null) {
            SET("`product_status` = #{record.product_status,jdbcType=INTEGER}");
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
        
        if (record.getDescription() != null) {
            SET("`description` = #{record.description,jdbcType=VARCHAR}");
        }
        
        if (record.getSource_url() != null) {
            SET("`source_url` = #{record.source_url,jdbcType=VARCHAR}");
        }
        
        if (record.getBusiness_code() != null) {
            SET("`business_code` = #{record.business_code,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            SET("`type` = #{record.type,jdbcType=VARCHAR}");
        }
        
        if (record.getShifou_2_kaifa() != null) {
            SET("`shifou_2_kaifa` = #{record.shifou_2_kaifa,jdbcType=VARCHAR}");
        }
        
        if (record.getSettle_mode() != null) {
            SET("`settle_mode` = #{record.settle_mode,jdbcType=VARCHAR}");
        }
        
        if (record.getSettle_column() != null) {
            SET("`settle_column` = #{record.settle_column,jdbcType=VARCHAR}");
        }
        
        if (record.getSettle_value() != null) {
            SET("`settle_value` = #{record.settle_value,jdbcType=VARCHAR}");
        }
        
        if (record.getChannel_code() != null) {
            SET("`channel_code` = #{record.channel_code,jdbcType=VARCHAR}");
        }
        
        if (record.getTemplate_code() != null) {
            SET("`template_code` = #{record.template_code,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`th_product_manage`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`business_name` = #{record.business_name,jdbcType=VARCHAR}");
        SET("`product_name` = #{record.product_name,jdbcType=VARCHAR}");
        SET("`product_code` = #{record.product_code,jdbcType=VARCHAR}");
        SET("`product_type` = #{record.product_type,jdbcType=VARCHAR}");
        SET("`url` = #{record.url,jdbcType=VARCHAR}");
        SET("`product_status` = #{record.product_status,jdbcType=INTEGER}");
        SET("`gmt_create` = #{record.gmt_create,jdbcType=TIMESTAMP}");
        SET("`gmt_modify` = #{record.gmt_modify,jdbcType=TIMESTAMP}");
        SET("`creator_account` = #{record.creator_account,jdbcType=VARCHAR}");
        SET("`modifier_account` = #{record.modifier_account,jdbcType=VARCHAR}");
        SET("`description` = #{record.description,jdbcType=VARCHAR}");
        SET("`source_url` = #{record.source_url,jdbcType=VARCHAR}");
        SET("`business_code` = #{record.business_code,jdbcType=VARCHAR}");
        SET("`type` = #{record.type,jdbcType=VARCHAR}");
        SET("`shifou_2_kaifa` = #{record.shifou_2_kaifa,jdbcType=VARCHAR}");
        SET("`settle_mode` = #{record.settle_mode,jdbcType=VARCHAR}");
        SET("`settle_column` = #{record.settle_column,jdbcType=VARCHAR}");
        SET("`settle_value` = #{record.settle_value,jdbcType=VARCHAR}");
        SET("`channel_code` = #{record.channel_code,jdbcType=VARCHAR}");
        SET("`template_code` = #{record.template_code,jdbcType=VARCHAR}");
        
        ThProductManageExample example = (ThProductManageExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(ThProductManage record) {
        BEGIN();
        UPDATE("`th_product_manage`");
        
        if (record.getBusiness_name() != null) {
            SET("`business_name` = #{business_name,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_name() != null) {
            SET("`product_name` = #{product_name,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_code() != null) {
            SET("`product_code` = #{product_code,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_type() != null) {
            SET("`product_type` = #{product_type,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            SET("`url` = #{url,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_status() != null) {
            SET("`product_status` = #{product_status,jdbcType=INTEGER}");
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
        
        if (record.getDescription() != null) {
            SET("`description` = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getSource_url() != null) {
            SET("`source_url` = #{source_url,jdbcType=VARCHAR}");
        }
        
        if (record.getBusiness_code() != null) {
            SET("`business_code` = #{business_code,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            SET("`type` = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getShifou_2_kaifa() != null) {
            SET("`shifou_2_kaifa` = #{shifou_2_kaifa,jdbcType=VARCHAR}");
        }
        
        if (record.getSettle_mode() != null) {
            SET("`settle_mode` = #{settle_mode,jdbcType=VARCHAR}");
        }
        
        if (record.getSettle_column() != null) {
            SET("`settle_column` = #{settle_column,jdbcType=VARCHAR}");
        }
        
        if (record.getSettle_value() != null) {
            SET("`settle_value` = #{settle_value,jdbcType=VARCHAR}");
        }
        
        if (record.getChannel_code() != null) {
            SET("`channel_code` = #{channel_code,jdbcType=VARCHAR}");
        }
        
        if (record.getTemplate_code() != null) {
            SET("`template_code` = #{template_code,jdbcType=VARCHAR}");
        }
        
        WHERE("`id` = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(ThProductManageExample example, boolean includeExamplePhrase) {
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
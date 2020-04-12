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

import com.segama.ege.entity.ThSaleExtensionManage;
import com.segama.ege.entity.ThSaleExtensionManageExample.Criteria;
import com.segama.ege.entity.ThSaleExtensionManageExample.Criterion;
import com.segama.ege.entity.ThSaleExtensionManageExample;
import java.util.List;
import java.util.Map;

public class ThSaleExtensionManageSqlProvider {

    public String countByExample(ThSaleExtensionManageExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("`th_sale_extension_manage`");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ThSaleExtensionManageExample example) {
        BEGIN();
        DELETE_FROM("`th_sale_extension_manage`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(ThSaleExtensionManage record) {
        BEGIN();
        INSERT_INTO("`th_sale_extension_manage`");
        
        if (record.getCode() != null) {
            VALUES("`code`", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getShare_url_code() != null) {
            VALUES("`share_url_code`", "#{share_url_code,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_name() != null) {
            VALUES("`product_name`", "#{product_name,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_code() != null) {
            VALUES("`product_code`", "#{product_code,jdbcType=VARCHAR}");
        }
        
        if (record.getRequest_url() != null) {
            VALUES("`request_url`", "#{request_url,jdbcType=VARCHAR}");
        }
        
        if (record.getSource_url() != null) {
            VALUES("`source_url`", "#{source_url,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            VALUES("`phone`", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getOwner_account() != null) {
            VALUES("`owner_account`", "#{owner_account,jdbcType=VARCHAR}");
        }
        
        if (record.getCreate_account() != null) {
            VALUES("`create_account`", "#{create_account,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_name() != null) {
            VALUES("`user_name`", "#{user_name,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            VALUES("`address`", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_create() != null) {
            VALUES("`gmt_create`", "#{gmt_create,jdbcType=TIMESTAMP}");
        }
        
        if (record.getQq() != null) {
            VALUES("`qq`", "#{qq,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(ThSaleExtensionManageExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("`id`");
        } else {
            SELECT("`id`");
        }
        SELECT("`code`");
        SELECT("`share_url_code`");
        SELECT("`product_name`");
        SELECT("`product_code`");
        SELECT("`request_url`");
        SELECT("`source_url`");
        SELECT("`phone`");
        SELECT("`owner_account`");
        SELECT("`create_account`");
        SELECT("`user_name`");
        SELECT("`address`");
        SELECT("`gmt_create`");
        SELECT("`qq`");
        FROM("`th_sale_extension_manage`");
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
        ThSaleExtensionManage record = (ThSaleExtensionManage) parameter.get("record");
        ThSaleExtensionManageExample example = (ThSaleExtensionManageExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`th_sale_extension_manage`");
        
        if (record.getId() != null) {
            SET("`id` = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getCode() != null) {
            SET("`code` = #{record.code,jdbcType=VARCHAR}");
        }
        
        if (record.getShare_url_code() != null) {
            SET("`share_url_code` = #{record.share_url_code,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_name() != null) {
            SET("`product_name` = #{record.product_name,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_code() != null) {
            SET("`product_code` = #{record.product_code,jdbcType=VARCHAR}");
        }
        
        if (record.getRequest_url() != null) {
            SET("`request_url` = #{record.request_url,jdbcType=VARCHAR}");
        }
        
        if (record.getSource_url() != null) {
            SET("`source_url` = #{record.source_url,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            SET("`phone` = #{record.phone,jdbcType=VARCHAR}");
        }
        
        if (record.getOwner_account() != null) {
            SET("`owner_account` = #{record.owner_account,jdbcType=VARCHAR}");
        }
        
        if (record.getCreate_account() != null) {
            SET("`create_account` = #{record.create_account,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_name() != null) {
            SET("`user_name` = #{record.user_name,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            SET("`address` = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_create() != null) {
            SET("`gmt_create` = #{record.gmt_create,jdbcType=TIMESTAMP}");
        }
        
        if (record.getQq() != null) {
            SET("`qq` = #{record.qq,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`th_sale_extension_manage`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`code` = #{record.code,jdbcType=VARCHAR}");
        SET("`share_url_code` = #{record.share_url_code,jdbcType=VARCHAR}");
        SET("`product_name` = #{record.product_name,jdbcType=VARCHAR}");
        SET("`product_code` = #{record.product_code,jdbcType=VARCHAR}");
        SET("`request_url` = #{record.request_url,jdbcType=VARCHAR}");
        SET("`source_url` = #{record.source_url,jdbcType=VARCHAR}");
        SET("`phone` = #{record.phone,jdbcType=VARCHAR}");
        SET("`owner_account` = #{record.owner_account,jdbcType=VARCHAR}");
        SET("`create_account` = #{record.create_account,jdbcType=VARCHAR}");
        SET("`user_name` = #{record.user_name,jdbcType=VARCHAR}");
        SET("`address` = #{record.address,jdbcType=VARCHAR}");
        SET("`gmt_create` = #{record.gmt_create,jdbcType=TIMESTAMP}");
        SET("`qq` = #{record.qq,jdbcType=VARCHAR}");
        
        ThSaleExtensionManageExample example = (ThSaleExtensionManageExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(ThSaleExtensionManage record) {
        BEGIN();
        UPDATE("`th_sale_extension_manage`");
        
        if (record.getCode() != null) {
            SET("`code` = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getShare_url_code() != null) {
            SET("`share_url_code` = #{share_url_code,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_name() != null) {
            SET("`product_name` = #{product_name,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_code() != null) {
            SET("`product_code` = #{product_code,jdbcType=VARCHAR}");
        }
        
        if (record.getRequest_url() != null) {
            SET("`request_url` = #{request_url,jdbcType=VARCHAR}");
        }
        
        if (record.getSource_url() != null) {
            SET("`source_url` = #{source_url,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            SET("`phone` = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getOwner_account() != null) {
            SET("`owner_account` = #{owner_account,jdbcType=VARCHAR}");
        }
        
        if (record.getCreate_account() != null) {
            SET("`create_account` = #{create_account,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_name() != null) {
            SET("`user_name` = #{user_name,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            SET("`address` = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_create() != null) {
            SET("`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP}");
        }
        
        if (record.getQq() != null) {
            SET("`qq` = #{qq,jdbcType=VARCHAR}");
        }
        
        WHERE("`id` = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(ThSaleExtensionManageExample example, boolean includeExamplePhrase) {
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
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

import com.segama.ege.entity.ThUrlManage;
import com.segama.ege.entity.ThUrlManageExample.Criteria;
import com.segama.ege.entity.ThUrlManageExample.Criterion;
import com.segama.ege.entity.ThUrlManageExample;
import java.util.List;
import java.util.Map;

public class ThUrlManageSqlProvider {

    public String countByExample(ThUrlManageExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("`th_url_manage`");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ThUrlManageExample example) {
        BEGIN();
        DELETE_FROM("`th_url_manage`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(ThUrlManage record) {
        BEGIN();
        INSERT_INTO("`th_url_manage`");
        
        if (record.getBusiness_name() != null) {
            VALUES("`business_name`", "#{business_name,jdbcType=VARCHAR}");
        }
        
        if (record.getOpen_ticket_main_body() != null) {
            VALUES("`open_ticket_main_body`", "#{open_ticket_main_body,jdbcType=VARCHAR}");
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
        
        if (record.getProduct_qudao_code() != null) {
            VALUES("`product_qudao_code`", "#{product_qudao_code,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            VALUES("`url`", "#{url,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl_status() != null) {
            VALUES("`url_status`", "#{url_status,jdbcType=INTEGER}");
        }
        
        if (record.getBiz_line() != null) {
            VALUES("`biz_line`", "#{biz_line,jdbcType=VARCHAR}");
        }
        
        if (record.getChannel_code() != null) {
            VALUES("`channel_code`", "#{channel_code,jdbcType=VARCHAR}");
        }
        
        if (record.getYouxiao_time() != null) {
            VALUES("`youxiao_time`", "#{youxiao_time,jdbcType=VARCHAR}");
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
        
        return SQL();
    }

    public String selectByExample(ThUrlManageExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("`id`");
        } else {
            SELECT("`id`");
        }
        SELECT("`business_name`");
        SELECT("`open_ticket_main_body`");
        SELECT("`product_name`");
        SELECT("`product_code`");
        SELECT("`product_type`");
        SELECT("`product_qudao_code`");
        SELECT("`url`");
        SELECT("`url_status`");
        SELECT("`biz_line`");
        SELECT("`channel_code`");
        SELECT("`youxiao_time`");
        SELECT("`gmt_create`");
        SELECT("`gmt_modify`");
        SELECT("`creator_account`");
        SELECT("`modifier_account`");
        SELECT("`description`");
        FROM("`th_url_manage`");
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
        ThUrlManage record = (ThUrlManage) parameter.get("record");
        ThUrlManageExample example = (ThUrlManageExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`th_url_manage`");
        
        if (record.getId() != null) {
            SET("`id` = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getBusiness_name() != null) {
            SET("`business_name` = #{record.business_name,jdbcType=VARCHAR}");
        }
        
        if (record.getOpen_ticket_main_body() != null) {
            SET("`open_ticket_main_body` = #{record.open_ticket_main_body,jdbcType=VARCHAR}");
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
        
        if (record.getProduct_qudao_code() != null) {
            SET("`product_qudao_code` = #{record.product_qudao_code,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            SET("`url` = #{record.url,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl_status() != null) {
            SET("`url_status` = #{record.url_status,jdbcType=INTEGER}");
        }
        
        if (record.getBiz_line() != null) {
            SET("`biz_line` = #{record.biz_line,jdbcType=VARCHAR}");
        }
        
        if (record.getChannel_code() != null) {
            SET("`channel_code` = #{record.channel_code,jdbcType=VARCHAR}");
        }
        
        if (record.getYouxiao_time() != null) {
            SET("`youxiao_time` = #{record.youxiao_time,jdbcType=VARCHAR}");
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
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`th_url_manage`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`business_name` = #{record.business_name,jdbcType=VARCHAR}");
        SET("`open_ticket_main_body` = #{record.open_ticket_main_body,jdbcType=VARCHAR}");
        SET("`product_name` = #{record.product_name,jdbcType=VARCHAR}");
        SET("`product_code` = #{record.product_code,jdbcType=VARCHAR}");
        SET("`product_type` = #{record.product_type,jdbcType=VARCHAR}");
        SET("`product_qudao_code` = #{record.product_qudao_code,jdbcType=VARCHAR}");
        SET("`url` = #{record.url,jdbcType=VARCHAR}");
        SET("`url_status` = #{record.url_status,jdbcType=INTEGER}");
        SET("`biz_line` = #{record.biz_line,jdbcType=VARCHAR}");
        SET("`channel_code` = #{record.channel_code,jdbcType=VARCHAR}");
        SET("`youxiao_time` = #{record.youxiao_time,jdbcType=VARCHAR}");
        SET("`gmt_create` = #{record.gmt_create,jdbcType=TIMESTAMP}");
        SET("`gmt_modify` = #{record.gmt_modify,jdbcType=TIMESTAMP}");
        SET("`creator_account` = #{record.creator_account,jdbcType=VARCHAR}");
        SET("`modifier_account` = #{record.modifier_account,jdbcType=VARCHAR}");
        SET("`description` = #{record.description,jdbcType=VARCHAR}");
        
        ThUrlManageExample example = (ThUrlManageExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(ThUrlManage record) {
        BEGIN();
        UPDATE("`th_url_manage`");
        
        if (record.getBusiness_name() != null) {
            SET("`business_name` = #{business_name,jdbcType=VARCHAR}");
        }
        
        if (record.getOpen_ticket_main_body() != null) {
            SET("`open_ticket_main_body` = #{open_ticket_main_body,jdbcType=VARCHAR}");
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
        
        if (record.getProduct_qudao_code() != null) {
            SET("`product_qudao_code` = #{product_qudao_code,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl() != null) {
            SET("`url` = #{url,jdbcType=VARCHAR}");
        }
        
        if (record.getUrl_status() != null) {
            SET("`url_status` = #{url_status,jdbcType=INTEGER}");
        }
        
        if (record.getBiz_line() != null) {
            SET("`biz_line` = #{biz_line,jdbcType=VARCHAR}");
        }
        
        if (record.getChannel_code() != null) {
            SET("`channel_code` = #{channel_code,jdbcType=VARCHAR}");
        }
        
        if (record.getYouxiao_time() != null) {
            SET("`youxiao_time` = #{youxiao_time,jdbcType=VARCHAR}");
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
        
        WHERE("`id` = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(ThUrlManageExample example, boolean includeExamplePhrase) {
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
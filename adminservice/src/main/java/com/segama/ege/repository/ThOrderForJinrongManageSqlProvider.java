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

import com.segama.ege.entity.ThOrderForJinrongManage;
import com.segama.ege.entity.ThOrderForJinrongManageExample.Criteria;
import com.segama.ege.entity.ThOrderForJinrongManageExample.Criterion;
import com.segama.ege.entity.ThOrderForJinrongManageExample;
import java.util.List;
import java.util.Map;

public class ThOrderForJinrongManageSqlProvider {

    public String countByExample(ThOrderForJinrongManageExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("`th_order_for_jinrong_manage`");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ThOrderForJinrongManageExample example) {
        BEGIN();
        DELETE_FROM("`th_order_for_jinrong_manage`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(ThOrderForJinrongManage record) {
        BEGIN();
        INSERT_INTO("`th_order_for_jinrong_manage`");
        
        if (record.getOperate_type() != null) {
            VALUES("`operate_type`", "#{operate_type,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_code() != null) {
            VALUES("`order_code`", "#{order_code,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_time() != null) {
            VALUES("`order_time`", "#{order_time,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_name() != null) {
            VALUES("`product_name`", "#{product_name,jdbcType=VARCHAR}");
        }
        
        if (record.getChannel_account() != null) {
            VALUES("`channel_account`", "#{channel_account,jdbcType=VARCHAR}");
        }
        
        if (record.getChannel_code() != null) {
            VALUES("`channel_code`", "#{channel_code,jdbcType=VARCHAR}");
        }
        
        if (record.getZhuce() != null) {
            VALUES("`zhuce`", "#{zhuce,jdbcType=VARCHAR}");
        }
        
        if (record.getXinhu() != null) {
            VALUES("`xinhu`", "#{xinhu,jdbcType=VARCHAR}");
        }
        
        if (record.getJinjian() != null) {
            VALUES("`jinjian`", "#{jinjian,jdbcType=VARCHAR}");
        }
        
        if (record.getJihuo() != null) {
            VALUES("`jihuo`", "#{jihuo,jdbcType=VARCHAR}");
        }
        
        if (record.getShouxin() != null) {
            VALUES("`shouxin`", "#{shouxin,jdbcType=VARCHAR}");
        }
        
        if (record.getHeka() != null) {
            VALUES("`heka`", "#{heka,jdbcType=VARCHAR}");
        }
        
        if (record.getXiakuan() != null) {
            VALUES("`xiakuan`", "#{xiakuan,jdbcType=VARCHAR}");
        }
        
        if (record.getXiakuan_amt() != null) {
            VALUES("`xiakuan_amt`", "#{xiakuan_amt,jdbcType=VARCHAR}");
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

    public String selectByExample(ThOrderForJinrongManageExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("`id`");
        } else {
            SELECT("`id`");
        }
        SELECT("`operate_type`");
        SELECT("`order_code`");
        SELECT("`order_time`");
        SELECT("`product_name`");
        SELECT("`channel_account`");
        SELECT("`channel_code`");
        SELECT("`zhuce`");
        SELECT("`xinhu`");
        SELECT("`jinjian`");
        SELECT("`jihuo`");
        SELECT("`shouxin`");
        SELECT("`heka`");
        SELECT("`xiakuan`");
        SELECT("`xiakuan_amt`");
        SELECT("`gmt_create`");
        SELECT("`gmt_modify`");
        SELECT("`creator_account`");
        SELECT("`modifier_account`");
        SELECT("`description`");
        FROM("`th_order_for_jinrong_manage`");
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
        ThOrderForJinrongManage record = (ThOrderForJinrongManage) parameter.get("record");
        ThOrderForJinrongManageExample example = (ThOrderForJinrongManageExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`th_order_for_jinrong_manage`");
        
        if (record.getId() != null) {
            SET("`id` = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getOperate_type() != null) {
            SET("`operate_type` = #{record.operate_type,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_code() != null) {
            SET("`order_code` = #{record.order_code,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_time() != null) {
            SET("`order_time` = #{record.order_time,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_name() != null) {
            SET("`product_name` = #{record.product_name,jdbcType=VARCHAR}");
        }
        
        if (record.getChannel_account() != null) {
            SET("`channel_account` = #{record.channel_account,jdbcType=VARCHAR}");
        }
        
        if (record.getChannel_code() != null) {
            SET("`channel_code` = #{record.channel_code,jdbcType=VARCHAR}");
        }
        
        if (record.getZhuce() != null) {
            SET("`zhuce` = #{record.zhuce,jdbcType=VARCHAR}");
        }
        
        if (record.getXinhu() != null) {
            SET("`xinhu` = #{record.xinhu,jdbcType=VARCHAR}");
        }
        
        if (record.getJinjian() != null) {
            SET("`jinjian` = #{record.jinjian,jdbcType=VARCHAR}");
        }
        
        if (record.getJihuo() != null) {
            SET("`jihuo` = #{record.jihuo,jdbcType=VARCHAR}");
        }
        
        if (record.getShouxin() != null) {
            SET("`shouxin` = #{record.shouxin,jdbcType=VARCHAR}");
        }
        
        if (record.getHeka() != null) {
            SET("`heka` = #{record.heka,jdbcType=VARCHAR}");
        }
        
        if (record.getXiakuan() != null) {
            SET("`xiakuan` = #{record.xiakuan,jdbcType=VARCHAR}");
        }
        
        if (record.getXiakuan_amt() != null) {
            SET("`xiakuan_amt` = #{record.xiakuan_amt,jdbcType=VARCHAR}");
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
        UPDATE("`th_order_for_jinrong_manage`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`operate_type` = #{record.operate_type,jdbcType=VARCHAR}");
        SET("`order_code` = #{record.order_code,jdbcType=VARCHAR}");
        SET("`order_time` = #{record.order_time,jdbcType=VARCHAR}");
        SET("`product_name` = #{record.product_name,jdbcType=VARCHAR}");
        SET("`channel_account` = #{record.channel_account,jdbcType=VARCHAR}");
        SET("`channel_code` = #{record.channel_code,jdbcType=VARCHAR}");
        SET("`zhuce` = #{record.zhuce,jdbcType=VARCHAR}");
        SET("`xinhu` = #{record.xinhu,jdbcType=VARCHAR}");
        SET("`jinjian` = #{record.jinjian,jdbcType=VARCHAR}");
        SET("`jihuo` = #{record.jihuo,jdbcType=VARCHAR}");
        SET("`shouxin` = #{record.shouxin,jdbcType=VARCHAR}");
        SET("`heka` = #{record.heka,jdbcType=VARCHAR}");
        SET("`xiakuan` = #{record.xiakuan,jdbcType=VARCHAR}");
        SET("`xiakuan_amt` = #{record.xiakuan_amt,jdbcType=VARCHAR}");
        SET("`gmt_create` = #{record.gmt_create,jdbcType=TIMESTAMP}");
        SET("`gmt_modify` = #{record.gmt_modify,jdbcType=TIMESTAMP}");
        SET("`creator_account` = #{record.creator_account,jdbcType=VARCHAR}");
        SET("`modifier_account` = #{record.modifier_account,jdbcType=VARCHAR}");
        SET("`description` = #{record.description,jdbcType=VARCHAR}");
        
        ThOrderForJinrongManageExample example = (ThOrderForJinrongManageExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(ThOrderForJinrongManage record) {
        BEGIN();
        UPDATE("`th_order_for_jinrong_manage`");
        
        if (record.getOperate_type() != null) {
            SET("`operate_type` = #{operate_type,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_code() != null) {
            SET("`order_code` = #{order_code,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_time() != null) {
            SET("`order_time` = #{order_time,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct_name() != null) {
            SET("`product_name` = #{product_name,jdbcType=VARCHAR}");
        }
        
        if (record.getChannel_account() != null) {
            SET("`channel_account` = #{channel_account,jdbcType=VARCHAR}");
        }
        
        if (record.getChannel_code() != null) {
            SET("`channel_code` = #{channel_code,jdbcType=VARCHAR}");
        }
        
        if (record.getZhuce() != null) {
            SET("`zhuce` = #{zhuce,jdbcType=VARCHAR}");
        }
        
        if (record.getXinhu() != null) {
            SET("`xinhu` = #{xinhu,jdbcType=VARCHAR}");
        }
        
        if (record.getJinjian() != null) {
            SET("`jinjian` = #{jinjian,jdbcType=VARCHAR}");
        }
        
        if (record.getJihuo() != null) {
            SET("`jihuo` = #{jihuo,jdbcType=VARCHAR}");
        }
        
        if (record.getShouxin() != null) {
            SET("`shouxin` = #{shouxin,jdbcType=VARCHAR}");
        }
        
        if (record.getHeka() != null) {
            SET("`heka` = #{heka,jdbcType=VARCHAR}");
        }
        
        if (record.getXiakuan() != null) {
            SET("`xiakuan` = #{xiakuan,jdbcType=VARCHAR}");
        }
        
        if (record.getXiakuan_amt() != null) {
            SET("`xiakuan_amt` = #{xiakuan_amt,jdbcType=VARCHAR}");
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

    protected void applyWhere(ThOrderForJinrongManageExample example, boolean includeExamplePhrase) {
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
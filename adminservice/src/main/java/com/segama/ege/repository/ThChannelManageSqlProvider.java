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

import com.segama.ege.entity.ThChannelManage;
import com.segama.ege.entity.ThChannelManageExample.Criteria;
import com.segama.ege.entity.ThChannelManageExample.Criterion;
import com.segama.ege.entity.ThChannelManageExample;
import java.util.List;
import java.util.Map;

public class ThChannelManageSqlProvider {

    public String countByExample(ThChannelManageExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("`th_channel_manage`");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ThChannelManageExample example) {
        BEGIN();
        DELETE_FROM("`th_channel_manage`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(ThChannelManage record) {
        BEGIN();
        INSERT_INTO("`th_channel_manage`");
        
        if (record.getChannel_code() != null) {
            VALUES("`channel_code`", "#{channel_code,jdbcType=VARCHAR}");
        }
        
        if (record.getChannel_name() != null) {
            VALUES("`channel_name`", "#{channel_name,jdbcType=VARCHAR}");
        }
        
        if (record.getMain_body() != null) {
            VALUES("`main_body`", "#{main_body,jdbcType=VARCHAR}");
        }
        
        if (record.getContacter() != null) {
            VALUES("`contacter`", "#{contacter,jdbcType=VARCHAR}");
        }
        
        if (record.getContacter_phone() != null) {
            VALUES("`contacter_phone`", "#{contacter_phone,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("`status`", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getJieru_way() != null) {
            VALUES("`jieru_way`", "#{jieru_way,jdbcType=VARCHAR}");
        }
        
        if (record.getMeiti_type() != null) {
            VALUES("`meiti_type`", "#{meiti_type,jdbcType=VARCHAR}");
        }
        
        if (record.getMeiti_pwd() != null) {
            VALUES("`meiti_pwd`", "#{meiti_pwd,jdbcType=VARCHAR}");
        }
        
        if (record.getMeiti_account() != null) {
            VALUES("`meiti_account`", "#{meiti_account,jdbcType=VARCHAR}");
        }
        
        if (record.getAccount_id() != null) {
            VALUES("`account_id`", "#{account_id,jdbcType=VARCHAR}");
        }
        
        if (record.getBank_card() != null) {
            VALUES("`bank_card`", "#{bank_card,jdbcType=VARCHAR}");
        }
        
        if (record.getOpen_bank_area() != null) {
            VALUES("`open_bank_area`", "#{open_bank_area,jdbcType=VARCHAR}");
        }
        
        if (record.getReal_name() != null) {
            VALUES("`real_name`", "#{real_name,jdbcType=VARCHAR}");
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

    public String selectByExample(ThChannelManageExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("`id`");
        } else {
            SELECT("`id`");
        }
        SELECT("`channel_code`");
        SELECT("`channel_name`");
        SELECT("`main_body`");
        SELECT("`contacter`");
        SELECT("`contacter_phone`");
        SELECT("`status`");
        SELECT("`jieru_way`");
        SELECT("`meiti_type`");
        SELECT("`meiti_pwd`");
        SELECT("`meiti_account`");
        SELECT("`account_id`");
        SELECT("`bank_card`");
        SELECT("`open_bank_area`");
        SELECT("`real_name`");
        SELECT("`gmt_create`");
        SELECT("`gmt_modify`");
        SELECT("`creator_account`");
        SELECT("`modifier_account`");
        SELECT("`description`");
        FROM("`th_channel_manage`");
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
        ThChannelManage record = (ThChannelManage) parameter.get("record");
        ThChannelManageExample example = (ThChannelManageExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`th_channel_manage`");
        
        if (record.getId() != null) {
            SET("`id` = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getChannel_code() != null) {
            SET("`channel_code` = #{record.channel_code,jdbcType=VARCHAR}");
        }
        
        if (record.getChannel_name() != null) {
            SET("`channel_name` = #{record.channel_name,jdbcType=VARCHAR}");
        }
        
        if (record.getMain_body() != null) {
            SET("`main_body` = #{record.main_body,jdbcType=VARCHAR}");
        }
        
        if (record.getContacter() != null) {
            SET("`contacter` = #{record.contacter,jdbcType=VARCHAR}");
        }
        
        if (record.getContacter_phone() != null) {
            SET("`contacter_phone` = #{record.contacter_phone,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("`status` = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getJieru_way() != null) {
            SET("`jieru_way` = #{record.jieru_way,jdbcType=VARCHAR}");
        }
        
        if (record.getMeiti_type() != null) {
            SET("`meiti_type` = #{record.meiti_type,jdbcType=VARCHAR}");
        }
        
        if (record.getMeiti_pwd() != null) {
            SET("`meiti_pwd` = #{record.meiti_pwd,jdbcType=VARCHAR}");
        }
        
        if (record.getMeiti_account() != null) {
            SET("`meiti_account` = #{record.meiti_account,jdbcType=VARCHAR}");
        }
        
        if (record.getAccount_id() != null) {
            SET("`account_id` = #{record.account_id,jdbcType=VARCHAR}");
        }
        
        if (record.getBank_card() != null) {
            SET("`bank_card` = #{record.bank_card,jdbcType=VARCHAR}");
        }
        
        if (record.getOpen_bank_area() != null) {
            SET("`open_bank_area` = #{record.open_bank_area,jdbcType=VARCHAR}");
        }
        
        if (record.getReal_name() != null) {
            SET("`real_name` = #{record.real_name,jdbcType=VARCHAR}");
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
        UPDATE("`th_channel_manage`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`channel_code` = #{record.channel_code,jdbcType=VARCHAR}");
        SET("`channel_name` = #{record.channel_name,jdbcType=VARCHAR}");
        SET("`main_body` = #{record.main_body,jdbcType=VARCHAR}");
        SET("`contacter` = #{record.contacter,jdbcType=VARCHAR}");
        SET("`contacter_phone` = #{record.contacter_phone,jdbcType=VARCHAR}");
        SET("`status` = #{record.status,jdbcType=INTEGER}");
        SET("`jieru_way` = #{record.jieru_way,jdbcType=VARCHAR}");
        SET("`meiti_type` = #{record.meiti_type,jdbcType=VARCHAR}");
        SET("`meiti_pwd` = #{record.meiti_pwd,jdbcType=VARCHAR}");
        SET("`meiti_account` = #{record.meiti_account,jdbcType=VARCHAR}");
        SET("`account_id` = #{record.account_id,jdbcType=VARCHAR}");
        SET("`bank_card` = #{record.bank_card,jdbcType=VARCHAR}");
        SET("`open_bank_area` = #{record.open_bank_area,jdbcType=VARCHAR}");
        SET("`real_name` = #{record.real_name,jdbcType=VARCHAR}");
        SET("`gmt_create` = #{record.gmt_create,jdbcType=TIMESTAMP}");
        SET("`gmt_modify` = #{record.gmt_modify,jdbcType=TIMESTAMP}");
        SET("`creator_account` = #{record.creator_account,jdbcType=VARCHAR}");
        SET("`modifier_account` = #{record.modifier_account,jdbcType=VARCHAR}");
        SET("`description` = #{record.description,jdbcType=VARCHAR}");
        
        ThChannelManageExample example = (ThChannelManageExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(ThChannelManage record) {
        BEGIN();
        UPDATE("`th_channel_manage`");
        
        if (record.getChannel_code() != null) {
            SET("`channel_code` = #{channel_code,jdbcType=VARCHAR}");
        }
        
        if (record.getChannel_name() != null) {
            SET("`channel_name` = #{channel_name,jdbcType=VARCHAR}");
        }
        
        if (record.getMain_body() != null) {
            SET("`main_body` = #{main_body,jdbcType=VARCHAR}");
        }
        
        if (record.getContacter() != null) {
            SET("`contacter` = #{contacter,jdbcType=VARCHAR}");
        }
        
        if (record.getContacter_phone() != null) {
            SET("`contacter_phone` = #{contacter_phone,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("`status` = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getJieru_way() != null) {
            SET("`jieru_way` = #{jieru_way,jdbcType=VARCHAR}");
        }
        
        if (record.getMeiti_type() != null) {
            SET("`meiti_type` = #{meiti_type,jdbcType=VARCHAR}");
        }
        
        if (record.getMeiti_pwd() != null) {
            SET("`meiti_pwd` = #{meiti_pwd,jdbcType=VARCHAR}");
        }
        
        if (record.getMeiti_account() != null) {
            SET("`meiti_account` = #{meiti_account,jdbcType=VARCHAR}");
        }
        
        if (record.getAccount_id() != null) {
            SET("`account_id` = #{account_id,jdbcType=VARCHAR}");
        }
        
        if (record.getBank_card() != null) {
            SET("`bank_card` = #{bank_card,jdbcType=VARCHAR}");
        }
        
        if (record.getOpen_bank_area() != null) {
            SET("`open_bank_area` = #{open_bank_area,jdbcType=VARCHAR}");
        }
        
        if (record.getReal_name() != null) {
            SET("`real_name` = #{real_name,jdbcType=VARCHAR}");
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

    protected void applyWhere(ThChannelManageExample example, boolean includeExamplePhrase) {
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
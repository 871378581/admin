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

import com.segama.ege.entity.AdminUser;
import com.segama.ege.entity.AdminUserExample.Criteria;
import com.segama.ege.entity.AdminUserExample.Criterion;
import com.segama.ege.entity.AdminUserExample;
import java.util.List;
import java.util.Map;

public class AdminUserSqlProvider {

    public String countByExample(AdminUserExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("`admin_user`");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(AdminUserExample example) {
        BEGIN();
        DELETE_FROM("`admin_user`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(AdminUser record) {
        BEGIN();
        INSERT_INTO("`admin_user`");
        
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
        
        if (record.getAccount() != null) {
            VALUES("`account`", "#{account,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            VALUES("`password`", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getVersion() != null) {
            VALUES("`version`", "#{version,jdbcType=INTEGER}");
        }
        
        if (record.getToken() != null) {
            VALUES("`token`", "#{token,jdbcType=VARCHAR}");
        }
        
        if (record.getExpire_time() != null) {
            VALUES("`expire_time`", "#{expire_time,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String selectByExample(AdminUserExample example) {
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
        SELECT("`account`");
        SELECT("`password`");
        SELECT("`version`");
        SELECT("`token`");
        SELECT("`expire_time`");
        FROM("`admin_user`");
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
        AdminUser record = (AdminUser) parameter.get("record");
        AdminUserExample example = (AdminUserExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`admin_user`");
        
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
        
        if (record.getAccount() != null) {
            SET("`account` = #{record.account,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            SET("`password` = #{record.password,jdbcType=VARCHAR}");
        }
        
        if (record.getVersion() != null) {
            SET("`version` = #{record.version,jdbcType=INTEGER}");
        }
        
        if (record.getToken() != null) {
            SET("`token` = #{record.token,jdbcType=VARCHAR}");
        }
        
        if (record.getExpire_time() != null) {
            SET("`expire_time` = #{record.expire_time,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`admin_user`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`gmt_create` = #{record.gmt_create,jdbcType=TIMESTAMP}");
        SET("`gmt_modify` = #{record.gmt_modify,jdbcType=TIMESTAMP}");
        SET("`creator_account` = #{record.creator_account,jdbcType=VARCHAR}");
        SET("`modifier_account` = #{record.modifier_account,jdbcType=VARCHAR}");
        SET("`account` = #{record.account,jdbcType=VARCHAR}");
        SET("`password` = #{record.password,jdbcType=VARCHAR}");
        SET("`version` = #{record.version,jdbcType=INTEGER}");
        SET("`token` = #{record.token,jdbcType=VARCHAR}");
        SET("`expire_time` = #{record.expire_time,jdbcType=TIMESTAMP}");
        
        AdminUserExample example = (AdminUserExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(AdminUser record) {
        BEGIN();
        UPDATE("`admin_user`");
        
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
        
        if (record.getAccount() != null) {
            SET("`account` = #{account,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            SET("`password` = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getVersion() != null) {
            SET("`version` = #{version,jdbcType=INTEGER}");
        }
        
        if (record.getToken() != null) {
            SET("`token` = #{token,jdbcType=VARCHAR}");
        }
        
        if (record.getExpire_time() != null) {
            SET("`expire_time` = #{expire_time,jdbcType=TIMESTAMP}");
        }
        
        WHERE("`id` = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(AdminUserExample example, boolean includeExamplePhrase) {
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
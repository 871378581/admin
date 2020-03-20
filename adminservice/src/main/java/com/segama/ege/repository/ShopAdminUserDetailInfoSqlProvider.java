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

import com.segama.ege.entity.ShopAdminUserDetailInfo;
import com.segama.ege.entity.ShopAdminUserDetailInfoExample.Criteria;
import com.segama.ege.entity.ShopAdminUserDetailInfoExample.Criterion;
import com.segama.ege.entity.ShopAdminUserDetailInfoExample;
import java.util.List;
import java.util.Map;

public class ShopAdminUserDetailInfoSqlProvider {

    public String countByExample(ShopAdminUserDetailInfoExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("`shop_admin_user_detail_info`");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ShopAdminUserDetailInfoExample example) {
        BEGIN();
        DELETE_FROM("`shop_admin_user_detail_info`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(ShopAdminUserDetailInfo record) {
        BEGIN();
        INSERT_INTO("`shop_admin_user_detail_info`");
        
        if (record.getAccount() != null) {
            VALUES("`account`", "#{account,jdbcType=VARCHAR}");
        }
        
        if (record.getAge() != null) {
            VALUES("`age`", "#{age,jdbcType=BIGINT}");
        }
        
        if (record.getShop_id() != null) {
            VALUES("`shop_id`", "#{shop_id,jdbcType=BIGINT}");
        }
        
        if (record.getPhone() != null) {
            VALUES("`phone`", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            VALUES("`address`", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getGender() != null) {
            VALUES("`gender`", "#{gender,jdbcType=VARCHAR}");
        }
        
        if (record.getReal_name() != null) {
            VALUES("`real_name`", "#{real_name,jdbcType=VARCHAR}");
        }
        
        if (record.getBirthday() != null) {
            VALUES("`birthday`", "#{birthday,jdbcType=VARCHAR}");
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
        
        if (record.getBirth() != null) {
            VALUES("`birth`", "#{birth,jdbcType=VARCHAR}");
        }
        
        if (record.getJob() != null) {
            VALUES("`job`", "#{job,jdbcType=VARCHAR}");
        }
        
        if (record.getCity() != null) {
            VALUES("`city`", "#{city,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_head() != null) {
            VALUES("`user_head`", "#{user_head,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(ShopAdminUserDetailInfoExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("`id`");
        } else {
            SELECT("`id`");
        }
        SELECT("`account`");
        SELECT("`age`");
        SELECT("`shop_id`");
        SELECT("`phone`");
        SELECT("`address`");
        SELECT("`gender`");
        SELECT("`real_name`");
        SELECT("`birthday`");
        SELECT("`gmt_create`");
        SELECT("`gmt_modify`");
        SELECT("`creator_account`");
        SELECT("`modifier_account`");
        SELECT("`description`");
        SELECT("`birth`");
        SELECT("`job`");
        SELECT("`city`");
        SELECT("`user_head`");
        FROM("`shop_admin_user_detail_info`");
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
        ShopAdminUserDetailInfo record = (ShopAdminUserDetailInfo) parameter.get("record");
        ShopAdminUserDetailInfoExample example = (ShopAdminUserDetailInfoExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`shop_admin_user_detail_info`");
        
        if (record.getId() != null) {
            SET("`id` = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getAccount() != null) {
            SET("`account` = #{record.account,jdbcType=VARCHAR}");
        }
        
        if (record.getAge() != null) {
            SET("`age` = #{record.age,jdbcType=BIGINT}");
        }
        
        if (record.getShop_id() != null) {
            SET("`shop_id` = #{record.shop_id,jdbcType=BIGINT}");
        }
        
        if (record.getPhone() != null) {
            SET("`phone` = #{record.phone,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            SET("`address` = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getGender() != null) {
            SET("`gender` = #{record.gender,jdbcType=VARCHAR}");
        }
        
        if (record.getReal_name() != null) {
            SET("`real_name` = #{record.real_name,jdbcType=VARCHAR}");
        }
        
        if (record.getBirthday() != null) {
            SET("`birthday` = #{record.birthday,jdbcType=VARCHAR}");
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
        
        if (record.getBirth() != null) {
            SET("`birth` = #{record.birth,jdbcType=VARCHAR}");
        }
        
        if (record.getJob() != null) {
            SET("`job` = #{record.job,jdbcType=VARCHAR}");
        }
        
        if (record.getCity() != null) {
            SET("`city` = #{record.city,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_head() != null) {
            SET("`user_head` = #{record.user_head,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`shop_admin_user_detail_info`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`account` = #{record.account,jdbcType=VARCHAR}");
        SET("`age` = #{record.age,jdbcType=BIGINT}");
        SET("`shop_id` = #{record.shop_id,jdbcType=BIGINT}");
        SET("`phone` = #{record.phone,jdbcType=VARCHAR}");
        SET("`address` = #{record.address,jdbcType=VARCHAR}");
        SET("`gender` = #{record.gender,jdbcType=VARCHAR}");
        SET("`real_name` = #{record.real_name,jdbcType=VARCHAR}");
        SET("`birthday` = #{record.birthday,jdbcType=VARCHAR}");
        SET("`gmt_create` = #{record.gmt_create,jdbcType=TIMESTAMP}");
        SET("`gmt_modify` = #{record.gmt_modify,jdbcType=TIMESTAMP}");
        SET("`creator_account` = #{record.creator_account,jdbcType=VARCHAR}");
        SET("`modifier_account` = #{record.modifier_account,jdbcType=VARCHAR}");
        SET("`description` = #{record.description,jdbcType=VARCHAR}");
        SET("`birth` = #{record.birth,jdbcType=VARCHAR}");
        SET("`job` = #{record.job,jdbcType=VARCHAR}");
        SET("`city` = #{record.city,jdbcType=VARCHAR}");
        SET("`user_head` = #{record.user_head,jdbcType=VARCHAR}");
        
        ShopAdminUserDetailInfoExample example = (ShopAdminUserDetailInfoExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(ShopAdminUserDetailInfo record) {
        BEGIN();
        UPDATE("`shop_admin_user_detail_info`");
        
        if (record.getAccount() != null) {
            SET("`account` = #{account,jdbcType=VARCHAR}");
        }
        
        if (record.getAge() != null) {
            SET("`age` = #{age,jdbcType=BIGINT}");
        }
        
        if (record.getShop_id() != null) {
            SET("`shop_id` = #{shop_id,jdbcType=BIGINT}");
        }
        
        if (record.getPhone() != null) {
            SET("`phone` = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            SET("`address` = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getGender() != null) {
            SET("`gender` = #{gender,jdbcType=VARCHAR}");
        }
        
        if (record.getReal_name() != null) {
            SET("`real_name` = #{real_name,jdbcType=VARCHAR}");
        }
        
        if (record.getBirthday() != null) {
            SET("`birthday` = #{birthday,jdbcType=VARCHAR}");
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
        
        if (record.getBirth() != null) {
            SET("`birth` = #{birth,jdbcType=VARCHAR}");
        }
        
        if (record.getJob() != null) {
            SET("`job` = #{job,jdbcType=VARCHAR}");
        }
        
        if (record.getCity() != null) {
            SET("`city` = #{city,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_head() != null) {
            SET("`user_head` = #{user_head,jdbcType=VARCHAR}");
        }
        
        WHERE("`id` = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(ShopAdminUserDetailInfoExample example, boolean includeExamplePhrase) {
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
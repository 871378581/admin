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

import com.segama.ege.entity.WxUser;
import com.segama.ege.entity.WxUserExample.Criteria;
import com.segama.ege.entity.WxUserExample.Criterion;
import com.segama.ege.entity.WxUserExample;
import java.util.List;
import java.util.Map;

public class WxUserSqlProvider {

    public String countByExample(WxUserExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("`wx_user`");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(WxUserExample example) {
        BEGIN();
        DELETE_FROM("`wx_user`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(WxUser record) {
        BEGIN();
        INSERT_INTO("`wx_user`");
        
        if (record.getUser_id() != null) {
            VALUES("`user_id`", "#{user_id,jdbcType=VARCHAR}");
        }
        
        if (record.getNick_name() != null) {
            VALUES("`nick_name`", "#{nick_name,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_head() != null) {
            VALUES("`user_head`", "#{user_head,jdbcType=VARCHAR}");
        }
        
        if (record.getToken_id() != null) {
            VALUES("`token_id`", "#{token_id,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_name() != null) {
            VALUES("`user_name`", "#{user_name,jdbcType=VARCHAR}");
        }
        
        if (record.getBirth() != null) {
            VALUES("`birth`", "#{birth,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            VALUES("`sex`", "#{sex,jdbcType=VARCHAR}");
        }
        
        if (record.getId_card() != null) {
            VALUES("`id_card`", "#{id_card,jdbcType=VARCHAR}");
        }
        
        if (record.getHas_bind_phone() != null) {
            VALUES("`has_bind_phone`", "#{has_bind_phone,jdbcType=BIT}");
        }
        
        if (record.getPhone() != null) {
            VALUES("`phone`", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_register() != null) {
            VALUES("`gmt_register`", "#{gmt_register,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPlace_city() != null) {
            VALUES("`place_city`", "#{place_city,jdbcType=VARCHAR}");
        }
        
        if (record.getLast_longitude() != null) {
            VALUES("`last_longitude`", "#{last_longitude,jdbcType=DECIMAL}");
        }
        
        if (record.getLast_latitude() != null) {
            VALUES("`last_latitude`", "#{last_latitude,jdbcType=DECIMAL}");
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
        
        if (record.getVersion() != null) {
            VALUES("`version`", "#{version,jdbcType=INTEGER}");
        }
        
        if (record.getMembership_level() != null) {
            VALUES("`membership_level`", "#{membership_level,jdbcType=VARCHAR}");
        }
        
        if (record.getJob() != null) {
            VALUES("`job`", "#{job,jdbcType=VARCHAR}");
        }
        
        if (record.getCode_expired_at() != null) {
            VALUES("`code_expired_at`", "#{code_expired_at,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCode() != null) {
            VALUES("`code`", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getDefault_plate() != null) {
            VALUES("`default_plate`", "#{default_plate,jdbcType=VARCHAR}");
        }
        
        if (record.getDefault_car_tye() != null) {
            VALUES("`default_car_tye`", "#{default_car_tye,jdbcType=VARCHAR}");
        }
        
        if (record.getHas_default_car() != null) {
            VALUES("`has_default_car`", "#{has_default_car,jdbcType=BIT}");
        }
        
        if (record.getCard_level() != null) {
            VALUES("`card_level`", "#{card_level,jdbcType=VARCHAR}");
        }
        
        if (record.getCapital_account_id() != null) {
            VALUES("`capital_account_id`", "#{capital_account_id,jdbcType=BIGINT}");
        }
        
        if (record.getAccount() != null) {
            VALUES("`account`", "#{account,jdbcType=VARCHAR}");
        }
        
        if (record.getCapital_account_str() != null) {
            VALUES("`capital_account_str`", "#{capital_account_str,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_type() != null) {
            VALUES("`user_type`", "#{user_type,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String selectByExample(WxUserExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("`id`");
        } else {
            SELECT("`id`");
        }
        SELECT("`user_id`");
        SELECT("`nick_name`");
        SELECT("`user_head`");
        SELECT("`token_id`");
        SELECT("`user_name`");
        SELECT("`birth`");
        SELECT("`sex`");
        SELECT("`id_card`");
        SELECT("`has_bind_phone`");
        SELECT("`phone`");
        SELECT("`gmt_register`");
        SELECT("`place_city`");
        SELECT("`last_longitude`");
        SELECT("`last_latitude`");
        SELECT("`gmt_create`");
        SELECT("`gmt_modify`");
        SELECT("`creator_account`");
        SELECT("`modifier_account`");
        SELECT("`version`");
        SELECT("`membership_level`");
        SELECT("`job`");
        SELECT("`code_expired_at`");
        SELECT("`code`");
        SELECT("`default_plate`");
        SELECT("`default_car_tye`");
        SELECT("`has_default_car`");
        SELECT("`card_level`");
        SELECT("`capital_account_id`");
        SELECT("`account`");
        SELECT("`capital_account_str`");
        SELECT("`user_type`");
        FROM("`wx_user`");
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
        WxUser record = (WxUser) parameter.get("record");
        WxUserExample example = (WxUserExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`wx_user`");
        
        if (record.getId() != null) {
            SET("`id` = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getUser_id() != null) {
            SET("`user_id` = #{record.user_id,jdbcType=VARCHAR}");
        }
        
        if (record.getNick_name() != null) {
            SET("`nick_name` = #{record.nick_name,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_head() != null) {
            SET("`user_head` = #{record.user_head,jdbcType=VARCHAR}");
        }
        
        if (record.getToken_id() != null) {
            SET("`token_id` = #{record.token_id,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_name() != null) {
            SET("`user_name` = #{record.user_name,jdbcType=VARCHAR}");
        }
        
        if (record.getBirth() != null) {
            SET("`birth` = #{record.birth,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            SET("`sex` = #{record.sex,jdbcType=VARCHAR}");
        }
        
        if (record.getId_card() != null) {
            SET("`id_card` = #{record.id_card,jdbcType=VARCHAR}");
        }
        
        if (record.getHas_bind_phone() != null) {
            SET("`has_bind_phone` = #{record.has_bind_phone,jdbcType=BIT}");
        }
        
        if (record.getPhone() != null) {
            SET("`phone` = #{record.phone,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_register() != null) {
            SET("`gmt_register` = #{record.gmt_register,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPlace_city() != null) {
            SET("`place_city` = #{record.place_city,jdbcType=VARCHAR}");
        }
        
        if (record.getLast_longitude() != null) {
            SET("`last_longitude` = #{record.last_longitude,jdbcType=DECIMAL}");
        }
        
        if (record.getLast_latitude() != null) {
            SET("`last_latitude` = #{record.last_latitude,jdbcType=DECIMAL}");
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
        
        if (record.getVersion() != null) {
            SET("`version` = #{record.version,jdbcType=INTEGER}");
        }
        
        if (record.getMembership_level() != null) {
            SET("`membership_level` = #{record.membership_level,jdbcType=VARCHAR}");
        }
        
        if (record.getJob() != null) {
            SET("`job` = #{record.job,jdbcType=VARCHAR}");
        }
        
        if (record.getCode_expired_at() != null) {
            SET("`code_expired_at` = #{record.code_expired_at,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCode() != null) {
            SET("`code` = #{record.code,jdbcType=VARCHAR}");
        }
        
        if (record.getDefault_plate() != null) {
            SET("`default_plate` = #{record.default_plate,jdbcType=VARCHAR}");
        }
        
        if (record.getDefault_car_tye() != null) {
            SET("`default_car_tye` = #{record.default_car_tye,jdbcType=VARCHAR}");
        }
        
        if (record.getHas_default_car() != null) {
            SET("`has_default_car` = #{record.has_default_car,jdbcType=BIT}");
        }
        
        if (record.getCard_level() != null) {
            SET("`card_level` = #{record.card_level,jdbcType=VARCHAR}");
        }
        
        if (record.getCapital_account_id() != null) {
            SET("`capital_account_id` = #{record.capital_account_id,jdbcType=BIGINT}");
        }
        
        if (record.getAccount() != null) {
            SET("`account` = #{record.account,jdbcType=VARCHAR}");
        }
        
        if (record.getCapital_account_str() != null) {
            SET("`capital_account_str` = #{record.capital_account_str,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_type() != null) {
            SET("`user_type` = #{record.user_type,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`wx_user`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`user_id` = #{record.user_id,jdbcType=VARCHAR}");
        SET("`nick_name` = #{record.nick_name,jdbcType=VARCHAR}");
        SET("`user_head` = #{record.user_head,jdbcType=VARCHAR}");
        SET("`token_id` = #{record.token_id,jdbcType=VARCHAR}");
        SET("`user_name` = #{record.user_name,jdbcType=VARCHAR}");
        SET("`birth` = #{record.birth,jdbcType=VARCHAR}");
        SET("`sex` = #{record.sex,jdbcType=VARCHAR}");
        SET("`id_card` = #{record.id_card,jdbcType=VARCHAR}");
        SET("`has_bind_phone` = #{record.has_bind_phone,jdbcType=BIT}");
        SET("`phone` = #{record.phone,jdbcType=VARCHAR}");
        SET("`gmt_register` = #{record.gmt_register,jdbcType=TIMESTAMP}");
        SET("`place_city` = #{record.place_city,jdbcType=VARCHAR}");
        SET("`last_longitude` = #{record.last_longitude,jdbcType=DECIMAL}");
        SET("`last_latitude` = #{record.last_latitude,jdbcType=DECIMAL}");
        SET("`gmt_create` = #{record.gmt_create,jdbcType=TIMESTAMP}");
        SET("`gmt_modify` = #{record.gmt_modify,jdbcType=TIMESTAMP}");
        SET("`creator_account` = #{record.creator_account,jdbcType=VARCHAR}");
        SET("`modifier_account` = #{record.modifier_account,jdbcType=VARCHAR}");
        SET("`version` = #{record.version,jdbcType=INTEGER}");
        SET("`membership_level` = #{record.membership_level,jdbcType=VARCHAR}");
        SET("`job` = #{record.job,jdbcType=VARCHAR}");
        SET("`code_expired_at` = #{record.code_expired_at,jdbcType=TIMESTAMP}");
        SET("`code` = #{record.code,jdbcType=VARCHAR}");
        SET("`default_plate` = #{record.default_plate,jdbcType=VARCHAR}");
        SET("`default_car_tye` = #{record.default_car_tye,jdbcType=VARCHAR}");
        SET("`has_default_car` = #{record.has_default_car,jdbcType=BIT}");
        SET("`card_level` = #{record.card_level,jdbcType=VARCHAR}");
        SET("`capital_account_id` = #{record.capital_account_id,jdbcType=BIGINT}");
        SET("`account` = #{record.account,jdbcType=VARCHAR}");
        SET("`capital_account_str` = #{record.capital_account_str,jdbcType=VARCHAR}");
        SET("`user_type` = #{record.user_type,jdbcType=INTEGER}");
        
        WxUserExample example = (WxUserExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(WxUser record) {
        BEGIN();
        UPDATE("`wx_user`");
        
        if (record.getUser_id() != null) {
            SET("`user_id` = #{user_id,jdbcType=VARCHAR}");
        }
        
        if (record.getNick_name() != null) {
            SET("`nick_name` = #{nick_name,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_head() != null) {
            SET("`user_head` = #{user_head,jdbcType=VARCHAR}");
        }
        
        if (record.getToken_id() != null) {
            SET("`token_id` = #{token_id,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_name() != null) {
            SET("`user_name` = #{user_name,jdbcType=VARCHAR}");
        }
        
        if (record.getBirth() != null) {
            SET("`birth` = #{birth,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            SET("`sex` = #{sex,jdbcType=VARCHAR}");
        }
        
        if (record.getId_card() != null) {
            SET("`id_card` = #{id_card,jdbcType=VARCHAR}");
        }
        
        if (record.getHas_bind_phone() != null) {
            SET("`has_bind_phone` = #{has_bind_phone,jdbcType=BIT}");
        }
        
        if (record.getPhone() != null) {
            SET("`phone` = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getGmt_register() != null) {
            SET("`gmt_register` = #{gmt_register,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPlace_city() != null) {
            SET("`place_city` = #{place_city,jdbcType=VARCHAR}");
        }
        
        if (record.getLast_longitude() != null) {
            SET("`last_longitude` = #{last_longitude,jdbcType=DECIMAL}");
        }
        
        if (record.getLast_latitude() != null) {
            SET("`last_latitude` = #{last_latitude,jdbcType=DECIMAL}");
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
        
        if (record.getVersion() != null) {
            SET("`version` = #{version,jdbcType=INTEGER}");
        }
        
        if (record.getMembership_level() != null) {
            SET("`membership_level` = #{membership_level,jdbcType=VARCHAR}");
        }
        
        if (record.getJob() != null) {
            SET("`job` = #{job,jdbcType=VARCHAR}");
        }
        
        if (record.getCode_expired_at() != null) {
            SET("`code_expired_at` = #{code_expired_at,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCode() != null) {
            SET("`code` = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getDefault_plate() != null) {
            SET("`default_plate` = #{default_plate,jdbcType=VARCHAR}");
        }
        
        if (record.getDefault_car_tye() != null) {
            SET("`default_car_tye` = #{default_car_tye,jdbcType=VARCHAR}");
        }
        
        if (record.getHas_default_car() != null) {
            SET("`has_default_car` = #{has_default_car,jdbcType=BIT}");
        }
        
        if (record.getCard_level() != null) {
            SET("`card_level` = #{card_level,jdbcType=VARCHAR}");
        }
        
        if (record.getCapital_account_id() != null) {
            SET("`capital_account_id` = #{capital_account_id,jdbcType=BIGINT}");
        }
        
        if (record.getAccount() != null) {
            SET("`account` = #{account,jdbcType=VARCHAR}");
        }
        
        if (record.getCapital_account_str() != null) {
            SET("`capital_account_str` = #{capital_account_str,jdbcType=VARCHAR}");
        }
        
        if (record.getUser_type() != null) {
            SET("`user_type` = #{user_type,jdbcType=INTEGER}");
        }
        
        WHERE("`id` = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(WxUserExample example, boolean includeExamplePhrase) {
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
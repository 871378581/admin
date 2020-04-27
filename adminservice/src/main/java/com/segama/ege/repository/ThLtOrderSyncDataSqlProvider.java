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

import com.segama.ege.entity.ThLtOrderSyncData;
import com.segama.ege.entity.ThLtOrderSyncDataExample.Criteria;
import com.segama.ege.entity.ThLtOrderSyncDataExample.Criterion;
import com.segama.ege.entity.ThLtOrderSyncDataExample;
import java.util.List;
import java.util.Map;

public class ThLtOrderSyncDataSqlProvider {

    public String countByExample(ThLtOrderSyncDataExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("`th_lt_order_sync_data`");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ThLtOrderSyncDataExample example) {
        BEGIN();
        DELETE_FROM("`th_lt_order_sync_data`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(ThLtOrderSyncData record) {
        BEGIN();
        INSERT_INTO("`th_lt_order_sync_data`");
        
        if (record.getCode() != null) {
            VALUES("`code`", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getChannel_code() != null) {
            VALUES("`channel_code`", "#{channel_code,jdbcType=VARCHAR}");
        }
        
        if (record.getExtend() != null) {
            VALUES("`extend`", "#{extend,jdbcType=VARCHAR}");
        }
        
        if (record.getCity_name() != null) {
            VALUES("`city_name`", "#{city_name,jdbcType=VARCHAR}");
        }
        
        if (record.getPacakge_code() != null) {
            VALUES("`pacakge_code`", "#{pacakge_code,jdbcType=VARCHAR}");
        }
        
        if (record.getPacakge_name() != null) {
            VALUES("`pacakge_name`", "#{pacakge_name,jdbcType=VARCHAR}");
        }
        
        if (record.getContract_period() != null) {
            VALUES("`contract_period`", "#{contract_period,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscount_amount() != null) {
            VALUES("`discount_amount`", "#{discount_amount,jdbcType=VARCHAR}");
        }
        
        if (record.getAccess_name() != null) {
            VALUES("`access_name`", "#{access_name,jdbcType=VARCHAR}");
        }
        
        if (record.getId_number() != null) {
            VALUES("`id_number`", "#{id_number,jdbcType=VARCHAR}");
        }
        
        if (record.getAddressee() != null) {
            VALUES("`addressee`", "#{addressee,jdbcType=VARCHAR}");
        }
        
        if (record.getAddressee_phone() != null) {
            VALUES("`addressee_phone`", "#{addressee_phone,jdbcType=VARCHAR}");
        }
        
        if (record.getDistrict_name() != null) {
            VALUES("`district_name`", "#{district_name,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            VALUES("`address`", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getSelected_phone_num() != null) {
            VALUES("`selected_phone_num`", "#{selected_phone_num,jdbcType=VARCHAR}");
        }
        
        if (record.getFreeze() != null) {
            VALUES("`freeze`", "#{freeze,jdbcType=VARCHAR}");
        }
        
        if (record.getFreeze_amount() != null) {
            VALUES("`freeze_amount`", "#{freeze_amount,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_create_time() != null) {
            VALUES("`order_create_time`", "#{order_create_time,jdbcType=VARCHAR}");
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

    public String selectByExample(ThLtOrderSyncDataExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("`id`");
        } else {
            SELECT("`id`");
        }
        SELECT("`code`");
        SELECT("`channel_code`");
        SELECT("`extend`");
        SELECT("`city_name`");
        SELECT("`pacakge_code`");
        SELECT("`pacakge_name`");
        SELECT("`contract_period`");
        SELECT("`discount_amount`");
        SELECT("`access_name`");
        SELECT("`id_number`");
        SELECT("`addressee`");
        SELECT("`addressee_phone`");
        SELECT("`district_name`");
        SELECT("`address`");
        SELECT("`selected_phone_num`");
        SELECT("`freeze`");
        SELECT("`freeze_amount`");
        SELECT("`order_create_time`");
        SELECT("`gmt_create`");
        SELECT("`gmt_modify`");
        SELECT("`creator_account`");
        SELECT("`modifier_account`");
        SELECT("`description`");
        FROM("`th_lt_order_sync_data`");
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
        ThLtOrderSyncData record = (ThLtOrderSyncData) parameter.get("record");
        ThLtOrderSyncDataExample example = (ThLtOrderSyncDataExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`th_lt_order_sync_data`");
        
        if (record.getId() != null) {
            SET("`id` = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getCode() != null) {
            SET("`code` = #{record.code,jdbcType=VARCHAR}");
        }
        
        if (record.getChannel_code() != null) {
            SET("`channel_code` = #{record.channel_code,jdbcType=VARCHAR}");
        }
        
        if (record.getExtend() != null) {
            SET("`extend` = #{record.extend,jdbcType=VARCHAR}");
        }
        
        if (record.getCity_name() != null) {
            SET("`city_name` = #{record.city_name,jdbcType=VARCHAR}");
        }
        
        if (record.getPacakge_code() != null) {
            SET("`pacakge_code` = #{record.pacakge_code,jdbcType=VARCHAR}");
        }
        
        if (record.getPacakge_name() != null) {
            SET("`pacakge_name` = #{record.pacakge_name,jdbcType=VARCHAR}");
        }
        
        if (record.getContract_period() != null) {
            SET("`contract_period` = #{record.contract_period,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscount_amount() != null) {
            SET("`discount_amount` = #{record.discount_amount,jdbcType=VARCHAR}");
        }
        
        if (record.getAccess_name() != null) {
            SET("`access_name` = #{record.access_name,jdbcType=VARCHAR}");
        }
        
        if (record.getId_number() != null) {
            SET("`id_number` = #{record.id_number,jdbcType=VARCHAR}");
        }
        
        if (record.getAddressee() != null) {
            SET("`addressee` = #{record.addressee,jdbcType=VARCHAR}");
        }
        
        if (record.getAddressee_phone() != null) {
            SET("`addressee_phone` = #{record.addressee_phone,jdbcType=VARCHAR}");
        }
        
        if (record.getDistrict_name() != null) {
            SET("`district_name` = #{record.district_name,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            SET("`address` = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getSelected_phone_num() != null) {
            SET("`selected_phone_num` = #{record.selected_phone_num,jdbcType=VARCHAR}");
        }
        
        if (record.getFreeze() != null) {
            SET("`freeze` = #{record.freeze,jdbcType=VARCHAR}");
        }
        
        if (record.getFreeze_amount() != null) {
            SET("`freeze_amount` = #{record.freeze_amount,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_create_time() != null) {
            SET("`order_create_time` = #{record.order_create_time,jdbcType=VARCHAR}");
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
        UPDATE("`th_lt_order_sync_data`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`code` = #{record.code,jdbcType=VARCHAR}");
        SET("`channel_code` = #{record.channel_code,jdbcType=VARCHAR}");
        SET("`extend` = #{record.extend,jdbcType=VARCHAR}");
        SET("`city_name` = #{record.city_name,jdbcType=VARCHAR}");
        SET("`pacakge_code` = #{record.pacakge_code,jdbcType=VARCHAR}");
        SET("`pacakge_name` = #{record.pacakge_name,jdbcType=VARCHAR}");
        SET("`contract_period` = #{record.contract_period,jdbcType=VARCHAR}");
        SET("`discount_amount` = #{record.discount_amount,jdbcType=VARCHAR}");
        SET("`access_name` = #{record.access_name,jdbcType=VARCHAR}");
        SET("`id_number` = #{record.id_number,jdbcType=VARCHAR}");
        SET("`addressee` = #{record.addressee,jdbcType=VARCHAR}");
        SET("`addressee_phone` = #{record.addressee_phone,jdbcType=VARCHAR}");
        SET("`district_name` = #{record.district_name,jdbcType=VARCHAR}");
        SET("`address` = #{record.address,jdbcType=VARCHAR}");
        SET("`selected_phone_num` = #{record.selected_phone_num,jdbcType=VARCHAR}");
        SET("`freeze` = #{record.freeze,jdbcType=VARCHAR}");
        SET("`freeze_amount` = #{record.freeze_amount,jdbcType=VARCHAR}");
        SET("`order_create_time` = #{record.order_create_time,jdbcType=VARCHAR}");
        SET("`gmt_create` = #{record.gmt_create,jdbcType=TIMESTAMP}");
        SET("`gmt_modify` = #{record.gmt_modify,jdbcType=TIMESTAMP}");
        SET("`creator_account` = #{record.creator_account,jdbcType=VARCHAR}");
        SET("`modifier_account` = #{record.modifier_account,jdbcType=VARCHAR}");
        SET("`description` = #{record.description,jdbcType=VARCHAR}");
        
        ThLtOrderSyncDataExample example = (ThLtOrderSyncDataExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(ThLtOrderSyncData record) {
        BEGIN();
        UPDATE("`th_lt_order_sync_data`");
        
        if (record.getCode() != null) {
            SET("`code` = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getChannel_code() != null) {
            SET("`channel_code` = #{channel_code,jdbcType=VARCHAR}");
        }
        
        if (record.getExtend() != null) {
            SET("`extend` = #{extend,jdbcType=VARCHAR}");
        }
        
        if (record.getCity_name() != null) {
            SET("`city_name` = #{city_name,jdbcType=VARCHAR}");
        }
        
        if (record.getPacakge_code() != null) {
            SET("`pacakge_code` = #{pacakge_code,jdbcType=VARCHAR}");
        }
        
        if (record.getPacakge_name() != null) {
            SET("`pacakge_name` = #{pacakge_name,jdbcType=VARCHAR}");
        }
        
        if (record.getContract_period() != null) {
            SET("`contract_period` = #{contract_period,jdbcType=VARCHAR}");
        }
        
        if (record.getDiscount_amount() != null) {
            SET("`discount_amount` = #{discount_amount,jdbcType=VARCHAR}");
        }
        
        if (record.getAccess_name() != null) {
            SET("`access_name` = #{access_name,jdbcType=VARCHAR}");
        }
        
        if (record.getId_number() != null) {
            SET("`id_number` = #{id_number,jdbcType=VARCHAR}");
        }
        
        if (record.getAddressee() != null) {
            SET("`addressee` = #{addressee,jdbcType=VARCHAR}");
        }
        
        if (record.getAddressee_phone() != null) {
            SET("`addressee_phone` = #{addressee_phone,jdbcType=VARCHAR}");
        }
        
        if (record.getDistrict_name() != null) {
            SET("`district_name` = #{district_name,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            SET("`address` = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getSelected_phone_num() != null) {
            SET("`selected_phone_num` = #{selected_phone_num,jdbcType=VARCHAR}");
        }
        
        if (record.getFreeze() != null) {
            SET("`freeze` = #{freeze,jdbcType=VARCHAR}");
        }
        
        if (record.getFreeze_amount() != null) {
            SET("`freeze_amount` = #{freeze_amount,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_create_time() != null) {
            SET("`order_create_time` = #{order_create_time,jdbcType=VARCHAR}");
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

    protected void applyWhere(ThLtOrderSyncDataExample example, boolean includeExamplePhrase) {
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
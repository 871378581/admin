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

import com.segama.ege.entity.ThOrderManage;
import com.segama.ege.entity.ThOrderManageExample.Criteria;
import com.segama.ege.entity.ThOrderManageExample.Criterion;
import com.segama.ege.entity.ThOrderManageExample;
import java.util.List;
import java.util.Map;

public class ThOrderManageSqlProvider {

    public String countByExample(ThOrderManageExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("`th_order_manage`");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(ThOrderManageExample example) {
        BEGIN();
        DELETE_FROM("`th_order_manage`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(ThOrderManage record) {
        BEGIN();
        INSERT_INTO("`th_order_manage`");
        
        if (record.getOperate_type() != null) {
            VALUES("`operate_type`", "#{operate_type,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_code() != null) {
            VALUES("`order_code`", "#{order_code,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_time() != null) {
            VALUES("`order_time`", "#{order_time,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_phone_number() != null) {
            VALUES("`order_phone_number`", "#{order_phone_number,jdbcType=VARCHAR}");
        }
        
        if (record.getProv() != null) {
            VALUES("`prov`", "#{prov,jdbcType=VARCHAR}");
        }
        
        if (record.getCity() != null) {
            VALUES("`city`", "#{city,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_status() != null) {
            VALUES("`order_status`", "#{order_status,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomer_name() != null) {
            VALUES("`customer_name`", "#{customer_name,jdbcType=VARCHAR}");
        }
        
        if (record.getCertificate_type() != null) {
            VALUES("`certificate_type`", "#{certificate_type,jdbcType=VARCHAR}");
        }
        
        if (record.getCertificate_num() != null) {
            VALUES("`certificate_num`", "#{certificate_num,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomer_contact_num() != null) {
            VALUES("`customer_contact_num`", "#{customer_contact_num,jdbcType=VARCHAR}");
        }
        
        if (record.getGood_name() != null) {
            VALUES("`good_name`", "#{good_name,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            VALUES("`address`", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getActive_status() != null) {
            VALUES("`active_status`", "#{active_status,jdbcType=VARCHAR}");
        }
        
        if (record.getCudian_code() != null) {
            VALUES("`cudian_code`", "#{cudian_code,jdbcType=VARCHAR}");
        }
        
        if (record.getShoucong_amt() != null) {
            VALUES("`shoucong_amt`", "#{shoucong_amt,jdbcType=VARCHAR}");
        }
        
        if (record.getShoucong_time() != null) {
            VALUES("`shoucong_time`", "#{shoucong_time,jdbcType=VARCHAR}");
        }
        
        if (record.getXiehaozhuanwang_type() != null) {
            VALUES("`xiehaozhuanwang_type`", "#{xiehaozhuanwang_type,jdbcType=VARCHAR}");
        }
        
        if (record.getZhuanhualvtichu_reason() != null) {
            VALUES("`zhuanhualvtichu_reason`", "#{zhuanhualvtichu_reason,jdbcType=VARCHAR}");
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
        
        if (record.getChannel_account() != null) {
            VALUES("`channel_account`", "#{channel_account,jdbcType=VARCHAR}");
        }
        
        if (record.getChannel_code() != null) {
            VALUES("`channel_code`", "#{channel_code,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(ThOrderManageExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("`id`");
        } else {
            SELECT("`id`");
        }
        SELECT("`operate_type`");
        SELECT("`order_code`");
        SELECT("`order_time`");
        SELECT("`order_phone_number`");
        SELECT("`prov`");
        SELECT("`city`");
        SELECT("`order_status`");
        SELECT("`customer_name`");
        SELECT("`certificate_type`");
        SELECT("`certificate_num`");
        SELECT("`customer_contact_num`");
        SELECT("`good_name`");
        SELECT("`address`");
        SELECT("`active_status`");
        SELECT("`cudian_code`");
        SELECT("`shoucong_amt`");
        SELECT("`shoucong_time`");
        SELECT("`xiehaozhuanwang_type`");
        SELECT("`zhuanhualvtichu_reason`");
        SELECT("`gmt_create`");
        SELECT("`gmt_modify`");
        SELECT("`creator_account`");
        SELECT("`modifier_account`");
        SELECT("`description`");
        SELECT("`channel_account`");
        SELECT("`channel_code`");
        FROM("`th_order_manage`");
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
        ThOrderManage record = (ThOrderManage) parameter.get("record");
        ThOrderManageExample example = (ThOrderManageExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`th_order_manage`");
        
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
        
        if (record.getOrder_phone_number() != null) {
            SET("`order_phone_number` = #{record.order_phone_number,jdbcType=VARCHAR}");
        }
        
        if (record.getProv() != null) {
            SET("`prov` = #{record.prov,jdbcType=VARCHAR}");
        }
        
        if (record.getCity() != null) {
            SET("`city` = #{record.city,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_status() != null) {
            SET("`order_status` = #{record.order_status,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomer_name() != null) {
            SET("`customer_name` = #{record.customer_name,jdbcType=VARCHAR}");
        }
        
        if (record.getCertificate_type() != null) {
            SET("`certificate_type` = #{record.certificate_type,jdbcType=VARCHAR}");
        }
        
        if (record.getCertificate_num() != null) {
            SET("`certificate_num` = #{record.certificate_num,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomer_contact_num() != null) {
            SET("`customer_contact_num` = #{record.customer_contact_num,jdbcType=VARCHAR}");
        }
        
        if (record.getGood_name() != null) {
            SET("`good_name` = #{record.good_name,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            SET("`address` = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getActive_status() != null) {
            SET("`active_status` = #{record.active_status,jdbcType=VARCHAR}");
        }
        
        if (record.getCudian_code() != null) {
            SET("`cudian_code` = #{record.cudian_code,jdbcType=VARCHAR}");
        }
        
        if (record.getShoucong_amt() != null) {
            SET("`shoucong_amt` = #{record.shoucong_amt,jdbcType=VARCHAR}");
        }
        
        if (record.getShoucong_time() != null) {
            SET("`shoucong_time` = #{record.shoucong_time,jdbcType=VARCHAR}");
        }
        
        if (record.getXiehaozhuanwang_type() != null) {
            SET("`xiehaozhuanwang_type` = #{record.xiehaozhuanwang_type,jdbcType=VARCHAR}");
        }
        
        if (record.getZhuanhualvtichu_reason() != null) {
            SET("`zhuanhualvtichu_reason` = #{record.zhuanhualvtichu_reason,jdbcType=VARCHAR}");
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
        
        if (record.getChannel_account() != null) {
            SET("`channel_account` = #{record.channel_account,jdbcType=VARCHAR}");
        }
        
        if (record.getChannel_code() != null) {
            SET("`channel_code` = #{record.channel_code,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`th_order_manage`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`operate_type` = #{record.operate_type,jdbcType=VARCHAR}");
        SET("`order_code` = #{record.order_code,jdbcType=VARCHAR}");
        SET("`order_time` = #{record.order_time,jdbcType=VARCHAR}");
        SET("`order_phone_number` = #{record.order_phone_number,jdbcType=VARCHAR}");
        SET("`prov` = #{record.prov,jdbcType=VARCHAR}");
        SET("`city` = #{record.city,jdbcType=VARCHAR}");
        SET("`order_status` = #{record.order_status,jdbcType=VARCHAR}");
        SET("`customer_name` = #{record.customer_name,jdbcType=VARCHAR}");
        SET("`certificate_type` = #{record.certificate_type,jdbcType=VARCHAR}");
        SET("`certificate_num` = #{record.certificate_num,jdbcType=VARCHAR}");
        SET("`customer_contact_num` = #{record.customer_contact_num,jdbcType=VARCHAR}");
        SET("`good_name` = #{record.good_name,jdbcType=VARCHAR}");
        SET("`address` = #{record.address,jdbcType=VARCHAR}");
        SET("`active_status` = #{record.active_status,jdbcType=VARCHAR}");
        SET("`cudian_code` = #{record.cudian_code,jdbcType=VARCHAR}");
        SET("`shoucong_amt` = #{record.shoucong_amt,jdbcType=VARCHAR}");
        SET("`shoucong_time` = #{record.shoucong_time,jdbcType=VARCHAR}");
        SET("`xiehaozhuanwang_type` = #{record.xiehaozhuanwang_type,jdbcType=VARCHAR}");
        SET("`zhuanhualvtichu_reason` = #{record.zhuanhualvtichu_reason,jdbcType=VARCHAR}");
        SET("`gmt_create` = #{record.gmt_create,jdbcType=TIMESTAMP}");
        SET("`gmt_modify` = #{record.gmt_modify,jdbcType=TIMESTAMP}");
        SET("`creator_account` = #{record.creator_account,jdbcType=VARCHAR}");
        SET("`modifier_account` = #{record.modifier_account,jdbcType=VARCHAR}");
        SET("`description` = #{record.description,jdbcType=VARCHAR}");
        SET("`channel_account` = #{record.channel_account,jdbcType=VARCHAR}");
        SET("`channel_code` = #{record.channel_code,jdbcType=VARCHAR}");
        
        ThOrderManageExample example = (ThOrderManageExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(ThOrderManage record) {
        BEGIN();
        UPDATE("`th_order_manage`");
        
        if (record.getOperate_type() != null) {
            SET("`operate_type` = #{operate_type,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_code() != null) {
            SET("`order_code` = #{order_code,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_time() != null) {
            SET("`order_time` = #{order_time,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_phone_number() != null) {
            SET("`order_phone_number` = #{order_phone_number,jdbcType=VARCHAR}");
        }
        
        if (record.getProv() != null) {
            SET("`prov` = #{prov,jdbcType=VARCHAR}");
        }
        
        if (record.getCity() != null) {
            SET("`city` = #{city,jdbcType=VARCHAR}");
        }
        
        if (record.getOrder_status() != null) {
            SET("`order_status` = #{order_status,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomer_name() != null) {
            SET("`customer_name` = #{customer_name,jdbcType=VARCHAR}");
        }
        
        if (record.getCertificate_type() != null) {
            SET("`certificate_type` = #{certificate_type,jdbcType=VARCHAR}");
        }
        
        if (record.getCertificate_num() != null) {
            SET("`certificate_num` = #{certificate_num,jdbcType=VARCHAR}");
        }
        
        if (record.getCustomer_contact_num() != null) {
            SET("`customer_contact_num` = #{customer_contact_num,jdbcType=VARCHAR}");
        }
        
        if (record.getGood_name() != null) {
            SET("`good_name` = #{good_name,jdbcType=VARCHAR}");
        }
        
        if (record.getAddress() != null) {
            SET("`address` = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getActive_status() != null) {
            SET("`active_status` = #{active_status,jdbcType=VARCHAR}");
        }
        
        if (record.getCudian_code() != null) {
            SET("`cudian_code` = #{cudian_code,jdbcType=VARCHAR}");
        }
        
        if (record.getShoucong_amt() != null) {
            SET("`shoucong_amt` = #{shoucong_amt,jdbcType=VARCHAR}");
        }
        
        if (record.getShoucong_time() != null) {
            SET("`shoucong_time` = #{shoucong_time,jdbcType=VARCHAR}");
        }
        
        if (record.getXiehaozhuanwang_type() != null) {
            SET("`xiehaozhuanwang_type` = #{xiehaozhuanwang_type,jdbcType=VARCHAR}");
        }
        
        if (record.getZhuanhualvtichu_reason() != null) {
            SET("`zhuanhualvtichu_reason` = #{zhuanhualvtichu_reason,jdbcType=VARCHAR}");
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
        
        if (record.getChannel_account() != null) {
            SET("`channel_account` = #{channel_account,jdbcType=VARCHAR}");
        }
        
        if (record.getChannel_code() != null) {
            SET("`channel_code` = #{channel_code,jdbcType=VARCHAR}");
        }
        
        WHERE("`id` = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(ThOrderManageExample example, boolean includeExamplePhrase) {
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
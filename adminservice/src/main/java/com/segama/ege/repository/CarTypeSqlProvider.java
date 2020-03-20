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

import com.segama.ege.entity.CarType;
import com.segama.ege.entity.CarTypeExample.Criteria;
import com.segama.ege.entity.CarTypeExample.Criterion;
import com.segama.ege.entity.CarTypeExample;
import java.util.List;
import java.util.Map;

public class CarTypeSqlProvider {

    public String countByExample(CarTypeExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("`car_type`");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(CarTypeExample example) {
        BEGIN();
        DELETE_FROM("`car_type`");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(CarType record) {
        BEGIN();
        INSERT_INTO("`car_type`");
        
        if (record.getBrand() != null) {
            VALUES("`brand`", "#{brand,jdbcType=VARCHAR}");
        }
        
        if (record.getBrand_code() != null) {
            VALUES("`brand_code`", "#{brand_code,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_type() != null) {
            VALUES("`car_type`", "#{car_type,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_type_code() != null) {
            VALUES("`car_type_code`", "#{car_type_code,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_style() != null) {
            VALUES("`car_style`", "#{car_style,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_style_code() != null) {
            VALUES("`car_style_code`", "#{car_style_code,jdbcType=VARCHAR}");
        }
        
        if (record.getBrand_first_letter() != null) {
            VALUES("`brand_first_letter`", "#{brand_first_letter,jdbcType=VARCHAR}");
        }
        
        if (record.getCategory_code() != null) {
            VALUES("`category_code`", "#{category_code,jdbcType=VARCHAR}");
        }
        
        if (record.getCategory_name() != null) {
            VALUES("`category_name`", "#{category_name,jdbcType=VARCHAR}");
        }
        
        if (record.getCategory_level() != null) {
            VALUES("`category_level`", "#{category_level,jdbcType=BIGINT}");
        }
        
        if (record.getParent_category_code() != null) {
            VALUES("`parent_category_code`", "#{parent_category_code,jdbcType=VARCHAR}");
        }
        
        if (record.getLogo_url() != null) {
            VALUES("`logo_url`", "#{logo_url,jdbcType=VARCHAR}");
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
        
        return SQL();
    }

    public String selectByExample(CarTypeExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("`id`");
        } else {
            SELECT("`id`");
        }
        SELECT("`brand`");
        SELECT("`brand_code`");
        SELECT("`car_type`");
        SELECT("`car_type_code`");
        SELECT("`car_style`");
        SELECT("`car_style_code`");
        SELECT("`brand_first_letter`");
        SELECT("`category_code`");
        SELECT("`category_name`");
        SELECT("`category_level`");
        SELECT("`parent_category_code`");
        SELECT("`logo_url`");
        SELECT("`gmt_create`");
        SELECT("`gmt_modify`");
        SELECT("`creator_account`");
        SELECT("`modifier_account`");
        FROM("`car_type`");
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
        CarType record = (CarType) parameter.get("record");
        CarTypeExample example = (CarTypeExample) parameter.get("example");
        
        BEGIN();
        UPDATE("`car_type`");
        
        if (record.getId() != null) {
            SET("`id` = #{record.id,jdbcType=BIGINT}");
        }
        
        if (record.getBrand() != null) {
            SET("`brand` = #{record.brand,jdbcType=VARCHAR}");
        }
        
        if (record.getBrand_code() != null) {
            SET("`brand_code` = #{record.brand_code,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_type() != null) {
            SET("`car_type` = #{record.car_type,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_type_code() != null) {
            SET("`car_type_code` = #{record.car_type_code,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_style() != null) {
            SET("`car_style` = #{record.car_style,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_style_code() != null) {
            SET("`car_style_code` = #{record.car_style_code,jdbcType=VARCHAR}");
        }
        
        if (record.getBrand_first_letter() != null) {
            SET("`brand_first_letter` = #{record.brand_first_letter,jdbcType=VARCHAR}");
        }
        
        if (record.getCategory_code() != null) {
            SET("`category_code` = #{record.category_code,jdbcType=VARCHAR}");
        }
        
        if (record.getCategory_name() != null) {
            SET("`category_name` = #{record.category_name,jdbcType=VARCHAR}");
        }
        
        if (record.getCategory_level() != null) {
            SET("`category_level` = #{record.category_level,jdbcType=BIGINT}");
        }
        
        if (record.getParent_category_code() != null) {
            SET("`parent_category_code` = #{record.parent_category_code,jdbcType=VARCHAR}");
        }
        
        if (record.getLogo_url() != null) {
            SET("`logo_url` = #{record.logo_url,jdbcType=VARCHAR}");
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
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("`car_type`");
        
        SET("`id` = #{record.id,jdbcType=BIGINT}");
        SET("`brand` = #{record.brand,jdbcType=VARCHAR}");
        SET("`brand_code` = #{record.brand_code,jdbcType=VARCHAR}");
        SET("`car_type` = #{record.car_type,jdbcType=VARCHAR}");
        SET("`car_type_code` = #{record.car_type_code,jdbcType=VARCHAR}");
        SET("`car_style` = #{record.car_style,jdbcType=VARCHAR}");
        SET("`car_style_code` = #{record.car_style_code,jdbcType=VARCHAR}");
        SET("`brand_first_letter` = #{record.brand_first_letter,jdbcType=VARCHAR}");
        SET("`category_code` = #{record.category_code,jdbcType=VARCHAR}");
        SET("`category_name` = #{record.category_name,jdbcType=VARCHAR}");
        SET("`category_level` = #{record.category_level,jdbcType=BIGINT}");
        SET("`parent_category_code` = #{record.parent_category_code,jdbcType=VARCHAR}");
        SET("`logo_url` = #{record.logo_url,jdbcType=VARCHAR}");
        SET("`gmt_create` = #{record.gmt_create,jdbcType=TIMESTAMP}");
        SET("`gmt_modify` = #{record.gmt_modify,jdbcType=TIMESTAMP}");
        SET("`creator_account` = #{record.creator_account,jdbcType=VARCHAR}");
        SET("`modifier_account` = #{record.modifier_account,jdbcType=VARCHAR}");
        
        CarTypeExample example = (CarTypeExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(CarType record) {
        BEGIN();
        UPDATE("`car_type`");
        
        if (record.getBrand() != null) {
            SET("`brand` = #{brand,jdbcType=VARCHAR}");
        }
        
        if (record.getBrand_code() != null) {
            SET("`brand_code` = #{brand_code,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_type() != null) {
            SET("`car_type` = #{car_type,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_type_code() != null) {
            SET("`car_type_code` = #{car_type_code,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_style() != null) {
            SET("`car_style` = #{car_style,jdbcType=VARCHAR}");
        }
        
        if (record.getCar_style_code() != null) {
            SET("`car_style_code` = #{car_style_code,jdbcType=VARCHAR}");
        }
        
        if (record.getBrand_first_letter() != null) {
            SET("`brand_first_letter` = #{brand_first_letter,jdbcType=VARCHAR}");
        }
        
        if (record.getCategory_code() != null) {
            SET("`category_code` = #{category_code,jdbcType=VARCHAR}");
        }
        
        if (record.getCategory_name() != null) {
            SET("`category_name` = #{category_name,jdbcType=VARCHAR}");
        }
        
        if (record.getCategory_level() != null) {
            SET("`category_level` = #{category_level,jdbcType=BIGINT}");
        }
        
        if (record.getParent_category_code() != null) {
            SET("`parent_category_code` = #{parent_category_code,jdbcType=VARCHAR}");
        }
        
        if (record.getLogo_url() != null) {
            SET("`logo_url` = #{logo_url,jdbcType=VARCHAR}");
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
        
        WHERE("`id` = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }

    protected void applyWhere(CarTypeExample example, boolean includeExamplePhrase) {
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
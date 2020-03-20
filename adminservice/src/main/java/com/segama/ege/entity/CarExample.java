package com.segama.ege.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public CarExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex=pageIndex;
    }

    public Integer getPageIndex() {
        return this.pageIndex;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount=pageCount;
    }

    public Integer getPageCount() {
        return this.pageCount;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("`id` is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("`id` is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("`id` =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("`id` <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("`id` >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("`id` >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("`id` <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("`id` <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("`id` in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("`id` not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("`id` between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("`id` not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNull() {
            addCriterion("`user_id` is null");
            return (Criteria) this;
        }

        public Criteria andUser_idIsNotNull() {
            addCriterion("`user_id` is not null");
            return (Criteria) this;
        }

        public Criteria andUser_idEqualTo(String value) {
            addCriterion("`user_id` =", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotEqualTo(String value) {
            addCriterion("`user_id` <>", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThan(String value) {
            addCriterion("`user_id` >", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idGreaterThanOrEqualTo(String value) {
            addCriterion("`user_id` >=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThan(String value) {
            addCriterion("`user_id` <", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLessThanOrEqualTo(String value) {
            addCriterion("`user_id` <=", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idLike(String value) {
            addCriterion("`user_id` like", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotLike(String value) {
            addCriterion("`user_id` not like", value, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idIn(List<String> values) {
            addCriterion("`user_id` in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotIn(List<String> values) {
            addCriterion("`user_id` not in", values, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idBetween(String value1, String value2) {
            addCriterion("`user_id` between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andUser_idNotBetween(String value1, String value2) {
            addCriterion("`user_id` not between", value1, value2, "user_id");
            return (Criteria) this;
        }

        public Criteria andPlateIsNull() {
            addCriterion("`plate` is null");
            return (Criteria) this;
        }

        public Criteria andPlateIsNotNull() {
            addCriterion("`plate` is not null");
            return (Criteria) this;
        }

        public Criteria andPlateEqualTo(String value) {
            addCriterion("`plate` =", value, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateNotEqualTo(String value) {
            addCriterion("`plate` <>", value, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateGreaterThan(String value) {
            addCriterion("`plate` >", value, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateGreaterThanOrEqualTo(String value) {
            addCriterion("`plate` >=", value, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateLessThan(String value) {
            addCriterion("`plate` <", value, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateLessThanOrEqualTo(String value) {
            addCriterion("`plate` <=", value, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateLike(String value) {
            addCriterion("`plate` like", value, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateNotLike(String value) {
            addCriterion("`plate` not like", value, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateIn(List<String> values) {
            addCriterion("`plate` in", values, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateNotIn(List<String> values) {
            addCriterion("`plate` not in", values, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateBetween(String value1, String value2) {
            addCriterion("`plate` between", value1, value2, "plate");
            return (Criteria) this;
        }

        public Criteria andPlateNotBetween(String value1, String value2) {
            addCriterion("`plate` not between", value1, value2, "plate");
            return (Criteria) this;
        }

        public Criteria andCar_type_idIsNull() {
            addCriterion("`car_type_id` is null");
            return (Criteria) this;
        }

        public Criteria andCar_type_idIsNotNull() {
            addCriterion("`car_type_id` is not null");
            return (Criteria) this;
        }

        public Criteria andCar_type_idEqualTo(Long value) {
            addCriterion("`car_type_id` =", value, "car_type_id");
            return (Criteria) this;
        }

        public Criteria andCar_type_idNotEqualTo(Long value) {
            addCriterion("`car_type_id` <>", value, "car_type_id");
            return (Criteria) this;
        }

        public Criteria andCar_type_idGreaterThan(Long value) {
            addCriterion("`car_type_id` >", value, "car_type_id");
            return (Criteria) this;
        }

        public Criteria andCar_type_idGreaterThanOrEqualTo(Long value) {
            addCriterion("`car_type_id` >=", value, "car_type_id");
            return (Criteria) this;
        }

        public Criteria andCar_type_idLessThan(Long value) {
            addCriterion("`car_type_id` <", value, "car_type_id");
            return (Criteria) this;
        }

        public Criteria andCar_type_idLessThanOrEqualTo(Long value) {
            addCriterion("`car_type_id` <=", value, "car_type_id");
            return (Criteria) this;
        }

        public Criteria andCar_type_idIn(List<Long> values) {
            addCriterion("`car_type_id` in", values, "car_type_id");
            return (Criteria) this;
        }

        public Criteria andCar_type_idNotIn(List<Long> values) {
            addCriterion("`car_type_id` not in", values, "car_type_id");
            return (Criteria) this;
        }

        public Criteria andCar_type_idBetween(Long value1, Long value2) {
            addCriterion("`car_type_id` between", value1, value2, "car_type_id");
            return (Criteria) this;
        }

        public Criteria andCar_type_idNotBetween(Long value1, Long value2) {
            addCriterion("`car_type_id` not between", value1, value2, "car_type_id");
            return (Criteria) this;
        }

        public Criteria andCar_type_nameIsNull() {
            addCriterion("`car_type_name` is null");
            return (Criteria) this;
        }

        public Criteria andCar_type_nameIsNotNull() {
            addCriterion("`car_type_name` is not null");
            return (Criteria) this;
        }

        public Criteria andCar_type_nameEqualTo(String value) {
            addCriterion("`car_type_name` =", value, "car_type_name");
            return (Criteria) this;
        }

        public Criteria andCar_type_nameNotEqualTo(String value) {
            addCriterion("`car_type_name` <>", value, "car_type_name");
            return (Criteria) this;
        }

        public Criteria andCar_type_nameGreaterThan(String value) {
            addCriterion("`car_type_name` >", value, "car_type_name");
            return (Criteria) this;
        }

        public Criteria andCar_type_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`car_type_name` >=", value, "car_type_name");
            return (Criteria) this;
        }

        public Criteria andCar_type_nameLessThan(String value) {
            addCriterion("`car_type_name` <", value, "car_type_name");
            return (Criteria) this;
        }

        public Criteria andCar_type_nameLessThanOrEqualTo(String value) {
            addCriterion("`car_type_name` <=", value, "car_type_name");
            return (Criteria) this;
        }

        public Criteria andCar_type_nameLike(String value) {
            addCriterion("`car_type_name` like", value, "car_type_name");
            return (Criteria) this;
        }

        public Criteria andCar_type_nameNotLike(String value) {
            addCriterion("`car_type_name` not like", value, "car_type_name");
            return (Criteria) this;
        }

        public Criteria andCar_type_nameIn(List<String> values) {
            addCriterion("`car_type_name` in", values, "car_type_name");
            return (Criteria) this;
        }

        public Criteria andCar_type_nameNotIn(List<String> values) {
            addCriterion("`car_type_name` not in", values, "car_type_name");
            return (Criteria) this;
        }

        public Criteria andCar_type_nameBetween(String value1, String value2) {
            addCriterion("`car_type_name` between", value1, value2, "car_type_name");
            return (Criteria) this;
        }

        public Criteria andCar_type_nameNotBetween(String value1, String value2) {
            addCriterion("`car_type_name` not between", value1, value2, "car_type_name");
            return (Criteria) this;
        }

        public Criteria andCar_type_colorIsNull() {
            addCriterion("`car_type_color` is null");
            return (Criteria) this;
        }

        public Criteria andCar_type_colorIsNotNull() {
            addCriterion("`car_type_color` is not null");
            return (Criteria) this;
        }

        public Criteria andCar_type_colorEqualTo(String value) {
            addCriterion("`car_type_color` =", value, "car_type_color");
            return (Criteria) this;
        }

        public Criteria andCar_type_colorNotEqualTo(String value) {
            addCriterion("`car_type_color` <>", value, "car_type_color");
            return (Criteria) this;
        }

        public Criteria andCar_type_colorGreaterThan(String value) {
            addCriterion("`car_type_color` >", value, "car_type_color");
            return (Criteria) this;
        }

        public Criteria andCar_type_colorGreaterThanOrEqualTo(String value) {
            addCriterion("`car_type_color` >=", value, "car_type_color");
            return (Criteria) this;
        }

        public Criteria andCar_type_colorLessThan(String value) {
            addCriterion("`car_type_color` <", value, "car_type_color");
            return (Criteria) this;
        }

        public Criteria andCar_type_colorLessThanOrEqualTo(String value) {
            addCriterion("`car_type_color` <=", value, "car_type_color");
            return (Criteria) this;
        }

        public Criteria andCar_type_colorLike(String value) {
            addCriterion("`car_type_color` like", value, "car_type_color");
            return (Criteria) this;
        }

        public Criteria andCar_type_colorNotLike(String value) {
            addCriterion("`car_type_color` not like", value, "car_type_color");
            return (Criteria) this;
        }

        public Criteria andCar_type_colorIn(List<String> values) {
            addCriterion("`car_type_color` in", values, "car_type_color");
            return (Criteria) this;
        }

        public Criteria andCar_type_colorNotIn(List<String> values) {
            addCriterion("`car_type_color` not in", values, "car_type_color");
            return (Criteria) this;
        }

        public Criteria andCar_type_colorBetween(String value1, String value2) {
            addCriterion("`car_type_color` between", value1, value2, "car_type_color");
            return (Criteria) this;
        }

        public Criteria andCar_type_colorNotBetween(String value1, String value2) {
            addCriterion("`car_type_color` not between", value1, value2, "car_type_color");
            return (Criteria) this;
        }

        public Criteria andCar_logo_urlIsNull() {
            addCriterion("`car_logo_url` is null");
            return (Criteria) this;
        }

        public Criteria andCar_logo_urlIsNotNull() {
            addCriterion("`car_logo_url` is not null");
            return (Criteria) this;
        }

        public Criteria andCar_logo_urlEqualTo(String value) {
            addCriterion("`car_logo_url` =", value, "car_logo_url");
            return (Criteria) this;
        }

        public Criteria andCar_logo_urlNotEqualTo(String value) {
            addCriterion("`car_logo_url` <>", value, "car_logo_url");
            return (Criteria) this;
        }

        public Criteria andCar_logo_urlGreaterThan(String value) {
            addCriterion("`car_logo_url` >", value, "car_logo_url");
            return (Criteria) this;
        }

        public Criteria andCar_logo_urlGreaterThanOrEqualTo(String value) {
            addCriterion("`car_logo_url` >=", value, "car_logo_url");
            return (Criteria) this;
        }

        public Criteria andCar_logo_urlLessThan(String value) {
            addCriterion("`car_logo_url` <", value, "car_logo_url");
            return (Criteria) this;
        }

        public Criteria andCar_logo_urlLessThanOrEqualTo(String value) {
            addCriterion("`car_logo_url` <=", value, "car_logo_url");
            return (Criteria) this;
        }

        public Criteria andCar_logo_urlLike(String value) {
            addCriterion("`car_logo_url` like", value, "car_logo_url");
            return (Criteria) this;
        }

        public Criteria andCar_logo_urlNotLike(String value) {
            addCriterion("`car_logo_url` not like", value, "car_logo_url");
            return (Criteria) this;
        }

        public Criteria andCar_logo_urlIn(List<String> values) {
            addCriterion("`car_logo_url` in", values, "car_logo_url");
            return (Criteria) this;
        }

        public Criteria andCar_logo_urlNotIn(List<String> values) {
            addCriterion("`car_logo_url` not in", values, "car_logo_url");
            return (Criteria) this;
        }

        public Criteria andCar_logo_urlBetween(String value1, String value2) {
            addCriterion("`car_logo_url` between", value1, value2, "car_logo_url");
            return (Criteria) this;
        }

        public Criteria andCar_logo_urlNotBetween(String value1, String value2) {
            addCriterion("`car_logo_url` not between", value1, value2, "car_logo_url");
            return (Criteria) this;
        }

        public Criteria andGmt_last_maintenanceIsNull() {
            addCriterion("`gmt_last_maintenance` is null");
            return (Criteria) this;
        }

        public Criteria andGmt_last_maintenanceIsNotNull() {
            addCriterion("`gmt_last_maintenance` is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_last_maintenanceEqualTo(Date value) {
            addCriterion("`gmt_last_maintenance` =", value, "gmt_last_maintenance");
            return (Criteria) this;
        }

        public Criteria andGmt_last_maintenanceNotEqualTo(Date value) {
            addCriterion("`gmt_last_maintenance` <>", value, "gmt_last_maintenance");
            return (Criteria) this;
        }

        public Criteria andGmt_last_maintenanceGreaterThan(Date value) {
            addCriterion("`gmt_last_maintenance` >", value, "gmt_last_maintenance");
            return (Criteria) this;
        }

        public Criteria andGmt_last_maintenanceGreaterThanOrEqualTo(Date value) {
            addCriterion("`gmt_last_maintenance` >=", value, "gmt_last_maintenance");
            return (Criteria) this;
        }

        public Criteria andGmt_last_maintenanceLessThan(Date value) {
            addCriterion("`gmt_last_maintenance` <", value, "gmt_last_maintenance");
            return (Criteria) this;
        }

        public Criteria andGmt_last_maintenanceLessThanOrEqualTo(Date value) {
            addCriterion("`gmt_last_maintenance` <=", value, "gmt_last_maintenance");
            return (Criteria) this;
        }

        public Criteria andGmt_last_maintenanceIn(List<Date> values) {
            addCriterion("`gmt_last_maintenance` in", values, "gmt_last_maintenance");
            return (Criteria) this;
        }

        public Criteria andGmt_last_maintenanceNotIn(List<Date> values) {
            addCriterion("`gmt_last_maintenance` not in", values, "gmt_last_maintenance");
            return (Criteria) this;
        }

        public Criteria andGmt_last_maintenanceBetween(Date value1, Date value2) {
            addCriterion("`gmt_last_maintenance` between", value1, value2, "gmt_last_maintenance");
            return (Criteria) this;
        }

        public Criteria andGmt_last_maintenanceNotBetween(Date value1, Date value2) {
            addCriterion("`gmt_last_maintenance` not between", value1, value2, "gmt_last_maintenance");
            return (Criteria) this;
        }

        public Criteria andMembership_card_idIsNull() {
            addCriterion("`membership_card_id` is null");
            return (Criteria) this;
        }

        public Criteria andMembership_card_idIsNotNull() {
            addCriterion("`membership_card_id` is not null");
            return (Criteria) this;
        }

        public Criteria andMembership_card_idEqualTo(String value) {
            addCriterion("`membership_card_id` =", value, "membership_card_id");
            return (Criteria) this;
        }

        public Criteria andMembership_card_idNotEqualTo(String value) {
            addCriterion("`membership_card_id` <>", value, "membership_card_id");
            return (Criteria) this;
        }

        public Criteria andMembership_card_idGreaterThan(String value) {
            addCriterion("`membership_card_id` >", value, "membership_card_id");
            return (Criteria) this;
        }

        public Criteria andMembership_card_idGreaterThanOrEqualTo(String value) {
            addCriterion("`membership_card_id` >=", value, "membership_card_id");
            return (Criteria) this;
        }

        public Criteria andMembership_card_idLessThan(String value) {
            addCriterion("`membership_card_id` <", value, "membership_card_id");
            return (Criteria) this;
        }

        public Criteria andMembership_card_idLessThanOrEqualTo(String value) {
            addCriterion("`membership_card_id` <=", value, "membership_card_id");
            return (Criteria) this;
        }

        public Criteria andMembership_card_idLike(String value) {
            addCriterion("`membership_card_id` like", value, "membership_card_id");
            return (Criteria) this;
        }

        public Criteria andMembership_card_idNotLike(String value) {
            addCriterion("`membership_card_id` not like", value, "membership_card_id");
            return (Criteria) this;
        }

        public Criteria andMembership_card_idIn(List<String> values) {
            addCriterion("`membership_card_id` in", values, "membership_card_id");
            return (Criteria) this;
        }

        public Criteria andMembership_card_idNotIn(List<String> values) {
            addCriterion("`membership_card_id` not in", values, "membership_card_id");
            return (Criteria) this;
        }

        public Criteria andMembership_card_idBetween(String value1, String value2) {
            addCriterion("`membership_card_id` between", value1, value2, "membership_card_id");
            return (Criteria) this;
        }

        public Criteria andMembership_card_idNotBetween(String value1, String value2) {
            addCriterion("`membership_card_id` not between", value1, value2, "membership_card_id");
            return (Criteria) this;
        }

        public Criteria andCar_statusIsNull() {
            addCriterion("`car_status` is null");
            return (Criteria) this;
        }

        public Criteria andCar_statusIsNotNull() {
            addCriterion("`car_status` is not null");
            return (Criteria) this;
        }

        public Criteria andCar_statusEqualTo(String value) {
            addCriterion("`car_status` =", value, "car_status");
            return (Criteria) this;
        }

        public Criteria andCar_statusNotEqualTo(String value) {
            addCriterion("`car_status` <>", value, "car_status");
            return (Criteria) this;
        }

        public Criteria andCar_statusGreaterThan(String value) {
            addCriterion("`car_status` >", value, "car_status");
            return (Criteria) this;
        }

        public Criteria andCar_statusGreaterThanOrEqualTo(String value) {
            addCriterion("`car_status` >=", value, "car_status");
            return (Criteria) this;
        }

        public Criteria andCar_statusLessThan(String value) {
            addCriterion("`car_status` <", value, "car_status");
            return (Criteria) this;
        }

        public Criteria andCar_statusLessThanOrEqualTo(String value) {
            addCriterion("`car_status` <=", value, "car_status");
            return (Criteria) this;
        }

        public Criteria andCar_statusLike(String value) {
            addCriterion("`car_status` like", value, "car_status");
            return (Criteria) this;
        }

        public Criteria andCar_statusNotLike(String value) {
            addCriterion("`car_status` not like", value, "car_status");
            return (Criteria) this;
        }

        public Criteria andCar_statusIn(List<String> values) {
            addCriterion("`car_status` in", values, "car_status");
            return (Criteria) this;
        }

        public Criteria andCar_statusNotIn(List<String> values) {
            addCriterion("`car_status` not in", values, "car_status");
            return (Criteria) this;
        }

        public Criteria andCar_statusBetween(String value1, String value2) {
            addCriterion("`car_status` between", value1, value2, "car_status");
            return (Criteria) this;
        }

        public Criteria andCar_statusNotBetween(String value1, String value2) {
            addCriterion("`car_status` not between", value1, value2, "car_status");
            return (Criteria) this;
        }

        public Criteria andGmt_activateIsNull() {
            addCriterion("`gmt_activate` is null");
            return (Criteria) this;
        }

        public Criteria andGmt_activateIsNotNull() {
            addCriterion("`gmt_activate` is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_activateEqualTo(Date value) {
            addCriterion("`gmt_activate` =", value, "gmt_activate");
            return (Criteria) this;
        }

        public Criteria andGmt_activateNotEqualTo(Date value) {
            addCriterion("`gmt_activate` <>", value, "gmt_activate");
            return (Criteria) this;
        }

        public Criteria andGmt_activateGreaterThan(Date value) {
            addCriterion("`gmt_activate` >", value, "gmt_activate");
            return (Criteria) this;
        }

        public Criteria andGmt_activateGreaterThanOrEqualTo(Date value) {
            addCriterion("`gmt_activate` >=", value, "gmt_activate");
            return (Criteria) this;
        }

        public Criteria andGmt_activateLessThan(Date value) {
            addCriterion("`gmt_activate` <", value, "gmt_activate");
            return (Criteria) this;
        }

        public Criteria andGmt_activateLessThanOrEqualTo(Date value) {
            addCriterion("`gmt_activate` <=", value, "gmt_activate");
            return (Criteria) this;
        }

        public Criteria andGmt_activateIn(List<Date> values) {
            addCriterion("`gmt_activate` in", values, "gmt_activate");
            return (Criteria) this;
        }

        public Criteria andGmt_activateNotIn(List<Date> values) {
            addCriterion("`gmt_activate` not in", values, "gmt_activate");
            return (Criteria) this;
        }

        public Criteria andGmt_activateBetween(Date value1, Date value2) {
            addCriterion("`gmt_activate` between", value1, value2, "gmt_activate");
            return (Criteria) this;
        }

        public Criteria andGmt_activateNotBetween(Date value1, Date value2) {
            addCriterion("`gmt_activate` not between", value1, value2, "gmt_activate");
            return (Criteria) this;
        }

        public Criteria andGmt_take_effectIsNull() {
            addCriterion("`gmt_take_effect` is null");
            return (Criteria) this;
        }

        public Criteria andGmt_take_effectIsNotNull() {
            addCriterion("`gmt_take_effect` is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_take_effectEqualTo(Date value) {
            addCriterion("`gmt_take_effect` =", value, "gmt_take_effect");
            return (Criteria) this;
        }

        public Criteria andGmt_take_effectNotEqualTo(Date value) {
            addCriterion("`gmt_take_effect` <>", value, "gmt_take_effect");
            return (Criteria) this;
        }

        public Criteria andGmt_take_effectGreaterThan(Date value) {
            addCriterion("`gmt_take_effect` >", value, "gmt_take_effect");
            return (Criteria) this;
        }

        public Criteria andGmt_take_effectGreaterThanOrEqualTo(Date value) {
            addCriterion("`gmt_take_effect` >=", value, "gmt_take_effect");
            return (Criteria) this;
        }

        public Criteria andGmt_take_effectLessThan(Date value) {
            addCriterion("`gmt_take_effect` <", value, "gmt_take_effect");
            return (Criteria) this;
        }

        public Criteria andGmt_take_effectLessThanOrEqualTo(Date value) {
            addCriterion("`gmt_take_effect` <=", value, "gmt_take_effect");
            return (Criteria) this;
        }

        public Criteria andGmt_take_effectIn(List<Date> values) {
            addCriterion("`gmt_take_effect` in", values, "gmt_take_effect");
            return (Criteria) this;
        }

        public Criteria andGmt_take_effectNotIn(List<Date> values) {
            addCriterion("`gmt_take_effect` not in", values, "gmt_take_effect");
            return (Criteria) this;
        }

        public Criteria andGmt_take_effectBetween(Date value1, Date value2) {
            addCriterion("`gmt_take_effect` between", value1, value2, "gmt_take_effect");
            return (Criteria) this;
        }

        public Criteria andGmt_take_effectNotBetween(Date value1, Date value2) {
            addCriterion("`gmt_take_effect` not between", value1, value2, "gmt_take_effect");
            return (Criteria) this;
        }

        public Criteria andGmt_lose_effectIsNull() {
            addCriterion("`gmt_lose_effect` is null");
            return (Criteria) this;
        }

        public Criteria andGmt_lose_effectIsNotNull() {
            addCriterion("`gmt_lose_effect` is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_lose_effectEqualTo(Date value) {
            addCriterion("`gmt_lose_effect` =", value, "gmt_lose_effect");
            return (Criteria) this;
        }

        public Criteria andGmt_lose_effectNotEqualTo(Date value) {
            addCriterion("`gmt_lose_effect` <>", value, "gmt_lose_effect");
            return (Criteria) this;
        }

        public Criteria andGmt_lose_effectGreaterThan(Date value) {
            addCriterion("`gmt_lose_effect` >", value, "gmt_lose_effect");
            return (Criteria) this;
        }

        public Criteria andGmt_lose_effectGreaterThanOrEqualTo(Date value) {
            addCriterion("`gmt_lose_effect` >=", value, "gmt_lose_effect");
            return (Criteria) this;
        }

        public Criteria andGmt_lose_effectLessThan(Date value) {
            addCriterion("`gmt_lose_effect` <", value, "gmt_lose_effect");
            return (Criteria) this;
        }

        public Criteria andGmt_lose_effectLessThanOrEqualTo(Date value) {
            addCriterion("`gmt_lose_effect` <=", value, "gmt_lose_effect");
            return (Criteria) this;
        }

        public Criteria andGmt_lose_effectIn(List<Date> values) {
            addCriterion("`gmt_lose_effect` in", values, "gmt_lose_effect");
            return (Criteria) this;
        }

        public Criteria andGmt_lose_effectNotIn(List<Date> values) {
            addCriterion("`gmt_lose_effect` not in", values, "gmt_lose_effect");
            return (Criteria) this;
        }

        public Criteria andGmt_lose_effectBetween(Date value1, Date value2) {
            addCriterion("`gmt_lose_effect` between", value1, value2, "gmt_lose_effect");
            return (Criteria) this;
        }

        public Criteria andGmt_lose_effectNotBetween(Date value1, Date value2) {
            addCriterion("`gmt_lose_effect` not between", value1, value2, "gmt_lose_effect");
            return (Criteria) this;
        }

        public Criteria andGmt_createIsNull() {
            addCriterion("`gmt_create` is null");
            return (Criteria) this;
        }

        public Criteria andGmt_createIsNotNull() {
            addCriterion("`gmt_create` is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_createEqualTo(Date value) {
            addCriterion("`gmt_create` =", value, "gmt_create");
            return (Criteria) this;
        }

        public Criteria andGmt_createNotEqualTo(Date value) {
            addCriterion("`gmt_create` <>", value, "gmt_create");
            return (Criteria) this;
        }

        public Criteria andGmt_createGreaterThan(Date value) {
            addCriterion("`gmt_create` >", value, "gmt_create");
            return (Criteria) this;
        }

        public Criteria andGmt_createGreaterThanOrEqualTo(Date value) {
            addCriterion("`gmt_create` >=", value, "gmt_create");
            return (Criteria) this;
        }

        public Criteria andGmt_createLessThan(Date value) {
            addCriterion("`gmt_create` <", value, "gmt_create");
            return (Criteria) this;
        }

        public Criteria andGmt_createLessThanOrEqualTo(Date value) {
            addCriterion("`gmt_create` <=", value, "gmt_create");
            return (Criteria) this;
        }

        public Criteria andGmt_createIn(List<Date> values) {
            addCriterion("`gmt_create` in", values, "gmt_create");
            return (Criteria) this;
        }

        public Criteria andGmt_createNotIn(List<Date> values) {
            addCriterion("`gmt_create` not in", values, "gmt_create");
            return (Criteria) this;
        }

        public Criteria andGmt_createBetween(Date value1, Date value2) {
            addCriterion("`gmt_create` between", value1, value2, "gmt_create");
            return (Criteria) this;
        }

        public Criteria andGmt_createNotBetween(Date value1, Date value2) {
            addCriterion("`gmt_create` not between", value1, value2, "gmt_create");
            return (Criteria) this;
        }

        public Criteria andGmt_modifyIsNull() {
            addCriterion("`gmt_modify` is null");
            return (Criteria) this;
        }

        public Criteria andGmt_modifyIsNotNull() {
            addCriterion("`gmt_modify` is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_modifyEqualTo(Date value) {
            addCriterion("`gmt_modify` =", value, "gmt_modify");
            return (Criteria) this;
        }

        public Criteria andGmt_modifyNotEqualTo(Date value) {
            addCriterion("`gmt_modify` <>", value, "gmt_modify");
            return (Criteria) this;
        }

        public Criteria andGmt_modifyGreaterThan(Date value) {
            addCriterion("`gmt_modify` >", value, "gmt_modify");
            return (Criteria) this;
        }

        public Criteria andGmt_modifyGreaterThanOrEqualTo(Date value) {
            addCriterion("`gmt_modify` >=", value, "gmt_modify");
            return (Criteria) this;
        }

        public Criteria andGmt_modifyLessThan(Date value) {
            addCriterion("`gmt_modify` <", value, "gmt_modify");
            return (Criteria) this;
        }

        public Criteria andGmt_modifyLessThanOrEqualTo(Date value) {
            addCriterion("`gmt_modify` <=", value, "gmt_modify");
            return (Criteria) this;
        }

        public Criteria andGmt_modifyIn(List<Date> values) {
            addCriterion("`gmt_modify` in", values, "gmt_modify");
            return (Criteria) this;
        }

        public Criteria andGmt_modifyNotIn(List<Date> values) {
            addCriterion("`gmt_modify` not in", values, "gmt_modify");
            return (Criteria) this;
        }

        public Criteria andGmt_modifyBetween(Date value1, Date value2) {
            addCriterion("`gmt_modify` between", value1, value2, "gmt_modify");
            return (Criteria) this;
        }

        public Criteria andGmt_modifyNotBetween(Date value1, Date value2) {
            addCriterion("`gmt_modify` not between", value1, value2, "gmt_modify");
            return (Criteria) this;
        }

        public Criteria andCreator_accountIsNull() {
            addCriterion("`creator_account` is null");
            return (Criteria) this;
        }

        public Criteria andCreator_accountIsNotNull() {
            addCriterion("`creator_account` is not null");
            return (Criteria) this;
        }

        public Criteria andCreator_accountEqualTo(String value) {
            addCriterion("`creator_account` =", value, "creator_account");
            return (Criteria) this;
        }

        public Criteria andCreator_accountNotEqualTo(String value) {
            addCriterion("`creator_account` <>", value, "creator_account");
            return (Criteria) this;
        }

        public Criteria andCreator_accountGreaterThan(String value) {
            addCriterion("`creator_account` >", value, "creator_account");
            return (Criteria) this;
        }

        public Criteria andCreator_accountGreaterThanOrEqualTo(String value) {
            addCriterion("`creator_account` >=", value, "creator_account");
            return (Criteria) this;
        }

        public Criteria andCreator_accountLessThan(String value) {
            addCriterion("`creator_account` <", value, "creator_account");
            return (Criteria) this;
        }

        public Criteria andCreator_accountLessThanOrEqualTo(String value) {
            addCriterion("`creator_account` <=", value, "creator_account");
            return (Criteria) this;
        }

        public Criteria andCreator_accountLike(String value) {
            addCriterion("`creator_account` like", value, "creator_account");
            return (Criteria) this;
        }

        public Criteria andCreator_accountNotLike(String value) {
            addCriterion("`creator_account` not like", value, "creator_account");
            return (Criteria) this;
        }

        public Criteria andCreator_accountIn(List<String> values) {
            addCriterion("`creator_account` in", values, "creator_account");
            return (Criteria) this;
        }

        public Criteria andCreator_accountNotIn(List<String> values) {
            addCriterion("`creator_account` not in", values, "creator_account");
            return (Criteria) this;
        }

        public Criteria andCreator_accountBetween(String value1, String value2) {
            addCriterion("`creator_account` between", value1, value2, "creator_account");
            return (Criteria) this;
        }

        public Criteria andCreator_accountNotBetween(String value1, String value2) {
            addCriterion("`creator_account` not between", value1, value2, "creator_account");
            return (Criteria) this;
        }

        public Criteria andModifier_accountIsNull() {
            addCriterion("`modifier_account` is null");
            return (Criteria) this;
        }

        public Criteria andModifier_accountIsNotNull() {
            addCriterion("`modifier_account` is not null");
            return (Criteria) this;
        }

        public Criteria andModifier_accountEqualTo(String value) {
            addCriterion("`modifier_account` =", value, "modifier_account");
            return (Criteria) this;
        }

        public Criteria andModifier_accountNotEqualTo(String value) {
            addCriterion("`modifier_account` <>", value, "modifier_account");
            return (Criteria) this;
        }

        public Criteria andModifier_accountGreaterThan(String value) {
            addCriterion("`modifier_account` >", value, "modifier_account");
            return (Criteria) this;
        }

        public Criteria andModifier_accountGreaterThanOrEqualTo(String value) {
            addCriterion("`modifier_account` >=", value, "modifier_account");
            return (Criteria) this;
        }

        public Criteria andModifier_accountLessThan(String value) {
            addCriterion("`modifier_account` <", value, "modifier_account");
            return (Criteria) this;
        }

        public Criteria andModifier_accountLessThanOrEqualTo(String value) {
            addCriterion("`modifier_account` <=", value, "modifier_account");
            return (Criteria) this;
        }

        public Criteria andModifier_accountLike(String value) {
            addCriterion("`modifier_account` like", value, "modifier_account");
            return (Criteria) this;
        }

        public Criteria andModifier_accountNotLike(String value) {
            addCriterion("`modifier_account` not like", value, "modifier_account");
            return (Criteria) this;
        }

        public Criteria andModifier_accountIn(List<String> values) {
            addCriterion("`modifier_account` in", values, "modifier_account");
            return (Criteria) this;
        }

        public Criteria andModifier_accountNotIn(List<String> values) {
            addCriterion("`modifier_account` not in", values, "modifier_account");
            return (Criteria) this;
        }

        public Criteria andModifier_accountBetween(String value1, String value2) {
            addCriterion("`modifier_account` between", value1, value2, "modifier_account");
            return (Criteria) this;
        }

        public Criteria andModifier_accountNotBetween(String value1, String value2) {
            addCriterion("`modifier_account` not between", value1, value2, "modifier_account");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("`version` is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("`version` is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("`version` =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("`version` <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("`version` >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("`version` >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("`version` <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("`version` <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("`version` in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("`version` not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("`version` between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("`version` not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andIs_defaultIsNull() {
            addCriterion("`is_default` is null");
            return (Criteria) this;
        }

        public Criteria andIs_defaultIsNotNull() {
            addCriterion("`is_default` is not null");
            return (Criteria) this;
        }

        public Criteria andIs_defaultEqualTo(Boolean value) {
            addCriterion("`is_default` =", value, "is_default");
            return (Criteria) this;
        }

        public Criteria andIs_defaultNotEqualTo(Boolean value) {
            addCriterion("`is_default` <>", value, "is_default");
            return (Criteria) this;
        }

        public Criteria andIs_defaultGreaterThan(Boolean value) {
            addCriterion("`is_default` >", value, "is_default");
            return (Criteria) this;
        }

        public Criteria andIs_defaultGreaterThanOrEqualTo(Boolean value) {
            addCriterion("`is_default` >=", value, "is_default");
            return (Criteria) this;
        }

        public Criteria andIs_defaultLessThan(Boolean value) {
            addCriterion("`is_default` <", value, "is_default");
            return (Criteria) this;
        }

        public Criteria andIs_defaultLessThanOrEqualTo(Boolean value) {
            addCriterion("`is_default` <=", value, "is_default");
            return (Criteria) this;
        }

        public Criteria andIs_defaultIn(List<Boolean> values) {
            addCriterion("`is_default` in", values, "is_default");
            return (Criteria) this;
        }

        public Criteria andIs_defaultNotIn(List<Boolean> values) {
            addCriterion("`is_default` not in", values, "is_default");
            return (Criteria) this;
        }

        public Criteria andIs_defaultBetween(Boolean value1, Boolean value2) {
            addCriterion("`is_default` between", value1, value2, "is_default");
            return (Criteria) this;
        }

        public Criteria andIs_defaultNotBetween(Boolean value1, Boolean value2) {
            addCriterion("`is_default` not between", value1, value2, "is_default");
            return (Criteria) this;
        }

        public Criteria andColorIsNull() {
            addCriterion("`color` is null");
            return (Criteria) this;
        }

        public Criteria andColorIsNotNull() {
            addCriterion("`color` is not null");
            return (Criteria) this;
        }

        public Criteria andColorEqualTo(String value) {
            addCriterion("`color` =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(String value) {
            addCriterion("`color` <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(String value) {
            addCriterion("`color` >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(String value) {
            addCriterion("`color` >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(String value) {
            addCriterion("`color` <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(String value) {
            addCriterion("`color` <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLike(String value) {
            addCriterion("`color` like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotLike(String value) {
            addCriterion("`color` not like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<String> values) {
            addCriterion("`color` in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<String> values) {
            addCriterion("`color` not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(String value1, String value2) {
            addCriterion("`color` between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(String value1, String value2) {
            addCriterion("`color` not between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andVinIsNull() {
            addCriterion("`vin` is null");
            return (Criteria) this;
        }

        public Criteria andVinIsNotNull() {
            addCriterion("`vin` is not null");
            return (Criteria) this;
        }

        public Criteria andVinEqualTo(String value) {
            addCriterion("`vin` =", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinNotEqualTo(String value) {
            addCriterion("`vin` <>", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinGreaterThan(String value) {
            addCriterion("`vin` >", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinGreaterThanOrEqualTo(String value) {
            addCriterion("`vin` >=", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinLessThan(String value) {
            addCriterion("`vin` <", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinLessThanOrEqualTo(String value) {
            addCriterion("`vin` <=", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinLike(String value) {
            addCriterion("`vin` like", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinNotLike(String value) {
            addCriterion("`vin` not like", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinIn(List<String> values) {
            addCriterion("`vin` in", values, "vin");
            return (Criteria) this;
        }

        public Criteria andVinNotIn(List<String> values) {
            addCriterion("`vin` not in", values, "vin");
            return (Criteria) this;
        }

        public Criteria andVinBetween(String value1, String value2) {
            addCriterion("`vin` between", value1, value2, "vin");
            return (Criteria) this;
        }

        public Criteria andVinNotBetween(String value1, String value2) {
            addCriterion("`vin` not between", value1, value2, "vin");
            return (Criteria) this;
        }

        public Criteria andCard_levelIsNull() {
            addCriterion("`card_level` is null");
            return (Criteria) this;
        }

        public Criteria andCard_levelIsNotNull() {
            addCriterion("`card_level` is not null");
            return (Criteria) this;
        }

        public Criteria andCard_levelEqualTo(String value) {
            addCriterion("`card_level` =", value, "card_level");
            return (Criteria) this;
        }

        public Criteria andCard_levelNotEqualTo(String value) {
            addCriterion("`card_level` <>", value, "card_level");
            return (Criteria) this;
        }

        public Criteria andCard_levelGreaterThan(String value) {
            addCriterion("`card_level` >", value, "card_level");
            return (Criteria) this;
        }

        public Criteria andCard_levelGreaterThanOrEqualTo(String value) {
            addCriterion("`card_level` >=", value, "card_level");
            return (Criteria) this;
        }

        public Criteria andCard_levelLessThan(String value) {
            addCriterion("`card_level` <", value, "card_level");
            return (Criteria) this;
        }

        public Criteria andCard_levelLessThanOrEqualTo(String value) {
            addCriterion("`card_level` <=", value, "card_level");
            return (Criteria) this;
        }

        public Criteria andCard_levelLike(String value) {
            addCriterion("`card_level` like", value, "card_level");
            return (Criteria) this;
        }

        public Criteria andCard_levelNotLike(String value) {
            addCriterion("`card_level` not like", value, "card_level");
            return (Criteria) this;
        }

        public Criteria andCard_levelIn(List<String> values) {
            addCriterion("`card_level` in", values, "card_level");
            return (Criteria) this;
        }

        public Criteria andCard_levelNotIn(List<String> values) {
            addCriterion("`card_level` not in", values, "card_level");
            return (Criteria) this;
        }

        public Criteria andCard_levelBetween(String value1, String value2) {
            addCriterion("`card_level` between", value1, value2, "card_level");
            return (Criteria) this;
        }

        public Criteria andCard_levelNotBetween(String value1, String value2) {
            addCriterion("`card_level` not between", value1, value2, "card_level");
            return (Criteria) this;
        }

        public Criteria andLast_maintenance_milesIsNull() {
            addCriterion("`last_maintenance_miles` is null");
            return (Criteria) this;
        }

        public Criteria andLast_maintenance_milesIsNotNull() {
            addCriterion("`last_maintenance_miles` is not null");
            return (Criteria) this;
        }

        public Criteria andLast_maintenance_milesEqualTo(String value) {
            addCriterion("`last_maintenance_miles` =", value, "last_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andLast_maintenance_milesNotEqualTo(String value) {
            addCriterion("`last_maintenance_miles` <>", value, "last_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andLast_maintenance_milesGreaterThan(String value) {
            addCriterion("`last_maintenance_miles` >", value, "last_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andLast_maintenance_milesGreaterThanOrEqualTo(String value) {
            addCriterion("`last_maintenance_miles` >=", value, "last_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andLast_maintenance_milesLessThan(String value) {
            addCriterion("`last_maintenance_miles` <", value, "last_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andLast_maintenance_milesLessThanOrEqualTo(String value) {
            addCriterion("`last_maintenance_miles` <=", value, "last_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andLast_maintenance_milesLike(String value) {
            addCriterion("`last_maintenance_miles` like", value, "last_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andLast_maintenance_milesNotLike(String value) {
            addCriterion("`last_maintenance_miles` not like", value, "last_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andLast_maintenance_milesIn(List<String> values) {
            addCriterion("`last_maintenance_miles` in", values, "last_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andLast_maintenance_milesNotIn(List<String> values) {
            addCriterion("`last_maintenance_miles` not in", values, "last_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andLast_maintenance_milesBetween(String value1, String value2) {
            addCriterion("`last_maintenance_miles` between", value1, value2, "last_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andLast_maintenance_milesNotBetween(String value1, String value2) {
            addCriterion("`last_maintenance_miles` not between", value1, value2, "last_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andNext_maintenance_milesIsNull() {
            addCriterion("`next_maintenance_miles` is null");
            return (Criteria) this;
        }

        public Criteria andNext_maintenance_milesIsNotNull() {
            addCriterion("`next_maintenance_miles` is not null");
            return (Criteria) this;
        }

        public Criteria andNext_maintenance_milesEqualTo(String value) {
            addCriterion("`next_maintenance_miles` =", value, "next_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andNext_maintenance_milesNotEqualTo(String value) {
            addCriterion("`next_maintenance_miles` <>", value, "next_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andNext_maintenance_milesGreaterThan(String value) {
            addCriterion("`next_maintenance_miles` >", value, "next_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andNext_maintenance_milesGreaterThanOrEqualTo(String value) {
            addCriterion("`next_maintenance_miles` >=", value, "next_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andNext_maintenance_milesLessThan(String value) {
            addCriterion("`next_maintenance_miles` <", value, "next_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andNext_maintenance_milesLessThanOrEqualTo(String value) {
            addCriterion("`next_maintenance_miles` <=", value, "next_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andNext_maintenance_milesLike(String value) {
            addCriterion("`next_maintenance_miles` like", value, "next_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andNext_maintenance_milesNotLike(String value) {
            addCriterion("`next_maintenance_miles` not like", value, "next_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andNext_maintenance_milesIn(List<String> values) {
            addCriterion("`next_maintenance_miles` in", values, "next_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andNext_maintenance_milesNotIn(List<String> values) {
            addCriterion("`next_maintenance_miles` not in", values, "next_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andNext_maintenance_milesBetween(String value1, String value2) {
            addCriterion("`next_maintenance_miles` between", value1, value2, "next_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andNext_maintenance_milesNotBetween(String value1, String value2) {
            addCriterion("`next_maintenance_miles` not between", value1, value2, "next_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andCurr_maintenance_milesIsNull() {
            addCriterion("`curr_maintenance_miles` is null");
            return (Criteria) this;
        }

        public Criteria andCurr_maintenance_milesIsNotNull() {
            addCriterion("`curr_maintenance_miles` is not null");
            return (Criteria) this;
        }

        public Criteria andCurr_maintenance_milesEqualTo(String value) {
            addCriterion("`curr_maintenance_miles` =", value, "curr_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andCurr_maintenance_milesNotEqualTo(String value) {
            addCriterion("`curr_maintenance_miles` <>", value, "curr_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andCurr_maintenance_milesGreaterThan(String value) {
            addCriterion("`curr_maintenance_miles` >", value, "curr_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andCurr_maintenance_milesGreaterThanOrEqualTo(String value) {
            addCriterion("`curr_maintenance_miles` >=", value, "curr_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andCurr_maintenance_milesLessThan(String value) {
            addCriterion("`curr_maintenance_miles` <", value, "curr_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andCurr_maintenance_milesLessThanOrEqualTo(String value) {
            addCriterion("`curr_maintenance_miles` <=", value, "curr_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andCurr_maintenance_milesLike(String value) {
            addCriterion("`curr_maintenance_miles` like", value, "curr_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andCurr_maintenance_milesNotLike(String value) {
            addCriterion("`curr_maintenance_miles` not like", value, "curr_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andCurr_maintenance_milesIn(List<String> values) {
            addCriterion("`curr_maintenance_miles` in", values, "curr_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andCurr_maintenance_milesNotIn(List<String> values) {
            addCriterion("`curr_maintenance_miles` not in", values, "curr_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andCurr_maintenance_milesBetween(String value1, String value2) {
            addCriterion("`curr_maintenance_miles` between", value1, value2, "curr_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andCurr_maintenance_milesNotBetween(String value1, String value2) {
            addCriterion("`curr_maintenance_miles` not between", value1, value2, "curr_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andCar_type_imageIsNull() {
            addCriterion("`car_type_image` is null");
            return (Criteria) this;
        }

        public Criteria andCar_type_imageIsNotNull() {
            addCriterion("`car_type_image` is not null");
            return (Criteria) this;
        }

        public Criteria andCar_type_imageEqualTo(String value) {
            addCriterion("`car_type_image` =", value, "car_type_image");
            return (Criteria) this;
        }

        public Criteria andCar_type_imageNotEqualTo(String value) {
            addCriterion("`car_type_image` <>", value, "car_type_image");
            return (Criteria) this;
        }

        public Criteria andCar_type_imageGreaterThan(String value) {
            addCriterion("`car_type_image` >", value, "car_type_image");
            return (Criteria) this;
        }

        public Criteria andCar_type_imageGreaterThanOrEqualTo(String value) {
            addCriterion("`car_type_image` >=", value, "car_type_image");
            return (Criteria) this;
        }

        public Criteria andCar_type_imageLessThan(String value) {
            addCriterion("`car_type_image` <", value, "car_type_image");
            return (Criteria) this;
        }

        public Criteria andCar_type_imageLessThanOrEqualTo(String value) {
            addCriterion("`car_type_image` <=", value, "car_type_image");
            return (Criteria) this;
        }

        public Criteria andCar_type_imageLike(String value) {
            addCriterion("`car_type_image` like", value, "car_type_image");
            return (Criteria) this;
        }

        public Criteria andCar_type_imageNotLike(String value) {
            addCriterion("`car_type_image` not like", value, "car_type_image");
            return (Criteria) this;
        }

        public Criteria andCar_type_imageIn(List<String> values) {
            addCriterion("`car_type_image` in", values, "car_type_image");
            return (Criteria) this;
        }

        public Criteria andCar_type_imageNotIn(List<String> values) {
            addCriterion("`car_type_image` not in", values, "car_type_image");
            return (Criteria) this;
        }

        public Criteria andCar_type_imageBetween(String value1, String value2) {
            addCriterion("`car_type_image` between", value1, value2, "car_type_image");
            return (Criteria) this;
        }

        public Criteria andCar_type_imageNotBetween(String value1, String value2) {
            addCriterion("`car_type_image` not between", value1, value2, "car_type_image");
            return (Criteria) this;
        }

        public Criteria andCar_type_codeIsNull() {
            addCriterion("`car_type_code` is null");
            return (Criteria) this;
        }

        public Criteria andCar_type_codeIsNotNull() {
            addCriterion("`car_type_code` is not null");
            return (Criteria) this;
        }

        public Criteria andCar_type_codeEqualTo(String value) {
            addCriterion("`car_type_code` =", value, "car_type_code");
            return (Criteria) this;
        }

        public Criteria andCar_type_codeNotEqualTo(String value) {
            addCriterion("`car_type_code` <>", value, "car_type_code");
            return (Criteria) this;
        }

        public Criteria andCar_type_codeGreaterThan(String value) {
            addCriterion("`car_type_code` >", value, "car_type_code");
            return (Criteria) this;
        }

        public Criteria andCar_type_codeGreaterThanOrEqualTo(String value) {
            addCriterion("`car_type_code` >=", value, "car_type_code");
            return (Criteria) this;
        }

        public Criteria andCar_type_codeLessThan(String value) {
            addCriterion("`car_type_code` <", value, "car_type_code");
            return (Criteria) this;
        }

        public Criteria andCar_type_codeLessThanOrEqualTo(String value) {
            addCriterion("`car_type_code` <=", value, "car_type_code");
            return (Criteria) this;
        }

        public Criteria andCar_type_codeLike(String value) {
            addCriterion("`car_type_code` like", value, "car_type_code");
            return (Criteria) this;
        }

        public Criteria andCar_type_codeNotLike(String value) {
            addCriterion("`car_type_code` not like", value, "car_type_code");
            return (Criteria) this;
        }

        public Criteria andCar_type_codeIn(List<String> values) {
            addCriterion("`car_type_code` in", values, "car_type_code");
            return (Criteria) this;
        }

        public Criteria andCar_type_codeNotIn(List<String> values) {
            addCriterion("`car_type_code` not in", values, "car_type_code");
            return (Criteria) this;
        }

        public Criteria andCar_type_codeBetween(String value1, String value2) {
            addCriterion("`car_type_code` between", value1, value2, "car_type_code");
            return (Criteria) this;
        }

        public Criteria andCar_type_codeNotBetween(String value1, String value2) {
            addCriterion("`car_type_code` not between", value1, value2, "car_type_code");
            return (Criteria) this;
        }

        public Criteria andCar_brand_codeIsNull() {
            addCriterion("`car_brand_code` is null");
            return (Criteria) this;
        }

        public Criteria andCar_brand_codeIsNotNull() {
            addCriterion("`car_brand_code` is not null");
            return (Criteria) this;
        }

        public Criteria andCar_brand_codeEqualTo(String value) {
            addCriterion("`car_brand_code` =", value, "car_brand_code");
            return (Criteria) this;
        }

        public Criteria andCar_brand_codeNotEqualTo(String value) {
            addCriterion("`car_brand_code` <>", value, "car_brand_code");
            return (Criteria) this;
        }

        public Criteria andCar_brand_codeGreaterThan(String value) {
            addCriterion("`car_brand_code` >", value, "car_brand_code");
            return (Criteria) this;
        }

        public Criteria andCar_brand_codeGreaterThanOrEqualTo(String value) {
            addCriterion("`car_brand_code` >=", value, "car_brand_code");
            return (Criteria) this;
        }

        public Criteria andCar_brand_codeLessThan(String value) {
            addCriterion("`car_brand_code` <", value, "car_brand_code");
            return (Criteria) this;
        }

        public Criteria andCar_brand_codeLessThanOrEqualTo(String value) {
            addCriterion("`car_brand_code` <=", value, "car_brand_code");
            return (Criteria) this;
        }

        public Criteria andCar_brand_codeLike(String value) {
            addCriterion("`car_brand_code` like", value, "car_brand_code");
            return (Criteria) this;
        }

        public Criteria andCar_brand_codeNotLike(String value) {
            addCriterion("`car_brand_code` not like", value, "car_brand_code");
            return (Criteria) this;
        }

        public Criteria andCar_brand_codeIn(List<String> values) {
            addCriterion("`car_brand_code` in", values, "car_brand_code");
            return (Criteria) this;
        }

        public Criteria andCar_brand_codeNotIn(List<String> values) {
            addCriterion("`car_brand_code` not in", values, "car_brand_code");
            return (Criteria) this;
        }

        public Criteria andCar_brand_codeBetween(String value1, String value2) {
            addCriterion("`car_brand_code` between", value1, value2, "car_brand_code");
            return (Criteria) this;
        }

        public Criteria andCar_brand_codeNotBetween(String value1, String value2) {
            addCriterion("`car_brand_code` not between", value1, value2, "car_brand_code");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
package com.segama.ege.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThOrderManageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public ThOrderManageExample() {
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

        public Criteria andOperate_typeIsNull() {
            addCriterion("`operate_type` is null");
            return (Criteria) this;
        }

        public Criteria andOperate_typeIsNotNull() {
            addCriterion("`operate_type` is not null");
            return (Criteria) this;
        }

        public Criteria andOperate_typeEqualTo(String value) {
            addCriterion("`operate_type` =", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeNotEqualTo(String value) {
            addCriterion("`operate_type` <>", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeGreaterThan(String value) {
            addCriterion("`operate_type` >", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeGreaterThanOrEqualTo(String value) {
            addCriterion("`operate_type` >=", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeLessThan(String value) {
            addCriterion("`operate_type` <", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeLessThanOrEqualTo(String value) {
            addCriterion("`operate_type` <=", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeLike(String value) {
            addCriterion("`operate_type` like", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeNotLike(String value) {
            addCriterion("`operate_type` not like", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeIn(List<String> values) {
            addCriterion("`operate_type` in", values, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeNotIn(List<String> values) {
            addCriterion("`operate_type` not in", values, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeBetween(String value1, String value2) {
            addCriterion("`operate_type` between", value1, value2, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeNotBetween(String value1, String value2) {
            addCriterion("`operate_type` not between", value1, value2, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOrder_codeIsNull() {
            addCriterion("`order_code` is null");
            return (Criteria) this;
        }

        public Criteria andOrder_codeIsNotNull() {
            addCriterion("`order_code` is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_codeEqualTo(String value) {
            addCriterion("`order_code` =", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeNotEqualTo(String value) {
            addCriterion("`order_code` <>", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeGreaterThan(String value) {
            addCriterion("`order_code` >", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeGreaterThanOrEqualTo(String value) {
            addCriterion("`order_code` >=", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeLessThan(String value) {
            addCriterion("`order_code` <", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeLessThanOrEqualTo(String value) {
            addCriterion("`order_code` <=", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeLike(String value) {
            addCriterion("`order_code` like", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeNotLike(String value) {
            addCriterion("`order_code` not like", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeIn(List<String> values) {
            addCriterion("`order_code` in", values, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeNotIn(List<String> values) {
            addCriterion("`order_code` not in", values, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeBetween(String value1, String value2) {
            addCriterion("`order_code` between", value1, value2, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeNotBetween(String value1, String value2) {
            addCriterion("`order_code` not between", value1, value2, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_timeIsNull() {
            addCriterion("`order_time` is null");
            return (Criteria) this;
        }

        public Criteria andOrder_timeIsNotNull() {
            addCriterion("`order_time` is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_timeEqualTo(String value) {
            addCriterion("`order_time` =", value, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeNotEqualTo(String value) {
            addCriterion("`order_time` <>", value, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeGreaterThan(String value) {
            addCriterion("`order_time` >", value, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeGreaterThanOrEqualTo(String value) {
            addCriterion("`order_time` >=", value, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeLessThan(String value) {
            addCriterion("`order_time` <", value, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeLessThanOrEqualTo(String value) {
            addCriterion("`order_time` <=", value, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeLike(String value) {
            addCriterion("`order_time` like", value, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeNotLike(String value) {
            addCriterion("`order_time` not like", value, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeIn(List<String> values) {
            addCriterion("`order_time` in", values, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeNotIn(List<String> values) {
            addCriterion("`order_time` not in", values, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeBetween(String value1, String value2) {
            addCriterion("`order_time` between", value1, value2, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeNotBetween(String value1, String value2) {
            addCriterion("`order_time` not between", value1, value2, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_phone_numberIsNull() {
            addCriterion("`order_phone_number` is null");
            return (Criteria) this;
        }

        public Criteria andOrder_phone_numberIsNotNull() {
            addCriterion("`order_phone_number` is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_phone_numberEqualTo(String value) {
            addCriterion("`order_phone_number` =", value, "order_phone_number");
            return (Criteria) this;
        }

        public Criteria andOrder_phone_numberNotEqualTo(String value) {
            addCriterion("`order_phone_number` <>", value, "order_phone_number");
            return (Criteria) this;
        }

        public Criteria andOrder_phone_numberGreaterThan(String value) {
            addCriterion("`order_phone_number` >", value, "order_phone_number");
            return (Criteria) this;
        }

        public Criteria andOrder_phone_numberGreaterThanOrEqualTo(String value) {
            addCriterion("`order_phone_number` >=", value, "order_phone_number");
            return (Criteria) this;
        }

        public Criteria andOrder_phone_numberLessThan(String value) {
            addCriterion("`order_phone_number` <", value, "order_phone_number");
            return (Criteria) this;
        }

        public Criteria andOrder_phone_numberLessThanOrEqualTo(String value) {
            addCriterion("`order_phone_number` <=", value, "order_phone_number");
            return (Criteria) this;
        }

        public Criteria andOrder_phone_numberLike(String value) {
            addCriterion("`order_phone_number` like", value, "order_phone_number");
            return (Criteria) this;
        }

        public Criteria andOrder_phone_numberNotLike(String value) {
            addCriterion("`order_phone_number` not like", value, "order_phone_number");
            return (Criteria) this;
        }

        public Criteria andOrder_phone_numberIn(List<String> values) {
            addCriterion("`order_phone_number` in", values, "order_phone_number");
            return (Criteria) this;
        }

        public Criteria andOrder_phone_numberNotIn(List<String> values) {
            addCriterion("`order_phone_number` not in", values, "order_phone_number");
            return (Criteria) this;
        }

        public Criteria andOrder_phone_numberBetween(String value1, String value2) {
            addCriterion("`order_phone_number` between", value1, value2, "order_phone_number");
            return (Criteria) this;
        }

        public Criteria andOrder_phone_numberNotBetween(String value1, String value2) {
            addCriterion("`order_phone_number` not between", value1, value2, "order_phone_number");
            return (Criteria) this;
        }

        public Criteria andProvIsNull() {
            addCriterion("`prov` is null");
            return (Criteria) this;
        }

        public Criteria andProvIsNotNull() {
            addCriterion("`prov` is not null");
            return (Criteria) this;
        }

        public Criteria andProvEqualTo(String value) {
            addCriterion("`prov` =", value, "prov");
            return (Criteria) this;
        }

        public Criteria andProvNotEqualTo(String value) {
            addCriterion("`prov` <>", value, "prov");
            return (Criteria) this;
        }

        public Criteria andProvGreaterThan(String value) {
            addCriterion("`prov` >", value, "prov");
            return (Criteria) this;
        }

        public Criteria andProvGreaterThanOrEqualTo(String value) {
            addCriterion("`prov` >=", value, "prov");
            return (Criteria) this;
        }

        public Criteria andProvLessThan(String value) {
            addCriterion("`prov` <", value, "prov");
            return (Criteria) this;
        }

        public Criteria andProvLessThanOrEqualTo(String value) {
            addCriterion("`prov` <=", value, "prov");
            return (Criteria) this;
        }

        public Criteria andProvLike(String value) {
            addCriterion("`prov` like", value, "prov");
            return (Criteria) this;
        }

        public Criteria andProvNotLike(String value) {
            addCriterion("`prov` not like", value, "prov");
            return (Criteria) this;
        }

        public Criteria andProvIn(List<String> values) {
            addCriterion("`prov` in", values, "prov");
            return (Criteria) this;
        }

        public Criteria andProvNotIn(List<String> values) {
            addCriterion("`prov` not in", values, "prov");
            return (Criteria) this;
        }

        public Criteria andProvBetween(String value1, String value2) {
            addCriterion("`prov` between", value1, value2, "prov");
            return (Criteria) this;
        }

        public Criteria andProvNotBetween(String value1, String value2) {
            addCriterion("`prov` not between", value1, value2, "prov");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("`city` is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("`city` is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("`city` =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("`city` <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("`city` >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("`city` >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("`city` <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("`city` <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("`city` like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("`city` not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("`city` in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("`city` not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("`city` between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("`city` not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andOrder_statusIsNull() {
            addCriterion("`order_status` is null");
            return (Criteria) this;
        }

        public Criteria andOrder_statusIsNotNull() {
            addCriterion("`order_status` is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_statusEqualTo(String value) {
            addCriterion("`order_status` =", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusNotEqualTo(String value) {
            addCriterion("`order_status` <>", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusGreaterThan(String value) {
            addCriterion("`order_status` >", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusGreaterThanOrEqualTo(String value) {
            addCriterion("`order_status` >=", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusLessThan(String value) {
            addCriterion("`order_status` <", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusLessThanOrEqualTo(String value) {
            addCriterion("`order_status` <=", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusLike(String value) {
            addCriterion("`order_status` like", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusNotLike(String value) {
            addCriterion("`order_status` not like", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusIn(List<String> values) {
            addCriterion("`order_status` in", values, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusNotIn(List<String> values) {
            addCriterion("`order_status` not in", values, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusBetween(String value1, String value2) {
            addCriterion("`order_status` between", value1, value2, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusNotBetween(String value1, String value2) {
            addCriterion("`order_status` not between", value1, value2, "order_status");
            return (Criteria) this;
        }

        public Criteria andCustomer_nameIsNull() {
            addCriterion("`customer_name` is null");
            return (Criteria) this;
        }

        public Criteria andCustomer_nameIsNotNull() {
            addCriterion("`customer_name` is not null");
            return (Criteria) this;
        }

        public Criteria andCustomer_nameEqualTo(String value) {
            addCriterion("`customer_name` =", value, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomer_nameNotEqualTo(String value) {
            addCriterion("`customer_name` <>", value, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomer_nameGreaterThan(String value) {
            addCriterion("`customer_name` >", value, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomer_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`customer_name` >=", value, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomer_nameLessThan(String value) {
            addCriterion("`customer_name` <", value, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomer_nameLessThanOrEqualTo(String value) {
            addCriterion("`customer_name` <=", value, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomer_nameLike(String value) {
            addCriterion("`customer_name` like", value, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomer_nameNotLike(String value) {
            addCriterion("`customer_name` not like", value, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomer_nameIn(List<String> values) {
            addCriterion("`customer_name` in", values, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomer_nameNotIn(List<String> values) {
            addCriterion("`customer_name` not in", values, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomer_nameBetween(String value1, String value2) {
            addCriterion("`customer_name` between", value1, value2, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCustomer_nameNotBetween(String value1, String value2) {
            addCriterion("`customer_name` not between", value1, value2, "customer_name");
            return (Criteria) this;
        }

        public Criteria andCertificate_typeIsNull() {
            addCriterion("`certificate_type` is null");
            return (Criteria) this;
        }

        public Criteria andCertificate_typeIsNotNull() {
            addCriterion("`certificate_type` is not null");
            return (Criteria) this;
        }

        public Criteria andCertificate_typeEqualTo(String value) {
            addCriterion("`certificate_type` =", value, "certificate_type");
            return (Criteria) this;
        }

        public Criteria andCertificate_typeNotEqualTo(String value) {
            addCriterion("`certificate_type` <>", value, "certificate_type");
            return (Criteria) this;
        }

        public Criteria andCertificate_typeGreaterThan(String value) {
            addCriterion("`certificate_type` >", value, "certificate_type");
            return (Criteria) this;
        }

        public Criteria andCertificate_typeGreaterThanOrEqualTo(String value) {
            addCriterion("`certificate_type` >=", value, "certificate_type");
            return (Criteria) this;
        }

        public Criteria andCertificate_typeLessThan(String value) {
            addCriterion("`certificate_type` <", value, "certificate_type");
            return (Criteria) this;
        }

        public Criteria andCertificate_typeLessThanOrEqualTo(String value) {
            addCriterion("`certificate_type` <=", value, "certificate_type");
            return (Criteria) this;
        }

        public Criteria andCertificate_typeLike(String value) {
            addCriterion("`certificate_type` like", value, "certificate_type");
            return (Criteria) this;
        }

        public Criteria andCertificate_typeNotLike(String value) {
            addCriterion("`certificate_type` not like", value, "certificate_type");
            return (Criteria) this;
        }

        public Criteria andCertificate_typeIn(List<String> values) {
            addCriterion("`certificate_type` in", values, "certificate_type");
            return (Criteria) this;
        }

        public Criteria andCertificate_typeNotIn(List<String> values) {
            addCriterion("`certificate_type` not in", values, "certificate_type");
            return (Criteria) this;
        }

        public Criteria andCertificate_typeBetween(String value1, String value2) {
            addCriterion("`certificate_type` between", value1, value2, "certificate_type");
            return (Criteria) this;
        }

        public Criteria andCertificate_typeNotBetween(String value1, String value2) {
            addCriterion("`certificate_type` not between", value1, value2, "certificate_type");
            return (Criteria) this;
        }

        public Criteria andCertificate_numIsNull() {
            addCriterion("`certificate_num` is null");
            return (Criteria) this;
        }

        public Criteria andCertificate_numIsNotNull() {
            addCriterion("`certificate_num` is not null");
            return (Criteria) this;
        }

        public Criteria andCertificate_numEqualTo(String value) {
            addCriterion("`certificate_num` =", value, "certificate_num");
            return (Criteria) this;
        }

        public Criteria andCertificate_numNotEqualTo(String value) {
            addCriterion("`certificate_num` <>", value, "certificate_num");
            return (Criteria) this;
        }

        public Criteria andCertificate_numGreaterThan(String value) {
            addCriterion("`certificate_num` >", value, "certificate_num");
            return (Criteria) this;
        }

        public Criteria andCertificate_numGreaterThanOrEqualTo(String value) {
            addCriterion("`certificate_num` >=", value, "certificate_num");
            return (Criteria) this;
        }

        public Criteria andCertificate_numLessThan(String value) {
            addCriterion("`certificate_num` <", value, "certificate_num");
            return (Criteria) this;
        }

        public Criteria andCertificate_numLessThanOrEqualTo(String value) {
            addCriterion("`certificate_num` <=", value, "certificate_num");
            return (Criteria) this;
        }

        public Criteria andCertificate_numLike(String value) {
            addCriterion("`certificate_num` like", value, "certificate_num");
            return (Criteria) this;
        }

        public Criteria andCertificate_numNotLike(String value) {
            addCriterion("`certificate_num` not like", value, "certificate_num");
            return (Criteria) this;
        }

        public Criteria andCertificate_numIn(List<String> values) {
            addCriterion("`certificate_num` in", values, "certificate_num");
            return (Criteria) this;
        }

        public Criteria andCertificate_numNotIn(List<String> values) {
            addCriterion("`certificate_num` not in", values, "certificate_num");
            return (Criteria) this;
        }

        public Criteria andCertificate_numBetween(String value1, String value2) {
            addCriterion("`certificate_num` between", value1, value2, "certificate_num");
            return (Criteria) this;
        }

        public Criteria andCertificate_numNotBetween(String value1, String value2) {
            addCriterion("`certificate_num` not between", value1, value2, "certificate_num");
            return (Criteria) this;
        }

        public Criteria andCustomer_contact_numIsNull() {
            addCriterion("`customer_contact_num` is null");
            return (Criteria) this;
        }

        public Criteria andCustomer_contact_numIsNotNull() {
            addCriterion("`customer_contact_num` is not null");
            return (Criteria) this;
        }

        public Criteria andCustomer_contact_numEqualTo(String value) {
            addCriterion("`customer_contact_num` =", value, "customer_contact_num");
            return (Criteria) this;
        }

        public Criteria andCustomer_contact_numNotEqualTo(String value) {
            addCriterion("`customer_contact_num` <>", value, "customer_contact_num");
            return (Criteria) this;
        }

        public Criteria andCustomer_contact_numGreaterThan(String value) {
            addCriterion("`customer_contact_num` >", value, "customer_contact_num");
            return (Criteria) this;
        }

        public Criteria andCustomer_contact_numGreaterThanOrEqualTo(String value) {
            addCriterion("`customer_contact_num` >=", value, "customer_contact_num");
            return (Criteria) this;
        }

        public Criteria andCustomer_contact_numLessThan(String value) {
            addCriterion("`customer_contact_num` <", value, "customer_contact_num");
            return (Criteria) this;
        }

        public Criteria andCustomer_contact_numLessThanOrEqualTo(String value) {
            addCriterion("`customer_contact_num` <=", value, "customer_contact_num");
            return (Criteria) this;
        }

        public Criteria andCustomer_contact_numLike(String value) {
            addCriterion("`customer_contact_num` like", value, "customer_contact_num");
            return (Criteria) this;
        }

        public Criteria andCustomer_contact_numNotLike(String value) {
            addCriterion("`customer_contact_num` not like", value, "customer_contact_num");
            return (Criteria) this;
        }

        public Criteria andCustomer_contact_numIn(List<String> values) {
            addCriterion("`customer_contact_num` in", values, "customer_contact_num");
            return (Criteria) this;
        }

        public Criteria andCustomer_contact_numNotIn(List<String> values) {
            addCriterion("`customer_contact_num` not in", values, "customer_contact_num");
            return (Criteria) this;
        }

        public Criteria andCustomer_contact_numBetween(String value1, String value2) {
            addCriterion("`customer_contact_num` between", value1, value2, "customer_contact_num");
            return (Criteria) this;
        }

        public Criteria andCustomer_contact_numNotBetween(String value1, String value2) {
            addCriterion("`customer_contact_num` not between", value1, value2, "customer_contact_num");
            return (Criteria) this;
        }

        public Criteria andGood_nameIsNull() {
            addCriterion("`good_name` is null");
            return (Criteria) this;
        }

        public Criteria andGood_nameIsNotNull() {
            addCriterion("`good_name` is not null");
            return (Criteria) this;
        }

        public Criteria andGood_nameEqualTo(String value) {
            addCriterion("`good_name` =", value, "good_name");
            return (Criteria) this;
        }

        public Criteria andGood_nameNotEqualTo(String value) {
            addCriterion("`good_name` <>", value, "good_name");
            return (Criteria) this;
        }

        public Criteria andGood_nameGreaterThan(String value) {
            addCriterion("`good_name` >", value, "good_name");
            return (Criteria) this;
        }

        public Criteria andGood_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`good_name` >=", value, "good_name");
            return (Criteria) this;
        }

        public Criteria andGood_nameLessThan(String value) {
            addCriterion("`good_name` <", value, "good_name");
            return (Criteria) this;
        }

        public Criteria andGood_nameLessThanOrEqualTo(String value) {
            addCriterion("`good_name` <=", value, "good_name");
            return (Criteria) this;
        }

        public Criteria andGood_nameLike(String value) {
            addCriterion("`good_name` like", value, "good_name");
            return (Criteria) this;
        }

        public Criteria andGood_nameNotLike(String value) {
            addCriterion("`good_name` not like", value, "good_name");
            return (Criteria) this;
        }

        public Criteria andGood_nameIn(List<String> values) {
            addCriterion("`good_name` in", values, "good_name");
            return (Criteria) this;
        }

        public Criteria andGood_nameNotIn(List<String> values) {
            addCriterion("`good_name` not in", values, "good_name");
            return (Criteria) this;
        }

        public Criteria andGood_nameBetween(String value1, String value2) {
            addCriterion("`good_name` between", value1, value2, "good_name");
            return (Criteria) this;
        }

        public Criteria andGood_nameNotBetween(String value1, String value2) {
            addCriterion("`good_name` not between", value1, value2, "good_name");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("`address` is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("`address` is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("`address` =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("`address` <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("`address` >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("`address` >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("`address` <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("`address` <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("`address` like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("`address` not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("`address` in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("`address` not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("`address` between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("`address` not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andActive_statusIsNull() {
            addCriterion("`active_status` is null");
            return (Criteria) this;
        }

        public Criteria andActive_statusIsNotNull() {
            addCriterion("`active_status` is not null");
            return (Criteria) this;
        }

        public Criteria andActive_statusEqualTo(String value) {
            addCriterion("`active_status` =", value, "active_status");
            return (Criteria) this;
        }

        public Criteria andActive_statusNotEqualTo(String value) {
            addCriterion("`active_status` <>", value, "active_status");
            return (Criteria) this;
        }

        public Criteria andActive_statusGreaterThan(String value) {
            addCriterion("`active_status` >", value, "active_status");
            return (Criteria) this;
        }

        public Criteria andActive_statusGreaterThanOrEqualTo(String value) {
            addCriterion("`active_status` >=", value, "active_status");
            return (Criteria) this;
        }

        public Criteria andActive_statusLessThan(String value) {
            addCriterion("`active_status` <", value, "active_status");
            return (Criteria) this;
        }

        public Criteria andActive_statusLessThanOrEqualTo(String value) {
            addCriterion("`active_status` <=", value, "active_status");
            return (Criteria) this;
        }

        public Criteria andActive_statusLike(String value) {
            addCriterion("`active_status` like", value, "active_status");
            return (Criteria) this;
        }

        public Criteria andActive_statusNotLike(String value) {
            addCriterion("`active_status` not like", value, "active_status");
            return (Criteria) this;
        }

        public Criteria andActive_statusIn(List<String> values) {
            addCriterion("`active_status` in", values, "active_status");
            return (Criteria) this;
        }

        public Criteria andActive_statusNotIn(List<String> values) {
            addCriterion("`active_status` not in", values, "active_status");
            return (Criteria) this;
        }

        public Criteria andActive_statusBetween(String value1, String value2) {
            addCriterion("`active_status` between", value1, value2, "active_status");
            return (Criteria) this;
        }

        public Criteria andActive_statusNotBetween(String value1, String value2) {
            addCriterion("`active_status` not between", value1, value2, "active_status");
            return (Criteria) this;
        }

        public Criteria andCudian_codeIsNull() {
            addCriterion("`cudian_code` is null");
            return (Criteria) this;
        }

        public Criteria andCudian_codeIsNotNull() {
            addCriterion("`cudian_code` is not null");
            return (Criteria) this;
        }

        public Criteria andCudian_codeEqualTo(String value) {
            addCriterion("`cudian_code` =", value, "cudian_code");
            return (Criteria) this;
        }

        public Criteria andCudian_codeNotEqualTo(String value) {
            addCriterion("`cudian_code` <>", value, "cudian_code");
            return (Criteria) this;
        }

        public Criteria andCudian_codeGreaterThan(String value) {
            addCriterion("`cudian_code` >", value, "cudian_code");
            return (Criteria) this;
        }

        public Criteria andCudian_codeGreaterThanOrEqualTo(String value) {
            addCriterion("`cudian_code` >=", value, "cudian_code");
            return (Criteria) this;
        }

        public Criteria andCudian_codeLessThan(String value) {
            addCriterion("`cudian_code` <", value, "cudian_code");
            return (Criteria) this;
        }

        public Criteria andCudian_codeLessThanOrEqualTo(String value) {
            addCriterion("`cudian_code` <=", value, "cudian_code");
            return (Criteria) this;
        }

        public Criteria andCudian_codeLike(String value) {
            addCriterion("`cudian_code` like", value, "cudian_code");
            return (Criteria) this;
        }

        public Criteria andCudian_codeNotLike(String value) {
            addCriterion("`cudian_code` not like", value, "cudian_code");
            return (Criteria) this;
        }

        public Criteria andCudian_codeIn(List<String> values) {
            addCriterion("`cudian_code` in", values, "cudian_code");
            return (Criteria) this;
        }

        public Criteria andCudian_codeNotIn(List<String> values) {
            addCriterion("`cudian_code` not in", values, "cudian_code");
            return (Criteria) this;
        }

        public Criteria andCudian_codeBetween(String value1, String value2) {
            addCriterion("`cudian_code` between", value1, value2, "cudian_code");
            return (Criteria) this;
        }

        public Criteria andCudian_codeNotBetween(String value1, String value2) {
            addCriterion("`cudian_code` not between", value1, value2, "cudian_code");
            return (Criteria) this;
        }

        public Criteria andShoucong_amtIsNull() {
            addCriterion("`shoucong_amt` is null");
            return (Criteria) this;
        }

        public Criteria andShoucong_amtIsNotNull() {
            addCriterion("`shoucong_amt` is not null");
            return (Criteria) this;
        }

        public Criteria andShoucong_amtEqualTo(String value) {
            addCriterion("`shoucong_amt` =", value, "shoucong_amt");
            return (Criteria) this;
        }

        public Criteria andShoucong_amtNotEqualTo(String value) {
            addCriterion("`shoucong_amt` <>", value, "shoucong_amt");
            return (Criteria) this;
        }

        public Criteria andShoucong_amtGreaterThan(String value) {
            addCriterion("`shoucong_amt` >", value, "shoucong_amt");
            return (Criteria) this;
        }

        public Criteria andShoucong_amtGreaterThanOrEqualTo(String value) {
            addCriterion("`shoucong_amt` >=", value, "shoucong_amt");
            return (Criteria) this;
        }

        public Criteria andShoucong_amtLessThan(String value) {
            addCriterion("`shoucong_amt` <", value, "shoucong_amt");
            return (Criteria) this;
        }

        public Criteria andShoucong_amtLessThanOrEqualTo(String value) {
            addCriterion("`shoucong_amt` <=", value, "shoucong_amt");
            return (Criteria) this;
        }

        public Criteria andShoucong_amtLike(String value) {
            addCriterion("`shoucong_amt` like", value, "shoucong_amt");
            return (Criteria) this;
        }

        public Criteria andShoucong_amtNotLike(String value) {
            addCriterion("`shoucong_amt` not like", value, "shoucong_amt");
            return (Criteria) this;
        }

        public Criteria andShoucong_amtIn(List<String> values) {
            addCriterion("`shoucong_amt` in", values, "shoucong_amt");
            return (Criteria) this;
        }

        public Criteria andShoucong_amtNotIn(List<String> values) {
            addCriterion("`shoucong_amt` not in", values, "shoucong_amt");
            return (Criteria) this;
        }

        public Criteria andShoucong_amtBetween(String value1, String value2) {
            addCriterion("`shoucong_amt` between", value1, value2, "shoucong_amt");
            return (Criteria) this;
        }

        public Criteria andShoucong_amtNotBetween(String value1, String value2) {
            addCriterion("`shoucong_amt` not between", value1, value2, "shoucong_amt");
            return (Criteria) this;
        }

        public Criteria andShoucong_timeIsNull() {
            addCriterion("`shoucong_time` is null");
            return (Criteria) this;
        }

        public Criteria andShoucong_timeIsNotNull() {
            addCriterion("`shoucong_time` is not null");
            return (Criteria) this;
        }

        public Criteria andShoucong_timeEqualTo(String value) {
            addCriterion("`shoucong_time` =", value, "shoucong_time");
            return (Criteria) this;
        }

        public Criteria andShoucong_timeNotEqualTo(String value) {
            addCriterion("`shoucong_time` <>", value, "shoucong_time");
            return (Criteria) this;
        }

        public Criteria andShoucong_timeGreaterThan(String value) {
            addCriterion("`shoucong_time` >", value, "shoucong_time");
            return (Criteria) this;
        }

        public Criteria andShoucong_timeGreaterThanOrEqualTo(String value) {
            addCriterion("`shoucong_time` >=", value, "shoucong_time");
            return (Criteria) this;
        }

        public Criteria andShoucong_timeLessThan(String value) {
            addCriterion("`shoucong_time` <", value, "shoucong_time");
            return (Criteria) this;
        }

        public Criteria andShoucong_timeLessThanOrEqualTo(String value) {
            addCriterion("`shoucong_time` <=", value, "shoucong_time");
            return (Criteria) this;
        }

        public Criteria andShoucong_timeLike(String value) {
            addCriterion("`shoucong_time` like", value, "shoucong_time");
            return (Criteria) this;
        }

        public Criteria andShoucong_timeNotLike(String value) {
            addCriterion("`shoucong_time` not like", value, "shoucong_time");
            return (Criteria) this;
        }

        public Criteria andShoucong_timeIn(List<String> values) {
            addCriterion("`shoucong_time` in", values, "shoucong_time");
            return (Criteria) this;
        }

        public Criteria andShoucong_timeNotIn(List<String> values) {
            addCriterion("`shoucong_time` not in", values, "shoucong_time");
            return (Criteria) this;
        }

        public Criteria andShoucong_timeBetween(String value1, String value2) {
            addCriterion("`shoucong_time` between", value1, value2, "shoucong_time");
            return (Criteria) this;
        }

        public Criteria andShoucong_timeNotBetween(String value1, String value2) {
            addCriterion("`shoucong_time` not between", value1, value2, "shoucong_time");
            return (Criteria) this;
        }

        public Criteria andXiehaozhuanwang_typeIsNull() {
            addCriterion("`xiehaozhuanwang_type` is null");
            return (Criteria) this;
        }

        public Criteria andXiehaozhuanwang_typeIsNotNull() {
            addCriterion("`xiehaozhuanwang_type` is not null");
            return (Criteria) this;
        }

        public Criteria andXiehaozhuanwang_typeEqualTo(String value) {
            addCriterion("`xiehaozhuanwang_type` =", value, "xiehaozhuanwang_type");
            return (Criteria) this;
        }

        public Criteria andXiehaozhuanwang_typeNotEqualTo(String value) {
            addCriterion("`xiehaozhuanwang_type` <>", value, "xiehaozhuanwang_type");
            return (Criteria) this;
        }

        public Criteria andXiehaozhuanwang_typeGreaterThan(String value) {
            addCriterion("`xiehaozhuanwang_type` >", value, "xiehaozhuanwang_type");
            return (Criteria) this;
        }

        public Criteria andXiehaozhuanwang_typeGreaterThanOrEqualTo(String value) {
            addCriterion("`xiehaozhuanwang_type` >=", value, "xiehaozhuanwang_type");
            return (Criteria) this;
        }

        public Criteria andXiehaozhuanwang_typeLessThan(String value) {
            addCriterion("`xiehaozhuanwang_type` <", value, "xiehaozhuanwang_type");
            return (Criteria) this;
        }

        public Criteria andXiehaozhuanwang_typeLessThanOrEqualTo(String value) {
            addCriterion("`xiehaozhuanwang_type` <=", value, "xiehaozhuanwang_type");
            return (Criteria) this;
        }

        public Criteria andXiehaozhuanwang_typeLike(String value) {
            addCriterion("`xiehaozhuanwang_type` like", value, "xiehaozhuanwang_type");
            return (Criteria) this;
        }

        public Criteria andXiehaozhuanwang_typeNotLike(String value) {
            addCriterion("`xiehaozhuanwang_type` not like", value, "xiehaozhuanwang_type");
            return (Criteria) this;
        }

        public Criteria andXiehaozhuanwang_typeIn(List<String> values) {
            addCriterion("`xiehaozhuanwang_type` in", values, "xiehaozhuanwang_type");
            return (Criteria) this;
        }

        public Criteria andXiehaozhuanwang_typeNotIn(List<String> values) {
            addCriterion("`xiehaozhuanwang_type` not in", values, "xiehaozhuanwang_type");
            return (Criteria) this;
        }

        public Criteria andXiehaozhuanwang_typeBetween(String value1, String value2) {
            addCriterion("`xiehaozhuanwang_type` between", value1, value2, "xiehaozhuanwang_type");
            return (Criteria) this;
        }

        public Criteria andXiehaozhuanwang_typeNotBetween(String value1, String value2) {
            addCriterion("`xiehaozhuanwang_type` not between", value1, value2, "xiehaozhuanwang_type");
            return (Criteria) this;
        }

        public Criteria andZhuanhualvtichu_reasonIsNull() {
            addCriterion("`zhuanhualvtichu_reason` is null");
            return (Criteria) this;
        }

        public Criteria andZhuanhualvtichu_reasonIsNotNull() {
            addCriterion("`zhuanhualvtichu_reason` is not null");
            return (Criteria) this;
        }

        public Criteria andZhuanhualvtichu_reasonEqualTo(String value) {
            addCriterion("`zhuanhualvtichu_reason` =", value, "zhuanhualvtichu_reason");
            return (Criteria) this;
        }

        public Criteria andZhuanhualvtichu_reasonNotEqualTo(String value) {
            addCriterion("`zhuanhualvtichu_reason` <>", value, "zhuanhualvtichu_reason");
            return (Criteria) this;
        }

        public Criteria andZhuanhualvtichu_reasonGreaterThan(String value) {
            addCriterion("`zhuanhualvtichu_reason` >", value, "zhuanhualvtichu_reason");
            return (Criteria) this;
        }

        public Criteria andZhuanhualvtichu_reasonGreaterThanOrEqualTo(String value) {
            addCriterion("`zhuanhualvtichu_reason` >=", value, "zhuanhualvtichu_reason");
            return (Criteria) this;
        }

        public Criteria andZhuanhualvtichu_reasonLessThan(String value) {
            addCriterion("`zhuanhualvtichu_reason` <", value, "zhuanhualvtichu_reason");
            return (Criteria) this;
        }

        public Criteria andZhuanhualvtichu_reasonLessThanOrEqualTo(String value) {
            addCriterion("`zhuanhualvtichu_reason` <=", value, "zhuanhualvtichu_reason");
            return (Criteria) this;
        }

        public Criteria andZhuanhualvtichu_reasonLike(String value) {
            addCriterion("`zhuanhualvtichu_reason` like", value, "zhuanhualvtichu_reason");
            return (Criteria) this;
        }

        public Criteria andZhuanhualvtichu_reasonNotLike(String value) {
            addCriterion("`zhuanhualvtichu_reason` not like", value, "zhuanhualvtichu_reason");
            return (Criteria) this;
        }

        public Criteria andZhuanhualvtichu_reasonIn(List<String> values) {
            addCriterion("`zhuanhualvtichu_reason` in", values, "zhuanhualvtichu_reason");
            return (Criteria) this;
        }

        public Criteria andZhuanhualvtichu_reasonNotIn(List<String> values) {
            addCriterion("`zhuanhualvtichu_reason` not in", values, "zhuanhualvtichu_reason");
            return (Criteria) this;
        }

        public Criteria andZhuanhualvtichu_reasonBetween(String value1, String value2) {
            addCriterion("`zhuanhualvtichu_reason` between", value1, value2, "zhuanhualvtichu_reason");
            return (Criteria) this;
        }

        public Criteria andZhuanhualvtichu_reasonNotBetween(String value1, String value2) {
            addCriterion("`zhuanhualvtichu_reason` not between", value1, value2, "zhuanhualvtichu_reason");
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

        public Criteria andDescriptionIsNull() {
            addCriterion("`description` is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("`description` is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("`description` =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("`description` <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("`description` >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("`description` >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("`description` <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("`description` <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("`description` like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("`description` not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("`description` in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("`description` not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("`description` between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("`description` not between", value1, value2, "description");
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
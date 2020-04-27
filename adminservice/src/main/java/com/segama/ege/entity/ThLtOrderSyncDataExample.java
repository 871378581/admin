package com.segama.ege.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThLtOrderSyncDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public ThLtOrderSyncDataExample() {
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

        public Criteria andCodeIsNull() {
            addCriterion("`code` is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("`code` is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("`code` =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("`code` <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("`code` >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("`code` >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("`code` <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("`code` <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("`code` like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("`code` not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("`code` in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("`code` not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("`code` between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("`code` not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andChannel_codeIsNull() {
            addCriterion("`channel_code` is null");
            return (Criteria) this;
        }

        public Criteria andChannel_codeIsNotNull() {
            addCriterion("`channel_code` is not null");
            return (Criteria) this;
        }

        public Criteria andChannel_codeEqualTo(String value) {
            addCriterion("`channel_code` =", value, "channel_code");
            return (Criteria) this;
        }

        public Criteria andChannel_codeNotEqualTo(String value) {
            addCriterion("`channel_code` <>", value, "channel_code");
            return (Criteria) this;
        }

        public Criteria andChannel_codeGreaterThan(String value) {
            addCriterion("`channel_code` >", value, "channel_code");
            return (Criteria) this;
        }

        public Criteria andChannel_codeGreaterThanOrEqualTo(String value) {
            addCriterion("`channel_code` >=", value, "channel_code");
            return (Criteria) this;
        }

        public Criteria andChannel_codeLessThan(String value) {
            addCriterion("`channel_code` <", value, "channel_code");
            return (Criteria) this;
        }

        public Criteria andChannel_codeLessThanOrEqualTo(String value) {
            addCriterion("`channel_code` <=", value, "channel_code");
            return (Criteria) this;
        }

        public Criteria andChannel_codeLike(String value) {
            addCriterion("`channel_code` like", value, "channel_code");
            return (Criteria) this;
        }

        public Criteria andChannel_codeNotLike(String value) {
            addCriterion("`channel_code` not like", value, "channel_code");
            return (Criteria) this;
        }

        public Criteria andChannel_codeIn(List<String> values) {
            addCriterion("`channel_code` in", values, "channel_code");
            return (Criteria) this;
        }

        public Criteria andChannel_codeNotIn(List<String> values) {
            addCriterion("`channel_code` not in", values, "channel_code");
            return (Criteria) this;
        }

        public Criteria andChannel_codeBetween(String value1, String value2) {
            addCriterion("`channel_code` between", value1, value2, "channel_code");
            return (Criteria) this;
        }

        public Criteria andChannel_codeNotBetween(String value1, String value2) {
            addCriterion("`channel_code` not between", value1, value2, "channel_code");
            return (Criteria) this;
        }

        public Criteria andExtendIsNull() {
            addCriterion("`extend` is null");
            return (Criteria) this;
        }

        public Criteria andExtendIsNotNull() {
            addCriterion("`extend` is not null");
            return (Criteria) this;
        }

        public Criteria andExtendEqualTo(String value) {
            addCriterion("`extend` =", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotEqualTo(String value) {
            addCriterion("`extend` <>", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendGreaterThan(String value) {
            addCriterion("`extend` >", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendGreaterThanOrEqualTo(String value) {
            addCriterion("`extend` >=", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLessThan(String value) {
            addCriterion("`extend` <", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLessThanOrEqualTo(String value) {
            addCriterion("`extend` <=", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLike(String value) {
            addCriterion("`extend` like", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotLike(String value) {
            addCriterion("`extend` not like", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendIn(List<String> values) {
            addCriterion("`extend` in", values, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotIn(List<String> values) {
            addCriterion("`extend` not in", values, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendBetween(String value1, String value2) {
            addCriterion("`extend` between", value1, value2, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotBetween(String value1, String value2) {
            addCriterion("`extend` not between", value1, value2, "extend");
            return (Criteria) this;
        }

        public Criteria andCity_nameIsNull() {
            addCriterion("`city_name` is null");
            return (Criteria) this;
        }

        public Criteria andCity_nameIsNotNull() {
            addCriterion("`city_name` is not null");
            return (Criteria) this;
        }

        public Criteria andCity_nameEqualTo(String value) {
            addCriterion("`city_name` =", value, "city_name");
            return (Criteria) this;
        }

        public Criteria andCity_nameNotEqualTo(String value) {
            addCriterion("`city_name` <>", value, "city_name");
            return (Criteria) this;
        }

        public Criteria andCity_nameGreaterThan(String value) {
            addCriterion("`city_name` >", value, "city_name");
            return (Criteria) this;
        }

        public Criteria andCity_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`city_name` >=", value, "city_name");
            return (Criteria) this;
        }

        public Criteria andCity_nameLessThan(String value) {
            addCriterion("`city_name` <", value, "city_name");
            return (Criteria) this;
        }

        public Criteria andCity_nameLessThanOrEqualTo(String value) {
            addCriterion("`city_name` <=", value, "city_name");
            return (Criteria) this;
        }

        public Criteria andCity_nameLike(String value) {
            addCriterion("`city_name` like", value, "city_name");
            return (Criteria) this;
        }

        public Criteria andCity_nameNotLike(String value) {
            addCriterion("`city_name` not like", value, "city_name");
            return (Criteria) this;
        }

        public Criteria andCity_nameIn(List<String> values) {
            addCriterion("`city_name` in", values, "city_name");
            return (Criteria) this;
        }

        public Criteria andCity_nameNotIn(List<String> values) {
            addCriterion("`city_name` not in", values, "city_name");
            return (Criteria) this;
        }

        public Criteria andCity_nameBetween(String value1, String value2) {
            addCriterion("`city_name` between", value1, value2, "city_name");
            return (Criteria) this;
        }

        public Criteria andCity_nameNotBetween(String value1, String value2) {
            addCriterion("`city_name` not between", value1, value2, "city_name");
            return (Criteria) this;
        }

        public Criteria andPacakge_codeIsNull() {
            addCriterion("`pacakge_code` is null");
            return (Criteria) this;
        }

        public Criteria andPacakge_codeIsNotNull() {
            addCriterion("`pacakge_code` is not null");
            return (Criteria) this;
        }

        public Criteria andPacakge_codeEqualTo(String value) {
            addCriterion("`pacakge_code` =", value, "pacakge_code");
            return (Criteria) this;
        }

        public Criteria andPacakge_codeNotEqualTo(String value) {
            addCriterion("`pacakge_code` <>", value, "pacakge_code");
            return (Criteria) this;
        }

        public Criteria andPacakge_codeGreaterThan(String value) {
            addCriterion("`pacakge_code` >", value, "pacakge_code");
            return (Criteria) this;
        }

        public Criteria andPacakge_codeGreaterThanOrEqualTo(String value) {
            addCriterion("`pacakge_code` >=", value, "pacakge_code");
            return (Criteria) this;
        }

        public Criteria andPacakge_codeLessThan(String value) {
            addCriterion("`pacakge_code` <", value, "pacakge_code");
            return (Criteria) this;
        }

        public Criteria andPacakge_codeLessThanOrEqualTo(String value) {
            addCriterion("`pacakge_code` <=", value, "pacakge_code");
            return (Criteria) this;
        }

        public Criteria andPacakge_codeLike(String value) {
            addCriterion("`pacakge_code` like", value, "pacakge_code");
            return (Criteria) this;
        }

        public Criteria andPacakge_codeNotLike(String value) {
            addCriterion("`pacakge_code` not like", value, "pacakge_code");
            return (Criteria) this;
        }

        public Criteria andPacakge_codeIn(List<String> values) {
            addCriterion("`pacakge_code` in", values, "pacakge_code");
            return (Criteria) this;
        }

        public Criteria andPacakge_codeNotIn(List<String> values) {
            addCriterion("`pacakge_code` not in", values, "pacakge_code");
            return (Criteria) this;
        }

        public Criteria andPacakge_codeBetween(String value1, String value2) {
            addCriterion("`pacakge_code` between", value1, value2, "pacakge_code");
            return (Criteria) this;
        }

        public Criteria andPacakge_codeNotBetween(String value1, String value2) {
            addCriterion("`pacakge_code` not between", value1, value2, "pacakge_code");
            return (Criteria) this;
        }

        public Criteria andPacakge_nameIsNull() {
            addCriterion("`pacakge_name` is null");
            return (Criteria) this;
        }

        public Criteria andPacakge_nameIsNotNull() {
            addCriterion("`pacakge_name` is not null");
            return (Criteria) this;
        }

        public Criteria andPacakge_nameEqualTo(String value) {
            addCriterion("`pacakge_name` =", value, "pacakge_name");
            return (Criteria) this;
        }

        public Criteria andPacakge_nameNotEqualTo(String value) {
            addCriterion("`pacakge_name` <>", value, "pacakge_name");
            return (Criteria) this;
        }

        public Criteria andPacakge_nameGreaterThan(String value) {
            addCriterion("`pacakge_name` >", value, "pacakge_name");
            return (Criteria) this;
        }

        public Criteria andPacakge_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`pacakge_name` >=", value, "pacakge_name");
            return (Criteria) this;
        }

        public Criteria andPacakge_nameLessThan(String value) {
            addCriterion("`pacakge_name` <", value, "pacakge_name");
            return (Criteria) this;
        }

        public Criteria andPacakge_nameLessThanOrEqualTo(String value) {
            addCriterion("`pacakge_name` <=", value, "pacakge_name");
            return (Criteria) this;
        }

        public Criteria andPacakge_nameLike(String value) {
            addCriterion("`pacakge_name` like", value, "pacakge_name");
            return (Criteria) this;
        }

        public Criteria andPacakge_nameNotLike(String value) {
            addCriterion("`pacakge_name` not like", value, "pacakge_name");
            return (Criteria) this;
        }

        public Criteria andPacakge_nameIn(List<String> values) {
            addCriterion("`pacakge_name` in", values, "pacakge_name");
            return (Criteria) this;
        }

        public Criteria andPacakge_nameNotIn(List<String> values) {
            addCriterion("`pacakge_name` not in", values, "pacakge_name");
            return (Criteria) this;
        }

        public Criteria andPacakge_nameBetween(String value1, String value2) {
            addCriterion("`pacakge_name` between", value1, value2, "pacakge_name");
            return (Criteria) this;
        }

        public Criteria andPacakge_nameNotBetween(String value1, String value2) {
            addCriterion("`pacakge_name` not between", value1, value2, "pacakge_name");
            return (Criteria) this;
        }

        public Criteria andContract_periodIsNull() {
            addCriterion("`contract_period` is null");
            return (Criteria) this;
        }

        public Criteria andContract_periodIsNotNull() {
            addCriterion("`contract_period` is not null");
            return (Criteria) this;
        }

        public Criteria andContract_periodEqualTo(String value) {
            addCriterion("`contract_period` =", value, "contract_period");
            return (Criteria) this;
        }

        public Criteria andContract_periodNotEqualTo(String value) {
            addCriterion("`contract_period` <>", value, "contract_period");
            return (Criteria) this;
        }

        public Criteria andContract_periodGreaterThan(String value) {
            addCriterion("`contract_period` >", value, "contract_period");
            return (Criteria) this;
        }

        public Criteria andContract_periodGreaterThanOrEqualTo(String value) {
            addCriterion("`contract_period` >=", value, "contract_period");
            return (Criteria) this;
        }

        public Criteria andContract_periodLessThan(String value) {
            addCriterion("`contract_period` <", value, "contract_period");
            return (Criteria) this;
        }

        public Criteria andContract_periodLessThanOrEqualTo(String value) {
            addCriterion("`contract_period` <=", value, "contract_period");
            return (Criteria) this;
        }

        public Criteria andContract_periodLike(String value) {
            addCriterion("`contract_period` like", value, "contract_period");
            return (Criteria) this;
        }

        public Criteria andContract_periodNotLike(String value) {
            addCriterion("`contract_period` not like", value, "contract_period");
            return (Criteria) this;
        }

        public Criteria andContract_periodIn(List<String> values) {
            addCriterion("`contract_period` in", values, "contract_period");
            return (Criteria) this;
        }

        public Criteria andContract_periodNotIn(List<String> values) {
            addCriterion("`contract_period` not in", values, "contract_period");
            return (Criteria) this;
        }

        public Criteria andContract_periodBetween(String value1, String value2) {
            addCriterion("`contract_period` between", value1, value2, "contract_period");
            return (Criteria) this;
        }

        public Criteria andContract_periodNotBetween(String value1, String value2) {
            addCriterion("`contract_period` not between", value1, value2, "contract_period");
            return (Criteria) this;
        }

        public Criteria andDiscount_amountIsNull() {
            addCriterion("`discount_amount` is null");
            return (Criteria) this;
        }

        public Criteria andDiscount_amountIsNotNull() {
            addCriterion("`discount_amount` is not null");
            return (Criteria) this;
        }

        public Criteria andDiscount_amountEqualTo(String value) {
            addCriterion("`discount_amount` =", value, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDiscount_amountNotEqualTo(String value) {
            addCriterion("`discount_amount` <>", value, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDiscount_amountGreaterThan(String value) {
            addCriterion("`discount_amount` >", value, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDiscount_amountGreaterThanOrEqualTo(String value) {
            addCriterion("`discount_amount` >=", value, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDiscount_amountLessThan(String value) {
            addCriterion("`discount_amount` <", value, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDiscount_amountLessThanOrEqualTo(String value) {
            addCriterion("`discount_amount` <=", value, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDiscount_amountLike(String value) {
            addCriterion("`discount_amount` like", value, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDiscount_amountNotLike(String value) {
            addCriterion("`discount_amount` not like", value, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDiscount_amountIn(List<String> values) {
            addCriterion("`discount_amount` in", values, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDiscount_amountNotIn(List<String> values) {
            addCriterion("`discount_amount` not in", values, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDiscount_amountBetween(String value1, String value2) {
            addCriterion("`discount_amount` between", value1, value2, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andDiscount_amountNotBetween(String value1, String value2) {
            addCriterion("`discount_amount` not between", value1, value2, "discount_amount");
            return (Criteria) this;
        }

        public Criteria andAccess_nameIsNull() {
            addCriterion("`access_name` is null");
            return (Criteria) this;
        }

        public Criteria andAccess_nameIsNotNull() {
            addCriterion("`access_name` is not null");
            return (Criteria) this;
        }

        public Criteria andAccess_nameEqualTo(String value) {
            addCriterion("`access_name` =", value, "access_name");
            return (Criteria) this;
        }

        public Criteria andAccess_nameNotEqualTo(String value) {
            addCriterion("`access_name` <>", value, "access_name");
            return (Criteria) this;
        }

        public Criteria andAccess_nameGreaterThan(String value) {
            addCriterion("`access_name` >", value, "access_name");
            return (Criteria) this;
        }

        public Criteria andAccess_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`access_name` >=", value, "access_name");
            return (Criteria) this;
        }

        public Criteria andAccess_nameLessThan(String value) {
            addCriterion("`access_name` <", value, "access_name");
            return (Criteria) this;
        }

        public Criteria andAccess_nameLessThanOrEqualTo(String value) {
            addCriterion("`access_name` <=", value, "access_name");
            return (Criteria) this;
        }

        public Criteria andAccess_nameLike(String value) {
            addCriterion("`access_name` like", value, "access_name");
            return (Criteria) this;
        }

        public Criteria andAccess_nameNotLike(String value) {
            addCriterion("`access_name` not like", value, "access_name");
            return (Criteria) this;
        }

        public Criteria andAccess_nameIn(List<String> values) {
            addCriterion("`access_name` in", values, "access_name");
            return (Criteria) this;
        }

        public Criteria andAccess_nameNotIn(List<String> values) {
            addCriterion("`access_name` not in", values, "access_name");
            return (Criteria) this;
        }

        public Criteria andAccess_nameBetween(String value1, String value2) {
            addCriterion("`access_name` between", value1, value2, "access_name");
            return (Criteria) this;
        }

        public Criteria andAccess_nameNotBetween(String value1, String value2) {
            addCriterion("`access_name` not between", value1, value2, "access_name");
            return (Criteria) this;
        }

        public Criteria andId_numberIsNull() {
            addCriterion("`id_number` is null");
            return (Criteria) this;
        }

        public Criteria andId_numberIsNotNull() {
            addCriterion("`id_number` is not null");
            return (Criteria) this;
        }

        public Criteria andId_numberEqualTo(String value) {
            addCriterion("`id_number` =", value, "id_number");
            return (Criteria) this;
        }

        public Criteria andId_numberNotEqualTo(String value) {
            addCriterion("`id_number` <>", value, "id_number");
            return (Criteria) this;
        }

        public Criteria andId_numberGreaterThan(String value) {
            addCriterion("`id_number` >", value, "id_number");
            return (Criteria) this;
        }

        public Criteria andId_numberGreaterThanOrEqualTo(String value) {
            addCriterion("`id_number` >=", value, "id_number");
            return (Criteria) this;
        }

        public Criteria andId_numberLessThan(String value) {
            addCriterion("`id_number` <", value, "id_number");
            return (Criteria) this;
        }

        public Criteria andId_numberLessThanOrEqualTo(String value) {
            addCriterion("`id_number` <=", value, "id_number");
            return (Criteria) this;
        }

        public Criteria andId_numberLike(String value) {
            addCriterion("`id_number` like", value, "id_number");
            return (Criteria) this;
        }

        public Criteria andId_numberNotLike(String value) {
            addCriterion("`id_number` not like", value, "id_number");
            return (Criteria) this;
        }

        public Criteria andId_numberIn(List<String> values) {
            addCriterion("`id_number` in", values, "id_number");
            return (Criteria) this;
        }

        public Criteria andId_numberNotIn(List<String> values) {
            addCriterion("`id_number` not in", values, "id_number");
            return (Criteria) this;
        }

        public Criteria andId_numberBetween(String value1, String value2) {
            addCriterion("`id_number` between", value1, value2, "id_number");
            return (Criteria) this;
        }

        public Criteria andId_numberNotBetween(String value1, String value2) {
            addCriterion("`id_number` not between", value1, value2, "id_number");
            return (Criteria) this;
        }

        public Criteria andAddresseeIsNull() {
            addCriterion("`addressee` is null");
            return (Criteria) this;
        }

        public Criteria andAddresseeIsNotNull() {
            addCriterion("`addressee` is not null");
            return (Criteria) this;
        }

        public Criteria andAddresseeEqualTo(String value) {
            addCriterion("`addressee` =", value, "addressee");
            return (Criteria) this;
        }

        public Criteria andAddresseeNotEqualTo(String value) {
            addCriterion("`addressee` <>", value, "addressee");
            return (Criteria) this;
        }

        public Criteria andAddresseeGreaterThan(String value) {
            addCriterion("`addressee` >", value, "addressee");
            return (Criteria) this;
        }

        public Criteria andAddresseeGreaterThanOrEqualTo(String value) {
            addCriterion("`addressee` >=", value, "addressee");
            return (Criteria) this;
        }

        public Criteria andAddresseeLessThan(String value) {
            addCriterion("`addressee` <", value, "addressee");
            return (Criteria) this;
        }

        public Criteria andAddresseeLessThanOrEqualTo(String value) {
            addCriterion("`addressee` <=", value, "addressee");
            return (Criteria) this;
        }

        public Criteria andAddresseeLike(String value) {
            addCriterion("`addressee` like", value, "addressee");
            return (Criteria) this;
        }

        public Criteria andAddresseeNotLike(String value) {
            addCriterion("`addressee` not like", value, "addressee");
            return (Criteria) this;
        }

        public Criteria andAddresseeIn(List<String> values) {
            addCriterion("`addressee` in", values, "addressee");
            return (Criteria) this;
        }

        public Criteria andAddresseeNotIn(List<String> values) {
            addCriterion("`addressee` not in", values, "addressee");
            return (Criteria) this;
        }

        public Criteria andAddresseeBetween(String value1, String value2) {
            addCriterion("`addressee` between", value1, value2, "addressee");
            return (Criteria) this;
        }

        public Criteria andAddresseeNotBetween(String value1, String value2) {
            addCriterion("`addressee` not between", value1, value2, "addressee");
            return (Criteria) this;
        }

        public Criteria andAddressee_phoneIsNull() {
            addCriterion("`addressee_phone` is null");
            return (Criteria) this;
        }

        public Criteria andAddressee_phoneIsNotNull() {
            addCriterion("`addressee_phone` is not null");
            return (Criteria) this;
        }

        public Criteria andAddressee_phoneEqualTo(String value) {
            addCriterion("`addressee_phone` =", value, "addressee_phone");
            return (Criteria) this;
        }

        public Criteria andAddressee_phoneNotEqualTo(String value) {
            addCriterion("`addressee_phone` <>", value, "addressee_phone");
            return (Criteria) this;
        }

        public Criteria andAddressee_phoneGreaterThan(String value) {
            addCriterion("`addressee_phone` >", value, "addressee_phone");
            return (Criteria) this;
        }

        public Criteria andAddressee_phoneGreaterThanOrEqualTo(String value) {
            addCriterion("`addressee_phone` >=", value, "addressee_phone");
            return (Criteria) this;
        }

        public Criteria andAddressee_phoneLessThan(String value) {
            addCriterion("`addressee_phone` <", value, "addressee_phone");
            return (Criteria) this;
        }

        public Criteria andAddressee_phoneLessThanOrEqualTo(String value) {
            addCriterion("`addressee_phone` <=", value, "addressee_phone");
            return (Criteria) this;
        }

        public Criteria andAddressee_phoneLike(String value) {
            addCriterion("`addressee_phone` like", value, "addressee_phone");
            return (Criteria) this;
        }

        public Criteria andAddressee_phoneNotLike(String value) {
            addCriterion("`addressee_phone` not like", value, "addressee_phone");
            return (Criteria) this;
        }

        public Criteria andAddressee_phoneIn(List<String> values) {
            addCriterion("`addressee_phone` in", values, "addressee_phone");
            return (Criteria) this;
        }

        public Criteria andAddressee_phoneNotIn(List<String> values) {
            addCriterion("`addressee_phone` not in", values, "addressee_phone");
            return (Criteria) this;
        }

        public Criteria andAddressee_phoneBetween(String value1, String value2) {
            addCriterion("`addressee_phone` between", value1, value2, "addressee_phone");
            return (Criteria) this;
        }

        public Criteria andAddressee_phoneNotBetween(String value1, String value2) {
            addCriterion("`addressee_phone` not between", value1, value2, "addressee_phone");
            return (Criteria) this;
        }

        public Criteria andDistrict_nameIsNull() {
            addCriterion("`district_name` is null");
            return (Criteria) this;
        }

        public Criteria andDistrict_nameIsNotNull() {
            addCriterion("`district_name` is not null");
            return (Criteria) this;
        }

        public Criteria andDistrict_nameEqualTo(String value) {
            addCriterion("`district_name` =", value, "district_name");
            return (Criteria) this;
        }

        public Criteria andDistrict_nameNotEqualTo(String value) {
            addCriterion("`district_name` <>", value, "district_name");
            return (Criteria) this;
        }

        public Criteria andDistrict_nameGreaterThan(String value) {
            addCriterion("`district_name` >", value, "district_name");
            return (Criteria) this;
        }

        public Criteria andDistrict_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`district_name` >=", value, "district_name");
            return (Criteria) this;
        }

        public Criteria andDistrict_nameLessThan(String value) {
            addCriterion("`district_name` <", value, "district_name");
            return (Criteria) this;
        }

        public Criteria andDistrict_nameLessThanOrEqualTo(String value) {
            addCriterion("`district_name` <=", value, "district_name");
            return (Criteria) this;
        }

        public Criteria andDistrict_nameLike(String value) {
            addCriterion("`district_name` like", value, "district_name");
            return (Criteria) this;
        }

        public Criteria andDistrict_nameNotLike(String value) {
            addCriterion("`district_name` not like", value, "district_name");
            return (Criteria) this;
        }

        public Criteria andDistrict_nameIn(List<String> values) {
            addCriterion("`district_name` in", values, "district_name");
            return (Criteria) this;
        }

        public Criteria andDistrict_nameNotIn(List<String> values) {
            addCriterion("`district_name` not in", values, "district_name");
            return (Criteria) this;
        }

        public Criteria andDistrict_nameBetween(String value1, String value2) {
            addCriterion("`district_name` between", value1, value2, "district_name");
            return (Criteria) this;
        }

        public Criteria andDistrict_nameNotBetween(String value1, String value2) {
            addCriterion("`district_name` not between", value1, value2, "district_name");
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

        public Criteria andSelected_phone_numIsNull() {
            addCriterion("`selected_phone_num` is null");
            return (Criteria) this;
        }

        public Criteria andSelected_phone_numIsNotNull() {
            addCriterion("`selected_phone_num` is not null");
            return (Criteria) this;
        }

        public Criteria andSelected_phone_numEqualTo(String value) {
            addCriterion("`selected_phone_num` =", value, "selected_phone_num");
            return (Criteria) this;
        }

        public Criteria andSelected_phone_numNotEqualTo(String value) {
            addCriterion("`selected_phone_num` <>", value, "selected_phone_num");
            return (Criteria) this;
        }

        public Criteria andSelected_phone_numGreaterThan(String value) {
            addCriterion("`selected_phone_num` >", value, "selected_phone_num");
            return (Criteria) this;
        }

        public Criteria andSelected_phone_numGreaterThanOrEqualTo(String value) {
            addCriterion("`selected_phone_num` >=", value, "selected_phone_num");
            return (Criteria) this;
        }

        public Criteria andSelected_phone_numLessThan(String value) {
            addCriterion("`selected_phone_num` <", value, "selected_phone_num");
            return (Criteria) this;
        }

        public Criteria andSelected_phone_numLessThanOrEqualTo(String value) {
            addCriterion("`selected_phone_num` <=", value, "selected_phone_num");
            return (Criteria) this;
        }

        public Criteria andSelected_phone_numLike(String value) {
            addCriterion("`selected_phone_num` like", value, "selected_phone_num");
            return (Criteria) this;
        }

        public Criteria andSelected_phone_numNotLike(String value) {
            addCriterion("`selected_phone_num` not like", value, "selected_phone_num");
            return (Criteria) this;
        }

        public Criteria andSelected_phone_numIn(List<String> values) {
            addCriterion("`selected_phone_num` in", values, "selected_phone_num");
            return (Criteria) this;
        }

        public Criteria andSelected_phone_numNotIn(List<String> values) {
            addCriterion("`selected_phone_num` not in", values, "selected_phone_num");
            return (Criteria) this;
        }

        public Criteria andSelected_phone_numBetween(String value1, String value2) {
            addCriterion("`selected_phone_num` between", value1, value2, "selected_phone_num");
            return (Criteria) this;
        }

        public Criteria andSelected_phone_numNotBetween(String value1, String value2) {
            addCriterion("`selected_phone_num` not between", value1, value2, "selected_phone_num");
            return (Criteria) this;
        }

        public Criteria andFreezeIsNull() {
            addCriterion("`freeze` is null");
            return (Criteria) this;
        }

        public Criteria andFreezeIsNotNull() {
            addCriterion("`freeze` is not null");
            return (Criteria) this;
        }

        public Criteria andFreezeEqualTo(String value) {
            addCriterion("`freeze` =", value, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreezeNotEqualTo(String value) {
            addCriterion("`freeze` <>", value, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreezeGreaterThan(String value) {
            addCriterion("`freeze` >", value, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreezeGreaterThanOrEqualTo(String value) {
            addCriterion("`freeze` >=", value, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreezeLessThan(String value) {
            addCriterion("`freeze` <", value, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreezeLessThanOrEqualTo(String value) {
            addCriterion("`freeze` <=", value, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreezeLike(String value) {
            addCriterion("`freeze` like", value, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreezeNotLike(String value) {
            addCriterion("`freeze` not like", value, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreezeIn(List<String> values) {
            addCriterion("`freeze` in", values, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreezeNotIn(List<String> values) {
            addCriterion("`freeze` not in", values, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreezeBetween(String value1, String value2) {
            addCriterion("`freeze` between", value1, value2, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreezeNotBetween(String value1, String value2) {
            addCriterion("`freeze` not between", value1, value2, "freeze");
            return (Criteria) this;
        }

        public Criteria andFreeze_amountIsNull() {
            addCriterion("`freeze_amount` is null");
            return (Criteria) this;
        }

        public Criteria andFreeze_amountIsNotNull() {
            addCriterion("`freeze_amount` is not null");
            return (Criteria) this;
        }

        public Criteria andFreeze_amountEqualTo(String value) {
            addCriterion("`freeze_amount` =", value, "freeze_amount");
            return (Criteria) this;
        }

        public Criteria andFreeze_amountNotEqualTo(String value) {
            addCriterion("`freeze_amount` <>", value, "freeze_amount");
            return (Criteria) this;
        }

        public Criteria andFreeze_amountGreaterThan(String value) {
            addCriterion("`freeze_amount` >", value, "freeze_amount");
            return (Criteria) this;
        }

        public Criteria andFreeze_amountGreaterThanOrEqualTo(String value) {
            addCriterion("`freeze_amount` >=", value, "freeze_amount");
            return (Criteria) this;
        }

        public Criteria andFreeze_amountLessThan(String value) {
            addCriterion("`freeze_amount` <", value, "freeze_amount");
            return (Criteria) this;
        }

        public Criteria andFreeze_amountLessThanOrEqualTo(String value) {
            addCriterion("`freeze_amount` <=", value, "freeze_amount");
            return (Criteria) this;
        }

        public Criteria andFreeze_amountLike(String value) {
            addCriterion("`freeze_amount` like", value, "freeze_amount");
            return (Criteria) this;
        }

        public Criteria andFreeze_amountNotLike(String value) {
            addCriterion("`freeze_amount` not like", value, "freeze_amount");
            return (Criteria) this;
        }

        public Criteria andFreeze_amountIn(List<String> values) {
            addCriterion("`freeze_amount` in", values, "freeze_amount");
            return (Criteria) this;
        }

        public Criteria andFreeze_amountNotIn(List<String> values) {
            addCriterion("`freeze_amount` not in", values, "freeze_amount");
            return (Criteria) this;
        }

        public Criteria andFreeze_amountBetween(String value1, String value2) {
            addCriterion("`freeze_amount` between", value1, value2, "freeze_amount");
            return (Criteria) this;
        }

        public Criteria andFreeze_amountNotBetween(String value1, String value2) {
            addCriterion("`freeze_amount` not between", value1, value2, "freeze_amount");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeIsNull() {
            addCriterion("`order_create_time` is null");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeIsNotNull() {
            addCriterion("`order_create_time` is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeEqualTo(String value) {
            addCriterion("`order_create_time` =", value, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeNotEqualTo(String value) {
            addCriterion("`order_create_time` <>", value, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeGreaterThan(String value) {
            addCriterion("`order_create_time` >", value, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeGreaterThanOrEqualTo(String value) {
            addCriterion("`order_create_time` >=", value, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeLessThan(String value) {
            addCriterion("`order_create_time` <", value, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeLessThanOrEqualTo(String value) {
            addCriterion("`order_create_time` <=", value, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeLike(String value) {
            addCriterion("`order_create_time` like", value, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeNotLike(String value) {
            addCriterion("`order_create_time` not like", value, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeIn(List<String> values) {
            addCriterion("`order_create_time` in", values, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeNotIn(List<String> values) {
            addCriterion("`order_create_time` not in", values, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeBetween(String value1, String value2) {
            addCriterion("`order_create_time` between", value1, value2, "order_create_time");
            return (Criteria) this;
        }

        public Criteria andOrder_create_timeNotBetween(String value1, String value2) {
            addCriterion("`order_create_time` not between", value1, value2, "order_create_time");
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
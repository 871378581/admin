package com.segama.ege.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CapitalAccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public CapitalAccountExample() {
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

        public Criteria andAccount_noIsNull() {
            addCriterion("`account_no` is null");
            return (Criteria) this;
        }

        public Criteria andAccount_noIsNotNull() {
            addCriterion("`account_no` is not null");
            return (Criteria) this;
        }

        public Criteria andAccount_noEqualTo(String value) {
            addCriterion("`account_no` =", value, "account_no");
            return (Criteria) this;
        }

        public Criteria andAccount_noNotEqualTo(String value) {
            addCriterion("`account_no` <>", value, "account_no");
            return (Criteria) this;
        }

        public Criteria andAccount_noGreaterThan(String value) {
            addCriterion("`account_no` >", value, "account_no");
            return (Criteria) this;
        }

        public Criteria andAccount_noGreaterThanOrEqualTo(String value) {
            addCriterion("`account_no` >=", value, "account_no");
            return (Criteria) this;
        }

        public Criteria andAccount_noLessThan(String value) {
            addCriterion("`account_no` <", value, "account_no");
            return (Criteria) this;
        }

        public Criteria andAccount_noLessThanOrEqualTo(String value) {
            addCriterion("`account_no` <=", value, "account_no");
            return (Criteria) this;
        }

        public Criteria andAccount_noLike(String value) {
            addCriterion("`account_no` like", value, "account_no");
            return (Criteria) this;
        }

        public Criteria andAccount_noNotLike(String value) {
            addCriterion("`account_no` not like", value, "account_no");
            return (Criteria) this;
        }

        public Criteria andAccount_noIn(List<String> values) {
            addCriterion("`account_no` in", values, "account_no");
            return (Criteria) this;
        }

        public Criteria andAccount_noNotIn(List<String> values) {
            addCriterion("`account_no` not in", values, "account_no");
            return (Criteria) this;
        }

        public Criteria andAccount_noBetween(String value1, String value2) {
            addCriterion("`account_no` between", value1, value2, "account_no");
            return (Criteria) this;
        }

        public Criteria andAccount_noNotBetween(String value1, String value2) {
            addCriterion("`account_no` not between", value1, value2, "account_no");
            return (Criteria) this;
        }

        public Criteria andAccount_typeIsNull() {
            addCriterion("`account_type` is null");
            return (Criteria) this;
        }

        public Criteria andAccount_typeIsNotNull() {
            addCriterion("`account_type` is not null");
            return (Criteria) this;
        }

        public Criteria andAccount_typeEqualTo(String value) {
            addCriterion("`account_type` =", value, "account_type");
            return (Criteria) this;
        }

        public Criteria andAccount_typeNotEqualTo(String value) {
            addCriterion("`account_type` <>", value, "account_type");
            return (Criteria) this;
        }

        public Criteria andAccount_typeGreaterThan(String value) {
            addCriterion("`account_type` >", value, "account_type");
            return (Criteria) this;
        }

        public Criteria andAccount_typeGreaterThanOrEqualTo(String value) {
            addCriterion("`account_type` >=", value, "account_type");
            return (Criteria) this;
        }

        public Criteria andAccount_typeLessThan(String value) {
            addCriterion("`account_type` <", value, "account_type");
            return (Criteria) this;
        }

        public Criteria andAccount_typeLessThanOrEqualTo(String value) {
            addCriterion("`account_type` <=", value, "account_type");
            return (Criteria) this;
        }

        public Criteria andAccount_typeLike(String value) {
            addCriterion("`account_type` like", value, "account_type");
            return (Criteria) this;
        }

        public Criteria andAccount_typeNotLike(String value) {
            addCriterion("`account_type` not like", value, "account_type");
            return (Criteria) this;
        }

        public Criteria andAccount_typeIn(List<String> values) {
            addCriterion("`account_type` in", values, "account_type");
            return (Criteria) this;
        }

        public Criteria andAccount_typeNotIn(List<String> values) {
            addCriterion("`account_type` not in", values, "account_type");
            return (Criteria) this;
        }

        public Criteria andAccount_typeBetween(String value1, String value2) {
            addCriterion("`account_type` between", value1, value2, "account_type");
            return (Criteria) this;
        }

        public Criteria andAccount_typeNotBetween(String value1, String value2) {
            addCriterion("`account_type` not between", value1, value2, "account_type");
            return (Criteria) this;
        }

        public Criteria andTotal_amountIsNull() {
            addCriterion("`total_amount` is null");
            return (Criteria) this;
        }

        public Criteria andTotal_amountIsNotNull() {
            addCriterion("`total_amount` is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_amountEqualTo(String value) {
            addCriterion("`total_amount` =", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountNotEqualTo(String value) {
            addCriterion("`total_amount` <>", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountGreaterThan(String value) {
            addCriterion("`total_amount` >", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountGreaterThanOrEqualTo(String value) {
            addCriterion("`total_amount` >=", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountLessThan(String value) {
            addCriterion("`total_amount` <", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountLessThanOrEqualTo(String value) {
            addCriterion("`total_amount` <=", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountLike(String value) {
            addCriterion("`total_amount` like", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountNotLike(String value) {
            addCriterion("`total_amount` not like", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountIn(List<String> values) {
            addCriterion("`total_amount` in", values, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountNotIn(List<String> values) {
            addCriterion("`total_amount` not in", values, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountBetween(String value1, String value2) {
            addCriterion("`total_amount` between", value1, value2, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountNotBetween(String value1, String value2) {
            addCriterion("`total_amount` not between", value1, value2, "total_amount");
            return (Criteria) this;
        }

        public Criteria andFreezing_amountIsNull() {
            addCriterion("`freezing_amount` is null");
            return (Criteria) this;
        }

        public Criteria andFreezing_amountIsNotNull() {
            addCriterion("`freezing_amount` is not null");
            return (Criteria) this;
        }

        public Criteria andFreezing_amountEqualTo(String value) {
            addCriterion("`freezing_amount` =", value, "freezing_amount");
            return (Criteria) this;
        }

        public Criteria andFreezing_amountNotEqualTo(String value) {
            addCriterion("`freezing_amount` <>", value, "freezing_amount");
            return (Criteria) this;
        }

        public Criteria andFreezing_amountGreaterThan(String value) {
            addCriterion("`freezing_amount` >", value, "freezing_amount");
            return (Criteria) this;
        }

        public Criteria andFreezing_amountGreaterThanOrEqualTo(String value) {
            addCriterion("`freezing_amount` >=", value, "freezing_amount");
            return (Criteria) this;
        }

        public Criteria andFreezing_amountLessThan(String value) {
            addCriterion("`freezing_amount` <", value, "freezing_amount");
            return (Criteria) this;
        }

        public Criteria andFreezing_amountLessThanOrEqualTo(String value) {
            addCriterion("`freezing_amount` <=", value, "freezing_amount");
            return (Criteria) this;
        }

        public Criteria andFreezing_amountLike(String value) {
            addCriterion("`freezing_amount` like", value, "freezing_amount");
            return (Criteria) this;
        }

        public Criteria andFreezing_amountNotLike(String value) {
            addCriterion("`freezing_amount` not like", value, "freezing_amount");
            return (Criteria) this;
        }

        public Criteria andFreezing_amountIn(List<String> values) {
            addCriterion("`freezing_amount` in", values, "freezing_amount");
            return (Criteria) this;
        }

        public Criteria andFreezing_amountNotIn(List<String> values) {
            addCriterion("`freezing_amount` not in", values, "freezing_amount");
            return (Criteria) this;
        }

        public Criteria andFreezing_amountBetween(String value1, String value2) {
            addCriterion("`freezing_amount` between", value1, value2, "freezing_amount");
            return (Criteria) this;
        }

        public Criteria andFreezing_amountNotBetween(String value1, String value2) {
            addCriterion("`freezing_amount` not between", value1, value2, "freezing_amount");
            return (Criteria) this;
        }

        public Criteria andAvailable_amountIsNull() {
            addCriterion("`available_amount` is null");
            return (Criteria) this;
        }

        public Criteria andAvailable_amountIsNotNull() {
            addCriterion("`available_amount` is not null");
            return (Criteria) this;
        }

        public Criteria andAvailable_amountEqualTo(String value) {
            addCriterion("`available_amount` =", value, "available_amount");
            return (Criteria) this;
        }

        public Criteria andAvailable_amountNotEqualTo(String value) {
            addCriterion("`available_amount` <>", value, "available_amount");
            return (Criteria) this;
        }

        public Criteria andAvailable_amountGreaterThan(String value) {
            addCriterion("`available_amount` >", value, "available_amount");
            return (Criteria) this;
        }

        public Criteria andAvailable_amountGreaterThanOrEqualTo(String value) {
            addCriterion("`available_amount` >=", value, "available_amount");
            return (Criteria) this;
        }

        public Criteria andAvailable_amountLessThan(String value) {
            addCriterion("`available_amount` <", value, "available_amount");
            return (Criteria) this;
        }

        public Criteria andAvailable_amountLessThanOrEqualTo(String value) {
            addCriterion("`available_amount` <=", value, "available_amount");
            return (Criteria) this;
        }

        public Criteria andAvailable_amountLike(String value) {
            addCriterion("`available_amount` like", value, "available_amount");
            return (Criteria) this;
        }

        public Criteria andAvailable_amountNotLike(String value) {
            addCriterion("`available_amount` not like", value, "available_amount");
            return (Criteria) this;
        }

        public Criteria andAvailable_amountIn(List<String> values) {
            addCriterion("`available_amount` in", values, "available_amount");
            return (Criteria) this;
        }

        public Criteria andAvailable_amountNotIn(List<String> values) {
            addCriterion("`available_amount` not in", values, "available_amount");
            return (Criteria) this;
        }

        public Criteria andAvailable_amountBetween(String value1, String value2) {
            addCriterion("`available_amount` between", value1, value2, "available_amount");
            return (Criteria) this;
        }

        public Criteria andAvailable_amountNotBetween(String value1, String value2) {
            addCriterion("`available_amount` not between", value1, value2, "available_amount");
            return (Criteria) this;
        }

        public Criteria andMacIsNull() {
            addCriterion("`mac` is null");
            return (Criteria) this;
        }

        public Criteria andMacIsNotNull() {
            addCriterion("`mac` is not null");
            return (Criteria) this;
        }

        public Criteria andMacEqualTo(String value) {
            addCriterion("`mac` =", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotEqualTo(String value) {
            addCriterion("`mac` <>", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacGreaterThan(String value) {
            addCriterion("`mac` >", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacGreaterThanOrEqualTo(String value) {
            addCriterion("`mac` >=", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLessThan(String value) {
            addCriterion("`mac` <", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLessThanOrEqualTo(String value) {
            addCriterion("`mac` <=", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacLike(String value) {
            addCriterion("`mac` like", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotLike(String value) {
            addCriterion("`mac` not like", value, "mac");
            return (Criteria) this;
        }

        public Criteria andMacIn(List<String> values) {
            addCriterion("`mac` in", values, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotIn(List<String> values) {
            addCriterion("`mac` not in", values, "mac");
            return (Criteria) this;
        }

        public Criteria andMacBetween(String value1, String value2) {
            addCriterion("`mac` between", value1, value2, "mac");
            return (Criteria) this;
        }

        public Criteria andMacNotBetween(String value1, String value2) {
            addCriterion("`mac` not between", value1, value2, "mac");
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

        public Criteria andOpening_bankIsNull() {
            addCriterion("`opening_bank` is null");
            return (Criteria) this;
        }

        public Criteria andOpening_bankIsNotNull() {
            addCriterion("`opening_bank` is not null");
            return (Criteria) this;
        }

        public Criteria andOpening_bankEqualTo(String value) {
            addCriterion("`opening_bank` =", value, "opening_bank");
            return (Criteria) this;
        }

        public Criteria andOpening_bankNotEqualTo(String value) {
            addCriterion("`opening_bank` <>", value, "opening_bank");
            return (Criteria) this;
        }

        public Criteria andOpening_bankGreaterThan(String value) {
            addCriterion("`opening_bank` >", value, "opening_bank");
            return (Criteria) this;
        }

        public Criteria andOpening_bankGreaterThanOrEqualTo(String value) {
            addCriterion("`opening_bank` >=", value, "opening_bank");
            return (Criteria) this;
        }

        public Criteria andOpening_bankLessThan(String value) {
            addCriterion("`opening_bank` <", value, "opening_bank");
            return (Criteria) this;
        }

        public Criteria andOpening_bankLessThanOrEqualTo(String value) {
            addCriterion("`opening_bank` <=", value, "opening_bank");
            return (Criteria) this;
        }

        public Criteria andOpening_bankLike(String value) {
            addCriterion("`opening_bank` like", value, "opening_bank");
            return (Criteria) this;
        }

        public Criteria andOpening_bankNotLike(String value) {
            addCriterion("`opening_bank` not like", value, "opening_bank");
            return (Criteria) this;
        }

        public Criteria andOpening_bankIn(List<String> values) {
            addCriterion("`opening_bank` in", values, "opening_bank");
            return (Criteria) this;
        }

        public Criteria andOpening_bankNotIn(List<String> values) {
            addCriterion("`opening_bank` not in", values, "opening_bank");
            return (Criteria) this;
        }

        public Criteria andOpening_bankBetween(String value1, String value2) {
            addCriterion("`opening_bank` between", value1, value2, "opening_bank");
            return (Criteria) this;
        }

        public Criteria andOpening_bankNotBetween(String value1, String value2) {
            addCriterion("`opening_bank` not between", value1, value2, "opening_bank");
            return (Criteria) this;
        }

        public Criteria andBank_card_numIsNull() {
            addCriterion("`bank_card_num` is null");
            return (Criteria) this;
        }

        public Criteria andBank_card_numIsNotNull() {
            addCriterion("`bank_card_num` is not null");
            return (Criteria) this;
        }

        public Criteria andBank_card_numEqualTo(String value) {
            addCriterion("`bank_card_num` =", value, "bank_card_num");
            return (Criteria) this;
        }

        public Criteria andBank_card_numNotEqualTo(String value) {
            addCriterion("`bank_card_num` <>", value, "bank_card_num");
            return (Criteria) this;
        }

        public Criteria andBank_card_numGreaterThan(String value) {
            addCriterion("`bank_card_num` >", value, "bank_card_num");
            return (Criteria) this;
        }

        public Criteria andBank_card_numGreaterThanOrEqualTo(String value) {
            addCriterion("`bank_card_num` >=", value, "bank_card_num");
            return (Criteria) this;
        }

        public Criteria andBank_card_numLessThan(String value) {
            addCriterion("`bank_card_num` <", value, "bank_card_num");
            return (Criteria) this;
        }

        public Criteria andBank_card_numLessThanOrEqualTo(String value) {
            addCriterion("`bank_card_num` <=", value, "bank_card_num");
            return (Criteria) this;
        }

        public Criteria andBank_card_numLike(String value) {
            addCriterion("`bank_card_num` like", value, "bank_card_num");
            return (Criteria) this;
        }

        public Criteria andBank_card_numNotLike(String value) {
            addCriterion("`bank_card_num` not like", value, "bank_card_num");
            return (Criteria) this;
        }

        public Criteria andBank_card_numIn(List<String> values) {
            addCriterion("`bank_card_num` in", values, "bank_card_num");
            return (Criteria) this;
        }

        public Criteria andBank_card_numNotIn(List<String> values) {
            addCriterion("`bank_card_num` not in", values, "bank_card_num");
            return (Criteria) this;
        }

        public Criteria andBank_card_numBetween(String value1, String value2) {
            addCriterion("`bank_card_num` between", value1, value2, "bank_card_num");
            return (Criteria) this;
        }

        public Criteria andBank_card_numNotBetween(String value1, String value2) {
            addCriterion("`bank_card_num` not between", value1, value2, "bank_card_num");
            return (Criteria) this;
        }

        public Criteria andPayeeIsNull() {
            addCriterion("`payee` is null");
            return (Criteria) this;
        }

        public Criteria andPayeeIsNotNull() {
            addCriterion("`payee` is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeEqualTo(String value) {
            addCriterion("`payee` =", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeNotEqualTo(String value) {
            addCriterion("`payee` <>", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeGreaterThan(String value) {
            addCriterion("`payee` >", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeGreaterThanOrEqualTo(String value) {
            addCriterion("`payee` >=", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeLessThan(String value) {
            addCriterion("`payee` <", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeLessThanOrEqualTo(String value) {
            addCriterion("`payee` <=", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeLike(String value) {
            addCriterion("`payee` like", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeNotLike(String value) {
            addCriterion("`payee` not like", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeIn(List<String> values) {
            addCriterion("`payee` in", values, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeNotIn(List<String> values) {
            addCriterion("`payee` not in", values, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeBetween(String value1, String value2) {
            addCriterion("`payee` between", value1, value2, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeNotBetween(String value1, String value2) {
            addCriterion("`payee` not between", value1, value2, "payee");
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
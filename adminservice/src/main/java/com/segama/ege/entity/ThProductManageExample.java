package com.segama.ege.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThProductManageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public ThProductManageExample() {
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

        public Criteria andBusiness_nameIsNull() {
            addCriterion("`business_name` is null");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameIsNotNull() {
            addCriterion("`business_name` is not null");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameEqualTo(String value) {
            addCriterion("`business_name` =", value, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameNotEqualTo(String value) {
            addCriterion("`business_name` <>", value, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameGreaterThan(String value) {
            addCriterion("`business_name` >", value, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`business_name` >=", value, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameLessThan(String value) {
            addCriterion("`business_name` <", value, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameLessThanOrEqualTo(String value) {
            addCriterion("`business_name` <=", value, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameLike(String value) {
            addCriterion("`business_name` like", value, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameNotLike(String value) {
            addCriterion("`business_name` not like", value, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameIn(List<String> values) {
            addCriterion("`business_name` in", values, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameNotIn(List<String> values) {
            addCriterion("`business_name` not in", values, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameBetween(String value1, String value2) {
            addCriterion("`business_name` between", value1, value2, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameNotBetween(String value1, String value2) {
            addCriterion("`business_name` not between", value1, value2, "business_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameIsNull() {
            addCriterion("`product_name` is null");
            return (Criteria) this;
        }

        public Criteria andProduct_nameIsNotNull() {
            addCriterion("`product_name` is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_nameEqualTo(String value) {
            addCriterion("`product_name` =", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameNotEqualTo(String value) {
            addCriterion("`product_name` <>", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameGreaterThan(String value) {
            addCriterion("`product_name` >", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`product_name` >=", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameLessThan(String value) {
            addCriterion("`product_name` <", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameLessThanOrEqualTo(String value) {
            addCriterion("`product_name` <=", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameLike(String value) {
            addCriterion("`product_name` like", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameNotLike(String value) {
            addCriterion("`product_name` not like", value, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameIn(List<String> values) {
            addCriterion("`product_name` in", values, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameNotIn(List<String> values) {
            addCriterion("`product_name` not in", values, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameBetween(String value1, String value2) {
            addCriterion("`product_name` between", value1, value2, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_nameNotBetween(String value1, String value2) {
            addCriterion("`product_name` not between", value1, value2, "product_name");
            return (Criteria) this;
        }

        public Criteria andProduct_codeIsNull() {
            addCriterion("`product_code` is null");
            return (Criteria) this;
        }

        public Criteria andProduct_codeIsNotNull() {
            addCriterion("`product_code` is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_codeEqualTo(String value) {
            addCriterion("`product_code` =", value, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeNotEqualTo(String value) {
            addCriterion("`product_code` <>", value, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeGreaterThan(String value) {
            addCriterion("`product_code` >", value, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeGreaterThanOrEqualTo(String value) {
            addCriterion("`product_code` >=", value, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeLessThan(String value) {
            addCriterion("`product_code` <", value, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeLessThanOrEqualTo(String value) {
            addCriterion("`product_code` <=", value, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeLike(String value) {
            addCriterion("`product_code` like", value, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeNotLike(String value) {
            addCriterion("`product_code` not like", value, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeIn(List<String> values) {
            addCriterion("`product_code` in", values, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeNotIn(List<String> values) {
            addCriterion("`product_code` not in", values, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeBetween(String value1, String value2) {
            addCriterion("`product_code` between", value1, value2, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeNotBetween(String value1, String value2) {
            addCriterion("`product_code` not between", value1, value2, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_typeIsNull() {
            addCriterion("`product_type` is null");
            return (Criteria) this;
        }

        public Criteria andProduct_typeIsNotNull() {
            addCriterion("`product_type` is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_typeEqualTo(String value) {
            addCriterion("`product_type` =", value, "product_type");
            return (Criteria) this;
        }

        public Criteria andProduct_typeNotEqualTo(String value) {
            addCriterion("`product_type` <>", value, "product_type");
            return (Criteria) this;
        }

        public Criteria andProduct_typeGreaterThan(String value) {
            addCriterion("`product_type` >", value, "product_type");
            return (Criteria) this;
        }

        public Criteria andProduct_typeGreaterThanOrEqualTo(String value) {
            addCriterion("`product_type` >=", value, "product_type");
            return (Criteria) this;
        }

        public Criteria andProduct_typeLessThan(String value) {
            addCriterion("`product_type` <", value, "product_type");
            return (Criteria) this;
        }

        public Criteria andProduct_typeLessThanOrEqualTo(String value) {
            addCriterion("`product_type` <=", value, "product_type");
            return (Criteria) this;
        }

        public Criteria andProduct_typeLike(String value) {
            addCriterion("`product_type` like", value, "product_type");
            return (Criteria) this;
        }

        public Criteria andProduct_typeNotLike(String value) {
            addCriterion("`product_type` not like", value, "product_type");
            return (Criteria) this;
        }

        public Criteria andProduct_typeIn(List<String> values) {
            addCriterion("`product_type` in", values, "product_type");
            return (Criteria) this;
        }

        public Criteria andProduct_typeNotIn(List<String> values) {
            addCriterion("`product_type` not in", values, "product_type");
            return (Criteria) this;
        }

        public Criteria andProduct_typeBetween(String value1, String value2) {
            addCriterion("`product_type` between", value1, value2, "product_type");
            return (Criteria) this;
        }

        public Criteria andProduct_typeNotBetween(String value1, String value2) {
            addCriterion("`product_type` not between", value1, value2, "product_type");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("`url` is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("`url` is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("`url` =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("`url` <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("`url` >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("`url` >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("`url` <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("`url` <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("`url` like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("`url` not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("`url` in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("`url` not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("`url` between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("`url` not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andProduct_statusIsNull() {
            addCriterion("`product_status` is null");
            return (Criteria) this;
        }

        public Criteria andProduct_statusIsNotNull() {
            addCriterion("`product_status` is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_statusEqualTo(Integer value) {
            addCriterion("`product_status` =", value, "product_status");
            return (Criteria) this;
        }

        public Criteria andProduct_statusNotEqualTo(Integer value) {
            addCriterion("`product_status` <>", value, "product_status");
            return (Criteria) this;
        }

        public Criteria andProduct_statusGreaterThan(Integer value) {
            addCriterion("`product_status` >", value, "product_status");
            return (Criteria) this;
        }

        public Criteria andProduct_statusGreaterThanOrEqualTo(Integer value) {
            addCriterion("`product_status` >=", value, "product_status");
            return (Criteria) this;
        }

        public Criteria andProduct_statusLessThan(Integer value) {
            addCriterion("`product_status` <", value, "product_status");
            return (Criteria) this;
        }

        public Criteria andProduct_statusLessThanOrEqualTo(Integer value) {
            addCriterion("`product_status` <=", value, "product_status");
            return (Criteria) this;
        }

        public Criteria andProduct_statusIn(List<Integer> values) {
            addCriterion("`product_status` in", values, "product_status");
            return (Criteria) this;
        }

        public Criteria andProduct_statusNotIn(List<Integer> values) {
            addCriterion("`product_status` not in", values, "product_status");
            return (Criteria) this;
        }

        public Criteria andProduct_statusBetween(Integer value1, Integer value2) {
            addCriterion("`product_status` between", value1, value2, "product_status");
            return (Criteria) this;
        }

        public Criteria andProduct_statusNotBetween(Integer value1, Integer value2) {
            addCriterion("`product_status` not between", value1, value2, "product_status");
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

        public Criteria andSource_urlIsNull() {
            addCriterion("`source_url` is null");
            return (Criteria) this;
        }

        public Criteria andSource_urlIsNotNull() {
            addCriterion("`source_url` is not null");
            return (Criteria) this;
        }

        public Criteria andSource_urlEqualTo(String value) {
            addCriterion("`source_url` =", value, "source_url");
            return (Criteria) this;
        }

        public Criteria andSource_urlNotEqualTo(String value) {
            addCriterion("`source_url` <>", value, "source_url");
            return (Criteria) this;
        }

        public Criteria andSource_urlGreaterThan(String value) {
            addCriterion("`source_url` >", value, "source_url");
            return (Criteria) this;
        }

        public Criteria andSource_urlGreaterThanOrEqualTo(String value) {
            addCriterion("`source_url` >=", value, "source_url");
            return (Criteria) this;
        }

        public Criteria andSource_urlLessThan(String value) {
            addCriterion("`source_url` <", value, "source_url");
            return (Criteria) this;
        }

        public Criteria andSource_urlLessThanOrEqualTo(String value) {
            addCriterion("`source_url` <=", value, "source_url");
            return (Criteria) this;
        }

        public Criteria andSource_urlLike(String value) {
            addCriterion("`source_url` like", value, "source_url");
            return (Criteria) this;
        }

        public Criteria andSource_urlNotLike(String value) {
            addCriterion("`source_url` not like", value, "source_url");
            return (Criteria) this;
        }

        public Criteria andSource_urlIn(List<String> values) {
            addCriterion("`source_url` in", values, "source_url");
            return (Criteria) this;
        }

        public Criteria andSource_urlNotIn(List<String> values) {
            addCriterion("`source_url` not in", values, "source_url");
            return (Criteria) this;
        }

        public Criteria andSource_urlBetween(String value1, String value2) {
            addCriterion("`source_url` between", value1, value2, "source_url");
            return (Criteria) this;
        }

        public Criteria andSource_urlNotBetween(String value1, String value2) {
            addCriterion("`source_url` not between", value1, value2, "source_url");
            return (Criteria) this;
        }

        public Criteria andBusiness_codeIsNull() {
            addCriterion("`business_code` is null");
            return (Criteria) this;
        }

        public Criteria andBusiness_codeIsNotNull() {
            addCriterion("`business_code` is not null");
            return (Criteria) this;
        }

        public Criteria andBusiness_codeEqualTo(String value) {
            addCriterion("`business_code` =", value, "business_code");
            return (Criteria) this;
        }

        public Criteria andBusiness_codeNotEqualTo(String value) {
            addCriterion("`business_code` <>", value, "business_code");
            return (Criteria) this;
        }

        public Criteria andBusiness_codeGreaterThan(String value) {
            addCriterion("`business_code` >", value, "business_code");
            return (Criteria) this;
        }

        public Criteria andBusiness_codeGreaterThanOrEqualTo(String value) {
            addCriterion("`business_code` >=", value, "business_code");
            return (Criteria) this;
        }

        public Criteria andBusiness_codeLessThan(String value) {
            addCriterion("`business_code` <", value, "business_code");
            return (Criteria) this;
        }

        public Criteria andBusiness_codeLessThanOrEqualTo(String value) {
            addCriterion("`business_code` <=", value, "business_code");
            return (Criteria) this;
        }

        public Criteria andBusiness_codeLike(String value) {
            addCriterion("`business_code` like", value, "business_code");
            return (Criteria) this;
        }

        public Criteria andBusiness_codeNotLike(String value) {
            addCriterion("`business_code` not like", value, "business_code");
            return (Criteria) this;
        }

        public Criteria andBusiness_codeIn(List<String> values) {
            addCriterion("`business_code` in", values, "business_code");
            return (Criteria) this;
        }

        public Criteria andBusiness_codeNotIn(List<String> values) {
            addCriterion("`business_code` not in", values, "business_code");
            return (Criteria) this;
        }

        public Criteria andBusiness_codeBetween(String value1, String value2) {
            addCriterion("`business_code` between", value1, value2, "business_code");
            return (Criteria) this;
        }

        public Criteria andBusiness_codeNotBetween(String value1, String value2) {
            addCriterion("`business_code` not between", value1, value2, "business_code");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("`type` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("`type` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("`type` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("`type` like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("`type` not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("`type` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("`type` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("`type` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("`type` not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andShifou_2_kaifaIsNull() {
            addCriterion("`shifou_2_kaifa` is null");
            return (Criteria) this;
        }

        public Criteria andShifou_2_kaifaIsNotNull() {
            addCriterion("`shifou_2_kaifa` is not null");
            return (Criteria) this;
        }

        public Criteria andShifou_2_kaifaEqualTo(String value) {
            addCriterion("`shifou_2_kaifa` =", value, "shifou_2_kaifa");
            return (Criteria) this;
        }

        public Criteria andShifou_2_kaifaNotEqualTo(String value) {
            addCriterion("`shifou_2_kaifa` <>", value, "shifou_2_kaifa");
            return (Criteria) this;
        }

        public Criteria andShifou_2_kaifaGreaterThan(String value) {
            addCriterion("`shifou_2_kaifa` >", value, "shifou_2_kaifa");
            return (Criteria) this;
        }

        public Criteria andShifou_2_kaifaGreaterThanOrEqualTo(String value) {
            addCriterion("`shifou_2_kaifa` >=", value, "shifou_2_kaifa");
            return (Criteria) this;
        }

        public Criteria andShifou_2_kaifaLessThan(String value) {
            addCriterion("`shifou_2_kaifa` <", value, "shifou_2_kaifa");
            return (Criteria) this;
        }

        public Criteria andShifou_2_kaifaLessThanOrEqualTo(String value) {
            addCriterion("`shifou_2_kaifa` <=", value, "shifou_2_kaifa");
            return (Criteria) this;
        }

        public Criteria andShifou_2_kaifaLike(String value) {
            addCriterion("`shifou_2_kaifa` like", value, "shifou_2_kaifa");
            return (Criteria) this;
        }

        public Criteria andShifou_2_kaifaNotLike(String value) {
            addCriterion("`shifou_2_kaifa` not like", value, "shifou_2_kaifa");
            return (Criteria) this;
        }

        public Criteria andShifou_2_kaifaIn(List<String> values) {
            addCriterion("`shifou_2_kaifa` in", values, "shifou_2_kaifa");
            return (Criteria) this;
        }

        public Criteria andShifou_2_kaifaNotIn(List<String> values) {
            addCriterion("`shifou_2_kaifa` not in", values, "shifou_2_kaifa");
            return (Criteria) this;
        }

        public Criteria andShifou_2_kaifaBetween(String value1, String value2) {
            addCriterion("`shifou_2_kaifa` between", value1, value2, "shifou_2_kaifa");
            return (Criteria) this;
        }

        public Criteria andShifou_2_kaifaNotBetween(String value1, String value2) {
            addCriterion("`shifou_2_kaifa` not between", value1, value2, "shifou_2_kaifa");
            return (Criteria) this;
        }

        public Criteria andSettle_modeIsNull() {
            addCriterion("`settle_mode` is null");
            return (Criteria) this;
        }

        public Criteria andSettle_modeIsNotNull() {
            addCriterion("`settle_mode` is not null");
            return (Criteria) this;
        }

        public Criteria andSettle_modeEqualTo(String value) {
            addCriterion("`settle_mode` =", value, "settle_mode");
            return (Criteria) this;
        }

        public Criteria andSettle_modeNotEqualTo(String value) {
            addCriterion("`settle_mode` <>", value, "settle_mode");
            return (Criteria) this;
        }

        public Criteria andSettle_modeGreaterThan(String value) {
            addCriterion("`settle_mode` >", value, "settle_mode");
            return (Criteria) this;
        }

        public Criteria andSettle_modeGreaterThanOrEqualTo(String value) {
            addCriterion("`settle_mode` >=", value, "settle_mode");
            return (Criteria) this;
        }

        public Criteria andSettle_modeLessThan(String value) {
            addCriterion("`settle_mode` <", value, "settle_mode");
            return (Criteria) this;
        }

        public Criteria andSettle_modeLessThanOrEqualTo(String value) {
            addCriterion("`settle_mode` <=", value, "settle_mode");
            return (Criteria) this;
        }

        public Criteria andSettle_modeLike(String value) {
            addCriterion("`settle_mode` like", value, "settle_mode");
            return (Criteria) this;
        }

        public Criteria andSettle_modeNotLike(String value) {
            addCriterion("`settle_mode` not like", value, "settle_mode");
            return (Criteria) this;
        }

        public Criteria andSettle_modeIn(List<String> values) {
            addCriterion("`settle_mode` in", values, "settle_mode");
            return (Criteria) this;
        }

        public Criteria andSettle_modeNotIn(List<String> values) {
            addCriterion("`settle_mode` not in", values, "settle_mode");
            return (Criteria) this;
        }

        public Criteria andSettle_modeBetween(String value1, String value2) {
            addCriterion("`settle_mode` between", value1, value2, "settle_mode");
            return (Criteria) this;
        }

        public Criteria andSettle_modeNotBetween(String value1, String value2) {
            addCriterion("`settle_mode` not between", value1, value2, "settle_mode");
            return (Criteria) this;
        }

        public Criteria andSettle_columnIsNull() {
            addCriterion("`settle_column` is null");
            return (Criteria) this;
        }

        public Criteria andSettle_columnIsNotNull() {
            addCriterion("`settle_column` is not null");
            return (Criteria) this;
        }

        public Criteria andSettle_columnEqualTo(String value) {
            addCriterion("`settle_column` =", value, "settle_column");
            return (Criteria) this;
        }

        public Criteria andSettle_columnNotEqualTo(String value) {
            addCriterion("`settle_column` <>", value, "settle_column");
            return (Criteria) this;
        }

        public Criteria andSettle_columnGreaterThan(String value) {
            addCriterion("`settle_column` >", value, "settle_column");
            return (Criteria) this;
        }

        public Criteria andSettle_columnGreaterThanOrEqualTo(String value) {
            addCriterion("`settle_column` >=", value, "settle_column");
            return (Criteria) this;
        }

        public Criteria andSettle_columnLessThan(String value) {
            addCriterion("`settle_column` <", value, "settle_column");
            return (Criteria) this;
        }

        public Criteria andSettle_columnLessThanOrEqualTo(String value) {
            addCriterion("`settle_column` <=", value, "settle_column");
            return (Criteria) this;
        }

        public Criteria andSettle_columnLike(String value) {
            addCriterion("`settle_column` like", value, "settle_column");
            return (Criteria) this;
        }

        public Criteria andSettle_columnNotLike(String value) {
            addCriterion("`settle_column` not like", value, "settle_column");
            return (Criteria) this;
        }

        public Criteria andSettle_columnIn(List<String> values) {
            addCriterion("`settle_column` in", values, "settle_column");
            return (Criteria) this;
        }

        public Criteria andSettle_columnNotIn(List<String> values) {
            addCriterion("`settle_column` not in", values, "settle_column");
            return (Criteria) this;
        }

        public Criteria andSettle_columnBetween(String value1, String value2) {
            addCriterion("`settle_column` between", value1, value2, "settle_column");
            return (Criteria) this;
        }

        public Criteria andSettle_columnNotBetween(String value1, String value2) {
            addCriterion("`settle_column` not between", value1, value2, "settle_column");
            return (Criteria) this;
        }

        public Criteria andSettle_valueIsNull() {
            addCriterion("`settle_value` is null");
            return (Criteria) this;
        }

        public Criteria andSettle_valueIsNotNull() {
            addCriterion("`settle_value` is not null");
            return (Criteria) this;
        }

        public Criteria andSettle_valueEqualTo(String value) {
            addCriterion("`settle_value` =", value, "settle_value");
            return (Criteria) this;
        }

        public Criteria andSettle_valueNotEqualTo(String value) {
            addCriterion("`settle_value` <>", value, "settle_value");
            return (Criteria) this;
        }

        public Criteria andSettle_valueGreaterThan(String value) {
            addCriterion("`settle_value` >", value, "settle_value");
            return (Criteria) this;
        }

        public Criteria andSettle_valueGreaterThanOrEqualTo(String value) {
            addCriterion("`settle_value` >=", value, "settle_value");
            return (Criteria) this;
        }

        public Criteria andSettle_valueLessThan(String value) {
            addCriterion("`settle_value` <", value, "settle_value");
            return (Criteria) this;
        }

        public Criteria andSettle_valueLessThanOrEqualTo(String value) {
            addCriterion("`settle_value` <=", value, "settle_value");
            return (Criteria) this;
        }

        public Criteria andSettle_valueLike(String value) {
            addCriterion("`settle_value` like", value, "settle_value");
            return (Criteria) this;
        }

        public Criteria andSettle_valueNotLike(String value) {
            addCriterion("`settle_value` not like", value, "settle_value");
            return (Criteria) this;
        }

        public Criteria andSettle_valueIn(List<String> values) {
            addCriterion("`settle_value` in", values, "settle_value");
            return (Criteria) this;
        }

        public Criteria andSettle_valueNotIn(List<String> values) {
            addCriterion("`settle_value` not in", values, "settle_value");
            return (Criteria) this;
        }

        public Criteria andSettle_valueBetween(String value1, String value2) {
            addCriterion("`settle_value` between", value1, value2, "settle_value");
            return (Criteria) this;
        }

        public Criteria andSettle_valueNotBetween(String value1, String value2) {
            addCriterion("`settle_value` not between", value1, value2, "settle_value");
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
package com.segama.ege.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThBusinessMerchantManageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public ThBusinessMerchantManageExample() {
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

        public Criteria andBusiness_short_nameIsNull() {
            addCriterion("`business_short_name` is null");
            return (Criteria) this;
        }

        public Criteria andBusiness_short_nameIsNotNull() {
            addCriterion("`business_short_name` is not null");
            return (Criteria) this;
        }

        public Criteria andBusiness_short_nameEqualTo(String value) {
            addCriterion("`business_short_name` =", value, "business_short_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_short_nameNotEqualTo(String value) {
            addCriterion("`business_short_name` <>", value, "business_short_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_short_nameGreaterThan(String value) {
            addCriterion("`business_short_name` >", value, "business_short_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_short_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`business_short_name` >=", value, "business_short_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_short_nameLessThan(String value) {
            addCriterion("`business_short_name` <", value, "business_short_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_short_nameLessThanOrEqualTo(String value) {
            addCriterion("`business_short_name` <=", value, "business_short_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_short_nameLike(String value) {
            addCriterion("`business_short_name` like", value, "business_short_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_short_nameNotLike(String value) {
            addCriterion("`business_short_name` not like", value, "business_short_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_short_nameIn(List<String> values) {
            addCriterion("`business_short_name` in", values, "business_short_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_short_nameNotIn(List<String> values) {
            addCriterion("`business_short_name` not in", values, "business_short_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_short_nameBetween(String value1, String value2) {
            addCriterion("`business_short_name` between", value1, value2, "business_short_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_short_nameNotBetween(String value1, String value2) {
            addCriterion("`business_short_name` not between", value1, value2, "business_short_name");
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

        public Criteria andContact_phoneIsNull() {
            addCriterion("`contact_phone` is null");
            return (Criteria) this;
        }

        public Criteria andContact_phoneIsNotNull() {
            addCriterion("`contact_phone` is not null");
            return (Criteria) this;
        }

        public Criteria andContact_phoneEqualTo(String value) {
            addCriterion("`contact_phone` =", value, "contact_phone");
            return (Criteria) this;
        }

        public Criteria andContact_phoneNotEqualTo(String value) {
            addCriterion("`contact_phone` <>", value, "contact_phone");
            return (Criteria) this;
        }

        public Criteria andContact_phoneGreaterThan(String value) {
            addCriterion("`contact_phone` >", value, "contact_phone");
            return (Criteria) this;
        }

        public Criteria andContact_phoneGreaterThanOrEqualTo(String value) {
            addCriterion("`contact_phone` >=", value, "contact_phone");
            return (Criteria) this;
        }

        public Criteria andContact_phoneLessThan(String value) {
            addCriterion("`contact_phone` <", value, "contact_phone");
            return (Criteria) this;
        }

        public Criteria andContact_phoneLessThanOrEqualTo(String value) {
            addCriterion("`contact_phone` <=", value, "contact_phone");
            return (Criteria) this;
        }

        public Criteria andContact_phoneLike(String value) {
            addCriterion("`contact_phone` like", value, "contact_phone");
            return (Criteria) this;
        }

        public Criteria andContact_phoneNotLike(String value) {
            addCriterion("`contact_phone` not like", value, "contact_phone");
            return (Criteria) this;
        }

        public Criteria andContact_phoneIn(List<String> values) {
            addCriterion("`contact_phone` in", values, "contact_phone");
            return (Criteria) this;
        }

        public Criteria andContact_phoneNotIn(List<String> values) {
            addCriterion("`contact_phone` not in", values, "contact_phone");
            return (Criteria) this;
        }

        public Criteria andContact_phoneBetween(String value1, String value2) {
            addCriterion("`contact_phone` between", value1, value2, "contact_phone");
            return (Criteria) this;
        }

        public Criteria andContact_phoneNotBetween(String value1, String value2) {
            addCriterion("`contact_phone` not between", value1, value2, "contact_phone");
            return (Criteria) this;
        }

        public Criteria andContact_nameIsNull() {
            addCriterion("`contact_name` is null");
            return (Criteria) this;
        }

        public Criteria andContact_nameIsNotNull() {
            addCriterion("`contact_name` is not null");
            return (Criteria) this;
        }

        public Criteria andContact_nameEqualTo(String value) {
            addCriterion("`contact_name` =", value, "contact_name");
            return (Criteria) this;
        }

        public Criteria andContact_nameNotEqualTo(String value) {
            addCriterion("`contact_name` <>", value, "contact_name");
            return (Criteria) this;
        }

        public Criteria andContact_nameGreaterThan(String value) {
            addCriterion("`contact_name` >", value, "contact_name");
            return (Criteria) this;
        }

        public Criteria andContact_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`contact_name` >=", value, "contact_name");
            return (Criteria) this;
        }

        public Criteria andContact_nameLessThan(String value) {
            addCriterion("`contact_name` <", value, "contact_name");
            return (Criteria) this;
        }

        public Criteria andContact_nameLessThanOrEqualTo(String value) {
            addCriterion("`contact_name` <=", value, "contact_name");
            return (Criteria) this;
        }

        public Criteria andContact_nameLike(String value) {
            addCriterion("`contact_name` like", value, "contact_name");
            return (Criteria) this;
        }

        public Criteria andContact_nameNotLike(String value) {
            addCriterion("`contact_name` not like", value, "contact_name");
            return (Criteria) this;
        }

        public Criteria andContact_nameIn(List<String> values) {
            addCriterion("`contact_name` in", values, "contact_name");
            return (Criteria) this;
        }

        public Criteria andContact_nameNotIn(List<String> values) {
            addCriterion("`contact_name` not in", values, "contact_name");
            return (Criteria) this;
        }

        public Criteria andContact_nameBetween(String value1, String value2) {
            addCriterion("`contact_name` between", value1, value2, "contact_name");
            return (Criteria) this;
        }

        public Criteria andContact_nameNotBetween(String value1, String value2) {
            addCriterion("`contact_name` not between", value1, value2, "contact_name");
            return (Criteria) this;
        }

        public Criteria andContact_emailIsNull() {
            addCriterion("`contact_email` is null");
            return (Criteria) this;
        }

        public Criteria andContact_emailIsNotNull() {
            addCriterion("`contact_email` is not null");
            return (Criteria) this;
        }

        public Criteria andContact_emailEqualTo(String value) {
            addCriterion("`contact_email` =", value, "contact_email");
            return (Criteria) this;
        }

        public Criteria andContact_emailNotEqualTo(String value) {
            addCriterion("`contact_email` <>", value, "contact_email");
            return (Criteria) this;
        }

        public Criteria andContact_emailGreaterThan(String value) {
            addCriterion("`contact_email` >", value, "contact_email");
            return (Criteria) this;
        }

        public Criteria andContact_emailGreaterThanOrEqualTo(String value) {
            addCriterion("`contact_email` >=", value, "contact_email");
            return (Criteria) this;
        }

        public Criteria andContact_emailLessThan(String value) {
            addCriterion("`contact_email` <", value, "contact_email");
            return (Criteria) this;
        }

        public Criteria andContact_emailLessThanOrEqualTo(String value) {
            addCriterion("`contact_email` <=", value, "contact_email");
            return (Criteria) this;
        }

        public Criteria andContact_emailLike(String value) {
            addCriterion("`contact_email` like", value, "contact_email");
            return (Criteria) this;
        }

        public Criteria andContact_emailNotLike(String value) {
            addCriterion("`contact_email` not like", value, "contact_email");
            return (Criteria) this;
        }

        public Criteria andContact_emailIn(List<String> values) {
            addCriterion("`contact_email` in", values, "contact_email");
            return (Criteria) this;
        }

        public Criteria andContact_emailNotIn(List<String> values) {
            addCriterion("`contact_email` not in", values, "contact_email");
            return (Criteria) this;
        }

        public Criteria andContact_emailBetween(String value1, String value2) {
            addCriterion("`contact_email` between", value1, value2, "contact_email");
            return (Criteria) this;
        }

        public Criteria andContact_emailNotBetween(String value1, String value2) {
            addCriterion("`contact_email` not between", value1, value2, "contact_email");
            return (Criteria) this;
        }

        public Criteria andBusiness_statusIsNull() {
            addCriterion("`business_status` is null");
            return (Criteria) this;
        }

        public Criteria andBusiness_statusIsNotNull() {
            addCriterion("`business_status` is not null");
            return (Criteria) this;
        }

        public Criteria andBusiness_statusEqualTo(Integer value) {
            addCriterion("`business_status` =", value, "business_status");
            return (Criteria) this;
        }

        public Criteria andBusiness_statusNotEqualTo(Integer value) {
            addCriterion("`business_status` <>", value, "business_status");
            return (Criteria) this;
        }

        public Criteria andBusiness_statusGreaterThan(Integer value) {
            addCriterion("`business_status` >", value, "business_status");
            return (Criteria) this;
        }

        public Criteria andBusiness_statusGreaterThanOrEqualTo(Integer value) {
            addCriterion("`business_status` >=", value, "business_status");
            return (Criteria) this;
        }

        public Criteria andBusiness_statusLessThan(Integer value) {
            addCriterion("`business_status` <", value, "business_status");
            return (Criteria) this;
        }

        public Criteria andBusiness_statusLessThanOrEqualTo(Integer value) {
            addCriterion("`business_status` <=", value, "business_status");
            return (Criteria) this;
        }

        public Criteria andBusiness_statusIn(List<Integer> values) {
            addCriterion("`business_status` in", values, "business_status");
            return (Criteria) this;
        }

        public Criteria andBusiness_statusNotIn(List<Integer> values) {
            addCriterion("`business_status` not in", values, "business_status");
            return (Criteria) this;
        }

        public Criteria andBusiness_statusBetween(Integer value1, Integer value2) {
            addCriterion("`business_status` between", value1, value2, "business_status");
            return (Criteria) this;
        }

        public Criteria andBusiness_statusNotBetween(Integer value1, Integer value2) {
            addCriterion("`business_status` not between", value1, value2, "business_status");
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
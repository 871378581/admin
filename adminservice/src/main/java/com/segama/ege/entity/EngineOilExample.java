package com.segama.ege.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EngineOilExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public EngineOilExample() {
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

        public Criteria andBrandIsNull() {
            addCriterion("`brand` is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("`brand` is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("`brand` =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("`brand` <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("`brand` >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("`brand` >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("`brand` <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("`brand` <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("`brand` like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("`brand` not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("`brand` in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("`brand` not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("`brand` between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("`brand` not between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrand_nameIsNull() {
            addCriterion("`brand_name` is null");
            return (Criteria) this;
        }

        public Criteria andBrand_nameIsNotNull() {
            addCriterion("`brand_name` is not null");
            return (Criteria) this;
        }

        public Criteria andBrand_nameEqualTo(String value) {
            addCriterion("`brand_name` =", value, "brand_name");
            return (Criteria) this;
        }

        public Criteria andBrand_nameNotEqualTo(String value) {
            addCriterion("`brand_name` <>", value, "brand_name");
            return (Criteria) this;
        }

        public Criteria andBrand_nameGreaterThan(String value) {
            addCriterion("`brand_name` >", value, "brand_name");
            return (Criteria) this;
        }

        public Criteria andBrand_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`brand_name` >=", value, "brand_name");
            return (Criteria) this;
        }

        public Criteria andBrand_nameLessThan(String value) {
            addCriterion("`brand_name` <", value, "brand_name");
            return (Criteria) this;
        }

        public Criteria andBrand_nameLessThanOrEqualTo(String value) {
            addCriterion("`brand_name` <=", value, "brand_name");
            return (Criteria) this;
        }

        public Criteria andBrand_nameLike(String value) {
            addCriterion("`brand_name` like", value, "brand_name");
            return (Criteria) this;
        }

        public Criteria andBrand_nameNotLike(String value) {
            addCriterion("`brand_name` not like", value, "brand_name");
            return (Criteria) this;
        }

        public Criteria andBrand_nameIn(List<String> values) {
            addCriterion("`brand_name` in", values, "brand_name");
            return (Criteria) this;
        }

        public Criteria andBrand_nameNotIn(List<String> values) {
            addCriterion("`brand_name` not in", values, "brand_name");
            return (Criteria) this;
        }

        public Criteria andBrand_nameBetween(String value1, String value2) {
            addCriterion("`brand_name` between", value1, value2, "brand_name");
            return (Criteria) this;
        }

        public Criteria andBrand_nameNotBetween(String value1, String value2) {
            addCriterion("`brand_name` not between", value1, value2, "brand_name");
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

        public Criteria andMarket_priceIsNull() {
            addCriterion("`market_price` is null");
            return (Criteria) this;
        }

        public Criteria andMarket_priceIsNotNull() {
            addCriterion("`market_price` is not null");
            return (Criteria) this;
        }

        public Criteria andMarket_priceEqualTo(BigDecimal value) {
            addCriterion("`market_price` =", value, "market_price");
            return (Criteria) this;
        }

        public Criteria andMarket_priceNotEqualTo(BigDecimal value) {
            addCriterion("`market_price` <>", value, "market_price");
            return (Criteria) this;
        }

        public Criteria andMarket_priceGreaterThan(BigDecimal value) {
            addCriterion("`market_price` >", value, "market_price");
            return (Criteria) this;
        }

        public Criteria andMarket_priceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("`market_price` >=", value, "market_price");
            return (Criteria) this;
        }

        public Criteria andMarket_priceLessThan(BigDecimal value) {
            addCriterion("`market_price` <", value, "market_price");
            return (Criteria) this;
        }

        public Criteria andMarket_priceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("`market_price` <=", value, "market_price");
            return (Criteria) this;
        }

        public Criteria andMarket_priceIn(List<BigDecimal> values) {
            addCriterion("`market_price` in", values, "market_price");
            return (Criteria) this;
        }

        public Criteria andMarket_priceNotIn(List<BigDecimal> values) {
            addCriterion("`market_price` not in", values, "market_price");
            return (Criteria) this;
        }

        public Criteria andMarket_priceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`market_price` between", value1, value2, "market_price");
            return (Criteria) this;
        }

        public Criteria andMarket_priceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`market_price` not between", value1, value2, "market_price");
            return (Criteria) this;
        }

        public Criteria andMember_priceIsNull() {
            addCriterion("`member_price` is null");
            return (Criteria) this;
        }

        public Criteria andMember_priceIsNotNull() {
            addCriterion("`member_price` is not null");
            return (Criteria) this;
        }

        public Criteria andMember_priceEqualTo(BigDecimal value) {
            addCriterion("`member_price` =", value, "member_price");
            return (Criteria) this;
        }

        public Criteria andMember_priceNotEqualTo(BigDecimal value) {
            addCriterion("`member_price` <>", value, "member_price");
            return (Criteria) this;
        }

        public Criteria andMember_priceGreaterThan(BigDecimal value) {
            addCriterion("`member_price` >", value, "member_price");
            return (Criteria) this;
        }

        public Criteria andMember_priceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("`member_price` >=", value, "member_price");
            return (Criteria) this;
        }

        public Criteria andMember_priceLessThan(BigDecimal value) {
            addCriterion("`member_price` <", value, "member_price");
            return (Criteria) this;
        }

        public Criteria andMember_priceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("`member_price` <=", value, "member_price");
            return (Criteria) this;
        }

        public Criteria andMember_priceIn(List<BigDecimal> values) {
            addCriterion("`member_price` in", values, "member_price");
            return (Criteria) this;
        }

        public Criteria andMember_priceNotIn(List<BigDecimal> values) {
            addCriterion("`member_price` not in", values, "member_price");
            return (Criteria) this;
        }

        public Criteria andMember_priceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`member_price` between", value1, value2, "member_price");
            return (Criteria) this;
        }

        public Criteria andMember_priceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`member_price` not between", value1, value2, "member_price");
            return (Criteria) this;
        }

        public Criteria andPhoto_urlIsNull() {
            addCriterion("`photo_url` is null");
            return (Criteria) this;
        }

        public Criteria andPhoto_urlIsNotNull() {
            addCriterion("`photo_url` is not null");
            return (Criteria) this;
        }

        public Criteria andPhoto_urlEqualTo(String value) {
            addCriterion("`photo_url` =", value, "photo_url");
            return (Criteria) this;
        }

        public Criteria andPhoto_urlNotEqualTo(String value) {
            addCriterion("`photo_url` <>", value, "photo_url");
            return (Criteria) this;
        }

        public Criteria andPhoto_urlGreaterThan(String value) {
            addCriterion("`photo_url` >", value, "photo_url");
            return (Criteria) this;
        }

        public Criteria andPhoto_urlGreaterThanOrEqualTo(String value) {
            addCriterion("`photo_url` >=", value, "photo_url");
            return (Criteria) this;
        }

        public Criteria andPhoto_urlLessThan(String value) {
            addCriterion("`photo_url` <", value, "photo_url");
            return (Criteria) this;
        }

        public Criteria andPhoto_urlLessThanOrEqualTo(String value) {
            addCriterion("`photo_url` <=", value, "photo_url");
            return (Criteria) this;
        }

        public Criteria andPhoto_urlLike(String value) {
            addCriterion("`photo_url` like", value, "photo_url");
            return (Criteria) this;
        }

        public Criteria andPhoto_urlNotLike(String value) {
            addCriterion("`photo_url` not like", value, "photo_url");
            return (Criteria) this;
        }

        public Criteria andPhoto_urlIn(List<String> values) {
            addCriterion("`photo_url` in", values, "photo_url");
            return (Criteria) this;
        }

        public Criteria andPhoto_urlNotIn(List<String> values) {
            addCriterion("`photo_url` not in", values, "photo_url");
            return (Criteria) this;
        }

        public Criteria andPhoto_urlBetween(String value1, String value2) {
            addCriterion("`photo_url` between", value1, value2, "photo_url");
            return (Criteria) this;
        }

        public Criteria andPhoto_urlNotBetween(String value1, String value2) {
            addCriterion("`photo_url` not between", value1, value2, "photo_url");
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

        public Criteria andOil_typeIsNull() {
            addCriterion("`oil_type` is null");
            return (Criteria) this;
        }

        public Criteria andOil_typeIsNotNull() {
            addCriterion("`oil_type` is not null");
            return (Criteria) this;
        }

        public Criteria andOil_typeEqualTo(String value) {
            addCriterion("`oil_type` =", value, "oil_type");
            return (Criteria) this;
        }

        public Criteria andOil_typeNotEqualTo(String value) {
            addCriterion("`oil_type` <>", value, "oil_type");
            return (Criteria) this;
        }

        public Criteria andOil_typeGreaterThan(String value) {
            addCriterion("`oil_type` >", value, "oil_type");
            return (Criteria) this;
        }

        public Criteria andOil_typeGreaterThanOrEqualTo(String value) {
            addCriterion("`oil_type` >=", value, "oil_type");
            return (Criteria) this;
        }

        public Criteria andOil_typeLessThan(String value) {
            addCriterion("`oil_type` <", value, "oil_type");
            return (Criteria) this;
        }

        public Criteria andOil_typeLessThanOrEqualTo(String value) {
            addCriterion("`oil_type` <=", value, "oil_type");
            return (Criteria) this;
        }

        public Criteria andOil_typeLike(String value) {
            addCriterion("`oil_type` like", value, "oil_type");
            return (Criteria) this;
        }

        public Criteria andOil_typeNotLike(String value) {
            addCriterion("`oil_type` not like", value, "oil_type");
            return (Criteria) this;
        }

        public Criteria andOil_typeIn(List<String> values) {
            addCriterion("`oil_type` in", values, "oil_type");
            return (Criteria) this;
        }

        public Criteria andOil_typeNotIn(List<String> values) {
            addCriterion("`oil_type` not in", values, "oil_type");
            return (Criteria) this;
        }

        public Criteria andOil_typeBetween(String value1, String value2) {
            addCriterion("`oil_type` between", value1, value2, "oil_type");
            return (Criteria) this;
        }

        public Criteria andOil_typeNotBetween(String value1, String value2) {
            addCriterion("`oil_type` not between", value1, value2, "oil_type");
            return (Criteria) this;
        }

        public Criteria andMarket_price_maxIsNull() {
            addCriterion("`market_price_max` is null");
            return (Criteria) this;
        }

        public Criteria andMarket_price_maxIsNotNull() {
            addCriterion("`market_price_max` is not null");
            return (Criteria) this;
        }

        public Criteria andMarket_price_maxEqualTo(BigDecimal value) {
            addCriterion("`market_price_max` =", value, "market_price_max");
            return (Criteria) this;
        }

        public Criteria andMarket_price_maxNotEqualTo(BigDecimal value) {
            addCriterion("`market_price_max` <>", value, "market_price_max");
            return (Criteria) this;
        }

        public Criteria andMarket_price_maxGreaterThan(BigDecimal value) {
            addCriterion("`market_price_max` >", value, "market_price_max");
            return (Criteria) this;
        }

        public Criteria andMarket_price_maxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("`market_price_max` >=", value, "market_price_max");
            return (Criteria) this;
        }

        public Criteria andMarket_price_maxLessThan(BigDecimal value) {
            addCriterion("`market_price_max` <", value, "market_price_max");
            return (Criteria) this;
        }

        public Criteria andMarket_price_maxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("`market_price_max` <=", value, "market_price_max");
            return (Criteria) this;
        }

        public Criteria andMarket_price_maxIn(List<BigDecimal> values) {
            addCriterion("`market_price_max` in", values, "market_price_max");
            return (Criteria) this;
        }

        public Criteria andMarket_price_maxNotIn(List<BigDecimal> values) {
            addCriterion("`market_price_max` not in", values, "market_price_max");
            return (Criteria) this;
        }

        public Criteria andMarket_price_maxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`market_price_max` between", value1, value2, "market_price_max");
            return (Criteria) this;
        }

        public Criteria andMarket_price_maxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`market_price_max` not between", value1, value2, "market_price_max");
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
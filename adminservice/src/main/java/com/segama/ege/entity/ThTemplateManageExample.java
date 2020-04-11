package com.segama.ege.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThTemplateManageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public ThTemplateManageExample() {
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

        public Criteria andTemplate_nameIsNull() {
            addCriterion("`template_name` is null");
            return (Criteria) this;
        }

        public Criteria andTemplate_nameIsNotNull() {
            addCriterion("`template_name` is not null");
            return (Criteria) this;
        }

        public Criteria andTemplate_nameEqualTo(String value) {
            addCriterion("`template_name` =", value, "template_name");
            return (Criteria) this;
        }

        public Criteria andTemplate_nameNotEqualTo(String value) {
            addCriterion("`template_name` <>", value, "template_name");
            return (Criteria) this;
        }

        public Criteria andTemplate_nameGreaterThan(String value) {
            addCriterion("`template_name` >", value, "template_name");
            return (Criteria) this;
        }

        public Criteria andTemplate_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`template_name` >=", value, "template_name");
            return (Criteria) this;
        }

        public Criteria andTemplate_nameLessThan(String value) {
            addCriterion("`template_name` <", value, "template_name");
            return (Criteria) this;
        }

        public Criteria andTemplate_nameLessThanOrEqualTo(String value) {
            addCriterion("`template_name` <=", value, "template_name");
            return (Criteria) this;
        }

        public Criteria andTemplate_nameLike(String value) {
            addCriterion("`template_name` like", value, "template_name");
            return (Criteria) this;
        }

        public Criteria andTemplate_nameNotLike(String value) {
            addCriterion("`template_name` not like", value, "template_name");
            return (Criteria) this;
        }

        public Criteria andTemplate_nameIn(List<String> values) {
            addCriterion("`template_name` in", values, "template_name");
            return (Criteria) this;
        }

        public Criteria andTemplate_nameNotIn(List<String> values) {
            addCriterion("`template_name` not in", values, "template_name");
            return (Criteria) this;
        }

        public Criteria andTemplate_nameBetween(String value1, String value2) {
            addCriterion("`template_name` between", value1, value2, "template_name");
            return (Criteria) this;
        }

        public Criteria andTemplate_nameNotBetween(String value1, String value2) {
            addCriterion("`template_name` not between", value1, value2, "template_name");
            return (Criteria) this;
        }

        public Criteria andTemplate_codeIsNull() {
            addCriterion("`template_code` is null");
            return (Criteria) this;
        }

        public Criteria andTemplate_codeIsNotNull() {
            addCriterion("`template_code` is not null");
            return (Criteria) this;
        }

        public Criteria andTemplate_codeEqualTo(String value) {
            addCriterion("`template_code` =", value, "template_code");
            return (Criteria) this;
        }

        public Criteria andTemplate_codeNotEqualTo(String value) {
            addCriterion("`template_code` <>", value, "template_code");
            return (Criteria) this;
        }

        public Criteria andTemplate_codeGreaterThan(String value) {
            addCriterion("`template_code` >", value, "template_code");
            return (Criteria) this;
        }

        public Criteria andTemplate_codeGreaterThanOrEqualTo(String value) {
            addCriterion("`template_code` >=", value, "template_code");
            return (Criteria) this;
        }

        public Criteria andTemplate_codeLessThan(String value) {
            addCriterion("`template_code` <", value, "template_code");
            return (Criteria) this;
        }

        public Criteria andTemplate_codeLessThanOrEqualTo(String value) {
            addCriterion("`template_code` <=", value, "template_code");
            return (Criteria) this;
        }

        public Criteria andTemplate_codeLike(String value) {
            addCriterion("`template_code` like", value, "template_code");
            return (Criteria) this;
        }

        public Criteria andTemplate_codeNotLike(String value) {
            addCriterion("`template_code` not like", value, "template_code");
            return (Criteria) this;
        }

        public Criteria andTemplate_codeIn(List<String> values) {
            addCriterion("`template_code` in", values, "template_code");
            return (Criteria) this;
        }

        public Criteria andTemplate_codeNotIn(List<String> values) {
            addCriterion("`template_code` not in", values, "template_code");
            return (Criteria) this;
        }

        public Criteria andTemplate_codeBetween(String value1, String value2) {
            addCriterion("`template_code` between", value1, value2, "template_code");
            return (Criteria) this;
        }

        public Criteria andTemplate_codeNotBetween(String value1, String value2) {
            addCriterion("`template_code` not between", value1, value2, "template_code");
            return (Criteria) this;
        }

        public Criteria andBanner1IsNull() {
            addCriterion("`banner1` is null");
            return (Criteria) this;
        }

        public Criteria andBanner1IsNotNull() {
            addCriterion("`banner1` is not null");
            return (Criteria) this;
        }

        public Criteria andBanner1EqualTo(String value) {
            addCriterion("`banner1` =", value, "banner1");
            return (Criteria) this;
        }

        public Criteria andBanner1NotEqualTo(String value) {
            addCriterion("`banner1` <>", value, "banner1");
            return (Criteria) this;
        }

        public Criteria andBanner1GreaterThan(String value) {
            addCriterion("`banner1` >", value, "banner1");
            return (Criteria) this;
        }

        public Criteria andBanner1GreaterThanOrEqualTo(String value) {
            addCriterion("`banner1` >=", value, "banner1");
            return (Criteria) this;
        }

        public Criteria andBanner1LessThan(String value) {
            addCriterion("`banner1` <", value, "banner1");
            return (Criteria) this;
        }

        public Criteria andBanner1LessThanOrEqualTo(String value) {
            addCriterion("`banner1` <=", value, "banner1");
            return (Criteria) this;
        }

        public Criteria andBanner1Like(String value) {
            addCriterion("`banner1` like", value, "banner1");
            return (Criteria) this;
        }

        public Criteria andBanner1NotLike(String value) {
            addCriterion("`banner1` not like", value, "banner1");
            return (Criteria) this;
        }

        public Criteria andBanner1In(List<String> values) {
            addCriterion("`banner1` in", values, "banner1");
            return (Criteria) this;
        }

        public Criteria andBanner1NotIn(List<String> values) {
            addCriterion("`banner1` not in", values, "banner1");
            return (Criteria) this;
        }

        public Criteria andBanner1Between(String value1, String value2) {
            addCriterion("`banner1` between", value1, value2, "banner1");
            return (Criteria) this;
        }

        public Criteria andBanner1NotBetween(String value1, String value2) {
            addCriterion("`banner1` not between", value1, value2, "banner1");
            return (Criteria) this;
        }

        public Criteria andBanner2IsNull() {
            addCriterion("`banner2` is null");
            return (Criteria) this;
        }

        public Criteria andBanner2IsNotNull() {
            addCriterion("`banner2` is not null");
            return (Criteria) this;
        }

        public Criteria andBanner2EqualTo(String value) {
            addCriterion("`banner2` =", value, "banner2");
            return (Criteria) this;
        }

        public Criteria andBanner2NotEqualTo(String value) {
            addCriterion("`banner2` <>", value, "banner2");
            return (Criteria) this;
        }

        public Criteria andBanner2GreaterThan(String value) {
            addCriterion("`banner2` >", value, "banner2");
            return (Criteria) this;
        }

        public Criteria andBanner2GreaterThanOrEqualTo(String value) {
            addCriterion("`banner2` >=", value, "banner2");
            return (Criteria) this;
        }

        public Criteria andBanner2LessThan(String value) {
            addCriterion("`banner2` <", value, "banner2");
            return (Criteria) this;
        }

        public Criteria andBanner2LessThanOrEqualTo(String value) {
            addCriterion("`banner2` <=", value, "banner2");
            return (Criteria) this;
        }

        public Criteria andBanner2Like(String value) {
            addCriterion("`banner2` like", value, "banner2");
            return (Criteria) this;
        }

        public Criteria andBanner2NotLike(String value) {
            addCriterion("`banner2` not like", value, "banner2");
            return (Criteria) this;
        }

        public Criteria andBanner2In(List<String> values) {
            addCriterion("`banner2` in", values, "banner2");
            return (Criteria) this;
        }

        public Criteria andBanner2NotIn(List<String> values) {
            addCriterion("`banner2` not in", values, "banner2");
            return (Criteria) this;
        }

        public Criteria andBanner2Between(String value1, String value2) {
            addCriterion("`banner2` between", value1, value2, "banner2");
            return (Criteria) this;
        }

        public Criteria andBanner2NotBetween(String value1, String value2) {
            addCriterion("`banner2` not between", value1, value2, "banner2");
            return (Criteria) this;
        }

        public Criteria andSub_productIsNull() {
            addCriterion("`sub_product` is null");
            return (Criteria) this;
        }

        public Criteria andSub_productIsNotNull() {
            addCriterion("`sub_product` is not null");
            return (Criteria) this;
        }

        public Criteria andSub_productEqualTo(String value) {
            addCriterion("`sub_product` =", value, "sub_product");
            return (Criteria) this;
        }

        public Criteria andSub_productNotEqualTo(String value) {
            addCriterion("`sub_product` <>", value, "sub_product");
            return (Criteria) this;
        }

        public Criteria andSub_productGreaterThan(String value) {
            addCriterion("`sub_product` >", value, "sub_product");
            return (Criteria) this;
        }

        public Criteria andSub_productGreaterThanOrEqualTo(String value) {
            addCriterion("`sub_product` >=", value, "sub_product");
            return (Criteria) this;
        }

        public Criteria andSub_productLessThan(String value) {
            addCriterion("`sub_product` <", value, "sub_product");
            return (Criteria) this;
        }

        public Criteria andSub_productLessThanOrEqualTo(String value) {
            addCriterion("`sub_product` <=", value, "sub_product");
            return (Criteria) this;
        }

        public Criteria andSub_productLike(String value) {
            addCriterion("`sub_product` like", value, "sub_product");
            return (Criteria) this;
        }

        public Criteria andSub_productNotLike(String value) {
            addCriterion("`sub_product` not like", value, "sub_product");
            return (Criteria) this;
        }

        public Criteria andSub_productIn(List<String> values) {
            addCriterion("`sub_product` in", values, "sub_product");
            return (Criteria) this;
        }

        public Criteria andSub_productNotIn(List<String> values) {
            addCriterion("`sub_product` not in", values, "sub_product");
            return (Criteria) this;
        }

        public Criteria andSub_productBetween(String value1, String value2) {
            addCriterion("`sub_product` between", value1, value2, "sub_product");
            return (Criteria) this;
        }

        public Criteria andSub_productNotBetween(String value1, String value2) {
            addCriterion("`sub_product` not between", value1, value2, "sub_product");
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
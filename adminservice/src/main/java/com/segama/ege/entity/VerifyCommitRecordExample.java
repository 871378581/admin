package com.segama.ege.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VerifyCommitRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public VerifyCommitRecordExample() {
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

        public Criteria andVerify_accountIsNull() {
            addCriterion("`verify_account` is null");
            return (Criteria) this;
        }

        public Criteria andVerify_accountIsNotNull() {
            addCriterion("`verify_account` is not null");
            return (Criteria) this;
        }

        public Criteria andVerify_accountEqualTo(String value) {
            addCriterion("`verify_account` =", value, "verify_account");
            return (Criteria) this;
        }

        public Criteria andVerify_accountNotEqualTo(String value) {
            addCriterion("`verify_account` <>", value, "verify_account");
            return (Criteria) this;
        }

        public Criteria andVerify_accountGreaterThan(String value) {
            addCriterion("`verify_account` >", value, "verify_account");
            return (Criteria) this;
        }

        public Criteria andVerify_accountGreaterThanOrEqualTo(String value) {
            addCriterion("`verify_account` >=", value, "verify_account");
            return (Criteria) this;
        }

        public Criteria andVerify_accountLessThan(String value) {
            addCriterion("`verify_account` <", value, "verify_account");
            return (Criteria) this;
        }

        public Criteria andVerify_accountLessThanOrEqualTo(String value) {
            addCriterion("`verify_account` <=", value, "verify_account");
            return (Criteria) this;
        }

        public Criteria andVerify_accountLike(String value) {
            addCriterion("`verify_account` like", value, "verify_account");
            return (Criteria) this;
        }

        public Criteria andVerify_accountNotLike(String value) {
            addCriterion("`verify_account` not like", value, "verify_account");
            return (Criteria) this;
        }

        public Criteria andVerify_accountIn(List<String> values) {
            addCriterion("`verify_account` in", values, "verify_account");
            return (Criteria) this;
        }

        public Criteria andVerify_accountNotIn(List<String> values) {
            addCriterion("`verify_account` not in", values, "verify_account");
            return (Criteria) this;
        }

        public Criteria andVerify_accountBetween(String value1, String value2) {
            addCriterion("`verify_account` between", value1, value2, "verify_account");
            return (Criteria) this;
        }

        public Criteria andVerify_accountNotBetween(String value1, String value2) {
            addCriterion("`verify_account` not between", value1, value2, "verify_account");
            return (Criteria) this;
        }

        public Criteria andShop_idIsNull() {
            addCriterion("`shop_id` is null");
            return (Criteria) this;
        }

        public Criteria andShop_idIsNotNull() {
            addCriterion("`shop_id` is not null");
            return (Criteria) this;
        }

        public Criteria andShop_idEqualTo(Long value) {
            addCriterion("`shop_id` =", value, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShop_idNotEqualTo(Long value) {
            addCriterion("`shop_id` <>", value, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShop_idGreaterThan(Long value) {
            addCriterion("`shop_id` >", value, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShop_idGreaterThanOrEqualTo(Long value) {
            addCriterion("`shop_id` >=", value, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShop_idLessThan(Long value) {
            addCriterion("`shop_id` <", value, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShop_idLessThanOrEqualTo(Long value) {
            addCriterion("`shop_id` <=", value, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShop_idIn(List<Long> values) {
            addCriterion("`shop_id` in", values, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShop_idNotIn(List<Long> values) {
            addCriterion("`shop_id` not in", values, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShop_idBetween(Long value1, Long value2) {
            addCriterion("`shop_id` between", value1, value2, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShop_idNotBetween(Long value1, Long value2) {
            addCriterion("`shop_id` not between", value1, value2, "shop_id");
            return (Criteria) this;
        }

        public Criteria andShop_nameIsNull() {
            addCriterion("`shop_name` is null");
            return (Criteria) this;
        }

        public Criteria andShop_nameIsNotNull() {
            addCriterion("`shop_name` is not null");
            return (Criteria) this;
        }

        public Criteria andShop_nameEqualTo(String value) {
            addCriterion("`shop_name` =", value, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShop_nameNotEqualTo(String value) {
            addCriterion("`shop_name` <>", value, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShop_nameGreaterThan(String value) {
            addCriterion("`shop_name` >", value, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShop_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`shop_name` >=", value, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShop_nameLessThan(String value) {
            addCriterion("`shop_name` <", value, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShop_nameLessThanOrEqualTo(String value) {
            addCriterion("`shop_name` <=", value, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShop_nameLike(String value) {
            addCriterion("`shop_name` like", value, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShop_nameNotLike(String value) {
            addCriterion("`shop_name` not like", value, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShop_nameIn(List<String> values) {
            addCriterion("`shop_name` in", values, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShop_nameNotIn(List<String> values) {
            addCriterion("`shop_name` not in", values, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShop_nameBetween(String value1, String value2) {
            addCriterion("`shop_name` between", value1, value2, "shop_name");
            return (Criteria) this;
        }

        public Criteria andShop_nameNotBetween(String value1, String value2) {
            addCriterion("`shop_name` not between", value1, value2, "shop_name");
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

        public Criteria andOperate_typeEqualTo(Integer value) {
            addCriterion("`operate_type` =", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeNotEqualTo(Integer value) {
            addCriterion("`operate_type` <>", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeGreaterThan(Integer value) {
            addCriterion("`operate_type` >", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("`operate_type` >=", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeLessThan(Integer value) {
            addCriterion("`operate_type` <", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeLessThanOrEqualTo(Integer value) {
            addCriterion("`operate_type` <=", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeIn(List<Integer> values) {
            addCriterion("`operate_type` in", values, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeNotIn(List<Integer> values) {
            addCriterion("`operate_type` not in", values, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeBetween(Integer value1, Integer value2) {
            addCriterion("`operate_type` between", value1, value2, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("`operate_type` not between", value1, value2, "operate_type");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("`remark` is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("`remark` is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("`remark` =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("`remark` <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("`remark` >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("`remark` >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("`remark` <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("`remark` <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("`remark` like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("`remark` not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("`remark` in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("`remark` not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("`remark` between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("`remark` not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andPayment_voucherIsNull() {
            addCriterion("`payment_voucher` is null");
            return (Criteria) this;
        }

        public Criteria andPayment_voucherIsNotNull() {
            addCriterion("`payment_voucher` is not null");
            return (Criteria) this;
        }

        public Criteria andPayment_voucherEqualTo(String value) {
            addCriterion("`payment_voucher` =", value, "payment_voucher");
            return (Criteria) this;
        }

        public Criteria andPayment_voucherNotEqualTo(String value) {
            addCriterion("`payment_voucher` <>", value, "payment_voucher");
            return (Criteria) this;
        }

        public Criteria andPayment_voucherGreaterThan(String value) {
            addCriterion("`payment_voucher` >", value, "payment_voucher");
            return (Criteria) this;
        }

        public Criteria andPayment_voucherGreaterThanOrEqualTo(String value) {
            addCriterion("`payment_voucher` >=", value, "payment_voucher");
            return (Criteria) this;
        }

        public Criteria andPayment_voucherLessThan(String value) {
            addCriterion("`payment_voucher` <", value, "payment_voucher");
            return (Criteria) this;
        }

        public Criteria andPayment_voucherLessThanOrEqualTo(String value) {
            addCriterion("`payment_voucher` <=", value, "payment_voucher");
            return (Criteria) this;
        }

        public Criteria andPayment_voucherLike(String value) {
            addCriterion("`payment_voucher` like", value, "payment_voucher");
            return (Criteria) this;
        }

        public Criteria andPayment_voucherNotLike(String value) {
            addCriterion("`payment_voucher` not like", value, "payment_voucher");
            return (Criteria) this;
        }

        public Criteria andPayment_voucherIn(List<String> values) {
            addCriterion("`payment_voucher` in", values, "payment_voucher");
            return (Criteria) this;
        }

        public Criteria andPayment_voucherNotIn(List<String> values) {
            addCriterion("`payment_voucher` not in", values, "payment_voucher");
            return (Criteria) this;
        }

        public Criteria andPayment_voucherBetween(String value1, String value2) {
            addCriterion("`payment_voucher` between", value1, value2, "payment_voucher");
            return (Criteria) this;
        }

        public Criteria andPayment_voucherNotBetween(String value1, String value2) {
            addCriterion("`payment_voucher` not between", value1, value2, "payment_voucher");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("`amount` is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("`amount` is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(String value) {
            addCriterion("`amount` =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(String value) {
            addCriterion("`amount` <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(String value) {
            addCriterion("`amount` >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(String value) {
            addCriterion("`amount` >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(String value) {
            addCriterion("`amount` <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(String value) {
            addCriterion("`amount` <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLike(String value) {
            addCriterion("`amount` like", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotLike(String value) {
            addCriterion("`amount` not like", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<String> values) {
            addCriterion("`amount` in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<String> values) {
            addCriterion("`amount` not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(String value1, String value2) {
            addCriterion("`amount` between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(String value1, String value2) {
            addCriterion("`amount` not between", value1, value2, "amount");
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
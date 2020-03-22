package com.segama.ege.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public AdminUserExample() {
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

        public Criteria andAccountIsNull() {
            addCriterion("`account` is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("`account` is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("`account` =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("`account` <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("`account` >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("`account` >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("`account` <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("`account` <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("`account` like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("`account` not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("`account` in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("`account` not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("`account` between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("`account` not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("`password` is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("`password` is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("`password` =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("`password` <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("`password` >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("`password` >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("`password` <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("`password` <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("`password` like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("`password` not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("`password` in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("`password` not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("`password` between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("`password` not between", value1, value2, "password");
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

        public Criteria andTokenIsNull() {
            addCriterion("`token` is null");
            return (Criteria) this;
        }

        public Criteria andTokenIsNotNull() {
            addCriterion("`token` is not null");
            return (Criteria) this;
        }

        public Criteria andTokenEqualTo(String value) {
            addCriterion("`token` =", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotEqualTo(String value) {
            addCriterion("`token` <>", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThan(String value) {
            addCriterion("`token` >", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenGreaterThanOrEqualTo(String value) {
            addCriterion("`token` >=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThan(String value) {
            addCriterion("`token` <", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLessThanOrEqualTo(String value) {
            addCriterion("`token` <=", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenLike(String value) {
            addCriterion("`token` like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotLike(String value) {
            addCriterion("`token` not like", value, "token");
            return (Criteria) this;
        }

        public Criteria andTokenIn(List<String> values) {
            addCriterion("`token` in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotIn(List<String> values) {
            addCriterion("`token` not in", values, "token");
            return (Criteria) this;
        }

        public Criteria andTokenBetween(String value1, String value2) {
            addCriterion("`token` between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andTokenNotBetween(String value1, String value2) {
            addCriterion("`token` not between", value1, value2, "token");
            return (Criteria) this;
        }

        public Criteria andExpire_timeIsNull() {
            addCriterion("`expire_time` is null");
            return (Criteria) this;
        }

        public Criteria andExpire_timeIsNotNull() {
            addCriterion("`expire_time` is not null");
            return (Criteria) this;
        }

        public Criteria andExpire_timeEqualTo(Date value) {
            addCriterion("`expire_time` =", value, "expire_time");
            return (Criteria) this;
        }

        public Criteria andExpire_timeNotEqualTo(Date value) {
            addCriterion("`expire_time` <>", value, "expire_time");
            return (Criteria) this;
        }

        public Criteria andExpire_timeGreaterThan(Date value) {
            addCriterion("`expire_time` >", value, "expire_time");
            return (Criteria) this;
        }

        public Criteria andExpire_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("`expire_time` >=", value, "expire_time");
            return (Criteria) this;
        }

        public Criteria andExpire_timeLessThan(Date value) {
            addCriterion("`expire_time` <", value, "expire_time");
            return (Criteria) this;
        }

        public Criteria andExpire_timeLessThanOrEqualTo(Date value) {
            addCriterion("`expire_time` <=", value, "expire_time");
            return (Criteria) this;
        }

        public Criteria andExpire_timeIn(List<Date> values) {
            addCriterion("`expire_time` in", values, "expire_time");
            return (Criteria) this;
        }

        public Criteria andExpire_timeNotIn(List<Date> values) {
            addCriterion("`expire_time` not in", values, "expire_time");
            return (Criteria) this;
        }

        public Criteria andExpire_timeBetween(Date value1, Date value2) {
            addCriterion("`expire_time` between", value1, value2, "expire_time");
            return (Criteria) this;
        }

        public Criteria andExpire_timeNotBetween(Date value1, Date value2) {
            addCriterion("`expire_time` not between", value1, value2, "expire_time");
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

        public Criteria andChannel_nameIsNull() {
            addCriterion("`channel_name` is null");
            return (Criteria) this;
        }

        public Criteria andChannel_nameIsNotNull() {
            addCriterion("`channel_name` is not null");
            return (Criteria) this;
        }

        public Criteria andChannel_nameEqualTo(String value) {
            addCriterion("`channel_name` =", value, "channel_name");
            return (Criteria) this;
        }

        public Criteria andChannel_nameNotEqualTo(String value) {
            addCriterion("`channel_name` <>", value, "channel_name");
            return (Criteria) this;
        }

        public Criteria andChannel_nameGreaterThan(String value) {
            addCriterion("`channel_name` >", value, "channel_name");
            return (Criteria) this;
        }

        public Criteria andChannel_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`channel_name` >=", value, "channel_name");
            return (Criteria) this;
        }

        public Criteria andChannel_nameLessThan(String value) {
            addCriterion("`channel_name` <", value, "channel_name");
            return (Criteria) this;
        }

        public Criteria andChannel_nameLessThanOrEqualTo(String value) {
            addCriterion("`channel_name` <=", value, "channel_name");
            return (Criteria) this;
        }

        public Criteria andChannel_nameLike(String value) {
            addCriterion("`channel_name` like", value, "channel_name");
            return (Criteria) this;
        }

        public Criteria andChannel_nameNotLike(String value) {
            addCriterion("`channel_name` not like", value, "channel_name");
            return (Criteria) this;
        }

        public Criteria andChannel_nameIn(List<String> values) {
            addCriterion("`channel_name` in", values, "channel_name");
            return (Criteria) this;
        }

        public Criteria andChannel_nameNotIn(List<String> values) {
            addCriterion("`channel_name` not in", values, "channel_name");
            return (Criteria) this;
        }

        public Criteria andChannel_nameBetween(String value1, String value2) {
            addCriterion("`channel_name` between", value1, value2, "channel_name");
            return (Criteria) this;
        }

        public Criteria andChannel_nameNotBetween(String value1, String value2) {
            addCriterion("`channel_name` not between", value1, value2, "channel_name");
            return (Criteria) this;
        }

        public Criteria andMain_bodyIsNull() {
            addCriterion("`main_body` is null");
            return (Criteria) this;
        }

        public Criteria andMain_bodyIsNotNull() {
            addCriterion("`main_body` is not null");
            return (Criteria) this;
        }

        public Criteria andMain_bodyEqualTo(String value) {
            addCriterion("`main_body` =", value, "main_body");
            return (Criteria) this;
        }

        public Criteria andMain_bodyNotEqualTo(String value) {
            addCriterion("`main_body` <>", value, "main_body");
            return (Criteria) this;
        }

        public Criteria andMain_bodyGreaterThan(String value) {
            addCriterion("`main_body` >", value, "main_body");
            return (Criteria) this;
        }

        public Criteria andMain_bodyGreaterThanOrEqualTo(String value) {
            addCriterion("`main_body` >=", value, "main_body");
            return (Criteria) this;
        }

        public Criteria andMain_bodyLessThan(String value) {
            addCriterion("`main_body` <", value, "main_body");
            return (Criteria) this;
        }

        public Criteria andMain_bodyLessThanOrEqualTo(String value) {
            addCriterion("`main_body` <=", value, "main_body");
            return (Criteria) this;
        }

        public Criteria andMain_bodyLike(String value) {
            addCriterion("`main_body` like", value, "main_body");
            return (Criteria) this;
        }

        public Criteria andMain_bodyNotLike(String value) {
            addCriterion("`main_body` not like", value, "main_body");
            return (Criteria) this;
        }

        public Criteria andMain_bodyIn(List<String> values) {
            addCriterion("`main_body` in", values, "main_body");
            return (Criteria) this;
        }

        public Criteria andMain_bodyNotIn(List<String> values) {
            addCriterion("`main_body` not in", values, "main_body");
            return (Criteria) this;
        }

        public Criteria andMain_bodyBetween(String value1, String value2) {
            addCriterion("`main_body` between", value1, value2, "main_body");
            return (Criteria) this;
        }

        public Criteria andMain_bodyNotBetween(String value1, String value2) {
            addCriterion("`main_body` not between", value1, value2, "main_body");
            return (Criteria) this;
        }

        public Criteria andContacterIsNull() {
            addCriterion("`contacter` is null");
            return (Criteria) this;
        }

        public Criteria andContacterIsNotNull() {
            addCriterion("`contacter` is not null");
            return (Criteria) this;
        }

        public Criteria andContacterEqualTo(String value) {
            addCriterion("`contacter` =", value, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterNotEqualTo(String value) {
            addCriterion("`contacter` <>", value, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterGreaterThan(String value) {
            addCriterion("`contacter` >", value, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterGreaterThanOrEqualTo(String value) {
            addCriterion("`contacter` >=", value, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterLessThan(String value) {
            addCriterion("`contacter` <", value, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterLessThanOrEqualTo(String value) {
            addCriterion("`contacter` <=", value, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterLike(String value) {
            addCriterion("`contacter` like", value, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterNotLike(String value) {
            addCriterion("`contacter` not like", value, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterIn(List<String> values) {
            addCriterion("`contacter` in", values, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterNotIn(List<String> values) {
            addCriterion("`contacter` not in", values, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterBetween(String value1, String value2) {
            addCriterion("`contacter` between", value1, value2, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterNotBetween(String value1, String value2) {
            addCriterion("`contacter` not between", value1, value2, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacter_phoneIsNull() {
            addCriterion("`contacter_phone` is null");
            return (Criteria) this;
        }

        public Criteria andContacter_phoneIsNotNull() {
            addCriterion("`contacter_phone` is not null");
            return (Criteria) this;
        }

        public Criteria andContacter_phoneEqualTo(String value) {
            addCriterion("`contacter_phone` =", value, "contacter_phone");
            return (Criteria) this;
        }

        public Criteria andContacter_phoneNotEqualTo(String value) {
            addCriterion("`contacter_phone` <>", value, "contacter_phone");
            return (Criteria) this;
        }

        public Criteria andContacter_phoneGreaterThan(String value) {
            addCriterion("`contacter_phone` >", value, "contacter_phone");
            return (Criteria) this;
        }

        public Criteria andContacter_phoneGreaterThanOrEqualTo(String value) {
            addCriterion("`contacter_phone` >=", value, "contacter_phone");
            return (Criteria) this;
        }

        public Criteria andContacter_phoneLessThan(String value) {
            addCriterion("`contacter_phone` <", value, "contacter_phone");
            return (Criteria) this;
        }

        public Criteria andContacter_phoneLessThanOrEqualTo(String value) {
            addCriterion("`contacter_phone` <=", value, "contacter_phone");
            return (Criteria) this;
        }

        public Criteria andContacter_phoneLike(String value) {
            addCriterion("`contacter_phone` like", value, "contacter_phone");
            return (Criteria) this;
        }

        public Criteria andContacter_phoneNotLike(String value) {
            addCriterion("`contacter_phone` not like", value, "contacter_phone");
            return (Criteria) this;
        }

        public Criteria andContacter_phoneIn(List<String> values) {
            addCriterion("`contacter_phone` in", values, "contacter_phone");
            return (Criteria) this;
        }

        public Criteria andContacter_phoneNotIn(List<String> values) {
            addCriterion("`contacter_phone` not in", values, "contacter_phone");
            return (Criteria) this;
        }

        public Criteria andContacter_phoneBetween(String value1, String value2) {
            addCriterion("`contacter_phone` between", value1, value2, "contacter_phone");
            return (Criteria) this;
        }

        public Criteria andContacter_phoneNotBetween(String value1, String value2) {
            addCriterion("`contacter_phone` not between", value1, value2, "contacter_phone");
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

        public Criteria andChannel_typeIsNull() {
            addCriterion("`channel_type` is null");
            return (Criteria) this;
        }

        public Criteria andChannel_typeIsNotNull() {
            addCriterion("`channel_type` is not null");
            return (Criteria) this;
        }

        public Criteria andChannel_typeEqualTo(Integer value) {
            addCriterion("`channel_type` =", value, "channel_type");
            return (Criteria) this;
        }

        public Criteria andChannel_typeNotEqualTo(Integer value) {
            addCriterion("`channel_type` <>", value, "channel_type");
            return (Criteria) this;
        }

        public Criteria andChannel_typeGreaterThan(Integer value) {
            addCriterion("`channel_type` >", value, "channel_type");
            return (Criteria) this;
        }

        public Criteria andChannel_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("`channel_type` >=", value, "channel_type");
            return (Criteria) this;
        }

        public Criteria andChannel_typeLessThan(Integer value) {
            addCriterion("`channel_type` <", value, "channel_type");
            return (Criteria) this;
        }

        public Criteria andChannel_typeLessThanOrEqualTo(Integer value) {
            addCriterion("`channel_type` <=", value, "channel_type");
            return (Criteria) this;
        }

        public Criteria andChannel_typeIn(List<Integer> values) {
            addCriterion("`channel_type` in", values, "channel_type");
            return (Criteria) this;
        }

        public Criteria andChannel_typeNotIn(List<Integer> values) {
            addCriterion("`channel_type` not in", values, "channel_type");
            return (Criteria) this;
        }

        public Criteria andChannel_typeBetween(Integer value1, Integer value2) {
            addCriterion("`channel_type` between", value1, value2, "channel_type");
            return (Criteria) this;
        }

        public Criteria andChannel_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("`channel_type` not between", value1, value2, "channel_type");
            return (Criteria) this;
        }

        public Criteria andJieru_wayIsNull() {
            addCriterion("`jieru_way` is null");
            return (Criteria) this;
        }

        public Criteria andJieru_wayIsNotNull() {
            addCriterion("`jieru_way` is not null");
            return (Criteria) this;
        }

        public Criteria andJieru_wayEqualTo(String value) {
            addCriterion("`jieru_way` =", value, "jieru_way");
            return (Criteria) this;
        }

        public Criteria andJieru_wayNotEqualTo(String value) {
            addCriterion("`jieru_way` <>", value, "jieru_way");
            return (Criteria) this;
        }

        public Criteria andJieru_wayGreaterThan(String value) {
            addCriterion("`jieru_way` >", value, "jieru_way");
            return (Criteria) this;
        }

        public Criteria andJieru_wayGreaterThanOrEqualTo(String value) {
            addCriterion("`jieru_way` >=", value, "jieru_way");
            return (Criteria) this;
        }

        public Criteria andJieru_wayLessThan(String value) {
            addCriterion("`jieru_way` <", value, "jieru_way");
            return (Criteria) this;
        }

        public Criteria andJieru_wayLessThanOrEqualTo(String value) {
            addCriterion("`jieru_way` <=", value, "jieru_way");
            return (Criteria) this;
        }

        public Criteria andJieru_wayLike(String value) {
            addCriterion("`jieru_way` like", value, "jieru_way");
            return (Criteria) this;
        }

        public Criteria andJieru_wayNotLike(String value) {
            addCriterion("`jieru_way` not like", value, "jieru_way");
            return (Criteria) this;
        }

        public Criteria andJieru_wayIn(List<String> values) {
            addCriterion("`jieru_way` in", values, "jieru_way");
            return (Criteria) this;
        }

        public Criteria andJieru_wayNotIn(List<String> values) {
            addCriterion("`jieru_way` not in", values, "jieru_way");
            return (Criteria) this;
        }

        public Criteria andJieru_wayBetween(String value1, String value2) {
            addCriterion("`jieru_way` between", value1, value2, "jieru_way");
            return (Criteria) this;
        }

        public Criteria andJieru_wayNotBetween(String value1, String value2) {
            addCriterion("`jieru_way` not between", value1, value2, "jieru_way");
            return (Criteria) this;
        }

        public Criteria andMeiti_typeIsNull() {
            addCriterion("`meiti_type` is null");
            return (Criteria) this;
        }

        public Criteria andMeiti_typeIsNotNull() {
            addCriterion("`meiti_type` is not null");
            return (Criteria) this;
        }

        public Criteria andMeiti_typeEqualTo(String value) {
            addCriterion("`meiti_type` =", value, "meiti_type");
            return (Criteria) this;
        }

        public Criteria andMeiti_typeNotEqualTo(String value) {
            addCriterion("`meiti_type` <>", value, "meiti_type");
            return (Criteria) this;
        }

        public Criteria andMeiti_typeGreaterThan(String value) {
            addCriterion("`meiti_type` >", value, "meiti_type");
            return (Criteria) this;
        }

        public Criteria andMeiti_typeGreaterThanOrEqualTo(String value) {
            addCriterion("`meiti_type` >=", value, "meiti_type");
            return (Criteria) this;
        }

        public Criteria andMeiti_typeLessThan(String value) {
            addCriterion("`meiti_type` <", value, "meiti_type");
            return (Criteria) this;
        }

        public Criteria andMeiti_typeLessThanOrEqualTo(String value) {
            addCriterion("`meiti_type` <=", value, "meiti_type");
            return (Criteria) this;
        }

        public Criteria andMeiti_typeLike(String value) {
            addCriterion("`meiti_type` like", value, "meiti_type");
            return (Criteria) this;
        }

        public Criteria andMeiti_typeNotLike(String value) {
            addCriterion("`meiti_type` not like", value, "meiti_type");
            return (Criteria) this;
        }

        public Criteria andMeiti_typeIn(List<String> values) {
            addCriterion("`meiti_type` in", values, "meiti_type");
            return (Criteria) this;
        }

        public Criteria andMeiti_typeNotIn(List<String> values) {
            addCriterion("`meiti_type` not in", values, "meiti_type");
            return (Criteria) this;
        }

        public Criteria andMeiti_typeBetween(String value1, String value2) {
            addCriterion("`meiti_type` between", value1, value2, "meiti_type");
            return (Criteria) this;
        }

        public Criteria andMeiti_typeNotBetween(String value1, String value2) {
            addCriterion("`meiti_type` not between", value1, value2, "meiti_type");
            return (Criteria) this;
        }

        public Criteria andMeiti_pwdIsNull() {
            addCriterion("`meiti_pwd` is null");
            return (Criteria) this;
        }

        public Criteria andMeiti_pwdIsNotNull() {
            addCriterion("`meiti_pwd` is not null");
            return (Criteria) this;
        }

        public Criteria andMeiti_pwdEqualTo(String value) {
            addCriterion("`meiti_pwd` =", value, "meiti_pwd");
            return (Criteria) this;
        }

        public Criteria andMeiti_pwdNotEqualTo(String value) {
            addCriterion("`meiti_pwd` <>", value, "meiti_pwd");
            return (Criteria) this;
        }

        public Criteria andMeiti_pwdGreaterThan(String value) {
            addCriterion("`meiti_pwd` >", value, "meiti_pwd");
            return (Criteria) this;
        }

        public Criteria andMeiti_pwdGreaterThanOrEqualTo(String value) {
            addCriterion("`meiti_pwd` >=", value, "meiti_pwd");
            return (Criteria) this;
        }

        public Criteria andMeiti_pwdLessThan(String value) {
            addCriterion("`meiti_pwd` <", value, "meiti_pwd");
            return (Criteria) this;
        }

        public Criteria andMeiti_pwdLessThanOrEqualTo(String value) {
            addCriterion("`meiti_pwd` <=", value, "meiti_pwd");
            return (Criteria) this;
        }

        public Criteria andMeiti_pwdLike(String value) {
            addCriterion("`meiti_pwd` like", value, "meiti_pwd");
            return (Criteria) this;
        }

        public Criteria andMeiti_pwdNotLike(String value) {
            addCriterion("`meiti_pwd` not like", value, "meiti_pwd");
            return (Criteria) this;
        }

        public Criteria andMeiti_pwdIn(List<String> values) {
            addCriterion("`meiti_pwd` in", values, "meiti_pwd");
            return (Criteria) this;
        }

        public Criteria andMeiti_pwdNotIn(List<String> values) {
            addCriterion("`meiti_pwd` not in", values, "meiti_pwd");
            return (Criteria) this;
        }

        public Criteria andMeiti_pwdBetween(String value1, String value2) {
            addCriterion("`meiti_pwd` between", value1, value2, "meiti_pwd");
            return (Criteria) this;
        }

        public Criteria andMeiti_pwdNotBetween(String value1, String value2) {
            addCriterion("`meiti_pwd` not between", value1, value2, "meiti_pwd");
            return (Criteria) this;
        }

        public Criteria andMeiti_accountIsNull() {
            addCriterion("`meiti_account` is null");
            return (Criteria) this;
        }

        public Criteria andMeiti_accountIsNotNull() {
            addCriterion("`meiti_account` is not null");
            return (Criteria) this;
        }

        public Criteria andMeiti_accountEqualTo(String value) {
            addCriterion("`meiti_account` =", value, "meiti_account");
            return (Criteria) this;
        }

        public Criteria andMeiti_accountNotEqualTo(String value) {
            addCriterion("`meiti_account` <>", value, "meiti_account");
            return (Criteria) this;
        }

        public Criteria andMeiti_accountGreaterThan(String value) {
            addCriterion("`meiti_account` >", value, "meiti_account");
            return (Criteria) this;
        }

        public Criteria andMeiti_accountGreaterThanOrEqualTo(String value) {
            addCriterion("`meiti_account` >=", value, "meiti_account");
            return (Criteria) this;
        }

        public Criteria andMeiti_accountLessThan(String value) {
            addCriterion("`meiti_account` <", value, "meiti_account");
            return (Criteria) this;
        }

        public Criteria andMeiti_accountLessThanOrEqualTo(String value) {
            addCriterion("`meiti_account` <=", value, "meiti_account");
            return (Criteria) this;
        }

        public Criteria andMeiti_accountLike(String value) {
            addCriterion("`meiti_account` like", value, "meiti_account");
            return (Criteria) this;
        }

        public Criteria andMeiti_accountNotLike(String value) {
            addCriterion("`meiti_account` not like", value, "meiti_account");
            return (Criteria) this;
        }

        public Criteria andMeiti_accountIn(List<String> values) {
            addCriterion("`meiti_account` in", values, "meiti_account");
            return (Criteria) this;
        }

        public Criteria andMeiti_accountNotIn(List<String> values) {
            addCriterion("`meiti_account` not in", values, "meiti_account");
            return (Criteria) this;
        }

        public Criteria andMeiti_accountBetween(String value1, String value2) {
            addCriterion("`meiti_account` between", value1, value2, "meiti_account");
            return (Criteria) this;
        }

        public Criteria andMeiti_accountNotBetween(String value1, String value2) {
            addCriterion("`meiti_account` not between", value1, value2, "meiti_account");
            return (Criteria) this;
        }

        public Criteria andAccount_idIsNull() {
            addCriterion("`account_id` is null");
            return (Criteria) this;
        }

        public Criteria andAccount_idIsNotNull() {
            addCriterion("`account_id` is not null");
            return (Criteria) this;
        }

        public Criteria andAccount_idEqualTo(String value) {
            addCriterion("`account_id` =", value, "account_id");
            return (Criteria) this;
        }

        public Criteria andAccount_idNotEqualTo(String value) {
            addCriterion("`account_id` <>", value, "account_id");
            return (Criteria) this;
        }

        public Criteria andAccount_idGreaterThan(String value) {
            addCriterion("`account_id` >", value, "account_id");
            return (Criteria) this;
        }

        public Criteria andAccount_idGreaterThanOrEqualTo(String value) {
            addCriterion("`account_id` >=", value, "account_id");
            return (Criteria) this;
        }

        public Criteria andAccount_idLessThan(String value) {
            addCriterion("`account_id` <", value, "account_id");
            return (Criteria) this;
        }

        public Criteria andAccount_idLessThanOrEqualTo(String value) {
            addCriterion("`account_id` <=", value, "account_id");
            return (Criteria) this;
        }

        public Criteria andAccount_idLike(String value) {
            addCriterion("`account_id` like", value, "account_id");
            return (Criteria) this;
        }

        public Criteria andAccount_idNotLike(String value) {
            addCriterion("`account_id` not like", value, "account_id");
            return (Criteria) this;
        }

        public Criteria andAccount_idIn(List<String> values) {
            addCriterion("`account_id` in", values, "account_id");
            return (Criteria) this;
        }

        public Criteria andAccount_idNotIn(List<String> values) {
            addCriterion("`account_id` not in", values, "account_id");
            return (Criteria) this;
        }

        public Criteria andAccount_idBetween(String value1, String value2) {
            addCriterion("`account_id` between", value1, value2, "account_id");
            return (Criteria) this;
        }

        public Criteria andAccount_idNotBetween(String value1, String value2) {
            addCriterion("`account_id` not between", value1, value2, "account_id");
            return (Criteria) this;
        }

        public Criteria andBank_cardIsNull() {
            addCriterion("`bank_card` is null");
            return (Criteria) this;
        }

        public Criteria andBank_cardIsNotNull() {
            addCriterion("`bank_card` is not null");
            return (Criteria) this;
        }

        public Criteria andBank_cardEqualTo(String value) {
            addCriterion("`bank_card` =", value, "bank_card");
            return (Criteria) this;
        }

        public Criteria andBank_cardNotEqualTo(String value) {
            addCriterion("`bank_card` <>", value, "bank_card");
            return (Criteria) this;
        }

        public Criteria andBank_cardGreaterThan(String value) {
            addCriterion("`bank_card` >", value, "bank_card");
            return (Criteria) this;
        }

        public Criteria andBank_cardGreaterThanOrEqualTo(String value) {
            addCriterion("`bank_card` >=", value, "bank_card");
            return (Criteria) this;
        }

        public Criteria andBank_cardLessThan(String value) {
            addCriterion("`bank_card` <", value, "bank_card");
            return (Criteria) this;
        }

        public Criteria andBank_cardLessThanOrEqualTo(String value) {
            addCriterion("`bank_card` <=", value, "bank_card");
            return (Criteria) this;
        }

        public Criteria andBank_cardLike(String value) {
            addCriterion("`bank_card` like", value, "bank_card");
            return (Criteria) this;
        }

        public Criteria andBank_cardNotLike(String value) {
            addCriterion("`bank_card` not like", value, "bank_card");
            return (Criteria) this;
        }

        public Criteria andBank_cardIn(List<String> values) {
            addCriterion("`bank_card` in", values, "bank_card");
            return (Criteria) this;
        }

        public Criteria andBank_cardNotIn(List<String> values) {
            addCriterion("`bank_card` not in", values, "bank_card");
            return (Criteria) this;
        }

        public Criteria andBank_cardBetween(String value1, String value2) {
            addCriterion("`bank_card` between", value1, value2, "bank_card");
            return (Criteria) this;
        }

        public Criteria andBank_cardNotBetween(String value1, String value2) {
            addCriterion("`bank_card` not between", value1, value2, "bank_card");
            return (Criteria) this;
        }

        public Criteria andOpen_bank_areaIsNull() {
            addCriterion("`open_bank_area` is null");
            return (Criteria) this;
        }

        public Criteria andOpen_bank_areaIsNotNull() {
            addCriterion("`open_bank_area` is not null");
            return (Criteria) this;
        }

        public Criteria andOpen_bank_areaEqualTo(String value) {
            addCriterion("`open_bank_area` =", value, "open_bank_area");
            return (Criteria) this;
        }

        public Criteria andOpen_bank_areaNotEqualTo(String value) {
            addCriterion("`open_bank_area` <>", value, "open_bank_area");
            return (Criteria) this;
        }

        public Criteria andOpen_bank_areaGreaterThan(String value) {
            addCriterion("`open_bank_area` >", value, "open_bank_area");
            return (Criteria) this;
        }

        public Criteria andOpen_bank_areaGreaterThanOrEqualTo(String value) {
            addCriterion("`open_bank_area` >=", value, "open_bank_area");
            return (Criteria) this;
        }

        public Criteria andOpen_bank_areaLessThan(String value) {
            addCriterion("`open_bank_area` <", value, "open_bank_area");
            return (Criteria) this;
        }

        public Criteria andOpen_bank_areaLessThanOrEqualTo(String value) {
            addCriterion("`open_bank_area` <=", value, "open_bank_area");
            return (Criteria) this;
        }

        public Criteria andOpen_bank_areaLike(String value) {
            addCriterion("`open_bank_area` like", value, "open_bank_area");
            return (Criteria) this;
        }

        public Criteria andOpen_bank_areaNotLike(String value) {
            addCriterion("`open_bank_area` not like", value, "open_bank_area");
            return (Criteria) this;
        }

        public Criteria andOpen_bank_areaIn(List<String> values) {
            addCriterion("`open_bank_area` in", values, "open_bank_area");
            return (Criteria) this;
        }

        public Criteria andOpen_bank_areaNotIn(List<String> values) {
            addCriterion("`open_bank_area` not in", values, "open_bank_area");
            return (Criteria) this;
        }

        public Criteria andOpen_bank_areaBetween(String value1, String value2) {
            addCriterion("`open_bank_area` between", value1, value2, "open_bank_area");
            return (Criteria) this;
        }

        public Criteria andOpen_bank_areaNotBetween(String value1, String value2) {
            addCriterion("`open_bank_area` not between", value1, value2, "open_bank_area");
            return (Criteria) this;
        }

        public Criteria andReal_nameIsNull() {
            addCriterion("`real_name` is null");
            return (Criteria) this;
        }

        public Criteria andReal_nameIsNotNull() {
            addCriterion("`real_name` is not null");
            return (Criteria) this;
        }

        public Criteria andReal_nameEqualTo(String value) {
            addCriterion("`real_name` =", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameNotEqualTo(String value) {
            addCriterion("`real_name` <>", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameGreaterThan(String value) {
            addCriterion("`real_name` >", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`real_name` >=", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameLessThan(String value) {
            addCriterion("`real_name` <", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameLessThanOrEqualTo(String value) {
            addCriterion("`real_name` <=", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameLike(String value) {
            addCriterion("`real_name` like", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameNotLike(String value) {
            addCriterion("`real_name` not like", value, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameIn(List<String> values) {
            addCriterion("`real_name` in", values, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameNotIn(List<String> values) {
            addCriterion("`real_name` not in", values, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameBetween(String value1, String value2) {
            addCriterion("`real_name` between", value1, value2, "real_name");
            return (Criteria) this;
        }

        public Criteria andReal_nameNotBetween(String value1, String value2) {
            addCriterion("`real_name` not between", value1, value2, "real_name");
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
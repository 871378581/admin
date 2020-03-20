package com.segama.ege.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MembershipcardBindCarLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public MembershipcardBindCarLogExample() {
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

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("`status` like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("`status` not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andGmt_bindIsNull() {
            addCriterion("`gmt_bind` is null");
            return (Criteria) this;
        }

        public Criteria andGmt_bindIsNotNull() {
            addCriterion("`gmt_bind` is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_bindEqualTo(Date value) {
            addCriterion("`gmt_bind` =", value, "gmt_bind");
            return (Criteria) this;
        }

        public Criteria andGmt_bindNotEqualTo(Date value) {
            addCriterion("`gmt_bind` <>", value, "gmt_bind");
            return (Criteria) this;
        }

        public Criteria andGmt_bindGreaterThan(Date value) {
            addCriterion("`gmt_bind` >", value, "gmt_bind");
            return (Criteria) this;
        }

        public Criteria andGmt_bindGreaterThanOrEqualTo(Date value) {
            addCriterion("`gmt_bind` >=", value, "gmt_bind");
            return (Criteria) this;
        }

        public Criteria andGmt_bindLessThan(Date value) {
            addCriterion("`gmt_bind` <", value, "gmt_bind");
            return (Criteria) this;
        }

        public Criteria andGmt_bindLessThanOrEqualTo(Date value) {
            addCriterion("`gmt_bind` <=", value, "gmt_bind");
            return (Criteria) this;
        }

        public Criteria andGmt_bindIn(List<Date> values) {
            addCriterion("`gmt_bind` in", values, "gmt_bind");
            return (Criteria) this;
        }

        public Criteria andGmt_bindNotIn(List<Date> values) {
            addCriterion("`gmt_bind` not in", values, "gmt_bind");
            return (Criteria) this;
        }

        public Criteria andGmt_bindBetween(Date value1, Date value2) {
            addCriterion("`gmt_bind` between", value1, value2, "gmt_bind");
            return (Criteria) this;
        }

        public Criteria andGmt_bindNotBetween(Date value1, Date value2) {
            addCriterion("`gmt_bind` not between", value1, value2, "gmt_bind");
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
package com.segama.ege.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WxUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public WxUserExample() {
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

        public Criteria andNick_nameIsNull() {
            addCriterion("`nick_name` is null");
            return (Criteria) this;
        }

        public Criteria andNick_nameIsNotNull() {
            addCriterion("`nick_name` is not null");
            return (Criteria) this;
        }

        public Criteria andNick_nameEqualTo(String value) {
            addCriterion("`nick_name` =", value, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameNotEqualTo(String value) {
            addCriterion("`nick_name` <>", value, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameGreaterThan(String value) {
            addCriterion("`nick_name` >", value, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`nick_name` >=", value, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameLessThan(String value) {
            addCriterion("`nick_name` <", value, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameLessThanOrEqualTo(String value) {
            addCriterion("`nick_name` <=", value, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameLike(String value) {
            addCriterion("`nick_name` like", value, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameNotLike(String value) {
            addCriterion("`nick_name` not like", value, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameIn(List<String> values) {
            addCriterion("`nick_name` in", values, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameNotIn(List<String> values) {
            addCriterion("`nick_name` not in", values, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameBetween(String value1, String value2) {
            addCriterion("`nick_name` between", value1, value2, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameNotBetween(String value1, String value2) {
            addCriterion("`nick_name` not between", value1, value2, "nick_name");
            return (Criteria) this;
        }

        public Criteria andUser_headIsNull() {
            addCriterion("`user_head` is null");
            return (Criteria) this;
        }

        public Criteria andUser_headIsNotNull() {
            addCriterion("`user_head` is not null");
            return (Criteria) this;
        }

        public Criteria andUser_headEqualTo(String value) {
            addCriterion("`user_head` =", value, "user_head");
            return (Criteria) this;
        }

        public Criteria andUser_headNotEqualTo(String value) {
            addCriterion("`user_head` <>", value, "user_head");
            return (Criteria) this;
        }

        public Criteria andUser_headGreaterThan(String value) {
            addCriterion("`user_head` >", value, "user_head");
            return (Criteria) this;
        }

        public Criteria andUser_headGreaterThanOrEqualTo(String value) {
            addCriterion("`user_head` >=", value, "user_head");
            return (Criteria) this;
        }

        public Criteria andUser_headLessThan(String value) {
            addCriterion("`user_head` <", value, "user_head");
            return (Criteria) this;
        }

        public Criteria andUser_headLessThanOrEqualTo(String value) {
            addCriterion("`user_head` <=", value, "user_head");
            return (Criteria) this;
        }

        public Criteria andUser_headLike(String value) {
            addCriterion("`user_head` like", value, "user_head");
            return (Criteria) this;
        }

        public Criteria andUser_headNotLike(String value) {
            addCriterion("`user_head` not like", value, "user_head");
            return (Criteria) this;
        }

        public Criteria andUser_headIn(List<String> values) {
            addCriterion("`user_head` in", values, "user_head");
            return (Criteria) this;
        }

        public Criteria andUser_headNotIn(List<String> values) {
            addCriterion("`user_head` not in", values, "user_head");
            return (Criteria) this;
        }

        public Criteria andUser_headBetween(String value1, String value2) {
            addCriterion("`user_head` between", value1, value2, "user_head");
            return (Criteria) this;
        }

        public Criteria andUser_headNotBetween(String value1, String value2) {
            addCriterion("`user_head` not between", value1, value2, "user_head");
            return (Criteria) this;
        }

        public Criteria andToken_idIsNull() {
            addCriterion("`token_id` is null");
            return (Criteria) this;
        }

        public Criteria andToken_idIsNotNull() {
            addCriterion("`token_id` is not null");
            return (Criteria) this;
        }

        public Criteria andToken_idEqualTo(String value) {
            addCriterion("`token_id` =", value, "token_id");
            return (Criteria) this;
        }

        public Criteria andToken_idNotEqualTo(String value) {
            addCriterion("`token_id` <>", value, "token_id");
            return (Criteria) this;
        }

        public Criteria andToken_idGreaterThan(String value) {
            addCriterion("`token_id` >", value, "token_id");
            return (Criteria) this;
        }

        public Criteria andToken_idGreaterThanOrEqualTo(String value) {
            addCriterion("`token_id` >=", value, "token_id");
            return (Criteria) this;
        }

        public Criteria andToken_idLessThan(String value) {
            addCriterion("`token_id` <", value, "token_id");
            return (Criteria) this;
        }

        public Criteria andToken_idLessThanOrEqualTo(String value) {
            addCriterion("`token_id` <=", value, "token_id");
            return (Criteria) this;
        }

        public Criteria andToken_idLike(String value) {
            addCriterion("`token_id` like", value, "token_id");
            return (Criteria) this;
        }

        public Criteria andToken_idNotLike(String value) {
            addCriterion("`token_id` not like", value, "token_id");
            return (Criteria) this;
        }

        public Criteria andToken_idIn(List<String> values) {
            addCriterion("`token_id` in", values, "token_id");
            return (Criteria) this;
        }

        public Criteria andToken_idNotIn(List<String> values) {
            addCriterion("`token_id` not in", values, "token_id");
            return (Criteria) this;
        }

        public Criteria andToken_idBetween(String value1, String value2) {
            addCriterion("`token_id` between", value1, value2, "token_id");
            return (Criteria) this;
        }

        public Criteria andToken_idNotBetween(String value1, String value2) {
            addCriterion("`token_id` not between", value1, value2, "token_id");
            return (Criteria) this;
        }

        public Criteria andUser_nameIsNull() {
            addCriterion("`user_name` is null");
            return (Criteria) this;
        }

        public Criteria andUser_nameIsNotNull() {
            addCriterion("`user_name` is not null");
            return (Criteria) this;
        }

        public Criteria andUser_nameEqualTo(String value) {
            addCriterion("`user_name` =", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameNotEqualTo(String value) {
            addCriterion("`user_name` <>", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameGreaterThan(String value) {
            addCriterion("`user_name` >", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`user_name` >=", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameLessThan(String value) {
            addCriterion("`user_name` <", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameLessThanOrEqualTo(String value) {
            addCriterion("`user_name` <=", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameLike(String value) {
            addCriterion("`user_name` like", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameNotLike(String value) {
            addCriterion("`user_name` not like", value, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameIn(List<String> values) {
            addCriterion("`user_name` in", values, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameNotIn(List<String> values) {
            addCriterion("`user_name` not in", values, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameBetween(String value1, String value2) {
            addCriterion("`user_name` between", value1, value2, "user_name");
            return (Criteria) this;
        }

        public Criteria andUser_nameNotBetween(String value1, String value2) {
            addCriterion("`user_name` not between", value1, value2, "user_name");
            return (Criteria) this;
        }

        public Criteria andBirthIsNull() {
            addCriterion("`birth` is null");
            return (Criteria) this;
        }

        public Criteria andBirthIsNotNull() {
            addCriterion("`birth` is not null");
            return (Criteria) this;
        }

        public Criteria andBirthEqualTo(String value) {
            addCriterion("`birth` =", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthNotEqualTo(String value) {
            addCriterion("`birth` <>", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthGreaterThan(String value) {
            addCriterion("`birth` >", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthGreaterThanOrEqualTo(String value) {
            addCriterion("`birth` >=", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthLessThan(String value) {
            addCriterion("`birth` <", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthLessThanOrEqualTo(String value) {
            addCriterion("`birth` <=", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthLike(String value) {
            addCriterion("`birth` like", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthNotLike(String value) {
            addCriterion("`birth` not like", value, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthIn(List<String> values) {
            addCriterion("`birth` in", values, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthNotIn(List<String> values) {
            addCriterion("`birth` not in", values, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthBetween(String value1, String value2) {
            addCriterion("`birth` between", value1, value2, "birth");
            return (Criteria) this;
        }

        public Criteria andBirthNotBetween(String value1, String value2) {
            addCriterion("`birth` not between", value1, value2, "birth");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("`sex` is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("`sex` is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("`sex` =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("`sex` <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("`sex` >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("`sex` >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("`sex` <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("`sex` <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("`sex` like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("`sex` not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("`sex` in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("`sex` not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("`sex` between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("`sex` not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andId_cardIsNull() {
            addCriterion("`id_card` is null");
            return (Criteria) this;
        }

        public Criteria andId_cardIsNotNull() {
            addCriterion("`id_card` is not null");
            return (Criteria) this;
        }

        public Criteria andId_cardEqualTo(String value) {
            addCriterion("`id_card` =", value, "id_card");
            return (Criteria) this;
        }

        public Criteria andId_cardNotEqualTo(String value) {
            addCriterion("`id_card` <>", value, "id_card");
            return (Criteria) this;
        }

        public Criteria andId_cardGreaterThan(String value) {
            addCriterion("`id_card` >", value, "id_card");
            return (Criteria) this;
        }

        public Criteria andId_cardGreaterThanOrEqualTo(String value) {
            addCriterion("`id_card` >=", value, "id_card");
            return (Criteria) this;
        }

        public Criteria andId_cardLessThan(String value) {
            addCriterion("`id_card` <", value, "id_card");
            return (Criteria) this;
        }

        public Criteria andId_cardLessThanOrEqualTo(String value) {
            addCriterion("`id_card` <=", value, "id_card");
            return (Criteria) this;
        }

        public Criteria andId_cardLike(String value) {
            addCriterion("`id_card` like", value, "id_card");
            return (Criteria) this;
        }

        public Criteria andId_cardNotLike(String value) {
            addCriterion("`id_card` not like", value, "id_card");
            return (Criteria) this;
        }

        public Criteria andId_cardIn(List<String> values) {
            addCriterion("`id_card` in", values, "id_card");
            return (Criteria) this;
        }

        public Criteria andId_cardNotIn(List<String> values) {
            addCriterion("`id_card` not in", values, "id_card");
            return (Criteria) this;
        }

        public Criteria andId_cardBetween(String value1, String value2) {
            addCriterion("`id_card` between", value1, value2, "id_card");
            return (Criteria) this;
        }

        public Criteria andId_cardNotBetween(String value1, String value2) {
            addCriterion("`id_card` not between", value1, value2, "id_card");
            return (Criteria) this;
        }

        public Criteria andHas_bind_phoneIsNull() {
            addCriterion("`has_bind_phone` is null");
            return (Criteria) this;
        }

        public Criteria andHas_bind_phoneIsNotNull() {
            addCriterion("`has_bind_phone` is not null");
            return (Criteria) this;
        }

        public Criteria andHas_bind_phoneEqualTo(Boolean value) {
            addCriterion("`has_bind_phone` =", value, "has_bind_phone");
            return (Criteria) this;
        }

        public Criteria andHas_bind_phoneNotEqualTo(Boolean value) {
            addCriterion("`has_bind_phone` <>", value, "has_bind_phone");
            return (Criteria) this;
        }

        public Criteria andHas_bind_phoneGreaterThan(Boolean value) {
            addCriterion("`has_bind_phone` >", value, "has_bind_phone");
            return (Criteria) this;
        }

        public Criteria andHas_bind_phoneGreaterThanOrEqualTo(Boolean value) {
            addCriterion("`has_bind_phone` >=", value, "has_bind_phone");
            return (Criteria) this;
        }

        public Criteria andHas_bind_phoneLessThan(Boolean value) {
            addCriterion("`has_bind_phone` <", value, "has_bind_phone");
            return (Criteria) this;
        }

        public Criteria andHas_bind_phoneLessThanOrEqualTo(Boolean value) {
            addCriterion("`has_bind_phone` <=", value, "has_bind_phone");
            return (Criteria) this;
        }

        public Criteria andHas_bind_phoneIn(List<Boolean> values) {
            addCriterion("`has_bind_phone` in", values, "has_bind_phone");
            return (Criteria) this;
        }

        public Criteria andHas_bind_phoneNotIn(List<Boolean> values) {
            addCriterion("`has_bind_phone` not in", values, "has_bind_phone");
            return (Criteria) this;
        }

        public Criteria andHas_bind_phoneBetween(Boolean value1, Boolean value2) {
            addCriterion("`has_bind_phone` between", value1, value2, "has_bind_phone");
            return (Criteria) this;
        }

        public Criteria andHas_bind_phoneNotBetween(Boolean value1, Boolean value2) {
            addCriterion("`has_bind_phone` not between", value1, value2, "has_bind_phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("`phone` is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("`phone` is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("`phone` =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("`phone` <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("`phone` >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("`phone` >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("`phone` <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("`phone` <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("`phone` like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("`phone` not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("`phone` in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("`phone` not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("`phone` between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("`phone` not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andGmt_registerIsNull() {
            addCriterion("`gmt_register` is null");
            return (Criteria) this;
        }

        public Criteria andGmt_registerIsNotNull() {
            addCriterion("`gmt_register` is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_registerEqualTo(Date value) {
            addCriterion("`gmt_register` =", value, "gmt_register");
            return (Criteria) this;
        }

        public Criteria andGmt_registerNotEqualTo(Date value) {
            addCriterion("`gmt_register` <>", value, "gmt_register");
            return (Criteria) this;
        }

        public Criteria andGmt_registerGreaterThan(Date value) {
            addCriterion("`gmt_register` >", value, "gmt_register");
            return (Criteria) this;
        }

        public Criteria andGmt_registerGreaterThanOrEqualTo(Date value) {
            addCriterion("`gmt_register` >=", value, "gmt_register");
            return (Criteria) this;
        }

        public Criteria andGmt_registerLessThan(Date value) {
            addCriterion("`gmt_register` <", value, "gmt_register");
            return (Criteria) this;
        }

        public Criteria andGmt_registerLessThanOrEqualTo(Date value) {
            addCriterion("`gmt_register` <=", value, "gmt_register");
            return (Criteria) this;
        }

        public Criteria andGmt_registerIn(List<Date> values) {
            addCriterion("`gmt_register` in", values, "gmt_register");
            return (Criteria) this;
        }

        public Criteria andGmt_registerNotIn(List<Date> values) {
            addCriterion("`gmt_register` not in", values, "gmt_register");
            return (Criteria) this;
        }

        public Criteria andGmt_registerBetween(Date value1, Date value2) {
            addCriterion("`gmt_register` between", value1, value2, "gmt_register");
            return (Criteria) this;
        }

        public Criteria andGmt_registerNotBetween(Date value1, Date value2) {
            addCriterion("`gmt_register` not between", value1, value2, "gmt_register");
            return (Criteria) this;
        }

        public Criteria andPlace_cityIsNull() {
            addCriterion("`place_city` is null");
            return (Criteria) this;
        }

        public Criteria andPlace_cityIsNotNull() {
            addCriterion("`place_city` is not null");
            return (Criteria) this;
        }

        public Criteria andPlace_cityEqualTo(String value) {
            addCriterion("`place_city` =", value, "place_city");
            return (Criteria) this;
        }

        public Criteria andPlace_cityNotEqualTo(String value) {
            addCriterion("`place_city` <>", value, "place_city");
            return (Criteria) this;
        }

        public Criteria andPlace_cityGreaterThan(String value) {
            addCriterion("`place_city` >", value, "place_city");
            return (Criteria) this;
        }

        public Criteria andPlace_cityGreaterThanOrEqualTo(String value) {
            addCriterion("`place_city` >=", value, "place_city");
            return (Criteria) this;
        }

        public Criteria andPlace_cityLessThan(String value) {
            addCriterion("`place_city` <", value, "place_city");
            return (Criteria) this;
        }

        public Criteria andPlace_cityLessThanOrEqualTo(String value) {
            addCriterion("`place_city` <=", value, "place_city");
            return (Criteria) this;
        }

        public Criteria andPlace_cityLike(String value) {
            addCriterion("`place_city` like", value, "place_city");
            return (Criteria) this;
        }

        public Criteria andPlace_cityNotLike(String value) {
            addCriterion("`place_city` not like", value, "place_city");
            return (Criteria) this;
        }

        public Criteria andPlace_cityIn(List<String> values) {
            addCriterion("`place_city` in", values, "place_city");
            return (Criteria) this;
        }

        public Criteria andPlace_cityNotIn(List<String> values) {
            addCriterion("`place_city` not in", values, "place_city");
            return (Criteria) this;
        }

        public Criteria andPlace_cityBetween(String value1, String value2) {
            addCriterion("`place_city` between", value1, value2, "place_city");
            return (Criteria) this;
        }

        public Criteria andPlace_cityNotBetween(String value1, String value2) {
            addCriterion("`place_city` not between", value1, value2, "place_city");
            return (Criteria) this;
        }

        public Criteria andLast_longitudeIsNull() {
            addCriterion("`last_longitude` is null");
            return (Criteria) this;
        }

        public Criteria andLast_longitudeIsNotNull() {
            addCriterion("`last_longitude` is not null");
            return (Criteria) this;
        }

        public Criteria andLast_longitudeEqualTo(BigDecimal value) {
            addCriterion("`last_longitude` =", value, "last_longitude");
            return (Criteria) this;
        }

        public Criteria andLast_longitudeNotEqualTo(BigDecimal value) {
            addCriterion("`last_longitude` <>", value, "last_longitude");
            return (Criteria) this;
        }

        public Criteria andLast_longitudeGreaterThan(BigDecimal value) {
            addCriterion("`last_longitude` >", value, "last_longitude");
            return (Criteria) this;
        }

        public Criteria andLast_longitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("`last_longitude` >=", value, "last_longitude");
            return (Criteria) this;
        }

        public Criteria andLast_longitudeLessThan(BigDecimal value) {
            addCriterion("`last_longitude` <", value, "last_longitude");
            return (Criteria) this;
        }

        public Criteria andLast_longitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("`last_longitude` <=", value, "last_longitude");
            return (Criteria) this;
        }

        public Criteria andLast_longitudeIn(List<BigDecimal> values) {
            addCriterion("`last_longitude` in", values, "last_longitude");
            return (Criteria) this;
        }

        public Criteria andLast_longitudeNotIn(List<BigDecimal> values) {
            addCriterion("`last_longitude` not in", values, "last_longitude");
            return (Criteria) this;
        }

        public Criteria andLast_longitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`last_longitude` between", value1, value2, "last_longitude");
            return (Criteria) this;
        }

        public Criteria andLast_longitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`last_longitude` not between", value1, value2, "last_longitude");
            return (Criteria) this;
        }

        public Criteria andLast_latitudeIsNull() {
            addCriterion("`last_latitude` is null");
            return (Criteria) this;
        }

        public Criteria andLast_latitudeIsNotNull() {
            addCriterion("`last_latitude` is not null");
            return (Criteria) this;
        }

        public Criteria andLast_latitudeEqualTo(BigDecimal value) {
            addCriterion("`last_latitude` =", value, "last_latitude");
            return (Criteria) this;
        }

        public Criteria andLast_latitudeNotEqualTo(BigDecimal value) {
            addCriterion("`last_latitude` <>", value, "last_latitude");
            return (Criteria) this;
        }

        public Criteria andLast_latitudeGreaterThan(BigDecimal value) {
            addCriterion("`last_latitude` >", value, "last_latitude");
            return (Criteria) this;
        }

        public Criteria andLast_latitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("`last_latitude` >=", value, "last_latitude");
            return (Criteria) this;
        }

        public Criteria andLast_latitudeLessThan(BigDecimal value) {
            addCriterion("`last_latitude` <", value, "last_latitude");
            return (Criteria) this;
        }

        public Criteria andLast_latitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("`last_latitude` <=", value, "last_latitude");
            return (Criteria) this;
        }

        public Criteria andLast_latitudeIn(List<BigDecimal> values) {
            addCriterion("`last_latitude` in", values, "last_latitude");
            return (Criteria) this;
        }

        public Criteria andLast_latitudeNotIn(List<BigDecimal> values) {
            addCriterion("`last_latitude` not in", values, "last_latitude");
            return (Criteria) this;
        }

        public Criteria andLast_latitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`last_latitude` between", value1, value2, "last_latitude");
            return (Criteria) this;
        }

        public Criteria andLast_latitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`last_latitude` not between", value1, value2, "last_latitude");
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

        public Criteria andMembership_levelIsNull() {
            addCriterion("`membership_level` is null");
            return (Criteria) this;
        }

        public Criteria andMembership_levelIsNotNull() {
            addCriterion("`membership_level` is not null");
            return (Criteria) this;
        }

        public Criteria andMembership_levelEqualTo(String value) {
            addCriterion("`membership_level` =", value, "membership_level");
            return (Criteria) this;
        }

        public Criteria andMembership_levelNotEqualTo(String value) {
            addCriterion("`membership_level` <>", value, "membership_level");
            return (Criteria) this;
        }

        public Criteria andMembership_levelGreaterThan(String value) {
            addCriterion("`membership_level` >", value, "membership_level");
            return (Criteria) this;
        }

        public Criteria andMembership_levelGreaterThanOrEqualTo(String value) {
            addCriterion("`membership_level` >=", value, "membership_level");
            return (Criteria) this;
        }

        public Criteria andMembership_levelLessThan(String value) {
            addCriterion("`membership_level` <", value, "membership_level");
            return (Criteria) this;
        }

        public Criteria andMembership_levelLessThanOrEqualTo(String value) {
            addCriterion("`membership_level` <=", value, "membership_level");
            return (Criteria) this;
        }

        public Criteria andMembership_levelLike(String value) {
            addCriterion("`membership_level` like", value, "membership_level");
            return (Criteria) this;
        }

        public Criteria andMembership_levelNotLike(String value) {
            addCriterion("`membership_level` not like", value, "membership_level");
            return (Criteria) this;
        }

        public Criteria andMembership_levelIn(List<String> values) {
            addCriterion("`membership_level` in", values, "membership_level");
            return (Criteria) this;
        }

        public Criteria andMembership_levelNotIn(List<String> values) {
            addCriterion("`membership_level` not in", values, "membership_level");
            return (Criteria) this;
        }

        public Criteria andMembership_levelBetween(String value1, String value2) {
            addCriterion("`membership_level` between", value1, value2, "membership_level");
            return (Criteria) this;
        }

        public Criteria andMembership_levelNotBetween(String value1, String value2) {
            addCriterion("`membership_level` not between", value1, value2, "membership_level");
            return (Criteria) this;
        }

        public Criteria andJobIsNull() {
            addCriterion("`job` is null");
            return (Criteria) this;
        }

        public Criteria andJobIsNotNull() {
            addCriterion("`job` is not null");
            return (Criteria) this;
        }

        public Criteria andJobEqualTo(String value) {
            addCriterion("`job` =", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotEqualTo(String value) {
            addCriterion("`job` <>", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThan(String value) {
            addCriterion("`job` >", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThanOrEqualTo(String value) {
            addCriterion("`job` >=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThan(String value) {
            addCriterion("`job` <", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThanOrEqualTo(String value) {
            addCriterion("`job` <=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLike(String value) {
            addCriterion("`job` like", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotLike(String value) {
            addCriterion("`job` not like", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobIn(List<String> values) {
            addCriterion("`job` in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotIn(List<String> values) {
            addCriterion("`job` not in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobBetween(String value1, String value2) {
            addCriterion("`job` between", value1, value2, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotBetween(String value1, String value2) {
            addCriterion("`job` not between", value1, value2, "job");
            return (Criteria) this;
        }

        public Criteria andCode_expired_atIsNull() {
            addCriterion("`code_expired_at` is null");
            return (Criteria) this;
        }

        public Criteria andCode_expired_atIsNotNull() {
            addCriterion("`code_expired_at` is not null");
            return (Criteria) this;
        }

        public Criteria andCode_expired_atEqualTo(Date value) {
            addCriterion("`code_expired_at` =", value, "code_expired_at");
            return (Criteria) this;
        }

        public Criteria andCode_expired_atNotEqualTo(Date value) {
            addCriterion("`code_expired_at` <>", value, "code_expired_at");
            return (Criteria) this;
        }

        public Criteria andCode_expired_atGreaterThan(Date value) {
            addCriterion("`code_expired_at` >", value, "code_expired_at");
            return (Criteria) this;
        }

        public Criteria andCode_expired_atGreaterThanOrEqualTo(Date value) {
            addCriterion("`code_expired_at` >=", value, "code_expired_at");
            return (Criteria) this;
        }

        public Criteria andCode_expired_atLessThan(Date value) {
            addCriterion("`code_expired_at` <", value, "code_expired_at");
            return (Criteria) this;
        }

        public Criteria andCode_expired_atLessThanOrEqualTo(Date value) {
            addCriterion("`code_expired_at` <=", value, "code_expired_at");
            return (Criteria) this;
        }

        public Criteria andCode_expired_atIn(List<Date> values) {
            addCriterion("`code_expired_at` in", values, "code_expired_at");
            return (Criteria) this;
        }

        public Criteria andCode_expired_atNotIn(List<Date> values) {
            addCriterion("`code_expired_at` not in", values, "code_expired_at");
            return (Criteria) this;
        }

        public Criteria andCode_expired_atBetween(Date value1, Date value2) {
            addCriterion("`code_expired_at` between", value1, value2, "code_expired_at");
            return (Criteria) this;
        }

        public Criteria andCode_expired_atNotBetween(Date value1, Date value2) {
            addCriterion("`code_expired_at` not between", value1, value2, "code_expired_at");
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

        public Criteria andDefault_plateIsNull() {
            addCriterion("`default_plate` is null");
            return (Criteria) this;
        }

        public Criteria andDefault_plateIsNotNull() {
            addCriterion("`default_plate` is not null");
            return (Criteria) this;
        }

        public Criteria andDefault_plateEqualTo(String value) {
            addCriterion("`default_plate` =", value, "default_plate");
            return (Criteria) this;
        }

        public Criteria andDefault_plateNotEqualTo(String value) {
            addCriterion("`default_plate` <>", value, "default_plate");
            return (Criteria) this;
        }

        public Criteria andDefault_plateGreaterThan(String value) {
            addCriterion("`default_plate` >", value, "default_plate");
            return (Criteria) this;
        }

        public Criteria andDefault_plateGreaterThanOrEqualTo(String value) {
            addCriterion("`default_plate` >=", value, "default_plate");
            return (Criteria) this;
        }

        public Criteria andDefault_plateLessThan(String value) {
            addCriterion("`default_plate` <", value, "default_plate");
            return (Criteria) this;
        }

        public Criteria andDefault_plateLessThanOrEqualTo(String value) {
            addCriterion("`default_plate` <=", value, "default_plate");
            return (Criteria) this;
        }

        public Criteria andDefault_plateLike(String value) {
            addCriterion("`default_plate` like", value, "default_plate");
            return (Criteria) this;
        }

        public Criteria andDefault_plateNotLike(String value) {
            addCriterion("`default_plate` not like", value, "default_plate");
            return (Criteria) this;
        }

        public Criteria andDefault_plateIn(List<String> values) {
            addCriterion("`default_plate` in", values, "default_plate");
            return (Criteria) this;
        }

        public Criteria andDefault_plateNotIn(List<String> values) {
            addCriterion("`default_plate` not in", values, "default_plate");
            return (Criteria) this;
        }

        public Criteria andDefault_plateBetween(String value1, String value2) {
            addCriterion("`default_plate` between", value1, value2, "default_plate");
            return (Criteria) this;
        }

        public Criteria andDefault_plateNotBetween(String value1, String value2) {
            addCriterion("`default_plate` not between", value1, value2, "default_plate");
            return (Criteria) this;
        }

        public Criteria andDefault_car_tyeIsNull() {
            addCriterion("`default_car_tye` is null");
            return (Criteria) this;
        }

        public Criteria andDefault_car_tyeIsNotNull() {
            addCriterion("`default_car_tye` is not null");
            return (Criteria) this;
        }

        public Criteria andDefault_car_tyeEqualTo(String value) {
            addCriterion("`default_car_tye` =", value, "default_car_tye");
            return (Criteria) this;
        }

        public Criteria andDefault_car_tyeNotEqualTo(String value) {
            addCriterion("`default_car_tye` <>", value, "default_car_tye");
            return (Criteria) this;
        }

        public Criteria andDefault_car_tyeGreaterThan(String value) {
            addCriterion("`default_car_tye` >", value, "default_car_tye");
            return (Criteria) this;
        }

        public Criteria andDefault_car_tyeGreaterThanOrEqualTo(String value) {
            addCriterion("`default_car_tye` >=", value, "default_car_tye");
            return (Criteria) this;
        }

        public Criteria andDefault_car_tyeLessThan(String value) {
            addCriterion("`default_car_tye` <", value, "default_car_tye");
            return (Criteria) this;
        }

        public Criteria andDefault_car_tyeLessThanOrEqualTo(String value) {
            addCriterion("`default_car_tye` <=", value, "default_car_tye");
            return (Criteria) this;
        }

        public Criteria andDefault_car_tyeLike(String value) {
            addCriterion("`default_car_tye` like", value, "default_car_tye");
            return (Criteria) this;
        }

        public Criteria andDefault_car_tyeNotLike(String value) {
            addCriterion("`default_car_tye` not like", value, "default_car_tye");
            return (Criteria) this;
        }

        public Criteria andDefault_car_tyeIn(List<String> values) {
            addCriterion("`default_car_tye` in", values, "default_car_tye");
            return (Criteria) this;
        }

        public Criteria andDefault_car_tyeNotIn(List<String> values) {
            addCriterion("`default_car_tye` not in", values, "default_car_tye");
            return (Criteria) this;
        }

        public Criteria andDefault_car_tyeBetween(String value1, String value2) {
            addCriterion("`default_car_tye` between", value1, value2, "default_car_tye");
            return (Criteria) this;
        }

        public Criteria andDefault_car_tyeNotBetween(String value1, String value2) {
            addCriterion("`default_car_tye` not between", value1, value2, "default_car_tye");
            return (Criteria) this;
        }

        public Criteria andHas_default_carIsNull() {
            addCriterion("`has_default_car` is null");
            return (Criteria) this;
        }

        public Criteria andHas_default_carIsNotNull() {
            addCriterion("`has_default_car` is not null");
            return (Criteria) this;
        }

        public Criteria andHas_default_carEqualTo(Boolean value) {
            addCriterion("`has_default_car` =", value, "has_default_car");
            return (Criteria) this;
        }

        public Criteria andHas_default_carNotEqualTo(Boolean value) {
            addCriterion("`has_default_car` <>", value, "has_default_car");
            return (Criteria) this;
        }

        public Criteria andHas_default_carGreaterThan(Boolean value) {
            addCriterion("`has_default_car` >", value, "has_default_car");
            return (Criteria) this;
        }

        public Criteria andHas_default_carGreaterThanOrEqualTo(Boolean value) {
            addCriterion("`has_default_car` >=", value, "has_default_car");
            return (Criteria) this;
        }

        public Criteria andHas_default_carLessThan(Boolean value) {
            addCriterion("`has_default_car` <", value, "has_default_car");
            return (Criteria) this;
        }

        public Criteria andHas_default_carLessThanOrEqualTo(Boolean value) {
            addCriterion("`has_default_car` <=", value, "has_default_car");
            return (Criteria) this;
        }

        public Criteria andHas_default_carIn(List<Boolean> values) {
            addCriterion("`has_default_car` in", values, "has_default_car");
            return (Criteria) this;
        }

        public Criteria andHas_default_carNotIn(List<Boolean> values) {
            addCriterion("`has_default_car` not in", values, "has_default_car");
            return (Criteria) this;
        }

        public Criteria andHas_default_carBetween(Boolean value1, Boolean value2) {
            addCriterion("`has_default_car` between", value1, value2, "has_default_car");
            return (Criteria) this;
        }

        public Criteria andHas_default_carNotBetween(Boolean value1, Boolean value2) {
            addCriterion("`has_default_car` not between", value1, value2, "has_default_car");
            return (Criteria) this;
        }

        public Criteria andCard_levelIsNull() {
            addCriterion("`card_level` is null");
            return (Criteria) this;
        }

        public Criteria andCard_levelIsNotNull() {
            addCriterion("`card_level` is not null");
            return (Criteria) this;
        }

        public Criteria andCard_levelEqualTo(String value) {
            addCriterion("`card_level` =", value, "card_level");
            return (Criteria) this;
        }

        public Criteria andCard_levelNotEqualTo(String value) {
            addCriterion("`card_level` <>", value, "card_level");
            return (Criteria) this;
        }

        public Criteria andCard_levelGreaterThan(String value) {
            addCriterion("`card_level` >", value, "card_level");
            return (Criteria) this;
        }

        public Criteria andCard_levelGreaterThanOrEqualTo(String value) {
            addCriterion("`card_level` >=", value, "card_level");
            return (Criteria) this;
        }

        public Criteria andCard_levelLessThan(String value) {
            addCriterion("`card_level` <", value, "card_level");
            return (Criteria) this;
        }

        public Criteria andCard_levelLessThanOrEqualTo(String value) {
            addCriterion("`card_level` <=", value, "card_level");
            return (Criteria) this;
        }

        public Criteria andCard_levelLike(String value) {
            addCriterion("`card_level` like", value, "card_level");
            return (Criteria) this;
        }

        public Criteria andCard_levelNotLike(String value) {
            addCriterion("`card_level` not like", value, "card_level");
            return (Criteria) this;
        }

        public Criteria andCard_levelIn(List<String> values) {
            addCriterion("`card_level` in", values, "card_level");
            return (Criteria) this;
        }

        public Criteria andCard_levelNotIn(List<String> values) {
            addCriterion("`card_level` not in", values, "card_level");
            return (Criteria) this;
        }

        public Criteria andCard_levelBetween(String value1, String value2) {
            addCriterion("`card_level` between", value1, value2, "card_level");
            return (Criteria) this;
        }

        public Criteria andCard_levelNotBetween(String value1, String value2) {
            addCriterion("`card_level` not between", value1, value2, "card_level");
            return (Criteria) this;
        }

        public Criteria andCapital_account_idIsNull() {
            addCriterion("`capital_account_id` is null");
            return (Criteria) this;
        }

        public Criteria andCapital_account_idIsNotNull() {
            addCriterion("`capital_account_id` is not null");
            return (Criteria) this;
        }

        public Criteria andCapital_account_idEqualTo(Long value) {
            addCriterion("`capital_account_id` =", value, "capital_account_id");
            return (Criteria) this;
        }

        public Criteria andCapital_account_idNotEqualTo(Long value) {
            addCriterion("`capital_account_id` <>", value, "capital_account_id");
            return (Criteria) this;
        }

        public Criteria andCapital_account_idGreaterThan(Long value) {
            addCriterion("`capital_account_id` >", value, "capital_account_id");
            return (Criteria) this;
        }

        public Criteria andCapital_account_idGreaterThanOrEqualTo(Long value) {
            addCriterion("`capital_account_id` >=", value, "capital_account_id");
            return (Criteria) this;
        }

        public Criteria andCapital_account_idLessThan(Long value) {
            addCriterion("`capital_account_id` <", value, "capital_account_id");
            return (Criteria) this;
        }

        public Criteria andCapital_account_idLessThanOrEqualTo(Long value) {
            addCriterion("`capital_account_id` <=", value, "capital_account_id");
            return (Criteria) this;
        }

        public Criteria andCapital_account_idIn(List<Long> values) {
            addCriterion("`capital_account_id` in", values, "capital_account_id");
            return (Criteria) this;
        }

        public Criteria andCapital_account_idNotIn(List<Long> values) {
            addCriterion("`capital_account_id` not in", values, "capital_account_id");
            return (Criteria) this;
        }

        public Criteria andCapital_account_idBetween(Long value1, Long value2) {
            addCriterion("`capital_account_id` between", value1, value2, "capital_account_id");
            return (Criteria) this;
        }

        public Criteria andCapital_account_idNotBetween(Long value1, Long value2) {
            addCriterion("`capital_account_id` not between", value1, value2, "capital_account_id");
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

        public Criteria andCapital_account_strIsNull() {
            addCriterion("`capital_account_str` is null");
            return (Criteria) this;
        }

        public Criteria andCapital_account_strIsNotNull() {
            addCriterion("`capital_account_str` is not null");
            return (Criteria) this;
        }

        public Criteria andCapital_account_strEqualTo(String value) {
            addCriterion("`capital_account_str` =", value, "capital_account_str");
            return (Criteria) this;
        }

        public Criteria andCapital_account_strNotEqualTo(String value) {
            addCriterion("`capital_account_str` <>", value, "capital_account_str");
            return (Criteria) this;
        }

        public Criteria andCapital_account_strGreaterThan(String value) {
            addCriterion("`capital_account_str` >", value, "capital_account_str");
            return (Criteria) this;
        }

        public Criteria andCapital_account_strGreaterThanOrEqualTo(String value) {
            addCriterion("`capital_account_str` >=", value, "capital_account_str");
            return (Criteria) this;
        }

        public Criteria andCapital_account_strLessThan(String value) {
            addCriterion("`capital_account_str` <", value, "capital_account_str");
            return (Criteria) this;
        }

        public Criteria andCapital_account_strLessThanOrEqualTo(String value) {
            addCriterion("`capital_account_str` <=", value, "capital_account_str");
            return (Criteria) this;
        }

        public Criteria andCapital_account_strLike(String value) {
            addCriterion("`capital_account_str` like", value, "capital_account_str");
            return (Criteria) this;
        }

        public Criteria andCapital_account_strNotLike(String value) {
            addCriterion("`capital_account_str` not like", value, "capital_account_str");
            return (Criteria) this;
        }

        public Criteria andCapital_account_strIn(List<String> values) {
            addCriterion("`capital_account_str` in", values, "capital_account_str");
            return (Criteria) this;
        }

        public Criteria andCapital_account_strNotIn(List<String> values) {
            addCriterion("`capital_account_str` not in", values, "capital_account_str");
            return (Criteria) this;
        }

        public Criteria andCapital_account_strBetween(String value1, String value2) {
            addCriterion("`capital_account_str` between", value1, value2, "capital_account_str");
            return (Criteria) this;
        }

        public Criteria andCapital_account_strNotBetween(String value1, String value2) {
            addCriterion("`capital_account_str` not between", value1, value2, "capital_account_str");
            return (Criteria) this;
        }

        public Criteria andUser_typeIsNull() {
            addCriterion("`user_type` is null");
            return (Criteria) this;
        }

        public Criteria andUser_typeIsNotNull() {
            addCriterion("`user_type` is not null");
            return (Criteria) this;
        }

        public Criteria andUser_typeEqualTo(Integer value) {
            addCriterion("`user_type` =", value, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeNotEqualTo(Integer value) {
            addCriterion("`user_type` <>", value, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeGreaterThan(Integer value) {
            addCriterion("`user_type` >", value, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("`user_type` >=", value, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeLessThan(Integer value) {
            addCriterion("`user_type` <", value, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeLessThanOrEqualTo(Integer value) {
            addCriterion("`user_type` <=", value, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeIn(List<Integer> values) {
            addCriterion("`user_type` in", values, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeNotIn(List<Integer> values) {
            addCriterion("`user_type` not in", values, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeBetween(Integer value1, Integer value2) {
            addCriterion("`user_type` between", value1, value2, "user_type");
            return (Criteria) this;
        }

        public Criteria andUser_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("`user_type` not between", value1, value2, "user_type");
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
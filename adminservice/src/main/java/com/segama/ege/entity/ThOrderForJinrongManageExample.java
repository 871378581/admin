package com.segama.ege.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThOrderForJinrongManageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public ThOrderForJinrongManageExample() {
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

        public Criteria andOperate_typeIsNull() {
            addCriterion("`operate_type` is null");
            return (Criteria) this;
        }

        public Criteria andOperate_typeIsNotNull() {
            addCriterion("`operate_type` is not null");
            return (Criteria) this;
        }

        public Criteria andOperate_typeEqualTo(String value) {
            addCriterion("`operate_type` =", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeNotEqualTo(String value) {
            addCriterion("`operate_type` <>", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeGreaterThan(String value) {
            addCriterion("`operate_type` >", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeGreaterThanOrEqualTo(String value) {
            addCriterion("`operate_type` >=", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeLessThan(String value) {
            addCriterion("`operate_type` <", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeLessThanOrEqualTo(String value) {
            addCriterion("`operate_type` <=", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeLike(String value) {
            addCriterion("`operate_type` like", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeNotLike(String value) {
            addCriterion("`operate_type` not like", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeIn(List<String> values) {
            addCriterion("`operate_type` in", values, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeNotIn(List<String> values) {
            addCriterion("`operate_type` not in", values, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeBetween(String value1, String value2) {
            addCriterion("`operate_type` between", value1, value2, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeNotBetween(String value1, String value2) {
            addCriterion("`operate_type` not between", value1, value2, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOrder_codeIsNull() {
            addCriterion("`order_code` is null");
            return (Criteria) this;
        }

        public Criteria andOrder_codeIsNotNull() {
            addCriterion("`order_code` is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_codeEqualTo(String value) {
            addCriterion("`order_code` =", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeNotEqualTo(String value) {
            addCriterion("`order_code` <>", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeGreaterThan(String value) {
            addCriterion("`order_code` >", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeGreaterThanOrEqualTo(String value) {
            addCriterion("`order_code` >=", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeLessThan(String value) {
            addCriterion("`order_code` <", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeLessThanOrEqualTo(String value) {
            addCriterion("`order_code` <=", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeLike(String value) {
            addCriterion("`order_code` like", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeNotLike(String value) {
            addCriterion("`order_code` not like", value, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeIn(List<String> values) {
            addCriterion("`order_code` in", values, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeNotIn(List<String> values) {
            addCriterion("`order_code` not in", values, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeBetween(String value1, String value2) {
            addCriterion("`order_code` between", value1, value2, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_codeNotBetween(String value1, String value2) {
            addCriterion("`order_code` not between", value1, value2, "order_code");
            return (Criteria) this;
        }

        public Criteria andOrder_timeIsNull() {
            addCriterion("`order_time` is null");
            return (Criteria) this;
        }

        public Criteria andOrder_timeIsNotNull() {
            addCriterion("`order_time` is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_timeEqualTo(String value) {
            addCriterion("`order_time` =", value, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeNotEqualTo(String value) {
            addCriterion("`order_time` <>", value, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeGreaterThan(String value) {
            addCriterion("`order_time` >", value, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeGreaterThanOrEqualTo(String value) {
            addCriterion("`order_time` >=", value, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeLessThan(String value) {
            addCriterion("`order_time` <", value, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeLessThanOrEqualTo(String value) {
            addCriterion("`order_time` <=", value, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeLike(String value) {
            addCriterion("`order_time` like", value, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeNotLike(String value) {
            addCriterion("`order_time` not like", value, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeIn(List<String> values) {
            addCriterion("`order_time` in", values, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeNotIn(List<String> values) {
            addCriterion("`order_time` not in", values, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeBetween(String value1, String value2) {
            addCriterion("`order_time` between", value1, value2, "order_time");
            return (Criteria) this;
        }

        public Criteria andOrder_timeNotBetween(String value1, String value2) {
            addCriterion("`order_time` not between", value1, value2, "order_time");
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

        public Criteria andChannel_accountIsNull() {
            addCriterion("`channel_account` is null");
            return (Criteria) this;
        }

        public Criteria andChannel_accountIsNotNull() {
            addCriterion("`channel_account` is not null");
            return (Criteria) this;
        }

        public Criteria andChannel_accountEqualTo(String value) {
            addCriterion("`channel_account` =", value, "channel_account");
            return (Criteria) this;
        }

        public Criteria andChannel_accountNotEqualTo(String value) {
            addCriterion("`channel_account` <>", value, "channel_account");
            return (Criteria) this;
        }

        public Criteria andChannel_accountGreaterThan(String value) {
            addCriterion("`channel_account` >", value, "channel_account");
            return (Criteria) this;
        }

        public Criteria andChannel_accountGreaterThanOrEqualTo(String value) {
            addCriterion("`channel_account` >=", value, "channel_account");
            return (Criteria) this;
        }

        public Criteria andChannel_accountLessThan(String value) {
            addCriterion("`channel_account` <", value, "channel_account");
            return (Criteria) this;
        }

        public Criteria andChannel_accountLessThanOrEqualTo(String value) {
            addCriterion("`channel_account` <=", value, "channel_account");
            return (Criteria) this;
        }

        public Criteria andChannel_accountLike(String value) {
            addCriterion("`channel_account` like", value, "channel_account");
            return (Criteria) this;
        }

        public Criteria andChannel_accountNotLike(String value) {
            addCriterion("`channel_account` not like", value, "channel_account");
            return (Criteria) this;
        }

        public Criteria andChannel_accountIn(List<String> values) {
            addCriterion("`channel_account` in", values, "channel_account");
            return (Criteria) this;
        }

        public Criteria andChannel_accountNotIn(List<String> values) {
            addCriterion("`channel_account` not in", values, "channel_account");
            return (Criteria) this;
        }

        public Criteria andChannel_accountBetween(String value1, String value2) {
            addCriterion("`channel_account` between", value1, value2, "channel_account");
            return (Criteria) this;
        }

        public Criteria andChannel_accountNotBetween(String value1, String value2) {
            addCriterion("`channel_account` not between", value1, value2, "channel_account");
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

        public Criteria andZhuceIsNull() {
            addCriterion("`zhuce` is null");
            return (Criteria) this;
        }

        public Criteria andZhuceIsNotNull() {
            addCriterion("`zhuce` is not null");
            return (Criteria) this;
        }

        public Criteria andZhuceEqualTo(String value) {
            addCriterion("`zhuce` =", value, "zhuce");
            return (Criteria) this;
        }

        public Criteria andZhuceNotEqualTo(String value) {
            addCriterion("`zhuce` <>", value, "zhuce");
            return (Criteria) this;
        }

        public Criteria andZhuceGreaterThan(String value) {
            addCriterion("`zhuce` >", value, "zhuce");
            return (Criteria) this;
        }

        public Criteria andZhuceGreaterThanOrEqualTo(String value) {
            addCriterion("`zhuce` >=", value, "zhuce");
            return (Criteria) this;
        }

        public Criteria andZhuceLessThan(String value) {
            addCriterion("`zhuce` <", value, "zhuce");
            return (Criteria) this;
        }

        public Criteria andZhuceLessThanOrEqualTo(String value) {
            addCriterion("`zhuce` <=", value, "zhuce");
            return (Criteria) this;
        }

        public Criteria andZhuceLike(String value) {
            addCriterion("`zhuce` like", value, "zhuce");
            return (Criteria) this;
        }

        public Criteria andZhuceNotLike(String value) {
            addCriterion("`zhuce` not like", value, "zhuce");
            return (Criteria) this;
        }

        public Criteria andZhuceIn(List<String> values) {
            addCriterion("`zhuce` in", values, "zhuce");
            return (Criteria) this;
        }

        public Criteria andZhuceNotIn(List<String> values) {
            addCriterion("`zhuce` not in", values, "zhuce");
            return (Criteria) this;
        }

        public Criteria andZhuceBetween(String value1, String value2) {
            addCriterion("`zhuce` between", value1, value2, "zhuce");
            return (Criteria) this;
        }

        public Criteria andZhuceNotBetween(String value1, String value2) {
            addCriterion("`zhuce` not between", value1, value2, "zhuce");
            return (Criteria) this;
        }

        public Criteria andXinhuIsNull() {
            addCriterion("`xinhu` is null");
            return (Criteria) this;
        }

        public Criteria andXinhuIsNotNull() {
            addCriterion("`xinhu` is not null");
            return (Criteria) this;
        }

        public Criteria andXinhuEqualTo(String value) {
            addCriterion("`xinhu` =", value, "xinhu");
            return (Criteria) this;
        }

        public Criteria andXinhuNotEqualTo(String value) {
            addCriterion("`xinhu` <>", value, "xinhu");
            return (Criteria) this;
        }

        public Criteria andXinhuGreaterThan(String value) {
            addCriterion("`xinhu` >", value, "xinhu");
            return (Criteria) this;
        }

        public Criteria andXinhuGreaterThanOrEqualTo(String value) {
            addCriterion("`xinhu` >=", value, "xinhu");
            return (Criteria) this;
        }

        public Criteria andXinhuLessThan(String value) {
            addCriterion("`xinhu` <", value, "xinhu");
            return (Criteria) this;
        }

        public Criteria andXinhuLessThanOrEqualTo(String value) {
            addCriterion("`xinhu` <=", value, "xinhu");
            return (Criteria) this;
        }

        public Criteria andXinhuLike(String value) {
            addCriterion("`xinhu` like", value, "xinhu");
            return (Criteria) this;
        }

        public Criteria andXinhuNotLike(String value) {
            addCriterion("`xinhu` not like", value, "xinhu");
            return (Criteria) this;
        }

        public Criteria andXinhuIn(List<String> values) {
            addCriterion("`xinhu` in", values, "xinhu");
            return (Criteria) this;
        }

        public Criteria andXinhuNotIn(List<String> values) {
            addCriterion("`xinhu` not in", values, "xinhu");
            return (Criteria) this;
        }

        public Criteria andXinhuBetween(String value1, String value2) {
            addCriterion("`xinhu` between", value1, value2, "xinhu");
            return (Criteria) this;
        }

        public Criteria andXinhuNotBetween(String value1, String value2) {
            addCriterion("`xinhu` not between", value1, value2, "xinhu");
            return (Criteria) this;
        }

        public Criteria andJinjianIsNull() {
            addCriterion("`jinjian` is null");
            return (Criteria) this;
        }

        public Criteria andJinjianIsNotNull() {
            addCriterion("`jinjian` is not null");
            return (Criteria) this;
        }

        public Criteria andJinjianEqualTo(String value) {
            addCriterion("`jinjian` =", value, "jinjian");
            return (Criteria) this;
        }

        public Criteria andJinjianNotEqualTo(String value) {
            addCriterion("`jinjian` <>", value, "jinjian");
            return (Criteria) this;
        }

        public Criteria andJinjianGreaterThan(String value) {
            addCriterion("`jinjian` >", value, "jinjian");
            return (Criteria) this;
        }

        public Criteria andJinjianGreaterThanOrEqualTo(String value) {
            addCriterion("`jinjian` >=", value, "jinjian");
            return (Criteria) this;
        }

        public Criteria andJinjianLessThan(String value) {
            addCriterion("`jinjian` <", value, "jinjian");
            return (Criteria) this;
        }

        public Criteria andJinjianLessThanOrEqualTo(String value) {
            addCriterion("`jinjian` <=", value, "jinjian");
            return (Criteria) this;
        }

        public Criteria andJinjianLike(String value) {
            addCriterion("`jinjian` like", value, "jinjian");
            return (Criteria) this;
        }

        public Criteria andJinjianNotLike(String value) {
            addCriterion("`jinjian` not like", value, "jinjian");
            return (Criteria) this;
        }

        public Criteria andJinjianIn(List<String> values) {
            addCriterion("`jinjian` in", values, "jinjian");
            return (Criteria) this;
        }

        public Criteria andJinjianNotIn(List<String> values) {
            addCriterion("`jinjian` not in", values, "jinjian");
            return (Criteria) this;
        }

        public Criteria andJinjianBetween(String value1, String value2) {
            addCriterion("`jinjian` between", value1, value2, "jinjian");
            return (Criteria) this;
        }

        public Criteria andJinjianNotBetween(String value1, String value2) {
            addCriterion("`jinjian` not between", value1, value2, "jinjian");
            return (Criteria) this;
        }

        public Criteria andJihuoIsNull() {
            addCriterion("`jihuo` is null");
            return (Criteria) this;
        }

        public Criteria andJihuoIsNotNull() {
            addCriterion("`jihuo` is not null");
            return (Criteria) this;
        }

        public Criteria andJihuoEqualTo(String value) {
            addCriterion("`jihuo` =", value, "jihuo");
            return (Criteria) this;
        }

        public Criteria andJihuoNotEqualTo(String value) {
            addCriterion("`jihuo` <>", value, "jihuo");
            return (Criteria) this;
        }

        public Criteria andJihuoGreaterThan(String value) {
            addCriterion("`jihuo` >", value, "jihuo");
            return (Criteria) this;
        }

        public Criteria andJihuoGreaterThanOrEqualTo(String value) {
            addCriterion("`jihuo` >=", value, "jihuo");
            return (Criteria) this;
        }

        public Criteria andJihuoLessThan(String value) {
            addCriterion("`jihuo` <", value, "jihuo");
            return (Criteria) this;
        }

        public Criteria andJihuoLessThanOrEqualTo(String value) {
            addCriterion("`jihuo` <=", value, "jihuo");
            return (Criteria) this;
        }

        public Criteria andJihuoLike(String value) {
            addCriterion("`jihuo` like", value, "jihuo");
            return (Criteria) this;
        }

        public Criteria andJihuoNotLike(String value) {
            addCriterion("`jihuo` not like", value, "jihuo");
            return (Criteria) this;
        }

        public Criteria andJihuoIn(List<String> values) {
            addCriterion("`jihuo` in", values, "jihuo");
            return (Criteria) this;
        }

        public Criteria andJihuoNotIn(List<String> values) {
            addCriterion("`jihuo` not in", values, "jihuo");
            return (Criteria) this;
        }

        public Criteria andJihuoBetween(String value1, String value2) {
            addCriterion("`jihuo` between", value1, value2, "jihuo");
            return (Criteria) this;
        }

        public Criteria andJihuoNotBetween(String value1, String value2) {
            addCriterion("`jihuo` not between", value1, value2, "jihuo");
            return (Criteria) this;
        }

        public Criteria andShouxinIsNull() {
            addCriterion("`shouxin` is null");
            return (Criteria) this;
        }

        public Criteria andShouxinIsNotNull() {
            addCriterion("`shouxin` is not null");
            return (Criteria) this;
        }

        public Criteria andShouxinEqualTo(String value) {
            addCriterion("`shouxin` =", value, "shouxin");
            return (Criteria) this;
        }

        public Criteria andShouxinNotEqualTo(String value) {
            addCriterion("`shouxin` <>", value, "shouxin");
            return (Criteria) this;
        }

        public Criteria andShouxinGreaterThan(String value) {
            addCriterion("`shouxin` >", value, "shouxin");
            return (Criteria) this;
        }

        public Criteria andShouxinGreaterThanOrEqualTo(String value) {
            addCriterion("`shouxin` >=", value, "shouxin");
            return (Criteria) this;
        }

        public Criteria andShouxinLessThan(String value) {
            addCriterion("`shouxin` <", value, "shouxin");
            return (Criteria) this;
        }

        public Criteria andShouxinLessThanOrEqualTo(String value) {
            addCriterion("`shouxin` <=", value, "shouxin");
            return (Criteria) this;
        }

        public Criteria andShouxinLike(String value) {
            addCriterion("`shouxin` like", value, "shouxin");
            return (Criteria) this;
        }

        public Criteria andShouxinNotLike(String value) {
            addCriterion("`shouxin` not like", value, "shouxin");
            return (Criteria) this;
        }

        public Criteria andShouxinIn(List<String> values) {
            addCriterion("`shouxin` in", values, "shouxin");
            return (Criteria) this;
        }

        public Criteria andShouxinNotIn(List<String> values) {
            addCriterion("`shouxin` not in", values, "shouxin");
            return (Criteria) this;
        }

        public Criteria andShouxinBetween(String value1, String value2) {
            addCriterion("`shouxin` between", value1, value2, "shouxin");
            return (Criteria) this;
        }

        public Criteria andShouxinNotBetween(String value1, String value2) {
            addCriterion("`shouxin` not between", value1, value2, "shouxin");
            return (Criteria) this;
        }

        public Criteria andHekaIsNull() {
            addCriterion("`heka` is null");
            return (Criteria) this;
        }

        public Criteria andHekaIsNotNull() {
            addCriterion("`heka` is not null");
            return (Criteria) this;
        }

        public Criteria andHekaEqualTo(String value) {
            addCriterion("`heka` =", value, "heka");
            return (Criteria) this;
        }

        public Criteria andHekaNotEqualTo(String value) {
            addCriterion("`heka` <>", value, "heka");
            return (Criteria) this;
        }

        public Criteria andHekaGreaterThan(String value) {
            addCriterion("`heka` >", value, "heka");
            return (Criteria) this;
        }

        public Criteria andHekaGreaterThanOrEqualTo(String value) {
            addCriterion("`heka` >=", value, "heka");
            return (Criteria) this;
        }

        public Criteria andHekaLessThan(String value) {
            addCriterion("`heka` <", value, "heka");
            return (Criteria) this;
        }

        public Criteria andHekaLessThanOrEqualTo(String value) {
            addCriterion("`heka` <=", value, "heka");
            return (Criteria) this;
        }

        public Criteria andHekaLike(String value) {
            addCriterion("`heka` like", value, "heka");
            return (Criteria) this;
        }

        public Criteria andHekaNotLike(String value) {
            addCriterion("`heka` not like", value, "heka");
            return (Criteria) this;
        }

        public Criteria andHekaIn(List<String> values) {
            addCriterion("`heka` in", values, "heka");
            return (Criteria) this;
        }

        public Criteria andHekaNotIn(List<String> values) {
            addCriterion("`heka` not in", values, "heka");
            return (Criteria) this;
        }

        public Criteria andHekaBetween(String value1, String value2) {
            addCriterion("`heka` between", value1, value2, "heka");
            return (Criteria) this;
        }

        public Criteria andHekaNotBetween(String value1, String value2) {
            addCriterion("`heka` not between", value1, value2, "heka");
            return (Criteria) this;
        }

        public Criteria andXiakuanIsNull() {
            addCriterion("`xiakuan` is null");
            return (Criteria) this;
        }

        public Criteria andXiakuanIsNotNull() {
            addCriterion("`xiakuan` is not null");
            return (Criteria) this;
        }

        public Criteria andXiakuanEqualTo(String value) {
            addCriterion("`xiakuan` =", value, "xiakuan");
            return (Criteria) this;
        }

        public Criteria andXiakuanNotEqualTo(String value) {
            addCriterion("`xiakuan` <>", value, "xiakuan");
            return (Criteria) this;
        }

        public Criteria andXiakuanGreaterThan(String value) {
            addCriterion("`xiakuan` >", value, "xiakuan");
            return (Criteria) this;
        }

        public Criteria andXiakuanGreaterThanOrEqualTo(String value) {
            addCriterion("`xiakuan` >=", value, "xiakuan");
            return (Criteria) this;
        }

        public Criteria andXiakuanLessThan(String value) {
            addCriterion("`xiakuan` <", value, "xiakuan");
            return (Criteria) this;
        }

        public Criteria andXiakuanLessThanOrEqualTo(String value) {
            addCriterion("`xiakuan` <=", value, "xiakuan");
            return (Criteria) this;
        }

        public Criteria andXiakuanLike(String value) {
            addCriterion("`xiakuan` like", value, "xiakuan");
            return (Criteria) this;
        }

        public Criteria andXiakuanNotLike(String value) {
            addCriterion("`xiakuan` not like", value, "xiakuan");
            return (Criteria) this;
        }

        public Criteria andXiakuanIn(List<String> values) {
            addCriterion("`xiakuan` in", values, "xiakuan");
            return (Criteria) this;
        }

        public Criteria andXiakuanNotIn(List<String> values) {
            addCriterion("`xiakuan` not in", values, "xiakuan");
            return (Criteria) this;
        }

        public Criteria andXiakuanBetween(String value1, String value2) {
            addCriterion("`xiakuan` between", value1, value2, "xiakuan");
            return (Criteria) this;
        }

        public Criteria andXiakuanNotBetween(String value1, String value2) {
            addCriterion("`xiakuan` not between", value1, value2, "xiakuan");
            return (Criteria) this;
        }

        public Criteria andXiakuan_amtIsNull() {
            addCriterion("`xiakuan_amt` is null");
            return (Criteria) this;
        }

        public Criteria andXiakuan_amtIsNotNull() {
            addCriterion("`xiakuan_amt` is not null");
            return (Criteria) this;
        }

        public Criteria andXiakuan_amtEqualTo(String value) {
            addCriterion("`xiakuan_amt` =", value, "xiakuan_amt");
            return (Criteria) this;
        }

        public Criteria andXiakuan_amtNotEqualTo(String value) {
            addCriterion("`xiakuan_amt` <>", value, "xiakuan_amt");
            return (Criteria) this;
        }

        public Criteria andXiakuan_amtGreaterThan(String value) {
            addCriterion("`xiakuan_amt` >", value, "xiakuan_amt");
            return (Criteria) this;
        }

        public Criteria andXiakuan_amtGreaterThanOrEqualTo(String value) {
            addCriterion("`xiakuan_amt` >=", value, "xiakuan_amt");
            return (Criteria) this;
        }

        public Criteria andXiakuan_amtLessThan(String value) {
            addCriterion("`xiakuan_amt` <", value, "xiakuan_amt");
            return (Criteria) this;
        }

        public Criteria andXiakuan_amtLessThanOrEqualTo(String value) {
            addCriterion("`xiakuan_amt` <=", value, "xiakuan_amt");
            return (Criteria) this;
        }

        public Criteria andXiakuan_amtLike(String value) {
            addCriterion("`xiakuan_amt` like", value, "xiakuan_amt");
            return (Criteria) this;
        }

        public Criteria andXiakuan_amtNotLike(String value) {
            addCriterion("`xiakuan_amt` not like", value, "xiakuan_amt");
            return (Criteria) this;
        }

        public Criteria andXiakuan_amtIn(List<String> values) {
            addCriterion("`xiakuan_amt` in", values, "xiakuan_amt");
            return (Criteria) this;
        }

        public Criteria andXiakuan_amtNotIn(List<String> values) {
            addCriterion("`xiakuan_amt` not in", values, "xiakuan_amt");
            return (Criteria) this;
        }

        public Criteria andXiakuan_amtBetween(String value1, String value2) {
            addCriterion("`xiakuan_amt` between", value1, value2, "xiakuan_amt");
            return (Criteria) this;
        }

        public Criteria andXiakuan_amtNotBetween(String value1, String value2) {
            addCriterion("`xiakuan_amt` not between", value1, value2, "xiakuan_amt");
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

        public Criteria andPicihaoIsNull() {
            addCriterion("`picihao` is null");
            return (Criteria) this;
        }

        public Criteria andPicihaoIsNotNull() {
            addCriterion("`picihao` is not null");
            return (Criteria) this;
        }

        public Criteria andPicihaoEqualTo(String value) {
            addCriterion("`picihao` =", value, "picihao");
            return (Criteria) this;
        }

        public Criteria andPicihaoNotEqualTo(String value) {
            addCriterion("`picihao` <>", value, "picihao");
            return (Criteria) this;
        }

        public Criteria andPicihaoGreaterThan(String value) {
            addCriterion("`picihao` >", value, "picihao");
            return (Criteria) this;
        }

        public Criteria andPicihaoGreaterThanOrEqualTo(String value) {
            addCriterion("`picihao` >=", value, "picihao");
            return (Criteria) this;
        }

        public Criteria andPicihaoLessThan(String value) {
            addCriterion("`picihao` <", value, "picihao");
            return (Criteria) this;
        }

        public Criteria andPicihaoLessThanOrEqualTo(String value) {
            addCriterion("`picihao` <=", value, "picihao");
            return (Criteria) this;
        }

        public Criteria andPicihaoLike(String value) {
            addCriterion("`picihao` like", value, "picihao");
            return (Criteria) this;
        }

        public Criteria andPicihaoNotLike(String value) {
            addCriterion("`picihao` not like", value, "picihao");
            return (Criteria) this;
        }

        public Criteria andPicihaoIn(List<String> values) {
            addCriterion("`picihao` in", values, "picihao");
            return (Criteria) this;
        }

        public Criteria andPicihaoNotIn(List<String> values) {
            addCriterion("`picihao` not in", values, "picihao");
            return (Criteria) this;
        }

        public Criteria andPicihaoBetween(String value1, String value2) {
            addCriterion("`picihao` between", value1, value2, "picihao");
            return (Criteria) this;
        }

        public Criteria andPicihaoNotBetween(String value1, String value2) {
            addCriterion("`picihao` not between", value1, value2, "picihao");
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
package com.segama.ege.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public PayExample() {
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

        public Criteria andOrder_idIsNull() {
            addCriterion("`order_id` is null");
            return (Criteria) this;
        }

        public Criteria andOrder_idIsNotNull() {
            addCriterion("`order_id` is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_idEqualTo(Long value) {
            addCriterion("`order_id` =", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotEqualTo(Long value) {
            addCriterion("`order_id` <>", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idGreaterThan(Long value) {
            addCriterion("`order_id` >", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idGreaterThanOrEqualTo(Long value) {
            addCriterion("`order_id` >=", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idLessThan(Long value) {
            addCriterion("`order_id` <", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idLessThanOrEqualTo(Long value) {
            addCriterion("`order_id` <=", value, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idIn(List<Long> values) {
            addCriterion("`order_id` in", values, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotIn(List<Long> values) {
            addCriterion("`order_id` not in", values, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idBetween(Long value1, Long value2) {
            addCriterion("`order_id` between", value1, value2, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_idNotBetween(Long value1, Long value2) {
            addCriterion("`order_id` not between", value1, value2, "order_id");
            return (Criteria) this;
        }

        public Criteria andOrder_string_idIsNull() {
            addCriterion("`order_string_id` is null");
            return (Criteria) this;
        }

        public Criteria andOrder_string_idIsNotNull() {
            addCriterion("`order_string_id` is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_string_idEqualTo(String value) {
            addCriterion("`order_string_id` =", value, "order_string_id");
            return (Criteria) this;
        }

        public Criteria andOrder_string_idNotEqualTo(String value) {
            addCriterion("`order_string_id` <>", value, "order_string_id");
            return (Criteria) this;
        }

        public Criteria andOrder_string_idGreaterThan(String value) {
            addCriterion("`order_string_id` >", value, "order_string_id");
            return (Criteria) this;
        }

        public Criteria andOrder_string_idGreaterThanOrEqualTo(String value) {
            addCriterion("`order_string_id` >=", value, "order_string_id");
            return (Criteria) this;
        }

        public Criteria andOrder_string_idLessThan(String value) {
            addCriterion("`order_string_id` <", value, "order_string_id");
            return (Criteria) this;
        }

        public Criteria andOrder_string_idLessThanOrEqualTo(String value) {
            addCriterion("`order_string_id` <=", value, "order_string_id");
            return (Criteria) this;
        }

        public Criteria andOrder_string_idLike(String value) {
            addCriterion("`order_string_id` like", value, "order_string_id");
            return (Criteria) this;
        }

        public Criteria andOrder_string_idNotLike(String value) {
            addCriterion("`order_string_id` not like", value, "order_string_id");
            return (Criteria) this;
        }

        public Criteria andOrder_string_idIn(List<String> values) {
            addCriterion("`order_string_id` in", values, "order_string_id");
            return (Criteria) this;
        }

        public Criteria andOrder_string_idNotIn(List<String> values) {
            addCriterion("`order_string_id` not in", values, "order_string_id");
            return (Criteria) this;
        }

        public Criteria andOrder_string_idBetween(String value1, String value2) {
            addCriterion("`order_string_id` between", value1, value2, "order_string_id");
            return (Criteria) this;
        }

        public Criteria andOrder_string_idNotBetween(String value1, String value2) {
            addCriterion("`order_string_id` not between", value1, value2, "order_string_id");
            return (Criteria) this;
        }

        public Criteria andPay_string_idIsNull() {
            addCriterion("`pay_string_id` is null");
            return (Criteria) this;
        }

        public Criteria andPay_string_idIsNotNull() {
            addCriterion("`pay_string_id` is not null");
            return (Criteria) this;
        }

        public Criteria andPay_string_idEqualTo(String value) {
            addCriterion("`pay_string_id` =", value, "pay_string_id");
            return (Criteria) this;
        }

        public Criteria andPay_string_idNotEqualTo(String value) {
            addCriterion("`pay_string_id` <>", value, "pay_string_id");
            return (Criteria) this;
        }

        public Criteria andPay_string_idGreaterThan(String value) {
            addCriterion("`pay_string_id` >", value, "pay_string_id");
            return (Criteria) this;
        }

        public Criteria andPay_string_idGreaterThanOrEqualTo(String value) {
            addCriterion("`pay_string_id` >=", value, "pay_string_id");
            return (Criteria) this;
        }

        public Criteria andPay_string_idLessThan(String value) {
            addCriterion("`pay_string_id` <", value, "pay_string_id");
            return (Criteria) this;
        }

        public Criteria andPay_string_idLessThanOrEqualTo(String value) {
            addCriterion("`pay_string_id` <=", value, "pay_string_id");
            return (Criteria) this;
        }

        public Criteria andPay_string_idLike(String value) {
            addCriterion("`pay_string_id` like", value, "pay_string_id");
            return (Criteria) this;
        }

        public Criteria andPay_string_idNotLike(String value) {
            addCriterion("`pay_string_id` not like", value, "pay_string_id");
            return (Criteria) this;
        }

        public Criteria andPay_string_idIn(List<String> values) {
            addCriterion("`pay_string_id` in", values, "pay_string_id");
            return (Criteria) this;
        }

        public Criteria andPay_string_idNotIn(List<String> values) {
            addCriterion("`pay_string_id` not in", values, "pay_string_id");
            return (Criteria) this;
        }

        public Criteria andPay_string_idBetween(String value1, String value2) {
            addCriterion("`pay_string_id` between", value1, value2, "pay_string_id");
            return (Criteria) this;
        }

        public Criteria andPay_string_idNotBetween(String value1, String value2) {
            addCriterion("`pay_string_id` not between", value1, value2, "pay_string_id");
            return (Criteria) this;
        }

        public Criteria andPay_statusIsNull() {
            addCriterion("`pay_status` is null");
            return (Criteria) this;
        }

        public Criteria andPay_statusIsNotNull() {
            addCriterion("`pay_status` is not null");
            return (Criteria) this;
        }

        public Criteria andPay_statusEqualTo(String value) {
            addCriterion("`pay_status` =", value, "pay_status");
            return (Criteria) this;
        }

        public Criteria andPay_statusNotEqualTo(String value) {
            addCriterion("`pay_status` <>", value, "pay_status");
            return (Criteria) this;
        }

        public Criteria andPay_statusGreaterThan(String value) {
            addCriterion("`pay_status` >", value, "pay_status");
            return (Criteria) this;
        }

        public Criteria andPay_statusGreaterThanOrEqualTo(String value) {
            addCriterion("`pay_status` >=", value, "pay_status");
            return (Criteria) this;
        }

        public Criteria andPay_statusLessThan(String value) {
            addCriterion("`pay_status` <", value, "pay_status");
            return (Criteria) this;
        }

        public Criteria andPay_statusLessThanOrEqualTo(String value) {
            addCriterion("`pay_status` <=", value, "pay_status");
            return (Criteria) this;
        }

        public Criteria andPay_statusLike(String value) {
            addCriterion("`pay_status` like", value, "pay_status");
            return (Criteria) this;
        }

        public Criteria andPay_statusNotLike(String value) {
            addCriterion("`pay_status` not like", value, "pay_status");
            return (Criteria) this;
        }

        public Criteria andPay_statusIn(List<String> values) {
            addCriterion("`pay_status` in", values, "pay_status");
            return (Criteria) this;
        }

        public Criteria andPay_statusNotIn(List<String> values) {
            addCriterion("`pay_status` not in", values, "pay_status");
            return (Criteria) this;
        }

        public Criteria andPay_statusBetween(String value1, String value2) {
            addCriterion("`pay_status` between", value1, value2, "pay_status");
            return (Criteria) this;
        }

        public Criteria andPay_statusNotBetween(String value1, String value2) {
            addCriterion("`pay_status` not between", value1, value2, "pay_status");
            return (Criteria) this;
        }

        public Criteria andBefore_discount_feeIsNull() {
            addCriterion("`before_discount_fee` is null");
            return (Criteria) this;
        }

        public Criteria andBefore_discount_feeIsNotNull() {
            addCriterion("`before_discount_fee` is not null");
            return (Criteria) this;
        }

        public Criteria andBefore_discount_feeEqualTo(String value) {
            addCriterion("`before_discount_fee` =", value, "before_discount_fee");
            return (Criteria) this;
        }

        public Criteria andBefore_discount_feeNotEqualTo(String value) {
            addCriterion("`before_discount_fee` <>", value, "before_discount_fee");
            return (Criteria) this;
        }

        public Criteria andBefore_discount_feeGreaterThan(String value) {
            addCriterion("`before_discount_fee` >", value, "before_discount_fee");
            return (Criteria) this;
        }

        public Criteria andBefore_discount_feeGreaterThanOrEqualTo(String value) {
            addCriterion("`before_discount_fee` >=", value, "before_discount_fee");
            return (Criteria) this;
        }

        public Criteria andBefore_discount_feeLessThan(String value) {
            addCriterion("`before_discount_fee` <", value, "before_discount_fee");
            return (Criteria) this;
        }

        public Criteria andBefore_discount_feeLessThanOrEqualTo(String value) {
            addCriterion("`before_discount_fee` <=", value, "before_discount_fee");
            return (Criteria) this;
        }

        public Criteria andBefore_discount_feeLike(String value) {
            addCriterion("`before_discount_fee` like", value, "before_discount_fee");
            return (Criteria) this;
        }

        public Criteria andBefore_discount_feeNotLike(String value) {
            addCriterion("`before_discount_fee` not like", value, "before_discount_fee");
            return (Criteria) this;
        }

        public Criteria andBefore_discount_feeIn(List<String> values) {
            addCriterion("`before_discount_fee` in", values, "before_discount_fee");
            return (Criteria) this;
        }

        public Criteria andBefore_discount_feeNotIn(List<String> values) {
            addCriterion("`before_discount_fee` not in", values, "before_discount_fee");
            return (Criteria) this;
        }

        public Criteria andBefore_discount_feeBetween(String value1, String value2) {
            addCriterion("`before_discount_fee` between", value1, value2, "before_discount_fee");
            return (Criteria) this;
        }

        public Criteria andBefore_discount_feeNotBetween(String value1, String value2) {
            addCriterion("`before_discount_fee` not between", value1, value2, "before_discount_fee");
            return (Criteria) this;
        }

        public Criteria andCoupon_idsIsNull() {
            addCriterion("`coupon_ids` is null");
            return (Criteria) this;
        }

        public Criteria andCoupon_idsIsNotNull() {
            addCriterion("`coupon_ids` is not null");
            return (Criteria) this;
        }

        public Criteria andCoupon_idsEqualTo(String value) {
            addCriterion("`coupon_ids` =", value, "coupon_ids");
            return (Criteria) this;
        }

        public Criteria andCoupon_idsNotEqualTo(String value) {
            addCriterion("`coupon_ids` <>", value, "coupon_ids");
            return (Criteria) this;
        }

        public Criteria andCoupon_idsGreaterThan(String value) {
            addCriterion("`coupon_ids` >", value, "coupon_ids");
            return (Criteria) this;
        }

        public Criteria andCoupon_idsGreaterThanOrEqualTo(String value) {
            addCriterion("`coupon_ids` >=", value, "coupon_ids");
            return (Criteria) this;
        }

        public Criteria andCoupon_idsLessThan(String value) {
            addCriterion("`coupon_ids` <", value, "coupon_ids");
            return (Criteria) this;
        }

        public Criteria andCoupon_idsLessThanOrEqualTo(String value) {
            addCriterion("`coupon_ids` <=", value, "coupon_ids");
            return (Criteria) this;
        }

        public Criteria andCoupon_idsLike(String value) {
            addCriterion("`coupon_ids` like", value, "coupon_ids");
            return (Criteria) this;
        }

        public Criteria andCoupon_idsNotLike(String value) {
            addCriterion("`coupon_ids` not like", value, "coupon_ids");
            return (Criteria) this;
        }

        public Criteria andCoupon_idsIn(List<String> values) {
            addCriterion("`coupon_ids` in", values, "coupon_ids");
            return (Criteria) this;
        }

        public Criteria andCoupon_idsNotIn(List<String> values) {
            addCriterion("`coupon_ids` not in", values, "coupon_ids");
            return (Criteria) this;
        }

        public Criteria andCoupon_idsBetween(String value1, String value2) {
            addCriterion("`coupon_ids` between", value1, value2, "coupon_ids");
            return (Criteria) this;
        }

        public Criteria andCoupon_idsNotBetween(String value1, String value2) {
            addCriterion("`coupon_ids` not between", value1, value2, "coupon_ids");
            return (Criteria) this;
        }

        public Criteria andDiscount_feeIsNull() {
            addCriterion("`discount_fee` is null");
            return (Criteria) this;
        }

        public Criteria andDiscount_feeIsNotNull() {
            addCriterion("`discount_fee` is not null");
            return (Criteria) this;
        }

        public Criteria andDiscount_feeEqualTo(String value) {
            addCriterion("`discount_fee` =", value, "discount_fee");
            return (Criteria) this;
        }

        public Criteria andDiscount_feeNotEqualTo(String value) {
            addCriterion("`discount_fee` <>", value, "discount_fee");
            return (Criteria) this;
        }

        public Criteria andDiscount_feeGreaterThan(String value) {
            addCriterion("`discount_fee` >", value, "discount_fee");
            return (Criteria) this;
        }

        public Criteria andDiscount_feeGreaterThanOrEqualTo(String value) {
            addCriterion("`discount_fee` >=", value, "discount_fee");
            return (Criteria) this;
        }

        public Criteria andDiscount_feeLessThan(String value) {
            addCriterion("`discount_fee` <", value, "discount_fee");
            return (Criteria) this;
        }

        public Criteria andDiscount_feeLessThanOrEqualTo(String value) {
            addCriterion("`discount_fee` <=", value, "discount_fee");
            return (Criteria) this;
        }

        public Criteria andDiscount_feeLike(String value) {
            addCriterion("`discount_fee` like", value, "discount_fee");
            return (Criteria) this;
        }

        public Criteria andDiscount_feeNotLike(String value) {
            addCriterion("`discount_fee` not like", value, "discount_fee");
            return (Criteria) this;
        }

        public Criteria andDiscount_feeIn(List<String> values) {
            addCriterion("`discount_fee` in", values, "discount_fee");
            return (Criteria) this;
        }

        public Criteria andDiscount_feeNotIn(List<String> values) {
            addCriterion("`discount_fee` not in", values, "discount_fee");
            return (Criteria) this;
        }

        public Criteria andDiscount_feeBetween(String value1, String value2) {
            addCriterion("`discount_fee` between", value1, value2, "discount_fee");
            return (Criteria) this;
        }

        public Criteria andDiscount_feeNotBetween(String value1, String value2) {
            addCriterion("`discount_fee` not between", value1, value2, "discount_fee");
            return (Criteria) this;
        }

        public Criteria andPay_modeIsNull() {
            addCriterion("`pay_mode` is null");
            return (Criteria) this;
        }

        public Criteria andPay_modeIsNotNull() {
            addCriterion("`pay_mode` is not null");
            return (Criteria) this;
        }

        public Criteria andPay_modeEqualTo(String value) {
            addCriterion("`pay_mode` =", value, "pay_mode");
            return (Criteria) this;
        }

        public Criteria andPay_modeNotEqualTo(String value) {
            addCriterion("`pay_mode` <>", value, "pay_mode");
            return (Criteria) this;
        }

        public Criteria andPay_modeGreaterThan(String value) {
            addCriterion("`pay_mode` >", value, "pay_mode");
            return (Criteria) this;
        }

        public Criteria andPay_modeGreaterThanOrEqualTo(String value) {
            addCriterion("`pay_mode` >=", value, "pay_mode");
            return (Criteria) this;
        }

        public Criteria andPay_modeLessThan(String value) {
            addCriterion("`pay_mode` <", value, "pay_mode");
            return (Criteria) this;
        }

        public Criteria andPay_modeLessThanOrEqualTo(String value) {
            addCriterion("`pay_mode` <=", value, "pay_mode");
            return (Criteria) this;
        }

        public Criteria andPay_modeLike(String value) {
            addCriterion("`pay_mode` like", value, "pay_mode");
            return (Criteria) this;
        }

        public Criteria andPay_modeNotLike(String value) {
            addCriterion("`pay_mode` not like", value, "pay_mode");
            return (Criteria) this;
        }

        public Criteria andPay_modeIn(List<String> values) {
            addCriterion("`pay_mode` in", values, "pay_mode");
            return (Criteria) this;
        }

        public Criteria andPay_modeNotIn(List<String> values) {
            addCriterion("`pay_mode` not in", values, "pay_mode");
            return (Criteria) this;
        }

        public Criteria andPay_modeBetween(String value1, String value2) {
            addCriterion("`pay_mode` between", value1, value2, "pay_mode");
            return (Criteria) this;
        }

        public Criteria andPay_modeNotBetween(String value1, String value2) {
            addCriterion("`pay_mode` not between", value1, value2, "pay_mode");
            return (Criteria) this;
        }

        public Criteria andFinal_feeIsNull() {
            addCriterion("`final_fee` is null");
            return (Criteria) this;
        }

        public Criteria andFinal_feeIsNotNull() {
            addCriterion("`final_fee` is not null");
            return (Criteria) this;
        }

        public Criteria andFinal_feeEqualTo(String value) {
            addCriterion("`final_fee` =", value, "final_fee");
            return (Criteria) this;
        }

        public Criteria andFinal_feeNotEqualTo(String value) {
            addCriterion("`final_fee` <>", value, "final_fee");
            return (Criteria) this;
        }

        public Criteria andFinal_feeGreaterThan(String value) {
            addCriterion("`final_fee` >", value, "final_fee");
            return (Criteria) this;
        }

        public Criteria andFinal_feeGreaterThanOrEqualTo(String value) {
            addCriterion("`final_fee` >=", value, "final_fee");
            return (Criteria) this;
        }

        public Criteria andFinal_feeLessThan(String value) {
            addCriterion("`final_fee` <", value, "final_fee");
            return (Criteria) this;
        }

        public Criteria andFinal_feeLessThanOrEqualTo(String value) {
            addCriterion("`final_fee` <=", value, "final_fee");
            return (Criteria) this;
        }

        public Criteria andFinal_feeLike(String value) {
            addCriterion("`final_fee` like", value, "final_fee");
            return (Criteria) this;
        }

        public Criteria andFinal_feeNotLike(String value) {
            addCriterion("`final_fee` not like", value, "final_fee");
            return (Criteria) this;
        }

        public Criteria andFinal_feeIn(List<String> values) {
            addCriterion("`final_fee` in", values, "final_fee");
            return (Criteria) this;
        }

        public Criteria andFinal_feeNotIn(List<String> values) {
            addCriterion("`final_fee` not in", values, "final_fee");
            return (Criteria) this;
        }

        public Criteria andFinal_feeBetween(String value1, String value2) {
            addCriterion("`final_fee` between", value1, value2, "final_fee");
            return (Criteria) this;
        }

        public Criteria andFinal_feeNotBetween(String value1, String value2) {
            addCriterion("`final_fee` not between", value1, value2, "final_fee");
            return (Criteria) this;
        }

        public Criteria andGmt_pay_createIsNull() {
            addCriterion("`gmt_pay_create` is null");
            return (Criteria) this;
        }

        public Criteria andGmt_pay_createIsNotNull() {
            addCriterion("`gmt_pay_create` is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_pay_createEqualTo(Date value) {
            addCriterion("`gmt_pay_create` =", value, "gmt_pay_create");
            return (Criteria) this;
        }

        public Criteria andGmt_pay_createNotEqualTo(Date value) {
            addCriterion("`gmt_pay_create` <>", value, "gmt_pay_create");
            return (Criteria) this;
        }

        public Criteria andGmt_pay_createGreaterThan(Date value) {
            addCriterion("`gmt_pay_create` >", value, "gmt_pay_create");
            return (Criteria) this;
        }

        public Criteria andGmt_pay_createGreaterThanOrEqualTo(Date value) {
            addCriterion("`gmt_pay_create` >=", value, "gmt_pay_create");
            return (Criteria) this;
        }

        public Criteria andGmt_pay_createLessThan(Date value) {
            addCriterion("`gmt_pay_create` <", value, "gmt_pay_create");
            return (Criteria) this;
        }

        public Criteria andGmt_pay_createLessThanOrEqualTo(Date value) {
            addCriterion("`gmt_pay_create` <=", value, "gmt_pay_create");
            return (Criteria) this;
        }

        public Criteria andGmt_pay_createIn(List<Date> values) {
            addCriterion("`gmt_pay_create` in", values, "gmt_pay_create");
            return (Criteria) this;
        }

        public Criteria andGmt_pay_createNotIn(List<Date> values) {
            addCriterion("`gmt_pay_create` not in", values, "gmt_pay_create");
            return (Criteria) this;
        }

        public Criteria andGmt_pay_createBetween(Date value1, Date value2) {
            addCriterion("`gmt_pay_create` between", value1, value2, "gmt_pay_create");
            return (Criteria) this;
        }

        public Criteria andGmt_pay_createNotBetween(Date value1, Date value2) {
            addCriterion("`gmt_pay_create` not between", value1, value2, "gmt_pay_create");
            return (Criteria) this;
        }

        public Criteria andGmt_pay_finishIsNull() {
            addCriterion("`gmt_pay_finish` is null");
            return (Criteria) this;
        }

        public Criteria andGmt_pay_finishIsNotNull() {
            addCriterion("`gmt_pay_finish` is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_pay_finishEqualTo(Date value) {
            addCriterion("`gmt_pay_finish` =", value, "gmt_pay_finish");
            return (Criteria) this;
        }

        public Criteria andGmt_pay_finishNotEqualTo(Date value) {
            addCriterion("`gmt_pay_finish` <>", value, "gmt_pay_finish");
            return (Criteria) this;
        }

        public Criteria andGmt_pay_finishGreaterThan(Date value) {
            addCriterion("`gmt_pay_finish` >", value, "gmt_pay_finish");
            return (Criteria) this;
        }

        public Criteria andGmt_pay_finishGreaterThanOrEqualTo(Date value) {
            addCriterion("`gmt_pay_finish` >=", value, "gmt_pay_finish");
            return (Criteria) this;
        }

        public Criteria andGmt_pay_finishLessThan(Date value) {
            addCriterion("`gmt_pay_finish` <", value, "gmt_pay_finish");
            return (Criteria) this;
        }

        public Criteria andGmt_pay_finishLessThanOrEqualTo(Date value) {
            addCriterion("`gmt_pay_finish` <=", value, "gmt_pay_finish");
            return (Criteria) this;
        }

        public Criteria andGmt_pay_finishIn(List<Date> values) {
            addCriterion("`gmt_pay_finish` in", values, "gmt_pay_finish");
            return (Criteria) this;
        }

        public Criteria andGmt_pay_finishNotIn(List<Date> values) {
            addCriterion("`gmt_pay_finish` not in", values, "gmt_pay_finish");
            return (Criteria) this;
        }

        public Criteria andGmt_pay_finishBetween(Date value1, Date value2) {
            addCriterion("`gmt_pay_finish` between", value1, value2, "gmt_pay_finish");
            return (Criteria) this;
        }

        public Criteria andGmt_pay_finishNotBetween(Date value1, Date value2) {
            addCriterion("`gmt_pay_finish` not between", value1, value2, "gmt_pay_finish");
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
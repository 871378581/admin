package com.segama.ege.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderFeeDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public OrderFeeDetailExample() {
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

        public Criteria andEach_item_idIsNull() {
            addCriterion("`each_item_id` is null");
            return (Criteria) this;
        }

        public Criteria andEach_item_idIsNotNull() {
            addCriterion("`each_item_id` is not null");
            return (Criteria) this;
        }

        public Criteria andEach_item_idEqualTo(Long value) {
            addCriterion("`each_item_id` =", value, "each_item_id");
            return (Criteria) this;
        }

        public Criteria andEach_item_idNotEqualTo(Long value) {
            addCriterion("`each_item_id` <>", value, "each_item_id");
            return (Criteria) this;
        }

        public Criteria andEach_item_idGreaterThan(Long value) {
            addCriterion("`each_item_id` >", value, "each_item_id");
            return (Criteria) this;
        }

        public Criteria andEach_item_idGreaterThanOrEqualTo(Long value) {
            addCriterion("`each_item_id` >=", value, "each_item_id");
            return (Criteria) this;
        }

        public Criteria andEach_item_idLessThan(Long value) {
            addCriterion("`each_item_id` <", value, "each_item_id");
            return (Criteria) this;
        }

        public Criteria andEach_item_idLessThanOrEqualTo(Long value) {
            addCriterion("`each_item_id` <=", value, "each_item_id");
            return (Criteria) this;
        }

        public Criteria andEach_item_idIn(List<Long> values) {
            addCriterion("`each_item_id` in", values, "each_item_id");
            return (Criteria) this;
        }

        public Criteria andEach_item_idNotIn(List<Long> values) {
            addCriterion("`each_item_id` not in", values, "each_item_id");
            return (Criteria) this;
        }

        public Criteria andEach_item_idBetween(Long value1, Long value2) {
            addCriterion("`each_item_id` between", value1, value2, "each_item_id");
            return (Criteria) this;
        }

        public Criteria andEach_item_idNotBetween(Long value1, Long value2) {
            addCriterion("`each_item_id` not between", value1, value2, "each_item_id");
            return (Criteria) this;
        }

        public Criteria andEach_itemIsNull() {
            addCriterion("`each_item` is null");
            return (Criteria) this;
        }

        public Criteria andEach_itemIsNotNull() {
            addCriterion("`each_item` is not null");
            return (Criteria) this;
        }

        public Criteria andEach_itemEqualTo(String value) {
            addCriterion("`each_item` =", value, "each_item");
            return (Criteria) this;
        }

        public Criteria andEach_itemNotEqualTo(String value) {
            addCriterion("`each_item` <>", value, "each_item");
            return (Criteria) this;
        }

        public Criteria andEach_itemGreaterThan(String value) {
            addCriterion("`each_item` >", value, "each_item");
            return (Criteria) this;
        }

        public Criteria andEach_itemGreaterThanOrEqualTo(String value) {
            addCriterion("`each_item` >=", value, "each_item");
            return (Criteria) this;
        }

        public Criteria andEach_itemLessThan(String value) {
            addCriterion("`each_item` <", value, "each_item");
            return (Criteria) this;
        }

        public Criteria andEach_itemLessThanOrEqualTo(String value) {
            addCriterion("`each_item` <=", value, "each_item");
            return (Criteria) this;
        }

        public Criteria andEach_itemLike(String value) {
            addCriterion("`each_item` like", value, "each_item");
            return (Criteria) this;
        }

        public Criteria andEach_itemNotLike(String value) {
            addCriterion("`each_item` not like", value, "each_item");
            return (Criteria) this;
        }

        public Criteria andEach_itemIn(List<String> values) {
            addCriterion("`each_item` in", values, "each_item");
            return (Criteria) this;
        }

        public Criteria andEach_itemNotIn(List<String> values) {
            addCriterion("`each_item` not in", values, "each_item");
            return (Criteria) this;
        }

        public Criteria andEach_itemBetween(String value1, String value2) {
            addCriterion("`each_item` between", value1, value2, "each_item");
            return (Criteria) this;
        }

        public Criteria andEach_itemNotBetween(String value1, String value2) {
            addCriterion("`each_item` not between", value1, value2, "each_item");
            return (Criteria) this;
        }

        public Criteria andEach_feeIsNull() {
            addCriterion("`each_fee` is null");
            return (Criteria) this;
        }

        public Criteria andEach_feeIsNotNull() {
            addCriterion("`each_fee` is not null");
            return (Criteria) this;
        }

        public Criteria andEach_feeEqualTo(String value) {
            addCriterion("`each_fee` =", value, "each_fee");
            return (Criteria) this;
        }

        public Criteria andEach_feeNotEqualTo(String value) {
            addCriterion("`each_fee` <>", value, "each_fee");
            return (Criteria) this;
        }

        public Criteria andEach_feeGreaterThan(String value) {
            addCriterion("`each_fee` >", value, "each_fee");
            return (Criteria) this;
        }

        public Criteria andEach_feeGreaterThanOrEqualTo(String value) {
            addCriterion("`each_fee` >=", value, "each_fee");
            return (Criteria) this;
        }

        public Criteria andEach_feeLessThan(String value) {
            addCriterion("`each_fee` <", value, "each_fee");
            return (Criteria) this;
        }

        public Criteria andEach_feeLessThanOrEqualTo(String value) {
            addCriterion("`each_fee` <=", value, "each_fee");
            return (Criteria) this;
        }

        public Criteria andEach_feeLike(String value) {
            addCriterion("`each_fee` like", value, "each_fee");
            return (Criteria) this;
        }

        public Criteria andEach_feeNotLike(String value) {
            addCriterion("`each_fee` not like", value, "each_fee");
            return (Criteria) this;
        }

        public Criteria andEach_feeIn(List<String> values) {
            addCriterion("`each_fee` in", values, "each_fee");
            return (Criteria) this;
        }

        public Criteria andEach_feeNotIn(List<String> values) {
            addCriterion("`each_fee` not in", values, "each_fee");
            return (Criteria) this;
        }

        public Criteria andEach_feeBetween(String value1, String value2) {
            addCriterion("`each_fee` between", value1, value2, "each_fee");
            return (Criteria) this;
        }

        public Criteria andEach_feeNotBetween(String value1, String value2) {
            addCriterion("`each_fee` not between", value1, value2, "each_fee");
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

        public Criteria andPay_idIsNull() {
            addCriterion("`pay_id` is null");
            return (Criteria) this;
        }

        public Criteria andPay_idIsNotNull() {
            addCriterion("`pay_id` is not null");
            return (Criteria) this;
        }

        public Criteria andPay_idEqualTo(Long value) {
            addCriterion("`pay_id` =", value, "pay_id");
            return (Criteria) this;
        }

        public Criteria andPay_idNotEqualTo(Long value) {
            addCriterion("`pay_id` <>", value, "pay_id");
            return (Criteria) this;
        }

        public Criteria andPay_idGreaterThan(Long value) {
            addCriterion("`pay_id` >", value, "pay_id");
            return (Criteria) this;
        }

        public Criteria andPay_idGreaterThanOrEqualTo(Long value) {
            addCriterion("`pay_id` >=", value, "pay_id");
            return (Criteria) this;
        }

        public Criteria andPay_idLessThan(Long value) {
            addCriterion("`pay_id` <", value, "pay_id");
            return (Criteria) this;
        }

        public Criteria andPay_idLessThanOrEqualTo(Long value) {
            addCriterion("`pay_id` <=", value, "pay_id");
            return (Criteria) this;
        }

        public Criteria andPay_idIn(List<Long> values) {
            addCriterion("`pay_id` in", values, "pay_id");
            return (Criteria) this;
        }

        public Criteria andPay_idNotIn(List<Long> values) {
            addCriterion("`pay_id` not in", values, "pay_id");
            return (Criteria) this;
        }

        public Criteria andPay_idBetween(Long value1, Long value2) {
            addCriterion("`pay_id` between", value1, value2, "pay_id");
            return (Criteria) this;
        }

        public Criteria andPay_idNotBetween(Long value1, Long value2) {
            addCriterion("`pay_id` not between", value1, value2, "pay_id");
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
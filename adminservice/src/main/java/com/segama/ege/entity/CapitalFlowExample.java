package com.segama.ege.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CapitalFlowExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public CapitalFlowExample() {
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

        public Criteria andBank_card_numIsNull() {
            addCriterion("`bank_card_num` is null");
            return (Criteria) this;
        }

        public Criteria andBank_card_numIsNotNull() {
            addCriterion("`bank_card_num` is not null");
            return (Criteria) this;
        }

        public Criteria andBank_card_numEqualTo(String value) {
            addCriterion("`bank_card_num` =", value, "bank_card_num");
            return (Criteria) this;
        }

        public Criteria andBank_card_numNotEqualTo(String value) {
            addCriterion("`bank_card_num` <>", value, "bank_card_num");
            return (Criteria) this;
        }

        public Criteria andBank_card_numGreaterThan(String value) {
            addCriterion("`bank_card_num` >", value, "bank_card_num");
            return (Criteria) this;
        }

        public Criteria andBank_card_numGreaterThanOrEqualTo(String value) {
            addCriterion("`bank_card_num` >=", value, "bank_card_num");
            return (Criteria) this;
        }

        public Criteria andBank_card_numLessThan(String value) {
            addCriterion("`bank_card_num` <", value, "bank_card_num");
            return (Criteria) this;
        }

        public Criteria andBank_card_numLessThanOrEqualTo(String value) {
            addCriterion("`bank_card_num` <=", value, "bank_card_num");
            return (Criteria) this;
        }

        public Criteria andBank_card_numLike(String value) {
            addCriterion("`bank_card_num` like", value, "bank_card_num");
            return (Criteria) this;
        }

        public Criteria andBank_card_numNotLike(String value) {
            addCriterion("`bank_card_num` not like", value, "bank_card_num");
            return (Criteria) this;
        }

        public Criteria andBank_card_numIn(List<String> values) {
            addCriterion("`bank_card_num` in", values, "bank_card_num");
            return (Criteria) this;
        }

        public Criteria andBank_card_numNotIn(List<String> values) {
            addCriterion("`bank_card_num` not in", values, "bank_card_num");
            return (Criteria) this;
        }

        public Criteria andBank_card_numBetween(String value1, String value2) {
            addCriterion("`bank_card_num` between", value1, value2, "bank_card_num");
            return (Criteria) this;
        }

        public Criteria andBank_card_numNotBetween(String value1, String value2) {
            addCriterion("`bank_card_num` not between", value1, value2, "bank_card_num");
            return (Criteria) this;
        }

        public Criteria andPayeeIsNull() {
            addCriterion("`payee` is null");
            return (Criteria) this;
        }

        public Criteria andPayeeIsNotNull() {
            addCriterion("`payee` is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeEqualTo(String value) {
            addCriterion("`payee` =", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeNotEqualTo(String value) {
            addCriterion("`payee` <>", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeGreaterThan(String value) {
            addCriterion("`payee` >", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeGreaterThanOrEqualTo(String value) {
            addCriterion("`payee` >=", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeLessThan(String value) {
            addCriterion("`payee` <", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeLessThanOrEqualTo(String value) {
            addCriterion("`payee` <=", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeLike(String value) {
            addCriterion("`payee` like", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeNotLike(String value) {
            addCriterion("`payee` not like", value, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeIn(List<String> values) {
            addCriterion("`payee` in", values, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeNotIn(List<String> values) {
            addCriterion("`payee` not in", values, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeBetween(String value1, String value2) {
            addCriterion("`payee` between", value1, value2, "payee");
            return (Criteria) this;
        }

        public Criteria andPayeeNotBetween(String value1, String value2) {
            addCriterion("`payee` not between", value1, value2, "payee");
            return (Criteria) this;
        }

        public Criteria andOpening_bankIsNull() {
            addCriterion("`opening_bank` is null");
            return (Criteria) this;
        }

        public Criteria andOpening_bankIsNotNull() {
            addCriterion("`opening_bank` is not null");
            return (Criteria) this;
        }

        public Criteria andOpening_bankEqualTo(String value) {
            addCriterion("`opening_bank` =", value, "opening_bank");
            return (Criteria) this;
        }

        public Criteria andOpening_bankNotEqualTo(String value) {
            addCriterion("`opening_bank` <>", value, "opening_bank");
            return (Criteria) this;
        }

        public Criteria andOpening_bankGreaterThan(String value) {
            addCriterion("`opening_bank` >", value, "opening_bank");
            return (Criteria) this;
        }

        public Criteria andOpening_bankGreaterThanOrEqualTo(String value) {
            addCriterion("`opening_bank` >=", value, "opening_bank");
            return (Criteria) this;
        }

        public Criteria andOpening_bankLessThan(String value) {
            addCriterion("`opening_bank` <", value, "opening_bank");
            return (Criteria) this;
        }

        public Criteria andOpening_bankLessThanOrEqualTo(String value) {
            addCriterion("`opening_bank` <=", value, "opening_bank");
            return (Criteria) this;
        }

        public Criteria andOpening_bankLike(String value) {
            addCriterion("`opening_bank` like", value, "opening_bank");
            return (Criteria) this;
        }

        public Criteria andOpening_bankNotLike(String value) {
            addCriterion("`opening_bank` not like", value, "opening_bank");
            return (Criteria) this;
        }

        public Criteria andOpening_bankIn(List<String> values) {
            addCriterion("`opening_bank` in", values, "opening_bank");
            return (Criteria) this;
        }

        public Criteria andOpening_bankNotIn(List<String> values) {
            addCriterion("`opening_bank` not in", values, "opening_bank");
            return (Criteria) this;
        }

        public Criteria andOpening_bankBetween(String value1, String value2) {
            addCriterion("`opening_bank` between", value1, value2, "opening_bank");
            return (Criteria) this;
        }

        public Criteria andOpening_bankNotBetween(String value1, String value2) {
            addCriterion("`opening_bank` not between", value1, value2, "opening_bank");
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

        public Criteria andOperate_typeEqualTo(Long value) {
            addCriterion("`operate_type` =", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeNotEqualTo(Long value) {
            addCriterion("`operate_type` <>", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeGreaterThan(Long value) {
            addCriterion("`operate_type` >", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeGreaterThanOrEqualTo(Long value) {
            addCriterion("`operate_type` >=", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeLessThan(Long value) {
            addCriterion("`operate_type` <", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeLessThanOrEqualTo(Long value) {
            addCriterion("`operate_type` <=", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeIn(List<Long> values) {
            addCriterion("`operate_type` in", values, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeNotIn(List<Long> values) {
            addCriterion("`operate_type` not in", values, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeBetween(Long value1, Long value2) {
            addCriterion("`operate_type` between", value1, value2, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeNotBetween(Long value1, Long value2) {
            addCriterion("`operate_type` not between", value1, value2, "operate_type");
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

        public Criteria andVerify_idIsNull() {
            addCriterion("`verify_id` is null");
            return (Criteria) this;
        }

        public Criteria andVerify_idIsNotNull() {
            addCriterion("`verify_id` is not null");
            return (Criteria) this;
        }

        public Criteria andVerify_idEqualTo(Long value) {
            addCriterion("`verify_id` =", value, "verify_id");
            return (Criteria) this;
        }

        public Criteria andVerify_idNotEqualTo(Long value) {
            addCriterion("`verify_id` <>", value, "verify_id");
            return (Criteria) this;
        }

        public Criteria andVerify_idGreaterThan(Long value) {
            addCriterion("`verify_id` >", value, "verify_id");
            return (Criteria) this;
        }

        public Criteria andVerify_idGreaterThanOrEqualTo(Long value) {
            addCriterion("`verify_id` >=", value, "verify_id");
            return (Criteria) this;
        }

        public Criteria andVerify_idLessThan(Long value) {
            addCriterion("`verify_id` <", value, "verify_id");
            return (Criteria) this;
        }

        public Criteria andVerify_idLessThanOrEqualTo(Long value) {
            addCriterion("`verify_id` <=", value, "verify_id");
            return (Criteria) this;
        }

        public Criteria andVerify_idIn(List<Long> values) {
            addCriterion("`verify_id` in", values, "verify_id");
            return (Criteria) this;
        }

        public Criteria andVerify_idNotIn(List<Long> values) {
            addCriterion("`verify_id` not in", values, "verify_id");
            return (Criteria) this;
        }

        public Criteria andVerify_idBetween(Long value1, Long value2) {
            addCriterion("`verify_id` between", value1, value2, "verify_id");
            return (Criteria) this;
        }

        public Criteria andVerify_idNotBetween(Long value1, Long value2) {
            addCriterion("`verify_id` not between", value1, value2, "verify_id");
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

        public Criteria andTotal_amountIsNull() {
            addCriterion("`total_amount` is null");
            return (Criteria) this;
        }

        public Criteria andTotal_amountIsNotNull() {
            addCriterion("`total_amount` is not null");
            return (Criteria) this;
        }

        public Criteria andTotal_amountEqualTo(String value) {
            addCriterion("`total_amount` =", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountNotEqualTo(String value) {
            addCriterion("`total_amount` <>", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountGreaterThan(String value) {
            addCriterion("`total_amount` >", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountGreaterThanOrEqualTo(String value) {
            addCriterion("`total_amount` >=", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountLessThan(String value) {
            addCriterion("`total_amount` <", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountLessThanOrEqualTo(String value) {
            addCriterion("`total_amount` <=", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountLike(String value) {
            addCriterion("`total_amount` like", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountNotLike(String value) {
            addCriterion("`total_amount` not like", value, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountIn(List<String> values) {
            addCriterion("`total_amount` in", values, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountNotIn(List<String> values) {
            addCriterion("`total_amount` not in", values, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountBetween(String value1, String value2) {
            addCriterion("`total_amount` between", value1, value2, "total_amount");
            return (Criteria) this;
        }

        public Criteria andTotal_amountNotBetween(String value1, String value2) {
            addCriterion("`total_amount` not between", value1, value2, "total_amount");
            return (Criteria) this;
        }

        public Criteria andFreezing_amountIsNull() {
            addCriterion("`freezing_amount` is null");
            return (Criteria) this;
        }

        public Criteria andFreezing_amountIsNotNull() {
            addCriterion("`freezing_amount` is not null");
            return (Criteria) this;
        }

        public Criteria andFreezing_amountEqualTo(String value) {
            addCriterion("`freezing_amount` =", value, "freezing_amount");
            return (Criteria) this;
        }

        public Criteria andFreezing_amountNotEqualTo(String value) {
            addCriterion("`freezing_amount` <>", value, "freezing_amount");
            return (Criteria) this;
        }

        public Criteria andFreezing_amountGreaterThan(String value) {
            addCriterion("`freezing_amount` >", value, "freezing_amount");
            return (Criteria) this;
        }

        public Criteria andFreezing_amountGreaterThanOrEqualTo(String value) {
            addCriterion("`freezing_amount` >=", value, "freezing_amount");
            return (Criteria) this;
        }

        public Criteria andFreezing_amountLessThan(String value) {
            addCriterion("`freezing_amount` <", value, "freezing_amount");
            return (Criteria) this;
        }

        public Criteria andFreezing_amountLessThanOrEqualTo(String value) {
            addCriterion("`freezing_amount` <=", value, "freezing_amount");
            return (Criteria) this;
        }

        public Criteria andFreezing_amountLike(String value) {
            addCriterion("`freezing_amount` like", value, "freezing_amount");
            return (Criteria) this;
        }

        public Criteria andFreezing_amountNotLike(String value) {
            addCriterion("`freezing_amount` not like", value, "freezing_amount");
            return (Criteria) this;
        }

        public Criteria andFreezing_amountIn(List<String> values) {
            addCriterion("`freezing_amount` in", values, "freezing_amount");
            return (Criteria) this;
        }

        public Criteria andFreezing_amountNotIn(List<String> values) {
            addCriterion("`freezing_amount` not in", values, "freezing_amount");
            return (Criteria) this;
        }

        public Criteria andFreezing_amountBetween(String value1, String value2) {
            addCriterion("`freezing_amount` between", value1, value2, "freezing_amount");
            return (Criteria) this;
        }

        public Criteria andFreezing_amountNotBetween(String value1, String value2) {
            addCriterion("`freezing_amount` not between", value1, value2, "freezing_amount");
            return (Criteria) this;
        }

        public Criteria andAvailable_amountIsNull() {
            addCriterion("`available_amount` is null");
            return (Criteria) this;
        }

        public Criteria andAvailable_amountIsNotNull() {
            addCriterion("`available_amount` is not null");
            return (Criteria) this;
        }

        public Criteria andAvailable_amountEqualTo(String value) {
            addCriterion("`available_amount` =", value, "available_amount");
            return (Criteria) this;
        }

        public Criteria andAvailable_amountNotEqualTo(String value) {
            addCriterion("`available_amount` <>", value, "available_amount");
            return (Criteria) this;
        }

        public Criteria andAvailable_amountGreaterThan(String value) {
            addCriterion("`available_amount` >", value, "available_amount");
            return (Criteria) this;
        }

        public Criteria andAvailable_amountGreaterThanOrEqualTo(String value) {
            addCriterion("`available_amount` >=", value, "available_amount");
            return (Criteria) this;
        }

        public Criteria andAvailable_amountLessThan(String value) {
            addCriterion("`available_amount` <", value, "available_amount");
            return (Criteria) this;
        }

        public Criteria andAvailable_amountLessThanOrEqualTo(String value) {
            addCriterion("`available_amount` <=", value, "available_amount");
            return (Criteria) this;
        }

        public Criteria andAvailable_amountLike(String value) {
            addCriterion("`available_amount` like", value, "available_amount");
            return (Criteria) this;
        }

        public Criteria andAvailable_amountNotLike(String value) {
            addCriterion("`available_amount` not like", value, "available_amount");
            return (Criteria) this;
        }

        public Criteria andAvailable_amountIn(List<String> values) {
            addCriterion("`available_amount` in", values, "available_amount");
            return (Criteria) this;
        }

        public Criteria andAvailable_amountNotIn(List<String> values) {
            addCriterion("`available_amount` not in", values, "available_amount");
            return (Criteria) this;
        }

        public Criteria andAvailable_amountBetween(String value1, String value2) {
            addCriterion("`available_amount` between", value1, value2, "available_amount");
            return (Criteria) this;
        }

        public Criteria andAvailable_amountNotBetween(String value1, String value2) {
            addCriterion("`available_amount` not between", value1, value2, "available_amount");
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
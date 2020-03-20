package com.segama.ege.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public ServiceOrderExample() {
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

        public Criteria andCar_idIsNull() {
            addCriterion("`car_id` is null");
            return (Criteria) this;
        }

        public Criteria andCar_idIsNotNull() {
            addCriterion("`car_id` is not null");
            return (Criteria) this;
        }

        public Criteria andCar_idEqualTo(Long value) {
            addCriterion("`car_id` =", value, "car_id");
            return (Criteria) this;
        }

        public Criteria andCar_idNotEqualTo(Long value) {
            addCriterion("`car_id` <>", value, "car_id");
            return (Criteria) this;
        }

        public Criteria andCar_idGreaterThan(Long value) {
            addCriterion("`car_id` >", value, "car_id");
            return (Criteria) this;
        }

        public Criteria andCar_idGreaterThanOrEqualTo(Long value) {
            addCriterion("`car_id` >=", value, "car_id");
            return (Criteria) this;
        }

        public Criteria andCar_idLessThan(Long value) {
            addCriterion("`car_id` <", value, "car_id");
            return (Criteria) this;
        }

        public Criteria andCar_idLessThanOrEqualTo(Long value) {
            addCriterion("`car_id` <=", value, "car_id");
            return (Criteria) this;
        }

        public Criteria andCar_idIn(List<Long> values) {
            addCriterion("`car_id` in", values, "car_id");
            return (Criteria) this;
        }

        public Criteria andCar_idNotIn(List<Long> values) {
            addCriterion("`car_id` not in", values, "car_id");
            return (Criteria) this;
        }

        public Criteria andCar_idBetween(Long value1, Long value2) {
            addCriterion("`car_id` between", value1, value2, "car_id");
            return (Criteria) this;
        }

        public Criteria andCar_idNotBetween(Long value1, Long value2) {
            addCriterion("`car_id` not between", value1, value2, "car_id");
            return (Criteria) this;
        }

        public Criteria andCar_plateIsNull() {
            addCriterion("`car_plate` is null");
            return (Criteria) this;
        }

        public Criteria andCar_plateIsNotNull() {
            addCriterion("`car_plate` is not null");
            return (Criteria) this;
        }

        public Criteria andCar_plateEqualTo(String value) {
            addCriterion("`car_plate` =", value, "car_plate");
            return (Criteria) this;
        }

        public Criteria andCar_plateNotEqualTo(String value) {
            addCriterion("`car_plate` <>", value, "car_plate");
            return (Criteria) this;
        }

        public Criteria andCar_plateGreaterThan(String value) {
            addCriterion("`car_plate` >", value, "car_plate");
            return (Criteria) this;
        }

        public Criteria andCar_plateGreaterThanOrEqualTo(String value) {
            addCriterion("`car_plate` >=", value, "car_plate");
            return (Criteria) this;
        }

        public Criteria andCar_plateLessThan(String value) {
            addCriterion("`car_plate` <", value, "car_plate");
            return (Criteria) this;
        }

        public Criteria andCar_plateLessThanOrEqualTo(String value) {
            addCriterion("`car_plate` <=", value, "car_plate");
            return (Criteria) this;
        }

        public Criteria andCar_plateLike(String value) {
            addCriterion("`car_plate` like", value, "car_plate");
            return (Criteria) this;
        }

        public Criteria andCar_plateNotLike(String value) {
            addCriterion("`car_plate` not like", value, "car_plate");
            return (Criteria) this;
        }

        public Criteria andCar_plateIn(List<String> values) {
            addCriterion("`car_plate` in", values, "car_plate");
            return (Criteria) this;
        }

        public Criteria andCar_plateNotIn(List<String> values) {
            addCriterion("`car_plate` not in", values, "car_plate");
            return (Criteria) this;
        }

        public Criteria andCar_plateBetween(String value1, String value2) {
            addCriterion("`car_plate` between", value1, value2, "car_plate");
            return (Criteria) this;
        }

        public Criteria andCar_plateNotBetween(String value1, String value2) {
            addCriterion("`car_plate` not between", value1, value2, "car_plate");
            return (Criteria) this;
        }

        public Criteria andCar_type_nameIsNull() {
            addCriterion("`car_type_name` is null");
            return (Criteria) this;
        }

        public Criteria andCar_type_nameIsNotNull() {
            addCriterion("`car_type_name` is not null");
            return (Criteria) this;
        }

        public Criteria andCar_type_nameEqualTo(String value) {
            addCriterion("`car_type_name` =", value, "car_type_name");
            return (Criteria) this;
        }

        public Criteria andCar_type_nameNotEqualTo(String value) {
            addCriterion("`car_type_name` <>", value, "car_type_name");
            return (Criteria) this;
        }

        public Criteria andCar_type_nameGreaterThan(String value) {
            addCriterion("`car_type_name` >", value, "car_type_name");
            return (Criteria) this;
        }

        public Criteria andCar_type_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`car_type_name` >=", value, "car_type_name");
            return (Criteria) this;
        }

        public Criteria andCar_type_nameLessThan(String value) {
            addCriterion("`car_type_name` <", value, "car_type_name");
            return (Criteria) this;
        }

        public Criteria andCar_type_nameLessThanOrEqualTo(String value) {
            addCriterion("`car_type_name` <=", value, "car_type_name");
            return (Criteria) this;
        }

        public Criteria andCar_type_nameLike(String value) {
            addCriterion("`car_type_name` like", value, "car_type_name");
            return (Criteria) this;
        }

        public Criteria andCar_type_nameNotLike(String value) {
            addCriterion("`car_type_name` not like", value, "car_type_name");
            return (Criteria) this;
        }

        public Criteria andCar_type_nameIn(List<String> values) {
            addCriterion("`car_type_name` in", values, "car_type_name");
            return (Criteria) this;
        }

        public Criteria andCar_type_nameNotIn(List<String> values) {
            addCriterion("`car_type_name` not in", values, "car_type_name");
            return (Criteria) this;
        }

        public Criteria andCar_type_nameBetween(String value1, String value2) {
            addCriterion("`car_type_name` between", value1, value2, "car_type_name");
            return (Criteria) this;
        }

        public Criteria andCar_type_nameNotBetween(String value1, String value2) {
            addCriterion("`car_type_name` not between", value1, value2, "car_type_name");
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

        public Criteria andOil_idIsNull() {
            addCriterion("`oil_id` is null");
            return (Criteria) this;
        }

        public Criteria andOil_idIsNotNull() {
            addCriterion("`oil_id` is not null");
            return (Criteria) this;
        }

        public Criteria andOil_idEqualTo(Long value) {
            addCriterion("`oil_id` =", value, "oil_id");
            return (Criteria) this;
        }

        public Criteria andOil_idNotEqualTo(Long value) {
            addCriterion("`oil_id` <>", value, "oil_id");
            return (Criteria) this;
        }

        public Criteria andOil_idGreaterThan(Long value) {
            addCriterion("`oil_id` >", value, "oil_id");
            return (Criteria) this;
        }

        public Criteria andOil_idGreaterThanOrEqualTo(Long value) {
            addCriterion("`oil_id` >=", value, "oil_id");
            return (Criteria) this;
        }

        public Criteria andOil_idLessThan(Long value) {
            addCriterion("`oil_id` <", value, "oil_id");
            return (Criteria) this;
        }

        public Criteria andOil_idLessThanOrEqualTo(Long value) {
            addCriterion("`oil_id` <=", value, "oil_id");
            return (Criteria) this;
        }

        public Criteria andOil_idIn(List<Long> values) {
            addCriterion("`oil_id` in", values, "oil_id");
            return (Criteria) this;
        }

        public Criteria andOil_idNotIn(List<Long> values) {
            addCriterion("`oil_id` not in", values, "oil_id");
            return (Criteria) this;
        }

        public Criteria andOil_idBetween(Long value1, Long value2) {
            addCriterion("`oil_id` between", value1, value2, "oil_id");
            return (Criteria) this;
        }

        public Criteria andOil_idNotBetween(Long value1, Long value2) {
            addCriterion("`oil_id` not between", value1, value2, "oil_id");
            return (Criteria) this;
        }

        public Criteria andOil_brandIsNull() {
            addCriterion("`oil_brand` is null");
            return (Criteria) this;
        }

        public Criteria andOil_brandIsNotNull() {
            addCriterion("`oil_brand` is not null");
            return (Criteria) this;
        }

        public Criteria andOil_brandEqualTo(String value) {
            addCriterion("`oil_brand` =", value, "oil_brand");
            return (Criteria) this;
        }

        public Criteria andOil_brandNotEqualTo(String value) {
            addCriterion("`oil_brand` <>", value, "oil_brand");
            return (Criteria) this;
        }

        public Criteria andOil_brandGreaterThan(String value) {
            addCriterion("`oil_brand` >", value, "oil_brand");
            return (Criteria) this;
        }

        public Criteria andOil_brandGreaterThanOrEqualTo(String value) {
            addCriterion("`oil_brand` >=", value, "oil_brand");
            return (Criteria) this;
        }

        public Criteria andOil_brandLessThan(String value) {
            addCriterion("`oil_brand` <", value, "oil_brand");
            return (Criteria) this;
        }

        public Criteria andOil_brandLessThanOrEqualTo(String value) {
            addCriterion("`oil_brand` <=", value, "oil_brand");
            return (Criteria) this;
        }

        public Criteria andOil_brandLike(String value) {
            addCriterion("`oil_brand` like", value, "oil_brand");
            return (Criteria) this;
        }

        public Criteria andOil_brandNotLike(String value) {
            addCriterion("`oil_brand` not like", value, "oil_brand");
            return (Criteria) this;
        }

        public Criteria andOil_brandIn(List<String> values) {
            addCriterion("`oil_brand` in", values, "oil_brand");
            return (Criteria) this;
        }

        public Criteria andOil_brandNotIn(List<String> values) {
            addCriterion("`oil_brand` not in", values, "oil_brand");
            return (Criteria) this;
        }

        public Criteria andOil_brandBetween(String value1, String value2) {
            addCriterion("`oil_brand` between", value1, value2, "oil_brand");
            return (Criteria) this;
        }

        public Criteria andOil_brandNotBetween(String value1, String value2) {
            addCriterion("`oil_brand` not between", value1, value2, "oil_brand");
            return (Criteria) this;
        }

        public Criteria andService_itemIsNull() {
            addCriterion("`service_item` is null");
            return (Criteria) this;
        }

        public Criteria andService_itemIsNotNull() {
            addCriterion("`service_item` is not null");
            return (Criteria) this;
        }

        public Criteria andService_itemEqualTo(String value) {
            addCriterion("`service_item` =", value, "service_item");
            return (Criteria) this;
        }

        public Criteria andService_itemNotEqualTo(String value) {
            addCriterion("`service_item` <>", value, "service_item");
            return (Criteria) this;
        }

        public Criteria andService_itemGreaterThan(String value) {
            addCriterion("`service_item` >", value, "service_item");
            return (Criteria) this;
        }

        public Criteria andService_itemGreaterThanOrEqualTo(String value) {
            addCriterion("`service_item` >=", value, "service_item");
            return (Criteria) this;
        }

        public Criteria andService_itemLessThan(String value) {
            addCriterion("`service_item` <", value, "service_item");
            return (Criteria) this;
        }

        public Criteria andService_itemLessThanOrEqualTo(String value) {
            addCriterion("`service_item` <=", value, "service_item");
            return (Criteria) this;
        }

        public Criteria andService_itemLike(String value) {
            addCriterion("`service_item` like", value, "service_item");
            return (Criteria) this;
        }

        public Criteria andService_itemNotLike(String value) {
            addCriterion("`service_item` not like", value, "service_item");
            return (Criteria) this;
        }

        public Criteria andService_itemIn(List<String> values) {
            addCriterion("`service_item` in", values, "service_item");
            return (Criteria) this;
        }

        public Criteria andService_itemNotIn(List<String> values) {
            addCriterion("`service_item` not in", values, "service_item");
            return (Criteria) this;
        }

        public Criteria andService_itemBetween(String value1, String value2) {
            addCriterion("`service_item` between", value1, value2, "service_item");
            return (Criteria) this;
        }

        public Criteria andService_itemNotBetween(String value1, String value2) {
            addCriterion("`service_item` not between", value1, value2, "service_item");
            return (Criteria) this;
        }

        public Criteria andOrder_statusIsNull() {
            addCriterion("`order_status` is null");
            return (Criteria) this;
        }

        public Criteria andOrder_statusIsNotNull() {
            addCriterion("`order_status` is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_statusEqualTo(String value) {
            addCriterion("`order_status` =", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusNotEqualTo(String value) {
            addCriterion("`order_status` <>", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusGreaterThan(String value) {
            addCriterion("`order_status` >", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusGreaterThanOrEqualTo(String value) {
            addCriterion("`order_status` >=", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusLessThan(String value) {
            addCriterion("`order_status` <", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusLessThanOrEqualTo(String value) {
            addCriterion("`order_status` <=", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusLike(String value) {
            addCriterion("`order_status` like", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusNotLike(String value) {
            addCriterion("`order_status` not like", value, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusIn(List<String> values) {
            addCriterion("`order_status` in", values, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusNotIn(List<String> values) {
            addCriterion("`order_status` not in", values, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusBetween(String value1, String value2) {
            addCriterion("`order_status` between", value1, value2, "order_status");
            return (Criteria) this;
        }

        public Criteria andOrder_statusNotBetween(String value1, String value2) {
            addCriterion("`order_status` not between", value1, value2, "order_status");
            return (Criteria) this;
        }

        public Criteria andService_pacakge_idIsNull() {
            addCriterion("`service_pacakge_id` is null");
            return (Criteria) this;
        }

        public Criteria andService_pacakge_idIsNotNull() {
            addCriterion("`service_pacakge_id` is not null");
            return (Criteria) this;
        }

        public Criteria andService_pacakge_idEqualTo(Long value) {
            addCriterion("`service_pacakge_id` =", value, "service_pacakge_id");
            return (Criteria) this;
        }

        public Criteria andService_pacakge_idNotEqualTo(Long value) {
            addCriterion("`service_pacakge_id` <>", value, "service_pacakge_id");
            return (Criteria) this;
        }

        public Criteria andService_pacakge_idGreaterThan(Long value) {
            addCriterion("`service_pacakge_id` >", value, "service_pacakge_id");
            return (Criteria) this;
        }

        public Criteria andService_pacakge_idGreaterThanOrEqualTo(Long value) {
            addCriterion("`service_pacakge_id` >=", value, "service_pacakge_id");
            return (Criteria) this;
        }

        public Criteria andService_pacakge_idLessThan(Long value) {
            addCriterion("`service_pacakge_id` <", value, "service_pacakge_id");
            return (Criteria) this;
        }

        public Criteria andService_pacakge_idLessThanOrEqualTo(Long value) {
            addCriterion("`service_pacakge_id` <=", value, "service_pacakge_id");
            return (Criteria) this;
        }

        public Criteria andService_pacakge_idIn(List<Long> values) {
            addCriterion("`service_pacakge_id` in", values, "service_pacakge_id");
            return (Criteria) this;
        }

        public Criteria andService_pacakge_idNotIn(List<Long> values) {
            addCriterion("`service_pacakge_id` not in", values, "service_pacakge_id");
            return (Criteria) this;
        }

        public Criteria andService_pacakge_idBetween(Long value1, Long value2) {
            addCriterion("`service_pacakge_id` between", value1, value2, "service_pacakge_id");
            return (Criteria) this;
        }

        public Criteria andService_pacakge_idNotBetween(Long value1, Long value2) {
            addCriterion("`service_pacakge_id` not between", value1, value2, "service_pacakge_id");
            return (Criteria) this;
        }

        public Criteria andReport_idIsNull() {
            addCriterion("`report_id` is null");
            return (Criteria) this;
        }

        public Criteria andReport_idIsNotNull() {
            addCriterion("`report_id` is not null");
            return (Criteria) this;
        }

        public Criteria andReport_idEqualTo(Long value) {
            addCriterion("`report_id` =", value, "report_id");
            return (Criteria) this;
        }

        public Criteria andReport_idNotEqualTo(Long value) {
            addCriterion("`report_id` <>", value, "report_id");
            return (Criteria) this;
        }

        public Criteria andReport_idGreaterThan(Long value) {
            addCriterion("`report_id` >", value, "report_id");
            return (Criteria) this;
        }

        public Criteria andReport_idGreaterThanOrEqualTo(Long value) {
            addCriterion("`report_id` >=", value, "report_id");
            return (Criteria) this;
        }

        public Criteria andReport_idLessThan(Long value) {
            addCriterion("`report_id` <", value, "report_id");
            return (Criteria) this;
        }

        public Criteria andReport_idLessThanOrEqualTo(Long value) {
            addCriterion("`report_id` <=", value, "report_id");
            return (Criteria) this;
        }

        public Criteria andReport_idIn(List<Long> values) {
            addCriterion("`report_id` in", values, "report_id");
            return (Criteria) this;
        }

        public Criteria andReport_idNotIn(List<Long> values) {
            addCriterion("`report_id` not in", values, "report_id");
            return (Criteria) this;
        }

        public Criteria andReport_idBetween(Long value1, Long value2) {
            addCriterion("`report_id` between", value1, value2, "report_id");
            return (Criteria) this;
        }

        public Criteria andReport_idNotBetween(Long value1, Long value2) {
            addCriterion("`report_id` not between", value1, value2, "report_id");
            return (Criteria) this;
        }

        public Criteria andEstimated_feeIsNull() {
            addCriterion("`estimated_fee` is null");
            return (Criteria) this;
        }

        public Criteria andEstimated_feeIsNotNull() {
            addCriterion("`estimated_fee` is not null");
            return (Criteria) this;
        }

        public Criteria andEstimated_feeEqualTo(String value) {
            addCriterion("`estimated_fee` =", value, "estimated_fee");
            return (Criteria) this;
        }

        public Criteria andEstimated_feeNotEqualTo(String value) {
            addCriterion("`estimated_fee` <>", value, "estimated_fee");
            return (Criteria) this;
        }

        public Criteria andEstimated_feeGreaterThan(String value) {
            addCriterion("`estimated_fee` >", value, "estimated_fee");
            return (Criteria) this;
        }

        public Criteria andEstimated_feeGreaterThanOrEqualTo(String value) {
            addCriterion("`estimated_fee` >=", value, "estimated_fee");
            return (Criteria) this;
        }

        public Criteria andEstimated_feeLessThan(String value) {
            addCriterion("`estimated_fee` <", value, "estimated_fee");
            return (Criteria) this;
        }

        public Criteria andEstimated_feeLessThanOrEqualTo(String value) {
            addCriterion("`estimated_fee` <=", value, "estimated_fee");
            return (Criteria) this;
        }

        public Criteria andEstimated_feeLike(String value) {
            addCriterion("`estimated_fee` like", value, "estimated_fee");
            return (Criteria) this;
        }

        public Criteria andEstimated_feeNotLike(String value) {
            addCriterion("`estimated_fee` not like", value, "estimated_fee");
            return (Criteria) this;
        }

        public Criteria andEstimated_feeIn(List<String> values) {
            addCriterion("`estimated_fee` in", values, "estimated_fee");
            return (Criteria) this;
        }

        public Criteria andEstimated_feeNotIn(List<String> values) {
            addCriterion("`estimated_fee` not in", values, "estimated_fee");
            return (Criteria) this;
        }

        public Criteria andEstimated_feeBetween(String value1, String value2) {
            addCriterion("`estimated_fee` between", value1, value2, "estimated_fee");
            return (Criteria) this;
        }

        public Criteria andEstimated_feeNotBetween(String value1, String value2) {
            addCriterion("`estimated_fee` not between", value1, value2, "estimated_fee");
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

        public Criteria andOrder_qr_codeIsNull() {
            addCriterion("`order_qr_code` is null");
            return (Criteria) this;
        }

        public Criteria andOrder_qr_codeIsNotNull() {
            addCriterion("`order_qr_code` is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_qr_codeEqualTo(String value) {
            addCriterion("`order_qr_code` =", value, "order_qr_code");
            return (Criteria) this;
        }

        public Criteria andOrder_qr_codeNotEqualTo(String value) {
            addCriterion("`order_qr_code` <>", value, "order_qr_code");
            return (Criteria) this;
        }

        public Criteria andOrder_qr_codeGreaterThan(String value) {
            addCriterion("`order_qr_code` >", value, "order_qr_code");
            return (Criteria) this;
        }

        public Criteria andOrder_qr_codeGreaterThanOrEqualTo(String value) {
            addCriterion("`order_qr_code` >=", value, "order_qr_code");
            return (Criteria) this;
        }

        public Criteria andOrder_qr_codeLessThan(String value) {
            addCriterion("`order_qr_code` <", value, "order_qr_code");
            return (Criteria) this;
        }

        public Criteria andOrder_qr_codeLessThanOrEqualTo(String value) {
            addCriterion("`order_qr_code` <=", value, "order_qr_code");
            return (Criteria) this;
        }

        public Criteria andOrder_qr_codeLike(String value) {
            addCriterion("`order_qr_code` like", value, "order_qr_code");
            return (Criteria) this;
        }

        public Criteria andOrder_qr_codeNotLike(String value) {
            addCriterion("`order_qr_code` not like", value, "order_qr_code");
            return (Criteria) this;
        }

        public Criteria andOrder_qr_codeIn(List<String> values) {
            addCriterion("`order_qr_code` in", values, "order_qr_code");
            return (Criteria) this;
        }

        public Criteria andOrder_qr_codeNotIn(List<String> values) {
            addCriterion("`order_qr_code` not in", values, "order_qr_code");
            return (Criteria) this;
        }

        public Criteria andOrder_qr_codeBetween(String value1, String value2) {
            addCriterion("`order_qr_code` between", value1, value2, "order_qr_code");
            return (Criteria) this;
        }

        public Criteria andOrder_qr_codeNotBetween(String value1, String value2) {
            addCriterion("`order_qr_code` not between", value1, value2, "order_qr_code");
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

        public Criteria andGmt_confirmIsNull() {
            addCriterion("`gmt_confirm` is null");
            return (Criteria) this;
        }

        public Criteria andGmt_confirmIsNotNull() {
            addCriterion("`gmt_confirm` is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_confirmEqualTo(Date value) {
            addCriterion("`gmt_confirm` =", value, "gmt_confirm");
            return (Criteria) this;
        }

        public Criteria andGmt_confirmNotEqualTo(Date value) {
            addCriterion("`gmt_confirm` <>", value, "gmt_confirm");
            return (Criteria) this;
        }

        public Criteria andGmt_confirmGreaterThan(Date value) {
            addCriterion("`gmt_confirm` >", value, "gmt_confirm");
            return (Criteria) this;
        }

        public Criteria andGmt_confirmGreaterThanOrEqualTo(Date value) {
            addCriterion("`gmt_confirm` >=", value, "gmt_confirm");
            return (Criteria) this;
        }

        public Criteria andGmt_confirmLessThan(Date value) {
            addCriterion("`gmt_confirm` <", value, "gmt_confirm");
            return (Criteria) this;
        }

        public Criteria andGmt_confirmLessThanOrEqualTo(Date value) {
            addCriterion("`gmt_confirm` <=", value, "gmt_confirm");
            return (Criteria) this;
        }

        public Criteria andGmt_confirmIn(List<Date> values) {
            addCriterion("`gmt_confirm` in", values, "gmt_confirm");
            return (Criteria) this;
        }

        public Criteria andGmt_confirmNotIn(List<Date> values) {
            addCriterion("`gmt_confirm` not in", values, "gmt_confirm");
            return (Criteria) this;
        }

        public Criteria andGmt_confirmBetween(Date value1, Date value2) {
            addCriterion("`gmt_confirm` between", value1, value2, "gmt_confirm");
            return (Criteria) this;
        }

        public Criteria andGmt_confirmNotBetween(Date value1, Date value2) {
            addCriterion("`gmt_confirm` not between", value1, value2, "gmt_confirm");
            return (Criteria) this;
        }

        public Criteria andGmt_service_dateIsNull() {
            addCriterion("`gmt_service_date` is null");
            return (Criteria) this;
        }

        public Criteria andGmt_service_dateIsNotNull() {
            addCriterion("`gmt_service_date` is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_service_dateEqualTo(String value) {
            addCriterion("`gmt_service_date` =", value, "gmt_service_date");
            return (Criteria) this;
        }

        public Criteria andGmt_service_dateNotEqualTo(String value) {
            addCriterion("`gmt_service_date` <>", value, "gmt_service_date");
            return (Criteria) this;
        }

        public Criteria andGmt_service_dateGreaterThan(String value) {
            addCriterion("`gmt_service_date` >", value, "gmt_service_date");
            return (Criteria) this;
        }

        public Criteria andGmt_service_dateGreaterThanOrEqualTo(String value) {
            addCriterion("`gmt_service_date` >=", value, "gmt_service_date");
            return (Criteria) this;
        }

        public Criteria andGmt_service_dateLessThan(String value) {
            addCriterion("`gmt_service_date` <", value, "gmt_service_date");
            return (Criteria) this;
        }

        public Criteria andGmt_service_dateLessThanOrEqualTo(String value) {
            addCriterion("`gmt_service_date` <=", value, "gmt_service_date");
            return (Criteria) this;
        }

        public Criteria andGmt_service_dateLike(String value) {
            addCriterion("`gmt_service_date` like", value, "gmt_service_date");
            return (Criteria) this;
        }

        public Criteria andGmt_service_dateNotLike(String value) {
            addCriterion("`gmt_service_date` not like", value, "gmt_service_date");
            return (Criteria) this;
        }

        public Criteria andGmt_service_dateIn(List<String> values) {
            addCriterion("`gmt_service_date` in", values, "gmt_service_date");
            return (Criteria) this;
        }

        public Criteria andGmt_service_dateNotIn(List<String> values) {
            addCriterion("`gmt_service_date` not in", values, "gmt_service_date");
            return (Criteria) this;
        }

        public Criteria andGmt_service_dateBetween(String value1, String value2) {
            addCriterion("`gmt_service_date` between", value1, value2, "gmt_service_date");
            return (Criteria) this;
        }

        public Criteria andGmt_service_dateNotBetween(String value1, String value2) {
            addCriterion("`gmt_service_date` not between", value1, value2, "gmt_service_date");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_dateIsNull() {
            addCriterion("`gmt_change_service_date` is null");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_dateIsNotNull() {
            addCriterion("`gmt_change_service_date` is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_dateEqualTo(String value) {
            addCriterion("`gmt_change_service_date` =", value, "gmt_change_service_date");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_dateNotEqualTo(String value) {
            addCriterion("`gmt_change_service_date` <>", value, "gmt_change_service_date");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_dateGreaterThan(String value) {
            addCriterion("`gmt_change_service_date` >", value, "gmt_change_service_date");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_dateGreaterThanOrEqualTo(String value) {
            addCriterion("`gmt_change_service_date` >=", value, "gmt_change_service_date");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_dateLessThan(String value) {
            addCriterion("`gmt_change_service_date` <", value, "gmt_change_service_date");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_dateLessThanOrEqualTo(String value) {
            addCriterion("`gmt_change_service_date` <=", value, "gmt_change_service_date");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_dateLike(String value) {
            addCriterion("`gmt_change_service_date` like", value, "gmt_change_service_date");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_dateNotLike(String value) {
            addCriterion("`gmt_change_service_date` not like", value, "gmt_change_service_date");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_dateIn(List<String> values) {
            addCriterion("`gmt_change_service_date` in", values, "gmt_change_service_date");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_dateNotIn(List<String> values) {
            addCriterion("`gmt_change_service_date` not in", values, "gmt_change_service_date");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_dateBetween(String value1, String value2) {
            addCriterion("`gmt_change_service_date` between", value1, value2, "gmt_change_service_date");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_dateNotBetween(String value1, String value2) {
            addCriterion("`gmt_change_service_date` not between", value1, value2, "gmt_change_service_date");
            return (Criteria) this;
        }

        public Criteria andGmt_actual_serviceIsNull() {
            addCriterion("`gmt_actual_service` is null");
            return (Criteria) this;
        }

        public Criteria andGmt_actual_serviceIsNotNull() {
            addCriterion("`gmt_actual_service` is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_actual_serviceEqualTo(Date value) {
            addCriterion("`gmt_actual_service` =", value, "gmt_actual_service");
            return (Criteria) this;
        }

        public Criteria andGmt_actual_serviceNotEqualTo(Date value) {
            addCriterion("`gmt_actual_service` <>", value, "gmt_actual_service");
            return (Criteria) this;
        }

        public Criteria andGmt_actual_serviceGreaterThan(Date value) {
            addCriterion("`gmt_actual_service` >", value, "gmt_actual_service");
            return (Criteria) this;
        }

        public Criteria andGmt_actual_serviceGreaterThanOrEqualTo(Date value) {
            addCriterion("`gmt_actual_service` >=", value, "gmt_actual_service");
            return (Criteria) this;
        }

        public Criteria andGmt_actual_serviceLessThan(Date value) {
            addCriterion("`gmt_actual_service` <", value, "gmt_actual_service");
            return (Criteria) this;
        }

        public Criteria andGmt_actual_serviceLessThanOrEqualTo(Date value) {
            addCriterion("`gmt_actual_service` <=", value, "gmt_actual_service");
            return (Criteria) this;
        }

        public Criteria andGmt_actual_serviceIn(List<Date> values) {
            addCriterion("`gmt_actual_service` in", values, "gmt_actual_service");
            return (Criteria) this;
        }

        public Criteria andGmt_actual_serviceNotIn(List<Date> values) {
            addCriterion("`gmt_actual_service` not in", values, "gmt_actual_service");
            return (Criteria) this;
        }

        public Criteria andGmt_actual_serviceBetween(Date value1, Date value2) {
            addCriterion("`gmt_actual_service` between", value1, value2, "gmt_actual_service");
            return (Criteria) this;
        }

        public Criteria andGmt_actual_serviceNotBetween(Date value1, Date value2) {
            addCriterion("`gmt_actual_service` not between", value1, value2, "gmt_actual_service");
            return (Criteria) this;
        }

        public Criteria andGmt_payIsNull() {
            addCriterion("`gmt_pay` is null");
            return (Criteria) this;
        }

        public Criteria andGmt_payIsNotNull() {
            addCriterion("`gmt_pay` is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_payEqualTo(Date value) {
            addCriterion("`gmt_pay` =", value, "gmt_pay");
            return (Criteria) this;
        }

        public Criteria andGmt_payNotEqualTo(Date value) {
            addCriterion("`gmt_pay` <>", value, "gmt_pay");
            return (Criteria) this;
        }

        public Criteria andGmt_payGreaterThan(Date value) {
            addCriterion("`gmt_pay` >", value, "gmt_pay");
            return (Criteria) this;
        }

        public Criteria andGmt_payGreaterThanOrEqualTo(Date value) {
            addCriterion("`gmt_pay` >=", value, "gmt_pay");
            return (Criteria) this;
        }

        public Criteria andGmt_payLessThan(Date value) {
            addCriterion("`gmt_pay` <", value, "gmt_pay");
            return (Criteria) this;
        }

        public Criteria andGmt_payLessThanOrEqualTo(Date value) {
            addCriterion("`gmt_pay` <=", value, "gmt_pay");
            return (Criteria) this;
        }

        public Criteria andGmt_payIn(List<Date> values) {
            addCriterion("`gmt_pay` in", values, "gmt_pay");
            return (Criteria) this;
        }

        public Criteria andGmt_payNotIn(List<Date> values) {
            addCriterion("`gmt_pay` not in", values, "gmt_pay");
            return (Criteria) this;
        }

        public Criteria andGmt_payBetween(Date value1, Date value2) {
            addCriterion("`gmt_pay` between", value1, value2, "gmt_pay");
            return (Criteria) this;
        }

        public Criteria andGmt_payNotBetween(Date value1, Date value2) {
            addCriterion("`gmt_pay` not between", value1, value2, "gmt_pay");
            return (Criteria) this;
        }

        public Criteria andGmt_evaluateIsNull() {
            addCriterion("`gmt_evaluate` is null");
            return (Criteria) this;
        }

        public Criteria andGmt_evaluateIsNotNull() {
            addCriterion("`gmt_evaluate` is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_evaluateEqualTo(Date value) {
            addCriterion("`gmt_evaluate` =", value, "gmt_evaluate");
            return (Criteria) this;
        }

        public Criteria andGmt_evaluateNotEqualTo(Date value) {
            addCriterion("`gmt_evaluate` <>", value, "gmt_evaluate");
            return (Criteria) this;
        }

        public Criteria andGmt_evaluateGreaterThan(Date value) {
            addCriterion("`gmt_evaluate` >", value, "gmt_evaluate");
            return (Criteria) this;
        }

        public Criteria andGmt_evaluateGreaterThanOrEqualTo(Date value) {
            addCriterion("`gmt_evaluate` >=", value, "gmt_evaluate");
            return (Criteria) this;
        }

        public Criteria andGmt_evaluateLessThan(Date value) {
            addCriterion("`gmt_evaluate` <", value, "gmt_evaluate");
            return (Criteria) this;
        }

        public Criteria andGmt_evaluateLessThanOrEqualTo(Date value) {
            addCriterion("`gmt_evaluate` <=", value, "gmt_evaluate");
            return (Criteria) this;
        }

        public Criteria andGmt_evaluateIn(List<Date> values) {
            addCriterion("`gmt_evaluate` in", values, "gmt_evaluate");
            return (Criteria) this;
        }

        public Criteria andGmt_evaluateNotIn(List<Date> values) {
            addCriterion("`gmt_evaluate` not in", values, "gmt_evaluate");
            return (Criteria) this;
        }

        public Criteria andGmt_evaluateBetween(Date value1, Date value2) {
            addCriterion("`gmt_evaluate` between", value1, value2, "gmt_evaluate");
            return (Criteria) this;
        }

        public Criteria andGmt_evaluateNotBetween(Date value1, Date value2) {
            addCriterion("`gmt_evaluate` not between", value1, value2, "gmt_evaluate");
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

        public Criteria andCar_logo_urlIsNull() {
            addCriterion("`car_logo_url` is null");
            return (Criteria) this;
        }

        public Criteria andCar_logo_urlIsNotNull() {
            addCriterion("`car_logo_url` is not null");
            return (Criteria) this;
        }

        public Criteria andCar_logo_urlEqualTo(String value) {
            addCriterion("`car_logo_url` =", value, "car_logo_url");
            return (Criteria) this;
        }

        public Criteria andCar_logo_urlNotEqualTo(String value) {
            addCriterion("`car_logo_url` <>", value, "car_logo_url");
            return (Criteria) this;
        }

        public Criteria andCar_logo_urlGreaterThan(String value) {
            addCriterion("`car_logo_url` >", value, "car_logo_url");
            return (Criteria) this;
        }

        public Criteria andCar_logo_urlGreaterThanOrEqualTo(String value) {
            addCriterion("`car_logo_url` >=", value, "car_logo_url");
            return (Criteria) this;
        }

        public Criteria andCar_logo_urlLessThan(String value) {
            addCriterion("`car_logo_url` <", value, "car_logo_url");
            return (Criteria) this;
        }

        public Criteria andCar_logo_urlLessThanOrEqualTo(String value) {
            addCriterion("`car_logo_url` <=", value, "car_logo_url");
            return (Criteria) this;
        }

        public Criteria andCar_logo_urlLike(String value) {
            addCriterion("`car_logo_url` like", value, "car_logo_url");
            return (Criteria) this;
        }

        public Criteria andCar_logo_urlNotLike(String value) {
            addCriterion("`car_logo_url` not like", value, "car_logo_url");
            return (Criteria) this;
        }

        public Criteria andCar_logo_urlIn(List<String> values) {
            addCriterion("`car_logo_url` in", values, "car_logo_url");
            return (Criteria) this;
        }

        public Criteria andCar_logo_urlNotIn(List<String> values) {
            addCriterion("`car_logo_url` not in", values, "car_logo_url");
            return (Criteria) this;
        }

        public Criteria andCar_logo_urlBetween(String value1, String value2) {
            addCriterion("`car_logo_url` between", value1, value2, "car_logo_url");
            return (Criteria) this;
        }

        public Criteria andCar_logo_urlNotBetween(String value1, String value2) {
            addCriterion("`car_logo_url` not between", value1, value2, "car_logo_url");
            return (Criteria) this;
        }

        public Criteria andEvaluate_idIsNull() {
            addCriterion("`evaluate_id` is null");
            return (Criteria) this;
        }

        public Criteria andEvaluate_idIsNotNull() {
            addCriterion("`evaluate_id` is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluate_idEqualTo(Long value) {
            addCriterion("`evaluate_id` =", value, "evaluate_id");
            return (Criteria) this;
        }

        public Criteria andEvaluate_idNotEqualTo(Long value) {
            addCriterion("`evaluate_id` <>", value, "evaluate_id");
            return (Criteria) this;
        }

        public Criteria andEvaluate_idGreaterThan(Long value) {
            addCriterion("`evaluate_id` >", value, "evaluate_id");
            return (Criteria) this;
        }

        public Criteria andEvaluate_idGreaterThanOrEqualTo(Long value) {
            addCriterion("`evaluate_id` >=", value, "evaluate_id");
            return (Criteria) this;
        }

        public Criteria andEvaluate_idLessThan(Long value) {
            addCriterion("`evaluate_id` <", value, "evaluate_id");
            return (Criteria) this;
        }

        public Criteria andEvaluate_idLessThanOrEqualTo(Long value) {
            addCriterion("`evaluate_id` <=", value, "evaluate_id");
            return (Criteria) this;
        }

        public Criteria andEvaluate_idIn(List<Long> values) {
            addCriterion("`evaluate_id` in", values, "evaluate_id");
            return (Criteria) this;
        }

        public Criteria andEvaluate_idNotIn(List<Long> values) {
            addCriterion("`evaluate_id` not in", values, "evaluate_id");
            return (Criteria) this;
        }

        public Criteria andEvaluate_idBetween(Long value1, Long value2) {
            addCriterion("`evaluate_id` between", value1, value2, "evaluate_id");
            return (Criteria) this;
        }

        public Criteria andEvaluate_idNotBetween(Long value1, Long value2) {
            addCriterion("`evaluate_id` not between", value1, value2, "evaluate_id");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("`longitude` is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("`longitude` is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(BigDecimal value) {
            addCriterion("`longitude` =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(BigDecimal value) {
            addCriterion("`longitude` <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(BigDecimal value) {
            addCriterion("`longitude` >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("`longitude` >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(BigDecimal value) {
            addCriterion("`longitude` <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("`longitude` <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<BigDecimal> values) {
            addCriterion("`longitude` in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<BigDecimal> values) {
            addCriterion("`longitude` not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`longitude` between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`longitude` not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("`latitude` is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("`latitude` is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(BigDecimal value) {
            addCriterion("`latitude` =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(BigDecimal value) {
            addCriterion("`latitude` <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(BigDecimal value) {
            addCriterion("`latitude` >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("`latitude` >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(BigDecimal value) {
            addCriterion("`latitude` <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("`latitude` <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<BigDecimal> values) {
            addCriterion("`latitude` in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<BigDecimal> values) {
            addCriterion("`latitude` not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`latitude` between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("`latitude` not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andGmt_service_begin_timeIsNull() {
            addCriterion("`gmt_service_begin_time` is null");
            return (Criteria) this;
        }

        public Criteria andGmt_service_begin_timeIsNotNull() {
            addCriterion("`gmt_service_begin_time` is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_service_begin_timeEqualTo(String value) {
            addCriterion("`gmt_service_begin_time` =", value, "gmt_service_begin_time");
            return (Criteria) this;
        }

        public Criteria andGmt_service_begin_timeNotEqualTo(String value) {
            addCriterion("`gmt_service_begin_time` <>", value, "gmt_service_begin_time");
            return (Criteria) this;
        }

        public Criteria andGmt_service_begin_timeGreaterThan(String value) {
            addCriterion("`gmt_service_begin_time` >", value, "gmt_service_begin_time");
            return (Criteria) this;
        }

        public Criteria andGmt_service_begin_timeGreaterThanOrEqualTo(String value) {
            addCriterion("`gmt_service_begin_time` >=", value, "gmt_service_begin_time");
            return (Criteria) this;
        }

        public Criteria andGmt_service_begin_timeLessThan(String value) {
            addCriterion("`gmt_service_begin_time` <", value, "gmt_service_begin_time");
            return (Criteria) this;
        }

        public Criteria andGmt_service_begin_timeLessThanOrEqualTo(String value) {
            addCriterion("`gmt_service_begin_time` <=", value, "gmt_service_begin_time");
            return (Criteria) this;
        }

        public Criteria andGmt_service_begin_timeLike(String value) {
            addCriterion("`gmt_service_begin_time` like", value, "gmt_service_begin_time");
            return (Criteria) this;
        }

        public Criteria andGmt_service_begin_timeNotLike(String value) {
            addCriterion("`gmt_service_begin_time` not like", value, "gmt_service_begin_time");
            return (Criteria) this;
        }

        public Criteria andGmt_service_begin_timeIn(List<String> values) {
            addCriterion("`gmt_service_begin_time` in", values, "gmt_service_begin_time");
            return (Criteria) this;
        }

        public Criteria andGmt_service_begin_timeNotIn(List<String> values) {
            addCriterion("`gmt_service_begin_time` not in", values, "gmt_service_begin_time");
            return (Criteria) this;
        }

        public Criteria andGmt_service_begin_timeBetween(String value1, String value2) {
            addCriterion("`gmt_service_begin_time` between", value1, value2, "gmt_service_begin_time");
            return (Criteria) this;
        }

        public Criteria andGmt_service_begin_timeNotBetween(String value1, String value2) {
            addCriterion("`gmt_service_begin_time` not between", value1, value2, "gmt_service_begin_time");
            return (Criteria) this;
        }

        public Criteria andGmt_service_end_timeIsNull() {
            addCriterion("`gmt_service_end_time` is null");
            return (Criteria) this;
        }

        public Criteria andGmt_service_end_timeIsNotNull() {
            addCriterion("`gmt_service_end_time` is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_service_end_timeEqualTo(String value) {
            addCriterion("`gmt_service_end_time` =", value, "gmt_service_end_time");
            return (Criteria) this;
        }

        public Criteria andGmt_service_end_timeNotEqualTo(String value) {
            addCriterion("`gmt_service_end_time` <>", value, "gmt_service_end_time");
            return (Criteria) this;
        }

        public Criteria andGmt_service_end_timeGreaterThan(String value) {
            addCriterion("`gmt_service_end_time` >", value, "gmt_service_end_time");
            return (Criteria) this;
        }

        public Criteria andGmt_service_end_timeGreaterThanOrEqualTo(String value) {
            addCriterion("`gmt_service_end_time` >=", value, "gmt_service_end_time");
            return (Criteria) this;
        }

        public Criteria andGmt_service_end_timeLessThan(String value) {
            addCriterion("`gmt_service_end_time` <", value, "gmt_service_end_time");
            return (Criteria) this;
        }

        public Criteria andGmt_service_end_timeLessThanOrEqualTo(String value) {
            addCriterion("`gmt_service_end_time` <=", value, "gmt_service_end_time");
            return (Criteria) this;
        }

        public Criteria andGmt_service_end_timeLike(String value) {
            addCriterion("`gmt_service_end_time` like", value, "gmt_service_end_time");
            return (Criteria) this;
        }

        public Criteria andGmt_service_end_timeNotLike(String value) {
            addCriterion("`gmt_service_end_time` not like", value, "gmt_service_end_time");
            return (Criteria) this;
        }

        public Criteria andGmt_service_end_timeIn(List<String> values) {
            addCriterion("`gmt_service_end_time` in", values, "gmt_service_end_time");
            return (Criteria) this;
        }

        public Criteria andGmt_service_end_timeNotIn(List<String> values) {
            addCriterion("`gmt_service_end_time` not in", values, "gmt_service_end_time");
            return (Criteria) this;
        }

        public Criteria andGmt_service_end_timeBetween(String value1, String value2) {
            addCriterion("`gmt_service_end_time` between", value1, value2, "gmt_service_end_time");
            return (Criteria) this;
        }

        public Criteria andGmt_service_end_timeNotBetween(String value1, String value2) {
            addCriterion("`gmt_service_end_time` not between", value1, value2, "gmt_service_end_time");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_end_timeIsNull() {
            addCriterion("`gmt_change_service_end_time` is null");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_end_timeIsNotNull() {
            addCriterion("`gmt_change_service_end_time` is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_end_timeEqualTo(String value) {
            addCriterion("`gmt_change_service_end_time` =", value, "gmt_change_service_end_time");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_end_timeNotEqualTo(String value) {
            addCriterion("`gmt_change_service_end_time` <>", value, "gmt_change_service_end_time");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_end_timeGreaterThan(String value) {
            addCriterion("`gmt_change_service_end_time` >", value, "gmt_change_service_end_time");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_end_timeGreaterThanOrEqualTo(String value) {
            addCriterion("`gmt_change_service_end_time` >=", value, "gmt_change_service_end_time");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_end_timeLessThan(String value) {
            addCriterion("`gmt_change_service_end_time` <", value, "gmt_change_service_end_time");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_end_timeLessThanOrEqualTo(String value) {
            addCriterion("`gmt_change_service_end_time` <=", value, "gmt_change_service_end_time");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_end_timeLike(String value) {
            addCriterion("`gmt_change_service_end_time` like", value, "gmt_change_service_end_time");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_end_timeNotLike(String value) {
            addCriterion("`gmt_change_service_end_time` not like", value, "gmt_change_service_end_time");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_end_timeIn(List<String> values) {
            addCriterion("`gmt_change_service_end_time` in", values, "gmt_change_service_end_time");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_end_timeNotIn(List<String> values) {
            addCriterion("`gmt_change_service_end_time` not in", values, "gmt_change_service_end_time");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_end_timeBetween(String value1, String value2) {
            addCriterion("`gmt_change_service_end_time` between", value1, value2, "gmt_change_service_end_time");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_end_timeNotBetween(String value1, String value2) {
            addCriterion("`gmt_change_service_end_time` not between", value1, value2, "gmt_change_service_end_time");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_begin_timeIsNull() {
            addCriterion("`gmt_change_service_begin_time` is null");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_begin_timeIsNotNull() {
            addCriterion("`gmt_change_service_begin_time` is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_begin_timeEqualTo(String value) {
            addCriterion("`gmt_change_service_begin_time` =", value, "gmt_change_service_begin_time");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_begin_timeNotEqualTo(String value) {
            addCriterion("`gmt_change_service_begin_time` <>", value, "gmt_change_service_begin_time");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_begin_timeGreaterThan(String value) {
            addCriterion("`gmt_change_service_begin_time` >", value, "gmt_change_service_begin_time");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_begin_timeGreaterThanOrEqualTo(String value) {
            addCriterion("`gmt_change_service_begin_time` >=", value, "gmt_change_service_begin_time");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_begin_timeLessThan(String value) {
            addCriterion("`gmt_change_service_begin_time` <", value, "gmt_change_service_begin_time");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_begin_timeLessThanOrEqualTo(String value) {
            addCriterion("`gmt_change_service_begin_time` <=", value, "gmt_change_service_begin_time");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_begin_timeLike(String value) {
            addCriterion("`gmt_change_service_begin_time` like", value, "gmt_change_service_begin_time");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_begin_timeNotLike(String value) {
            addCriterion("`gmt_change_service_begin_time` not like", value, "gmt_change_service_begin_time");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_begin_timeIn(List<String> values) {
            addCriterion("`gmt_change_service_begin_time` in", values, "gmt_change_service_begin_time");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_begin_timeNotIn(List<String> values) {
            addCriterion("`gmt_change_service_begin_time` not in", values, "gmt_change_service_begin_time");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_begin_timeBetween(String value1, String value2) {
            addCriterion("`gmt_change_service_begin_time` between", value1, value2, "gmt_change_service_begin_time");
            return (Criteria) this;
        }

        public Criteria andGmt_change_service_begin_timeNotBetween(String value1, String value2) {
            addCriterion("`gmt_change_service_begin_time` not between", value1, value2, "gmt_change_service_begin_time");
            return (Criteria) this;
        }

        public Criteria andChild_statusIsNull() {
            addCriterion("`child_status` is null");
            return (Criteria) this;
        }

        public Criteria andChild_statusIsNotNull() {
            addCriterion("`child_status` is not null");
            return (Criteria) this;
        }

        public Criteria andChild_statusEqualTo(String value) {
            addCriterion("`child_status` =", value, "child_status");
            return (Criteria) this;
        }

        public Criteria andChild_statusNotEqualTo(String value) {
            addCriterion("`child_status` <>", value, "child_status");
            return (Criteria) this;
        }

        public Criteria andChild_statusGreaterThan(String value) {
            addCriterion("`child_status` >", value, "child_status");
            return (Criteria) this;
        }

        public Criteria andChild_statusGreaterThanOrEqualTo(String value) {
            addCriterion("`child_status` >=", value, "child_status");
            return (Criteria) this;
        }

        public Criteria andChild_statusLessThan(String value) {
            addCriterion("`child_status` <", value, "child_status");
            return (Criteria) this;
        }

        public Criteria andChild_statusLessThanOrEqualTo(String value) {
            addCriterion("`child_status` <=", value, "child_status");
            return (Criteria) this;
        }

        public Criteria andChild_statusLike(String value) {
            addCriterion("`child_status` like", value, "child_status");
            return (Criteria) this;
        }

        public Criteria andChild_statusNotLike(String value) {
            addCriterion("`child_status` not like", value, "child_status");
            return (Criteria) this;
        }

        public Criteria andChild_statusIn(List<String> values) {
            addCriterion("`child_status` in", values, "child_status");
            return (Criteria) this;
        }

        public Criteria andChild_statusNotIn(List<String> values) {
            addCriterion("`child_status` not in", values, "child_status");
            return (Criteria) this;
        }

        public Criteria andChild_statusBetween(String value1, String value2) {
            addCriterion("`child_status` between", value1, value2, "child_status");
            return (Criteria) this;
        }

        public Criteria andChild_statusNotBetween(String value1, String value2) {
            addCriterion("`child_status` not between", value1, value2, "child_status");
            return (Criteria) this;
        }

        public Criteria andShop_user_idIsNull() {
            addCriterion("`shop_user_id` is null");
            return (Criteria) this;
        }

        public Criteria andShop_user_idIsNotNull() {
            addCriterion("`shop_user_id` is not null");
            return (Criteria) this;
        }

        public Criteria andShop_user_idEqualTo(Long value) {
            addCriterion("`shop_user_id` =", value, "shop_user_id");
            return (Criteria) this;
        }

        public Criteria andShop_user_idNotEqualTo(Long value) {
            addCriterion("`shop_user_id` <>", value, "shop_user_id");
            return (Criteria) this;
        }

        public Criteria andShop_user_idGreaterThan(Long value) {
            addCriterion("`shop_user_id` >", value, "shop_user_id");
            return (Criteria) this;
        }

        public Criteria andShop_user_idGreaterThanOrEqualTo(Long value) {
            addCriterion("`shop_user_id` >=", value, "shop_user_id");
            return (Criteria) this;
        }

        public Criteria andShop_user_idLessThan(Long value) {
            addCriterion("`shop_user_id` <", value, "shop_user_id");
            return (Criteria) this;
        }

        public Criteria andShop_user_idLessThanOrEqualTo(Long value) {
            addCriterion("`shop_user_id` <=", value, "shop_user_id");
            return (Criteria) this;
        }

        public Criteria andShop_user_idIn(List<Long> values) {
            addCriterion("`shop_user_id` in", values, "shop_user_id");
            return (Criteria) this;
        }

        public Criteria andShop_user_idNotIn(List<Long> values) {
            addCriterion("`shop_user_id` not in", values, "shop_user_id");
            return (Criteria) this;
        }

        public Criteria andShop_user_idBetween(Long value1, Long value2) {
            addCriterion("`shop_user_id` between", value1, value2, "shop_user_id");
            return (Criteria) this;
        }

        public Criteria andShop_user_idNotBetween(Long value1, Long value2) {
            addCriterion("`shop_user_id` not between", value1, value2, "shop_user_id");
            return (Criteria) this;
        }

        public Criteria andShop_user_accountIsNull() {
            addCriterion("`shop_user_account` is null");
            return (Criteria) this;
        }

        public Criteria andShop_user_accountIsNotNull() {
            addCriterion("`shop_user_account` is not null");
            return (Criteria) this;
        }

        public Criteria andShop_user_accountEqualTo(String value) {
            addCriterion("`shop_user_account` =", value, "shop_user_account");
            return (Criteria) this;
        }

        public Criteria andShop_user_accountNotEqualTo(String value) {
            addCriterion("`shop_user_account` <>", value, "shop_user_account");
            return (Criteria) this;
        }

        public Criteria andShop_user_accountGreaterThan(String value) {
            addCriterion("`shop_user_account` >", value, "shop_user_account");
            return (Criteria) this;
        }

        public Criteria andShop_user_accountGreaterThanOrEqualTo(String value) {
            addCriterion("`shop_user_account` >=", value, "shop_user_account");
            return (Criteria) this;
        }

        public Criteria andShop_user_accountLessThan(String value) {
            addCriterion("`shop_user_account` <", value, "shop_user_account");
            return (Criteria) this;
        }

        public Criteria andShop_user_accountLessThanOrEqualTo(String value) {
            addCriterion("`shop_user_account` <=", value, "shop_user_account");
            return (Criteria) this;
        }

        public Criteria andShop_user_accountLike(String value) {
            addCriterion("`shop_user_account` like", value, "shop_user_account");
            return (Criteria) this;
        }

        public Criteria andShop_user_accountNotLike(String value) {
            addCriterion("`shop_user_account` not like", value, "shop_user_account");
            return (Criteria) this;
        }

        public Criteria andShop_user_accountIn(List<String> values) {
            addCriterion("`shop_user_account` in", values, "shop_user_account");
            return (Criteria) this;
        }

        public Criteria andShop_user_accountNotIn(List<String> values) {
            addCriterion("`shop_user_account` not in", values, "shop_user_account");
            return (Criteria) this;
        }

        public Criteria andShop_user_accountBetween(String value1, String value2) {
            addCriterion("`shop_user_account` between", value1, value2, "shop_user_account");
            return (Criteria) this;
        }

        public Criteria andShop_user_accountNotBetween(String value1, String value2) {
            addCriterion("`shop_user_account` not between", value1, value2, "shop_user_account");
            return (Criteria) this;
        }

        public Criteria andShop_user_nameIsNull() {
            addCriterion("`shop_user_name` is null");
            return (Criteria) this;
        }

        public Criteria andShop_user_nameIsNotNull() {
            addCriterion("`shop_user_name` is not null");
            return (Criteria) this;
        }

        public Criteria andShop_user_nameEqualTo(String value) {
            addCriterion("`shop_user_name` =", value, "shop_user_name");
            return (Criteria) this;
        }

        public Criteria andShop_user_nameNotEqualTo(String value) {
            addCriterion("`shop_user_name` <>", value, "shop_user_name");
            return (Criteria) this;
        }

        public Criteria andShop_user_nameGreaterThan(String value) {
            addCriterion("`shop_user_name` >", value, "shop_user_name");
            return (Criteria) this;
        }

        public Criteria andShop_user_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`shop_user_name` >=", value, "shop_user_name");
            return (Criteria) this;
        }

        public Criteria andShop_user_nameLessThan(String value) {
            addCriterion("`shop_user_name` <", value, "shop_user_name");
            return (Criteria) this;
        }

        public Criteria andShop_user_nameLessThanOrEqualTo(String value) {
            addCriterion("`shop_user_name` <=", value, "shop_user_name");
            return (Criteria) this;
        }

        public Criteria andShop_user_nameLike(String value) {
            addCriterion("`shop_user_name` like", value, "shop_user_name");
            return (Criteria) this;
        }

        public Criteria andShop_user_nameNotLike(String value) {
            addCriterion("`shop_user_name` not like", value, "shop_user_name");
            return (Criteria) this;
        }

        public Criteria andShop_user_nameIn(List<String> values) {
            addCriterion("`shop_user_name` in", values, "shop_user_name");
            return (Criteria) this;
        }

        public Criteria andShop_user_nameNotIn(List<String> values) {
            addCriterion("`shop_user_name` not in", values, "shop_user_name");
            return (Criteria) this;
        }

        public Criteria andShop_user_nameBetween(String value1, String value2) {
            addCriterion("`shop_user_name` between", value1, value2, "shop_user_name");
            return (Criteria) this;
        }

        public Criteria andShop_user_nameNotBetween(String value1, String value2) {
            addCriterion("`shop_user_name` not between", value1, value2, "shop_user_name");
            return (Criteria) this;
        }

        public Criteria andCurr_maintenance_milesIsNull() {
            addCriterion("`curr_maintenance_miles` is null");
            return (Criteria) this;
        }

        public Criteria andCurr_maintenance_milesIsNotNull() {
            addCriterion("`curr_maintenance_miles` is not null");
            return (Criteria) this;
        }

        public Criteria andCurr_maintenance_milesEqualTo(String value) {
            addCriterion("`curr_maintenance_miles` =", value, "curr_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andCurr_maintenance_milesNotEqualTo(String value) {
            addCriterion("`curr_maintenance_miles` <>", value, "curr_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andCurr_maintenance_milesGreaterThan(String value) {
            addCriterion("`curr_maintenance_miles` >", value, "curr_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andCurr_maintenance_milesGreaterThanOrEqualTo(String value) {
            addCriterion("`curr_maintenance_miles` >=", value, "curr_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andCurr_maintenance_milesLessThan(String value) {
            addCriterion("`curr_maintenance_miles` <", value, "curr_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andCurr_maintenance_milesLessThanOrEqualTo(String value) {
            addCriterion("`curr_maintenance_miles` <=", value, "curr_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andCurr_maintenance_milesLike(String value) {
            addCriterion("`curr_maintenance_miles` like", value, "curr_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andCurr_maintenance_milesNotLike(String value) {
            addCriterion("`curr_maintenance_miles` not like", value, "curr_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andCurr_maintenance_milesIn(List<String> values) {
            addCriterion("`curr_maintenance_miles` in", values, "curr_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andCurr_maintenance_milesNotIn(List<String> values) {
            addCriterion("`curr_maintenance_miles` not in", values, "curr_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andCurr_maintenance_milesBetween(String value1, String value2) {
            addCriterion("`curr_maintenance_miles` between", value1, value2, "curr_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andCurr_maintenance_milesNotBetween(String value1, String value2) {
            addCriterion("`curr_maintenance_miles` not between", value1, value2, "curr_maintenance_miles");
            return (Criteria) this;
        }

        public Criteria andCar_front_photo_urlIsNull() {
            addCriterion("`car_front_photo_url` is null");
            return (Criteria) this;
        }

        public Criteria andCar_front_photo_urlIsNotNull() {
            addCriterion("`car_front_photo_url` is not null");
            return (Criteria) this;
        }

        public Criteria andCar_front_photo_urlEqualTo(String value) {
            addCriterion("`car_front_photo_url` =", value, "car_front_photo_url");
            return (Criteria) this;
        }

        public Criteria andCar_front_photo_urlNotEqualTo(String value) {
            addCriterion("`car_front_photo_url` <>", value, "car_front_photo_url");
            return (Criteria) this;
        }

        public Criteria andCar_front_photo_urlGreaterThan(String value) {
            addCriterion("`car_front_photo_url` >", value, "car_front_photo_url");
            return (Criteria) this;
        }

        public Criteria andCar_front_photo_urlGreaterThanOrEqualTo(String value) {
            addCriterion("`car_front_photo_url` >=", value, "car_front_photo_url");
            return (Criteria) this;
        }

        public Criteria andCar_front_photo_urlLessThan(String value) {
            addCriterion("`car_front_photo_url` <", value, "car_front_photo_url");
            return (Criteria) this;
        }

        public Criteria andCar_front_photo_urlLessThanOrEqualTo(String value) {
            addCriterion("`car_front_photo_url` <=", value, "car_front_photo_url");
            return (Criteria) this;
        }

        public Criteria andCar_front_photo_urlLike(String value) {
            addCriterion("`car_front_photo_url` like", value, "car_front_photo_url");
            return (Criteria) this;
        }

        public Criteria andCar_front_photo_urlNotLike(String value) {
            addCriterion("`car_front_photo_url` not like", value, "car_front_photo_url");
            return (Criteria) this;
        }

        public Criteria andCar_front_photo_urlIn(List<String> values) {
            addCriterion("`car_front_photo_url` in", values, "car_front_photo_url");
            return (Criteria) this;
        }

        public Criteria andCar_front_photo_urlNotIn(List<String> values) {
            addCriterion("`car_front_photo_url` not in", values, "car_front_photo_url");
            return (Criteria) this;
        }

        public Criteria andCar_front_photo_urlBetween(String value1, String value2) {
            addCriterion("`car_front_photo_url` between", value1, value2, "car_front_photo_url");
            return (Criteria) this;
        }

        public Criteria andCar_front_photo_urlNotBetween(String value1, String value2) {
            addCriterion("`car_front_photo_url` not between", value1, value2, "car_front_photo_url");
            return (Criteria) this;
        }

        public Criteria andCar_dashboard_photo_urlIsNull() {
            addCriterion("`car_dashboard_photo_url` is null");
            return (Criteria) this;
        }

        public Criteria andCar_dashboard_photo_urlIsNotNull() {
            addCriterion("`car_dashboard_photo_url` is not null");
            return (Criteria) this;
        }

        public Criteria andCar_dashboard_photo_urlEqualTo(String value) {
            addCriterion("`car_dashboard_photo_url` =", value, "car_dashboard_photo_url");
            return (Criteria) this;
        }

        public Criteria andCar_dashboard_photo_urlNotEqualTo(String value) {
            addCriterion("`car_dashboard_photo_url` <>", value, "car_dashboard_photo_url");
            return (Criteria) this;
        }

        public Criteria andCar_dashboard_photo_urlGreaterThan(String value) {
            addCriterion("`car_dashboard_photo_url` >", value, "car_dashboard_photo_url");
            return (Criteria) this;
        }

        public Criteria andCar_dashboard_photo_urlGreaterThanOrEqualTo(String value) {
            addCriterion("`car_dashboard_photo_url` >=", value, "car_dashboard_photo_url");
            return (Criteria) this;
        }

        public Criteria andCar_dashboard_photo_urlLessThan(String value) {
            addCriterion("`car_dashboard_photo_url` <", value, "car_dashboard_photo_url");
            return (Criteria) this;
        }

        public Criteria andCar_dashboard_photo_urlLessThanOrEqualTo(String value) {
            addCriterion("`car_dashboard_photo_url` <=", value, "car_dashboard_photo_url");
            return (Criteria) this;
        }

        public Criteria andCar_dashboard_photo_urlLike(String value) {
            addCriterion("`car_dashboard_photo_url` like", value, "car_dashboard_photo_url");
            return (Criteria) this;
        }

        public Criteria andCar_dashboard_photo_urlNotLike(String value) {
            addCriterion("`car_dashboard_photo_url` not like", value, "car_dashboard_photo_url");
            return (Criteria) this;
        }

        public Criteria andCar_dashboard_photo_urlIn(List<String> values) {
            addCriterion("`car_dashboard_photo_url` in", values, "car_dashboard_photo_url");
            return (Criteria) this;
        }

        public Criteria andCar_dashboard_photo_urlNotIn(List<String> values) {
            addCriterion("`car_dashboard_photo_url` not in", values, "car_dashboard_photo_url");
            return (Criteria) this;
        }

        public Criteria andCar_dashboard_photo_urlBetween(String value1, String value2) {
            addCriterion("`car_dashboard_photo_url` between", value1, value2, "car_dashboard_photo_url");
            return (Criteria) this;
        }

        public Criteria andCar_dashboard_photo_urlNotBetween(String value1, String value2) {
            addCriterion("`car_dashboard_photo_url` not between", value1, value2, "car_dashboard_photo_url");
            return (Criteria) this;
        }

        public Criteria andOrder_typeIsNull() {
            addCriterion("`order_type` is null");
            return (Criteria) this;
        }

        public Criteria andOrder_typeIsNotNull() {
            addCriterion("`order_type` is not null");
            return (Criteria) this;
        }

        public Criteria andOrder_typeEqualTo(Integer value) {
            addCriterion("`order_type` =", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeNotEqualTo(Integer value) {
            addCriterion("`order_type` <>", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeGreaterThan(Integer value) {
            addCriterion("`order_type` >", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("`order_type` >=", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeLessThan(Integer value) {
            addCriterion("`order_type` <", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeLessThanOrEqualTo(Integer value) {
            addCriterion("`order_type` <=", value, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeIn(List<Integer> values) {
            addCriterion("`order_type` in", values, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeNotIn(List<Integer> values) {
            addCriterion("`order_type` not in", values, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeBetween(Integer value1, Integer value2) {
            addCriterion("`order_type` between", value1, value2, "order_type");
            return (Criteria) this;
        }

        public Criteria andOrder_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("`order_type` not between", value1, value2, "order_type");
            return (Criteria) this;
        }

        public Criteria andVerify_remarkIsNull() {
            addCriterion("`verify_remark` is null");
            return (Criteria) this;
        }

        public Criteria andVerify_remarkIsNotNull() {
            addCriterion("`verify_remark` is not null");
            return (Criteria) this;
        }

        public Criteria andVerify_remarkEqualTo(String value) {
            addCriterion("`verify_remark` =", value, "verify_remark");
            return (Criteria) this;
        }

        public Criteria andVerify_remarkNotEqualTo(String value) {
            addCriterion("`verify_remark` <>", value, "verify_remark");
            return (Criteria) this;
        }

        public Criteria andVerify_remarkGreaterThan(String value) {
            addCriterion("`verify_remark` >", value, "verify_remark");
            return (Criteria) this;
        }

        public Criteria andVerify_remarkGreaterThanOrEqualTo(String value) {
            addCriterion("`verify_remark` >=", value, "verify_remark");
            return (Criteria) this;
        }

        public Criteria andVerify_remarkLessThan(String value) {
            addCriterion("`verify_remark` <", value, "verify_remark");
            return (Criteria) this;
        }

        public Criteria andVerify_remarkLessThanOrEqualTo(String value) {
            addCriterion("`verify_remark` <=", value, "verify_remark");
            return (Criteria) this;
        }

        public Criteria andVerify_remarkLike(String value) {
            addCriterion("`verify_remark` like", value, "verify_remark");
            return (Criteria) this;
        }

        public Criteria andVerify_remarkNotLike(String value) {
            addCriterion("`verify_remark` not like", value, "verify_remark");
            return (Criteria) this;
        }

        public Criteria andVerify_remarkIn(List<String> values) {
            addCriterion("`verify_remark` in", values, "verify_remark");
            return (Criteria) this;
        }

        public Criteria andVerify_remarkNotIn(List<String> values) {
            addCriterion("`verify_remark` not in", values, "verify_remark");
            return (Criteria) this;
        }

        public Criteria andVerify_remarkBetween(String value1, String value2) {
            addCriterion("`verify_remark` between", value1, value2, "verify_remark");
            return (Criteria) this;
        }

        public Criteria andVerify_remarkNotBetween(String value1, String value2) {
            addCriterion("`verify_remark` not between", value1, value2, "verify_remark");
            return (Criteria) this;
        }

        public Criteria andSettleIsNull() {
            addCriterion("`settle` is null");
            return (Criteria) this;
        }

        public Criteria andSettleIsNotNull() {
            addCriterion("`settle` is not null");
            return (Criteria) this;
        }

        public Criteria andSettleEqualTo(Integer value) {
            addCriterion("`settle` =", value, "settle");
            return (Criteria) this;
        }

        public Criteria andSettleNotEqualTo(Integer value) {
            addCriterion("`settle` <>", value, "settle");
            return (Criteria) this;
        }

        public Criteria andSettleGreaterThan(Integer value) {
            addCriterion("`settle` >", value, "settle");
            return (Criteria) this;
        }

        public Criteria andSettleGreaterThanOrEqualTo(Integer value) {
            addCriterion("`settle` >=", value, "settle");
            return (Criteria) this;
        }

        public Criteria andSettleLessThan(Integer value) {
            addCriterion("`settle` <", value, "settle");
            return (Criteria) this;
        }

        public Criteria andSettleLessThanOrEqualTo(Integer value) {
            addCriterion("`settle` <=", value, "settle");
            return (Criteria) this;
        }

        public Criteria andSettleIn(List<Integer> values) {
            addCriterion("`settle` in", values, "settle");
            return (Criteria) this;
        }

        public Criteria andSettleNotIn(List<Integer> values) {
            addCriterion("`settle` not in", values, "settle");
            return (Criteria) this;
        }

        public Criteria andSettleBetween(Integer value1, Integer value2) {
            addCriterion("`settle` between", value1, value2, "settle");
            return (Criteria) this;
        }

        public Criteria andSettleNotBetween(Integer value1, Integer value2) {
            addCriterion("`settle` not between", value1, value2, "settle");
            return (Criteria) this;
        }

        public Criteria andSettle_amountIsNull() {
            addCriterion("`settle_amount` is null");
            return (Criteria) this;
        }

        public Criteria andSettle_amountIsNotNull() {
            addCriterion("`settle_amount` is not null");
            return (Criteria) this;
        }

        public Criteria andSettle_amountEqualTo(String value) {
            addCriterion("`settle_amount` =", value, "settle_amount");
            return (Criteria) this;
        }

        public Criteria andSettle_amountNotEqualTo(String value) {
            addCriterion("`settle_amount` <>", value, "settle_amount");
            return (Criteria) this;
        }

        public Criteria andSettle_amountGreaterThan(String value) {
            addCriterion("`settle_amount` >", value, "settle_amount");
            return (Criteria) this;
        }

        public Criteria andSettle_amountGreaterThanOrEqualTo(String value) {
            addCriterion("`settle_amount` >=", value, "settle_amount");
            return (Criteria) this;
        }

        public Criteria andSettle_amountLessThan(String value) {
            addCriterion("`settle_amount` <", value, "settle_amount");
            return (Criteria) this;
        }

        public Criteria andSettle_amountLessThanOrEqualTo(String value) {
            addCriterion("`settle_amount` <=", value, "settle_amount");
            return (Criteria) this;
        }

        public Criteria andSettle_amountLike(String value) {
            addCriterion("`settle_amount` like", value, "settle_amount");
            return (Criteria) this;
        }

        public Criteria andSettle_amountNotLike(String value) {
            addCriterion("`settle_amount` not like", value, "settle_amount");
            return (Criteria) this;
        }

        public Criteria andSettle_amountIn(List<String> values) {
            addCriterion("`settle_amount` in", values, "settle_amount");
            return (Criteria) this;
        }

        public Criteria andSettle_amountNotIn(List<String> values) {
            addCriterion("`settle_amount` not in", values, "settle_amount");
            return (Criteria) this;
        }

        public Criteria andSettle_amountBetween(String value1, String value2) {
            addCriterion("`settle_amount` between", value1, value2, "settle_amount");
            return (Criteria) this;
        }

        public Criteria andSettle_amountNotBetween(String value1, String value2) {
            addCriterion("`settle_amount` not between", value1, value2, "settle_amount");
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
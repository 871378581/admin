package com.segama.ege.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public CarTypeExample() {
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

        public Criteria andBrandIsNull() {
            addCriterion("`brand` is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("`brand` is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("`brand` =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("`brand` <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("`brand` >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("`brand` >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("`brand` <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("`brand` <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("`brand` like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("`brand` not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("`brand` in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("`brand` not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("`brand` between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("`brand` not between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrand_codeIsNull() {
            addCriterion("`brand_code` is null");
            return (Criteria) this;
        }

        public Criteria andBrand_codeIsNotNull() {
            addCriterion("`brand_code` is not null");
            return (Criteria) this;
        }

        public Criteria andBrand_codeEqualTo(String value) {
            addCriterion("`brand_code` =", value, "brand_code");
            return (Criteria) this;
        }

        public Criteria andBrand_codeNotEqualTo(String value) {
            addCriterion("`brand_code` <>", value, "brand_code");
            return (Criteria) this;
        }

        public Criteria andBrand_codeGreaterThan(String value) {
            addCriterion("`brand_code` >", value, "brand_code");
            return (Criteria) this;
        }

        public Criteria andBrand_codeGreaterThanOrEqualTo(String value) {
            addCriterion("`brand_code` >=", value, "brand_code");
            return (Criteria) this;
        }

        public Criteria andBrand_codeLessThan(String value) {
            addCriterion("`brand_code` <", value, "brand_code");
            return (Criteria) this;
        }

        public Criteria andBrand_codeLessThanOrEqualTo(String value) {
            addCriterion("`brand_code` <=", value, "brand_code");
            return (Criteria) this;
        }

        public Criteria andBrand_codeLike(String value) {
            addCriterion("`brand_code` like", value, "brand_code");
            return (Criteria) this;
        }

        public Criteria andBrand_codeNotLike(String value) {
            addCriterion("`brand_code` not like", value, "brand_code");
            return (Criteria) this;
        }

        public Criteria andBrand_codeIn(List<String> values) {
            addCriterion("`brand_code` in", values, "brand_code");
            return (Criteria) this;
        }

        public Criteria andBrand_codeNotIn(List<String> values) {
            addCriterion("`brand_code` not in", values, "brand_code");
            return (Criteria) this;
        }

        public Criteria andBrand_codeBetween(String value1, String value2) {
            addCriterion("`brand_code` between", value1, value2, "brand_code");
            return (Criteria) this;
        }

        public Criteria andBrand_codeNotBetween(String value1, String value2) {
            addCriterion("`brand_code` not between", value1, value2, "brand_code");
            return (Criteria) this;
        }

        public Criteria andCar_typeIsNull() {
            addCriterion("`car_type` is null");
            return (Criteria) this;
        }

        public Criteria andCar_typeIsNotNull() {
            addCriterion("`car_type` is not null");
            return (Criteria) this;
        }

        public Criteria andCar_typeEqualTo(String value) {
            addCriterion("`car_type` =", value, "car_type");
            return (Criteria) this;
        }

        public Criteria andCar_typeNotEqualTo(String value) {
            addCriterion("`car_type` <>", value, "car_type");
            return (Criteria) this;
        }

        public Criteria andCar_typeGreaterThan(String value) {
            addCriterion("`car_type` >", value, "car_type");
            return (Criteria) this;
        }

        public Criteria andCar_typeGreaterThanOrEqualTo(String value) {
            addCriterion("`car_type` >=", value, "car_type");
            return (Criteria) this;
        }

        public Criteria andCar_typeLessThan(String value) {
            addCriterion("`car_type` <", value, "car_type");
            return (Criteria) this;
        }

        public Criteria andCar_typeLessThanOrEqualTo(String value) {
            addCriterion("`car_type` <=", value, "car_type");
            return (Criteria) this;
        }

        public Criteria andCar_typeLike(String value) {
            addCriterion("`car_type` like", value, "car_type");
            return (Criteria) this;
        }

        public Criteria andCar_typeNotLike(String value) {
            addCriterion("`car_type` not like", value, "car_type");
            return (Criteria) this;
        }

        public Criteria andCar_typeIn(List<String> values) {
            addCriterion("`car_type` in", values, "car_type");
            return (Criteria) this;
        }

        public Criteria andCar_typeNotIn(List<String> values) {
            addCriterion("`car_type` not in", values, "car_type");
            return (Criteria) this;
        }

        public Criteria andCar_typeBetween(String value1, String value2) {
            addCriterion("`car_type` between", value1, value2, "car_type");
            return (Criteria) this;
        }

        public Criteria andCar_typeNotBetween(String value1, String value2) {
            addCriterion("`car_type` not between", value1, value2, "car_type");
            return (Criteria) this;
        }

        public Criteria andCar_type_codeIsNull() {
            addCriterion("`car_type_code` is null");
            return (Criteria) this;
        }

        public Criteria andCar_type_codeIsNotNull() {
            addCriterion("`car_type_code` is not null");
            return (Criteria) this;
        }

        public Criteria andCar_type_codeEqualTo(String value) {
            addCriterion("`car_type_code` =", value, "car_type_code");
            return (Criteria) this;
        }

        public Criteria andCar_type_codeNotEqualTo(String value) {
            addCriterion("`car_type_code` <>", value, "car_type_code");
            return (Criteria) this;
        }

        public Criteria andCar_type_codeGreaterThan(String value) {
            addCriterion("`car_type_code` >", value, "car_type_code");
            return (Criteria) this;
        }

        public Criteria andCar_type_codeGreaterThanOrEqualTo(String value) {
            addCriterion("`car_type_code` >=", value, "car_type_code");
            return (Criteria) this;
        }

        public Criteria andCar_type_codeLessThan(String value) {
            addCriterion("`car_type_code` <", value, "car_type_code");
            return (Criteria) this;
        }

        public Criteria andCar_type_codeLessThanOrEqualTo(String value) {
            addCriterion("`car_type_code` <=", value, "car_type_code");
            return (Criteria) this;
        }

        public Criteria andCar_type_codeLike(String value) {
            addCriterion("`car_type_code` like", value, "car_type_code");
            return (Criteria) this;
        }

        public Criteria andCar_type_codeNotLike(String value) {
            addCriterion("`car_type_code` not like", value, "car_type_code");
            return (Criteria) this;
        }

        public Criteria andCar_type_codeIn(List<String> values) {
            addCriterion("`car_type_code` in", values, "car_type_code");
            return (Criteria) this;
        }

        public Criteria andCar_type_codeNotIn(List<String> values) {
            addCriterion("`car_type_code` not in", values, "car_type_code");
            return (Criteria) this;
        }

        public Criteria andCar_type_codeBetween(String value1, String value2) {
            addCriterion("`car_type_code` between", value1, value2, "car_type_code");
            return (Criteria) this;
        }

        public Criteria andCar_type_codeNotBetween(String value1, String value2) {
            addCriterion("`car_type_code` not between", value1, value2, "car_type_code");
            return (Criteria) this;
        }

        public Criteria andCar_styleIsNull() {
            addCriterion("`car_style` is null");
            return (Criteria) this;
        }

        public Criteria andCar_styleIsNotNull() {
            addCriterion("`car_style` is not null");
            return (Criteria) this;
        }

        public Criteria andCar_styleEqualTo(String value) {
            addCriterion("`car_style` =", value, "car_style");
            return (Criteria) this;
        }

        public Criteria andCar_styleNotEqualTo(String value) {
            addCriterion("`car_style` <>", value, "car_style");
            return (Criteria) this;
        }

        public Criteria andCar_styleGreaterThan(String value) {
            addCriterion("`car_style` >", value, "car_style");
            return (Criteria) this;
        }

        public Criteria andCar_styleGreaterThanOrEqualTo(String value) {
            addCriterion("`car_style` >=", value, "car_style");
            return (Criteria) this;
        }

        public Criteria andCar_styleLessThan(String value) {
            addCriterion("`car_style` <", value, "car_style");
            return (Criteria) this;
        }

        public Criteria andCar_styleLessThanOrEqualTo(String value) {
            addCriterion("`car_style` <=", value, "car_style");
            return (Criteria) this;
        }

        public Criteria andCar_styleLike(String value) {
            addCriterion("`car_style` like", value, "car_style");
            return (Criteria) this;
        }

        public Criteria andCar_styleNotLike(String value) {
            addCriterion("`car_style` not like", value, "car_style");
            return (Criteria) this;
        }

        public Criteria andCar_styleIn(List<String> values) {
            addCriterion("`car_style` in", values, "car_style");
            return (Criteria) this;
        }

        public Criteria andCar_styleNotIn(List<String> values) {
            addCriterion("`car_style` not in", values, "car_style");
            return (Criteria) this;
        }

        public Criteria andCar_styleBetween(String value1, String value2) {
            addCriterion("`car_style` between", value1, value2, "car_style");
            return (Criteria) this;
        }

        public Criteria andCar_styleNotBetween(String value1, String value2) {
            addCriterion("`car_style` not between", value1, value2, "car_style");
            return (Criteria) this;
        }

        public Criteria andCar_style_codeIsNull() {
            addCriterion("`car_style_code` is null");
            return (Criteria) this;
        }

        public Criteria andCar_style_codeIsNotNull() {
            addCriterion("`car_style_code` is not null");
            return (Criteria) this;
        }

        public Criteria andCar_style_codeEqualTo(String value) {
            addCriterion("`car_style_code` =", value, "car_style_code");
            return (Criteria) this;
        }

        public Criteria andCar_style_codeNotEqualTo(String value) {
            addCriterion("`car_style_code` <>", value, "car_style_code");
            return (Criteria) this;
        }

        public Criteria andCar_style_codeGreaterThan(String value) {
            addCriterion("`car_style_code` >", value, "car_style_code");
            return (Criteria) this;
        }

        public Criteria andCar_style_codeGreaterThanOrEqualTo(String value) {
            addCriterion("`car_style_code` >=", value, "car_style_code");
            return (Criteria) this;
        }

        public Criteria andCar_style_codeLessThan(String value) {
            addCriterion("`car_style_code` <", value, "car_style_code");
            return (Criteria) this;
        }

        public Criteria andCar_style_codeLessThanOrEqualTo(String value) {
            addCriterion("`car_style_code` <=", value, "car_style_code");
            return (Criteria) this;
        }

        public Criteria andCar_style_codeLike(String value) {
            addCriterion("`car_style_code` like", value, "car_style_code");
            return (Criteria) this;
        }

        public Criteria andCar_style_codeNotLike(String value) {
            addCriterion("`car_style_code` not like", value, "car_style_code");
            return (Criteria) this;
        }

        public Criteria andCar_style_codeIn(List<String> values) {
            addCriterion("`car_style_code` in", values, "car_style_code");
            return (Criteria) this;
        }

        public Criteria andCar_style_codeNotIn(List<String> values) {
            addCriterion("`car_style_code` not in", values, "car_style_code");
            return (Criteria) this;
        }

        public Criteria andCar_style_codeBetween(String value1, String value2) {
            addCriterion("`car_style_code` between", value1, value2, "car_style_code");
            return (Criteria) this;
        }

        public Criteria andCar_style_codeNotBetween(String value1, String value2) {
            addCriterion("`car_style_code` not between", value1, value2, "car_style_code");
            return (Criteria) this;
        }

        public Criteria andBrand_first_letterIsNull() {
            addCriterion("`brand_first_letter` is null");
            return (Criteria) this;
        }

        public Criteria andBrand_first_letterIsNotNull() {
            addCriterion("`brand_first_letter` is not null");
            return (Criteria) this;
        }

        public Criteria andBrand_first_letterEqualTo(String value) {
            addCriterion("`brand_first_letter` =", value, "brand_first_letter");
            return (Criteria) this;
        }

        public Criteria andBrand_first_letterNotEqualTo(String value) {
            addCriterion("`brand_first_letter` <>", value, "brand_first_letter");
            return (Criteria) this;
        }

        public Criteria andBrand_first_letterGreaterThan(String value) {
            addCriterion("`brand_first_letter` >", value, "brand_first_letter");
            return (Criteria) this;
        }

        public Criteria andBrand_first_letterGreaterThanOrEqualTo(String value) {
            addCriterion("`brand_first_letter` >=", value, "brand_first_letter");
            return (Criteria) this;
        }

        public Criteria andBrand_first_letterLessThan(String value) {
            addCriterion("`brand_first_letter` <", value, "brand_first_letter");
            return (Criteria) this;
        }

        public Criteria andBrand_first_letterLessThanOrEqualTo(String value) {
            addCriterion("`brand_first_letter` <=", value, "brand_first_letter");
            return (Criteria) this;
        }

        public Criteria andBrand_first_letterLike(String value) {
            addCriterion("`brand_first_letter` like", value, "brand_first_letter");
            return (Criteria) this;
        }

        public Criteria andBrand_first_letterNotLike(String value) {
            addCriterion("`brand_first_letter` not like", value, "brand_first_letter");
            return (Criteria) this;
        }

        public Criteria andBrand_first_letterIn(List<String> values) {
            addCriterion("`brand_first_letter` in", values, "brand_first_letter");
            return (Criteria) this;
        }

        public Criteria andBrand_first_letterNotIn(List<String> values) {
            addCriterion("`brand_first_letter` not in", values, "brand_first_letter");
            return (Criteria) this;
        }

        public Criteria andBrand_first_letterBetween(String value1, String value2) {
            addCriterion("`brand_first_letter` between", value1, value2, "brand_first_letter");
            return (Criteria) this;
        }

        public Criteria andBrand_first_letterNotBetween(String value1, String value2) {
            addCriterion("`brand_first_letter` not between", value1, value2, "brand_first_letter");
            return (Criteria) this;
        }

        public Criteria andCategory_codeIsNull() {
            addCriterion("`category_code` is null");
            return (Criteria) this;
        }

        public Criteria andCategory_codeIsNotNull() {
            addCriterion("`category_code` is not null");
            return (Criteria) this;
        }

        public Criteria andCategory_codeEqualTo(String value) {
            addCriterion("`category_code` =", value, "category_code");
            return (Criteria) this;
        }

        public Criteria andCategory_codeNotEqualTo(String value) {
            addCriterion("`category_code` <>", value, "category_code");
            return (Criteria) this;
        }

        public Criteria andCategory_codeGreaterThan(String value) {
            addCriterion("`category_code` >", value, "category_code");
            return (Criteria) this;
        }

        public Criteria andCategory_codeGreaterThanOrEqualTo(String value) {
            addCriterion("`category_code` >=", value, "category_code");
            return (Criteria) this;
        }

        public Criteria andCategory_codeLessThan(String value) {
            addCriterion("`category_code` <", value, "category_code");
            return (Criteria) this;
        }

        public Criteria andCategory_codeLessThanOrEqualTo(String value) {
            addCriterion("`category_code` <=", value, "category_code");
            return (Criteria) this;
        }

        public Criteria andCategory_codeLike(String value) {
            addCriterion("`category_code` like", value, "category_code");
            return (Criteria) this;
        }

        public Criteria andCategory_codeNotLike(String value) {
            addCriterion("`category_code` not like", value, "category_code");
            return (Criteria) this;
        }

        public Criteria andCategory_codeIn(List<String> values) {
            addCriterion("`category_code` in", values, "category_code");
            return (Criteria) this;
        }

        public Criteria andCategory_codeNotIn(List<String> values) {
            addCriterion("`category_code` not in", values, "category_code");
            return (Criteria) this;
        }

        public Criteria andCategory_codeBetween(String value1, String value2) {
            addCriterion("`category_code` between", value1, value2, "category_code");
            return (Criteria) this;
        }

        public Criteria andCategory_codeNotBetween(String value1, String value2) {
            addCriterion("`category_code` not between", value1, value2, "category_code");
            return (Criteria) this;
        }

        public Criteria andCategory_nameIsNull() {
            addCriterion("`category_name` is null");
            return (Criteria) this;
        }

        public Criteria andCategory_nameIsNotNull() {
            addCriterion("`category_name` is not null");
            return (Criteria) this;
        }

        public Criteria andCategory_nameEqualTo(String value) {
            addCriterion("`category_name` =", value, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategory_nameNotEqualTo(String value) {
            addCriterion("`category_name` <>", value, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategory_nameGreaterThan(String value) {
            addCriterion("`category_name` >", value, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategory_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`category_name` >=", value, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategory_nameLessThan(String value) {
            addCriterion("`category_name` <", value, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategory_nameLessThanOrEqualTo(String value) {
            addCriterion("`category_name` <=", value, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategory_nameLike(String value) {
            addCriterion("`category_name` like", value, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategory_nameNotLike(String value) {
            addCriterion("`category_name` not like", value, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategory_nameIn(List<String> values) {
            addCriterion("`category_name` in", values, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategory_nameNotIn(List<String> values) {
            addCriterion("`category_name` not in", values, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategory_nameBetween(String value1, String value2) {
            addCriterion("`category_name` between", value1, value2, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategory_nameNotBetween(String value1, String value2) {
            addCriterion("`category_name` not between", value1, value2, "category_name");
            return (Criteria) this;
        }

        public Criteria andCategory_levelIsNull() {
            addCriterion("`category_level` is null");
            return (Criteria) this;
        }

        public Criteria andCategory_levelIsNotNull() {
            addCriterion("`category_level` is not null");
            return (Criteria) this;
        }

        public Criteria andCategory_levelEqualTo(Long value) {
            addCriterion("`category_level` =", value, "category_level");
            return (Criteria) this;
        }

        public Criteria andCategory_levelNotEqualTo(Long value) {
            addCriterion("`category_level` <>", value, "category_level");
            return (Criteria) this;
        }

        public Criteria andCategory_levelGreaterThan(Long value) {
            addCriterion("`category_level` >", value, "category_level");
            return (Criteria) this;
        }

        public Criteria andCategory_levelGreaterThanOrEqualTo(Long value) {
            addCriterion("`category_level` >=", value, "category_level");
            return (Criteria) this;
        }

        public Criteria andCategory_levelLessThan(Long value) {
            addCriterion("`category_level` <", value, "category_level");
            return (Criteria) this;
        }

        public Criteria andCategory_levelLessThanOrEqualTo(Long value) {
            addCriterion("`category_level` <=", value, "category_level");
            return (Criteria) this;
        }

        public Criteria andCategory_levelIn(List<Long> values) {
            addCriterion("`category_level` in", values, "category_level");
            return (Criteria) this;
        }

        public Criteria andCategory_levelNotIn(List<Long> values) {
            addCriterion("`category_level` not in", values, "category_level");
            return (Criteria) this;
        }

        public Criteria andCategory_levelBetween(Long value1, Long value2) {
            addCriterion("`category_level` between", value1, value2, "category_level");
            return (Criteria) this;
        }

        public Criteria andCategory_levelNotBetween(Long value1, Long value2) {
            addCriterion("`category_level` not between", value1, value2, "category_level");
            return (Criteria) this;
        }

        public Criteria andParent_category_codeIsNull() {
            addCriterion("`parent_category_code` is null");
            return (Criteria) this;
        }

        public Criteria andParent_category_codeIsNotNull() {
            addCriterion("`parent_category_code` is not null");
            return (Criteria) this;
        }

        public Criteria andParent_category_codeEqualTo(String value) {
            addCriterion("`parent_category_code` =", value, "parent_category_code");
            return (Criteria) this;
        }

        public Criteria andParent_category_codeNotEqualTo(String value) {
            addCriterion("`parent_category_code` <>", value, "parent_category_code");
            return (Criteria) this;
        }

        public Criteria andParent_category_codeGreaterThan(String value) {
            addCriterion("`parent_category_code` >", value, "parent_category_code");
            return (Criteria) this;
        }

        public Criteria andParent_category_codeGreaterThanOrEqualTo(String value) {
            addCriterion("`parent_category_code` >=", value, "parent_category_code");
            return (Criteria) this;
        }

        public Criteria andParent_category_codeLessThan(String value) {
            addCriterion("`parent_category_code` <", value, "parent_category_code");
            return (Criteria) this;
        }

        public Criteria andParent_category_codeLessThanOrEqualTo(String value) {
            addCriterion("`parent_category_code` <=", value, "parent_category_code");
            return (Criteria) this;
        }

        public Criteria andParent_category_codeLike(String value) {
            addCriterion("`parent_category_code` like", value, "parent_category_code");
            return (Criteria) this;
        }

        public Criteria andParent_category_codeNotLike(String value) {
            addCriterion("`parent_category_code` not like", value, "parent_category_code");
            return (Criteria) this;
        }

        public Criteria andParent_category_codeIn(List<String> values) {
            addCriterion("`parent_category_code` in", values, "parent_category_code");
            return (Criteria) this;
        }

        public Criteria andParent_category_codeNotIn(List<String> values) {
            addCriterion("`parent_category_code` not in", values, "parent_category_code");
            return (Criteria) this;
        }

        public Criteria andParent_category_codeBetween(String value1, String value2) {
            addCriterion("`parent_category_code` between", value1, value2, "parent_category_code");
            return (Criteria) this;
        }

        public Criteria andParent_category_codeNotBetween(String value1, String value2) {
            addCriterion("`parent_category_code` not between", value1, value2, "parent_category_code");
            return (Criteria) this;
        }

        public Criteria andLogo_urlIsNull() {
            addCriterion("`logo_url` is null");
            return (Criteria) this;
        }

        public Criteria andLogo_urlIsNotNull() {
            addCriterion("`logo_url` is not null");
            return (Criteria) this;
        }

        public Criteria andLogo_urlEqualTo(String value) {
            addCriterion("`logo_url` =", value, "logo_url");
            return (Criteria) this;
        }

        public Criteria andLogo_urlNotEqualTo(String value) {
            addCriterion("`logo_url` <>", value, "logo_url");
            return (Criteria) this;
        }

        public Criteria andLogo_urlGreaterThan(String value) {
            addCriterion("`logo_url` >", value, "logo_url");
            return (Criteria) this;
        }

        public Criteria andLogo_urlGreaterThanOrEqualTo(String value) {
            addCriterion("`logo_url` >=", value, "logo_url");
            return (Criteria) this;
        }

        public Criteria andLogo_urlLessThan(String value) {
            addCriterion("`logo_url` <", value, "logo_url");
            return (Criteria) this;
        }

        public Criteria andLogo_urlLessThanOrEqualTo(String value) {
            addCriterion("`logo_url` <=", value, "logo_url");
            return (Criteria) this;
        }

        public Criteria andLogo_urlLike(String value) {
            addCriterion("`logo_url` like", value, "logo_url");
            return (Criteria) this;
        }

        public Criteria andLogo_urlNotLike(String value) {
            addCriterion("`logo_url` not like", value, "logo_url");
            return (Criteria) this;
        }

        public Criteria andLogo_urlIn(List<String> values) {
            addCriterion("`logo_url` in", values, "logo_url");
            return (Criteria) this;
        }

        public Criteria andLogo_urlNotIn(List<String> values) {
            addCriterion("`logo_url` not in", values, "logo_url");
            return (Criteria) this;
        }

        public Criteria andLogo_urlBetween(String value1, String value2) {
            addCriterion("`logo_url` between", value1, value2, "logo_url");
            return (Criteria) this;
        }

        public Criteria andLogo_urlNotBetween(String value1, String value2) {
            addCriterion("`logo_url` not between", value1, value2, "logo_url");
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
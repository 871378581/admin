package com.segama.ege.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public ShopExample() {
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

        public Criteria andEnterprise_nameIsNull() {
            addCriterion("`enterprise_name` is null");
            return (Criteria) this;
        }

        public Criteria andEnterprise_nameIsNotNull() {
            addCriterion("`enterprise_name` is not null");
            return (Criteria) this;
        }

        public Criteria andEnterprise_nameEqualTo(String value) {
            addCriterion("`enterprise_name` =", value, "enterprise_name");
            return (Criteria) this;
        }

        public Criteria andEnterprise_nameNotEqualTo(String value) {
            addCriterion("`enterprise_name` <>", value, "enterprise_name");
            return (Criteria) this;
        }

        public Criteria andEnterprise_nameGreaterThan(String value) {
            addCriterion("`enterprise_name` >", value, "enterprise_name");
            return (Criteria) this;
        }

        public Criteria andEnterprise_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`enterprise_name` >=", value, "enterprise_name");
            return (Criteria) this;
        }

        public Criteria andEnterprise_nameLessThan(String value) {
            addCriterion("`enterprise_name` <", value, "enterprise_name");
            return (Criteria) this;
        }

        public Criteria andEnterprise_nameLessThanOrEqualTo(String value) {
            addCriterion("`enterprise_name` <=", value, "enterprise_name");
            return (Criteria) this;
        }

        public Criteria andEnterprise_nameLike(String value) {
            addCriterion("`enterprise_name` like", value, "enterprise_name");
            return (Criteria) this;
        }

        public Criteria andEnterprise_nameNotLike(String value) {
            addCriterion("`enterprise_name` not like", value, "enterprise_name");
            return (Criteria) this;
        }

        public Criteria andEnterprise_nameIn(List<String> values) {
            addCriterion("`enterprise_name` in", values, "enterprise_name");
            return (Criteria) this;
        }

        public Criteria andEnterprise_nameNotIn(List<String> values) {
            addCriterion("`enterprise_name` not in", values, "enterprise_name");
            return (Criteria) this;
        }

        public Criteria andEnterprise_nameBetween(String value1, String value2) {
            addCriterion("`enterprise_name` between", value1, value2, "enterprise_name");
            return (Criteria) this;
        }

        public Criteria andEnterprise_nameNotBetween(String value1, String value2) {
            addCriterion("`enterprise_name` not between", value1, value2, "enterprise_name");
            return (Criteria) this;
        }

        public Criteria andPerson_liable_nameIsNull() {
            addCriterion("`person_liable_name` is null");
            return (Criteria) this;
        }

        public Criteria andPerson_liable_nameIsNotNull() {
            addCriterion("`person_liable_name` is not null");
            return (Criteria) this;
        }

        public Criteria andPerson_liable_nameEqualTo(String value) {
            addCriterion("`person_liable_name` =", value, "person_liable_name");
            return (Criteria) this;
        }

        public Criteria andPerson_liable_nameNotEqualTo(String value) {
            addCriterion("`person_liable_name` <>", value, "person_liable_name");
            return (Criteria) this;
        }

        public Criteria andPerson_liable_nameGreaterThan(String value) {
            addCriterion("`person_liable_name` >", value, "person_liable_name");
            return (Criteria) this;
        }

        public Criteria andPerson_liable_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`person_liable_name` >=", value, "person_liable_name");
            return (Criteria) this;
        }

        public Criteria andPerson_liable_nameLessThan(String value) {
            addCriterion("`person_liable_name` <", value, "person_liable_name");
            return (Criteria) this;
        }

        public Criteria andPerson_liable_nameLessThanOrEqualTo(String value) {
            addCriterion("`person_liable_name` <=", value, "person_liable_name");
            return (Criteria) this;
        }

        public Criteria andPerson_liable_nameLike(String value) {
            addCriterion("`person_liable_name` like", value, "person_liable_name");
            return (Criteria) this;
        }

        public Criteria andPerson_liable_nameNotLike(String value) {
            addCriterion("`person_liable_name` not like", value, "person_liable_name");
            return (Criteria) this;
        }

        public Criteria andPerson_liable_nameIn(List<String> values) {
            addCriterion("`person_liable_name` in", values, "person_liable_name");
            return (Criteria) this;
        }

        public Criteria andPerson_liable_nameNotIn(List<String> values) {
            addCriterion("`person_liable_name` not in", values, "person_liable_name");
            return (Criteria) this;
        }

        public Criteria andPerson_liable_nameBetween(String value1, String value2) {
            addCriterion("`person_liable_name` between", value1, value2, "person_liable_name");
            return (Criteria) this;
        }

        public Criteria andPerson_liable_nameNotBetween(String value1, String value2) {
            addCriterion("`person_liable_name` not between", value1, value2, "person_liable_name");
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

        public Criteria andMobileIsNull() {
            addCriterion("`mobile` is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("`mobile` is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("`mobile` =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("`mobile` <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("`mobile` >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("`mobile` >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("`mobile` <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("`mobile` <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("`mobile` like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("`mobile` not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("`mobile` in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("`mobile` not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("`mobile` between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("`mobile` not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("`address` is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("`address` is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("`address` =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("`address` <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("`address` >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("`address` >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("`address` <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("`address` <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("`address` like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("`address` not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("`address` in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("`address` not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("`address` between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("`address` not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andBusiness_license_img_urlIsNull() {
            addCriterion("`business_license_img_url` is null");
            return (Criteria) this;
        }

        public Criteria andBusiness_license_img_urlIsNotNull() {
            addCriterion("`business_license_img_url` is not null");
            return (Criteria) this;
        }

        public Criteria andBusiness_license_img_urlEqualTo(String value) {
            addCriterion("`business_license_img_url` =", value, "business_license_img_url");
            return (Criteria) this;
        }

        public Criteria andBusiness_license_img_urlNotEqualTo(String value) {
            addCriterion("`business_license_img_url` <>", value, "business_license_img_url");
            return (Criteria) this;
        }

        public Criteria andBusiness_license_img_urlGreaterThan(String value) {
            addCriterion("`business_license_img_url` >", value, "business_license_img_url");
            return (Criteria) this;
        }

        public Criteria andBusiness_license_img_urlGreaterThanOrEqualTo(String value) {
            addCriterion("`business_license_img_url` >=", value, "business_license_img_url");
            return (Criteria) this;
        }

        public Criteria andBusiness_license_img_urlLessThan(String value) {
            addCriterion("`business_license_img_url` <", value, "business_license_img_url");
            return (Criteria) this;
        }

        public Criteria andBusiness_license_img_urlLessThanOrEqualTo(String value) {
            addCriterion("`business_license_img_url` <=", value, "business_license_img_url");
            return (Criteria) this;
        }

        public Criteria andBusiness_license_img_urlLike(String value) {
            addCriterion("`business_license_img_url` like", value, "business_license_img_url");
            return (Criteria) this;
        }

        public Criteria andBusiness_license_img_urlNotLike(String value) {
            addCriterion("`business_license_img_url` not like", value, "business_license_img_url");
            return (Criteria) this;
        }

        public Criteria andBusiness_license_img_urlIn(List<String> values) {
            addCriterion("`business_license_img_url` in", values, "business_license_img_url");
            return (Criteria) this;
        }

        public Criteria andBusiness_license_img_urlNotIn(List<String> values) {
            addCriterion("`business_license_img_url` not in", values, "business_license_img_url");
            return (Criteria) this;
        }

        public Criteria andBusiness_license_img_urlBetween(String value1, String value2) {
            addCriterion("`business_license_img_url` between", value1, value2, "business_license_img_url");
            return (Criteria) this;
        }

        public Criteria andBusiness_license_img_urlNotBetween(String value1, String value2) {
            addCriterion("`business_license_img_url` not between", value1, value2, "business_license_img_url");
            return (Criteria) this;
        }

        public Criteria andDoor_img_urlIsNull() {
            addCriterion("`door_img_url` is null");
            return (Criteria) this;
        }

        public Criteria andDoor_img_urlIsNotNull() {
            addCriterion("`door_img_url` is not null");
            return (Criteria) this;
        }

        public Criteria andDoor_img_urlEqualTo(String value) {
            addCriterion("`door_img_url` =", value, "door_img_url");
            return (Criteria) this;
        }

        public Criteria andDoor_img_urlNotEqualTo(String value) {
            addCriterion("`door_img_url` <>", value, "door_img_url");
            return (Criteria) this;
        }

        public Criteria andDoor_img_urlGreaterThan(String value) {
            addCriterion("`door_img_url` >", value, "door_img_url");
            return (Criteria) this;
        }

        public Criteria andDoor_img_urlGreaterThanOrEqualTo(String value) {
            addCriterion("`door_img_url` >=", value, "door_img_url");
            return (Criteria) this;
        }

        public Criteria andDoor_img_urlLessThan(String value) {
            addCriterion("`door_img_url` <", value, "door_img_url");
            return (Criteria) this;
        }

        public Criteria andDoor_img_urlLessThanOrEqualTo(String value) {
            addCriterion("`door_img_url` <=", value, "door_img_url");
            return (Criteria) this;
        }

        public Criteria andDoor_img_urlLike(String value) {
            addCriterion("`door_img_url` like", value, "door_img_url");
            return (Criteria) this;
        }

        public Criteria andDoor_img_urlNotLike(String value) {
            addCriterion("`door_img_url` not like", value, "door_img_url");
            return (Criteria) this;
        }

        public Criteria andDoor_img_urlIn(List<String> values) {
            addCriterion("`door_img_url` in", values, "door_img_url");
            return (Criteria) this;
        }

        public Criteria andDoor_img_urlNotIn(List<String> values) {
            addCriterion("`door_img_url` not in", values, "door_img_url");
            return (Criteria) this;
        }

        public Criteria andDoor_img_urlBetween(String value1, String value2) {
            addCriterion("`door_img_url` between", value1, value2, "door_img_url");
            return (Criteria) this;
        }

        public Criteria andDoor_img_urlNotBetween(String value1, String value2) {
            addCriterion("`door_img_url` not between", value1, value2, "door_img_url");
            return (Criteria) this;
        }

        public Criteria andLogo_img_urlIsNull() {
            addCriterion("`logo_img_url` is null");
            return (Criteria) this;
        }

        public Criteria andLogo_img_urlIsNotNull() {
            addCriterion("`logo_img_url` is not null");
            return (Criteria) this;
        }

        public Criteria andLogo_img_urlEqualTo(String value) {
            addCriterion("`logo_img_url` =", value, "logo_img_url");
            return (Criteria) this;
        }

        public Criteria andLogo_img_urlNotEqualTo(String value) {
            addCriterion("`logo_img_url` <>", value, "logo_img_url");
            return (Criteria) this;
        }

        public Criteria andLogo_img_urlGreaterThan(String value) {
            addCriterion("`logo_img_url` >", value, "logo_img_url");
            return (Criteria) this;
        }

        public Criteria andLogo_img_urlGreaterThanOrEqualTo(String value) {
            addCriterion("`logo_img_url` >=", value, "logo_img_url");
            return (Criteria) this;
        }

        public Criteria andLogo_img_urlLessThan(String value) {
            addCriterion("`logo_img_url` <", value, "logo_img_url");
            return (Criteria) this;
        }

        public Criteria andLogo_img_urlLessThanOrEqualTo(String value) {
            addCriterion("`logo_img_url` <=", value, "logo_img_url");
            return (Criteria) this;
        }

        public Criteria andLogo_img_urlLike(String value) {
            addCriterion("`logo_img_url` like", value, "logo_img_url");
            return (Criteria) this;
        }

        public Criteria andLogo_img_urlNotLike(String value) {
            addCriterion("`logo_img_url` not like", value, "logo_img_url");
            return (Criteria) this;
        }

        public Criteria andLogo_img_urlIn(List<String> values) {
            addCriterion("`logo_img_url` in", values, "logo_img_url");
            return (Criteria) this;
        }

        public Criteria andLogo_img_urlNotIn(List<String> values) {
            addCriterion("`logo_img_url` not in", values, "logo_img_url");
            return (Criteria) this;
        }

        public Criteria andLogo_img_urlBetween(String value1, String value2) {
            addCriterion("`logo_img_url` between", value1, value2, "logo_img_url");
            return (Criteria) this;
        }

        public Criteria andLogo_img_urlNotBetween(String value1, String value2) {
            addCriterion("`logo_img_url` not between", value1, value2, "logo_img_url");
            return (Criteria) this;
        }

        public Criteria andIntroduceIsNull() {
            addCriterion("`introduce` is null");
            return (Criteria) this;
        }

        public Criteria andIntroduceIsNotNull() {
            addCriterion("`introduce` is not null");
            return (Criteria) this;
        }

        public Criteria andIntroduceEqualTo(String value) {
            addCriterion("`introduce` =", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotEqualTo(String value) {
            addCriterion("`introduce` <>", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThan(String value) {
            addCriterion("`introduce` >", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("`introduce` >=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThan(String value) {
            addCriterion("`introduce` <", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLessThanOrEqualTo(String value) {
            addCriterion("`introduce` <=", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceLike(String value) {
            addCriterion("`introduce` like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotLike(String value) {
            addCriterion("`introduce` not like", value, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceIn(List<String> values) {
            addCriterion("`introduce` in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotIn(List<String> values) {
            addCriterion("`introduce` not in", values, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceBetween(String value1, String value2) {
            addCriterion("`introduce` between", value1, value2, "introduce");
            return (Criteria) this;
        }

        public Criteria andIntroduceNotBetween(String value1, String value2) {
            addCriterion("`introduce` not between", value1, value2, "introduce");
            return (Criteria) this;
        }

        public Criteria andServiceIsNull() {
            addCriterion("`service` is null");
            return (Criteria) this;
        }

        public Criteria andServiceIsNotNull() {
            addCriterion("`service` is not null");
            return (Criteria) this;
        }

        public Criteria andServiceEqualTo(String value) {
            addCriterion("`service` =", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceNotEqualTo(String value) {
            addCriterion("`service` <>", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceGreaterThan(String value) {
            addCriterion("`service` >", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceGreaterThanOrEqualTo(String value) {
            addCriterion("`service` >=", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceLessThan(String value) {
            addCriterion("`service` <", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceLessThanOrEqualTo(String value) {
            addCriterion("`service` <=", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceLike(String value) {
            addCriterion("`service` like", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceNotLike(String value) {
            addCriterion("`service` not like", value, "service");
            return (Criteria) this;
        }

        public Criteria andServiceIn(List<String> values) {
            addCriterion("`service` in", values, "service");
            return (Criteria) this;
        }

        public Criteria andServiceNotIn(List<String> values) {
            addCriterion("`service` not in", values, "service");
            return (Criteria) this;
        }

        public Criteria andServiceBetween(String value1, String value2) {
            addCriterion("`service` between", value1, value2, "service");
            return (Criteria) this;
        }

        public Criteria andServiceNotBetween(String value1, String value2) {
            addCriterion("`service` not between", value1, value2, "service");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("`score` is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("`score` is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(String value) {
            addCriterion("`score` =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(String value) {
            addCriterion("`score` <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(String value) {
            addCriterion("`score` >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(String value) {
            addCriterion("`score` >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(String value) {
            addCriterion("`score` <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(String value) {
            addCriterion("`score` <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLike(String value) {
            addCriterion("`score` like", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotLike(String value) {
            addCriterion("`score` not like", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<String> values) {
            addCriterion("`score` in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<String> values) {
            addCriterion("`score` not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(String value1, String value2) {
            addCriterion("`score` between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(String value1, String value2) {
            addCriterion("`score` not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andIs_disableIsNull() {
            addCriterion("`is_disable` is null");
            return (Criteria) this;
        }

        public Criteria andIs_disableIsNotNull() {
            addCriterion("`is_disable` is not null");
            return (Criteria) this;
        }

        public Criteria andIs_disableEqualTo(Boolean value) {
            addCriterion("`is_disable` =", value, "is_disable");
            return (Criteria) this;
        }

        public Criteria andIs_disableNotEqualTo(Boolean value) {
            addCriterion("`is_disable` <>", value, "is_disable");
            return (Criteria) this;
        }

        public Criteria andIs_disableGreaterThan(Boolean value) {
            addCriterion("`is_disable` >", value, "is_disable");
            return (Criteria) this;
        }

        public Criteria andIs_disableGreaterThanOrEqualTo(Boolean value) {
            addCriterion("`is_disable` >=", value, "is_disable");
            return (Criteria) this;
        }

        public Criteria andIs_disableLessThan(Boolean value) {
            addCriterion("`is_disable` <", value, "is_disable");
            return (Criteria) this;
        }

        public Criteria andIs_disableLessThanOrEqualTo(Boolean value) {
            addCriterion("`is_disable` <=", value, "is_disable");
            return (Criteria) this;
        }

        public Criteria andIs_disableIn(List<Boolean> values) {
            addCriterion("`is_disable` in", values, "is_disable");
            return (Criteria) this;
        }

        public Criteria andIs_disableNotIn(List<Boolean> values) {
            addCriterion("`is_disable` not in", values, "is_disable");
            return (Criteria) this;
        }

        public Criteria andIs_disableBetween(Boolean value1, Boolean value2) {
            addCriterion("`is_disable` between", value1, value2, "is_disable");
            return (Criteria) this;
        }

        public Criteria andIs_disableNotBetween(Boolean value1, Boolean value2) {
            addCriterion("`is_disable` not between", value1, value2, "is_disable");
            return (Criteria) this;
        }

        public Criteria andWorkstation_numIsNull() {
            addCriterion("`workstation_num` is null");
            return (Criteria) this;
        }

        public Criteria andWorkstation_numIsNotNull() {
            addCriterion("`workstation_num` is not null");
            return (Criteria) this;
        }

        public Criteria andWorkstation_numEqualTo(Long value) {
            addCriterion("`workstation_num` =", value, "workstation_num");
            return (Criteria) this;
        }

        public Criteria andWorkstation_numNotEqualTo(Long value) {
            addCriterion("`workstation_num` <>", value, "workstation_num");
            return (Criteria) this;
        }

        public Criteria andWorkstation_numGreaterThan(Long value) {
            addCriterion("`workstation_num` >", value, "workstation_num");
            return (Criteria) this;
        }

        public Criteria andWorkstation_numGreaterThanOrEqualTo(Long value) {
            addCriterion("`workstation_num` >=", value, "workstation_num");
            return (Criteria) this;
        }

        public Criteria andWorkstation_numLessThan(Long value) {
            addCriterion("`workstation_num` <", value, "workstation_num");
            return (Criteria) this;
        }

        public Criteria andWorkstation_numLessThanOrEqualTo(Long value) {
            addCriterion("`workstation_num` <=", value, "workstation_num");
            return (Criteria) this;
        }

        public Criteria andWorkstation_numIn(List<Long> values) {
            addCriterion("`workstation_num` in", values, "workstation_num");
            return (Criteria) this;
        }

        public Criteria andWorkstation_numNotIn(List<Long> values) {
            addCriterion("`workstation_num` not in", values, "workstation_num");
            return (Criteria) this;
        }

        public Criteria andWorkstation_numBetween(Long value1, Long value2) {
            addCriterion("`workstation_num` between", value1, value2, "workstation_num");
            return (Criteria) this;
        }

        public Criteria andWorkstation_numNotBetween(Long value1, Long value2) {
            addCriterion("`workstation_num` not between", value1, value2, "workstation_num");
            return (Criteria) this;
        }

        public Criteria andBusiness_hour_startIsNull() {
            addCriterion("`business_hour_start` is null");
            return (Criteria) this;
        }

        public Criteria andBusiness_hour_startIsNotNull() {
            addCriterion("`business_hour_start` is not null");
            return (Criteria) this;
        }

        public Criteria andBusiness_hour_startEqualTo(String value) {
            addCriterion("`business_hour_start` =", value, "business_hour_start");
            return (Criteria) this;
        }

        public Criteria andBusiness_hour_startNotEqualTo(String value) {
            addCriterion("`business_hour_start` <>", value, "business_hour_start");
            return (Criteria) this;
        }

        public Criteria andBusiness_hour_startGreaterThan(String value) {
            addCriterion("`business_hour_start` >", value, "business_hour_start");
            return (Criteria) this;
        }

        public Criteria andBusiness_hour_startGreaterThanOrEqualTo(String value) {
            addCriterion("`business_hour_start` >=", value, "business_hour_start");
            return (Criteria) this;
        }

        public Criteria andBusiness_hour_startLessThan(String value) {
            addCriterion("`business_hour_start` <", value, "business_hour_start");
            return (Criteria) this;
        }

        public Criteria andBusiness_hour_startLessThanOrEqualTo(String value) {
            addCriterion("`business_hour_start` <=", value, "business_hour_start");
            return (Criteria) this;
        }

        public Criteria andBusiness_hour_startLike(String value) {
            addCriterion("`business_hour_start` like", value, "business_hour_start");
            return (Criteria) this;
        }

        public Criteria andBusiness_hour_startNotLike(String value) {
            addCriterion("`business_hour_start` not like", value, "business_hour_start");
            return (Criteria) this;
        }

        public Criteria andBusiness_hour_startIn(List<String> values) {
            addCriterion("`business_hour_start` in", values, "business_hour_start");
            return (Criteria) this;
        }

        public Criteria andBusiness_hour_startNotIn(List<String> values) {
            addCriterion("`business_hour_start` not in", values, "business_hour_start");
            return (Criteria) this;
        }

        public Criteria andBusiness_hour_startBetween(String value1, String value2) {
            addCriterion("`business_hour_start` between", value1, value2, "business_hour_start");
            return (Criteria) this;
        }

        public Criteria andBusiness_hour_startNotBetween(String value1, String value2) {
            addCriterion("`business_hour_start` not between", value1, value2, "business_hour_start");
            return (Criteria) this;
        }

        public Criteria andBusiness_hour_endIsNull() {
            addCriterion("`business_hour_end` is null");
            return (Criteria) this;
        }

        public Criteria andBusiness_hour_endIsNotNull() {
            addCriterion("`business_hour_end` is not null");
            return (Criteria) this;
        }

        public Criteria andBusiness_hour_endEqualTo(String value) {
            addCriterion("`business_hour_end` =", value, "business_hour_end");
            return (Criteria) this;
        }

        public Criteria andBusiness_hour_endNotEqualTo(String value) {
            addCriterion("`business_hour_end` <>", value, "business_hour_end");
            return (Criteria) this;
        }

        public Criteria andBusiness_hour_endGreaterThan(String value) {
            addCriterion("`business_hour_end` >", value, "business_hour_end");
            return (Criteria) this;
        }

        public Criteria andBusiness_hour_endGreaterThanOrEqualTo(String value) {
            addCriterion("`business_hour_end` >=", value, "business_hour_end");
            return (Criteria) this;
        }

        public Criteria andBusiness_hour_endLessThan(String value) {
            addCriterion("`business_hour_end` <", value, "business_hour_end");
            return (Criteria) this;
        }

        public Criteria andBusiness_hour_endLessThanOrEqualTo(String value) {
            addCriterion("`business_hour_end` <=", value, "business_hour_end");
            return (Criteria) this;
        }

        public Criteria andBusiness_hour_endLike(String value) {
            addCriterion("`business_hour_end` like", value, "business_hour_end");
            return (Criteria) this;
        }

        public Criteria andBusiness_hour_endNotLike(String value) {
            addCriterion("`business_hour_end` not like", value, "business_hour_end");
            return (Criteria) this;
        }

        public Criteria andBusiness_hour_endIn(List<String> values) {
            addCriterion("`business_hour_end` in", values, "business_hour_end");
            return (Criteria) this;
        }

        public Criteria andBusiness_hour_endNotIn(List<String> values) {
            addCriterion("`business_hour_end` not in", values, "business_hour_end");
            return (Criteria) this;
        }

        public Criteria andBusiness_hour_endBetween(String value1, String value2) {
            addCriterion("`business_hour_end` between", value1, value2, "business_hour_end");
            return (Criteria) this;
        }

        public Criteria andBusiness_hour_endNotBetween(String value1, String value2) {
            addCriterion("`business_hour_end` not between", value1, value2, "business_hour_end");
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

        public Criteria andIs_recommendIsNull() {
            addCriterion("`is_recommend` is null");
            return (Criteria) this;
        }

        public Criteria andIs_recommendIsNotNull() {
            addCriterion("`is_recommend` is not null");
            return (Criteria) this;
        }

        public Criteria andIs_recommendEqualTo(Boolean value) {
            addCriterion("`is_recommend` =", value, "is_recommend");
            return (Criteria) this;
        }

        public Criteria andIs_recommendNotEqualTo(Boolean value) {
            addCriterion("`is_recommend` <>", value, "is_recommend");
            return (Criteria) this;
        }

        public Criteria andIs_recommendGreaterThan(Boolean value) {
            addCriterion("`is_recommend` >", value, "is_recommend");
            return (Criteria) this;
        }

        public Criteria andIs_recommendGreaterThanOrEqualTo(Boolean value) {
            addCriterion("`is_recommend` >=", value, "is_recommend");
            return (Criteria) this;
        }

        public Criteria andIs_recommendLessThan(Boolean value) {
            addCriterion("`is_recommend` <", value, "is_recommend");
            return (Criteria) this;
        }

        public Criteria andIs_recommendLessThanOrEqualTo(Boolean value) {
            addCriterion("`is_recommend` <=", value, "is_recommend");
            return (Criteria) this;
        }

        public Criteria andIs_recommendIn(List<Boolean> values) {
            addCriterion("`is_recommend` in", values, "is_recommend");
            return (Criteria) this;
        }

        public Criteria andIs_recommendNotIn(List<Boolean> values) {
            addCriterion("`is_recommend` not in", values, "is_recommend");
            return (Criteria) this;
        }

        public Criteria andIs_recommendBetween(Boolean value1, Boolean value2) {
            addCriterion("`is_recommend` between", value1, value2, "is_recommend");
            return (Criteria) this;
        }

        public Criteria andIs_recommendNotBetween(Boolean value1, Boolean value2) {
            addCriterion("`is_recommend` not between", value1, value2, "is_recommend");
            return (Criteria) this;
        }

        public Criteria andGmt_recommendIsNull() {
            addCriterion("`gmt_recommend` is null");
            return (Criteria) this;
        }

        public Criteria andGmt_recommendIsNotNull() {
            addCriterion("`gmt_recommend` is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_recommendEqualTo(Date value) {
            addCriterion("`gmt_recommend` =", value, "gmt_recommend");
            return (Criteria) this;
        }

        public Criteria andGmt_recommendNotEqualTo(Date value) {
            addCriterion("`gmt_recommend` <>", value, "gmt_recommend");
            return (Criteria) this;
        }

        public Criteria andGmt_recommendGreaterThan(Date value) {
            addCriterion("`gmt_recommend` >", value, "gmt_recommend");
            return (Criteria) this;
        }

        public Criteria andGmt_recommendGreaterThanOrEqualTo(Date value) {
            addCriterion("`gmt_recommend` >=", value, "gmt_recommend");
            return (Criteria) this;
        }

        public Criteria andGmt_recommendLessThan(Date value) {
            addCriterion("`gmt_recommend` <", value, "gmt_recommend");
            return (Criteria) this;
        }

        public Criteria andGmt_recommendLessThanOrEqualTo(Date value) {
            addCriterion("`gmt_recommend` <=", value, "gmt_recommend");
            return (Criteria) this;
        }

        public Criteria andGmt_recommendIn(List<Date> values) {
            addCriterion("`gmt_recommend` in", values, "gmt_recommend");
            return (Criteria) this;
        }

        public Criteria andGmt_recommendNotIn(List<Date> values) {
            addCriterion("`gmt_recommend` not in", values, "gmt_recommend");
            return (Criteria) this;
        }

        public Criteria andGmt_recommendBetween(Date value1, Date value2) {
            addCriterion("`gmt_recommend` between", value1, value2, "gmt_recommend");
            return (Criteria) this;
        }

        public Criteria andGmt_recommendNotBetween(Date value1, Date value2) {
            addCriterion("`gmt_recommend` not between", value1, value2, "gmt_recommend");
            return (Criteria) this;
        }

        public Criteria andDisable_reasonIsNull() {
            addCriterion("`disable_reason` is null");
            return (Criteria) this;
        }

        public Criteria andDisable_reasonIsNotNull() {
            addCriterion("`disable_reason` is not null");
            return (Criteria) this;
        }

        public Criteria andDisable_reasonEqualTo(String value) {
            addCriterion("`disable_reason` =", value, "disable_reason");
            return (Criteria) this;
        }

        public Criteria andDisable_reasonNotEqualTo(String value) {
            addCriterion("`disable_reason` <>", value, "disable_reason");
            return (Criteria) this;
        }

        public Criteria andDisable_reasonGreaterThan(String value) {
            addCriterion("`disable_reason` >", value, "disable_reason");
            return (Criteria) this;
        }

        public Criteria andDisable_reasonGreaterThanOrEqualTo(String value) {
            addCriterion("`disable_reason` >=", value, "disable_reason");
            return (Criteria) this;
        }

        public Criteria andDisable_reasonLessThan(String value) {
            addCriterion("`disable_reason` <", value, "disable_reason");
            return (Criteria) this;
        }

        public Criteria andDisable_reasonLessThanOrEqualTo(String value) {
            addCriterion("`disable_reason` <=", value, "disable_reason");
            return (Criteria) this;
        }

        public Criteria andDisable_reasonLike(String value) {
            addCriterion("`disable_reason` like", value, "disable_reason");
            return (Criteria) this;
        }

        public Criteria andDisable_reasonNotLike(String value) {
            addCriterion("`disable_reason` not like", value, "disable_reason");
            return (Criteria) this;
        }

        public Criteria andDisable_reasonIn(List<String> values) {
            addCriterion("`disable_reason` in", values, "disable_reason");
            return (Criteria) this;
        }

        public Criteria andDisable_reasonNotIn(List<String> values) {
            addCriterion("`disable_reason` not in", values, "disable_reason");
            return (Criteria) this;
        }

        public Criteria andDisable_reasonBetween(String value1, String value2) {
            addCriterion("`disable_reason` between", value1, value2, "disable_reason");
            return (Criteria) this;
        }

        public Criteria andDisable_reasonNotBetween(String value1, String value2) {
            addCriterion("`disable_reason` not between", value1, value2, "disable_reason");
            return (Criteria) this;
        }

        public Criteria andDisable_daysIsNull() {
            addCriterion("`disable_days` is null");
            return (Criteria) this;
        }

        public Criteria andDisable_daysIsNotNull() {
            addCriterion("`disable_days` is not null");
            return (Criteria) this;
        }

        public Criteria andDisable_daysEqualTo(Integer value) {
            addCriterion("`disable_days` =", value, "disable_days");
            return (Criteria) this;
        }

        public Criteria andDisable_daysNotEqualTo(Integer value) {
            addCriterion("`disable_days` <>", value, "disable_days");
            return (Criteria) this;
        }

        public Criteria andDisable_daysGreaterThan(Integer value) {
            addCriterion("`disable_days` >", value, "disable_days");
            return (Criteria) this;
        }

        public Criteria andDisable_daysGreaterThanOrEqualTo(Integer value) {
            addCriterion("`disable_days` >=", value, "disable_days");
            return (Criteria) this;
        }

        public Criteria andDisable_daysLessThan(Integer value) {
            addCriterion("`disable_days` <", value, "disable_days");
            return (Criteria) this;
        }

        public Criteria andDisable_daysLessThanOrEqualTo(Integer value) {
            addCriterion("`disable_days` <=", value, "disable_days");
            return (Criteria) this;
        }

        public Criteria andDisable_daysIn(List<Integer> values) {
            addCriterion("`disable_days` in", values, "disable_days");
            return (Criteria) this;
        }

        public Criteria andDisable_daysNotIn(List<Integer> values) {
            addCriterion("`disable_days` not in", values, "disable_days");
            return (Criteria) this;
        }

        public Criteria andDisable_daysBetween(Integer value1, Integer value2) {
            addCriterion("`disable_days` between", value1, value2, "disable_days");
            return (Criteria) this;
        }

        public Criteria andDisable_daysNotBetween(Integer value1, Integer value2) {
            addCriterion("`disable_days` not between", value1, value2, "disable_days");
            return (Criteria) this;
        }

        public Criteria andSmall_img_urlIsNull() {
            addCriterion("`small_img_url` is null");
            return (Criteria) this;
        }

        public Criteria andSmall_img_urlIsNotNull() {
            addCriterion("`small_img_url` is not null");
            return (Criteria) this;
        }

        public Criteria andSmall_img_urlEqualTo(String value) {
            addCriterion("`small_img_url` =", value, "small_img_url");
            return (Criteria) this;
        }

        public Criteria andSmall_img_urlNotEqualTo(String value) {
            addCriterion("`small_img_url` <>", value, "small_img_url");
            return (Criteria) this;
        }

        public Criteria andSmall_img_urlGreaterThan(String value) {
            addCriterion("`small_img_url` >", value, "small_img_url");
            return (Criteria) this;
        }

        public Criteria andSmall_img_urlGreaterThanOrEqualTo(String value) {
            addCriterion("`small_img_url` >=", value, "small_img_url");
            return (Criteria) this;
        }

        public Criteria andSmall_img_urlLessThan(String value) {
            addCriterion("`small_img_url` <", value, "small_img_url");
            return (Criteria) this;
        }

        public Criteria andSmall_img_urlLessThanOrEqualTo(String value) {
            addCriterion("`small_img_url` <=", value, "small_img_url");
            return (Criteria) this;
        }

        public Criteria andSmall_img_urlLike(String value) {
            addCriterion("`small_img_url` like", value, "small_img_url");
            return (Criteria) this;
        }

        public Criteria andSmall_img_urlNotLike(String value) {
            addCriterion("`small_img_url` not like", value, "small_img_url");
            return (Criteria) this;
        }

        public Criteria andSmall_img_urlIn(List<String> values) {
            addCriterion("`small_img_url` in", values, "small_img_url");
            return (Criteria) this;
        }

        public Criteria andSmall_img_urlNotIn(List<String> values) {
            addCriterion("`small_img_url` not in", values, "small_img_url");
            return (Criteria) this;
        }

        public Criteria andSmall_img_urlBetween(String value1, String value2) {
            addCriterion("`small_img_url` between", value1, value2, "small_img_url");
            return (Criteria) this;
        }

        public Criteria andSmall_img_urlNotBetween(String value1, String value2) {
            addCriterion("`small_img_url` not between", value1, value2, "small_img_url");
            return (Criteria) this;
        }

        public Criteria andMiles_last_maintenanceIsNull() {
            addCriterion("`miles_last_maintenance` is null");
            return (Criteria) this;
        }

        public Criteria andMiles_last_maintenanceIsNotNull() {
            addCriterion("`miles_last_maintenance` is not null");
            return (Criteria) this;
        }

        public Criteria andMiles_last_maintenanceEqualTo(String value) {
            addCriterion("`miles_last_maintenance` =", value, "miles_last_maintenance");
            return (Criteria) this;
        }

        public Criteria andMiles_last_maintenanceNotEqualTo(String value) {
            addCriterion("`miles_last_maintenance` <>", value, "miles_last_maintenance");
            return (Criteria) this;
        }

        public Criteria andMiles_last_maintenanceGreaterThan(String value) {
            addCriterion("`miles_last_maintenance` >", value, "miles_last_maintenance");
            return (Criteria) this;
        }

        public Criteria andMiles_last_maintenanceGreaterThanOrEqualTo(String value) {
            addCriterion("`miles_last_maintenance` >=", value, "miles_last_maintenance");
            return (Criteria) this;
        }

        public Criteria andMiles_last_maintenanceLessThan(String value) {
            addCriterion("`miles_last_maintenance` <", value, "miles_last_maintenance");
            return (Criteria) this;
        }

        public Criteria andMiles_last_maintenanceLessThanOrEqualTo(String value) {
            addCriterion("`miles_last_maintenance` <=", value, "miles_last_maintenance");
            return (Criteria) this;
        }

        public Criteria andMiles_last_maintenanceLike(String value) {
            addCriterion("`miles_last_maintenance` like", value, "miles_last_maintenance");
            return (Criteria) this;
        }

        public Criteria andMiles_last_maintenanceNotLike(String value) {
            addCriterion("`miles_last_maintenance` not like", value, "miles_last_maintenance");
            return (Criteria) this;
        }

        public Criteria andMiles_last_maintenanceIn(List<String> values) {
            addCriterion("`miles_last_maintenance` in", values, "miles_last_maintenance");
            return (Criteria) this;
        }

        public Criteria andMiles_last_maintenanceNotIn(List<String> values) {
            addCriterion("`miles_last_maintenance` not in", values, "miles_last_maintenance");
            return (Criteria) this;
        }

        public Criteria andMiles_last_maintenanceBetween(String value1, String value2) {
            addCriterion("`miles_last_maintenance` between", value1, value2, "miles_last_maintenance");
            return (Criteria) this;
        }

        public Criteria andMiles_last_maintenanceNotBetween(String value1, String value2) {
            addCriterion("`miles_last_maintenance` not between", value1, value2, "miles_last_maintenance");
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

        public Criteria andEvaluate_tagsIsNull() {
            addCriterion("`evaluate_tags` is null");
            return (Criteria) this;
        }

        public Criteria andEvaluate_tagsIsNotNull() {
            addCriterion("`evaluate_tags` is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluate_tagsEqualTo(String value) {
            addCriterion("`evaluate_tags` =", value, "evaluate_tags");
            return (Criteria) this;
        }

        public Criteria andEvaluate_tagsNotEqualTo(String value) {
            addCriterion("`evaluate_tags` <>", value, "evaluate_tags");
            return (Criteria) this;
        }

        public Criteria andEvaluate_tagsGreaterThan(String value) {
            addCriterion("`evaluate_tags` >", value, "evaluate_tags");
            return (Criteria) this;
        }

        public Criteria andEvaluate_tagsGreaterThanOrEqualTo(String value) {
            addCriterion("`evaluate_tags` >=", value, "evaluate_tags");
            return (Criteria) this;
        }

        public Criteria andEvaluate_tagsLessThan(String value) {
            addCriterion("`evaluate_tags` <", value, "evaluate_tags");
            return (Criteria) this;
        }

        public Criteria andEvaluate_tagsLessThanOrEqualTo(String value) {
            addCriterion("`evaluate_tags` <=", value, "evaluate_tags");
            return (Criteria) this;
        }

        public Criteria andEvaluate_tagsLike(String value) {
            addCriterion("`evaluate_tags` like", value, "evaluate_tags");
            return (Criteria) this;
        }

        public Criteria andEvaluate_tagsNotLike(String value) {
            addCriterion("`evaluate_tags` not like", value, "evaluate_tags");
            return (Criteria) this;
        }

        public Criteria andEvaluate_tagsIn(List<String> values) {
            addCriterion("`evaluate_tags` in", values, "evaluate_tags");
            return (Criteria) this;
        }

        public Criteria andEvaluate_tagsNotIn(List<String> values) {
            addCriterion("`evaluate_tags` not in", values, "evaluate_tags");
            return (Criteria) this;
        }

        public Criteria andEvaluate_tagsBetween(String value1, String value2) {
            addCriterion("`evaluate_tags` between", value1, value2, "evaluate_tags");
            return (Criteria) this;
        }

        public Criteria andEvaluate_tagsNotBetween(String value1, String value2) {
            addCriterion("`evaluate_tags` not between", value1, value2, "evaluate_tags");
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
package com.segama.ege.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThUrlManageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public ThUrlManageExample() {
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

        public Criteria andBusiness_nameIsNull() {
            addCriterion("`business_name` is null");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameIsNotNull() {
            addCriterion("`business_name` is not null");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameEqualTo(String value) {
            addCriterion("`business_name` =", value, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameNotEqualTo(String value) {
            addCriterion("`business_name` <>", value, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameGreaterThan(String value) {
            addCriterion("`business_name` >", value, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`business_name` >=", value, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameLessThan(String value) {
            addCriterion("`business_name` <", value, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameLessThanOrEqualTo(String value) {
            addCriterion("`business_name` <=", value, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameLike(String value) {
            addCriterion("`business_name` like", value, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameNotLike(String value) {
            addCriterion("`business_name` not like", value, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameIn(List<String> values) {
            addCriterion("`business_name` in", values, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameNotIn(List<String> values) {
            addCriterion("`business_name` not in", values, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameBetween(String value1, String value2) {
            addCriterion("`business_name` between", value1, value2, "business_name");
            return (Criteria) this;
        }

        public Criteria andBusiness_nameNotBetween(String value1, String value2) {
            addCriterion("`business_name` not between", value1, value2, "business_name");
            return (Criteria) this;
        }

        public Criteria andUrl_codeIsNull() {
            addCriterion("`url_code` is null");
            return (Criteria) this;
        }

        public Criteria andUrl_codeIsNotNull() {
            addCriterion("`url_code` is not null");
            return (Criteria) this;
        }

        public Criteria andUrl_codeEqualTo(String value) {
            addCriterion("`url_code` =", value, "url_code");
            return (Criteria) this;
        }

        public Criteria andUrl_codeNotEqualTo(String value) {
            addCriterion("`url_code` <>", value, "url_code");
            return (Criteria) this;
        }

        public Criteria andUrl_codeGreaterThan(String value) {
            addCriterion("`url_code` >", value, "url_code");
            return (Criteria) this;
        }

        public Criteria andUrl_codeGreaterThanOrEqualTo(String value) {
            addCriterion("`url_code` >=", value, "url_code");
            return (Criteria) this;
        }

        public Criteria andUrl_codeLessThan(String value) {
            addCriterion("`url_code` <", value, "url_code");
            return (Criteria) this;
        }

        public Criteria andUrl_codeLessThanOrEqualTo(String value) {
            addCriterion("`url_code` <=", value, "url_code");
            return (Criteria) this;
        }

        public Criteria andUrl_codeLike(String value) {
            addCriterion("`url_code` like", value, "url_code");
            return (Criteria) this;
        }

        public Criteria andUrl_codeNotLike(String value) {
            addCriterion("`url_code` not like", value, "url_code");
            return (Criteria) this;
        }

        public Criteria andUrl_codeIn(List<String> values) {
            addCriterion("`url_code` in", values, "url_code");
            return (Criteria) this;
        }

        public Criteria andUrl_codeNotIn(List<String> values) {
            addCriterion("`url_code` not in", values, "url_code");
            return (Criteria) this;
        }

        public Criteria andUrl_codeBetween(String value1, String value2) {
            addCriterion("`url_code` between", value1, value2, "url_code");
            return (Criteria) this;
        }

        public Criteria andUrl_codeNotBetween(String value1, String value2) {
            addCriterion("`url_code` not between", value1, value2, "url_code");
            return (Criteria) this;
        }

        public Criteria andShare_url_codeIsNull() {
            addCriterion("`share_url_code` is null");
            return (Criteria) this;
        }

        public Criteria andShare_url_codeIsNotNull() {
            addCriterion("`share_url_code` is not null");
            return (Criteria) this;
        }

        public Criteria andShare_url_codeEqualTo(String value) {
            addCriterion("`share_url_code` =", value, "share_url_code");
            return (Criteria) this;
        }

        public Criteria andShare_url_codeNotEqualTo(String value) {
            addCriterion("`share_url_code` <>", value, "share_url_code");
            return (Criteria) this;
        }

        public Criteria andShare_url_codeGreaterThan(String value) {
            addCriterion("`share_url_code` >", value, "share_url_code");
            return (Criteria) this;
        }

        public Criteria andShare_url_codeGreaterThanOrEqualTo(String value) {
            addCriterion("`share_url_code` >=", value, "share_url_code");
            return (Criteria) this;
        }

        public Criteria andShare_url_codeLessThan(String value) {
            addCriterion("`share_url_code` <", value, "share_url_code");
            return (Criteria) this;
        }

        public Criteria andShare_url_codeLessThanOrEqualTo(String value) {
            addCriterion("`share_url_code` <=", value, "share_url_code");
            return (Criteria) this;
        }

        public Criteria andShare_url_codeLike(String value) {
            addCriterion("`share_url_code` like", value, "share_url_code");
            return (Criteria) this;
        }

        public Criteria andShare_url_codeNotLike(String value) {
            addCriterion("`share_url_code` not like", value, "share_url_code");
            return (Criteria) this;
        }

        public Criteria andShare_url_codeIn(List<String> values) {
            addCriterion("`share_url_code` in", values, "share_url_code");
            return (Criteria) this;
        }

        public Criteria andShare_url_codeNotIn(List<String> values) {
            addCriterion("`share_url_code` not in", values, "share_url_code");
            return (Criteria) this;
        }

        public Criteria andShare_url_codeBetween(String value1, String value2) {
            addCriterion("`share_url_code` between", value1, value2, "share_url_code");
            return (Criteria) this;
        }

        public Criteria andShare_url_codeNotBetween(String value1, String value2) {
            addCriterion("`share_url_code` not between", value1, value2, "share_url_code");
            return (Criteria) this;
        }

        public Criteria andOpen_ticket_main_bodyIsNull() {
            addCriterion("`open_ticket_main_body` is null");
            return (Criteria) this;
        }

        public Criteria andOpen_ticket_main_bodyIsNotNull() {
            addCriterion("`open_ticket_main_body` is not null");
            return (Criteria) this;
        }

        public Criteria andOpen_ticket_main_bodyEqualTo(String value) {
            addCriterion("`open_ticket_main_body` =", value, "open_ticket_main_body");
            return (Criteria) this;
        }

        public Criteria andOpen_ticket_main_bodyNotEqualTo(String value) {
            addCriterion("`open_ticket_main_body` <>", value, "open_ticket_main_body");
            return (Criteria) this;
        }

        public Criteria andOpen_ticket_main_bodyGreaterThan(String value) {
            addCriterion("`open_ticket_main_body` >", value, "open_ticket_main_body");
            return (Criteria) this;
        }

        public Criteria andOpen_ticket_main_bodyGreaterThanOrEqualTo(String value) {
            addCriterion("`open_ticket_main_body` >=", value, "open_ticket_main_body");
            return (Criteria) this;
        }

        public Criteria andOpen_ticket_main_bodyLessThan(String value) {
            addCriterion("`open_ticket_main_body` <", value, "open_ticket_main_body");
            return (Criteria) this;
        }

        public Criteria andOpen_ticket_main_bodyLessThanOrEqualTo(String value) {
            addCriterion("`open_ticket_main_body` <=", value, "open_ticket_main_body");
            return (Criteria) this;
        }

        public Criteria andOpen_ticket_main_bodyLike(String value) {
            addCriterion("`open_ticket_main_body` like", value, "open_ticket_main_body");
            return (Criteria) this;
        }

        public Criteria andOpen_ticket_main_bodyNotLike(String value) {
            addCriterion("`open_ticket_main_body` not like", value, "open_ticket_main_body");
            return (Criteria) this;
        }

        public Criteria andOpen_ticket_main_bodyIn(List<String> values) {
            addCriterion("`open_ticket_main_body` in", values, "open_ticket_main_body");
            return (Criteria) this;
        }

        public Criteria andOpen_ticket_main_bodyNotIn(List<String> values) {
            addCriterion("`open_ticket_main_body` not in", values, "open_ticket_main_body");
            return (Criteria) this;
        }

        public Criteria andOpen_ticket_main_bodyBetween(String value1, String value2) {
            addCriterion("`open_ticket_main_body` between", value1, value2, "open_ticket_main_body");
            return (Criteria) this;
        }

        public Criteria andOpen_ticket_main_bodyNotBetween(String value1, String value2) {
            addCriterion("`open_ticket_main_body` not between", value1, value2, "open_ticket_main_body");
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

        public Criteria andProduct_codeIsNull() {
            addCriterion("`product_code` is null");
            return (Criteria) this;
        }

        public Criteria andProduct_codeIsNotNull() {
            addCriterion("`product_code` is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_codeEqualTo(String value) {
            addCriterion("`product_code` =", value, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeNotEqualTo(String value) {
            addCriterion("`product_code` <>", value, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeGreaterThan(String value) {
            addCriterion("`product_code` >", value, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeGreaterThanOrEqualTo(String value) {
            addCriterion("`product_code` >=", value, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeLessThan(String value) {
            addCriterion("`product_code` <", value, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeLessThanOrEqualTo(String value) {
            addCriterion("`product_code` <=", value, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeLike(String value) {
            addCriterion("`product_code` like", value, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeNotLike(String value) {
            addCriterion("`product_code` not like", value, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeIn(List<String> values) {
            addCriterion("`product_code` in", values, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeNotIn(List<String> values) {
            addCriterion("`product_code` not in", values, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeBetween(String value1, String value2) {
            addCriterion("`product_code` between", value1, value2, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_codeNotBetween(String value1, String value2) {
            addCriterion("`product_code` not between", value1, value2, "product_code");
            return (Criteria) this;
        }

        public Criteria andProduct_typeIsNull() {
            addCriterion("`product_type` is null");
            return (Criteria) this;
        }

        public Criteria andProduct_typeIsNotNull() {
            addCriterion("`product_type` is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_typeEqualTo(String value) {
            addCriterion("`product_type` =", value, "product_type");
            return (Criteria) this;
        }

        public Criteria andProduct_typeNotEqualTo(String value) {
            addCriterion("`product_type` <>", value, "product_type");
            return (Criteria) this;
        }

        public Criteria andProduct_typeGreaterThan(String value) {
            addCriterion("`product_type` >", value, "product_type");
            return (Criteria) this;
        }

        public Criteria andProduct_typeGreaterThanOrEqualTo(String value) {
            addCriterion("`product_type` >=", value, "product_type");
            return (Criteria) this;
        }

        public Criteria andProduct_typeLessThan(String value) {
            addCriterion("`product_type` <", value, "product_type");
            return (Criteria) this;
        }

        public Criteria andProduct_typeLessThanOrEqualTo(String value) {
            addCriterion("`product_type` <=", value, "product_type");
            return (Criteria) this;
        }

        public Criteria andProduct_typeLike(String value) {
            addCriterion("`product_type` like", value, "product_type");
            return (Criteria) this;
        }

        public Criteria andProduct_typeNotLike(String value) {
            addCriterion("`product_type` not like", value, "product_type");
            return (Criteria) this;
        }

        public Criteria andProduct_typeIn(List<String> values) {
            addCriterion("`product_type` in", values, "product_type");
            return (Criteria) this;
        }

        public Criteria andProduct_typeNotIn(List<String> values) {
            addCriterion("`product_type` not in", values, "product_type");
            return (Criteria) this;
        }

        public Criteria andProduct_typeBetween(String value1, String value2) {
            addCriterion("`product_type` between", value1, value2, "product_type");
            return (Criteria) this;
        }

        public Criteria andProduct_typeNotBetween(String value1, String value2) {
            addCriterion("`product_type` not between", value1, value2, "product_type");
            return (Criteria) this;
        }

        public Criteria andProduct_qudao_codeIsNull() {
            addCriterion("`product_qudao_code` is null");
            return (Criteria) this;
        }

        public Criteria andProduct_qudao_codeIsNotNull() {
            addCriterion("`product_qudao_code` is not null");
            return (Criteria) this;
        }

        public Criteria andProduct_qudao_codeEqualTo(String value) {
            addCriterion("`product_qudao_code` =", value, "product_qudao_code");
            return (Criteria) this;
        }

        public Criteria andProduct_qudao_codeNotEqualTo(String value) {
            addCriterion("`product_qudao_code` <>", value, "product_qudao_code");
            return (Criteria) this;
        }

        public Criteria andProduct_qudao_codeGreaterThan(String value) {
            addCriterion("`product_qudao_code` >", value, "product_qudao_code");
            return (Criteria) this;
        }

        public Criteria andProduct_qudao_codeGreaterThanOrEqualTo(String value) {
            addCriterion("`product_qudao_code` >=", value, "product_qudao_code");
            return (Criteria) this;
        }

        public Criteria andProduct_qudao_codeLessThan(String value) {
            addCriterion("`product_qudao_code` <", value, "product_qudao_code");
            return (Criteria) this;
        }

        public Criteria andProduct_qudao_codeLessThanOrEqualTo(String value) {
            addCriterion("`product_qudao_code` <=", value, "product_qudao_code");
            return (Criteria) this;
        }

        public Criteria andProduct_qudao_codeLike(String value) {
            addCriterion("`product_qudao_code` like", value, "product_qudao_code");
            return (Criteria) this;
        }

        public Criteria andProduct_qudao_codeNotLike(String value) {
            addCriterion("`product_qudao_code` not like", value, "product_qudao_code");
            return (Criteria) this;
        }

        public Criteria andProduct_qudao_codeIn(List<String> values) {
            addCriterion("`product_qudao_code` in", values, "product_qudao_code");
            return (Criteria) this;
        }

        public Criteria andProduct_qudao_codeNotIn(List<String> values) {
            addCriterion("`product_qudao_code` not in", values, "product_qudao_code");
            return (Criteria) this;
        }

        public Criteria andProduct_qudao_codeBetween(String value1, String value2) {
            addCriterion("`product_qudao_code` between", value1, value2, "product_qudao_code");
            return (Criteria) this;
        }

        public Criteria andProduct_qudao_codeNotBetween(String value1, String value2) {
            addCriterion("`product_qudao_code` not between", value1, value2, "product_qudao_code");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("`url` is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("`url` is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("`url` =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("`url` <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("`url` >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("`url` >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("`url` <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("`url` <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("`url` like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("`url` not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("`url` in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("`url` not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("`url` between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("`url` not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrl_statusIsNull() {
            addCriterion("`url_status` is null");
            return (Criteria) this;
        }

        public Criteria andUrl_statusIsNotNull() {
            addCriterion("`url_status` is not null");
            return (Criteria) this;
        }

        public Criteria andUrl_statusEqualTo(Integer value) {
            addCriterion("`url_status` =", value, "url_status");
            return (Criteria) this;
        }

        public Criteria andUrl_statusNotEqualTo(Integer value) {
            addCriterion("`url_status` <>", value, "url_status");
            return (Criteria) this;
        }

        public Criteria andUrl_statusGreaterThan(Integer value) {
            addCriterion("`url_status` >", value, "url_status");
            return (Criteria) this;
        }

        public Criteria andUrl_statusGreaterThanOrEqualTo(Integer value) {
            addCriterion("`url_status` >=", value, "url_status");
            return (Criteria) this;
        }

        public Criteria andUrl_statusLessThan(Integer value) {
            addCriterion("`url_status` <", value, "url_status");
            return (Criteria) this;
        }

        public Criteria andUrl_statusLessThanOrEqualTo(Integer value) {
            addCriterion("`url_status` <=", value, "url_status");
            return (Criteria) this;
        }

        public Criteria andUrl_statusIn(List<Integer> values) {
            addCriterion("`url_status` in", values, "url_status");
            return (Criteria) this;
        }

        public Criteria andUrl_statusNotIn(List<Integer> values) {
            addCriterion("`url_status` not in", values, "url_status");
            return (Criteria) this;
        }

        public Criteria andUrl_statusBetween(Integer value1, Integer value2) {
            addCriterion("`url_status` between", value1, value2, "url_status");
            return (Criteria) this;
        }

        public Criteria andUrl_statusNotBetween(Integer value1, Integer value2) {
            addCriterion("`url_status` not between", value1, value2, "url_status");
            return (Criteria) this;
        }

        public Criteria andBiz_lineIsNull() {
            addCriterion("`biz_line` is null");
            return (Criteria) this;
        }

        public Criteria andBiz_lineIsNotNull() {
            addCriterion("`biz_line` is not null");
            return (Criteria) this;
        }

        public Criteria andBiz_lineEqualTo(String value) {
            addCriterion("`biz_line` =", value, "biz_line");
            return (Criteria) this;
        }

        public Criteria andBiz_lineNotEqualTo(String value) {
            addCriterion("`biz_line` <>", value, "biz_line");
            return (Criteria) this;
        }

        public Criteria andBiz_lineGreaterThan(String value) {
            addCriterion("`biz_line` >", value, "biz_line");
            return (Criteria) this;
        }

        public Criteria andBiz_lineGreaterThanOrEqualTo(String value) {
            addCriterion("`biz_line` >=", value, "biz_line");
            return (Criteria) this;
        }

        public Criteria andBiz_lineLessThan(String value) {
            addCriterion("`biz_line` <", value, "biz_line");
            return (Criteria) this;
        }

        public Criteria andBiz_lineLessThanOrEqualTo(String value) {
            addCriterion("`biz_line` <=", value, "biz_line");
            return (Criteria) this;
        }

        public Criteria andBiz_lineLike(String value) {
            addCriterion("`biz_line` like", value, "biz_line");
            return (Criteria) this;
        }

        public Criteria andBiz_lineNotLike(String value) {
            addCriterion("`biz_line` not like", value, "biz_line");
            return (Criteria) this;
        }

        public Criteria andBiz_lineIn(List<String> values) {
            addCriterion("`biz_line` in", values, "biz_line");
            return (Criteria) this;
        }

        public Criteria andBiz_lineNotIn(List<String> values) {
            addCriterion("`biz_line` not in", values, "biz_line");
            return (Criteria) this;
        }

        public Criteria andBiz_lineBetween(String value1, String value2) {
            addCriterion("`biz_line` between", value1, value2, "biz_line");
            return (Criteria) this;
        }

        public Criteria andBiz_lineNotBetween(String value1, String value2) {
            addCriterion("`biz_line` not between", value1, value2, "biz_line");
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

        public Criteria andYouxiao_timeIsNull() {
            addCriterion("`youxiao_time` is null");
            return (Criteria) this;
        }

        public Criteria andYouxiao_timeIsNotNull() {
            addCriterion("`youxiao_time` is not null");
            return (Criteria) this;
        }

        public Criteria andYouxiao_timeEqualTo(String value) {
            addCriterion("`youxiao_time` =", value, "youxiao_time");
            return (Criteria) this;
        }

        public Criteria andYouxiao_timeNotEqualTo(String value) {
            addCriterion("`youxiao_time` <>", value, "youxiao_time");
            return (Criteria) this;
        }

        public Criteria andYouxiao_timeGreaterThan(String value) {
            addCriterion("`youxiao_time` >", value, "youxiao_time");
            return (Criteria) this;
        }

        public Criteria andYouxiao_timeGreaterThanOrEqualTo(String value) {
            addCriterion("`youxiao_time` >=", value, "youxiao_time");
            return (Criteria) this;
        }

        public Criteria andYouxiao_timeLessThan(String value) {
            addCriterion("`youxiao_time` <", value, "youxiao_time");
            return (Criteria) this;
        }

        public Criteria andYouxiao_timeLessThanOrEqualTo(String value) {
            addCriterion("`youxiao_time` <=", value, "youxiao_time");
            return (Criteria) this;
        }

        public Criteria andYouxiao_timeLike(String value) {
            addCriterion("`youxiao_time` like", value, "youxiao_time");
            return (Criteria) this;
        }

        public Criteria andYouxiao_timeNotLike(String value) {
            addCriterion("`youxiao_time` not like", value, "youxiao_time");
            return (Criteria) this;
        }

        public Criteria andYouxiao_timeIn(List<String> values) {
            addCriterion("`youxiao_time` in", values, "youxiao_time");
            return (Criteria) this;
        }

        public Criteria andYouxiao_timeNotIn(List<String> values) {
            addCriterion("`youxiao_time` not in", values, "youxiao_time");
            return (Criteria) this;
        }

        public Criteria andYouxiao_timeBetween(String value1, String value2) {
            addCriterion("`youxiao_time` between", value1, value2, "youxiao_time");
            return (Criteria) this;
        }

        public Criteria andYouxiao_timeNotBetween(String value1, String value2) {
            addCriterion("`youxiao_time` not between", value1, value2, "youxiao_time");
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

        public Criteria andOwner_accountIsNull() {
            addCriterion("`owner_account` is null");
            return (Criteria) this;
        }

        public Criteria andOwner_accountIsNotNull() {
            addCriterion("`owner_account` is not null");
            return (Criteria) this;
        }

        public Criteria andOwner_accountEqualTo(String value) {
            addCriterion("`owner_account` =", value, "owner_account");
            return (Criteria) this;
        }

        public Criteria andOwner_accountNotEqualTo(String value) {
            addCriterion("`owner_account` <>", value, "owner_account");
            return (Criteria) this;
        }

        public Criteria andOwner_accountGreaterThan(String value) {
            addCriterion("`owner_account` >", value, "owner_account");
            return (Criteria) this;
        }

        public Criteria andOwner_accountGreaterThanOrEqualTo(String value) {
            addCriterion("`owner_account` >=", value, "owner_account");
            return (Criteria) this;
        }

        public Criteria andOwner_accountLessThan(String value) {
            addCriterion("`owner_account` <", value, "owner_account");
            return (Criteria) this;
        }

        public Criteria andOwner_accountLessThanOrEqualTo(String value) {
            addCriterion("`owner_account` <=", value, "owner_account");
            return (Criteria) this;
        }

        public Criteria andOwner_accountLike(String value) {
            addCriterion("`owner_account` like", value, "owner_account");
            return (Criteria) this;
        }

        public Criteria andOwner_accountNotLike(String value) {
            addCriterion("`owner_account` not like", value, "owner_account");
            return (Criteria) this;
        }

        public Criteria andOwner_accountIn(List<String> values) {
            addCriterion("`owner_account` in", values, "owner_account");
            return (Criteria) this;
        }

        public Criteria andOwner_accountNotIn(List<String> values) {
            addCriterion("`owner_account` not in", values, "owner_account");
            return (Criteria) this;
        }

        public Criteria andOwner_accountBetween(String value1, String value2) {
            addCriterion("`owner_account` between", value1, value2, "owner_account");
            return (Criteria) this;
        }

        public Criteria andOwner_accountNotBetween(String value1, String value2) {
            addCriterion("`owner_account` not between", value1, value2, "owner_account");
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

        public Criteria andShifou_2_kaifaIsNull() {
            addCriterion("`shifou_2_kaifa` is null");
            return (Criteria) this;
        }

        public Criteria andShifou_2_kaifaIsNotNull() {
            addCriterion("`shifou_2_kaifa` is not null");
            return (Criteria) this;
        }

        public Criteria andShifou_2_kaifaEqualTo(String value) {
            addCriterion("`shifou_2_kaifa` =", value, "shifou_2_kaifa");
            return (Criteria) this;
        }

        public Criteria andShifou_2_kaifaNotEqualTo(String value) {
            addCriterion("`shifou_2_kaifa` <>", value, "shifou_2_kaifa");
            return (Criteria) this;
        }

        public Criteria andShifou_2_kaifaGreaterThan(String value) {
            addCriterion("`shifou_2_kaifa` >", value, "shifou_2_kaifa");
            return (Criteria) this;
        }

        public Criteria andShifou_2_kaifaGreaterThanOrEqualTo(String value) {
            addCriterion("`shifou_2_kaifa` >=", value, "shifou_2_kaifa");
            return (Criteria) this;
        }

        public Criteria andShifou_2_kaifaLessThan(String value) {
            addCriterion("`shifou_2_kaifa` <", value, "shifou_2_kaifa");
            return (Criteria) this;
        }

        public Criteria andShifou_2_kaifaLessThanOrEqualTo(String value) {
            addCriterion("`shifou_2_kaifa` <=", value, "shifou_2_kaifa");
            return (Criteria) this;
        }

        public Criteria andShifou_2_kaifaLike(String value) {
            addCriterion("`shifou_2_kaifa` like", value, "shifou_2_kaifa");
            return (Criteria) this;
        }

        public Criteria andShifou_2_kaifaNotLike(String value) {
            addCriterion("`shifou_2_kaifa` not like", value, "shifou_2_kaifa");
            return (Criteria) this;
        }

        public Criteria andShifou_2_kaifaIn(List<String> values) {
            addCriterion("`shifou_2_kaifa` in", values, "shifou_2_kaifa");
            return (Criteria) this;
        }

        public Criteria andShifou_2_kaifaNotIn(List<String> values) {
            addCriterion("`shifou_2_kaifa` not in", values, "shifou_2_kaifa");
            return (Criteria) this;
        }

        public Criteria andShifou_2_kaifaBetween(String value1, String value2) {
            addCriterion("`shifou_2_kaifa` between", value1, value2, "shifou_2_kaifa");
            return (Criteria) this;
        }

        public Criteria andShifou_2_kaifaNotBetween(String value1, String value2) {
            addCriterion("`shifou_2_kaifa` not between", value1, value2, "shifou_2_kaifa");
            return (Criteria) this;
        }

        public Criteria andOwner_1_accountIsNull() {
            addCriterion("`owner_1_account` is null");
            return (Criteria) this;
        }

        public Criteria andOwner_1_accountIsNotNull() {
            addCriterion("`owner_1_account` is not null");
            return (Criteria) this;
        }

        public Criteria andOwner_1_accountEqualTo(String value) {
            addCriterion("`owner_1_account` =", value, "owner_1_account");
            return (Criteria) this;
        }

        public Criteria andOwner_1_accountNotEqualTo(String value) {
            addCriterion("`owner_1_account` <>", value, "owner_1_account");
            return (Criteria) this;
        }

        public Criteria andOwner_1_accountGreaterThan(String value) {
            addCriterion("`owner_1_account` >", value, "owner_1_account");
            return (Criteria) this;
        }

        public Criteria andOwner_1_accountGreaterThanOrEqualTo(String value) {
            addCriterion("`owner_1_account` >=", value, "owner_1_account");
            return (Criteria) this;
        }

        public Criteria andOwner_1_accountLessThan(String value) {
            addCriterion("`owner_1_account` <", value, "owner_1_account");
            return (Criteria) this;
        }

        public Criteria andOwner_1_accountLessThanOrEqualTo(String value) {
            addCriterion("`owner_1_account` <=", value, "owner_1_account");
            return (Criteria) this;
        }

        public Criteria andOwner_1_accountLike(String value) {
            addCriterion("`owner_1_account` like", value, "owner_1_account");
            return (Criteria) this;
        }

        public Criteria andOwner_1_accountNotLike(String value) {
            addCriterion("`owner_1_account` not like", value, "owner_1_account");
            return (Criteria) this;
        }

        public Criteria andOwner_1_accountIn(List<String> values) {
            addCriterion("`owner_1_account` in", values, "owner_1_account");
            return (Criteria) this;
        }

        public Criteria andOwner_1_accountNotIn(List<String> values) {
            addCriterion("`owner_1_account` not in", values, "owner_1_account");
            return (Criteria) this;
        }

        public Criteria andOwner_1_accountBetween(String value1, String value2) {
            addCriterion("`owner_1_account` between", value1, value2, "owner_1_account");
            return (Criteria) this;
        }

        public Criteria andOwner_1_accountNotBetween(String value1, String value2) {
            addCriterion("`owner_1_account` not between", value1, value2, "owner_1_account");
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
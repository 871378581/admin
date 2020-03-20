package com.segama.ege.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusinessCooperateApplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public BusinessCooperateApplyExample() {
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

        public Criteria andPhone_numIsNull() {
            addCriterion("`phone_num` is null");
            return (Criteria) this;
        }

        public Criteria andPhone_numIsNotNull() {
            addCriterion("`phone_num` is not null");
            return (Criteria) this;
        }

        public Criteria andPhone_numEqualTo(String value) {
            addCriterion("`phone_num` =", value, "phone_num");
            return (Criteria) this;
        }

        public Criteria andPhone_numNotEqualTo(String value) {
            addCriterion("`phone_num` <>", value, "phone_num");
            return (Criteria) this;
        }

        public Criteria andPhone_numGreaterThan(String value) {
            addCriterion("`phone_num` >", value, "phone_num");
            return (Criteria) this;
        }

        public Criteria andPhone_numGreaterThanOrEqualTo(String value) {
            addCriterion("`phone_num` >=", value, "phone_num");
            return (Criteria) this;
        }

        public Criteria andPhone_numLessThan(String value) {
            addCriterion("`phone_num` <", value, "phone_num");
            return (Criteria) this;
        }

        public Criteria andPhone_numLessThanOrEqualTo(String value) {
            addCriterion("`phone_num` <=", value, "phone_num");
            return (Criteria) this;
        }

        public Criteria andPhone_numLike(String value) {
            addCriterion("`phone_num` like", value, "phone_num");
            return (Criteria) this;
        }

        public Criteria andPhone_numNotLike(String value) {
            addCriterion("`phone_num` not like", value, "phone_num");
            return (Criteria) this;
        }

        public Criteria andPhone_numIn(List<String> values) {
            addCriterion("`phone_num` in", values, "phone_num");
            return (Criteria) this;
        }

        public Criteria andPhone_numNotIn(List<String> values) {
            addCriterion("`phone_num` not in", values, "phone_num");
            return (Criteria) this;
        }

        public Criteria andPhone_numBetween(String value1, String value2) {
            addCriterion("`phone_num` between", value1, value2, "phone_num");
            return (Criteria) this;
        }

        public Criteria andPhone_numNotBetween(String value1, String value2) {
            addCriterion("`phone_num` not between", value1, value2, "phone_num");
            return (Criteria) this;
        }

        public Criteria andExpect_contact_timeIsNull() {
            addCriterion("`expect_contact_time` is null");
            return (Criteria) this;
        }

        public Criteria andExpect_contact_timeIsNotNull() {
            addCriterion("`expect_contact_time` is not null");
            return (Criteria) this;
        }

        public Criteria andExpect_contact_timeEqualTo(String value) {
            addCriterion("`expect_contact_time` =", value, "expect_contact_time");
            return (Criteria) this;
        }

        public Criteria andExpect_contact_timeNotEqualTo(String value) {
            addCriterion("`expect_contact_time` <>", value, "expect_contact_time");
            return (Criteria) this;
        }

        public Criteria andExpect_contact_timeGreaterThan(String value) {
            addCriterion("`expect_contact_time` >", value, "expect_contact_time");
            return (Criteria) this;
        }

        public Criteria andExpect_contact_timeGreaterThanOrEqualTo(String value) {
            addCriterion("`expect_contact_time` >=", value, "expect_contact_time");
            return (Criteria) this;
        }

        public Criteria andExpect_contact_timeLessThan(String value) {
            addCriterion("`expect_contact_time` <", value, "expect_contact_time");
            return (Criteria) this;
        }

        public Criteria andExpect_contact_timeLessThanOrEqualTo(String value) {
            addCriterion("`expect_contact_time` <=", value, "expect_contact_time");
            return (Criteria) this;
        }

        public Criteria andExpect_contact_timeLike(String value) {
            addCriterion("`expect_contact_time` like", value, "expect_contact_time");
            return (Criteria) this;
        }

        public Criteria andExpect_contact_timeNotLike(String value) {
            addCriterion("`expect_contact_time` not like", value, "expect_contact_time");
            return (Criteria) this;
        }

        public Criteria andExpect_contact_timeIn(List<String> values) {
            addCriterion("`expect_contact_time` in", values, "expect_contact_time");
            return (Criteria) this;
        }

        public Criteria andExpect_contact_timeNotIn(List<String> values) {
            addCriterion("`expect_contact_time` not in", values, "expect_contact_time");
            return (Criteria) this;
        }

        public Criteria andExpect_contact_timeBetween(String value1, String value2) {
            addCriterion("`expect_contact_time` between", value1, value2, "expect_contact_time");
            return (Criteria) this;
        }

        public Criteria andExpect_contact_timeNotBetween(String value1, String value2) {
            addCriterion("`expect_contact_time` not between", value1, value2, "expect_contact_time");
            return (Criteria) this;
        }

        public Criteria andProject_descriptionIsNull() {
            addCriterion("`project_description` is null");
            return (Criteria) this;
        }

        public Criteria andProject_descriptionIsNotNull() {
            addCriterion("`project_description` is not null");
            return (Criteria) this;
        }

        public Criteria andProject_descriptionEqualTo(String value) {
            addCriterion("`project_description` =", value, "project_description");
            return (Criteria) this;
        }

        public Criteria andProject_descriptionNotEqualTo(String value) {
            addCriterion("`project_description` <>", value, "project_description");
            return (Criteria) this;
        }

        public Criteria andProject_descriptionGreaterThan(String value) {
            addCriterion("`project_description` >", value, "project_description");
            return (Criteria) this;
        }

        public Criteria andProject_descriptionGreaterThanOrEqualTo(String value) {
            addCriterion("`project_description` >=", value, "project_description");
            return (Criteria) this;
        }

        public Criteria andProject_descriptionLessThan(String value) {
            addCriterion("`project_description` <", value, "project_description");
            return (Criteria) this;
        }

        public Criteria andProject_descriptionLessThanOrEqualTo(String value) {
            addCriterion("`project_description` <=", value, "project_description");
            return (Criteria) this;
        }

        public Criteria andProject_descriptionLike(String value) {
            addCriterion("`project_description` like", value, "project_description");
            return (Criteria) this;
        }

        public Criteria andProject_descriptionNotLike(String value) {
            addCriterion("`project_description` not like", value, "project_description");
            return (Criteria) this;
        }

        public Criteria andProject_descriptionIn(List<String> values) {
            addCriterion("`project_description` in", values, "project_description");
            return (Criteria) this;
        }

        public Criteria andProject_descriptionNotIn(List<String> values) {
            addCriterion("`project_description` not in", values, "project_description");
            return (Criteria) this;
        }

        public Criteria andProject_descriptionBetween(String value1, String value2) {
            addCriterion("`project_description` between", value1, value2, "project_description");
            return (Criteria) this;
        }

        public Criteria andProject_descriptionNotBetween(String value1, String value2) {
            addCriterion("`project_description` not between", value1, value2, "project_description");
            return (Criteria) this;
        }

        public Criteria andContacter_statusIsNull() {
            addCriterion("`contacter_status` is null");
            return (Criteria) this;
        }

        public Criteria andContacter_statusIsNotNull() {
            addCriterion("`contacter_status` is not null");
            return (Criteria) this;
        }

        public Criteria andContacter_statusEqualTo(String value) {
            addCriterion("`contacter_status` =", value, "contacter_status");
            return (Criteria) this;
        }

        public Criteria andContacter_statusNotEqualTo(String value) {
            addCriterion("`contacter_status` <>", value, "contacter_status");
            return (Criteria) this;
        }

        public Criteria andContacter_statusGreaterThan(String value) {
            addCriterion("`contacter_status` >", value, "contacter_status");
            return (Criteria) this;
        }

        public Criteria andContacter_statusGreaterThanOrEqualTo(String value) {
            addCriterion("`contacter_status` >=", value, "contacter_status");
            return (Criteria) this;
        }

        public Criteria andContacter_statusLessThan(String value) {
            addCriterion("`contacter_status` <", value, "contacter_status");
            return (Criteria) this;
        }

        public Criteria andContacter_statusLessThanOrEqualTo(String value) {
            addCriterion("`contacter_status` <=", value, "contacter_status");
            return (Criteria) this;
        }

        public Criteria andContacter_statusLike(String value) {
            addCriterion("`contacter_status` like", value, "contacter_status");
            return (Criteria) this;
        }

        public Criteria andContacter_statusNotLike(String value) {
            addCriterion("`contacter_status` not like", value, "contacter_status");
            return (Criteria) this;
        }

        public Criteria andContacter_statusIn(List<String> values) {
            addCriterion("`contacter_status` in", values, "contacter_status");
            return (Criteria) this;
        }

        public Criteria andContacter_statusNotIn(List<String> values) {
            addCriterion("`contacter_status` not in", values, "contacter_status");
            return (Criteria) this;
        }

        public Criteria andContacter_statusBetween(String value1, String value2) {
            addCriterion("`contacter_status` between", value1, value2, "contacter_status");
            return (Criteria) this;
        }

        public Criteria andContacter_statusNotBetween(String value1, String value2) {
            addCriterion("`contacter_status` not between", value1, value2, "contacter_status");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("`remark` is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("`remark` is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("`remark` =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("`remark` <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("`remark` >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("`remark` >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("`remark` <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("`remark` <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("`remark` like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("`remark` not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("`remark` in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("`remark` not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("`remark` between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("`remark` not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("`operator` is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("`operator` is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("`operator` =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("`operator` <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("`operator` >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("`operator` >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("`operator` <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("`operator` <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("`operator` like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("`operator` not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("`operator` in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("`operator` not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("`operator` between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("`operator` not between", value1, value2, "operator");
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

        public Criteria andShop_area_sizeIsNull() {
            addCriterion("`shop_area_size` is null");
            return (Criteria) this;
        }

        public Criteria andShop_area_sizeIsNotNull() {
            addCriterion("`shop_area_size` is not null");
            return (Criteria) this;
        }

        public Criteria andShop_area_sizeEqualTo(String value) {
            addCriterion("`shop_area_size` =", value, "shop_area_size");
            return (Criteria) this;
        }

        public Criteria andShop_area_sizeNotEqualTo(String value) {
            addCriterion("`shop_area_size` <>", value, "shop_area_size");
            return (Criteria) this;
        }

        public Criteria andShop_area_sizeGreaterThan(String value) {
            addCriterion("`shop_area_size` >", value, "shop_area_size");
            return (Criteria) this;
        }

        public Criteria andShop_area_sizeGreaterThanOrEqualTo(String value) {
            addCriterion("`shop_area_size` >=", value, "shop_area_size");
            return (Criteria) this;
        }

        public Criteria andShop_area_sizeLessThan(String value) {
            addCriterion("`shop_area_size` <", value, "shop_area_size");
            return (Criteria) this;
        }

        public Criteria andShop_area_sizeLessThanOrEqualTo(String value) {
            addCriterion("`shop_area_size` <=", value, "shop_area_size");
            return (Criteria) this;
        }

        public Criteria andShop_area_sizeLike(String value) {
            addCriterion("`shop_area_size` like", value, "shop_area_size");
            return (Criteria) this;
        }

        public Criteria andShop_area_sizeNotLike(String value) {
            addCriterion("`shop_area_size` not like", value, "shop_area_size");
            return (Criteria) this;
        }

        public Criteria andShop_area_sizeIn(List<String> values) {
            addCriterion("`shop_area_size` in", values, "shop_area_size");
            return (Criteria) this;
        }

        public Criteria andShop_area_sizeNotIn(List<String> values) {
            addCriterion("`shop_area_size` not in", values, "shop_area_size");
            return (Criteria) this;
        }

        public Criteria andShop_area_sizeBetween(String value1, String value2) {
            addCriterion("`shop_area_size` between", value1, value2, "shop_area_size");
            return (Criteria) this;
        }

        public Criteria andShop_area_sizeNotBetween(String value1, String value2) {
            addCriterion("`shop_area_size` not between", value1, value2, "shop_area_size");
            return (Criteria) this;
        }

        public Criteria andShop_addressIsNull() {
            addCriterion("`shop_address` is null");
            return (Criteria) this;
        }

        public Criteria andShop_addressIsNotNull() {
            addCriterion("`shop_address` is not null");
            return (Criteria) this;
        }

        public Criteria andShop_addressEqualTo(String value) {
            addCriterion("`shop_address` =", value, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShop_addressNotEqualTo(String value) {
            addCriterion("`shop_address` <>", value, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShop_addressGreaterThan(String value) {
            addCriterion("`shop_address` >", value, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShop_addressGreaterThanOrEqualTo(String value) {
            addCriterion("`shop_address` >=", value, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShop_addressLessThan(String value) {
            addCriterion("`shop_address` <", value, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShop_addressLessThanOrEqualTo(String value) {
            addCriterion("`shop_address` <=", value, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShop_addressLike(String value) {
            addCriterion("`shop_address` like", value, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShop_addressNotLike(String value) {
            addCriterion("`shop_address` not like", value, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShop_addressIn(List<String> values) {
            addCriterion("`shop_address` in", values, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShop_addressNotIn(List<String> values) {
            addCriterion("`shop_address` not in", values, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShop_addressBetween(String value1, String value2) {
            addCriterion("`shop_address` between", value1, value2, "shop_address");
            return (Criteria) this;
        }

        public Criteria andShop_addressNotBetween(String value1, String value2) {
            addCriterion("`shop_address` not between", value1, value2, "shop_address");
            return (Criteria) this;
        }

        public Criteria andMerchant_typeIsNull() {
            addCriterion("`merchant_type` is null");
            return (Criteria) this;
        }

        public Criteria andMerchant_typeIsNotNull() {
            addCriterion("`merchant_type` is not null");
            return (Criteria) this;
        }

        public Criteria andMerchant_typeEqualTo(String value) {
            addCriterion("`merchant_type` =", value, "merchant_type");
            return (Criteria) this;
        }

        public Criteria andMerchant_typeNotEqualTo(String value) {
            addCriterion("`merchant_type` <>", value, "merchant_type");
            return (Criteria) this;
        }

        public Criteria andMerchant_typeGreaterThan(String value) {
            addCriterion("`merchant_type` >", value, "merchant_type");
            return (Criteria) this;
        }

        public Criteria andMerchant_typeGreaterThanOrEqualTo(String value) {
            addCriterion("`merchant_type` >=", value, "merchant_type");
            return (Criteria) this;
        }

        public Criteria andMerchant_typeLessThan(String value) {
            addCriterion("`merchant_type` <", value, "merchant_type");
            return (Criteria) this;
        }

        public Criteria andMerchant_typeLessThanOrEqualTo(String value) {
            addCriterion("`merchant_type` <=", value, "merchant_type");
            return (Criteria) this;
        }

        public Criteria andMerchant_typeLike(String value) {
            addCriterion("`merchant_type` like", value, "merchant_type");
            return (Criteria) this;
        }

        public Criteria andMerchant_typeNotLike(String value) {
            addCriterion("`merchant_type` not like", value, "merchant_type");
            return (Criteria) this;
        }

        public Criteria andMerchant_typeIn(List<String> values) {
            addCriterion("`merchant_type` in", values, "merchant_type");
            return (Criteria) this;
        }

        public Criteria andMerchant_typeNotIn(List<String> values) {
            addCriterion("`merchant_type` not in", values, "merchant_type");
            return (Criteria) this;
        }

        public Criteria andMerchant_typeBetween(String value1, String value2) {
            addCriterion("`merchant_type` between", value1, value2, "merchant_type");
            return (Criteria) this;
        }

        public Criteria andMerchant_typeNotBetween(String value1, String value2) {
            addCriterion("`merchant_type` not between", value1, value2, "merchant_type");
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
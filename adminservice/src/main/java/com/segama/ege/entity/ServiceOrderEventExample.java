package com.segama.ege.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceOrderEventExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public ServiceOrderEventExample() {
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

        public Criteria andEvent_staff_idIsNull() {
            addCriterion("`event_staff_id` is null");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_idIsNotNull() {
            addCriterion("`event_staff_id` is not null");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_idEqualTo(String value) {
            addCriterion("`event_staff_id` =", value, "event_staff_id");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_idNotEqualTo(String value) {
            addCriterion("`event_staff_id` <>", value, "event_staff_id");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_idGreaterThan(String value) {
            addCriterion("`event_staff_id` >", value, "event_staff_id");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_idGreaterThanOrEqualTo(String value) {
            addCriterion("`event_staff_id` >=", value, "event_staff_id");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_idLessThan(String value) {
            addCriterion("`event_staff_id` <", value, "event_staff_id");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_idLessThanOrEqualTo(String value) {
            addCriterion("`event_staff_id` <=", value, "event_staff_id");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_idLike(String value) {
            addCriterion("`event_staff_id` like", value, "event_staff_id");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_idNotLike(String value) {
            addCriterion("`event_staff_id` not like", value, "event_staff_id");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_idIn(List<String> values) {
            addCriterion("`event_staff_id` in", values, "event_staff_id");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_idNotIn(List<String> values) {
            addCriterion("`event_staff_id` not in", values, "event_staff_id");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_idBetween(String value1, String value2) {
            addCriterion("`event_staff_id` between", value1, value2, "event_staff_id");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_idNotBetween(String value1, String value2) {
            addCriterion("`event_staff_id` not between", value1, value2, "event_staff_id");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_roleIsNull() {
            addCriterion("`event_staff_role` is null");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_roleIsNotNull() {
            addCriterion("`event_staff_role` is not null");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_roleEqualTo(String value) {
            addCriterion("`event_staff_role` =", value, "event_staff_role");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_roleNotEqualTo(String value) {
            addCriterion("`event_staff_role` <>", value, "event_staff_role");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_roleGreaterThan(String value) {
            addCriterion("`event_staff_role` >", value, "event_staff_role");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_roleGreaterThanOrEqualTo(String value) {
            addCriterion("`event_staff_role` >=", value, "event_staff_role");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_roleLessThan(String value) {
            addCriterion("`event_staff_role` <", value, "event_staff_role");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_roleLessThanOrEqualTo(String value) {
            addCriterion("`event_staff_role` <=", value, "event_staff_role");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_roleLike(String value) {
            addCriterion("`event_staff_role` like", value, "event_staff_role");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_roleNotLike(String value) {
            addCriterion("`event_staff_role` not like", value, "event_staff_role");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_roleIn(List<String> values) {
            addCriterion("`event_staff_role` in", values, "event_staff_role");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_roleNotIn(List<String> values) {
            addCriterion("`event_staff_role` not in", values, "event_staff_role");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_roleBetween(String value1, String value2) {
            addCriterion("`event_staff_role` between", value1, value2, "event_staff_role");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_roleNotBetween(String value1, String value2) {
            addCriterion("`event_staff_role` not between", value1, value2, "event_staff_role");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_nameIsNull() {
            addCriterion("`event_staff_name` is null");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_nameIsNotNull() {
            addCriterion("`event_staff_name` is not null");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_nameEqualTo(String value) {
            addCriterion("`event_staff_name` =", value, "event_staff_name");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_nameNotEqualTo(String value) {
            addCriterion("`event_staff_name` <>", value, "event_staff_name");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_nameGreaterThan(String value) {
            addCriterion("`event_staff_name` >", value, "event_staff_name");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`event_staff_name` >=", value, "event_staff_name");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_nameLessThan(String value) {
            addCriterion("`event_staff_name` <", value, "event_staff_name");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_nameLessThanOrEqualTo(String value) {
            addCriterion("`event_staff_name` <=", value, "event_staff_name");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_nameLike(String value) {
            addCriterion("`event_staff_name` like", value, "event_staff_name");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_nameNotLike(String value) {
            addCriterion("`event_staff_name` not like", value, "event_staff_name");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_nameIn(List<String> values) {
            addCriterion("`event_staff_name` in", values, "event_staff_name");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_nameNotIn(List<String> values) {
            addCriterion("`event_staff_name` not in", values, "event_staff_name");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_nameBetween(String value1, String value2) {
            addCriterion("`event_staff_name` between", value1, value2, "event_staff_name");
            return (Criteria) this;
        }

        public Criteria andEvent_staff_nameNotBetween(String value1, String value2) {
            addCriterion("`event_staff_name` not between", value1, value2, "event_staff_name");
            return (Criteria) this;
        }

        public Criteria andEvent_descIsNull() {
            addCriterion("`event_desc` is null");
            return (Criteria) this;
        }

        public Criteria andEvent_descIsNotNull() {
            addCriterion("`event_desc` is not null");
            return (Criteria) this;
        }

        public Criteria andEvent_descEqualTo(String value) {
            addCriterion("`event_desc` =", value, "event_desc");
            return (Criteria) this;
        }

        public Criteria andEvent_descNotEqualTo(String value) {
            addCriterion("`event_desc` <>", value, "event_desc");
            return (Criteria) this;
        }

        public Criteria andEvent_descGreaterThan(String value) {
            addCriterion("`event_desc` >", value, "event_desc");
            return (Criteria) this;
        }

        public Criteria andEvent_descGreaterThanOrEqualTo(String value) {
            addCriterion("`event_desc` >=", value, "event_desc");
            return (Criteria) this;
        }

        public Criteria andEvent_descLessThan(String value) {
            addCriterion("`event_desc` <", value, "event_desc");
            return (Criteria) this;
        }

        public Criteria andEvent_descLessThanOrEqualTo(String value) {
            addCriterion("`event_desc` <=", value, "event_desc");
            return (Criteria) this;
        }

        public Criteria andEvent_descLike(String value) {
            addCriterion("`event_desc` like", value, "event_desc");
            return (Criteria) this;
        }

        public Criteria andEvent_descNotLike(String value) {
            addCriterion("`event_desc` not like", value, "event_desc");
            return (Criteria) this;
        }

        public Criteria andEvent_descIn(List<String> values) {
            addCriterion("`event_desc` in", values, "event_desc");
            return (Criteria) this;
        }

        public Criteria andEvent_descNotIn(List<String> values) {
            addCriterion("`event_desc` not in", values, "event_desc");
            return (Criteria) this;
        }

        public Criteria andEvent_descBetween(String value1, String value2) {
            addCriterion("`event_desc` between", value1, value2, "event_desc");
            return (Criteria) this;
        }

        public Criteria andEvent_descNotBetween(String value1, String value2) {
            addCriterion("`event_desc` not between", value1, value2, "event_desc");
            return (Criteria) this;
        }

        public Criteria andGmt_eventIsNull() {
            addCriterion("`gmt_event` is null");
            return (Criteria) this;
        }

        public Criteria andGmt_eventIsNotNull() {
            addCriterion("`gmt_event` is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_eventEqualTo(Date value) {
            addCriterion("`gmt_event` =", value, "gmt_event");
            return (Criteria) this;
        }

        public Criteria andGmt_eventNotEqualTo(Date value) {
            addCriterion("`gmt_event` <>", value, "gmt_event");
            return (Criteria) this;
        }

        public Criteria andGmt_eventGreaterThan(Date value) {
            addCriterion("`gmt_event` >", value, "gmt_event");
            return (Criteria) this;
        }

        public Criteria andGmt_eventGreaterThanOrEqualTo(Date value) {
            addCriterion("`gmt_event` >=", value, "gmt_event");
            return (Criteria) this;
        }

        public Criteria andGmt_eventLessThan(Date value) {
            addCriterion("`gmt_event` <", value, "gmt_event");
            return (Criteria) this;
        }

        public Criteria andGmt_eventLessThanOrEqualTo(Date value) {
            addCriterion("`gmt_event` <=", value, "gmt_event");
            return (Criteria) this;
        }

        public Criteria andGmt_eventIn(List<Date> values) {
            addCriterion("`gmt_event` in", values, "gmt_event");
            return (Criteria) this;
        }

        public Criteria andGmt_eventNotIn(List<Date> values) {
            addCriterion("`gmt_event` not in", values, "gmt_event");
            return (Criteria) this;
        }

        public Criteria andGmt_eventBetween(Date value1, Date value2) {
            addCriterion("`gmt_event` between", value1, value2, "gmt_event");
            return (Criteria) this;
        }

        public Criteria andGmt_eventNotBetween(Date value1, Date value2) {
            addCriterion("`gmt_event` not between", value1, value2, "gmt_event");
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

        public Criteria andResultIsNull() {
            addCriterion("`result` is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("`result` is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(Boolean value) {
            addCriterion("`result` =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(Boolean value) {
            addCriterion("`result` <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(Boolean value) {
            addCriterion("`result` >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(Boolean value) {
            addCriterion("`result` >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(Boolean value) {
            addCriterion("`result` <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(Boolean value) {
            addCriterion("`result` <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<Boolean> values) {
            addCriterion("`result` in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<Boolean> values) {
            addCriterion("`result` not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(Boolean value1, Boolean value2) {
            addCriterion("`result` between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(Boolean value1, Boolean value2) {
            addCriterion("`result` not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andIs_car_user_operateIsNull() {
            addCriterion("`is_car_user_operate` is null");
            return (Criteria) this;
        }

        public Criteria andIs_car_user_operateIsNotNull() {
            addCriterion("`is_car_user_operate` is not null");
            return (Criteria) this;
        }

        public Criteria andIs_car_user_operateEqualTo(Boolean value) {
            addCriterion("`is_car_user_operate` =", value, "is_car_user_operate");
            return (Criteria) this;
        }

        public Criteria andIs_car_user_operateNotEqualTo(Boolean value) {
            addCriterion("`is_car_user_operate` <>", value, "is_car_user_operate");
            return (Criteria) this;
        }

        public Criteria andIs_car_user_operateGreaterThan(Boolean value) {
            addCriterion("`is_car_user_operate` >", value, "is_car_user_operate");
            return (Criteria) this;
        }

        public Criteria andIs_car_user_operateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("`is_car_user_operate` >=", value, "is_car_user_operate");
            return (Criteria) this;
        }

        public Criteria andIs_car_user_operateLessThan(Boolean value) {
            addCriterion("`is_car_user_operate` <", value, "is_car_user_operate");
            return (Criteria) this;
        }

        public Criteria andIs_car_user_operateLessThanOrEqualTo(Boolean value) {
            addCriterion("`is_car_user_operate` <=", value, "is_car_user_operate");
            return (Criteria) this;
        }

        public Criteria andIs_car_user_operateIn(List<Boolean> values) {
            addCriterion("`is_car_user_operate` in", values, "is_car_user_operate");
            return (Criteria) this;
        }

        public Criteria andIs_car_user_operateNotIn(List<Boolean> values) {
            addCriterion("`is_car_user_operate` not in", values, "is_car_user_operate");
            return (Criteria) this;
        }

        public Criteria andIs_car_user_operateBetween(Boolean value1, Boolean value2) {
            addCriterion("`is_car_user_operate` between", value1, value2, "is_car_user_operate");
            return (Criteria) this;
        }

        public Criteria andIs_car_user_operateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("`is_car_user_operate` not between", value1, value2, "is_car_user_operate");
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
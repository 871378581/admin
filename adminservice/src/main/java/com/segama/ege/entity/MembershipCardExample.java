package com.segama.ege.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MembershipCardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public MembershipCardExample() {
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

        public Criteria andCard_idIsNull() {
            addCriterion("`card_id` is null");
            return (Criteria) this;
        }

        public Criteria andCard_idIsNotNull() {
            addCriterion("`card_id` is not null");
            return (Criteria) this;
        }

        public Criteria andCard_idEqualTo(String value) {
            addCriterion("`card_id` =", value, "card_id");
            return (Criteria) this;
        }

        public Criteria andCard_idNotEqualTo(String value) {
            addCriterion("`card_id` <>", value, "card_id");
            return (Criteria) this;
        }

        public Criteria andCard_idGreaterThan(String value) {
            addCriterion("`card_id` >", value, "card_id");
            return (Criteria) this;
        }

        public Criteria andCard_idGreaterThanOrEqualTo(String value) {
            addCriterion("`card_id` >=", value, "card_id");
            return (Criteria) this;
        }

        public Criteria andCard_idLessThan(String value) {
            addCriterion("`card_id` <", value, "card_id");
            return (Criteria) this;
        }

        public Criteria andCard_idLessThanOrEqualTo(String value) {
            addCriterion("`card_id` <=", value, "card_id");
            return (Criteria) this;
        }

        public Criteria andCard_idLike(String value) {
            addCriterion("`card_id` like", value, "card_id");
            return (Criteria) this;
        }

        public Criteria andCard_idNotLike(String value) {
            addCriterion("`card_id` not like", value, "card_id");
            return (Criteria) this;
        }

        public Criteria andCard_idIn(List<String> values) {
            addCriterion("`card_id` in", values, "card_id");
            return (Criteria) this;
        }

        public Criteria andCard_idNotIn(List<String> values) {
            addCriterion("`card_id` not in", values, "card_id");
            return (Criteria) this;
        }

        public Criteria andCard_idBetween(String value1, String value2) {
            addCriterion("`card_id` between", value1, value2, "card_id");
            return (Criteria) this;
        }

        public Criteria andCard_idNotBetween(String value1, String value2) {
            addCriterion("`card_id` not between", value1, value2, "card_id");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("`password` is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("`password` is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("`password` =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("`password` <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("`password` >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("`password` >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("`password` <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("`password` <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("`password` like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("`password` not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("`password` in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("`password` not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("`password` between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("`password` not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andBatch_numIsNull() {
            addCriterion("`batch_num` is null");
            return (Criteria) this;
        }

        public Criteria andBatch_numIsNotNull() {
            addCriterion("`batch_num` is not null");
            return (Criteria) this;
        }

        public Criteria andBatch_numEqualTo(String value) {
            addCriterion("`batch_num` =", value, "batch_num");
            return (Criteria) this;
        }

        public Criteria andBatch_numNotEqualTo(String value) {
            addCriterion("`batch_num` <>", value, "batch_num");
            return (Criteria) this;
        }

        public Criteria andBatch_numGreaterThan(String value) {
            addCriterion("`batch_num` >", value, "batch_num");
            return (Criteria) this;
        }

        public Criteria andBatch_numGreaterThanOrEqualTo(String value) {
            addCriterion("`batch_num` >=", value, "batch_num");
            return (Criteria) this;
        }

        public Criteria andBatch_numLessThan(String value) {
            addCriterion("`batch_num` <", value, "batch_num");
            return (Criteria) this;
        }

        public Criteria andBatch_numLessThanOrEqualTo(String value) {
            addCriterion("`batch_num` <=", value, "batch_num");
            return (Criteria) this;
        }

        public Criteria andBatch_numLike(String value) {
            addCriterion("`batch_num` like", value, "batch_num");
            return (Criteria) this;
        }

        public Criteria andBatch_numNotLike(String value) {
            addCriterion("`batch_num` not like", value, "batch_num");
            return (Criteria) this;
        }

        public Criteria andBatch_numIn(List<String> values) {
            addCriterion("`batch_num` in", values, "batch_num");
            return (Criteria) this;
        }

        public Criteria andBatch_numNotIn(List<String> values) {
            addCriterion("`batch_num` not in", values, "batch_num");
            return (Criteria) this;
        }

        public Criteria andBatch_numBetween(String value1, String value2) {
            addCriterion("`batch_num` between", value1, value2, "batch_num");
            return (Criteria) this;
        }

        public Criteria andBatch_numNotBetween(String value1, String value2) {
            addCriterion("`batch_num` not between", value1, value2, "batch_num");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("`status` like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("`status` not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andEffective_daysIsNull() {
            addCriterion("`effective_days` is null");
            return (Criteria) this;
        }

        public Criteria andEffective_daysIsNotNull() {
            addCriterion("`effective_days` is not null");
            return (Criteria) this;
        }

        public Criteria andEffective_daysEqualTo(Integer value) {
            addCriterion("`effective_days` =", value, "effective_days");
            return (Criteria) this;
        }

        public Criteria andEffective_daysNotEqualTo(Integer value) {
            addCriterion("`effective_days` <>", value, "effective_days");
            return (Criteria) this;
        }

        public Criteria andEffective_daysGreaterThan(Integer value) {
            addCriterion("`effective_days` >", value, "effective_days");
            return (Criteria) this;
        }

        public Criteria andEffective_daysGreaterThanOrEqualTo(Integer value) {
            addCriterion("`effective_days` >=", value, "effective_days");
            return (Criteria) this;
        }

        public Criteria andEffective_daysLessThan(Integer value) {
            addCriterion("`effective_days` <", value, "effective_days");
            return (Criteria) this;
        }

        public Criteria andEffective_daysLessThanOrEqualTo(Integer value) {
            addCriterion("`effective_days` <=", value, "effective_days");
            return (Criteria) this;
        }

        public Criteria andEffective_daysIn(List<Integer> values) {
            addCriterion("`effective_days` in", values, "effective_days");
            return (Criteria) this;
        }

        public Criteria andEffective_daysNotIn(List<Integer> values) {
            addCriterion("`effective_days` not in", values, "effective_days");
            return (Criteria) this;
        }

        public Criteria andEffective_daysBetween(Integer value1, Integer value2) {
            addCriterion("`effective_days` between", value1, value2, "effective_days");
            return (Criteria) this;
        }

        public Criteria andEffective_daysNotBetween(Integer value1, Integer value2) {
            addCriterion("`effective_days` not between", value1, value2, "effective_days");
            return (Criteria) this;
        }

        public Criteria andEffective_dateIsNull() {
            addCriterion("`effective_date` is null");
            return (Criteria) this;
        }

        public Criteria andEffective_dateIsNotNull() {
            addCriterion("`effective_date` is not null");
            return (Criteria) this;
        }

        public Criteria andEffective_dateEqualTo(Date value) {
            addCriterion("`effective_date` =", value, "effective_date");
            return (Criteria) this;
        }

        public Criteria andEffective_dateNotEqualTo(Date value) {
            addCriterion("`effective_date` <>", value, "effective_date");
            return (Criteria) this;
        }

        public Criteria andEffective_dateGreaterThan(Date value) {
            addCriterion("`effective_date` >", value, "effective_date");
            return (Criteria) this;
        }

        public Criteria andEffective_dateGreaterThanOrEqualTo(Date value) {
            addCriterion("`effective_date` >=", value, "effective_date");
            return (Criteria) this;
        }

        public Criteria andEffective_dateLessThan(Date value) {
            addCriterion("`effective_date` <", value, "effective_date");
            return (Criteria) this;
        }

        public Criteria andEffective_dateLessThanOrEqualTo(Date value) {
            addCriterion("`effective_date` <=", value, "effective_date");
            return (Criteria) this;
        }

        public Criteria andEffective_dateIn(List<Date> values) {
            addCriterion("`effective_date` in", values, "effective_date");
            return (Criteria) this;
        }

        public Criteria andEffective_dateNotIn(List<Date> values) {
            addCriterion("`effective_date` not in", values, "effective_date");
            return (Criteria) this;
        }

        public Criteria andEffective_dateBetween(Date value1, Date value2) {
            addCriterion("`effective_date` between", value1, value2, "effective_date");
            return (Criteria) this;
        }

        public Criteria andEffective_dateNotBetween(Date value1, Date value2) {
            addCriterion("`effective_date` not between", value1, value2, "effective_date");
            return (Criteria) this;
        }

        public Criteria andExpire_dateIsNull() {
            addCriterion("`expire_date` is null");
            return (Criteria) this;
        }

        public Criteria andExpire_dateIsNotNull() {
            addCriterion("`expire_date` is not null");
            return (Criteria) this;
        }

        public Criteria andExpire_dateEqualTo(Date value) {
            addCriterion("`expire_date` =", value, "expire_date");
            return (Criteria) this;
        }

        public Criteria andExpire_dateNotEqualTo(Date value) {
            addCriterion("`expire_date` <>", value, "expire_date");
            return (Criteria) this;
        }

        public Criteria andExpire_dateGreaterThan(Date value) {
            addCriterion("`expire_date` >", value, "expire_date");
            return (Criteria) this;
        }

        public Criteria andExpire_dateGreaterThanOrEqualTo(Date value) {
            addCriterion("`expire_date` >=", value, "expire_date");
            return (Criteria) this;
        }

        public Criteria andExpire_dateLessThan(Date value) {
            addCriterion("`expire_date` <", value, "expire_date");
            return (Criteria) this;
        }

        public Criteria andExpire_dateLessThanOrEqualTo(Date value) {
            addCriterion("`expire_date` <=", value, "expire_date");
            return (Criteria) this;
        }

        public Criteria andExpire_dateIn(List<Date> values) {
            addCriterion("`expire_date` in", values, "expire_date");
            return (Criteria) this;
        }

        public Criteria andExpire_dateNotIn(List<Date> values) {
            addCriterion("`expire_date` not in", values, "expire_date");
            return (Criteria) this;
        }

        public Criteria andExpire_dateBetween(Date value1, Date value2) {
            addCriterion("`expire_date` between", value1, value2, "expire_date");
            return (Criteria) this;
        }

        public Criteria andExpire_dateNotBetween(Date value1, Date value2) {
            addCriterion("`expire_date` not between", value1, value2, "expire_date");
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

        public Criteria andTake_effect_typeIsNull() {
            addCriterion("`take_effect_type` is null");
            return (Criteria) this;
        }

        public Criteria andTake_effect_typeIsNotNull() {
            addCriterion("`take_effect_type` is not null");
            return (Criteria) this;
        }

        public Criteria andTake_effect_typeEqualTo(String value) {
            addCriterion("`take_effect_type` =", value, "take_effect_type");
            return (Criteria) this;
        }

        public Criteria andTake_effect_typeNotEqualTo(String value) {
            addCriterion("`take_effect_type` <>", value, "take_effect_type");
            return (Criteria) this;
        }

        public Criteria andTake_effect_typeGreaterThan(String value) {
            addCriterion("`take_effect_type` >", value, "take_effect_type");
            return (Criteria) this;
        }

        public Criteria andTake_effect_typeGreaterThanOrEqualTo(String value) {
            addCriterion("`take_effect_type` >=", value, "take_effect_type");
            return (Criteria) this;
        }

        public Criteria andTake_effect_typeLessThan(String value) {
            addCriterion("`take_effect_type` <", value, "take_effect_type");
            return (Criteria) this;
        }

        public Criteria andTake_effect_typeLessThanOrEqualTo(String value) {
            addCriterion("`take_effect_type` <=", value, "take_effect_type");
            return (Criteria) this;
        }

        public Criteria andTake_effect_typeLike(String value) {
            addCriterion("`take_effect_type` like", value, "take_effect_type");
            return (Criteria) this;
        }

        public Criteria andTake_effect_typeNotLike(String value) {
            addCriterion("`take_effect_type` not like", value, "take_effect_type");
            return (Criteria) this;
        }

        public Criteria andTake_effect_typeIn(List<String> values) {
            addCriterion("`take_effect_type` in", values, "take_effect_type");
            return (Criteria) this;
        }

        public Criteria andTake_effect_typeNotIn(List<String> values) {
            addCriterion("`take_effect_type` not in", values, "take_effect_type");
            return (Criteria) this;
        }

        public Criteria andTake_effect_typeBetween(String value1, String value2) {
            addCriterion("`take_effect_type` between", value1, value2, "take_effect_type");
            return (Criteria) this;
        }

        public Criteria andTake_effect_typeNotBetween(String value1, String value2) {
            addCriterion("`take_effect_type` not between", value1, value2, "take_effect_type");
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
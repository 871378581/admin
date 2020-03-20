package com.segama.ege.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopEvaluateDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageIndex;

    protected Integer pageCount;

    public ShopEvaluateDetailExample() {
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

        public Criteria andNick_nameIsNull() {
            addCriterion("`nick_name` is null");
            return (Criteria) this;
        }

        public Criteria andNick_nameIsNotNull() {
            addCriterion("`nick_name` is not null");
            return (Criteria) this;
        }

        public Criteria andNick_nameEqualTo(String value) {
            addCriterion("`nick_name` =", value, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameNotEqualTo(String value) {
            addCriterion("`nick_name` <>", value, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameGreaterThan(String value) {
            addCriterion("`nick_name` >", value, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameGreaterThanOrEqualTo(String value) {
            addCriterion("`nick_name` >=", value, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameLessThan(String value) {
            addCriterion("`nick_name` <", value, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameLessThanOrEqualTo(String value) {
            addCriterion("`nick_name` <=", value, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameLike(String value) {
            addCriterion("`nick_name` like", value, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameNotLike(String value) {
            addCriterion("`nick_name` not like", value, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameIn(List<String> values) {
            addCriterion("`nick_name` in", values, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameNotIn(List<String> values) {
            addCriterion("`nick_name` not in", values, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameBetween(String value1, String value2) {
            addCriterion("`nick_name` between", value1, value2, "nick_name");
            return (Criteria) this;
        }

        public Criteria andNick_nameNotBetween(String value1, String value2) {
            addCriterion("`nick_name` not between", value1, value2, "nick_name");
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

        public Criteria andGmt_repairIsNull() {
            addCriterion("`gmt_repair` is null");
            return (Criteria) this;
        }

        public Criteria andGmt_repairIsNotNull() {
            addCriterion("`gmt_repair` is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_repairEqualTo(Date value) {
            addCriterion("`gmt_repair` =", value, "gmt_repair");
            return (Criteria) this;
        }

        public Criteria andGmt_repairNotEqualTo(Date value) {
            addCriterion("`gmt_repair` <>", value, "gmt_repair");
            return (Criteria) this;
        }

        public Criteria andGmt_repairGreaterThan(Date value) {
            addCriterion("`gmt_repair` >", value, "gmt_repair");
            return (Criteria) this;
        }

        public Criteria andGmt_repairGreaterThanOrEqualTo(Date value) {
            addCriterion("`gmt_repair` >=", value, "gmt_repair");
            return (Criteria) this;
        }

        public Criteria andGmt_repairLessThan(Date value) {
            addCriterion("`gmt_repair` <", value, "gmt_repair");
            return (Criteria) this;
        }

        public Criteria andGmt_repairLessThanOrEqualTo(Date value) {
            addCriterion("`gmt_repair` <=", value, "gmt_repair");
            return (Criteria) this;
        }

        public Criteria andGmt_repairIn(List<Date> values) {
            addCriterion("`gmt_repair` in", values, "gmt_repair");
            return (Criteria) this;
        }

        public Criteria andGmt_repairNotIn(List<Date> values) {
            addCriterion("`gmt_repair` not in", values, "gmt_repair");
            return (Criteria) this;
        }

        public Criteria andGmt_repairBetween(Date value1, Date value2) {
            addCriterion("`gmt_repair` between", value1, value2, "gmt_repair");
            return (Criteria) this;
        }

        public Criteria andGmt_repairNotBetween(Date value1, Date value2) {
            addCriterion("`gmt_repair` not between", value1, value2, "gmt_repair");
            return (Criteria) this;
        }

        public Criteria andEvaluate_scoreIsNull() {
            addCriterion("`evaluate_score` is null");
            return (Criteria) this;
        }

        public Criteria andEvaluate_scoreIsNotNull() {
            addCriterion("`evaluate_score` is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluate_scoreEqualTo(String value) {
            addCriterion("`evaluate_score` =", value, "evaluate_score");
            return (Criteria) this;
        }

        public Criteria andEvaluate_scoreNotEqualTo(String value) {
            addCriterion("`evaluate_score` <>", value, "evaluate_score");
            return (Criteria) this;
        }

        public Criteria andEvaluate_scoreGreaterThan(String value) {
            addCriterion("`evaluate_score` >", value, "evaluate_score");
            return (Criteria) this;
        }

        public Criteria andEvaluate_scoreGreaterThanOrEqualTo(String value) {
            addCriterion("`evaluate_score` >=", value, "evaluate_score");
            return (Criteria) this;
        }

        public Criteria andEvaluate_scoreLessThan(String value) {
            addCriterion("`evaluate_score` <", value, "evaluate_score");
            return (Criteria) this;
        }

        public Criteria andEvaluate_scoreLessThanOrEqualTo(String value) {
            addCriterion("`evaluate_score` <=", value, "evaluate_score");
            return (Criteria) this;
        }

        public Criteria andEvaluate_scoreLike(String value) {
            addCriterion("`evaluate_score` like", value, "evaluate_score");
            return (Criteria) this;
        }

        public Criteria andEvaluate_scoreNotLike(String value) {
            addCriterion("`evaluate_score` not like", value, "evaluate_score");
            return (Criteria) this;
        }

        public Criteria andEvaluate_scoreIn(List<String> values) {
            addCriterion("`evaluate_score` in", values, "evaluate_score");
            return (Criteria) this;
        }

        public Criteria andEvaluate_scoreNotIn(List<String> values) {
            addCriterion("`evaluate_score` not in", values, "evaluate_score");
            return (Criteria) this;
        }

        public Criteria andEvaluate_scoreBetween(String value1, String value2) {
            addCriterion("`evaluate_score` between", value1, value2, "evaluate_score");
            return (Criteria) this;
        }

        public Criteria andEvaluate_scoreNotBetween(String value1, String value2) {
            addCriterion("`evaluate_score` not between", value1, value2, "evaluate_score");
            return (Criteria) this;
        }

        public Criteria andEvaluate_contentIsNull() {
            addCriterion("`evaluate_content` is null");
            return (Criteria) this;
        }

        public Criteria andEvaluate_contentIsNotNull() {
            addCriterion("`evaluate_content` is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluate_contentEqualTo(String value) {
            addCriterion("`evaluate_content` =", value, "evaluate_content");
            return (Criteria) this;
        }

        public Criteria andEvaluate_contentNotEqualTo(String value) {
            addCriterion("`evaluate_content` <>", value, "evaluate_content");
            return (Criteria) this;
        }

        public Criteria andEvaluate_contentGreaterThan(String value) {
            addCriterion("`evaluate_content` >", value, "evaluate_content");
            return (Criteria) this;
        }

        public Criteria andEvaluate_contentGreaterThanOrEqualTo(String value) {
            addCriterion("`evaluate_content` >=", value, "evaluate_content");
            return (Criteria) this;
        }

        public Criteria andEvaluate_contentLessThan(String value) {
            addCriterion("`evaluate_content` <", value, "evaluate_content");
            return (Criteria) this;
        }

        public Criteria andEvaluate_contentLessThanOrEqualTo(String value) {
            addCriterion("`evaluate_content` <=", value, "evaluate_content");
            return (Criteria) this;
        }

        public Criteria andEvaluate_contentLike(String value) {
            addCriterion("`evaluate_content` like", value, "evaluate_content");
            return (Criteria) this;
        }

        public Criteria andEvaluate_contentNotLike(String value) {
            addCriterion("`evaluate_content` not like", value, "evaluate_content");
            return (Criteria) this;
        }

        public Criteria andEvaluate_contentIn(List<String> values) {
            addCriterion("`evaluate_content` in", values, "evaluate_content");
            return (Criteria) this;
        }

        public Criteria andEvaluate_contentNotIn(List<String> values) {
            addCriterion("`evaluate_content` not in", values, "evaluate_content");
            return (Criteria) this;
        }

        public Criteria andEvaluate_contentBetween(String value1, String value2) {
            addCriterion("`evaluate_content` between", value1, value2, "evaluate_content");
            return (Criteria) this;
        }

        public Criteria andEvaluate_contentNotBetween(String value1, String value2) {
            addCriterion("`evaluate_content` not between", value1, value2, "evaluate_content");
            return (Criteria) this;
        }

        public Criteria andGmt_evaluate_commitIsNull() {
            addCriterion("`gmt_evaluate_commit` is null");
            return (Criteria) this;
        }

        public Criteria andGmt_evaluate_commitIsNotNull() {
            addCriterion("`gmt_evaluate_commit` is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_evaluate_commitEqualTo(Date value) {
            addCriterion("`gmt_evaluate_commit` =", value, "gmt_evaluate_commit");
            return (Criteria) this;
        }

        public Criteria andGmt_evaluate_commitNotEqualTo(Date value) {
            addCriterion("`gmt_evaluate_commit` <>", value, "gmt_evaluate_commit");
            return (Criteria) this;
        }

        public Criteria andGmt_evaluate_commitGreaterThan(Date value) {
            addCriterion("`gmt_evaluate_commit` >", value, "gmt_evaluate_commit");
            return (Criteria) this;
        }

        public Criteria andGmt_evaluate_commitGreaterThanOrEqualTo(Date value) {
            addCriterion("`gmt_evaluate_commit` >=", value, "gmt_evaluate_commit");
            return (Criteria) this;
        }

        public Criteria andGmt_evaluate_commitLessThan(Date value) {
            addCriterion("`gmt_evaluate_commit` <", value, "gmt_evaluate_commit");
            return (Criteria) this;
        }

        public Criteria andGmt_evaluate_commitLessThanOrEqualTo(Date value) {
            addCriterion("`gmt_evaluate_commit` <=", value, "gmt_evaluate_commit");
            return (Criteria) this;
        }

        public Criteria andGmt_evaluate_commitIn(List<Date> values) {
            addCriterion("`gmt_evaluate_commit` in", values, "gmt_evaluate_commit");
            return (Criteria) this;
        }

        public Criteria andGmt_evaluate_commitNotIn(List<Date> values) {
            addCriterion("`gmt_evaluate_commit` not in", values, "gmt_evaluate_commit");
            return (Criteria) this;
        }

        public Criteria andGmt_evaluate_commitBetween(Date value1, Date value2) {
            addCriterion("`gmt_evaluate_commit` between", value1, value2, "gmt_evaluate_commit");
            return (Criteria) this;
        }

        public Criteria andGmt_evaluate_commitNotBetween(Date value1, Date value2) {
            addCriterion("`gmt_evaluate_commit` not between", value1, value2, "gmt_evaluate_commit");
            return (Criteria) this;
        }

        public Criteria andIs_invalidIsNull() {
            addCriterion("`is_invalid` is null");
            return (Criteria) this;
        }

        public Criteria andIs_invalidIsNotNull() {
            addCriterion("`is_invalid` is not null");
            return (Criteria) this;
        }

        public Criteria andIs_invalidEqualTo(Boolean value) {
            addCriterion("`is_invalid` =", value, "is_invalid");
            return (Criteria) this;
        }

        public Criteria andIs_invalidNotEqualTo(Boolean value) {
            addCriterion("`is_invalid` <>", value, "is_invalid");
            return (Criteria) this;
        }

        public Criteria andIs_invalidGreaterThan(Boolean value) {
            addCriterion("`is_invalid` >", value, "is_invalid");
            return (Criteria) this;
        }

        public Criteria andIs_invalidGreaterThanOrEqualTo(Boolean value) {
            addCriterion("`is_invalid` >=", value, "is_invalid");
            return (Criteria) this;
        }

        public Criteria andIs_invalidLessThan(Boolean value) {
            addCriterion("`is_invalid` <", value, "is_invalid");
            return (Criteria) this;
        }

        public Criteria andIs_invalidLessThanOrEqualTo(Boolean value) {
            addCriterion("`is_invalid` <=", value, "is_invalid");
            return (Criteria) this;
        }

        public Criteria andIs_invalidIn(List<Boolean> values) {
            addCriterion("`is_invalid` in", values, "is_invalid");
            return (Criteria) this;
        }

        public Criteria andIs_invalidNotIn(List<Boolean> values) {
            addCriterion("`is_invalid` not in", values, "is_invalid");
            return (Criteria) this;
        }

        public Criteria andIs_invalidBetween(Boolean value1, Boolean value2) {
            addCriterion("`is_invalid` between", value1, value2, "is_invalid");
            return (Criteria) this;
        }

        public Criteria andIs_invalidNotBetween(Boolean value1, Boolean value2) {
            addCriterion("`is_invalid` not between", value1, value2, "is_invalid");
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

        public Criteria andUser_headIsNull() {
            addCriterion("`user_head` is null");
            return (Criteria) this;
        }

        public Criteria andUser_headIsNotNull() {
            addCriterion("`user_head` is not null");
            return (Criteria) this;
        }

        public Criteria andUser_headEqualTo(String value) {
            addCriterion("`user_head` =", value, "user_head");
            return (Criteria) this;
        }

        public Criteria andUser_headNotEqualTo(String value) {
            addCriterion("`user_head` <>", value, "user_head");
            return (Criteria) this;
        }

        public Criteria andUser_headGreaterThan(String value) {
            addCriterion("`user_head` >", value, "user_head");
            return (Criteria) this;
        }

        public Criteria andUser_headGreaterThanOrEqualTo(String value) {
            addCriterion("`user_head` >=", value, "user_head");
            return (Criteria) this;
        }

        public Criteria andUser_headLessThan(String value) {
            addCriterion("`user_head` <", value, "user_head");
            return (Criteria) this;
        }

        public Criteria andUser_headLessThanOrEqualTo(String value) {
            addCriterion("`user_head` <=", value, "user_head");
            return (Criteria) this;
        }

        public Criteria andUser_headLike(String value) {
            addCriterion("`user_head` like", value, "user_head");
            return (Criteria) this;
        }

        public Criteria andUser_headNotLike(String value) {
            addCriterion("`user_head` not like", value, "user_head");
            return (Criteria) this;
        }

        public Criteria andUser_headIn(List<String> values) {
            addCriterion("`user_head` in", values, "user_head");
            return (Criteria) this;
        }

        public Criteria andUser_headNotIn(List<String> values) {
            addCriterion("`user_head` not in", values, "user_head");
            return (Criteria) this;
        }

        public Criteria andUser_headBetween(String value1, String value2) {
            addCriterion("`user_head` between", value1, value2, "user_head");
            return (Criteria) this;
        }

        public Criteria andUser_headNotBetween(String value1, String value2) {
            addCriterion("`user_head` not between", value1, value2, "user_head");
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
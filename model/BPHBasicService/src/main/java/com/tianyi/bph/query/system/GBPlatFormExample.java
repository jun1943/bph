package com.tianyi.bph.query.system;

import java.util.ArrayList;
import java.util.List;

public class GBPlatFormExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GBPlatFormExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCmsIdIsNull() {
            addCriterion("cms_id is null");
            return (Criteria) this;
        }

        public Criteria andCmsIdIsNotNull() {
            addCriterion("cms_id is not null");
            return (Criteria) this;
        }

        public Criteria andCmsIdEqualTo(String value) {
            addCriterion("cms_id =", value, "cmsId");
            return (Criteria) this;
        }

        public Criteria andCmsIdNotEqualTo(String value) {
            addCriterion("cms_id <>", value, "cmsId");
            return (Criteria) this;
        }

        public Criteria andCmsIdGreaterThan(String value) {
            addCriterion("cms_id >", value, "cmsId");
            return (Criteria) this;
        }

        public Criteria andCmsIdGreaterThanOrEqualTo(String value) {
            addCriterion("cms_id >=", value, "cmsId");
            return (Criteria) this;
        }

        public Criteria andCmsIdLessThan(String value) {
            addCriterion("cms_id <", value, "cmsId");
            return (Criteria) this;
        }

        public Criteria andCmsIdLessThanOrEqualTo(String value) {
            addCriterion("cms_id <=", value, "cmsId");
            return (Criteria) this;
        }

        public Criteria andCmsIdLike(String value) {
            addCriterion("cms_id like", value, "cmsId");
            return (Criteria) this;
        }

        public Criteria andCmsIdNotLike(String value) {
            addCriterion("cms_id not like", value, "cmsId");
            return (Criteria) this;
        }

        public Criteria andCmsIdIn(List<String> values) {
            addCriterion("cms_id in", values, "cmsId");
            return (Criteria) this;
        }

        public Criteria andCmsIdNotIn(List<String> values) {
            addCriterion("cms_id not in", values, "cmsId");
            return (Criteria) this;
        }

        public Criteria andCmsIdBetween(String value1, String value2) {
            addCriterion("cms_id between", value1, value2, "cmsId");
            return (Criteria) this;
        }

        public Criteria andCmsIdNotBetween(String value1, String value2) {
            addCriterion("cms_id not between", value1, value2, "cmsId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andSipServerIsNull() {
            addCriterion("sip_server is null");
            return (Criteria) this;
        }

        public Criteria andSipServerIsNotNull() {
            addCriterion("sip_server is not null");
            return (Criteria) this;
        }

        public Criteria andSipServerEqualTo(String value) {
            addCriterion("sip_server =", value, "sipServer");
            return (Criteria) this;
        }

        public Criteria andSipServerNotEqualTo(String value) {
            addCriterion("sip_server <>", value, "sipServer");
            return (Criteria) this;
        }

        public Criteria andSipServerGreaterThan(String value) {
            addCriterion("sip_server >", value, "sipServer");
            return (Criteria) this;
        }

        public Criteria andSipServerGreaterThanOrEqualTo(String value) {
            addCriterion("sip_server >=", value, "sipServer");
            return (Criteria) this;
        }

        public Criteria andSipServerLessThan(String value) {
            addCriterion("sip_server <", value, "sipServer");
            return (Criteria) this;
        }

        public Criteria andSipServerLessThanOrEqualTo(String value) {
            addCriterion("sip_server <=", value, "sipServer");
            return (Criteria) this;
        }

        public Criteria andSipServerLike(String value) {
            addCriterion("sip_server like", value, "sipServer");
            return (Criteria) this;
        }

        public Criteria andSipServerNotLike(String value) {
            addCriterion("sip_server not like", value, "sipServer");
            return (Criteria) this;
        }

        public Criteria andSipServerIn(List<String> values) {
            addCriterion("sip_server in", values, "sipServer");
            return (Criteria) this;
        }

        public Criteria andSipServerNotIn(List<String> values) {
            addCriterion("sip_server not in", values, "sipServer");
            return (Criteria) this;
        }

        public Criteria andSipServerBetween(String value1, String value2) {
            addCriterion("sip_server between", value1, value2, "sipServer");
            return (Criteria) this;
        }

        public Criteria andSipServerNotBetween(String value1, String value2) {
            addCriterion("sip_server not between", value1, value2, "sipServer");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNull() {
            addCriterion("manufacturer is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNotNull() {
            addCriterion("manufacturer is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerEqualTo(String value) {
            addCriterion("manufacturer =", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotEqualTo(String value) {
            addCriterion("manufacturer <>", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThan(String value) {
            addCriterion("manufacturer >", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThanOrEqualTo(String value) {
            addCriterion("manufacturer >=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThan(String value) {
            addCriterion("manufacturer <", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThanOrEqualTo(String value) {
            addCriterion("manufacturer <=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLike(String value) {
            addCriterion("manufacturer like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotLike(String value) {
            addCriterion("manufacturer not like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerIn(List<String> values) {
            addCriterion("manufacturer in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotIn(List<String> values) {
            addCriterion("manufacturer not in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerBetween(String value1, String value2) {
            addCriterion("manufacturer between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotBetween(String value1, String value2) {
            addCriterion("manufacturer not between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andContainIsNull() {
            addCriterion("contain is null");
            return (Criteria) this;
        }

        public Criteria andContainIsNotNull() {
            addCriterion("contain is not null");
            return (Criteria) this;
        }

        public Criteria andContainEqualTo(Boolean value) {
            addCriterion("contain =", value, "contain");
            return (Criteria) this;
        }

        public Criteria andContainNotEqualTo(Boolean value) {
            addCriterion("contain <>", value, "contain");
            return (Criteria) this;
        }

        public Criteria andContainGreaterThan(Boolean value) {
            addCriterion("contain >", value, "contain");
            return (Criteria) this;
        }

        public Criteria andContainGreaterThanOrEqualTo(Boolean value) {
            addCriterion("contain >=", value, "contain");
            return (Criteria) this;
        }

        public Criteria andContainLessThan(Boolean value) {
            addCriterion("contain <", value, "contain");
            return (Criteria) this;
        }

        public Criteria andContainLessThanOrEqualTo(Boolean value) {
            addCriterion("contain <=", value, "contain");
            return (Criteria) this;
        }

        public Criteria andContainIn(List<Boolean> values) {
            addCriterion("contain in", values, "contain");
            return (Criteria) this;
        }

        public Criteria andContainNotIn(List<Boolean> values) {
            addCriterion("contain not in", values, "contain");
            return (Criteria) this;
        }

        public Criteria andContainBetween(Boolean value1, Boolean value2) {
            addCriterion("contain between", value1, value2, "contain");
            return (Criteria) this;
        }

        public Criteria andContainNotBetween(Boolean value1, Boolean value2) {
            addCriterion("contain not between", value1, value2, "contain");
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
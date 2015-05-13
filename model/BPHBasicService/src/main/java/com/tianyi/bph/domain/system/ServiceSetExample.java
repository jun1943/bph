package com.tianyi.bph.domain.system;

import java.util.ArrayList;
import java.util.List;

public class ServiceSetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServiceSetExample() {
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

        public Criteria andServiceIdIsNull() {
            addCriterion("SERVICE_ID is null");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNotNull() {
            addCriterion("SERVICE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andServiceIdEqualTo(Integer value) {
            addCriterion("SERVICE_ID =", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotEqualTo(Integer value) {
            addCriterion("SERVICE_ID <>", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThan(Integer value) {
            addCriterion("SERVICE_ID >", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SERVICE_ID >=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThan(Integer value) {
            addCriterion("SERVICE_ID <", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThanOrEqualTo(Integer value) {
            addCriterion("SERVICE_ID <=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdIn(List<Integer> values) {
            addCriterion("SERVICE_ID in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotIn(List<Integer> values) {
            addCriterion("SERVICE_ID not in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdBetween(Integer value1, Integer value2) {
            addCriterion("SERVICE_ID between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SERVICE_ID not between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceNameIsNull() {
            addCriterion("SERVICE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andServiceNameIsNotNull() {
            addCriterion("SERVICE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andServiceNameEqualTo(String value) {
            addCriterion("SERVICE_NAME =", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotEqualTo(String value) {
            addCriterion("SERVICE_NAME <>", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThan(String value) {
            addCriterion("SERVICE_NAME >", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_NAME >=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThan(String value) {
            addCriterion("SERVICE_NAME <", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThanOrEqualTo(String value) {
            addCriterion("SERVICE_NAME <=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLike(String value) {
            addCriterion("SERVICE_NAME like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotLike(String value) {
            addCriterion("SERVICE_NAME not like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameIn(List<String> values) {
            addCriterion("SERVICE_NAME in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotIn(List<String> values) {
            addCriterion("SERVICE_NAME not in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameBetween(String value1, String value2) {
            addCriterion("SERVICE_NAME between", value1, value2, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotBetween(String value1, String value2) {
            addCriterion("SERVICE_NAME not between", value1, value2, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNull() {
            addCriterion("SERVICE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNotNull() {
            addCriterion("SERVICE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeEqualTo(Integer value) {
            addCriterion("SERVICE_TYPE =", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotEqualTo(Integer value) {
            addCriterion("SERVICE_TYPE <>", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThan(Integer value) {
            addCriterion("SERVICE_TYPE >", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("SERVICE_TYPE >=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThan(Integer value) {
            addCriterion("SERVICE_TYPE <", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("SERVICE_TYPE <=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIn(List<Integer> values) {
            addCriterion("SERVICE_TYPE in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotIn(List<Integer> values) {
            addCriterion("SERVICE_TYPE not in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeBetween(Integer value1, Integer value2) {
            addCriterion("SERVICE_TYPE between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("SERVICE_TYPE not between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceIpIsNull() {
            addCriterion("SERVICE_IP is null");
            return (Criteria) this;
        }

        public Criteria andServiceIpIsNotNull() {
            addCriterion("SERVICE_IP is not null");
            return (Criteria) this;
        }

        public Criteria andServiceIpEqualTo(String value) {
            addCriterion("SERVICE_IP =", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpNotEqualTo(String value) {
            addCriterion("SERVICE_IP <>", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpGreaterThan(String value) {
            addCriterion("SERVICE_IP >", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_IP >=", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpLessThan(String value) {
            addCriterion("SERVICE_IP <", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpLessThanOrEqualTo(String value) {
            addCriterion("SERVICE_IP <=", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpLike(String value) {
            addCriterion("SERVICE_IP like", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpNotLike(String value) {
            addCriterion("SERVICE_IP not like", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpIn(List<String> values) {
            addCriterion("SERVICE_IP in", values, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpNotIn(List<String> values) {
            addCriterion("SERVICE_IP not in", values, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpBetween(String value1, String value2) {
            addCriterion("SERVICE_IP between", value1, value2, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpNotBetween(String value1, String value2) {
            addCriterion("SERVICE_IP not between", value1, value2, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServicePortIsNull() {
            addCriterion("SERVICE_PORT is null");
            return (Criteria) this;
        }

        public Criteria andServicePortIsNotNull() {
            addCriterion("SERVICE_PORT is not null");
            return (Criteria) this;
        }

        public Criteria andServicePortEqualTo(Integer value) {
            addCriterion("SERVICE_PORT =", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortNotEqualTo(Integer value) {
            addCriterion("SERVICE_PORT <>", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortGreaterThan(Integer value) {
            addCriterion("SERVICE_PORT >", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortGreaterThanOrEqualTo(Integer value) {
            addCriterion("SERVICE_PORT >=", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortLessThan(Integer value) {
            addCriterion("SERVICE_PORT <", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortLessThanOrEqualTo(Integer value) {
            addCriterion("SERVICE_PORT <=", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortIn(List<Integer> values) {
            addCriterion("SERVICE_PORT in", values, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortNotIn(List<Integer> values) {
            addCriterion("SERVICE_PORT not in", values, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortBetween(Integer value1, Integer value2) {
            addCriterion("SERVICE_PORT between", value1, value2, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortNotBetween(Integer value1, Integer value2) {
            addCriterion("SERVICE_PORT not between", value1, value2, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServiceAccountIsNull() {
            addCriterion("SERVICE_ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andServiceAccountIsNotNull() {
            addCriterion("SERVICE_ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andServiceAccountEqualTo(String value) {
            addCriterion("SERVICE_ACCOUNT =", value, "serviceAccount");
            return (Criteria) this;
        }

        public Criteria andServiceAccountNotEqualTo(String value) {
            addCriterion("SERVICE_ACCOUNT <>", value, "serviceAccount");
            return (Criteria) this;
        }

        public Criteria andServiceAccountGreaterThan(String value) {
            addCriterion("SERVICE_ACCOUNT >", value, "serviceAccount");
            return (Criteria) this;
        }

        public Criteria andServiceAccountGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_ACCOUNT >=", value, "serviceAccount");
            return (Criteria) this;
        }

        public Criteria andServiceAccountLessThan(String value) {
            addCriterion("SERVICE_ACCOUNT <", value, "serviceAccount");
            return (Criteria) this;
        }

        public Criteria andServiceAccountLessThanOrEqualTo(String value) {
            addCriterion("SERVICE_ACCOUNT <=", value, "serviceAccount");
            return (Criteria) this;
        }

        public Criteria andServiceAccountLike(String value) {
            addCriterion("SERVICE_ACCOUNT like", value, "serviceAccount");
            return (Criteria) this;
        }

        public Criteria andServiceAccountNotLike(String value) {
            addCriterion("SERVICE_ACCOUNT not like", value, "serviceAccount");
            return (Criteria) this;
        }

        public Criteria andServiceAccountIn(List<String> values) {
            addCriterion("SERVICE_ACCOUNT in", values, "serviceAccount");
            return (Criteria) this;
        }

        public Criteria andServiceAccountNotIn(List<String> values) {
            addCriterion("SERVICE_ACCOUNT not in", values, "serviceAccount");
            return (Criteria) this;
        }

        public Criteria andServiceAccountBetween(String value1, String value2) {
            addCriterion("SERVICE_ACCOUNT between", value1, value2, "serviceAccount");
            return (Criteria) this;
        }

        public Criteria andServiceAccountNotBetween(String value1, String value2) {
            addCriterion("SERVICE_ACCOUNT not between", value1, value2, "serviceAccount");
            return (Criteria) this;
        }

        public Criteria andServicePwdIsNull() {
            addCriterion("SERVICE_PWD is null");
            return (Criteria) this;
        }

        public Criteria andServicePwdIsNotNull() {
            addCriterion("SERVICE_PWD is not null");
            return (Criteria) this;
        }

        public Criteria andServicePwdEqualTo(String value) {
            addCriterion("SERVICE_PWD =", value, "servicePwd");
            return (Criteria) this;
        }

        public Criteria andServicePwdNotEqualTo(String value) {
            addCriterion("SERVICE_PWD <>", value, "servicePwd");
            return (Criteria) this;
        }

        public Criteria andServicePwdGreaterThan(String value) {
            addCriterion("SERVICE_PWD >", value, "servicePwd");
            return (Criteria) this;
        }

        public Criteria andServicePwdGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_PWD >=", value, "servicePwd");
            return (Criteria) this;
        }

        public Criteria andServicePwdLessThan(String value) {
            addCriterion("SERVICE_PWD <", value, "servicePwd");
            return (Criteria) this;
        }

        public Criteria andServicePwdLessThanOrEqualTo(String value) {
            addCriterion("SERVICE_PWD <=", value, "servicePwd");
            return (Criteria) this;
        }

        public Criteria andServicePwdLike(String value) {
            addCriterion("SERVICE_PWD like", value, "servicePwd");
            return (Criteria) this;
        }

        public Criteria andServicePwdNotLike(String value) {
            addCriterion("SERVICE_PWD not like", value, "servicePwd");
            return (Criteria) this;
        }

        public Criteria andServicePwdIn(List<String> values) {
            addCriterion("SERVICE_PWD in", values, "servicePwd");
            return (Criteria) this;
        }

        public Criteria andServicePwdNotIn(List<String> values) {
            addCriterion("SERVICE_PWD not in", values, "servicePwd");
            return (Criteria) this;
        }

        public Criteria andServicePwdBetween(String value1, String value2) {
            addCriterion("SERVICE_PWD between", value1, value2, "servicePwd");
            return (Criteria) this;
        }

        public Criteria andServicePwdNotBetween(String value1, String value2) {
            addCriterion("SERVICE_PWD not between", value1, value2, "servicePwd");
            return (Criteria) this;
        }

        public Criteria andServiceVersionIsNull() {
            addCriterion("SERVICE_VERSION is null");
            return (Criteria) this;
        }

        public Criteria andServiceVersionIsNotNull() {
            addCriterion("SERVICE_VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andServiceVersionEqualTo(String value) {
            addCriterion("SERVICE_VERSION =", value, "serviceVersion");
            return (Criteria) this;
        }

        public Criteria andServiceVersionNotEqualTo(String value) {
            addCriterion("SERVICE_VERSION <>", value, "serviceVersion");
            return (Criteria) this;
        }

        public Criteria andServiceVersionGreaterThan(String value) {
            addCriterion("SERVICE_VERSION >", value, "serviceVersion");
            return (Criteria) this;
        }

        public Criteria andServiceVersionGreaterThanOrEqualTo(String value) {
            addCriterion("SERVICE_VERSION >=", value, "serviceVersion");
            return (Criteria) this;
        }

        public Criteria andServiceVersionLessThan(String value) {
            addCriterion("SERVICE_VERSION <", value, "serviceVersion");
            return (Criteria) this;
        }

        public Criteria andServiceVersionLessThanOrEqualTo(String value) {
            addCriterion("SERVICE_VERSION <=", value, "serviceVersion");
            return (Criteria) this;
        }

        public Criteria andServiceVersionLike(String value) {
            addCriterion("SERVICE_VERSION like", value, "serviceVersion");
            return (Criteria) this;
        }

        public Criteria andServiceVersionNotLike(String value) {
            addCriterion("SERVICE_VERSION not like", value, "serviceVersion");
            return (Criteria) this;
        }

        public Criteria andServiceVersionIn(List<String> values) {
            addCriterion("SERVICE_VERSION in", values, "serviceVersion");
            return (Criteria) this;
        }

        public Criteria andServiceVersionNotIn(List<String> values) {
            addCriterion("SERVICE_VERSION not in", values, "serviceVersion");
            return (Criteria) this;
        }

        public Criteria andServiceVersionBetween(String value1, String value2) {
            addCriterion("SERVICE_VERSION between", value1, value2, "serviceVersion");
            return (Criteria) this;
        }

        public Criteria andServiceVersionNotBetween(String value1, String value2) {
            addCriterion("SERVICE_VERSION not between", value1, value2, "serviceVersion");
            return (Criteria) this;
        }

        public Criteria andExchangeNameIsNull() {
            addCriterion("EXCHANGE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andExchangeNameIsNotNull() {
            addCriterion("EXCHANGE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andExchangeNameEqualTo(String value) {
            addCriterion("EXCHANGE_NAME =", value, "exchangeName");
            return (Criteria) this;
        }

        public Criteria andExchangeNameNotEqualTo(String value) {
            addCriterion("EXCHANGE_NAME <>", value, "exchangeName");
            return (Criteria) this;
        }

        public Criteria andExchangeNameGreaterThan(String value) {
            addCriterion("EXCHANGE_NAME >", value, "exchangeName");
            return (Criteria) this;
        }

        public Criteria andExchangeNameGreaterThanOrEqualTo(String value) {
            addCriterion("EXCHANGE_NAME >=", value, "exchangeName");
            return (Criteria) this;
        }

        public Criteria andExchangeNameLessThan(String value) {
            addCriterion("EXCHANGE_NAME <", value, "exchangeName");
            return (Criteria) this;
        }

        public Criteria andExchangeNameLessThanOrEqualTo(String value) {
            addCriterion("EXCHANGE_NAME <=", value, "exchangeName");
            return (Criteria) this;
        }

        public Criteria andExchangeNameLike(String value) {
            addCriterion("EXCHANGE_NAME like", value, "exchangeName");
            return (Criteria) this;
        }

        public Criteria andExchangeNameNotLike(String value) {
            addCriterion("EXCHANGE_NAME not like", value, "exchangeName");
            return (Criteria) this;
        }

        public Criteria andExchangeNameIn(List<String> values) {
            addCriterion("EXCHANGE_NAME in", values, "exchangeName");
            return (Criteria) this;
        }

        public Criteria andExchangeNameNotIn(List<String> values) {
            addCriterion("EXCHANGE_NAME not in", values, "exchangeName");
            return (Criteria) this;
        }

        public Criteria andExchangeNameBetween(String value1, String value2) {
            addCriterion("EXCHANGE_NAME between", value1, value2, "exchangeName");
            return (Criteria) this;
        }

        public Criteria andExchangeNameNotBetween(String value1, String value2) {
            addCriterion("EXCHANGE_NAME not between", value1, value2, "exchangeName");
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
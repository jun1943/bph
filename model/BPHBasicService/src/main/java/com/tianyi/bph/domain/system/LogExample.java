package com.tianyi.bph.domain.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andLogIdIsNull() {
            addCriterion("LOG_ID is null");
            return (Criteria) this;
        }

        public Criteria andLogIdIsNotNull() {
            addCriterion("LOG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLogIdEqualTo(Integer value) {
            addCriterion("LOG_ID =", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotEqualTo(Integer value) {
            addCriterion("LOG_ID <>", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThan(Integer value) {
            addCriterion("LOG_ID >", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("LOG_ID >=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThan(Integer value) {
            addCriterion("LOG_ID <", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThanOrEqualTo(Integer value) {
            addCriterion("LOG_ID <=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdIn(List<Integer> values) {
            addCriterion("LOG_ID in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotIn(List<Integer> values) {
            addCriterion("LOG_ID not in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdBetween(Integer value1, Integer value2) {
            addCriterion("LOG_ID between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("LOG_ID not between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdIsNull() {
            addCriterion("LOG_TYPE_ID is null");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdIsNotNull() {
            addCriterion("LOG_TYPE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdEqualTo(Integer value) {
            addCriterion("LOG_TYPE_ID =", value, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdNotEqualTo(Integer value) {
            addCriterion("LOG_TYPE_ID <>", value, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdGreaterThan(Integer value) {
            addCriterion("LOG_TYPE_ID >", value, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("LOG_TYPE_ID >=", value, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdLessThan(Integer value) {
            addCriterion("LOG_TYPE_ID <", value, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("LOG_TYPE_ID <=", value, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdIn(List<Integer> values) {
            addCriterion("LOG_TYPE_ID in", values, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdNotIn(List<Integer> values) {
            addCriterion("LOG_TYPE_ID not in", values, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("LOG_TYPE_ID between", value1, value2, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("LOG_TYPE_ID not between", value1, value2, "logTypeId");
            return (Criteria) this;
        }

        public Criteria andLoginUserIdIsNull() {
            addCriterion("LOGIN_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andLoginUserIdIsNotNull() {
            addCriterion("LOGIN_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLoginUserIdEqualTo(String value) {
            addCriterion("LOGIN_USER_ID =", value, "loginUserId");
            return (Criteria) this;
        }

        public Criteria andLoginUserIdNotEqualTo(String value) {
            addCriterion("LOGIN_USER_ID <>", value, "loginUserId");
            return (Criteria) this;
        }

        public Criteria andLoginUserIdGreaterThan(String value) {
            addCriterion("LOGIN_USER_ID >", value, "loginUserId");
            return (Criteria) this;
        }

        public Criteria andLoginUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_USER_ID >=", value, "loginUserId");
            return (Criteria) this;
        }

        public Criteria andLoginUserIdLessThan(String value) {
            addCriterion("LOGIN_USER_ID <", value, "loginUserId");
            return (Criteria) this;
        }

        public Criteria andLoginUserIdLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_USER_ID <=", value, "loginUserId");
            return (Criteria) this;
        }

        public Criteria andLoginUserIdLike(String value) {
            addCriterion("LOGIN_USER_ID like", value, "loginUserId");
            return (Criteria) this;
        }

        public Criteria andLoginUserIdNotLike(String value) {
            addCriterion("LOGIN_USER_ID not like", value, "loginUserId");
            return (Criteria) this;
        }

        public Criteria andLoginUserIdIn(List<String> values) {
            addCriterion("LOGIN_USER_ID in", values, "loginUserId");
            return (Criteria) this;
        }

        public Criteria andLoginUserIdNotIn(List<String> values) {
            addCriterion("LOGIN_USER_ID not in", values, "loginUserId");
            return (Criteria) this;
        }

        public Criteria andLoginUserIdBetween(String value1, String value2) {
            addCriterion("LOGIN_USER_ID between", value1, value2, "loginUserId");
            return (Criteria) this;
        }

        public Criteria andLoginUserIdNotBetween(String value1, String value2) {
            addCriterion("LOGIN_USER_ID not between", value1, value2, "loginUserId");
            return (Criteria) this;
        }

        public Criteria andLoginUserNameIsNull() {
            addCriterion("LOGIN_USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andLoginUserNameIsNotNull() {
            addCriterion("LOGIN_USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andLoginUserNameEqualTo(String value) {
            addCriterion("LOGIN_USER_NAME =", value, "loginUserName");
            return (Criteria) this;
        }

        public Criteria andLoginUserNameNotEqualTo(String value) {
            addCriterion("LOGIN_USER_NAME <>", value, "loginUserName");
            return (Criteria) this;
        }

        public Criteria andLoginUserNameGreaterThan(String value) {
            addCriterion("LOGIN_USER_NAME >", value, "loginUserName");
            return (Criteria) this;
        }

        public Criteria andLoginUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_USER_NAME >=", value, "loginUserName");
            return (Criteria) this;
        }

        public Criteria andLoginUserNameLessThan(String value) {
            addCriterion("LOGIN_USER_NAME <", value, "loginUserName");
            return (Criteria) this;
        }

        public Criteria andLoginUserNameLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_USER_NAME <=", value, "loginUserName");
            return (Criteria) this;
        }

        public Criteria andLoginUserNameLike(String value) {
            addCriterion("LOGIN_USER_NAME like", value, "loginUserName");
            return (Criteria) this;
        }

        public Criteria andLoginUserNameNotLike(String value) {
            addCriterion("LOGIN_USER_NAME not like", value, "loginUserName");
            return (Criteria) this;
        }

        public Criteria andLoginUserNameIn(List<String> values) {
            addCriterion("LOGIN_USER_NAME in", values, "loginUserName");
            return (Criteria) this;
        }

        public Criteria andLoginUserNameNotIn(List<String> values) {
            addCriterion("LOGIN_USER_NAME not in", values, "loginUserName");
            return (Criteria) this;
        }

        public Criteria andLoginUserNameBetween(String value1, String value2) {
            addCriterion("LOGIN_USER_NAME between", value1, value2, "loginUserName");
            return (Criteria) this;
        }

        public Criteria andLoginUserNameNotBetween(String value1, String value2) {
            addCriterion("LOGIN_USER_NAME not between", value1, value2, "loginUserName");
            return (Criteria) this;
        }

        public Criteria andLoginIpIsNull() {
            addCriterion("LOGIN_IP is null");
            return (Criteria) this;
        }

        public Criteria andLoginIpIsNotNull() {
            addCriterion("LOGIN_IP is not null");
            return (Criteria) this;
        }

        public Criteria andLoginIpEqualTo(String value) {
            addCriterion("LOGIN_IP =", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotEqualTo(String value) {
            addCriterion("LOGIN_IP <>", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpGreaterThan(String value) {
            addCriterion("LOGIN_IP >", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_IP >=", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLessThan(String value) {
            addCriterion("LOGIN_IP <", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_IP <=", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLike(String value) {
            addCriterion("LOGIN_IP like", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotLike(String value) {
            addCriterion("LOGIN_IP not like", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpIn(List<String> values) {
            addCriterion("LOGIN_IP in", values, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotIn(List<String> values) {
            addCriterion("LOGIN_IP not in", values, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpBetween(String value1, String value2) {
            addCriterion("LOGIN_IP between", value1, value2, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotBetween(String value1, String value2) {
            addCriterion("LOGIN_IP not between", value1, value2, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginMacIsNull() {
            addCriterion("LOGIN_MAC is null");
            return (Criteria) this;
        }

        public Criteria andLoginMacIsNotNull() {
            addCriterion("LOGIN_MAC is not null");
            return (Criteria) this;
        }

        public Criteria andLoginMacEqualTo(String value) {
            addCriterion("LOGIN_MAC =", value, "loginMac");
            return (Criteria) this;
        }

        public Criteria andLoginMacNotEqualTo(String value) {
            addCriterion("LOGIN_MAC <>", value, "loginMac");
            return (Criteria) this;
        }

        public Criteria andLoginMacGreaterThan(String value) {
            addCriterion("LOGIN_MAC >", value, "loginMac");
            return (Criteria) this;
        }

        public Criteria andLoginMacGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_MAC >=", value, "loginMac");
            return (Criteria) this;
        }

        public Criteria andLoginMacLessThan(String value) {
            addCriterion("LOGIN_MAC <", value, "loginMac");
            return (Criteria) this;
        }

        public Criteria andLoginMacLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_MAC <=", value, "loginMac");
            return (Criteria) this;
        }

        public Criteria andLoginMacLike(String value) {
            addCriterion("LOGIN_MAC like", value, "loginMac");
            return (Criteria) this;
        }

        public Criteria andLoginMacNotLike(String value) {
            addCriterion("LOGIN_MAC not like", value, "loginMac");
            return (Criteria) this;
        }

        public Criteria andLoginMacIn(List<String> values) {
            addCriterion("LOGIN_MAC in", values, "loginMac");
            return (Criteria) this;
        }

        public Criteria andLoginMacNotIn(List<String> values) {
            addCriterion("LOGIN_MAC not in", values, "loginMac");
            return (Criteria) this;
        }

        public Criteria andLoginMacBetween(String value1, String value2) {
            addCriterion("LOGIN_MAC between", value1, value2, "loginMac");
            return (Criteria) this;
        }

        public Criteria andLoginMacNotBetween(String value1, String value2) {
            addCriterion("LOGIN_MAC not between", value1, value2, "loginMac");
            return (Criteria) this;
        }

        public Criteria andOperateDateIsNull() {
            addCriterion("OPERATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andOperateDateIsNotNull() {
            addCriterion("OPERATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andOperateDateEqualTo(Date value) {
            addCriterionForJDBCDate("OPERATE_DATE =", value, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("OPERATE_DATE <>", value, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("OPERATE_DATE >", value, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("OPERATE_DATE >=", value, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateLessThan(Date value) {
            addCriterionForJDBCDate("OPERATE_DATE <", value, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("OPERATE_DATE <=", value, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateIn(List<Date> values) {
            addCriterionForJDBCDate("OPERATE_DATE in", values, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("OPERATE_DATE not in", values, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("OPERATE_DATE between", value1, value2, "operateDate");
            return (Criteria) this;
        }

        public Criteria andOperateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("OPERATE_DATE not between", value1, value2, "operateDate");
            return (Criteria) this;
        }

        public Criteria andLogContextIsNull() {
            addCriterion("LOG_CONTEXT is null");
            return (Criteria) this;
        }

        public Criteria andLogContextIsNotNull() {
            addCriterion("LOG_CONTEXT is not null");
            return (Criteria) this;
        }

        public Criteria andLogContextEqualTo(String value) {
            addCriterion("LOG_CONTEXT =", value, "logContext");
            return (Criteria) this;
        }

        public Criteria andLogContextNotEqualTo(String value) {
            addCriterion("LOG_CONTEXT <>", value, "logContext");
            return (Criteria) this;
        }

        public Criteria andLogContextGreaterThan(String value) {
            addCriterion("LOG_CONTEXT >", value, "logContext");
            return (Criteria) this;
        }

        public Criteria andLogContextGreaterThanOrEqualTo(String value) {
            addCriterion("LOG_CONTEXT >=", value, "logContext");
            return (Criteria) this;
        }

        public Criteria andLogContextLessThan(String value) {
            addCriterion("LOG_CONTEXT <", value, "logContext");
            return (Criteria) this;
        }

        public Criteria andLogContextLessThanOrEqualTo(String value) {
            addCriterion("LOG_CONTEXT <=", value, "logContext");
            return (Criteria) this;
        }

        public Criteria andLogContextLike(String value) {
            addCriterion("LOG_CONTEXT like", value, "logContext");
            return (Criteria) this;
        }

        public Criteria andLogContextNotLike(String value) {
            addCriterion("LOG_CONTEXT not like", value, "logContext");
            return (Criteria) this;
        }

        public Criteria andLogContextIn(List<String> values) {
            addCriterion("LOG_CONTEXT in", values, "logContext");
            return (Criteria) this;
        }

        public Criteria andLogContextNotIn(List<String> values) {
            addCriterion("LOG_CONTEXT not in", values, "logContext");
            return (Criteria) this;
        }

        public Criteria andLogContextBetween(String value1, String value2) {
            addCriterion("LOG_CONTEXT between", value1, value2, "logContext");
            return (Criteria) this;
        }

        public Criteria andLogContextNotBetween(String value1, String value2) {
            addCriterion("LOG_CONTEXT not between", value1, value2, "logContext");
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
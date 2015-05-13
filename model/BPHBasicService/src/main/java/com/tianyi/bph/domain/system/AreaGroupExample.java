package com.tianyi.bph.domain.system;

import java.util.ArrayList;
import java.util.List;

public class AreaGroupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AreaGroupExample() {
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

        public Criteria andGroupIdIsNull() {
            addCriterion("GROUP_ID is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("GROUP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(Integer value) {
            addCriterion("GROUP_ID =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(Integer value) {
            addCriterion("GROUP_ID <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(Integer value) {
            addCriterion("GROUP_ID >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("GROUP_ID >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(Integer value) {
            addCriterion("GROUP_ID <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("GROUP_ID <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<Integer> values) {
            addCriterion("GROUP_ID in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<Integer> values) {
            addCriterion("GROUP_ID not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("GROUP_ID between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("GROUP_ID not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andAreaGroupTypeIsNull() {
            addCriterion("AREA_GROUP_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andAreaGroupTypeIsNotNull() {
            addCriterion("AREA_GROUP_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andAreaGroupTypeEqualTo(Integer value) {
            addCriterion("AREA_GROUP_TYPE =", value, "areaGroupType");
            return (Criteria) this;
        }

        public Criteria andAreaGroupTypeNotEqualTo(Integer value) {
            addCriterion("AREA_GROUP_TYPE <>", value, "areaGroupType");
            return (Criteria) this;
        }

        public Criteria andAreaGroupTypeGreaterThan(Integer value) {
            addCriterion("AREA_GROUP_TYPE >", value, "areaGroupType");
            return (Criteria) this;
        }

        public Criteria andAreaGroupTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("AREA_GROUP_TYPE >=", value, "areaGroupType");
            return (Criteria) this;
        }

        public Criteria andAreaGroupTypeLessThan(Integer value) {
            addCriterion("AREA_GROUP_TYPE <", value, "areaGroupType");
            return (Criteria) this;
        }

        public Criteria andAreaGroupTypeLessThanOrEqualTo(Integer value) {
            addCriterion("AREA_GROUP_TYPE <=", value, "areaGroupType");
            return (Criteria) this;
        }

        public Criteria andAreaGroupTypeIn(List<Integer> values) {
            addCriterion("AREA_GROUP_TYPE in", values, "areaGroupType");
            return (Criteria) this;
        }

        public Criteria andAreaGroupTypeNotIn(List<Integer> values) {
            addCriterion("AREA_GROUP_TYPE not in", values, "areaGroupType");
            return (Criteria) this;
        }

        public Criteria andAreaGroupTypeBetween(Integer value1, Integer value2) {
            addCriterion("AREA_GROUP_TYPE between", value1, value2, "areaGroupType");
            return (Criteria) this;
        }

        public Criteria andAreaGroupTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("AREA_GROUP_TYPE not between", value1, value2, "areaGroupType");
            return (Criteria) this;
        }

        public Criteria andAreaGroupContentIsNull() {
            addCriterion("AREA_GROUP_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andAreaGroupContentIsNotNull() {
            addCriterion("AREA_GROUP_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andAreaGroupContentEqualTo(String value) {
            addCriterion("AREA_GROUP_CONTENT =", value, "areaGroupContent");
            return (Criteria) this;
        }

        public Criteria andAreaGroupContentNotEqualTo(String value) {
            addCriterion("AREA_GROUP_CONTENT <>", value, "areaGroupContent");
            return (Criteria) this;
        }

        public Criteria andAreaGroupContentGreaterThan(String value) {
            addCriterion("AREA_GROUP_CONTENT >", value, "areaGroupContent");
            return (Criteria) this;
        }

        public Criteria andAreaGroupContentGreaterThanOrEqualTo(String value) {
            addCriterion("AREA_GROUP_CONTENT >=", value, "areaGroupContent");
            return (Criteria) this;
        }

        public Criteria andAreaGroupContentLessThan(String value) {
            addCriterion("AREA_GROUP_CONTENT <", value, "areaGroupContent");
            return (Criteria) this;
        }

        public Criteria andAreaGroupContentLessThanOrEqualTo(String value) {
            addCriterion("AREA_GROUP_CONTENT <=", value, "areaGroupContent");
            return (Criteria) this;
        }

        public Criteria andAreaGroupContentLike(String value) {
            addCriterion("AREA_GROUP_CONTENT like", value, "areaGroupContent");
            return (Criteria) this;
        }

        public Criteria andAreaGroupContentNotLike(String value) {
            addCriterion("AREA_GROUP_CONTENT not like", value, "areaGroupContent");
            return (Criteria) this;
        }

        public Criteria andAreaGroupContentIn(List<String> values) {
            addCriterion("AREA_GROUP_CONTENT in", values, "areaGroupContent");
            return (Criteria) this;
        }

        public Criteria andAreaGroupContentNotIn(List<String> values) {
            addCriterion("AREA_GROUP_CONTENT not in", values, "areaGroupContent");
            return (Criteria) this;
        }

        public Criteria andAreaGroupContentBetween(String value1, String value2) {
            addCriterion("AREA_GROUP_CONTENT between", value1, value2, "areaGroupContent");
            return (Criteria) this;
        }

        public Criteria andAreaGroupContentNotBetween(String value1, String value2) {
            addCriterion("AREA_GROUP_CONTENT not between", value1, value2, "areaGroupContent");
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
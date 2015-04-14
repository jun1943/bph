package com.tianyi.bph.query.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AreaExample {

	final public static int flag_normal = 1;// 正常
	final public static int flag_escape = 2;// 弃用

	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected int begin;

	protected int end;

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public AreaExample() {
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

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
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

		public Criteria andAreaNameIsNull() {
			addCriterion("area_name is null");
			return (Criteria) this;
		}

		public Criteria andAreaNameIsNotNull() {
			addCriterion("area_name is not null");
			return (Criteria) this;
		}

		public Criteria andAreaNameEqualTo(String value) {
			addCriterion("area_name =", value, "areaName");
			return (Criteria) this;
		}

		public Criteria andAreaNameNotEqualTo(String value) {
			addCriterion("area_name <>", value, "areaName");
			return (Criteria) this;
		}

		public Criteria andAreaNameGreaterThan(String value) {
			addCriterion("area_name >", value, "areaName");
			return (Criteria) this;
		}

		public Criteria andAreaNameGreaterThanOrEqualTo(String value) {
			addCriterion("area_name >=", value, "areaName");
			return (Criteria) this;
		}

		public Criteria andAreaNameLessThan(String value) {
			addCriterion("area_name <", value, "areaName");
			return (Criteria) this;
		}

		public Criteria andAreaNameLessThanOrEqualTo(String value) {
			addCriterion("area_name <=", value, "areaName");
			return (Criteria) this;
		}

		public Criteria andAreaNameLike(String value) {
			addCriterion("area_name like", value, "areaName");
			return (Criteria) this;
		}

		public Criteria andAreaNameNotLike(String value) {
			addCriterion("area_name not like", value, "areaName");
			return (Criteria) this;
		}

		public Criteria andAreaNameIn(List<String> values) {
			addCriterion("area_name in", values, "areaName");
			return (Criteria) this;
		}

		public Criteria andAreaNameNotIn(List<String> values) {
			addCriterion("area_name not in", values, "areaName");
			return (Criteria) this;
		}

		public Criteria andAreaNameBetween(String value1, String value2) {
			addCriterion("area_name between", value1, value2, "areaName");
			return (Criteria) this;
		}

		public Criteria andAreaNameNotBetween(String value1, String value2) {
			addCriterion("area_name not between", value1, value2, "areaName");
			return (Criteria) this;
		}

		public Criteria andAreaTypeIsNull() {
			addCriterion("area_type is null");
			return (Criteria) this;
		}

		public Criteria andAreaTypeIsNotNull() {
			addCriterion("area_type is not null");
			return (Criteria) this;
		}

		public Criteria andAreaTypeEqualTo(Integer value) {
			addCriterion("area_type =", value, "areaType");
			return (Criteria) this;
		}

		public Criteria andAreaTypeNotEqualTo(Integer value) {
			addCriterion("area_type <>", value, "areaType");
			return (Criteria) this;
		}

		public Criteria andAreaTypeGreaterThan(Integer value) {
			addCriterion("area_type >", value, "areaType");
			return (Criteria) this;
		}

		public Criteria andAreaTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("area_type >=", value, "areaType");
			return (Criteria) this;
		}

		public Criteria andAreaTypeLessThan(Integer value) {
			addCriterion("area_type <", value, "areaType");
			return (Criteria) this;
		}

		public Criteria andAreaTypeLessThanOrEqualTo(Integer value) {
			addCriterion("area_type <=", value, "areaType");
			return (Criteria) this;
		}

		public Criteria andAreaTypeIn(List<Integer> values) {
			addCriterion("area_type in", values, "areaType");
			return (Criteria) this;
		}

		public Criteria andAreaTypeNotIn(List<Integer> values) {
			addCriterion("area_type not in", values, "areaType");
			return (Criteria) this;
		}

		public Criteria andAreaTypeBetween(Integer value1, Integer value2) {
			addCriterion("area_type between", value1, value2, "areaType");
			return (Criteria) this;
		}

		public Criteria andAreaTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("area_type not between", value1, value2, "areaType");
			return (Criteria) this;
		}

		public Criteria andOrganIdIsNull() {
			addCriterion("organ_id is null");
			return (Criteria) this;
		}

		public Criteria andOrganIdIsNotNull() {
			addCriterion("organ_id is not null");
			return (Criteria) this;
		}

		public Criteria andOrganIdEqualTo(Integer value) {
			addCriterion("organ_id =", value, "organId");
			return (Criteria) this;
		}

		public Criteria andOrganIdNotEqualTo(Integer value) {
			addCriterion("organ_id <>", value, "organId");
			return (Criteria) this;
		}

		public Criteria andOrganIdGreaterThan(Integer value) {
			addCriterion("organ_id >", value, "organId");
			return (Criteria) this;
		}

		public Criteria andOrganIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("organ_id >=", value, "organId");
			return (Criteria) this;
		}

		public Criteria andOrganIdLessThan(Integer value) {
			addCriterion("organ_id <", value, "organId");
			return (Criteria) this;
		}

		public Criteria andOrganIdLessThanOrEqualTo(Integer value) {
			addCriterion("organ_id <=", value, "organId");
			return (Criteria) this;
		}

		public Criteria andOrganIdIn(List<Integer> values) {
			addCriterion("organ_id in", values, "organId");
			return (Criteria) this;
		}

		public Criteria andOrganIdNotIn(List<Integer> values) {
			addCriterion("organ_id not in", values, "organId");
			return (Criteria) this;
		}

		public Criteria andOrganIdBetween(Integer value1, Integer value2) {
			addCriterion("organ_id between", value1, value2, "organId");
			return (Criteria) this;
		}

		public Criteria andOrganIdNotBetween(Integer value1, Integer value2) {
			addCriterion("organ_id not between", value1, value2, "organId");
			return (Criteria) this;
		}

		public Criteria andChangeRangeIsNull() {
			addCriterion("change_range is null");
			return (Criteria) this;
		}

		public Criteria andChangeRangeIsNotNull() {
			addCriterion("change_range is not null");
			return (Criteria) this;
		}

		public Criteria andChangeRangeEqualTo(Boolean value) {
			addCriterion("change_range =", value, "changeRange");
			return (Criteria) this;
		}

		public Criteria andChangeRangeNotEqualTo(Boolean value) {
			addCriterion("change_range <>", value, "changeRange");
			return (Criteria) this;
		}

		public Criteria andChangeRangeGreaterThan(Boolean value) {
			addCriterion("change_range >", value, "changeRange");
			return (Criteria) this;
		}

		public Criteria andChangeRangeGreaterThanOrEqualTo(Boolean value) {
			addCriterion("change_range >=", value, "changeRange");
			return (Criteria) this;
		}

		public Criteria andChangeRangeLessThan(Boolean value) {
			addCriterion("change_range <", value, "changeRange");
			return (Criteria) this;
		}

		public Criteria andChangeRangeLessThanOrEqualTo(Boolean value) {
			addCriterion("change_range <=", value, "changeRange");
			return (Criteria) this;
		}

		public Criteria andChangeRangeIn(List<Boolean> values) {
			addCriterion("change_range in", values, "changeRange");
			return (Criteria) this;
		}

		public Criteria andChangeRangeNotIn(List<Boolean> values) {
			addCriterion("change_range not in", values, "changeRange");
			return (Criteria) this;
		}

		public Criteria andChangeRangeBetween(Boolean value1, Boolean value2) {
			addCriterion("change_range between", value1, value2, "changeRange");
			return (Criteria) this;
		}

		public Criteria andChangeRangeNotBetween(Boolean value1, Boolean value2) {
			addCriterion("change_range not between", value1, value2,
					"changeRange");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNull() {
			addCriterion("create_time is null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNotNull() {
			addCriterion("create_time is not null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeEqualTo(Date value) {
			addCriterion("create_time =", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotEqualTo(Date value) {
			addCriterion("create_time <>", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThan(Date value) {
			addCriterion("create_time >", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("create_time >=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThan(Date value) {
			addCriterion("create_time <", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
			addCriterion("create_time <=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIn(List<Date> values) {
			addCriterion("create_time in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotIn(List<Date> values) {
			addCriterion("create_time not in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeBetween(Date value1, Date value2) {
			addCriterion("create_time between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
			addCriterion("create_time not between", value1, value2,
					"createTime");
			return (Criteria) this;
		}

		public Criteria andFlagIsNull() {
			addCriterion("flag is null");
			return (Criteria) this;
		}

		public Criteria andFlagIsNotNull() {
			addCriterion("flag is not null");
			return (Criteria) this;
		}

		public Criteria andFlagEqualTo(Integer value) {
			addCriterion("flag =", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagNotEqualTo(Integer value) {
			addCriterion("flag <>", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagGreaterThan(Integer value) {
			addCriterion("flag >", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagGreaterThanOrEqualTo(Integer value) {
			addCriterion("flag >=", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagLessThan(Integer value) {
			addCriterion("flag <", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagLessThanOrEqualTo(Integer value) {
			addCriterion("flag <=", value, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagIn(List<Integer> values) {
			addCriterion("flag in", values, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagNotIn(List<Integer> values) {
			addCriterion("flag not in", values, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagBetween(Integer value1, Integer value2) {
			addCriterion("flag between", value1, value2, "flag");
			return (Criteria) this;
		}

		public Criteria andFlagNotBetween(Integer value1, Integer value2) {
			addCriterion("flag not between", value1, value2, "flag");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdIsNull() {
			addCriterion("create_user_id is null");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdIsNotNull() {
			addCriterion("create_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdEqualTo(Integer value) {
			addCriterion("create_user_id =", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdNotEqualTo(Integer value) {
			addCriterion("create_user_id <>", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdGreaterThan(Integer value) {
			addCriterion("create_user_id >", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("create_user_id >=", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdLessThan(Integer value) {
			addCriterion("create_user_id <", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdLessThanOrEqualTo(Integer value) {
			addCriterion("create_user_id <=", value, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdIn(List<Integer> values) {
			addCriterion("create_user_id in", values, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdNotIn(List<Integer> values) {
			addCriterion("create_user_id not in", values, "createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdBetween(Integer value1, Integer value2) {
			addCriterion("create_user_id between", value1, value2,
					"createUserId");
			return (Criteria) this;
		}

		public Criteria andCreateUserIdNotBetween(Integer value1, Integer value2) {
			addCriterion("create_user_id not between", value1, value2,
					"createUserId");
			return (Criteria) this;
		}

		public Criteria andTelIsNull() {
			addCriterion("tel is null");
			return (Criteria) this;
		}

		public Criteria andTelIsNotNull() {
			addCriterion("tel is not null");
			return (Criteria) this;
		}

		public Criteria andTelEqualTo(String value) {
			addCriterion("tel =", value, "tel");
			return (Criteria) this;
		}

		public Criteria andTelNotEqualTo(String value) {
			addCriterion("tel <>", value, "tel");
			return (Criteria) this;
		}

		public Criteria andTelGreaterThan(String value) {
			addCriterion("tel >", value, "tel");
			return (Criteria) this;
		}

		public Criteria andTelGreaterThanOrEqualTo(String value) {
			addCriterion("tel >=", value, "tel");
			return (Criteria) this;
		}

		public Criteria andTelLessThan(String value) {
			addCriterion("tel <", value, "tel");
			return (Criteria) this;
		}

		public Criteria andTelLessThanOrEqualTo(String value) {
			addCriterion("tel <=", value, "tel");
			return (Criteria) this;
		}

		public Criteria andTelLike(String value) {
			addCriterion("tel like", value, "tel");
			return (Criteria) this;
		}

		public Criteria andTelNotLike(String value) {
			addCriterion("tel not like", value, "tel");
			return (Criteria) this;
		}

		public Criteria andTelIn(List<String> values) {
			addCriterion("tel in", values, "tel");
			return (Criteria) this;
		}

		public Criteria andTelNotIn(List<String> values) {
			addCriterion("tel not in", values, "tel");
			return (Criteria) this;
		}

		public Criteria andTelBetween(String value1, String value2) {
			addCriterion("tel between", value1, value2, "tel");
			return (Criteria) this;
		}

		public Criteria andTelNotBetween(String value1, String value2) {
			addCriterion("tel not between", value1, value2, "tel");
			return (Criteria) this;
		}

		public Criteria andNntIsNull() {
			addCriterion("nnt is null");
			return (Criteria) this;
		}

		public Criteria andNntIsNotNull() {
			addCriterion("nnt is not null");
			return (Criteria) this;
		}

		public Criteria andNntEqualTo(Integer value) {
			addCriterion("nnt =", value, "nnt");
			return (Criteria) this;
		}

		public Criteria andNntNotEqualTo(Integer value) {
			addCriterion("nnt <>", value, "nnt");
			return (Criteria) this;
		}

		public Criteria andNntGreaterThan(Integer value) {
			addCriterion("nnt >", value, "nnt");
			return (Criteria) this;
		}

		public Criteria andNntGreaterThanOrEqualTo(Integer value) {
			addCriterion("nnt >=", value, "nnt");
			return (Criteria) this;
		}

		public Criteria andNntLessThan(Integer value) {
			addCriterion("nnt <", value, "nnt");
			return (Criteria) this;
		}

		public Criteria andNntLessThanOrEqualTo(Integer value) {
			addCriterion("nnt <=", value, "nnt");
			return (Criteria) this;
		}

		public Criteria andNntIn(List<Integer> values) {
			addCriterion("nnt in", values, "nnt");
			return (Criteria) this;
		}

		public Criteria andNntNotIn(List<Integer> values) {
			addCriterion("nnt not in", values, "nnt");
			return (Criteria) this;
		}

		public Criteria andNntBetween(Integer value1, Integer value2) {
			addCriterion("nnt between", value1, value2, "nnt");
			return (Criteria) this;
		}

		public Criteria andNntNotBetween(Integer value1, Integer value2) {
			addCriterion("nnt not between", value1, value2, "nnt");
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

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
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
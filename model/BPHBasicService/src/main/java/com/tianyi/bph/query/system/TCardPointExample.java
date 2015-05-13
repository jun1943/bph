package com.tianyi.bph.query.system;

import java.util.ArrayList;
import java.util.List;

public class TCardPointExample {
	protected String orderByClause;

	protected boolean distinct;

	protected int begin;// 开始记录

	protected int end;// 结束记录

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

	protected List<Criteria> oredCriteria;

	public TCardPointExample() {
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

		public Criteria andCommunityGroupNumIsNull() {
			addCriterion("community_group_num is null");
			return (Criteria) this;
		}

		public Criteria andCommunityGroupNumIsNotNull() {
			addCriterion("community_group_num is not null");
			return (Criteria) this;
		}

		public Criteria andCommunityGroupNumEqualTo(String value) {
			addCriterion("community_group_num =", value, "communityGroupNum");
			return (Criteria) this;
		}

		public Criteria andCommunityGroupNumNotEqualTo(String value) {
			addCriterion("community_group_num <>", value, "communityGroupNum");
			return (Criteria) this;
		}

		public Criteria andCommunityGroupNumGreaterThan(String value) {
			addCriterion("community_group_num >", value, "communityGroupNum");
			return (Criteria) this;
		}

		public Criteria andCommunityGroupNumGreaterThanOrEqualTo(String value) {
			addCriterion("community_group_num >=", value, "communityGroupNum");
			return (Criteria) this;
		}

		public Criteria andCommunityGroupNumLessThan(String value) {
			addCriterion("community_group_num <", value, "communityGroupNum");
			return (Criteria) this;
		}

		public Criteria andCommunityGroupNumLessThanOrEqualTo(String value) {
			addCriterion("community_group_num <=", value, "communityGroupNum");
			return (Criteria) this;
		}

		public Criteria andCommunityGroupNumLike(String value) {
			addCriterion("community_group_num like", value, "communityGroupNum");
			return (Criteria) this;
		}

		public Criteria andCommunityGroupNumNotLike(String value) {
			addCriterion("community_group_num not like", value,
					"communityGroupNum");
			return (Criteria) this;
		}

		public Criteria andCommunityGroupNumIn(List<String> values) {
			addCriterion("community_group_num in", values, "communityGroupNum");
			return (Criteria) this;
		}

		public Criteria andCommunityGroupNumNotIn(List<String> values) {
			addCriterion("community_group_num not in", values,
					"communityGroupNum");
			return (Criteria) this;
		}

		public Criteria andCommunityGroupNumBetween(String value1, String value2) {
			addCriterion("community_group_num between", value1, value2,
					"communityGroupNum");
			return (Criteria) this;
		}

		public Criteria andCommunityGroupNumNotBetween(String value1,
				String value2) {
			addCriterion("community_group_num not between", value1, value2,
					"communityGroupNum");
			return (Criteria) this;
		}

		public Criteria andLayersIdIsNull() {
			addCriterion("layers_id is null");
			return (Criteria) this;
		}

		public Criteria andLayersIdIsNotNull() {
			addCriterion("layers_id is not null");
			return (Criteria) this;
		}

		public Criteria andLayersIdEqualTo(Integer value) {
			addCriterion("layers_id =", value, "layersId");
			return (Criteria) this;
		}

		public Criteria andLayersIdNotEqualTo(Integer value) {
			addCriterion("layers_id <>", value, "layersId");
			return (Criteria) this;
		}

		public Criteria andLayersIdGreaterThan(Integer value) {
			addCriterion("layers_id >", value, "layersId");
			return (Criteria) this;
		}

		public Criteria andLayersIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("layers_id >=", value, "layersId");
			return (Criteria) this;
		}

		public Criteria andLayersIdLessThan(Integer value) {
			addCriterion("layers_id <", value, "layersId");
			return (Criteria) this;
		}

		public Criteria andLayersIdLessThanOrEqualTo(Integer value) {
			addCriterion("layers_id <=", value, "layersId");
			return (Criteria) this;
		}

		public Criteria andLayersIdIn(List<Integer> values) {
			addCriterion("layers_id in", values, "layersId");
			return (Criteria) this;
		}

		public Criteria andLayersIdNotIn(List<Integer> values) {
			addCriterion("layers_id not in", values, "layersId");
			return (Criteria) this;
		}

		public Criteria andLayersIdBetween(Integer value1, Integer value2) {
			addCriterion("layers_id between", value1, value2, "layersId");
			return (Criteria) this;
		}

		public Criteria andLayersIdNotBetween(Integer value1, Integer value2) {
			addCriterion("layers_id not between", value1, value2, "layersId");
			return (Criteria) this;
		}

		public Criteria andPeoplePoliceCountIsNull() {
			addCriterion("people_police_count is null");
			return (Criteria) this;
		}

		public Criteria andPeoplePoliceCountIsNotNull() {
			addCriterion("people_police_count is not null");
			return (Criteria) this;
		}

		public Criteria andPeoplePoliceCountEqualTo(Integer value) {
			addCriterion("people_police_count =", value, "peoplePoliceCount");
			return (Criteria) this;
		}

		public Criteria andPeoplePoliceCountNotEqualTo(Integer value) {
			addCriterion("people_police_count <>", value, "peoplePoliceCount");
			return (Criteria) this;
		}

		public Criteria andPeoplePoliceCountGreaterThan(Integer value) {
			addCriterion("people_police_count >", value, "peoplePoliceCount");
			return (Criteria) this;
		}

		public Criteria andPeoplePoliceCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("people_police_count >=", value, "peoplePoliceCount");
			return (Criteria) this;
		}

		public Criteria andPeoplePoliceCountLessThan(Integer value) {
			addCriterion("people_police_count <", value, "peoplePoliceCount");
			return (Criteria) this;
		}

		public Criteria andPeoplePoliceCountLessThanOrEqualTo(Integer value) {
			addCriterion("people_police_count <=", value, "peoplePoliceCount");
			return (Criteria) this;
		}

		public Criteria andPeoplePoliceCountIn(List<Integer> values) {
			addCriterion("people_police_count in", values, "peoplePoliceCount");
			return (Criteria) this;
		}

		public Criteria andPeoplePoliceCountNotIn(List<Integer> values) {
			addCriterion("people_police_count not in", values,
					"peoplePoliceCount");
			return (Criteria) this;
		}

		public Criteria andPeoplePoliceCountBetween(Integer value1,
				Integer value2) {
			addCriterion("people_police_count between", value1, value2,
					"peoplePoliceCount");
			return (Criteria) this;
		}

		public Criteria andPeoplePoliceCountNotBetween(Integer value1,
				Integer value2) {
			addCriterion("people_police_count not between", value1, value2,
					"peoplePoliceCount");
			return (Criteria) this;
		}

		public Criteria andTrafficPoliceCountIsNull() {
			addCriterion("traffic_police_count is null");
			return (Criteria) this;
		}

		public Criteria andTrafficPoliceCountIsNotNull() {
			addCriterion("traffic_police_count is not null");
			return (Criteria) this;
		}

		public Criteria andTrafficPoliceCountEqualTo(Integer value) {
			addCriterion("traffic_police_count =", value, "trafficPoliceCount");
			return (Criteria) this;
		}

		public Criteria andTrafficPoliceCountNotEqualTo(Integer value) {
			addCriterion("traffic_police_count <>", value, "trafficPoliceCount");
			return (Criteria) this;
		}

		public Criteria andTrafficPoliceCountGreaterThan(Integer value) {
			addCriterion("traffic_police_count >", value, "trafficPoliceCount");
			return (Criteria) this;
		}

		public Criteria andTrafficPoliceCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("traffic_police_count >=", value, "trafficPoliceCount");
			return (Criteria) this;
		}

		public Criteria andTrafficPoliceCountLessThan(Integer value) {
			addCriterion("traffic_police_count <", value, "trafficPoliceCount");
			return (Criteria) this;
		}

		public Criteria andTrafficPoliceCountLessThanOrEqualTo(Integer value) {
			addCriterion("traffic_police_count <=", value, "trafficPoliceCount");
			return (Criteria) this;
		}

		public Criteria andTrafficPoliceCountIn(List<Integer> values) {
			addCriterion("traffic_police_count in", values,
					"trafficPoliceCount");
			return (Criteria) this;
		}

		public Criteria andTrafficPoliceCountNotIn(List<Integer> values) {
			addCriterion("traffic_police_count not in", values,
					"trafficPoliceCount");
			return (Criteria) this;
		}

		public Criteria andTrafficPoliceCountBetween(Integer value1,
				Integer value2) {
			addCriterion("traffic_police_count between", value1, value2,
					"trafficPoliceCount");
			return (Criteria) this;
		}

		public Criteria andTrafficPoliceCountNotBetween(Integer value1,
				Integer value2) {
			addCriterion("traffic_police_count not between", value1, value2,
					"trafficPoliceCount");
			return (Criteria) this;
		}

		public Criteria andArmsPoliceCountIsNull() {
			addCriterion("\"arms_ police _count\" is null");
			return (Criteria) this;
		}

		public Criteria andArmsPoliceCountIsNotNull() {
			addCriterion("\"arms_ police _count\" is not null");
			return (Criteria) this;
		}

		public Criteria andArmsPoliceCountEqualTo(Integer value) {
			addCriterion("\"arms_ police _count\" =", value, "armsPoliceCount");
			return (Criteria) this;
		}

		public Criteria andArmsPoliceCountNotEqualTo(Integer value) {
			addCriterion("\"arms_ police _count\" <>", value, "armsPoliceCount");
			return (Criteria) this;
		}

		public Criteria andArmsPoliceCountGreaterThan(Integer value) {
			addCriterion("\"arms_ police _count\" >", value, "armsPoliceCount");
			return (Criteria) this;
		}

		public Criteria andArmsPoliceCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("\"arms_ police _count\" >=", value, "armsPoliceCount");
			return (Criteria) this;
		}

		public Criteria andArmsPoliceCountLessThan(Integer value) {
			addCriterion("\"arms_ police _count\" <", value, "armsPoliceCount");
			return (Criteria) this;
		}

		public Criteria andArmsPoliceCountLessThanOrEqualTo(Integer value) {
			addCriterion("\"arms_ police _count\" <=", value, "armsPoliceCount");
			return (Criteria) this;
		}

		public Criteria andArmsPoliceCountIn(List<Integer> values) {
			addCriterion("\"arms_ police _count\" in", values,
					"armsPoliceCount");
			return (Criteria) this;
		}

		public Criteria andArmsPoliceCountNotIn(List<Integer> values) {
			addCriterion("\"arms_ police _count\" not in", values,
					"armsPoliceCount");
			return (Criteria) this;
		}

		public Criteria andArmsPoliceCountBetween(Integer value1, Integer value2) {
			addCriterion("\"arms_ police _count\" between", value1, value2,
					"armsPoliceCount");
			return (Criteria) this;
		}

		public Criteria andArmsPoliceCountNotBetween(Integer value1,
				Integer value2) {
			addCriterion("\"arms_ police _count\" not between", value1, value2,
					"armsPoliceCount");
			return (Criteria) this;
		}

		public Criteria andAssignmentIsNull() {
			addCriterion("assignment is null");
			return (Criteria) this;
		}

		public Criteria andAssignmentIsNotNull() {
			addCriterion("assignment is not null");
			return (Criteria) this;
		}

		public Criteria andAssignmentEqualTo(String value) {
			addCriterion("assignment =", value, "assignment");
			return (Criteria) this;
		}

		public Criteria andAssignmentNotEqualTo(String value) {
			addCriterion("assignment <>", value, "assignment");
			return (Criteria) this;
		}

		public Criteria andAssignmentGreaterThan(String value) {
			addCriterion("assignment >", value, "assignment");
			return (Criteria) this;
		}

		public Criteria andAssignmentGreaterThanOrEqualTo(String value) {
			addCriterion("assignment >=", value, "assignment");
			return (Criteria) this;
		}

		public Criteria andAssignmentLessThan(String value) {
			addCriterion("assignment <", value, "assignment");
			return (Criteria) this;
		}

		public Criteria andAssignmentLessThanOrEqualTo(String value) {
			addCriterion("assignment <=", value, "assignment");
			return (Criteria) this;
		}

		public Criteria andAssignmentLike(String value) {
			addCriterion("assignment like", value, "assignment");
			return (Criteria) this;
		}

		public Criteria andAssignmentNotLike(String value) {
			addCriterion("assignment not like", value, "assignment");
			return (Criteria) this;
		}

		public Criteria andAssignmentIn(List<String> values) {
			addCriterion("assignment in", values, "assignment");
			return (Criteria) this;
		}

		public Criteria andAssignmentNotIn(List<String> values) {
			addCriterion("assignment not in", values, "assignment");
			return (Criteria) this;
		}

		public Criteria andAssignmentBetween(String value1, String value2) {
			addCriterion("assignment between", value1, value2, "assignment");
			return (Criteria) this;
		}

		public Criteria andAssignmentNotBetween(String value1, String value2) {
			addCriterion("assignment not between", value1, value2, "assignment");
			return (Criteria) this;
		}

		public Criteria andCardTypeIsNull() {
			addCriterion("card_type is null");
			return (Criteria) this;
		}

		public Criteria andCardTypeIsNotNull() {
			addCriterion("card_type is not null");
			return (Criteria) this;
		}

		public Criteria andCardTypeEqualTo(Integer value) {
			addCriterion("card_type =", value, "cardType");
			return (Criteria) this;
		}

		public Criteria andCardTypeNotEqualTo(Integer value) {
			addCriterion("card_type <>", value, "cardType");
			return (Criteria) this;
		}

		public Criteria andCardTypeGreaterThan(Integer value) {
			addCriterion("card_type >", value, "cardType");
			return (Criteria) this;
		}

		public Criteria andCardTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("card_type >=", value, "cardType");
			return (Criteria) this;
		}

		public Criteria andCardTypeLessThan(Integer value) {
			addCriterion("card_type <", value, "cardType");
			return (Criteria) this;
		}

		public Criteria andCardTypeLessThanOrEqualTo(Integer value) {
			addCriterion("card_type <=", value, "cardType");
			return (Criteria) this;
		}

		public Criteria andCardTypeIn(List<Integer> values) {
			addCriterion("card_type in", values, "cardType");
			return (Criteria) this;
		}

		public Criteria andCardTypeNotIn(List<Integer> values) {
			addCriterion("card_type not in", values, "cardType");
			return (Criteria) this;
		}

		public Criteria andCardTypeBetween(Integer value1, Integer value2) {
			addCriterion("card_type between", value1, value2, "cardType");
			return (Criteria) this;
		}

		public Criteria andCardTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("card_type not between", value1, value2, "cardType");
			return (Criteria) this;
		}

		public Criteria andLongitudeIsNull() {
			addCriterion("longitude is null");
			return (Criteria) this;
		}

		public Criteria andLongitudeIsNotNull() {
			addCriterion("longitude is not null");
			return (Criteria) this;
		}

		public Criteria andLongitudeEqualTo(Double value) {
			addCriterion("longitude =", value, "longitude");
			return (Criteria) this;
		}

		public Criteria andLongitudeNotEqualTo(Double value) {
			addCriterion("longitude <>", value, "longitude");
			return (Criteria) this;
		}

		public Criteria andLongitudeGreaterThan(Double value) {
			addCriterion("longitude >", value, "longitude");
			return (Criteria) this;
		}

		public Criteria andLongitudeGreaterThanOrEqualTo(Double value) {
			addCriterion("longitude >=", value, "longitude");
			return (Criteria) this;
		}

		public Criteria andLongitudeLessThan(Double value) {
			addCriterion("longitude <", value, "longitude");
			return (Criteria) this;
		}

		public Criteria andLongitudeLessThanOrEqualTo(Double value) {
			addCriterion("longitude <=", value, "longitude");
			return (Criteria) this;
		}

		public Criteria andLongitudeIn(List<Double> values) {
			addCriterion("longitude in", values, "longitude");
			return (Criteria) this;
		}

		public Criteria andLongitudeNotIn(List<Double> values) {
			addCriterion("longitude not in", values, "longitude");
			return (Criteria) this;
		}

		public Criteria andLongitudeBetween(Double value1, Double value2) {
			addCriterion("longitude between", value1, value2, "longitude");
			return (Criteria) this;
		}

		public Criteria andLongitudeNotBetween(Double value1, Double value2) {
			addCriterion("longitude not between", value1, value2, "longitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeIsNull() {
			addCriterion("latitude is null");
			return (Criteria) this;
		}

		public Criteria andLatitudeIsNotNull() {
			addCriterion("latitude is not null");
			return (Criteria) this;
		}

		public Criteria andLatitudeEqualTo(Double value) {
			addCriterion("latitude =", value, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeNotEqualTo(Double value) {
			addCriterion("latitude <>", value, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeGreaterThan(Double value) {
			addCriterion("latitude >", value, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeGreaterThanOrEqualTo(Double value) {
			addCriterion("latitude >=", value, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeLessThan(Double value) {
			addCriterion("latitude <", value, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeLessThanOrEqualTo(Double value) {
			addCriterion("latitude <=", value, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeIn(List<Double> values) {
			addCriterion("latitude in", values, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeNotIn(List<Double> values) {
			addCriterion("latitude not in", values, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeBetween(Double value1, Double value2) {
			addCriterion("latitude between", value1, value2, "latitude");
			return (Criteria) this;
		}

		public Criteria andLatitudeNotBetween(Double value1, Double value2) {
			addCriterion("latitude not between", value1, value2, "latitude");
			return (Criteria) this;
		}

		public Criteria andIconIdIsNull() {
			addCriterion("icon_id is null");
			return (Criteria) this;
		}

		public Criteria andIconIdIsNotNull() {
			addCriterion("icon_id is not null");
			return (Criteria) this;
		}

		public Criteria andIconIdEqualTo(Integer value) {
			addCriterion("icon_id =", value, "iconId");
			return (Criteria) this;
		}

		public Criteria andIconIdNotEqualTo(Integer value) {
			addCriterion("icon_id <>", value, "iconId");
			return (Criteria) this;
		}

		public Criteria andIconIdGreaterThan(Integer value) {
			addCriterion("icon_id >", value, "iconId");
			return (Criteria) this;
		}

		public Criteria andIconIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("icon_id >=", value, "iconId");
			return (Criteria) this;
		}

		public Criteria andIconIdLessThan(Integer value) {
			addCriterion("icon_id <", value, "iconId");
			return (Criteria) this;
		}

		public Criteria andIconIdLessThanOrEqualTo(Integer value) {
			addCriterion("icon_id <=", value, "iconId");
			return (Criteria) this;
		}

		public Criteria andIconIdIn(List<Integer> values) {
			addCriterion("icon_id in", values, "iconId");
			return (Criteria) this;
		}

		public Criteria andIconIdNotIn(List<Integer> values) {
			addCriterion("icon_id not in", values, "iconId");
			return (Criteria) this;
		}

		public Criteria andIconIdBetween(Integer value1, Integer value2) {
			addCriterion("icon_id between", value1, value2, "iconId");
			return (Criteria) this;
		}

		public Criteria andIconIdNotBetween(Integer value1, Integer value2) {
			addCriterion("icon_id not between", value1, value2, "iconId");
			return (Criteria) this;
		}

		public Criteria andMarkIsNull() {
			addCriterion("mark is null");
			return (Criteria) this;
		}

		public Criteria andMarkIsNotNull() {
			addCriterion("mark is not null");
			return (Criteria) this;
		}

		public Criteria andMarkEqualTo(Boolean value) {
			addCriterion("mark =", value, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkNotEqualTo(Boolean value) {
			addCriterion("mark <>", value, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkGreaterThan(Boolean value) {
			addCriterion("mark >", value, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkGreaterThanOrEqualTo(Boolean value) {
			addCriterion("mark >=", value, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkLessThan(Boolean value) {
			addCriterion("mark <", value, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkLessThanOrEqualTo(Boolean value) {
			addCriterion("mark <=", value, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkIn(List<Boolean> values) {
			addCriterion("mark in", values, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkNotIn(List<Boolean> values) {
			addCriterion("mark not in", values, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkBetween(Boolean value1, Boolean value2) {
			addCriterion("mark between", value1, value2, "mark");
			return (Criteria) this;
		}

		public Criteria andMarkNotBetween(Boolean value1, Boolean value2) {
			addCriterion("mark not between", value1, value2, "mark");
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

		public Criteria andEquipIsNull() {
			addCriterion("equip is null");
			return (Criteria) this;
		}

		public Criteria andEquipIsNotNull() {
			addCriterion("equip is not null");
			return (Criteria) this;
		}

		public Criteria andEquipEqualTo(String value) {
			addCriterion("equip =", value, "equip");
			return (Criteria) this;
		}

		public Criteria andEquipNotEqualTo(String value) {
			addCriterion("equip <>", value, "equip");
			return (Criteria) this;
		}

		public Criteria andEquipGreaterThan(String value) {
			addCriterion("equip >", value, "equip");
			return (Criteria) this;
		}

		public Criteria andEquipGreaterThanOrEqualTo(String value) {
			addCriterion("equip >=", value, "equip");
			return (Criteria) this;
		}

		public Criteria andEquipLessThan(String value) {
			addCriterion("equip <", value, "equip");
			return (Criteria) this;
		}

		public Criteria andEquipLessThanOrEqualTo(String value) {
			addCriterion("equip <=", value, "equip");
			return (Criteria) this;
		}

		public Criteria andEquipLike(String value) {
			addCriterion("equip like", value, "equip");
			return (Criteria) this;
		}

		public Criteria andEquipNotLike(String value) {
			addCriterion("equip not like", value, "equip");
			return (Criteria) this;
		}

		public Criteria andEquipIn(List<String> values) {
			addCriterion("equip in", values, "equip");
			return (Criteria) this;
		}

		public Criteria andEquipNotIn(List<String> values) {
			addCriterion("equip not in", values, "equip");
			return (Criteria) this;
		}

		public Criteria andEquipBetween(String value1, String value2) {
			addCriterion("equip between", value1, value2, "equip");
			return (Criteria) this;
		}

		public Criteria andEquipNotBetween(String value1, String value2) {
			addCriterion("equip not between", value1, value2, "equip");
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
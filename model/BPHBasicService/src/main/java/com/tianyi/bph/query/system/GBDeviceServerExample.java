package com.tianyi.bph.query.system;

import java.util.ArrayList;
import java.util.List;

public class GBDeviceServerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GBDeviceServerExample() {
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andStdIdIsNull() {
            addCriterion("std_id is null");
            return (Criteria) this;
        }

        public Criteria andStdIdIsNotNull() {
            addCriterion("std_id is not null");
            return (Criteria) this;
        }

        public Criteria andStdIdEqualTo(String value) {
            addCriterion("std_id =", value, "stdId");
            return (Criteria) this;
        }

        public Criteria andStdIdNotEqualTo(String value) {
            addCriterion("std_id <>", value, "stdId");
            return (Criteria) this;
        }

        public Criteria andStdIdGreaterThan(String value) {
            addCriterion("std_id >", value, "stdId");
            return (Criteria) this;
        }

        public Criteria andStdIdGreaterThanOrEqualTo(String value) {
            addCriterion("std_id >=", value, "stdId");
            return (Criteria) this;
        }

        public Criteria andStdIdLessThan(String value) {
            addCriterion("std_id <", value, "stdId");
            return (Criteria) this;
        }

        public Criteria andStdIdLessThanOrEqualTo(String value) {
            addCriterion("std_id <=", value, "stdId");
            return (Criteria) this;
        }

        public Criteria andStdIdLike(String value) {
            addCriterion("std_id like", value, "stdId");
            return (Criteria) this;
        }

        public Criteria andStdIdNotLike(String value) {
            addCriterion("std_id not like", value, "stdId");
            return (Criteria) this;
        }

        public Criteria andStdIdIn(List<String> values) {
            addCriterion("std_id in", values, "stdId");
            return (Criteria) this;
        }

        public Criteria andStdIdNotIn(List<String> values) {
            addCriterion("std_id not in", values, "stdId");
            return (Criteria) this;
        }

        public Criteria andStdIdBetween(String value1, String value2) {
            addCriterion("std_id between", value1, value2, "stdId");
            return (Criteria) this;
        }

        public Criteria andStdIdNotBetween(String value1, String value2) {
            addCriterion("std_id not between", value1, value2, "stdId");
            return (Criteria) this;
        }

        public Criteria andSecrecyIsNull() {
            addCriterion("secrecy is null");
            return (Criteria) this;
        }

        public Criteria andSecrecyIsNotNull() {
            addCriterion("secrecy is not null");
            return (Criteria) this;
        }

        public Criteria andSecrecyEqualTo(Integer value) {
            addCriterion("secrecy =", value, "secrecy");
            return (Criteria) this;
        }

        public Criteria andSecrecyNotEqualTo(Integer value) {
            addCriterion("secrecy <>", value, "secrecy");
            return (Criteria) this;
        }

        public Criteria andSecrecyGreaterThan(Integer value) {
            addCriterion("secrecy >", value, "secrecy");
            return (Criteria) this;
        }

        public Criteria andSecrecyGreaterThanOrEqualTo(Integer value) {
            addCriterion("secrecy >=", value, "secrecy");
            return (Criteria) this;
        }

        public Criteria andSecrecyLessThan(Integer value) {
            addCriterion("secrecy <", value, "secrecy");
            return (Criteria) this;
        }

        public Criteria andSecrecyLessThanOrEqualTo(Integer value) {
            addCriterion("secrecy <=", value, "secrecy");
            return (Criteria) this;
        }

        public Criteria andSecrecyIn(List<Integer> values) {
            addCriterion("secrecy in", values, "secrecy");
            return (Criteria) this;
        }

        public Criteria andSecrecyNotIn(List<Integer> values) {
            addCriterion("secrecy not in", values, "secrecy");
            return (Criteria) this;
        }

        public Criteria andSecrecyBetween(Integer value1, Integer value2) {
            addCriterion("secrecy between", value1, value2, "secrecy");
            return (Criteria) this;
        }

        public Criteria andSecrecyNotBetween(Integer value1, Integer value2) {
            addCriterion("secrecy not between", value1, value2, "secrecy");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("model like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("model not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("model not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
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

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("longitude like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("longitude not like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<String> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<String> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
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

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("latitude like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("latitude not like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<String> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<String> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNull() {
            addCriterion("owner is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNotNull() {
            addCriterion("owner is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerEqualTo(String value) {
            addCriterion("owner =", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotEqualTo(String value) {
            addCriterion("owner <>", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThan(String value) {
            addCriterion("owner >", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("owner >=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThan(String value) {
            addCriterion("owner <", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThanOrEqualTo(String value) {
            addCriterion("owner <=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLike(String value) {
            addCriterion("owner like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotLike(String value) {
            addCriterion("owner not like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerIn(List<String> values) {
            addCriterion("owner in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotIn(List<String> values) {
            addCriterion("owner not in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerBetween(String value1, String value2) {
            addCriterion("owner between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotBetween(String value1, String value2) {
            addCriterion("owner not between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andRegisterWayIsNull() {
            addCriterion("register_way is null");
            return (Criteria) this;
        }

        public Criteria andRegisterWayIsNotNull() {
            addCriterion("register_way is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterWayEqualTo(String value) {
            addCriterion("register_way =", value, "registerWay");
            return (Criteria) this;
        }

        public Criteria andRegisterWayNotEqualTo(String value) {
            addCriterion("register_way <>", value, "registerWay");
            return (Criteria) this;
        }

        public Criteria andRegisterWayGreaterThan(String value) {
            addCriterion("register_way >", value, "registerWay");
            return (Criteria) this;
        }

        public Criteria andRegisterWayGreaterThanOrEqualTo(String value) {
            addCriterion("register_way >=", value, "registerWay");
            return (Criteria) this;
        }

        public Criteria andRegisterWayLessThan(String value) {
            addCriterion("register_way <", value, "registerWay");
            return (Criteria) this;
        }

        public Criteria andRegisterWayLessThanOrEqualTo(String value) {
            addCriterion("register_way <=", value, "registerWay");
            return (Criteria) this;
        }

        public Criteria andRegisterWayLike(String value) {
            addCriterion("register_way like", value, "registerWay");
            return (Criteria) this;
        }

        public Criteria andRegisterWayNotLike(String value) {
            addCriterion("register_way not like", value, "registerWay");
            return (Criteria) this;
        }

        public Criteria andRegisterWayIn(List<String> values) {
            addCriterion("register_way in", values, "registerWay");
            return (Criteria) this;
        }

        public Criteria andRegisterWayNotIn(List<String> values) {
            addCriterion("register_way not in", values, "registerWay");
            return (Criteria) this;
        }

        public Criteria andRegisterWayBetween(String value1, String value2) {
            addCriterion("register_way between", value1, value2, "registerWay");
            return (Criteria) this;
        }

        public Criteria andRegisterWayNotBetween(String value1, String value2) {
            addCriterion("register_way not between", value1, value2, "registerWay");
            return (Criteria) this;
        }

        public Criteria andGbOrganIdIsNull() {
            addCriterion("gb_organ_id is null");
            return (Criteria) this;
        }

        public Criteria andGbOrganIdIsNotNull() {
            addCriterion("gb_organ_id is not null");
            return (Criteria) this;
        }

        public Criteria andGbOrganIdEqualTo(Integer value) {
            addCriterion("gb_organ_id =", value, "gbOrganId");
            return (Criteria) this;
        }

        public Criteria andGbOrganIdNotEqualTo(Integer value) {
            addCriterion("gb_organ_id <>", value, "gbOrganId");
            return (Criteria) this;
        }

        public Criteria andGbOrganIdGreaterThan(Integer value) {
            addCriterion("gb_organ_id >", value, "gbOrganId");
            return (Criteria) this;
        }

        public Criteria andGbOrganIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("gb_organ_id >=", value, "gbOrganId");
            return (Criteria) this;
        }

        public Criteria andGbOrganIdLessThan(Integer value) {
            addCriterion("gb_organ_id <", value, "gbOrganId");
            return (Criteria) this;
        }

        public Criteria andGbOrganIdLessThanOrEqualTo(Integer value) {
            addCriterion("gb_organ_id <=", value, "gbOrganId");
            return (Criteria) this;
        }

        public Criteria andGbOrganIdIn(List<Integer> values) {
            addCriterion("gb_organ_id in", values, "gbOrganId");
            return (Criteria) this;
        }

        public Criteria andGbOrganIdNotIn(List<Integer> values) {
            addCriterion("gb_organ_id not in", values, "gbOrganId");
            return (Criteria) this;
        }

        public Criteria andGbOrganIdBetween(Integer value1, Integer value2) {
            addCriterion("gb_organ_id between", value1, value2, "gbOrganId");
            return (Criteria) this;
        }

        public Criteria andGbOrganIdNotBetween(Integer value1, Integer value2) {
            addCriterion("gb_organ_id not between", value1, value2, "gbOrganId");
            return (Criteria) this;
        }

        public Criteria andCivilCodeIsNull() {
            addCriterion("civil_code is null");
            return (Criteria) this;
        }

        public Criteria andCivilCodeIsNotNull() {
            addCriterion("civil_code is not null");
            return (Criteria) this;
        }

        public Criteria andCivilCodeEqualTo(String value) {
            addCriterion("civil_code =", value, "civilCode");
            return (Criteria) this;
        }

        public Criteria andCivilCodeNotEqualTo(String value) {
            addCriterion("civil_code <>", value, "civilCode");
            return (Criteria) this;
        }

        public Criteria andCivilCodeGreaterThan(String value) {
            addCriterion("civil_code >", value, "civilCode");
            return (Criteria) this;
        }

        public Criteria andCivilCodeGreaterThanOrEqualTo(String value) {
            addCriterion("civil_code >=", value, "civilCode");
            return (Criteria) this;
        }

        public Criteria andCivilCodeLessThan(String value) {
            addCriterion("civil_code <", value, "civilCode");
            return (Criteria) this;
        }

        public Criteria andCivilCodeLessThanOrEqualTo(String value) {
            addCriterion("civil_code <=", value, "civilCode");
            return (Criteria) this;
        }

        public Criteria andCivilCodeLike(String value) {
            addCriterion("civil_code like", value, "civilCode");
            return (Criteria) this;
        }

        public Criteria andCivilCodeNotLike(String value) {
            addCriterion("civil_code not like", value, "civilCode");
            return (Criteria) this;
        }

        public Criteria andCivilCodeIn(List<String> values) {
            addCriterion("civil_code in", values, "civilCode");
            return (Criteria) this;
        }

        public Criteria andCivilCodeNotIn(List<String> values) {
            addCriterion("civil_code not in", values, "civilCode");
            return (Criteria) this;
        }

        public Criteria andCivilCodeBetween(String value1, String value2) {
            addCriterion("civil_code between", value1, value2, "civilCode");
            return (Criteria) this;
        }

        public Criteria andCivilCodeNotBetween(String value1, String value2) {
            addCriterion("civil_code not between", value1, value2, "civilCode");
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
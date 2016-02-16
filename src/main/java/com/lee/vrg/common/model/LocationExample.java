package com.lee.vrg.common.model;

import java.util.ArrayList;
import java.util.List;

public class LocationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LocationExample() {
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

        public Criteria andXIsNull() {
            addCriterion("x is null");
            return (Criteria) this;
        }

        public Criteria andXIsNotNull() {
            addCriterion("x is not null");
            return (Criteria) this;
        }

        public Criteria andXEqualTo(String value) {
            addCriterion("x =", value, "x");
            return (Criteria) this;
        }

        public Criteria andXNotEqualTo(String value) {
            addCriterion("x <>", value, "x");
            return (Criteria) this;
        }

        public Criteria andXGreaterThan(String value) {
            addCriterion("x >", value, "x");
            return (Criteria) this;
        }

        public Criteria andXGreaterThanOrEqualTo(String value) {
            addCriterion("x >=", value, "x");
            return (Criteria) this;
        }

        public Criteria andXLessThan(String value) {
            addCriterion("x <", value, "x");
            return (Criteria) this;
        }

        public Criteria andXLessThanOrEqualTo(String value) {
            addCriterion("x <=", value, "x");
            return (Criteria) this;
        }

        public Criteria andXLike(String value) {
            addCriterion("x like", value, "x");
            return (Criteria) this;
        }

        public Criteria andXNotLike(String value) {
            addCriterion("x not like", value, "x");
            return (Criteria) this;
        }

        public Criteria andXIn(List<String> values) {
            addCriterion("x in", values, "x");
            return (Criteria) this;
        }

        public Criteria andXNotIn(List<String> values) {
            addCriterion("x not in", values, "x");
            return (Criteria) this;
        }

        public Criteria andXBetween(String value1, String value2) {
            addCriterion("x between", value1, value2, "x");
            return (Criteria) this;
        }

        public Criteria andXNotBetween(String value1, String value2) {
            addCriterion("x not between", value1, value2, "x");
            return (Criteria) this;
        }

        public Criteria andYIsNull() {
            addCriterion("y is null");
            return (Criteria) this;
        }

        public Criteria andYIsNotNull() {
            addCriterion("y is not null");
            return (Criteria) this;
        }

        public Criteria andYEqualTo(String value) {
            addCriterion("y =", value, "y");
            return (Criteria) this;
        }

        public Criteria andYNotEqualTo(String value) {
            addCriterion("y <>", value, "y");
            return (Criteria) this;
        }

        public Criteria andYGreaterThan(String value) {
            addCriterion("y >", value, "y");
            return (Criteria) this;
        }

        public Criteria andYGreaterThanOrEqualTo(String value) {
            addCriterion("y >=", value, "y");
            return (Criteria) this;
        }

        public Criteria andYLessThan(String value) {
            addCriterion("y <", value, "y");
            return (Criteria) this;
        }

        public Criteria andYLessThanOrEqualTo(String value) {
            addCriterion("y <=", value, "y");
            return (Criteria) this;
        }

        public Criteria andYLike(String value) {
            addCriterion("y like", value, "y");
            return (Criteria) this;
        }

        public Criteria andYNotLike(String value) {
            addCriterion("y not like", value, "y");
            return (Criteria) this;
        }

        public Criteria andYIn(List<String> values) {
            addCriterion("y in", values, "y");
            return (Criteria) this;
        }

        public Criteria andYNotIn(List<String> values) {
            addCriterion("y not in", values, "y");
            return (Criteria) this;
        }

        public Criteria andYBetween(String value1, String value2) {
            addCriterion("y between", value1, value2, "y");
            return (Criteria) this;
        }

        public Criteria andYNotBetween(String value1, String value2) {
            addCriterion("y not between", value1, value2, "y");
            return (Criteria) this;
        }

        public Criteria andLocationTypeIsNull() {
            addCriterion("location_type is null");
            return (Criteria) this;
        }

        public Criteria andLocationTypeIsNotNull() {
            addCriterion("location_type is not null");
            return (Criteria) this;
        }

        public Criteria andLocationTypeEqualTo(Integer value) {
            addCriterion("location_type =", value, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeNotEqualTo(Integer value) {
            addCriterion("location_type <>", value, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeGreaterThan(Integer value) {
            addCriterion("location_type >", value, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("location_type >=", value, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeLessThan(Integer value) {
            addCriterion("location_type <", value, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeLessThanOrEqualTo(Integer value) {
            addCriterion("location_type <=", value, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeIn(List<Integer> values) {
            addCriterion("location_type in", values, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeNotIn(List<Integer> values) {
            addCriterion("location_type not in", values, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeBetween(Integer value1, Integer value2) {
            addCriterion("location_type between", value1, value2, "locationType");
            return (Criteria) this;
        }

        public Criteria andLocationTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("location_type not between", value1, value2, "locationType");
            return (Criteria) this;
        }

        public Criteria andDayHotIsNull() {
            addCriterion("day_hot is null");
            return (Criteria) this;
        }

        public Criteria andDayHotIsNotNull() {
            addCriterion("day_hot is not null");
            return (Criteria) this;
        }

        public Criteria andDayHotEqualTo(Integer value) {
            addCriterion("day_hot =", value, "dayHot");
            return (Criteria) this;
        }

        public Criteria andDayHotNotEqualTo(Integer value) {
            addCriterion("day_hot <>", value, "dayHot");
            return (Criteria) this;
        }

        public Criteria andDayHotGreaterThan(Integer value) {
            addCriterion("day_hot >", value, "dayHot");
            return (Criteria) this;
        }

        public Criteria andDayHotGreaterThanOrEqualTo(Integer value) {
            addCriterion("day_hot >=", value, "dayHot");
            return (Criteria) this;
        }

        public Criteria andDayHotLessThan(Integer value) {
            addCriterion("day_hot <", value, "dayHot");
            return (Criteria) this;
        }

        public Criteria andDayHotLessThanOrEqualTo(Integer value) {
            addCriterion("day_hot <=", value, "dayHot");
            return (Criteria) this;
        }

        public Criteria andDayHotIn(List<Integer> values) {
            addCriterion("day_hot in", values, "dayHot");
            return (Criteria) this;
        }

        public Criteria andDayHotNotIn(List<Integer> values) {
            addCriterion("day_hot not in", values, "dayHot");
            return (Criteria) this;
        }

        public Criteria andDayHotBetween(Integer value1, Integer value2) {
            addCriterion("day_hot between", value1, value2, "dayHot");
            return (Criteria) this;
        }

        public Criteria andDayHotNotBetween(Integer value1, Integer value2) {
            addCriterion("day_hot not between", value1, value2, "dayHot");
            return (Criteria) this;
        }

        public Criteria andWeekHotIsNull() {
            addCriterion("week_hot is null");
            return (Criteria) this;
        }

        public Criteria andWeekHotIsNotNull() {
            addCriterion("week_hot is not null");
            return (Criteria) this;
        }

        public Criteria andWeekHotEqualTo(Integer value) {
            addCriterion("week_hot =", value, "weekHot");
            return (Criteria) this;
        }

        public Criteria andWeekHotNotEqualTo(Integer value) {
            addCriterion("week_hot <>", value, "weekHot");
            return (Criteria) this;
        }

        public Criteria andWeekHotGreaterThan(Integer value) {
            addCriterion("week_hot >", value, "weekHot");
            return (Criteria) this;
        }

        public Criteria andWeekHotGreaterThanOrEqualTo(Integer value) {
            addCriterion("week_hot >=", value, "weekHot");
            return (Criteria) this;
        }

        public Criteria andWeekHotLessThan(Integer value) {
            addCriterion("week_hot <", value, "weekHot");
            return (Criteria) this;
        }

        public Criteria andWeekHotLessThanOrEqualTo(Integer value) {
            addCriterion("week_hot <=", value, "weekHot");
            return (Criteria) this;
        }

        public Criteria andWeekHotIn(List<Integer> values) {
            addCriterion("week_hot in", values, "weekHot");
            return (Criteria) this;
        }

        public Criteria andWeekHotNotIn(List<Integer> values) {
            addCriterion("week_hot not in", values, "weekHot");
            return (Criteria) this;
        }

        public Criteria andWeekHotBetween(Integer value1, Integer value2) {
            addCriterion("week_hot between", value1, value2, "weekHot");
            return (Criteria) this;
        }

        public Criteria andWeekHotNotBetween(Integer value1, Integer value2) {
            addCriterion("week_hot not between", value1, value2, "weekHot");
            return (Criteria) this;
        }

        public Criteria andMonthHotIsNull() {
            addCriterion("month_hot is null");
            return (Criteria) this;
        }

        public Criteria andMonthHotIsNotNull() {
            addCriterion("month_hot is not null");
            return (Criteria) this;
        }

        public Criteria andMonthHotEqualTo(Integer value) {
            addCriterion("month_hot =", value, "monthHot");
            return (Criteria) this;
        }

        public Criteria andMonthHotNotEqualTo(Integer value) {
            addCriterion("month_hot <>", value, "monthHot");
            return (Criteria) this;
        }

        public Criteria andMonthHotGreaterThan(Integer value) {
            addCriterion("month_hot >", value, "monthHot");
            return (Criteria) this;
        }

        public Criteria andMonthHotGreaterThanOrEqualTo(Integer value) {
            addCriterion("month_hot >=", value, "monthHot");
            return (Criteria) this;
        }

        public Criteria andMonthHotLessThan(Integer value) {
            addCriterion("month_hot <", value, "monthHot");
            return (Criteria) this;
        }

        public Criteria andMonthHotLessThanOrEqualTo(Integer value) {
            addCriterion("month_hot <=", value, "monthHot");
            return (Criteria) this;
        }

        public Criteria andMonthHotIn(List<Integer> values) {
            addCriterion("month_hot in", values, "monthHot");
            return (Criteria) this;
        }

        public Criteria andMonthHotNotIn(List<Integer> values) {
            addCriterion("month_hot not in", values, "monthHot");
            return (Criteria) this;
        }

        public Criteria andMonthHotBetween(Integer value1, Integer value2) {
            addCriterion("month_hot between", value1, value2, "monthHot");
            return (Criteria) this;
        }

        public Criteria andMonthHotNotBetween(Integer value1, Integer value2) {
            addCriterion("month_hot not between", value1, value2, "monthHot");
            return (Criteria) this;
        }

        public Criteria andYearHotIsNull() {
            addCriterion("year_hot is null");
            return (Criteria) this;
        }

        public Criteria andYearHotIsNotNull() {
            addCriterion("year_hot is not null");
            return (Criteria) this;
        }

        public Criteria andYearHotEqualTo(Integer value) {
            addCriterion("year_hot =", value, "yearHot");
            return (Criteria) this;
        }

        public Criteria andYearHotNotEqualTo(Integer value) {
            addCriterion("year_hot <>", value, "yearHot");
            return (Criteria) this;
        }

        public Criteria andYearHotGreaterThan(Integer value) {
            addCriterion("year_hot >", value, "yearHot");
            return (Criteria) this;
        }

        public Criteria andYearHotGreaterThanOrEqualTo(Integer value) {
            addCriterion("year_hot >=", value, "yearHot");
            return (Criteria) this;
        }

        public Criteria andYearHotLessThan(Integer value) {
            addCriterion("year_hot <", value, "yearHot");
            return (Criteria) this;
        }

        public Criteria andYearHotLessThanOrEqualTo(Integer value) {
            addCriterion("year_hot <=", value, "yearHot");
            return (Criteria) this;
        }

        public Criteria andYearHotIn(List<Integer> values) {
            addCriterion("year_hot in", values, "yearHot");
            return (Criteria) this;
        }

        public Criteria andYearHotNotIn(List<Integer> values) {
            addCriterion("year_hot not in", values, "yearHot");
            return (Criteria) this;
        }

        public Criteria andYearHotBetween(Integer value1, Integer value2) {
            addCriterion("year_hot between", value1, value2, "yearHot");
            return (Criteria) this;
        }

        public Criteria andYearHotNotBetween(Integer value1, Integer value2) {
            addCriterion("year_hot not between", value1, value2, "yearHot");
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
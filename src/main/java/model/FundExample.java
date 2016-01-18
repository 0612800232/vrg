package model;

import java.util.ArrayList;
import java.util.List;

public class FundExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FundExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFundAccountIsNull() {
            addCriterion("fund_account is null");
            return (Criteria) this;
        }

        public Criteria andFundAccountIsNotNull() {
            addCriterion("fund_account is not null");
            return (Criteria) this;
        }

        public Criteria andFundAccountEqualTo(String value) {
            addCriterion("fund_account =", value, "fundAccount");
            return (Criteria) this;
        }

        public Criteria andFundAccountNotEqualTo(String value) {
            addCriterion("fund_account <>", value, "fundAccount");
            return (Criteria) this;
        }

        public Criteria andFundAccountGreaterThan(String value) {
            addCriterion("fund_account >", value, "fundAccount");
            return (Criteria) this;
        }

        public Criteria andFundAccountGreaterThanOrEqualTo(String value) {
            addCriterion("fund_account >=", value, "fundAccount");
            return (Criteria) this;
        }

        public Criteria andFundAccountLessThan(String value) {
            addCriterion("fund_account <", value, "fundAccount");
            return (Criteria) this;
        }

        public Criteria andFundAccountLessThanOrEqualTo(String value) {
            addCriterion("fund_account <=", value, "fundAccount");
            return (Criteria) this;
        }

        public Criteria andFundAccountLike(String value) {
            addCriterion("fund_account like", value, "fundAccount");
            return (Criteria) this;
        }

        public Criteria andFundAccountNotLike(String value) {
            addCriterion("fund_account not like", value, "fundAccount");
            return (Criteria) this;
        }

        public Criteria andFundAccountIn(List<String> values) {
            addCriterion("fund_account in", values, "fundAccount");
            return (Criteria) this;
        }

        public Criteria andFundAccountNotIn(List<String> values) {
            addCriterion("fund_account not in", values, "fundAccount");
            return (Criteria) this;
        }

        public Criteria andFundAccountBetween(String value1, String value2) {
            addCriterion("fund_account between", value1, value2, "fundAccount");
            return (Criteria) this;
        }

        public Criteria andFundAccountNotBetween(String value1, String value2) {
            addCriterion("fund_account not between", value1, value2, "fundAccount");
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

        public Criteria andAssetBalanceIsNull() {
            addCriterion("asset_balance is null");
            return (Criteria) this;
        }

        public Criteria andAssetBalanceIsNotNull() {
            addCriterion("asset_balance is not null");
            return (Criteria) this;
        }

        public Criteria andAssetBalanceEqualTo(Long value) {
            addCriterion("asset_balance =", value, "assetBalance");
            return (Criteria) this;
        }

        public Criteria andAssetBalanceNotEqualTo(Long value) {
            addCriterion("asset_balance <>", value, "assetBalance");
            return (Criteria) this;
        }

        public Criteria andAssetBalanceGreaterThan(Long value) {
            addCriterion("asset_balance >", value, "assetBalance");
            return (Criteria) this;
        }

        public Criteria andAssetBalanceGreaterThanOrEqualTo(Long value) {
            addCriterion("asset_balance >=", value, "assetBalance");
            return (Criteria) this;
        }

        public Criteria andAssetBalanceLessThan(Long value) {
            addCriterion("asset_balance <", value, "assetBalance");
            return (Criteria) this;
        }

        public Criteria andAssetBalanceLessThanOrEqualTo(Long value) {
            addCriterion("asset_balance <=", value, "assetBalance");
            return (Criteria) this;
        }

        public Criteria andAssetBalanceIn(List<Long> values) {
            addCriterion("asset_balance in", values, "assetBalance");
            return (Criteria) this;
        }

        public Criteria andAssetBalanceNotIn(List<Long> values) {
            addCriterion("asset_balance not in", values, "assetBalance");
            return (Criteria) this;
        }

        public Criteria andAssetBalanceBetween(Long value1, Long value2) {
            addCriterion("asset_balance between", value1, value2, "assetBalance");
            return (Criteria) this;
        }

        public Criteria andAssetBalanceNotBetween(Long value1, Long value2) {
            addCriterion("asset_balance not between", value1, value2, "assetBalance");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceIsNull() {
            addCriterion("current_balance is null");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceIsNotNull() {
            addCriterion("current_balance is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceEqualTo(Long value) {
            addCriterion("current_balance =", value, "currentBalance");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceNotEqualTo(Long value) {
            addCriterion("current_balance <>", value, "currentBalance");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceGreaterThan(Long value) {
            addCriterion("current_balance >", value, "currentBalance");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceGreaterThanOrEqualTo(Long value) {
            addCriterion("current_balance >=", value, "currentBalance");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceLessThan(Long value) {
            addCriterion("current_balance <", value, "currentBalance");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceLessThanOrEqualTo(Long value) {
            addCriterion("current_balance <=", value, "currentBalance");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceIn(List<Long> values) {
            addCriterion("current_balance in", values, "currentBalance");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceNotIn(List<Long> values) {
            addCriterion("current_balance not in", values, "currentBalance");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceBetween(Long value1, Long value2) {
            addCriterion("current_balance between", value1, value2, "currentBalance");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceNotBetween(Long value1, Long value2) {
            addCriterion("current_balance not between", value1, value2, "currentBalance");
            return (Criteria) this;
        }

        public Criteria andEnableBalanceIsNull() {
            addCriterion("enable_balance is null");
            return (Criteria) this;
        }

        public Criteria andEnableBalanceIsNotNull() {
            addCriterion("enable_balance is not null");
            return (Criteria) this;
        }

        public Criteria andEnableBalanceEqualTo(Long value) {
            addCriterion("enable_balance =", value, "enableBalance");
            return (Criteria) this;
        }

        public Criteria andEnableBalanceNotEqualTo(Long value) {
            addCriterion("enable_balance <>", value, "enableBalance");
            return (Criteria) this;
        }

        public Criteria andEnableBalanceGreaterThan(Long value) {
            addCriterion("enable_balance >", value, "enableBalance");
            return (Criteria) this;
        }

        public Criteria andEnableBalanceGreaterThanOrEqualTo(Long value) {
            addCriterion("enable_balance >=", value, "enableBalance");
            return (Criteria) this;
        }

        public Criteria andEnableBalanceLessThan(Long value) {
            addCriterion("enable_balance <", value, "enableBalance");
            return (Criteria) this;
        }

        public Criteria andEnableBalanceLessThanOrEqualTo(Long value) {
            addCriterion("enable_balance <=", value, "enableBalance");
            return (Criteria) this;
        }

        public Criteria andEnableBalanceIn(List<Long> values) {
            addCriterion("enable_balance in", values, "enableBalance");
            return (Criteria) this;
        }

        public Criteria andEnableBalanceNotIn(List<Long> values) {
            addCriterion("enable_balance not in", values, "enableBalance");
            return (Criteria) this;
        }

        public Criteria andEnableBalanceBetween(Long value1, Long value2) {
            addCriterion("enable_balance between", value1, value2, "enableBalance");
            return (Criteria) this;
        }

        public Criteria andEnableBalanceNotBetween(Long value1, Long value2) {
            addCriterion("enable_balance not between", value1, value2, "enableBalance");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeIsNull() {
            addCriterion("money_type is null");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeIsNotNull() {
            addCriterion("money_type is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeEqualTo(String value) {
            addCriterion("money_type =", value, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeNotEqualTo(String value) {
            addCriterion("money_type <>", value, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeGreaterThan(String value) {
            addCriterion("money_type >", value, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("money_type >=", value, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeLessThan(String value) {
            addCriterion("money_type <", value, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeLessThanOrEqualTo(String value) {
            addCriterion("money_type <=", value, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeLike(String value) {
            addCriterion("money_type like", value, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeNotLike(String value) {
            addCriterion("money_type not like", value, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeIn(List<String> values) {
            addCriterion("money_type in", values, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeNotIn(List<String> values) {
            addCriterion("money_type not in", values, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeBetween(String value1, String value2) {
            addCriterion("money_type between", value1, value2, "moneyType");
            return (Criteria) this;
        }

        public Criteria andMoneyTypeNotBetween(String value1, String value2) {
            addCriterion("money_type not between", value1, value2, "moneyType");
            return (Criteria) this;
        }

        public Criteria andFetchBalanceIsNull() {
            addCriterion("fetch_balance is null");
            return (Criteria) this;
        }

        public Criteria andFetchBalanceIsNotNull() {
            addCriterion("fetch_balance is not null");
            return (Criteria) this;
        }

        public Criteria andFetchBalanceEqualTo(Long value) {
            addCriterion("fetch_balance =", value, "fetchBalance");
            return (Criteria) this;
        }

        public Criteria andFetchBalanceNotEqualTo(Long value) {
            addCriterion("fetch_balance <>", value, "fetchBalance");
            return (Criteria) this;
        }

        public Criteria andFetchBalanceGreaterThan(Long value) {
            addCriterion("fetch_balance >", value, "fetchBalance");
            return (Criteria) this;
        }

        public Criteria andFetchBalanceGreaterThanOrEqualTo(Long value) {
            addCriterion("fetch_balance >=", value, "fetchBalance");
            return (Criteria) this;
        }

        public Criteria andFetchBalanceLessThan(Long value) {
            addCriterion("fetch_balance <", value, "fetchBalance");
            return (Criteria) this;
        }

        public Criteria andFetchBalanceLessThanOrEqualTo(Long value) {
            addCriterion("fetch_balance <=", value, "fetchBalance");
            return (Criteria) this;
        }

        public Criteria andFetchBalanceIn(List<Long> values) {
            addCriterion("fetch_balance in", values, "fetchBalance");
            return (Criteria) this;
        }

        public Criteria andFetchBalanceNotIn(List<Long> values) {
            addCriterion("fetch_balance not in", values, "fetchBalance");
            return (Criteria) this;
        }

        public Criteria andFetchBalanceBetween(Long value1, Long value2) {
            addCriterion("fetch_balance between", value1, value2, "fetchBalance");
            return (Criteria) this;
        }

        public Criteria andFetchBalanceNotBetween(Long value1, Long value2) {
            addCriterion("fetch_balance not between", value1, value2, "fetchBalance");
            return (Criteria) this;
        }

        public Criteria andForzenBalanceIsNull() {
            addCriterion("forzen_balance is null");
            return (Criteria) this;
        }

        public Criteria andForzenBalanceIsNotNull() {
            addCriterion("forzen_balance is not null");
            return (Criteria) this;
        }

        public Criteria andForzenBalanceEqualTo(Long value) {
            addCriterion("forzen_balance =", value, "forzenBalance");
            return (Criteria) this;
        }

        public Criteria andForzenBalanceNotEqualTo(Long value) {
            addCriterion("forzen_balance <>", value, "forzenBalance");
            return (Criteria) this;
        }

        public Criteria andForzenBalanceGreaterThan(Long value) {
            addCriterion("forzen_balance >", value, "forzenBalance");
            return (Criteria) this;
        }

        public Criteria andForzenBalanceGreaterThanOrEqualTo(Long value) {
            addCriterion("forzen_balance >=", value, "forzenBalance");
            return (Criteria) this;
        }

        public Criteria andForzenBalanceLessThan(Long value) {
            addCriterion("forzen_balance <", value, "forzenBalance");
            return (Criteria) this;
        }

        public Criteria andForzenBalanceLessThanOrEqualTo(Long value) {
            addCriterion("forzen_balance <=", value, "forzenBalance");
            return (Criteria) this;
        }

        public Criteria andForzenBalanceIn(List<Long> values) {
            addCriterion("forzen_balance in", values, "forzenBalance");
            return (Criteria) this;
        }

        public Criteria andForzenBalanceNotIn(List<Long> values) {
            addCriterion("forzen_balance not in", values, "forzenBalance");
            return (Criteria) this;
        }

        public Criteria andForzenBalanceBetween(Long value1, Long value2) {
            addCriterion("forzen_balance between", value1, value2, "forzenBalance");
            return (Criteria) this;
        }

        public Criteria andForzenBalanceNotBetween(Long value1, Long value2) {
            addCriterion("forzen_balance not between", value1, value2, "forzenBalance");
            return (Criteria) this;
        }

        public Criteria andTradeDateIsNull() {
            addCriterion("trade_date is null");
            return (Criteria) this;
        }

        public Criteria andTradeDateIsNotNull() {
            addCriterion("trade_date is not null");
            return (Criteria) this;
        }

        public Criteria andTradeDateEqualTo(Long value) {
            addCriterion("trade_date =", value, "tradeDate");
            return (Criteria) this;
        }

        public Criteria andTradeDateNotEqualTo(Long value) {
            addCriterion("trade_date <>", value, "tradeDate");
            return (Criteria) this;
        }

        public Criteria andTradeDateGreaterThan(Long value) {
            addCriterion("trade_date >", value, "tradeDate");
            return (Criteria) this;
        }

        public Criteria andTradeDateGreaterThanOrEqualTo(Long value) {
            addCriterion("trade_date >=", value, "tradeDate");
            return (Criteria) this;
        }

        public Criteria andTradeDateLessThan(Long value) {
            addCriterion("trade_date <", value, "tradeDate");
            return (Criteria) this;
        }

        public Criteria andTradeDateLessThanOrEqualTo(Long value) {
            addCriterion("trade_date <=", value, "tradeDate");
            return (Criteria) this;
        }

        public Criteria andTradeDateIn(List<Long> values) {
            addCriterion("trade_date in", values, "tradeDate");
            return (Criteria) this;
        }

        public Criteria andTradeDateNotIn(List<Long> values) {
            addCriterion("trade_date not in", values, "tradeDate");
            return (Criteria) this;
        }

        public Criteria andTradeDateBetween(Long value1, Long value2) {
            addCriterion("trade_date between", value1, value2, "tradeDate");
            return (Criteria) this;
        }

        public Criteria andTradeDateNotBetween(Long value1, Long value2) {
            addCriterion("trade_date not between", value1, value2, "tradeDate");
            return (Criteria) this;
        }

        public Criteria andItnBrokerIdIsNull() {
            addCriterion("itn_broker_id is null");
            return (Criteria) this;
        }

        public Criteria andItnBrokerIdIsNotNull() {
            addCriterion("itn_broker_id is not null");
            return (Criteria) this;
        }

        public Criteria andItnBrokerIdEqualTo(String value) {
            addCriterion("itn_broker_id =", value, "itnBrokerId");
            return (Criteria) this;
        }

        public Criteria andItnBrokerIdNotEqualTo(String value) {
            addCriterion("itn_broker_id <>", value, "itnBrokerId");
            return (Criteria) this;
        }

        public Criteria andItnBrokerIdGreaterThan(String value) {
            addCriterion("itn_broker_id >", value, "itnBrokerId");
            return (Criteria) this;
        }

        public Criteria andItnBrokerIdGreaterThanOrEqualTo(String value) {
            addCriterion("itn_broker_id >=", value, "itnBrokerId");
            return (Criteria) this;
        }

        public Criteria andItnBrokerIdLessThan(String value) {
            addCriterion("itn_broker_id <", value, "itnBrokerId");
            return (Criteria) this;
        }

        public Criteria andItnBrokerIdLessThanOrEqualTo(String value) {
            addCriterion("itn_broker_id <=", value, "itnBrokerId");
            return (Criteria) this;
        }

        public Criteria andItnBrokerIdLike(String value) {
            addCriterion("itn_broker_id like", value, "itnBrokerId");
            return (Criteria) this;
        }

        public Criteria andItnBrokerIdNotLike(String value) {
            addCriterion("itn_broker_id not like", value, "itnBrokerId");
            return (Criteria) this;
        }

        public Criteria andItnBrokerIdIn(List<String> values) {
            addCriterion("itn_broker_id in", values, "itnBrokerId");
            return (Criteria) this;
        }

        public Criteria andItnBrokerIdNotIn(List<String> values) {
            addCriterion("itn_broker_id not in", values, "itnBrokerId");
            return (Criteria) this;
        }

        public Criteria andItnBrokerIdBetween(String value1, String value2) {
            addCriterion("itn_broker_id between", value1, value2, "itnBrokerId");
            return (Criteria) this;
        }

        public Criteria andItnBrokerIdNotBetween(String value1, String value2) {
            addCriterion("itn_broker_id not between", value1, value2, "itnBrokerId");
            return (Criteria) this;
        }

        public Criteria andUndeliveryBalanceIsNull() {
            addCriterion("undelivery_balance is null");
            return (Criteria) this;
        }

        public Criteria andUndeliveryBalanceIsNotNull() {
            addCriterion("undelivery_balance is not null");
            return (Criteria) this;
        }

        public Criteria andUndeliveryBalanceEqualTo(Long value) {
            addCriterion("undelivery_balance =", value, "undeliveryBalance");
            return (Criteria) this;
        }

        public Criteria andUndeliveryBalanceNotEqualTo(Long value) {
            addCriterion("undelivery_balance <>", value, "undeliveryBalance");
            return (Criteria) this;
        }

        public Criteria andUndeliveryBalanceGreaterThan(Long value) {
            addCriterion("undelivery_balance >", value, "undeliveryBalance");
            return (Criteria) this;
        }

        public Criteria andUndeliveryBalanceGreaterThanOrEqualTo(Long value) {
            addCriterion("undelivery_balance >=", value, "undeliveryBalance");
            return (Criteria) this;
        }

        public Criteria andUndeliveryBalanceLessThan(Long value) {
            addCriterion("undelivery_balance <", value, "undeliveryBalance");
            return (Criteria) this;
        }

        public Criteria andUndeliveryBalanceLessThanOrEqualTo(Long value) {
            addCriterion("undelivery_balance <=", value, "undeliveryBalance");
            return (Criteria) this;
        }

        public Criteria andUndeliveryBalanceIn(List<Long> values) {
            addCriterion("undelivery_balance in", values, "undeliveryBalance");
            return (Criteria) this;
        }

        public Criteria andUndeliveryBalanceNotIn(List<Long> values) {
            addCriterion("undelivery_balance not in", values, "undeliveryBalance");
            return (Criteria) this;
        }

        public Criteria andUndeliveryBalanceBetween(Long value1, Long value2) {
            addCriterion("undelivery_balance between", value1, value2, "undeliveryBalance");
            return (Criteria) this;
        }

        public Criteria andUndeliveryBalanceNotBetween(Long value1, Long value2) {
            addCriterion("undelivery_balance not between", value1, value2, "undeliveryBalance");
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
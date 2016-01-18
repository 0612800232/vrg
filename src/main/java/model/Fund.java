package model;

public class Fund {
    private Long id;

    private String fundAccount;

    private String password;

    private Long assetBalance;

    private Long currentBalance;

    private Long enableBalance;

    private String moneyType;

    private Long fetchBalance;

    private Long forzenBalance;

    private Long tradeDate;

    private String itnBrokerId;

    private Long undeliveryBalance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFundAccount() {
        return fundAccount;
    }

    public void setFundAccount(String fundAccount) {
        this.fundAccount = fundAccount == null ? null : fundAccount.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Long getAssetBalance() {
        return assetBalance;
    }

    public void setAssetBalance(Long assetBalance) {
        this.assetBalance = assetBalance;
    }

    public Long getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Long currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Long getEnableBalance() {
        return enableBalance;
    }

    public void setEnableBalance(Long enableBalance) {
        this.enableBalance = enableBalance;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType == null ? null : moneyType.trim();
    }

    public Long getFetchBalance() {
        return fetchBalance;
    }

    public void setFetchBalance(Long fetchBalance) {
        this.fetchBalance = fetchBalance;
    }

    public Long getForzenBalance() {
        return forzenBalance;
    }

    public void setForzenBalance(Long forzenBalance) {
        this.forzenBalance = forzenBalance;
    }

    public Long getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Long tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getItnBrokerId() {
        return itnBrokerId;
    }

    public void setItnBrokerId(String itnBrokerId) {
        this.itnBrokerId = itnBrokerId == null ? null : itnBrokerId.trim();
    }

    public Long getUndeliveryBalance() {
        return undeliveryBalance;
    }

    public void setUndeliveryBalance(Long undeliveryBalance) {
        this.undeliveryBalance = undeliveryBalance;
    }
}
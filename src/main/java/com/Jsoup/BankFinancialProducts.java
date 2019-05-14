package com.Jsoup;

import java.io.Serializable;

/**
 * bank_financial_products
 * @author
 */
public class BankFinancialProducts implements Serializable {
    private Integer id;

    /**
     * 银行名称
     */
    private String bankName;
    /**
     * 产品名称
     */
    private String productName;

    /**
     * 收益率
     */
    private String yieldRate;

    /**
     * 起止时间
     */
    private String during;

    /**
     * 期限
     */
    private String timeLimit;

    /**
     * 起购金额
     */
    private String purchaseAmount;



    /**
     * 风险
     */
    private String risk;

    /**
     * 链接
     */
    private String url;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getYieldRate() {
        return yieldRate;
    }

    public void setYieldRate(String yieldRate) {
        this.yieldRate = yieldRate;
    }

    public String getDuring() {
        return during;
    }

    public void setDuring(String during) {
        this.during = during;
    }

    public String getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(String purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BankFinancialProducts(String bankName, String productName, String yieldRate, String during, String timeLimit, String purchaseAmount, String risk, String url) {

        this.bankName = bankName;
        this.productName = productName;
        this.yieldRate = yieldRate;
        this.during = during;
        this.timeLimit = timeLimit;
        this.purchaseAmount = purchaseAmount;
        this.risk = risk;
        this.url = url;
    }

    public BankFinancialProducts(String bankName, String productName, String url){
        this.bankName=bankName;
        this.productName=productName;
        this.url=url;
    }
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BankFinancialProducts other = (BankFinancialProducts) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBankName() == null ? other.getBankName() == null : this.getBankName().equals(other.getBankName()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getYieldRate() == null ? other.getYieldRate() == null : this.getYieldRate().equals(other.getYieldRate()))
            && (this.getDuring() == null ? other.getDuring() == null : this.getDuring().equals(other.getDuring()))
            && (this.getTimeLimit() == null ? other.getTimeLimit() == null : this.getTimeLimit().equals(other.getTimeLimit()))
            && (this.getPurchaseAmount() == null ? other.getPurchaseAmount() == null : this.getPurchaseAmount().equals(other.getPurchaseAmount()))
            && (this.getRisk() == null ? other.getRisk() == null : this.getRisk().equals(other.getRisk()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBankName() == null) ? 0 : getBankName().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getYieldRate() == null) ? 0 : getYieldRate().hashCode());
        result = prime * result + ((getDuring() == null) ? 0 : getDuring().hashCode());
        result = prime * result + ((getTimeLimit() == null) ? 0 : getTimeLimit().hashCode());
        result = prime * result + ((getPurchaseAmount() == null) ? 0 : getPurchaseAmount().hashCode());
        result = prime * result + ((getRisk() == null) ? 0 : getRisk().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", bankName=").append(bankName);
        sb.append(", productName=").append(productName);
        sb.append(", yieldRate=").append(yieldRate);
        sb.append(", during=").append(during);
        sb.append(", timeLimit=").append(timeLimit);
        sb.append(", purchaseAmount=").append(purchaseAmount);
        sb.append(", risk=").append(risk);
        sb.append(", url=").append(url);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

}
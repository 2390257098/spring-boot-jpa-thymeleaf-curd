package com.demo.other;

import java.util.List;

/**
 * @Desc
 * @Author 刘慧斌
 * @CreateTime 2019-04-25 22:51
 **/
public class BankInfo2 {
    private int result;
    private int totalRecord;
    private int totalPage;
    private List<Product2> list;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<Product2> getList() {
        return list;
    }

    public void setList(List<Product2> list) {
        this.list = list;
    }

    public class Product2{
        private String Status;
        private String SaleChannelName;
        private String IsCanBuy;
        private String ExpireDate;
        private String TypeCode;
        private String InitMoney;
        private String REGCode;
        private String Risk;
        private String IncresingMoney;
        private String Term;
        private String PrdName;
        private String CapitalProtectName;
        private String EndDate;
        private String BeginDate;
        private String SaleChannel;
        private String PrdCode;
        private String FinDate;
        private String Currency;
        private String NetValue;
        private String AreaCode;
        private String Style;
        private String IsNewFlag;

        public String getStatus() {
            return Status;
        }

        public void setStatus(String status) {
            Status = status;
        }

        public String getSaleChannelName() {
            return SaleChannelName;
        }

        public void setSaleChannelName(String saleChannelName) {
            SaleChannelName = saleChannelName;
        }

        public String getIsCanBuy() {
            return IsCanBuy;
        }

        public void setIsCanBuy(String isCanBuy) {
            IsCanBuy = isCanBuy;
        }

        public String getExpireDate() {
            return ExpireDate;
        }

        public void setExpireDate(String expireDate) {
            ExpireDate = expireDate;
        }

        public String getTypeCode() {
            return TypeCode;
        }

        public void setTypeCode(String typeCode) {
            TypeCode = typeCode;
        }

        public String getInitMoney() {
            return InitMoney;
        }

        public void setInitMoney(String initMoney) {
            InitMoney = initMoney;
        }

        public String getREGCode() {
            return REGCode;
        }

        public void setREGCode(String REGCode) {
            this.REGCode = REGCode;
        }

        public String getRisk() {
            return Risk;
        }

        public void setRisk(String risk) {
            Risk = risk;
        }

        public String getIncresingMoney() {
            return IncresingMoney;
        }

        public void setIncresingMoney(String incresingMoney) {
            IncresingMoney = incresingMoney;
        }

        public String getTerm() {
            return Term;
        }

        public void setTerm(String term) {
            Term = term;
        }

        public String getPrdName() {
            return PrdName;
        }

        public void setPrdName(String prdName) {
            PrdName = prdName;
        }

        public String getCapitalProtectName() {
            return CapitalProtectName;
        }

        public void setCapitalProtectName(String capitalProtectName) {
            CapitalProtectName = capitalProtectName;
        }

        public String getEndDate() {
            return EndDate;
        }

        public void setEndDate(String endDate) {
            EndDate = endDate;
        }

        public String getBeginDate() {
            return BeginDate;
        }

        public void setBeginDate(String beginDate) {
            BeginDate = beginDate;
        }

        public String getSaleChannel() {
            return SaleChannel;
        }

        public void setSaleChannel(String saleChannel) {
            SaleChannel = saleChannel;
        }

        public String getPrdCode() {
            return PrdCode;
        }

        public void setPrdCode(String prdCode) {
            PrdCode = prdCode;
        }

        public String getFinDate() {
            return FinDate;
        }

        public void setFinDate(String finDate) {
            FinDate = finDate;
        }

        public String getCurrency() {
            return Currency;
        }

        public void setCurrency(String currency) {
            Currency = currency;
        }

        public String getNetValue() {
            return NetValue;
        }

        public void setNetValue(String netValue) {
            NetValue = netValue;
        }

        public String getAreaCode() {
            return AreaCode;
        }

        public void setAreaCode(String areaCode) {
            AreaCode = areaCode;
        }

        public String getStyle() {
            return Style;
        }

        public void setStyle(String style) {
            Style = style;
        }

        public String getIsNewFlag() {
            return IsNewFlag;
        }

        public void setIsNewFlag(String isNewFlag) {
            IsNewFlag = isNewFlag;
        }
    }
}

package com.demo.other;
//实体类-------包含IP，端口，类型
public class IPBean {

    public class Product2{
        private Object PrdCode;
        private Object PrdName;
        private Object TypeCode;
        private Object AreaCode;
        private Object Currency;
        private Object BeginDate;
        private Object EndDate;
        private Object ExpireDate;
        private Object Status;
        private Object NetValue;
        private Object IsNewFlag;
        private Object Term;
        private Object Style;
        private Object InitMoney;
        private Object IncresingMoney;
        private Object Risk;
        private Object FinDate;
        private Object SaleChannel;
        private Object SaleChannelName;
        private Object IsCanBuy;
        private Object REGCode;
        private Object CapitalProtectName;

        public Object getPrdCode() {
            return PrdCode;
        }

        public void setPrdCode(Object prdCode) {
            PrdCode = prdCode;
        }

        public Object getPrdName() {
            return PrdName;
        }

        public void setPrdName(Object prdName) {
            PrdName = prdName;
        }

        public Object getTypeCode() {
            return TypeCode;
        }

        public void setTypeCode(Object typeCode) {
            TypeCode = typeCode;
        }

        public Object getAreaCode() {
            return AreaCode;
        }

        public void setAreaCode(Object areaCode) {
            AreaCode = areaCode;
        }

        public Object getCurrency() {
            return Currency;
        }

        public void setCurrency(Object currency) {
            Currency = currency;
        }

        public Object getBeginDate() {
            return BeginDate;
        }

        public void setBeginDate(Object beginDate) {
            BeginDate = beginDate;
        }

        public Object getEndDate() {
            return EndDate;
        }

        public void setEndDate(Object endDate) {
            EndDate = endDate;
        }

        public Object getExpireDate() {
            return ExpireDate;
        }

        public void setExpireDate(Object expireDate) {
            ExpireDate = expireDate;
        }

        public Object getStatus() {
            return Status;
        }

        public void setStatus(Object status) {
            Status = status;
        }

        public Object getNetValue() {
            return NetValue;
        }

        public void setNetValue(Object netValue) {
            NetValue = netValue;
        }

        public Object getIsNewFlag() {
            return IsNewFlag;
        }

        public void setIsNewFlag(Object isNewFlag) {
            IsNewFlag = isNewFlag;
        }

        public Object getTerm() {
            return Term;
        }

        public void setTerm(Object term) {
            Term = term;
        }

        public Object getStyle() {
            return Style;
        }

        public void setStyle(Object style) {
            Style = style;
        }

        public Object getInitMoney() {
            return InitMoney;
        }

        public void setInitMoney(Object initMoney) {
            InitMoney = initMoney;
        }

        public Object getIncresingMoney() {
            return IncresingMoney;
        }

        public void setIncresingMoney(Object incresingMoney) {
            IncresingMoney = incresingMoney;
        }

        public Object getRisk() {
            return Risk;
        }

        public void setRisk(Object risk) {
            Risk = risk;
        }

        public Object getFinDate() {
            return FinDate;
        }

        public void setFinDate(Object finDate) {
            FinDate = finDate;
        }

        public Object getSaleChannel() {
            return SaleChannel;
        }

        public void setSaleChannel(Object saleChannel) {
            SaleChannel = saleChannel;
        }

        public Object getSaleChannelName() {
            return SaleChannelName;
        }

        public void setSaleChannelName(Object saleChannelName) {
            SaleChannelName = saleChannelName;
        }

        public Object getIsCanBuy() {
            return IsCanBuy;
        }

        public void setIsCanBuy(Object isCanBuy) {
            IsCanBuy = isCanBuy;
        }

        public Object getREGCode() {
            return REGCode;
        }

        public void setREGCode(Object REGCode) {
            this.REGCode = REGCode;
        }

        public Object getCapitalProtectName() {
            return CapitalProtectName;
        }

        public void setCapitalProtectName(Object capitalProtectName) {
            CapitalProtectName = capitalProtectName;
        }
    }


    public static final int TYPE_HTTP = 0;
    public static final int TYPE_HTTPS = 1;

    private String ip;
    private int port;
    private int type;

    public IPBean(){}

    public IPBean(IPBean bean){
        ip = bean.getIp();
        port = bean.getPort();
        type = bean.getType();
    }

    public IPBean(String ip, int port, int type) {
        this.ip = ip;
        this.port = port;
        this.type = type;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

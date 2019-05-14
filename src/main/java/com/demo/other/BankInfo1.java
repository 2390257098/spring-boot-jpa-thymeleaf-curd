package com.demo.other;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Desc
 * @Author 刘慧斌
 * @CreateTime 2019-04-25 22:36
 **/
public class BankInfo1 {
    private int totalCount;
    private int pageNo;
    private int pageSize;
    private List<Product> ProdList;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<Product> getProdList() {
        return ProdList;
    }

    public void setProdList(List<Product> prodList) {
        ProdList = prodList;
    }

    public class Product{
        private Object name;
        private Object code;
        private Object brand;
        private Object collBgnDate;
        private Object collEndDate;
        private Object yieldRate;
        private Object investBgnDate;
        private Object investEndDate;
        private Object investPeriod;
        private Object purFloorAmt;
        private Object currencyType;
        private Object riskLevel;
        private Object provinceId;
        private Object allOrgFlag;
        private Object channel;
        private Object proMode;
        private Object yieldSpec;
        private Object saleStatus;
        private Object reserveBgnTime;
        private Object reserveEgnTime;
        private Object instructionUrl;
        private Object pubNoticeUrl;
        private Object pdType;
        private Object purStepAmt;
        private Object ext1;
        private Object ext2;
        private Object ext3;
        private Object isCcbcomPro;
        private Object isNetvalPro;
        private Object netval;
        private Object netvalDate;
        private Object dcrIndex;
        private Object hotStatus;
        private Object validateDate;
        private Object invalidateDate;
        private Object channel_sig;
        private Object hot_stauts;
        private Object yieldRateStart;
        private Object yieldRateEnd;
        private Object investPeriodStart;
        private Object investPeriodEnd;

        public Object getName() {
            return name;
        }

        public void setName(Object name) {
            this.name = name;
        }

        public Object getCode() {
            return code;
        }

        public void setCode(Object code) {
            this.code = code;
        }

        public Object getBrand() {
            return brand;
        }

        public void setBrand(Object brand) {
            this.brand = brand;
        }

        public Object getYieldRate() {
            return yieldRate;
        }

        public void setYieldRate(Object yieldRate) {
            this.yieldRate = yieldRate;
        }

        public Object getInvestPeriod() {
            return investPeriod;
        }

        public void setInvestPeriod(Object investPeriod) {
            this.investPeriod = investPeriod;
        }

        public Object getPurFloorAmt() {
            return purFloorAmt;
        }

        public void setPurFloorAmt(Object purFloorAmt) {
            this.purFloorAmt = purFloorAmt;
        }

        public Object getCurrencyType() {
            return currencyType;
        }

        public void setCurrencyType(Object currencyType) {
            this.currencyType = currencyType;
        }

        public Object getRiskLevel() {
            return riskLevel;
        }

        public void setRiskLevel(Object riskLevel) {
            this.riskLevel = riskLevel;
        }

        public Object getProvinceId() {
            return provinceId;
        }

        public void setProvinceId(Object provinceId) {
            this.provinceId = provinceId;
        }

        public Object getAllOrgFlag() {
            return allOrgFlag;
        }

        public void setAllOrgFlag(Object allOrgFlag) {
            this.allOrgFlag = allOrgFlag;
        }

        public Object getChannel() {
            return channel;
        }

        public void setChannel(Object channel) {
            this.channel = channel;
        }

        public Object getProMode() {
            return proMode;
        }

        public void setProMode(Object proMode) {
            this.proMode = proMode;
        }

        public Object getYieldSpec() {
            return yieldSpec;
        }

        public void setYieldSpec(Object yieldSpec) {
            this.yieldSpec = yieldSpec;
        }

        public Object getSaleStatus() {
            return saleStatus;
        }

        public void setSaleStatus(Object saleStatus) {
            this.saleStatus = saleStatus;
        }

        public Object getInstructionUrl() {
            return instructionUrl;
        }

        public void setInstructionUrl(Object instructionUrl) {
            this.instructionUrl = instructionUrl;
        }

        public Object getPubNoticeUrl() {
            return pubNoticeUrl;
        }

        public void setPubNoticeUrl(Object pubNoticeUrl) {
            this.pubNoticeUrl = pubNoticeUrl;
        }

        public Object getPdType() {
            return pdType;
        }

        public void setPdType(Object pdType) {
            this.pdType = pdType;
        }

        public Object getPurStepAmt() {
            return purStepAmt;
        }

        public void setPurStepAmt(Object purStepAmt) {
            this.purStepAmt = purStepAmt;
        }

        public Object getExt1() {
            return ext1;
        }

        public Object getIsCcbcomPro() {
            return isCcbcomPro;
        }

        public void setIsCcbcomPro(Object isCcbcomPro) {
            this.isCcbcomPro = isCcbcomPro;
        }

        public Object getCollBgnDate() {
            return collBgnDate;
        }

        public void setCollBgnDate(Object collBgnDate) {
            this.collBgnDate = collBgnDate;
        }

        public Object getCollEndDate() {
            return collEndDate;
        }

        public void setCollEndDate(Object collEndDate) {
            this.collEndDate = collEndDate;
        }



        public Object getInvestBgnDate() {
            return investBgnDate;
        }

        public void setInvestBgnDate(Object investBgnDate) {
            this.investBgnDate = investBgnDate;
        }

        public Object getInvestEndDate() {
            return investEndDate;
        }

        public void setInvestEndDate(Object investEndDate) {
            this.investEndDate = investEndDate;
        }



        public Object getReserveBgnTime() {
            return reserveBgnTime;
        }

        public void setReserveBgnTime(Object reserveBgnTime) {
            this.reserveBgnTime = reserveBgnTime;
        }

        public Object getReserveEgnTime() {
            return reserveEgnTime;
        }

        public void setReserveEgnTime(Object reserveEgnTime) {
            this.reserveEgnTime = reserveEgnTime;
        }



        public void setExt1(Object ext1) {
            this.ext1 = ext1;
        }

        public Object getExt2() {
            return ext2;
        }

        public void setExt2(Object ext2) {
            this.ext2 = ext2;
        }

        public Object getExt3() {
            return ext3;
        }

        public void setExt3(Object ext3) {
            this.ext3 = ext3;
        }



        public Object getIsNetvalPro() {
            return isNetvalPro;
        }

        public void setIsNetvalPro(Object isNetvalPro) {
            this.isNetvalPro = isNetvalPro;
        }

        public Object getNetval() {
            return netval;
        }

        public void setNetval(Object netval) {
            this.netval = netval;
        }

        public Object getNetvalDate() {
            return netvalDate;
        }

        public void setNetvalDate(Object netvalDate) {
            this.netvalDate = netvalDate;
        }

        public Object getDcrIndex() {
            return dcrIndex;
        }

        public void setDcrIndex(Object dcrIndex) {
            this.dcrIndex = dcrIndex;
        }

        public Object getHotStatus() {
            return hotStatus;
        }

        public void setHotStatus(Object hotStatus) {
            this.hotStatus = hotStatus;
        }

        public Object getValidateDate() {
            return validateDate;
        }

        public void setValidateDate(Object validateDate) {
            this.validateDate = validateDate;
        }

        public Object getInvalidateDate() {
            return invalidateDate;
        }

        public void setInvalidateDate(Object invalidateDate) {
            this.invalidateDate = invalidateDate;
        }

        public Object getChannel_sig() {
            return channel_sig;
        }

        public void setChannel_sig(Object channel_sig) {
            this.channel_sig = channel_sig;
        }

        public Object getHot_stauts() {
            return hot_stauts;
        }

        public void setHot_stauts(Object hot_stauts) {
            this.hot_stauts = hot_stauts;
        }

        public Object getYieldRateStart() {
            return yieldRateStart;
        }

        public void setYieldRateStart(Object yieldRateStart) {
            this.yieldRateStart = yieldRateStart;
        }

        public Object getYieldRateEnd() {
            return yieldRateEnd;
        }

        public void setYieldRateEnd(Object yieldRateEnd) {
            this.yieldRateEnd = yieldRateEnd;
        }

        public Object getInvestPeriodStart() {
            return investPeriodStart;
        }

        public void setInvestPeriodStart(Object investPeriodStart) {
            this.investPeriodStart = investPeriodStart;
        }

        public Object getInvestPeriodEnd() {
            return investPeriodEnd;
        }

        public void setInvestPeriodEnd(Object investPeriodEnd) {
            this.investPeriodEnd = investPeriodEnd;
        }
    }
}

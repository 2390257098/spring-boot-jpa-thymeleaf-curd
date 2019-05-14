package com.demo.other;

/**
 * @Desc
 * @Author 刘慧斌
 * @CreateTime 2019-04-25 17:26
 **/
public class Bank {
    private Object Data;

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }
    public class Table{
        private Object Table;

        public Object getTable() {
            return Table;
        }

        public void setTable(Object table) {
            Table = table;
        }

        public class BankProduct{
            private String ProductNo;
            private String ProdName;
            private String ProdClass;
            private String ProdLimit;
            private String ProdProfit;
            private String ProdYildType;
            private String PrdYildTypeOrder;
            private String ProdArea;
            private String szComDat;
            private String ProdSaleDate;
            private String IsCanBuy;
            private String PurStarAmo;
            private String RowNumber;

            public String getProductNo() {
                return ProductNo;
            }

            public void setProductNo(String productNo) {
                ProductNo = productNo;
            }

            public String getProdName() {
                return ProdName;
            }

            public void setProdName(String prodName) {
                ProdName = prodName;
            }

            public String getProdClass() {
                return ProdClass;
            }

            public void setProdClass(String prodClass) {
                ProdClass = prodClass;
            }

            public String getProdLimit() {
                return ProdLimit;
            }

            public void setProdLimit(String prodLimit) {
                ProdLimit = prodLimit;
            }

            public String getProdProfit() {
                return ProdProfit;
            }

            public void setProdProfit(String prodProfit) {
                ProdProfit = prodProfit;
            }

            public String getProdYildType() {
                return ProdYildType;
            }

            public void setProdYildType(String prodYildType) {
                ProdYildType = prodYildType;
            }

            public String getPrdYildTypeOrder() {
                return PrdYildTypeOrder;
            }

            public void setPrdYildTypeOrder(String prdYildTypeOrder) {
                PrdYildTypeOrder = prdYildTypeOrder;
            }

            public String getProdArea() {
                return ProdArea;
            }

            public void setProdArea(String prodArea) {
                ProdArea = prodArea;
            }

            public String getSzComDat() {
                return szComDat;
            }

            public void setSzComDat(String szComDat) {
                this.szComDat = szComDat;
            }

            public String getProdSaleDate() {
                return ProdSaleDate;
            }

            public void setProdSaleDate(String prodSaleDate) {
                ProdSaleDate = prodSaleDate;
            }

            public String getIsCanBuy() {
                return IsCanBuy;
            }

            public void setIsCanBuy(String isCanBuy) {
                IsCanBuy = isCanBuy;
            }

            public String getPurStarAmo() {
                return PurStarAmo;
            }

            public void setPurStarAmo(String purStarAmo) {
                PurStarAmo = purStarAmo;
            }

            public String getRowNumber() {
                return RowNumber;
            }

            public void setRowNumber(String rowNumber) {
                RowNumber = rowNumber;
            }
        }
    }
}

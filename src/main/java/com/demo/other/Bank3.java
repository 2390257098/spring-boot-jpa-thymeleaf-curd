package com.demo.other;

import java.util.List;

/**
 * @Desc
 * @Author 刘慧斌
 * @CreateTime 2019-04-28 10:41
 **/
public class Bank3 {
    private int total;
    private int pageSize;
    private int pageTotal;
    private List<Product3> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }

    public List<Product3> getRows() {
        return rows;
    }

    public void setRows(List<Product3> rows) {
        this.rows = rows;
    }

    public class Product3{
        private String finance_risklevel;
        private String finance_indi_ipominamnt;
        private String finance_ipoapp_flag;
        private String finance_indi_applminamnt;
        private String finance_lmttime_info;
        private String finance_type;
        private String finance_allname;
        private String finance_limittime;
        private String finance_ipo_enddate;
        private String finance_no;
        private String product_attr;
        private String finance_anticipate_rate;
        private String finance_state;
        private String docpuburl;
        private String finance_next_openday;

        public String getFinance_risklevel() {
            return finance_risklevel;
        }

        public void setFinance_risklevel(String finance_risklevel) {
            this.finance_risklevel = finance_risklevel;
        }

        public String getFinance_indi_ipominamnt() {
            return finance_indi_ipominamnt;
        }

        public void setFinance_indi_ipominamnt(String finance_indi_ipominamnt) {
            this.finance_indi_ipominamnt = finance_indi_ipominamnt;
        }

        public String getFinance_ipoapp_flag() {
            return finance_ipoapp_flag;
        }

        public void setFinance_ipoapp_flag(String finance_ipoapp_flag) {
            this.finance_ipoapp_flag = finance_ipoapp_flag;
        }

        public String getFinance_indi_applminamnt() {
            return finance_indi_applminamnt;
        }

        public void setFinance_indi_applminamnt(String finance_indi_applminamnt) {
            this.finance_indi_applminamnt = finance_indi_applminamnt;
        }

        public String getFinance_lmttime_info() {
            return finance_lmttime_info;
        }

        public void setFinance_lmttime_info(String finance_lmttime_info) {
            this.finance_lmttime_info = finance_lmttime_info;
        }

        public String getFinance_type() {
            return finance_type;
        }

        public void setFinance_type(String finance_type) {
            this.finance_type = finance_type;
        }

        public String getFinance_allname() {
            return finance_allname;
        }

        public void setFinance_allname(String finance_allname) {
            this.finance_allname = finance_allname;
        }

        public String getFinance_limittime() {
            return finance_limittime;
        }

        public void setFinance_limittime(String finance_limittime) {
            this.finance_limittime = finance_limittime;
        }

        public String getFinance_ipo_enddate() {
            return finance_ipo_enddate;
        }

        public void setFinance_ipo_enddate(String finance_ipo_enddate) {
            this.finance_ipo_enddate = finance_ipo_enddate;
        }

        public String getFinance_no() {
            return finance_no;
        }

        public void setFinance_no(String finance_no) {
            this.finance_no = finance_no;
        }

        public String getProduct_attr() {
            return product_attr;
        }

        public void setProduct_attr(String product_attr) {
            this.product_attr = product_attr;
        }

        public String getFinance_anticipate_rate() {
            return finance_anticipate_rate;
        }

        public void setFinance_anticipate_rate(String finance_anticipate_rate) {
            this.finance_anticipate_rate = finance_anticipate_rate;
        }

        public String getFinance_state() {
            return finance_state;
        }

        public void setFinance_state(String finance_state) {
            this.finance_state = finance_state;
        }

        public String getDocpuburl() {
            return docpuburl;
        }

        public void setDocpuburl(String docpuburl) {
            this.docpuburl = docpuburl;
        }

        public String getFinance_next_openday() {
            return finance_next_openday;
        }

        public void setFinance_next_openday(String finance_next_openday) {
            this.finance_next_openday = finance_next_openday;
        }
    }
}

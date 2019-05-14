package com.demo.other;

/**
 * @Desc
 * @Author 刘慧斌
 * @CreateTime 2019-04-22 10:15
 **/
public class BankInfo {
    private String url;
    private int pages;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public BankInfo(String url,int pages){
        this.url=url;
        this.pages=pages;
    }
}

package com.demo.other;


/*import util.HttpUtils;*/

import com.Jsoup.BankFinancialProducts;
import com.demo.util.HttpUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("ALL")
public class IPSpider {

    //private final String HTTP_API ="http://www.boc.cn/pbservice/pb3/";//中行
    //private final String HTTP_API ="http://finance.ccb.com/cn/finance/product.html";//建行
    //private final String HTTP_API ="http://www.hfbank.com.cn/gryw/cfgl/lc/rmlctj/index.shtml";//恒丰银行
    //private final String HTTP_API ="http://ewealth.abchina.com/fs/filter/";//农行
    //private final String HTTP_API ="http://www.bankcomm.com/BankCommSite/shtml/jyjr/cn/7226/7266/7281/7282/list.shtml?channelId=7226";//交通银行
    //private final String HTTP_API ="http://www.cebbank.com/site/gryw/yglc/lccp49/index.html";//光大银行
    //private final String HTTP_API ="http://www.cmbc.com.cn/channelApp/finance/financial.jsp";//民生银行
    //private final String HTTP_API ="http://www.hxb.com.cn/grjr/lylc/zzfsdlccpxx/index.shtml";//华夏银行------HTTP
    //private final String HTTP_API ="http://www.czbank.com/cn/fin_kno/xxcxpt1/lccpxxcx1/201904/t20190417_16651.shtml";//浙商银行-------HTTP
    //private final String HTTP_API ="http://www.cgbchina.com.cn/Channel/16684283";//广发银行-------HTTP
    private final String HTTP_API ="http://www.cmbchina.com/cfweb/Personal/Default.aspx";//招商银行
    //private final String HTTP_API ="http://www.cbhb.com.cn/bhbank/S101/lingshouyinhangfuwu/lcfw/rxcp/2018y/index.htm";//渤海银行，PDF格式，暂时不爬

    //private final String HTTPS_API ="https://mybank.icbc.com.cn/icbc/newperbank/perbank3/frame/frame_index.jsp#";//工商银行
    //private final String HTTPS_API ="https://www.cib.com.cn/cn/personal/wealth-management/xxcx/table/";//兴业银行------HTTPS
    private final String HTTPS_API ="https://per.spdb.com.cn/bank_financing/financial_product/";//浦发银行——————HTTPS
    //private final String HTTPS_API ="https://bank.pingan.com.cn/m/main/index.html";//平安银行——————HTTPS
    //private final String HTTPS_API ="https://etrade.citicbank.com/portalweb/html/finList.html";//中信银行————HTTPS

    private List<BankFinancialProducts> list = new ArrayList<>();

    // 爬取的页数----每页包含100个IP
    private int pages = 5;


    public IPSpider() {
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<BankFinancialProducts> crawlHttp(){
        List<BankFinancialProducts> ipBeans = new ArrayList<>();
        for (int page = 1; page <= pages; page++){
            ipBeans.addAll(crawl(HTTP_API, page));
        }
        System.out.println("ipBeans:"+ipBeans.size());
        return ipBeans;
    }

    public List<BankFinancialProducts> crawlHttp(int pages){
        this.pages = pages;
        return crawlHttp();
    }

    public List<BankFinancialProducts> crawlHttps(){
        List<BankFinancialProducts> ipBeans = new ArrayList<>();
        for (int page = 1; page <= pages; page++){
            ipBeans.addAll(crawl(HTTPS_API, page));
        }
        return ipBeans;
    }

    public List<BankFinancialProducts> crawlHttps(int pages){
        this.pages = pages;
        return crawlHttps();
    }

    private List<BankFinancialProducts> crawl(String api, int page) {

        String html = HttpUtils.getResponseContent(api+"");
        System.out.println("-----" + html + "\t\t\t" + "-----");
        Document document = null;/*Jsoup.parse(html);*/
        //Document document = null;
        try {
            document = Jsoup.connect(HTTPS_API).userAgent("Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.75 Safari/537.36").get();

        /*document =Jsoup.parse(html);*/
        System.out.println("22222222222222222222222222222222" + "\n\n\n");
        //Elements eles = document.select("#financeFilter");
        Elements eles = document.select("#licai > div:nth-child(1)");

        System.out.println("得到数据：" + eles.size() + "\n\n\n");
        System.out.println(document);
        for (Element element : eles) {
            Elements detail = element.select("ul li");
            System.out.println("数据条数：" + detail.size()+"\n\n\n");
            System.out.println(detail);
            for (Element n : detail) {
                String productName = n.select("div").eq(0)/*.select("p > font")*/.text();
                String url = n.select("td").eq(0)./*select(".MsoNormal").*/select("a").attr("href").trim();//pdf形式
                String yield=n.select(".ebdp-pc4promote-infoarea-content").select("p").eq(1).select("span").eq(2).text();
                String timelimit=n.select(".ebdp-pc4promote-infoarea-content").select("div").eq(2).select("span")/*.select("span")*/.text();
                String during=n.select(".ebdp-pc4promote-infoarea-content").select("div").eq(3)/*.select("span")*/.text();//购买时间
                String risk=n.select(".ebdp-pc4promote-infoarea-content").select("p").eq(0).select("span").eq(2).text();
                String purchase_amount=n.select(".ebdp-pc4promote-infoarea-content").select("div").eq(1).select("span").text()/*+"万元起"*/;

                System.out.println("银行名称：工商银行"+"\n"
                        +"产品名:" + productName+"\n"
                        +"风险:" + risk+"\n"
                        +"收益："+yield+"\n"
                        +"生效时间："+timelimit+"\n"
                        +"购买日期："+during+"\n"
                        +"起购金额："+purchase_amount+"\n");

                String bankname = "中国银行";
                BankFinancialProducts bankProduct = new BankFinancialProducts(bankname, productName, url);
                list.add(bankProduct);
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("--------数据条数：" + list.size());
        return list;
        /*System.out.println(document);

        System.out.println("22222222222222222222222222222222"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n");
        Elements eles=document.select("#yhlctbody");
        //Elements detailg=eles.select("tbody");
        //System.out.println("11111111"+detailg.size());

        //Elements eles=document.select("#director > div > div > div.content.col-sm-9 > div > div.TRS_Editor > div > div > div > table > tbody > tr:nth-child(3) > td:nth-child(1) > p > font");
        System.out.println("得到数据："+eles.size()+"\n\n\n");
        String name=eles.text();
        System.out.println(name);
        *//*SqlSessionFactory sqlSessionFactory=new SqlSessionFactory() {
        }*//*


        for (Element element:eles){
            Elements detail=element.select("tr td");
            System.out.println("数据条数："+detail.size());
            for (Element n:detail){
                String productName = n.select("h3").select("a").text();
                String url = n.select("a").attr("href").trim();
                System.out.println("title:" + productName);
                System.out.println("link:" + url);
                String bankname="中国银行";
                BankFinancialProducts bankProduct=new BankFinancialProducts(bankname,productName,url);
                list.add(bankProduct);
            }
        }

        System.out.println("--------数据条数："+list.size());
        return list;*/

    }
}

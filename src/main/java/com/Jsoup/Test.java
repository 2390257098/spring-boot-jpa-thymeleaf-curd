package com.Jsoup;


import com.alibaba.fastjson.JSON;
import com.demo.other.Bank;
import com.demo.other.BankProduct;
import com.demo.other.Table;
import com.google.gson.Gson;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import sun.net.www.protocol.http.Handler;
import sun.net.www.protocol.http.HttpURLConnection;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;


/**
 * @Desc
 * @Author 刘慧斌
 * @CreateTime 2019-04-24 10:38
 **/
public class Test {
    /*能顺利拿到数据的----9家银行-----方法一可以解析*/
    //private static String HTTP_API ="https://ccsa.ebsnew.boc.cn/BMPS/_bfwajax.do?rnd=31849&_locale=zh_CN";
    //private static String HTTP_API ="http://www.boc.cn/pbservice/pb3/";//中行
    //private static String HTTP_API ="http://wealth.cib.com.cn/retail/onsale/index.html";//兴业银行------HTTP
    //private static String HTTP_API ="http://www.hxb.com.cn/grjr/lylc/zzfsdlccpxx/index.shtml";//华夏银行------HTTP
    //private static String HTTP_API ="http://www.czbank.com/cn/fin_kno/xxcxpt1/lccpxxcx1/201904/t20190417_16651.shtml";//浙商银行-------HTTP----数据杂乱，需手动修改
    //private static String HTTP_API ="https://mybank.icbc.com.cn/icbc/newperbank/perbank3/frame/frame_index.jsp#";//工商银行
    //private static String HTTP_API ="http://www.bankcomm.com/BankCommSite/jyjr/cn/lcpd/queryFundInfoListNew.do";//交通银行------真网页解析（数据页
    //private static String HTTP_API ="http://www.cgbchina.com.cn/Channel/16684283?nav=2?nav=2";//广发银行-------HTTP-------真网页解析--分页未解决
    //private static String HTTP_API ="http://www.hfbank.com.cn/ucms/hfyh/jsp/gryw/lc_lb.jsp";//恒丰银行------分页未解决
    //private static String HTTP_API ="http://ewealth.abchina.com/app/data/api/DataService/BoeProductV2?i=1&s=75&o=0&w=%25E5%258F%25AF%25E5%2594%25AE%257C%257C%257C%257C%257C%257C%257C1%257C%257C0%257C%257C0";//需要json格式解析，方法二
    //private static String HTTP_API ="https://ccsa.ebsnew.boc.cn/BMPS/_bfwajax.do?rnd=31849&_locale=zh_CN";
    /*-----数据显示异常----2家-------*/
    //private static String HTTP_API ="http://www.cebbank.com/site/gryw/yglc/lccp49/index.html";//光大银行---假网页----有静态页，无数据
    //private static String HTTP_API ="http://www.cebbank.com/eportal/ui?moduleId=12073&struts.portlet.action=/app/yglcAction!listProduct.action";//源码里有数据，但是打开链接无数据，运行时效果一样
    //private static String HTTP_API ="http://www.cmbc.com.cn/channelApp/finance/financial.jsp";//民生银行---假网页----有静态页，无数据
    //private static String HTTP_API ="http://www.cmbc.com.cn/channelApp/ajax/Financialpage";//源码有数据，单独访问链接没数据，运行时效果一样

    /*---需要json转对象----3家-----*/
    //private static String HTTP_API ="http://finance.ccb.com/cn/finance/product.html";//建行-------有静态页，无数据
    //private static String HTTP_API ="http://finance.ccb.com/cc_webtran/queryFinanceProdList.gsp";///*?jsoncallback=jQuery19106392803671956198_1556096449544*/";//需要json格式解析---方法一（方法二显示乱码）分页暂时不处理
    //private static String HTTP_API ="http://ewealth.abchina.com/fs/filter/";//农行-------有静态页，无数据
    //private static String HTTP_API ="http://ewealth.abchina.com/app/data/api/DataService/BoeProductV2?i=1&s=75&o=0&w=%25E5%258F%25AF%25E5%2594%25AE%257C%257C%257C%257C%257C%257C%257C1%257C%257C0%257C%257C0";//需要json格式解析，方法二
    //private static String HTTP_API ="http://www.cmbchina.com/cfweb/Personal/Default.aspx";//招商银行-------有静态页，无数据
    //private static String HTTP_API ="http://www.cmbchina.com/cfweb/svrajax/product.ashx?op=search&type=m&pageindex=1&salestatus=&baoben=&currency=10&term=&keyword=&series=01&risk=&city=&date=&pagesize=20&orderby=ord1&t=0.5836768716596312&citycode=";//需json解析，方法二
    //private static String HTTP_API ="http://www.echargenet.com/views/mapService/map.html";
    //private static String HTTP_API ="http://www.hfbank.com.cn/gryw/cfgl/lc/rmlctj/index.shtml";//恒丰银行——————post请求
    //private static String HTTP_API ="http://www.hfbank.com.cn/ucms/hfyh/jsp/gryw/lc_xq.jsp?PrdCode=ZL19015&staticPrefix=q";
    //private static String HTTP_API ="http://www.bankcomm.com/BankCommSite/shtml/jyjr/cn/7226/7266/7281/7282/list.shtml?channelId=7226";//交通银行----假网页---有静态页，无数据

    /*----渤海银行----1家-----数据在PDF中，暂时不爬---*/
    //private static String HTTP_API ="http://www.cbhb.com.cn/bhbank/S101/lingshouyinhangfuwu/lcfw/rxcp/2018y/index.htm";//渤海银行，PDF格式，暂时不爬

    //------------https://blog.csdn.net/u011400521/article/details/78251857-----------绕过SSL证书发请求
    /*-----HTTPS-----3家银行-----请求-----直接发https请求报错转化https出错，发HTTP请求报错链接超时或拒绝---*/
    //private static String HTTPS_API ="https://per.spdb.com.cn/bank_financing/financial_product/";//浦发银行——————HTTPS
    //private static String HTTPS_API ="https://per.spdb.com.cn/was5/web/search";
    //private static String HTTPS_API ="https://bank.pingan.com.cn/m/main/index.html";//平安银行——————HTTPS
    //private static String HTTPS_API ="https://bank.pingan.com.cn/rmb/bron/ibank/cust/bron-ibank-pd/pc/finance/getRecommendList.do?channelCode=C0002&moduleCode=C0002_FINA_PC_INDEX&access_source=PC";//请求返回为空
    //private static String HTTPS_API ="https://etrade.citicbank.com/portalweb/html/finList.html";//中信银行————HTTPS
    //private static String HTTPS_API ="https://etrade.citicbank.com/portalweb/fd/getFinaList.htm";//需要json转对象-----

    //设置多代理绕过反爬——————失败
    //private static String HTTP_API ="https://movie.douban.com/";
    //private static String HTTP_API ="https://movie.douban.com/subject/26835471/?from=showing";
    private static String HTTP_API ="http://www.yymh8.com/index.php?m=&c=Mh&a=book_cate&p_reload=1&reload_time=1557747251931";
    public static void main(String[] args) {
        try {
            Document document=null;
                document=Jsoup.connect(HTTP_API).userAgent("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET CLR 2.0.50727; Media Center PC 6.0)")
                        .get();
                System.out.println(document);
                document=Jsoup.parse(document.toString());
                //Elements eles = document.select("body");
            Elements eles = document.select("body");
                System.out.println("得到数据：" + eles.size() + "\n\n\n");
                //System.out.println(eles);
                /*for (Element element : eles) {
                    Elements detail = element.select(".wrapper.marbotton10").select(".financialist-article");
                    System.out.println("数据条数：" + detail.size()+"\n\n\n");
                    ///System.out.println(detail);
                    for (Element n : detail) {
                        String productName = n.select("h3").select("a").text();
                        String currency=n.select("td").eq(1).text();
                        String url = n.select("h3").select("a").attr("href").trim();
                        String yield=n.select("div").eq(0).select("tr").eq(1).select("td").eq(1).text();//
                        String time_limit=n.select("div").eq(0).select("tr").eq(1).select("td").eq(2).text();//
                        String during=n.select("div").eq(0).select(".date").select("p").eq(1).text()+"----"+n.select("div").eq(0).select(".date").select("p").eq(3).text();//购买时间
                        String risk=n.select("h3").select(".right").select("span").text();
                        String purchase_amount=n.select("div").eq(0).select("tr").eq(1).select("td").eq(3).text();//

                        System.out.println("银行名称：恒丰银行"+"\n"
                                +"产品名:" + productName+"\n"
                                +"币种:" + currency +"\n"
                                +"链接:" + url+"\n"
                                +"风险:" + risk+"\n"
                                +"收益："+yield+"\n"
                                +"生效时间："+time_limit+"\n"
                                +"购买日期："+during+"\n"
                                +"起购金额："+purchase_amount+"\n");
                        //String bankname = "中国银行";
                        //BankFinancialProducts bankProduct = new BankFinancialProducts(bankname, productName, url);
                    }
                }*/

        } catch (IOException e) {
            e.printStackTrace();
        }

        HttpURLConnection connection = null;
        if (connection == null) {
            try {

                connection = (HttpURLConnection)new URL(null, HTTP_API, new Handler()).openConnection();
                // 添加请求头部
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.81 Safari/537.36");
                //connection.setInstanceFollowRedirects(false);
                connection.addRequestProperty("mobile","pkran1986");
                connection.addRequestProperty("pass", "7788120K");
                System.out.println("----------");
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                reader.close();
                inputStream.close();
                System.out.println(stringBuilder.toString());
                /*Gson gson=new Gson();
                Bank bankProduct=gson.fromJson(stringBuilder.toString(),Bank.class);

                //System.out.println(bankProduct.getData());
                String jsons = JSON.toJSONString(bankProduct.getData());
                Table table=gson.fromJson(jsons,Table.class);
                //System.out.println(table.getTable()+"\n\n");
                String jsons1= JSON.toJSONString(table.getTable());
        BankProduct bankProduct1=gson.fromJson(jsons1,BankProduct.class);
        System.out.println(bankProduct1.getProdName());
                //System.out.println(jsons1);
                JSONArray jsonArray=JSONArray.fromObject(jsons1);
                for (int i=0;i<jsonArray.size();i++){
                    Object o=jsonArray.get(i);
                    //System.out.println("***"+i+"***"+o);
                    String json2 = JSON.toJSONString(o);
                    BankProduct b1=gson.fromJson(json2,BankProduct.class);
                    BankFinancialProducts products=new BankFinancialProducts("中国农业银行",b1.getProdName(),b1.getProdProfit(),b1.getProdSaleDate(),b1.getProdLimit(),b1.getPurStarAmo(),b1.getProdArea(),b1.getProdYildType(),"");
                    System.out.println(products.getProductName());
                }*/
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /*HttpsURLConnection connections = null;
        if (connections == null) {
            try {
                //connections = (HttpsURLConnection) new URL(null, HTTPS_API, new Handler()).openConnection();
                connections = new HttpsURLConnection(null, HTTPS_API, new sun.net.www.protocol.https.Handler());
                // 添加请求头部
                connections.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.81 Safari/537.36");
                connections.setInstanceFollowRedirects(false);
                System.out.println("----------");
                InputStream inputStream = connections.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                reader.close();
                inputStream.close();
                System.out.println(stringBuilder);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    }
}

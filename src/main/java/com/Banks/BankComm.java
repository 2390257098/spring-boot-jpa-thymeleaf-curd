package com.Banks;


import com.Jsoup.BankFinancialProducts;
import com.Jsoup.BankFinancialProductsDao;
import com.Jsoup.util.MyBatisUtil;
import com.demo.other.BankProduct;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.ibatis.session.SqlSession;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import sun.net.www.protocol.http.Handler;
import sun.net.www.protocol.http.HttpURLConnection;

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
//交通银行-----数据匹配杂乱-----数据完整
public class BankComm {
    private static String HTTP_API ="http://www.bankcomm.com/BankCommSite/jyjr/cn/lcpd/queryFundInfoListNew.do";
    public static void main(String[] args) {
        Document document=null;
        SqlSession sqlSession=null;
        sqlSession=MyBatisUtil.createSqlSession();
        try {
                document=Jsoup.connect(HTTP_API).userAgent("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET CLR 2.0.50727; Media Center PC 6.0)")
                        .get();
                //System.out.println(document);
                document=Jsoup.parse(document.toString());
                Elements eles = document.select(".fundsList");

                System.out.println("得到数据：" + eles.size() + "\n\n\n");
                //System.out.println(eles);
                for (Element element : eles) {
                    Elements detail = element.select("ul li");
                    System.out.println("数据条数：" + detail.size()+"\n\n\n");
                    //System.out.println(detail);
                    for (Element n : detail) {
                        String productName = n.select("div").eq(0).select("h1").text();
                        String url = n.select(".right-box").select("a").attr("href").trim();//pdf形式
                        String yield=n.select("div").eq(0).select("dl").eq(2).select("h5").text();
                        String time_limit=n.select("td").eq(4).text();
                        String during=n.select(".right-box").select("h6").text();//购买时间
                        String risk=n.select("div").eq(0).select("dl").eq(1).select("h5").text();
                        String purchase_amount=n.select("div").eq(0).select("dl").eq(0).select("h5").text();
                        BankFinancialProducts products=new BankFinancialProducts("交通银行",productName,yield,during,time_limit,purchase_amount,risk,url);
                        sqlSession.getMapper(BankFinancialProductsDao.class).insertSelective(products);
                        sqlSession.commit();
                        /*System.out.println("银行名称："+"\t\t"+products.getBankName()+"\n"
                                +"产品名:" + "\t\t\t"+products.getProductName()+"\n"
                                +"链接:" + "\t\t\t"+products.getUrl()+"\n"
                                +"风险:" + "\t\t\t"+products.getRisk()+"\n"
                                +"收益："+"\t\t\t"+products.getYieldRate()+"%"+"\n"
                                +"生效时间："+"\t\t"+products.getTimeLimit()+"\n"
                                +"购买日期："+"\t\t"+products.getDuring()+"\n"
                                +"起购金额："+"\t\t"+products.getPurchaseAmount()+"\n");*/
                        //String bankname = "中国银行";
                        //BankFinancialProducts bankProduct = new BankFinancialProducts(bankname, productName, url);
                    }
                }

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }
}

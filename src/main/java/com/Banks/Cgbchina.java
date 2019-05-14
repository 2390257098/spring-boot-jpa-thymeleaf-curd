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
//广发银行-------只有一页数据
public class Cgbchina {
    public static void main(String[] args) {
        String HTTP_API ="http://www.cgbchina.com.cn/Channel/16684283?nav=2?nav=2";//广发银行-------HTTP-------真网页解析--分页未解决
        Document document=null;
        SqlSession sqlSession=MyBatisUtil.createSqlSession();
        try {

                document=Jsoup.connect(HTTP_API).userAgent("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET CLR 2.0.50727; Media Center PC 6.0)")
                        .get();
                //System.out.println(document);
                document=Jsoup.parse(document.toString());
                Elements eles = document.select("#product_tab");
                //System.out.println("得到数据：" + eles.size() + "\n\n\n");
                for (Element element : eles) {
                    Elements detail = element.select(".bg2");
                    //System.out.println("数据条数：" + detail.size()+"\n\n\n");
                    for (Element n : detail) {
                        String productName = n.select("td").eq(0).text();
                        /*String currency=n.select("td").eq(1).text();*///币种
                        String url = n.select("td").eq(0).select("a").attr("href").trim();//pdf形式
                        String yield=n.select("td").eq(4).text();
                        String time_limit=n.select("td").eq(2).text();
                        String during=n.select("td").eq(6).text();//购买时间
                        String risk=n.select("td").eq(5).text();
                        String purchase_amount=n.select("td").eq(3).text();
                        BankFinancialProducts products=new BankFinancialProducts("广发银行",productName,yield+"%",during,time_limit,purchase_amount,risk,url);
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
                        //String bankname = "广发银行";
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

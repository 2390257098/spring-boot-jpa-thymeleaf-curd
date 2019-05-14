package com.Banks;

import com.Jsoup.BankFinancialProducts;
import com.Jsoup.BankFinancialProductsDao;
import com.Jsoup.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;

/**
 * @Desc
 * @Author 刘慧斌
 * @CreateTime 2019-04-27 12:20
 **/
//浙商银行------数据杂乱，需手动修改------只有一页数据
public class CzBank {
    public static void main(String[] args) {
        String HTTP_API ="http://www.czbank.com/cn/fin_kno/xxcxpt1/lccpxxcx1/201904/t20190417_16651.shtml";
        Document document=null;
        SqlSession sqlSession=MyBatisUtil.createSqlSession();
        try {
            document=Jsoup.connect(HTTP_API).userAgent("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET CLR 2.0.50727; Media Center PC 6.0)")
                    .get();
            //System.out.println(document);
            document=Jsoup.parse(document.toString());
            //Elements eles = document.select("body");

            Elements eles = document.select("#director > div > div > div.content.col-sm-9 > div > div.TRS_Editor > div > div > div > table");
            System.out.println("得到数据：" + eles.size() + "\n\n\n");
            //System.out.println(eles);
            for (Element element : eles) {
                Elements detail = element.select("tbody > tr");
                System.out.println("数据条数：" + detail.size()+"\n\n\n");
                ///System.out.println(detail);
                for (Element n : detail) {
                    String productName = n.select("td").eq(0).select("p > font").text();
                    String url = n.select("td").eq(1).select(".MsoNormal").select("a").attr("href").trim();
                    String yield=n.select("td").eq(2).select(".MsoNormal").text();
                    //String time_limit=n.select("ul > li:nth-child(1) > span.highlight").text();
                    String during=n.select("td").eq(4).select(".MsoNormal").text();
                    //String risk=n.select(".box_title").select("p").eq(0).select("span").eq(2).text();
                    String purchase_amount=n.select("td").eq(3).select(".MsoNormal").text();
                    BankFinancialProducts products=new BankFinancialProducts("浙商银行",productName,yield,during,"",purchase_amount,"",url);
                    sqlSession.getMapper(BankFinancialProductsDao.class).insertSelective(products);
                    sqlSession.commit();
                    /*System.out.println("银行名称："+"\t\t"+products.getBankName()+"\n"
                            +"产品名:" + "\t\t\t"+products.getProductName()+"\n"
                            +"链接:" + "\t\t\t"+products.getUrl()+"\n"
                            +"风险:" + "\t\t\t"+products.getRisk()+"\n"
                            +"收益："+"\t\t\t"+products.getYieldRate()+"\n"
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

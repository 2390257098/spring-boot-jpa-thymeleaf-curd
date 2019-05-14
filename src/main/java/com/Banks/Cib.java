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
 * @CreateTime 2019-04-27 10:51
 **/
//兴业银行--------近期发售只有一页数据
public class Cib {
    public static void main(String[] args) {
        String HTTP_API ="http://wealth.cib.com.cn/retail/onsale/index.html";//兴业银行------HTTP----分页未处理
        SqlSession sqlSession=MyBatisUtil.createSqlSession();
        try {
            Document document=Jsoup.connect(HTTP_API).userAgent("Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.75 Safari/537.36").get();
            System.out.println(document);
            Elements eles = document.select("#finTable > tbody");

            System.out.println("得到数据：" + eles.size() + "\n\n\n");
            System.out.println(document);
            for (Element element : eles) {
                Elements detail = element.select("tr");
                System.out.println("数据条数：" + detail.size()+"\n\n\n");
                System.out.println(detail);
                for (Element n : detail) {
                    String productName = n.select("td").eq(0).text();
                    String url = n.select("td").eq(0)./*select(".MsoNormal").*/select("a").attr("href").trim();//pdf形式
                    String yield=n.select("td").eq(6).text();
                    String time_limit=n.select("td").eq(4).text();
                    String during=n.select("td").eq(1).text()+"-"+n.select("td").eq(2).text();//购买时间
                    String risk="暂无数据";
                    String purchase_amount=n.select("td").eq(5).text()/*+"万元起"*/;
                    BankFinancialProducts products=new BankFinancialProducts("兴业银行",productName,yield,during,time_limit,purchase_amount,risk,url);
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

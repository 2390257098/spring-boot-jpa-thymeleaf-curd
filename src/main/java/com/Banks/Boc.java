package com.Banks;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @Desc
 * @Author 刘慧斌
 * @CreateTime 2019-04-27 11:12
 **/
//中国银行------只有产品名和相关链接
public class Boc {
    public static void main(String[] args) {
        //String url="https://ccsa.ebsnew.boc.cn/BMPS/_bfwajax.do?rnd=31849&_locale=zh_CN";
        String url="https://ccsa.ebsnew.boc.cn/shareFinace/shareVue/finance/index.html#/productList?v=5.3.4";
        Document document=null;
        try {
            document=Jsoup.connect(url).userAgent("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET CLR 2.0.50727; Media Center PC 6.0)")
                    .post();
            System.out.println(document);
            document=Jsoup.parse(document.toString());
            //Elements eles = document.select("body");
            Elements eles = document.select("body > div > div.main > div > div");
            System.out.println("得到数据：" + eles.size() + "\n\n\n");
            //System.out.println(eles);
            for (Element element : eles) {
                Elements detail = element.select("ul li");
                System.out.println("数据条数：" + detail.size()+"\n\n\n");
                ///System.out.println(detail);
                for (Element n : detail) {
                    String productName = n.select("a").text();
                    String url1 = n.select("a").attr("href").trim();

                    System.out.println("银行名称：中国银行"+"\n"
                            +"产品名:" + productName+"\n"+
                            "链接："+url1
                            );
                    //String bankname = "中国银行";
                    //BankFinancialProducts bankProduct = new BankFinancialProducts(bankname, productName, url);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

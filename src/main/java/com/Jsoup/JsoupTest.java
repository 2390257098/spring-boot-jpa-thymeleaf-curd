package com.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
/**
 * @Desc
 * @Author 刘慧斌
 * @CreateTime 2019-04-15 11:22
 **/
public class JsoupTest {
       public static void main(String []args) {
           try{
               //String url="http://www.boc.cn/pbservice/pb3/";
               String url="https://www.cib.com.cn/cn/personal/wealth-management/xxcx/table/";
               Document document = Jsoup.connect(url)
                       .userAgent("Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.75 Safari/537.36")
                       .get();
               //#batchTBODY > tr:nth-child(1) > td:nth-child(6) > span > a

               Elements elements=document.select("#yhlctbody")/*.select(".left")*/
                       /*.select("tr:nth-child(1)")
                       .select("td:nth-child(6)")
                       .select("span a")*/;
                       //#posts-list > li:nth-child(1) > div > a
               System.out.println("数据条数："+elements.size());
               for (Element element:elements){
                   String name=element.select("td").eq(1).text();
                   System.out.println("产品名称:"+name);
                   Elements detail=element.select("tr td");
                   for (Element n:detail){
                       String title = n.select("td").eq(1).text();
                       //String link = n./*select("td").eq(1).*/select("a").attr("href").trim();
                       System.out.println("title:" + title);
                       //System.out.println("link:" + link);
                   }
               }
           }catch (IOException e){
               e.printStackTrace();
           }
       }
}

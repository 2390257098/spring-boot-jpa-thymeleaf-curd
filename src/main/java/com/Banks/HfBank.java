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
//恒丰银行-----一页显示8条数据，但是换页url不变，无法处理
public class HfBank {

    private static String HTTP_API ="http://www.hfbank.com.cn/ucms/hfyh/jsp/gryw/lc_lb.jsp";//恒丰银行------分页未解决
    public static void main(String[] args) {
        SqlSession sqlSession=MyBatisUtil.createSqlSession();
        try {
            Document document = null;
            document = Jsoup.connect(HTTP_API).userAgent("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET CLR 2.0.50727; Media Center PC 6.0)")
                    .post();
            //System.out.println(document);
            document = Jsoup.parse(document.toString());
            //Elements eles = document.select("body");
            Elements eles = document.select("body");
            System.out.println("得到数据：" + eles.size() + "\n\n\n");
            //System.out.println(eles);
            for (Element element : eles) {
                Elements detail = element.select(".wrapper.marbotton10").select(".financialist-article");
                System.out.println("数据条数：" + detail.size() + "\n\n\n");
                ///System.out.println(detail);

                BankFinancialProducts products = null;
                for (Element n : detail) {
                    String productName = n.select("h3").select("a").text();
                    String url = n.select("h3").select("a").attr("href").trim();
                    String yield = n.select("div").eq(0).select("tr").eq(1).select("td").eq(1).text();//
                    String time_limit = n.select("div").eq(0).select("tr").eq(1).select("td").eq(2).text();//
                    String during = n.select("div").eq(0).select(".date").select("p").eq(1).text() + "----" + n.select("div").eq(0).select(".date").select("p").eq(3).text();//购买时间
                    String risk = n.select("h3").select(".right").select("span").text();
                    String purchase_amount = n.select("div").eq(0).select("tr").eq(1).select("td").eq(3).text();//
                    products = new BankFinancialProducts("恒丰银行", productName, yield, during, time_limit, purchase_amount, risk, url);
                    sqlSession.getMapper(BankFinancialProductsDao.class).insertSelective(products);
                    sqlSession.commit();
                    /*System.out.println("银行名称：" + "\t\t" + products.getBankName() + "\n"
                            + "产品名:" + "\t\t\t" + products.getProductName() + "\n"
                            + "链接:" + "\t\t\t" + products.getUrl() + "\n"
                            + "风险:" + "\t\t\t" + products.getRisk() + "\n"
                            + "收益：" + "\t\t\t" + products.getYieldRate() + "\n"
                            + "生效时间：" + "\t\t" + products.getTimeLimit() + "\n"
                            + "购买日期：" + "\t\t" + products.getDuring() + "\n"
                            + "起购金额：" + "\t\t" + products.getPurchaseAmount() + "\n");*/
                }
                //String bankname = "中国银行";
                //BankFinancialProducts bankProduct = new BankFinancialProducts(bankname, productName, url);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            MyBatisUtil.closeSqlSession(sqlSession);
        }

        /*HttpURLConnection connection = null;
        if (connection == null) {
            try {
                connection = (HttpURLConnection)new URL(null, HTTPS_API, new Handler()).openConnection();
                // 添加请求头部
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.81 Safari/537.36");
                connection.setInstanceFollowRedirects(false);
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
                System.out.println(stringBuilder);
                //Document document=Jsoup.parse(stringBuilder.toString());
                *//*String document="{\"ProductNo\":\"AD190180\",\"ProdName\":\"“金钥匙·安心得利·灵珑”2019年第136期封闭净值型人民币理财产品（白金客户专属款）\",\"ProdClass\":\"封闭\",\"ProdLimit\":\"170天\",\"ProdProfit\":\"业绩基准4.05%\",\"ProdYildType\":\"非保本浮动收益\",\"PrdYildTypeOrder\":\"2\",\"ProdArea\":\"全国发行\",\"szComDat\":\"2019.04.25\",\"ProdSaleDate\":\"19.04.25-19.04.29\",\"IsCanBuy\":\"1\",\"PurStarAmo\":\"10000.00\",\"RowNumber\":\"1\"}";
                JSONObject jsonObject=JSONObject.fromObject(document);
                BankProduct stu=(BankProduct)JSONObject.toBean(jsonObject, BankProduct.class);
                JSONArray jsonArray=JSONArray.fromObject(document);
                Object o=jsonArray.get(0);
                JSONObject jsonObject2=JSONObject.fromObject(o);
                BankProduct stu2=(BankProduct)JSONObject.toBean(jsonObject2, BankProduct.class);
                System.out.println("产品名"+stu.getProdName());*//*
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

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

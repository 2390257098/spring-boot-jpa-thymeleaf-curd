package com.Banks;

import com.Jsoup.BankFinancialProducts;
import com.Jsoup.BankFinancialProductsDao;
import com.Jsoup.util.MyBatisUtil;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import org.apache.ibatis.session.SqlSession;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @Desc
 * @Author 刘慧斌
 * @CreateTime 2019-04-27 11:41
 **/
//华夏银行------数据完整
public class HxB {
    public static void main(String[] args) {
        String HTTP_API ="http://www.hxb.com.cn/grjr/lylc/zzfsdlccpxx/index.shtml";
        SqlSession sqlSession=MyBatisUtil.createSqlSession();
        try {
            Document document=null;
            document=Jsoup.connect(HTTP_API).userAgent("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET CLR 2.0.50727; Media Center PC 6.0)")
                    .get();
            //System.out.println(document);
            document=Jsoup.parse(document.toString());
            //Elements eles = document.select("body");
            Elements eles = document.select("#pageContent");
            System.out.println("得到数据：" + eles.size() + "\n\n\n");
            //System.out.println(eles);
            BankFinancialProducts products=null;
            for (Element element : eles) {
                Elements detail = element.select("ol li").select(".pro_box");
                System.out.println("数据条数：" + detail.size()+"\n\n\n");
                ///System.out.println(detail);
                for (Element n : detail) {
                    String productName = n.select(".box_title").select("a").text();
                    String url = n.select(".box_title").select("a").attr("href").trim();
                    String yield=n.select(".box_lf").select(".box_num").text();
                    String time_limit=n.select("ul > li:nth-child(1) > span.highlight").text();
                    String during=n.select(".box_rt").select("li").eq(1).select("span").eq(1).text();
                    //String risk=n.select(".box_title").select("p").eq(0).select("span").eq(2).text();
                    String purchase_amount=n.select(".box_rt").select(".amt").text()+"万元起";
                    products=new BankFinancialProducts("华夏银行",productName,yield+"%",during,time_limit,purchase_amount,"暂无数据",url);
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

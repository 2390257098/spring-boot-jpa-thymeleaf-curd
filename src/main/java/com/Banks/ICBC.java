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
 * @CreateTime 2019-04-27 11:24
 **/
//工商银行-------分页未处理
public class ICBC {
    public static void main(String[] args) {
        //String HTTP_API ="https://mybank.icbc.com.cn/icbc/newperbank/perbank3/frame/frame_index.jsp#";
        //String HTTP_API ="https://mybank.icbc.com.cn/icbc/newperbank/perbank3/frame/frame_index.jsp#";
        String HTTP_API ="https://mybank.icbc.com.cn/servlet/ICBCBaseReqServletNoSession?dse_operationName=per_FinanceCurProListP3NSOp&p3bank_error_backid=120103&pageFlag=0&Area_code=1200&requestChannel=302";
        SqlSession sqlSession=MyBatisUtil.createSqlSession();
        try {
            Document document=null;
                document=Jsoup.connect(HTTP_API).userAgent("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET CLR 2.0.50727; Media Center PC 6.0)")
                        .get();
                System.out.println(document);
                document=Jsoup.parse(document.toString());
                //Elements eles = document.select("body");
            Elements eles = document.select(".ebdp-pc4promote-circularcontainer");
                System.out.println("得到数据：" + eles.size() + "\n\n\n");
                System.out.println(eles);
            BankFinancialProducts products=null;
                for (Element element : eles) {
                    Elements detail = element.select("ul li");
                    System.out.println("数据条数：" + detail.size()+"\n\n\n");
                    ///System.out.println(detail);
                    for (Element n : detail) {
                        String productName = n.select("div").eq(0).text();
                        String url = n.select("td").eq(0).select("a").attr("href").trim();//pdf形式
                        String yield=n.select(".ebdp-pc4promote-infoarea-content").select("p").eq(1).select("span").eq(2).text();
                        String time_limit=n.select(".ebdp-pc4promote-infoarea-content").select("div").eq(2).select("span").text();
                        String during=n.select(".ebdp-pc4promote-infoarea-content").select("div").eq(3).text()+"----"+n.select(".ebdp-pc4promote-infoarea-content").select("div").eq(3).text();//购买时间
                        String risk=n.select(".ebdp-pc4promote-infoarea-content").select("p").eq(0).select("span").eq(2).text();
                        String purchase_amount=n.select(".ebdp-pc4promote-infoarea-content").select("div").eq(1).select("span").text();
                        products=new BankFinancialProducts("工商银行",productName,yield+"%",during,time_limit,purchase_amount,risk,url);
                        sqlSession.getMapper(BankFinancialProductsDao.class).insertSelective(products);
                        sqlSession.commit();
                        /*System.out.println("银行名称：" + "\t\t" + products.getBankName() + "\n"
                                + "产品名:" + "\t\t\t" + products.getProductName() + "\n"
                                + "链接:" + "\t\t\t" + products.getUrl() + "\n"
                                + "风险:" + "\t\t\t" + products.getRisk() + "\n"
                                + "收益：" + "\t\t\t" + products.getYieldRate() + "\n"
                                + "生效时间：" + "\t\t" + products.getTimeLimit() + "\n"
                                + "购买日期：" + "\t" + products.getDuring() + "\n"
                                + "起购金额：" + "\t\t" + products.getPurchaseAmount() + "\n");*/                        //String bankname = "中国银行";
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

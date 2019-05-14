package com.Banks;

import com.Jsoup.BankFinancialProducts;
import com.Jsoup.BankFinancialProductsDao;
import com.Jsoup.util.GsonBuilderUtil;
import com.Jsoup.util.MyBatisUtil;
import com.alibaba.fastjson.JSON;
import com.demo.other.BankInfo1;
import com.google.gson.Gson;
import net.sf.json.JSONArray;
import org.apache.ibatis.session.SqlSession;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Desc
 * @Author 刘慧斌
 * @CreateTime 2019-04-25 23:32
 **/
//建设银行-------数据完整
public class CCB {
    public static void main(String[] args) {
        String url="http://finance.ccb.com/cc_webtran/queryFinanceProdList.gsp";
        Document document=null;
        SqlSession sqlSession=MyBatisUtil.createSqlSession();
        try {
            document=Jsoup.connect(url).userAgent("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET CLR 2.0.50727; Media Center PC 6.0)")
                    .get();
            //System.out.println(document);//输出结果带几个HTML标签，用.text()提取出来
            String json=document.text();
            /*JSONObject obj = JSONObject.parseObject(json);
            com.alibaba.fastjson.JSONArray jsonArray2= (com.alibaba.fastjson.JSONArray) obj.get("ProdList");*/
            System.out.println(json);
            Gson gson=GsonBuilderUtil.create();;
            BankInfo1 bankProduct=gson.fromJson(json,BankInfo1.class);
            JSONArray jsonArray=JSONArray.fromObject(bankProduct.getProdList());
            BankInfo1.Product product=null;
            BankFinancialProducts products=null;
            for (int i=0;i<jsonArray.size();i++){
                Object o=jsonArray.get(i);
                String json2 = JSON.toJSONString(o);
                product=gson.fromJson(json2,BankInfo1.Product.class);
                String time1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(product.getCollBgnDate());
                String time2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(product.getCollEndDate());
                products=new BankFinancialProducts("中国建设银行",product.getName().toString(),product.getYieldRate().toString()+"%",time1+"--"+time2,product.getInvestPeriod().toString()+"天",product.getPurFloorAmt().toString(),product.getRiskLevel().toString(),product.getInstructionUrl().toString());
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
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            MyBatisUtil.closeSqlSession(sqlSession);
        }


    }
}

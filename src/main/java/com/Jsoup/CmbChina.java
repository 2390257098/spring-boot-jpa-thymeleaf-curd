package com.Jsoup;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.demo.other.BankInfo1;
import com.demo.other.BankInfo2;
import com.demo.other.Product2;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import net.sf.json.JSONArray;
import sun.net.www.protocol.http.Handler;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @Desc
 * @Author 刘慧斌
 * @CreateTime 2019-04-25 22:54
 **/
//招商银行
public class CmbChina {
    private static String HTTP_API ="http://www.cmbchina.com/cfweb/svrajax/product.ashx?op=search&type=m&pageindex=1&salestatus=&baoben=&currency=10&term=&keyword=&series=01&risk=&city=&date=&pagesize=20&orderby=ord1&t=0.5836768716596312&citycode=";//需json解析，方法二

    public static void main(String[] args) {
        try {
            HttpURLConnection connection = (HttpURLConnection)new URL(null, HTTP_API, new Handler()).openConnection();
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
            //System.out.println(stringBuilder);
            String json=stringBuilder.substring(1,stringBuilder.length()-1);
            //可以给key值加上""
            String jsons=JSONObject.parse(json).toString();
            JSONObject obj = JSONObject.parseObject(json);
            com.alibaba.fastjson.JSONArray jsonArray2= (com.alibaba.fastjson.JSONArray) obj.get("ProdList");
            for (int i=0;i<jsonArray2.size();i++){
                JSONObject pobj = jsonArray2.getJSONObject(i);
                pobj.get("");

            }
            //BankInfo2 resultBean = new Gson().fromJson(jsons,BankInfo2.class);
            Gson gson=new Gson();
            BankInfo2 bankInfo2=gson.fromJson(jsons,BankInfo2.class);
            JSONArray jsonArray=JSONArray.fromObject(bankInfo2.getList());
            System.out.println(jsonArray);
            BankInfo2.Product2 product2=null;
            BankFinancialProducts products=null;
            for (int i=0;i<jsonArray.size();i++){
                Object o=jsonArray.get(i);
                String json2 = JSON.toJSONString(o);
                System.out.println(json2);
                product2=gson.fromJson(json2,BankInfo2.Product2.class);
                products=new BankFinancialProducts("招商银行",product2.getPrdName().toString(),"浮动收益",product2.getBeginDate().toString()+"-"+product2.getEndDate().toString(),product2.getFinDate().toString(),product2.getInitMoney().toString(),"",product2.getRisk().toString());
                System.out.println("产品名："+products.getProductName()+"\t"+
                        "收益："+products.getYieldRate()+"\t"+
                        "起购金额："+products.getPurchaseAmount());
            }
            /*//对象中拿到集合
            List<BankInfo2.Product2> userBeanList = resultBean.getList();
            System.out.println(userBeanList.get(1).getCapitalProtectName());*/
            /*JsonParser jsonParser = new JsonParser();
            JsonArray jsonArray = jsonParser.parse(stringBuilder.toString()).getAsJsonArray();
            System.out.println(jsonArray);*/
            /*Gson gson=new Gson();
            List<BankInfo2> coursesList=new ArrayList<>();
            for (JsonElement user : jsonArray) {
                //使用GSON，直接转成Bean对象
                BankInfo2 userBean = gson.fromJson(user, BankInfo2.class);
                coursesList.add(userBean);
            }*/

            //BankInfo2 bank=gson.fromJson(stringBuilder.toString(),BankInfo2.class);

                //System.out.println(bank.getList());
                /*String jsons = JSON.toJSONString(bank.getList());
                *//*Product2 product2=gson.fromJson(jsons,Product2.class);
                //System.out.println(table.getTable()+"\n\n");
                String jsons1= JSON.toJSONString(product2.getTable());*//*
                Product2 bankProduct1=gson.fromJson(jsons,Product2.class);
                //System.out.println(bankProduct1.getAreaCode());
                //System.out.println(jsons1);
                JSONArray jsonArray=JSONArray.fromObject(bankProduct1);
                for (int i=0;i<jsonArray.size();i++){
                    Object o=jsonArray.get(i);
                    //System.out.println("***"+i+"***"+o);
                    String json2 = JSON.toJSONString(o);
                    Product2 product2=gson.fromJson(json2,Product2.class);
                    BankFinancialProducts products=new BankFinancialProducts("中国招商银行",product2.getPrdName().toString(),"",product2.getBeginDate().toString()+"-"+product2.getEndDate().toString(),product2.getFinDate().toString(),product2.getInitMoney().toString(),"全行",product2.getRisk().toString(),"");
                    System.out.println(products.getProductName());
                }*/
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}

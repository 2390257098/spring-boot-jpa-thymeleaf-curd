package com.Jsoup;

import com.alibaba.fastjson.JSON;
import com.demo.other.Bank;
import com.demo.other.BankProduct;
import com.demo.other.Table;
import com.google.gson.Gson;
import net.sf.json.JSONArray;
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
 * @CreateTime 2019-04-25 19:40
 **/
public class EwealthBank {
    public static void main(String[] args) {
        String url="http://ewealth.abchina.com/app/data/api/DataService/BoeProductV2?i=1&s=75&o=0&w=%25E5%258F%25AF%25E5%2594%25AE%257C%257C%257C%257C%257C%257C%257C1%257C%257C0%257C%257C0";
        HttpURLConnection connection = null;
        if(connection == null) {
            try {
            connection = (HttpURLConnection)new URL(null, url, new Handler()).openConnection();
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
            Gson gson=new Gson();
            Bank bankProduct=gson.fromJson(stringBuilder.toString(),Bank.class);
            String jsons = JSON.toJSONString(bankProduct.getData());
            Table table=gson.fromJson(jsons,Table.class);
            String jsons1= JSON.toJSONString(table.getTable());
            JSONArray jsonArray=JSONArray.fromObject(jsons1);
            for (int i=0;i<jsonArray.size();i++){
                Object o=jsonArray.get(i);
                String json2 = JSON.toJSONString(o);
                BankProduct b1=gson.fromJson(json2,BankProduct.class);
                BankFinancialProducts products=new BankFinancialProducts("中国农业银行",b1.getProdName(),b1.getProdProfit(),b1.getProdSaleDate(),b1.getProdLimit(),b1.getPurStarAmo(),b1.getProdArea(),b1.getProdYildType());
                //System.out.println(products.getProductName());
                System.out.println(products);
                }
            } catch (IOException e) {
            e.printStackTrace();
            }
        }
    }
}

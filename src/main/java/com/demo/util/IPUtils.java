package com.demo.util;

import com.Jsoup.BankFinancialProducts;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import com.demo.other.IPBean;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.*;

public class IPUtils {

    private static final String MY_IP_API = "https://www.ipip.net/ip.html";

    // 获取当前ip地址，判断是否代理成功
    public static String getMyIp() {
        try {
            String html = HttpUtils.getResponseContent(MY_IP_API);

            Document doc = Jsoup.parse(html);
            Elements element = doc.select("div.tableNormal");

            Element ele = element.select("table").select("td").get(1);

            String ip = element.select("a").text();

            // System.out.println(ip);
            return ip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 检测代理ip是否有效
     *
     * @param ipBean
     * @return
     */
/*
    public static boolean isValid(BankFinancialProducts ipBean) {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ipBean.getIp(), ipBean.getPort()));
        try {
            URLConnection httpCon = new URL("https://www.baidu.com/").openConnection(proxy);
            httpCon.setConnectTimeout(5000);
            httpCon.setReadTimeout(5000);
            int code = ((HttpURLConnection) httpCon).getResponseCode();
            System.out.println("code:----"+code);
            return code == 200;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
*/
}

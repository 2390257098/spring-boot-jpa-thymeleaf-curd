package com.demo.util;



import com.demo.other.IPBean;

import sun.net.www.protocol.http.HttpURLConnection;


import javax.net.ssl.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Asche
 * @github: https://github.com/asche910
 * @date 2019年1月19日
 */
public class HttpUtils {

    public static String getResponseContent(String url) {
        try {
            return getResponseContent(url, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getResponseContent(String url, IPBean ipBean) {
        try {
            return getResponseContent(url, null, ipBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param url
     * @param headerMap 请求头部
     * @param ipBean
     * @return
     * @throws Exception
     */
    public static String getResponseContent(String url, Map<String, List<String>> headerMap, IPBean ipBean) throws Exception {
        HttpURLConnection connection = null;
        //HttpsURLConnection connection2 = null;
        // 设置代理
        /*if (ipBean != null) {
            System.out.println("+++++++++++++");
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ipBean.getIp(), ipBean.getPort()));

            connection2 = (HttpsURLConnection) new URL(url).openConnection(proxy);

            if (ipBean.getType() == IPBean.TYPE_HTTPS) {
                //获取一个SSL实例
                SSLContext sslContext = SSLContext.getInstance("SSL");
                //初始化
                sslContext.init(null, new TrustManager[]{new TrustAnyTrustManager()}, new java.security.SecureRandom());
                connection2.setSSLSocketFactory(sslContext.getSocketFactory());
                connection2.setHostnameVerifier(new TrustAnyHostnameVerifier());
            }
        }*/
// 添加请求头部

        if (connection == null) {
            //connection2 = (HttpsURLConnection) new URL(null, url, new sun.net.www.protocol.http.Handler()).openConnection();
            connection = (HttpURLConnection)new URL(null, url, new sun.net.www.protocol.http.Handler()).openConnection();
        }
        /*if (connection2 == null) {
            connection2 = (HttpsURLConnection) new URL(null, url, new sun.net.www.protocol.http.Handler()).openConnection();
        }*/
        // 添加请求头部
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.81 Safari/537.36");
        connection.setInstanceFollowRedirects(false);
        /*connection2.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.81 Safari/537.36");
        connection2.setInstanceFollowRedirects(false);*/
        /*System.out.println("asdfghjsdfg"+connection);*/
        if (headerMap != null) {
            Iterator<Map.Entry<String, List<String>>> iterator = headerMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, List<String>> entry = iterator.next();
                List<String> values = entry.getValue();
                for (String value : values)
                    connection.setRequestProperty(entry.getKey(), value);
            }
        }

        System.out.println("----------");

        InputStream inputStream = connection.getInputStream();
        //System.out.println("biaoshi :"+inputStream);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        reader.close();
        inputStream.close();
        return stringBuilder.toString();
    }

    private static class TrustAnyTrustManager implements X509TrustManager {

        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[]{};
        }
    }

    private static class TrustAnyHostnameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }
}

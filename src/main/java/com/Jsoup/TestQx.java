package com.Jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Map;

/**
 * @Desc
 * @Author 刘慧斌
 * @CreateTime 2019-05-13 19:46
 **/
public class TestQx {
    public static void login() throws IOException {
        String urlLogin = "http://www.yymh8.com/index.php?m=&c=Mh&a=book_cate&p_reload=1&reload_time=1557747251931";
        Connection connect = Jsoup.connect(urlLogin);
        // 伪造请求头
//        connect.header("Accept", "application/json, text/javascript, */*; q=0.01").header("Accept-Encoding",
//                "gzip, deflate");
//        connect.header("Accept-Language", "zh-CN,zh;q=0.9").header("Connection", "keep-alive");
//        connect.header("Content-Length", "72").header("Content-Type",
//                "application/x-www-form-urlencoded; charset=UTF-8");
//        connect.header("Host", "qiaoliqiang.cn").header("Referer", "http://qiaoliqiang.cn/Exam/");
//        connect.header("User-Agent",
//                "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36")
//                .header("X-Requested-With", "XMLHttpRequest");

        // 携带登陆信息
        connect.data("mobile", "pkran1986").data("pass", "7788120K")
                .data("isRememberme", "yes");

        //请求url获取响应信息
        Connection.Response res = connect.ignoreContentType(true).method(Connection.Method.POST).execute();// 执行请求
        // 获取返回的cookie
        Map<String, String> cookies = res.cookies();
        for (Map.Entry<String, String> entry : cookies.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        System.out.println("---------华丽的分割线-----------");
        String body = res.body();// 获取响应体
        System.out.println(body);
    }

    public static void denglu(){
        String url="http://www.yymh8.com/index.php?m=&c=Mh&a=book_cate&p_reload=1&reload_time=1557747251931";
        try {
            Document document=Jsoup.connect(url).userAgent("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET CLR 2.0.50727; Media Center PC 6.0)")
                    .post();

            System.out.println(document.text());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TestQx.login();
        //TestQx.denglu();
    }
}

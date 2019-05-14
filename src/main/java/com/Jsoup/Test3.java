package com.Jsoup;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Map;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 * @Desc
 * @Author 刘慧斌
 * @CreateTime 2019-04-16 14:46
 **/
public class Test3 {
    public static void main(String [] args)throws Exception {
        /*String departureCity = BaiduApi.requestPinYin("成都");
        String arrivalCity = BaiduApi.requestPinYin("大英东");*/
        String departureDate = "2019-04-26";
        String url = "http://trains.ctrip.com/TrainBooking/Ajax/GetTrainDataV22.aspx?DepartureCity=成都&ArrivalCity=大英东&DepartureDate="+departureDate+"&NO=02";

        Test3.getTicketList(url);
    }
    public static Map getTicketList(String ticketurl) throws IOException {
        /*System.out.println(ticketurl);*/
        String url = ticketurl;
        Document document = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.75 Safari/537.36").get();
        Elements elements = document.select("#resultTable02 > tbody");
// System.out.println(elements.outerHtml());
        int size = elements.size();
        System.out.println("数据条数："+size);
        /*System.out.println(DateUtils.getCurrentDateTime());*/
        for (int i = 1; i < size; i++) {
            Element element = elements.get(i);
            String railway_num = element.select("td").eq(0).select(".railway_num").text();
            String railway_time = element.select("td").eq(1).select(".railway_time").text();
            String railwayArrivalCity = element.select("td").eq(2).text();
            String date = element.select("td").eq(3).text();
            String railway_seat = element.select(".railway_seat").first().text();
            String seat_num = element.select(".seat_num").first().text();
            if(seat_num.indexOf("0") < 0){
                System.out.println(railway_num + "==" + railway_time + "=="+ railwayArrivalCity + "==" + date + "==" + railway_seat.substring(0,3) + "==" + seat_num + "\n");
            }
        }
        return null;
    }}

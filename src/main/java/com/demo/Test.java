package com.demo;


import com.demo.util.IPUtils;

public class Test {
    public static void main(String[] args) {
        System.out.println("Cgbchina Start: ");
        //String ip = "119.101.118.61";
        String ip ="172.16.1.204";

        System.out.println(IPUtils.getMyIp());

        System.setProperty("proxyPort", "9999");
        System.setProperty("proxyHost", ip);
        System.setProperty("proxySet", "true");

        System.out.println(IPUtils.getMyIp());
    }
}

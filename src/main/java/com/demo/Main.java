package com.demo;

import com.Jsoup.BankFinancialProducts;
import com.demo.other.BankInfo;

import com.demo.other.IPSpider;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Asche
 * @github: https://github.com/asche910
 * @date 2019年1月19日
 */
public class Main {


    public static void main(String[] args){
        Map<String ,BankInfo> banksInfo=new HashMap<>();

        banksInfo.put("中国银行",new BankInfo("http://www.boc.cn/pbservice/pb3/",1));
        banksInfo.put("交通银行",new BankInfo("http://www.bankcomm.com/BankCommSite/shtml/jyjr/cn/7226/7266/7281/7282/list.shtml?channelId=7226",17));
        banksInfo.put("农业银行",new BankInfo("http://ewealth.abchina.com/fs/filter/",6));
        banksInfo.put("工商银行",new BankInfo("https://mybank.icbc.com.cn/icbc/newperbank/perbank3/frame/frame_index.jsp#",8));
        banksInfo.put("建设银行",new BankInfo("http://finance.ccb.com/cn/finance/product.html",34));

        banksInfo.put("恒发银行",new BankInfo("http://www.hfbank.com.cn/gryw/cfgl/lc/rmlctj/index.shtml",3));
        banksInfo.put("浦发银行",new BankInfo("https://per.spdb.com.cn/bank_financing/financial_product/",3));
        banksInfo.put("民生银行",new BankInfo("http://www.cmbc.com.cn/channelApp/finance/financial.jsp",72));
        banksInfo.put("光大银行",new BankInfo("http://www.cebbank.com/site/gryw/yglc/lccp49/index.html",3));
        banksInfo.put("中信银行",new BankInfo("https://etrade.citicbank.com/portalweb/html/finList.html",3));
        banksInfo.put("招商银行",new BankInfo("http://www.cmbchina.com/cfweb/Personal/Default.aspx",16));
        banksInfo.put("兴业银行",new BankInfo("https://www.cib.com.cn/cn/personal/wealth-management/xxcx/table/",1));
        banksInfo.put("广发银行",new BankInfo("http://www.cgbchina.com.cn/Channel/16684283?nav=2?nav=2",1));
        banksInfo.put("浙商银行",new BankInfo("http://www.czbank.com/cn/fin_kno/xxcxpt1/lccpxxcx1/201904/t20190417_16651.shtml",1));
        banksInfo.put("华夏银行",new BankInfo("http://www.hxb.com.cn/grjr/lylc/zzfsdlccpxx/index.shtml",2));
        banksInfo.put("渤海银行",new BankInfo("http://www.cbhb.com.cn/bhbank/S101/lingshouyinhangfuwu/lcfw/rxcp/2018y/index.htm",0));//PDF格式，暂不爬取
        banksInfo.put("平安银行",new BankInfo("https://bank.pingan.com.cn/m/main/index.html",1));//分类不明，暂不爬取
        System.out.println("Start: ");
        IPSpider spider = new IPSpider();
        List<BankFinancialProducts> list = spider.crawlHttp(1);

        System.out.println("爬取数量：" + list.size());

        /*Gson gson = new Gson();
        for (BankFinancialProducts ipBean : list) {
            //System.out.println(gson.toJson(ipBean));
            //检测一下代理ip是否有效
            new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean valid = IPUtils.isValid(ipBean);
                    if (valid){
                        IPList.add(ipBean);
                    }
                    IPList.increase();
                }
            }).start();
        }*/

        /*while (true){
            // 判断所有副线程是否完成
            if (IPList.getCount() == list.size()){
                System.out.println("数量："+list.size());
                System.out.println("有效数量：" + IPList.getSize());
                break;
            }
        }*/
    }
}

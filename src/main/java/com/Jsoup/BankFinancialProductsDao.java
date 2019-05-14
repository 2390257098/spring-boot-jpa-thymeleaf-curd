package com.Jsoup;

import com.Jsoup.BankFinancialProducts;
import org.springframework.stereotype.Repository;


public interface BankFinancialProductsDao {

    int insertSelective(BankFinancialProducts record);


}
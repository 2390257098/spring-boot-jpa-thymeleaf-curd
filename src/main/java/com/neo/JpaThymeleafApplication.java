package com.neo;

import com.Jsoup.BankFinancialProducts;
import com.Jsoup.BankFinancialProductsDao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import javax.annotation.Resource;


@SpringBootApplication
@MapperScan("com.neo.mapper")
public class JpaThymeleafApplication /*extends SpringBootServletInitializer */{
    /*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JpaThymeleafApplication.class);
    }*/

    public static void main(String[] args) throws Exception {
        SpringApplication.run(JpaThymeleafApplication.class, args);

    }
}


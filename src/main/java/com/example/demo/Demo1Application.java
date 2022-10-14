package com.example.demo;

import com.Parser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
        ArrayList<String> urls = new ArrayList<>();
        urls.add("https://services.it4profit.com/product/ru/720/ProductList.xml?USERNAME=ns_company&PASSWORD=NS_COMPANY123");
//        for (String url : urls) {
//            Parser.parse(url);//"https://services.it4profit.com/product/ru/720/ProductList.xml?USERNAME=ns_company&PASSWORD=NS_COMPANY123");
//        }
        Parser.parse("https://services.it4profit.com/product/ru/720/PriceAvail.xml?USERNAME=ns_company&PASSWORD=NS_COMPANY123");

    }

}

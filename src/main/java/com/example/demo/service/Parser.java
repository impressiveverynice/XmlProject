package com.example.demo.service;


import com.example.demo.response.SatuResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
@Configuration
@EnableScheduling
public class Parser {
    private final UnMarshaller unMarshaller;
    private final Marshaller marshaller;
    public String result;
    private static final List<String> urlList = new ArrayList<>();
    static {
        urlList.add("https://www.ak-cent.kz/export/Exchange/article_all/Ware0022.xml");
        urlList.add("https://shop.azerti.kz/price/import.xml");
        urlList.add("https://services.it4profit.com/product/ru/720/PriceAvail.xml?USERNAME=ns_company&PASSWORD=NS_COMPANY123");
        //zdes bil ruslan
    }



    @Scheduled(fixedDelay = 36000000)
    public void parse() throws Exception{
        log.info("Downloading from URL");
        SatuResponse response = new SatuResponse();
        for(String url : urlList) {
            String xml = urlRequest(url);
            response = unMarshaller.generateObject(response, xml, urlList.indexOf(url));
        }
        marshaller.marshal(response.getShop());
        System.out.println("Completed request to Satu");
    }

    public String urlRequest(String urlRQU) throws Exception {
        log.info("Making request to url: " + urlRQU);
        StringBuilder response = new StringBuilder();
        URL url = new URL(urlRQU);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setDoOutput(true);
        InputStream stream = con.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String tempIn;
        while ((tempIn = in.readLine()) != null) {
            response.append(tempIn);

        }
        result = response.toString();
        in.close();
        stream.close();
        con.disconnect();
        return response.toString();
    }
}

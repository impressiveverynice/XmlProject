package com.example.demo.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
@Configuration
@EnableScheduling
public class Parser {
    private final UnMarshaller unMarshaller;

    private static final List<String> urlList = new ArrayList<>();
    static {
        urlList.add("https://www.ak-cent.kz/export/Exchange/article_all/Ware0022.xml");
    }

    @Scheduled(fixedDelay = 1000000)
    public void parse() throws Exception{
        log.info("Downloading from URL");
        for(String url : urlList) {
            String xml = urlRequest(url);
            String s = unMarshaller.akcent(xml);
            System.out.println("Completed request to Satu");
        }
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
        in.close();
        stream.close();
        con.disconnect();
        return response.toString();
    }
}

package com.example.demo.service;

import com.example.demo.response.SatuOffers;
import com.example.demo.response.Shop;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import java.io.StringWriter;

@Service
@Slf4j
@RequiredArgsConstructor
public class Marshaller {
    private final LocalFile fileWriter;
    public String marshal(Shop shop) throws Exception{
        log.info("Marshalling started");
        JAXBContext context = JAXBContext.newInstance(Shop.class);
        String xmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
        xmlHeader += "<yml_catalog date=\"2022-10-15 18:55\">\n";
        String xmlFooter = "</yml_catalog>";
        javax.xml.bind.Marshaller marshaller = context.createMarshaller();
        StringWriter writer = new StringWriter();
        marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT, true);
        marshaller.marshal(shop,writer);
        fileWriter.createFile(xmlHeader+writer+xmlFooter);
        return "done";
    }
}

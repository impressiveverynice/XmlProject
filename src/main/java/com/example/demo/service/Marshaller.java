package com.example.demo.service;

import com.example.demo.response.SatuOffers;
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
    public String marshal(SatuOffers satuOffers) throws Exception{
        log.info("Marshalling started");
        JAXBContext context = JAXBContext.newInstance(SatuOffers.class);
        String xmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
        xmlHeader += "<yml_catalog date=\"2022-10-15 18:55\">\n" +
                "<shop>\n" +
                "<currencies><currency id=\"KZT\" rate=\"1\" plus=\"0\"/></currencies>";
        xmlHeader += "<categories><category id=\"000002695\">Чист. ср-во для техники IT</category></categories>";
        String xmlFooter = "</shop></yml_catalog>";
        javax.xml.bind.Marshaller marshaller = context.createMarshaller();
        StringWriter writer = new StringWriter();
        marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FRAGMENT, true);
        marshaller.marshal(satuOffers,writer);
        fileWriter.createFile(xmlHeader+writer+xmlFooter);
        return "done";
    }
}

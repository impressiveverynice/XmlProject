package com.example.demo.service;

import com.example.demo.it4profit.request.it4profit.It4profit;
import com.example.demo.it4profit.request.it4profit.Price;
import com.example.demo.response.Offer;
import com.example.demo.response.SatuOffers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UnMarshaller {
    private final Marshaller marshal;

    public String it4profit(String xml) throws Exception {
        log.info("Unmarshalling XML for it4profit");
        JAXBContext context = JAXBContext.newInstance(It4profit.class);
        javax.xml.bind.Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader sr = new StringReader(xml);
        It4profit unmarshalledObject = (It4profit) unmarshaller.unmarshal(sr);

        SatuOffers satuOffers = new SatuOffers();
        List<Offer> offerList = new ArrayList<>();
        int id = 1;

        for(Price product : unmarshalledObject.getPrices().getPrice()) {
            if(id == 3 ) break;
            Offer offer = new Offer();
            offer.setDescription(product.getDescription());
            offer.setCurrencyCode(offer.getCurrencyCode());
            offer.setAvailable(true);
            offer.setId(id++);
            offer.setRetailPrice(offer.getRetailPrice());
            offer.setUrl(offer.getProductCard());
            offer.setPrice(100);
            offer.setName("test");
            offer.setType("Чист. ср-во для техники IT");
            offer.setCategoryId("000002695");
            offerList.add(offer);
        }
        satuOffers.setOffer(offerList);
        return marshal.marshal(satuOffers);
    }
}

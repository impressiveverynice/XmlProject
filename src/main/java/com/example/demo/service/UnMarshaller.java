package com.example.demo.service;

import com.example.demo.akcent.Akcent;
import com.example.demo.akcent.AkcentOffer;
import com.example.demo.response.Offer;
import com.example.demo.response.SatuOffers;
import com.example.demo.response.SatuResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UnMarshaller {
    private final Marshaller marshal;

    //todo
    public String akcent(String xml) throws Exception {
        xml = xml.replaceAll("[^\\x20-\\x7e]", "");
        log.info("Unmarshalling XML for akcent");
        JAXBContext context = JAXBContext.newInstance(Akcent.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader sr = new StringReader(xml);
        Akcent unmarshalledObject = (Akcent) unmarshaller.unmarshal(sr);
        SatuResponse response = new SatuResponse();
        response.getShop().setCategoriesList(unmarshalledObject.getShop().getCategories());
        response.getShop().setCurrencies(unmarshalledObject.getShop().getCurrencies());
        int id = 1;
        List<Offer> offers = new ArrayList<>();
        for(AkcentOffer product : unmarshalledObject.getShop().getAkcentOffers().getAkcentOffer()) {
            if(id == 3 ) break;
            if(product.getCategoryId().isEmpty()) continue;
            if(product.getPrices().getPrice() == null) continue;
            id++;
            Offer offer = new Offer();
            offer.setDescription(product.getDescription());
            offer.setId(product.getOfferId());
            offer.setAvailable(true);
            offer.setUrl(product.getUrl());
            offer.setSmallImage(product.getPicture());
            offer.setQuantityInStock(product.getStock());
            offer.setVendor(product.getVendor());
            offer.setProductCard(product.getOfferArticle());
            offer.setName(product.getName());
            offer.setType(product.getOfferType());
            offer.setCurrencyCode(product.getPrices().getPrice().get(0).getCurrencyId());
            Double incrementPrice = product.getPrices().getPrice().get(0).getValue() * 1.2;
            offer.setPrice(String.format("%.0f", incrementPrice));
            offer.setCategoryId(product.getCategoryId());
            offers.add(offer);
        }
        SatuOffers satuOffers = new SatuOffers();
        satuOffers.setOfferList(offers);
        response.getShop().setOffers(satuOffers);
        return marshal.marshal(response.getShop());
    }
    //todo
//    public String azerti(String xml) throws Exception {
//        log.info("Unmarshalling XML for it4profit");
//        JAXBContext context = JAXBContext.newInstance(It4profit.class);
//        javax.xml.bind.Unmarshaller unmarshaller = context.createUnmarshaller();
//        StringReader sr = new StringReader(xml);
//        It4profit unmarshalledObject = (It4profit) unmarshaller.unmarshal(sr);
//
//        SatuOffers satuOffers = new SatuOffers();
//        List<Offer> offerList = new ArrayList<>();
//        int id = 1;
//
//        for(Price product : unmarshalledObject.getPrices().getPrice()) {
//            if(id == 3 ) break;
//            Offer offer = new Offer();
//            offer.setDescription(product.getDescription());
//            offer.setCurrencyCode(offer.getCurrencyCode());
//            offer.setAvailable(true);
//            offer.setId(id++);
//            offer.setRetailPrice(offer.getRetailPrice());
//            offer.setUrl(offer.getProductCard());
//            offer.setPrice(100);
//            offer.setName("test");
//            offer.setType("Чист. ср-во для техники IT");
//            offer.setCategoryId("000002695");
//            offerList.add(offer);
//        }
//        satuOffers.setOffer(offerList);
//        return marshal.marshal(satuOffers);
//    }
//    public String it4profit(String xml) throws Exception {
//        log.info("Unmarshalling XML for it4profit");
//        JAXBContext context = JAXBContext.newInstance(It4profit.class);
//        javax.xml.bind.Unmarshaller unmarshaller = context.createUnmarshaller();
//        StringReader sr = new StringReader(xml);
//        It4profit unmarshalledObject = (It4profit) unmarshaller.unmarshal(sr);
//
//        SatuOffers satuOffers = new SatuOffers();
//        List<Offer> offerList = new ArrayList<>();
//        int id = 1;
//
//        for(Price product : unmarshalledObject.getPrices().getPrice()) {
//            if(id == 3 ) break;
//            Offer offer = new Offer();
//            offer.setDescription(product.getDescription());
//            offer.setCurrencyCode(offer.getCurrencyCode());
//            offer.setAvailable(true);
//            offer.setId(id++);
//            offer.setRetailPrice(offer.getRetailPrice());
//            offer.setUrl(offer.getProductCard());
//            offer.setPrice(100);
//            offer.setName("test");
//            offer.setType("Чист. ср-во для техники IT");
//            offer.setCategoryId("000002695");
//            offerList.add(offer);
//        }
//        satuOffers.setOffer(offerList);
//        return marshal.marshal(satuOffers);
//    }
}

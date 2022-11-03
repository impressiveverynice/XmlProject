package com.example.demo.service;

import com.example.demo.akcent.Akcent;
import com.example.demo.akcent.AkcentOffer;
import com.example.demo.azerti.Azerti;
import com.example.demo.azerti.AzertiOffer;
import com.example.demo.it4profit.request.it4profit.It4profit;
import com.example.demo.it4profit.request.it4profit.Price;
import com.example.demo.it4profit.request.it4profit.Prices;
import com.example.demo.marcom.Marcom;
import com.example.demo.marcom.MarcomOffer;
import com.example.demo.response.Category;
import com.example.demo.response.Offer;
import com.example.demo.response.SatuOffers;
import com.example.demo.response.SatuResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UnMarshaller {
    private final Marshaller marshal;

    public SatuResponse generateObject(SatuResponse response, String xml, int provider) throws Exception {
        if(provider == 0) {
             response = akcent(xml, response);
        }
        if(provider == 1) {
             response = azerti(xml,response);
        }
        if(provider == 2) {
            response = it4profit(xml, response);
        }

        return response;
    }

    private SatuResponse akcent(String xml, SatuResponse response) throws Exception {
        String customXml = xml.substring(1);
        log.info("Unmarshalling XML for akcent");
        JAXBContext context = JAXBContext.newInstance(Akcent.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader sr = new StringReader(customXml);
        Akcent unmarshalledObject = (Akcent) unmarshaller.unmarshal(sr);
        response.getShop().getCategoriesList().getCategoryList().addAll(unmarshalledObject.getShop().getCategories().getCategoryList());
        response.getShop().getCurrencies().getCurrencyList().addAll(unmarshalledObject.getShop().getCurrencies().getCurrencyList());
        List<Offer> offers = new ArrayList<>();
        for (AkcentOffer product : unmarshalledObject.getShop().getAkcentOffers().getAkcentOffer()) {
            if (product.getCategoryId().isEmpty()) continue;
            if (product.getPrices().getPrice() == null) continue;
            Offer offer = new Offer();
            offer.setDescription(product.getDescription());
            offer.setId(product.getOfferId());
            offer.setAvailable(true);
            offer.setUrl(product.getUrl());
            offer.setPicture(product.getPicture());
            offer.setQuantityInStock(product.getStock());
            offer.setVendor(product.getVendor());
            offer.setVendorCode(product.getOfferArticle());
            offer.setProductCard(product.getOfferArticle());
            offer.setName(product.getName());
            offer.setType(product.getOfferType());
            offer.setCurrencyCode(product.getPrices().getPrice().get(1).getCurrencyId());
            Double incrementPrice = product.getPrices().getPrice().get(1).getValue() * 1.2;
            offer.setPrice(String.format("%.0f", incrementPrice));
            offer.setCategoryId(product.getCategoryId());
            offers.add(offer);
        }
        response.getShop().getOffers().getOfferList().addAll(offers);
        return response;
    }

    private SatuResponse azerti(String xml, SatuResponse response) throws Exception {
        log.info("Unmarshalling XML for azerti");
        String customXml = xml.substring(1);
        JAXBContext context = JAXBContext.newInstance(Azerti.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader sr = new StringReader(customXml);
        Azerti unmarshalledObject = (Azerti) unmarshaller.unmarshal(sr);
        response.getShop().getCategoriesList().getCategoryList().addAll(unmarshalledObject.getShop().getCategories().getCategoryList());
        response.getShop().getCurrencies().getCurrencyList().addAll(unmarshalledObject.getShop().getCurrencies().getCurrencyList());
        List<Offer> offers = new ArrayList<>();
        for (AzertiOffer product : unmarshalledObject.getShop().getAzertiOffers().getAzertiOffer()) {
            if (product.getCategoryId().isEmpty()) continue;
            if (product.getPrice() == null || product.getPrice() < 1) continue;
            if(product.getStock().isBlank() || Integer.parseInt(product.getStock()) < 1) continue;

            Offer offer = new Offer();
            offer.setId(product.getOfferId());
            offer.setAvailable(true);
            offer.setQuantityInStock(product.getStock());
            offer.setVendor(product.getVendor());
            offer.setVendorCode(product.getOfferId());
            offer.setProductCard(product.getOfferTnved());
            offer.setName(product.getNameshot());
            offer.setDescription(product.getName());
            offer.setType("");
            offer.setCurrencyCode(product.getCurrencyId());
            Double incrementPrice = product.getPrice() * 1.2;
            offer.setPrice(String.format("%.0f", incrementPrice));
            offer.setCategoryId(product.getCategoryId());
            offers.add(offer);
        }
       offers.parallelStream().forEach(offer -> {
            try {
                offer.setPicture(getImageUrl(offer.getName()));
            }catch (Exception ex) {
                log.info(ex.getMessage());
            }
        });
        response.getShop().getOffers().getOfferList().addAll(offers);
        return response;
    }

    private SatuResponse it4profit(String xml, SatuResponse response) throws Exception {
        System.out.println("first char: " + xml.substring(0, 10));
        log.info("Unmarshalling XML for it4profit");
        JAXBContext context = JAXBContext.newInstance(It4profit.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader sr = new StringReader(xml);
        It4profit unmarshalledObject = (It4profit) unmarshaller.unmarshal(sr);
        int id = 1;
        List<Offer> offers = new ArrayList<>();
        List<Category> categoryList = new ArrayList<>();
        for (Price product : unmarshalledObject.getPrices().getPrice()) {
            if(product.getDescription().isEmpty()) continue;
            if(product.getMyPrice() == 0) continue;
            Category category = new Category();
            category.setId(String.valueOf(product.getGroupId()));
            category.setValue(product.getGroupName());
            categoryList.add(category);
            Offer offer = new Offer();
            offer.setDescription(product.getDescription());
            offer.setId("010101" + id++);
            offer.setAvailable(true);
            offer.setUrl(product.getProductCard());
            offer.setPicture(product.getSmallImage());
            offer.setQuantityInStock(String.valueOf(product.getAvail()));
            offer.setVendor(product.getVendorName());
            offer.setVendorCode(product.getWic());
            offer.setProductCard(product.getEan());
            offer.setName(product.getDescription());
            offer.setType(product.getGroupName());
            offer.setCurrencyCode("KZT");
                Double incrementPrice = product.getMyPrice() * 1.2;
            offer.setPrice(String.format("%.0f", incrementPrice));
            offer.setCategoryId(String.valueOf(product.getGroupId()));
            offers.add(offer);
        }
        response.getShop().getCategoriesList().getCategoryList().addAll(categoryList);
        response.getShop().getOffers().getOfferList().addAll(offers);
        return response;
    }

    private SatuResponse marcom(String xml, SatuResponse response) throws Exception {
        log.info("Unmarshalling XML for marcom");
        String customXml = xml.substring(1);
        JAXBContext context = JAXBContext.newInstance(Marcom.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader sr = new StringReader(customXml);
        Marcom unmarshalledObject = (Marcom) unmarshaller.unmarshal(sr);
        response.getShop().getCategoriesList().getCategoryList().addAll(unmarshalledObject.getShop().getCategories().getCategoryList());
        response.getShop().getCurrencies().getCurrencyList().addAll(unmarshalledObject.getShop().getCurrencies().getCurrencyList());
        List<Offer> offers = new ArrayList<>();
        for (MarcomOffer product : unmarshalledObject.getShop().getMarcomOffers().getMarcomOffer()) {
            if (product.getCategoryId().isEmpty()) continue;
            if (product.getPrices().getPrice().get(0) == null
                    || product.getPrices().getPrice().get(0).getValue() < 1) continue;
            Offer offer = new Offer();
            offer.setId(product.getOfferId());
            offer.setAvailable(true);
            offer.setQuantityInStock(product.getStock());
            offer.setVendor(product.getVendor());
            offer.setVendorCode(product.getOfferId());
            offer.setName(product.getName());
            offer.setDescription(product.getName());
            offer.setType("");
            offer.setCurrencyCode("KZT");
            Double incrementPrice = product.getPrices().getPrice().get(0).getValue() * 1.15;
            offer.setPrice(String.format("%.0f", incrementPrice));
            offer.setCategoryId(product.getCategoryId());
            offers.add(offer);
        }
        offers.parallelStream().forEach(offer -> {
            try {
                offer.setPicture(getImageUrl(offer.getName()));
            }catch (Exception ex) {
                log.info(ex.getMessage());
            }
        });
        response.getShop().getOffers().getOfferList().addAll(offers);
        return response;
    }


    public String getImageUrl(String img) throws IOException {
        log.info("Looking for image for : " + img);
        img = img.replace(" ", "%20");
        Document document = Jsoup.connect("https://google.com/search?tbm=isch&q="+img).userAgent("Mozilla").get();
        Elements imgList = document.getElementsByTag("img");
        List<String> images = new ArrayList<>();
        for(Element el : imgList) {
            if(images.size()>1) break;
            String src = el.attr("src");
            if(!src.isEmpty())
                images.add(src);
        }
        if(images.size() < 2) return "";
        return images.get(1);
    }

}

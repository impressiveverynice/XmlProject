package com;


import com.example.demo.it4profit.OLDREQUEST.Product;
import com.example.demo.it4profit.OLDREQUEST.ProductCatalog;
import com.example.demo.it4profit.request.Content;
import com.example.demo.it4profit.request.Price;
import com.example.demo.it4profit.request.Prices;
import com.example.demo.it4profit.response.Offer;
import com.example.demo.it4profit.response.Offers;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Parser {

    public static void parse (String myurl) {
        System.out.println("Downloading from URL");
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL(myurl);
            HttpURLConnection con = null;
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setDoOutput(true);
            InputStream stream = con.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String tempIn = "";
            while((tempIn = in.readLine()) != null) {
                response.append(tempIn);
            }
            in.close();
            con.disconnect();
            unMarshal(response.toString());
            stream.close();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ProductCatalog unMarshal(String xml, Class<?> cls) throws JAXBException {
        ProductCatalog pc;
        JAXBContext context = JAXBContext.newInstance(cls.getClass());
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader sr = new StringReader(xml);
        if(cls.getClass().equals(Content.class)) {
            Content content = (Content) unmarshaller.unmarshal(sr);
            responseXml(content);
            return content;
        }
//        responseXml(pc);
        return pc;
    }

    public static String marshal(Offers offers) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Offers.class);
        String xmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><!DOCTYPE yml_catalog SYSTEM \"shops.dtd\">";
        Marshaller marshaller = context.createMarshaller();
        StringWriter writer = new StringWriter();
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        marshaller.marshal(offers,writer);
        return xmlHeader +  writer;
    }
    public static void responseXml(Content content) throws JAXBException {
        Offers offers = new Offers();
        ArrayList<Offer> offerList = new ArrayList<>();
        Prices prices = content.getPrices();
        for(Price price : prices.getPrice()) {
            Offer offer = new Offer();
            offer.setPrice(price.getRetailPrice()*1.2);
            offer.setCurrencyId("KZT");
            offer.setCategoryId(999);
            offer.setUrl(price.);
            offer.setDescription(price.getDescription());


//            ArrayList<Params> params;
//                    for(AttrList.Element s : product.getAttrlist().getElement()) {
//                        Params param = new Params();
//                        param
//                    }
//            offer.setParams();
            offerList.add(offer);
        }
        offers.setOffer(offerList);
        String marshal = marshal(offers);
        System.out.println(marshal);
    }

}

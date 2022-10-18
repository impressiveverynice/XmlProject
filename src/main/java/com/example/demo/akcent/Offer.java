package com.example.demo.akcent;

import com.example.demo.it4profit.OLDREQUEST.Images;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class Offer {
    @XmlAttribute
    private String offerIdAttribute;
    @XmlAttribute
    private String offerArticle;
    @XmlAttribute(name = "type")
    private String offerType;
    @XmlAttribute(name = "available")
    private Boolean offerAvailable;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "url")
    private String url;
    @XmlElement(name = "Offer_ID")
    private String offerId;
    @XmlElement(name = "categoryId")
    private String categoryId;
    @XmlElement(name = "picture")
    private String picture;
    @XmlElement(name = "delivery")
    private Boolean delivery;
    @XmlElement(name = "local_delivery_cost")
    private Integer localDeliveryCost;
    @XmlElement(name = "vendor")
    private String vendor;
    @XmlElement(name = "model")
    private String model;
    @XmlElement(name = "description")
    private String description;
    @XmlElement(name = "manufacturer_warranty")
    private String manufacturer_warranty;
    @XmlElement(name = "stock")
    private String stock;
    @XmlElement(name = "prices")
    private Prices prices;
}

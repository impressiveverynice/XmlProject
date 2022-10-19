package com.example.demo.azerti;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
public class AzertiOffer {
    @XmlAttribute (name = "id")
    private String offerId;
    @XmlAttribute (name = "tnved")
    private String offerTnved;
    @XmlAttribute (name = "available")
    private Boolean offerAvailable;
    @XmlElement (name = "name")
    private String name;
    @XmlElement (name = "nameshot")
    private String nameshot;
    @XmlElement (name = "stock")
    private String stock;
    @XmlElement (name = "price")
    private Double price;
    @XmlElement (name = "currencyId")
    private String currencyId;
    @XmlElement (name = "categoryId")
    private String categoryId;
    @XmlElement (name = "vendor")
    private String vendor;
    @XmlElement (name = "model")
    private String model;
    @XmlElement (name = "ean")
    private String ean;
}

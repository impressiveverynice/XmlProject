package com.example.demo.marcom;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
public class MarcomOffer {
    @XmlElement (name = "name")
    private String name;
    @XmlElement (name = "description")
    private String description;
    @XmlElement (name = "Stock")
    private String stock;
    @XmlElement (name = "categoryId")
    private String categoryId;
    @XmlElement(name = "prices")
    private Prices prices;
}

package com.example.demo.response;


import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@XmlRootElement(name = "shop")
public class Shop {
    @XmlElement(name = "currencies")
    private Currencies currencies = new Currencies();
    @XmlElement(name = "categories")
    private Categories categoriesList = new Categories();
    @XmlElement(name = "offers")
    private SatuOffers offers = new SatuOffers();
}

package com.example.demo.marcom;

import com.example.demo.azerti.AzertiOffers;
import com.example.demo.response.Categories;
import com.example.demo.response.Currencies;
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
public class Shop {
    @XmlElement(name = "offers")
    private AzertiOffers azertiOffers;
    @XmlElement(name = "categories")
    private Categories categories;
    @XmlElement(name = "currencies")
    private Currencies currencies;
}

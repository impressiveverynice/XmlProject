package com.example.demo.akcent;

import com.example.demo.response.Categories;
import com.example.demo.response.Currencies;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
public class Shop {
    @XmlElement(name = "offers")
    private AkcentOffers akcentOffers;
    @XmlElement(name = "categories")
    private Categories categories;
    @XmlElement(name = "currencies")
    private Currencies currencies;
}

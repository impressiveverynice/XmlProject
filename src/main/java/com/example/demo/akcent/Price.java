package com.example.demo.akcent;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class Price {
    @XmlElement(name = "price")
    private String price;
    @XmlAttribute
    String type;
    @XmlAttribute
    String currencyId;
}

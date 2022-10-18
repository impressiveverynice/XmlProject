package com.example.demo.akcent;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
public class Currency {
    @XmlAttribute(name = "id")
    private String currenciesId;
    @XmlAttribute (name = "rate")
    private Integer currencyRate;
    @XmlAttribute (name = "plus")
    private Integer currencyPlus;
}

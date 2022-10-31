package com.example.demo.marcom;

import com.example.demo.azerti.Currency;
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
public class Currencies {
    @XmlElement(name = "currency")
    private Currency currency;
}

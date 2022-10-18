package com.example.demo.akcent;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "price")
public class Price {
    @XmlValue
    private Double value;
    @XmlAttribute
    private String type;
    @XmlAttribute
    private String currencyId;
}

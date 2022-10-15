package com.example.demo.it4profit.request.it4profit;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@ToString
@Getter
@Setter
@XmlRootElement(name = "CONTENT")
public class It4profit {
    @XmlElement(name = "PRICES")
    Prices prices;
}

package com.example.demo.it4profit.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@ToString
@Getter
@Setter
@XmlRootElement(name = "offers")
public class SatuOffers {
    @XmlElement(name = "offer")
    private List<Offer> offer;
}

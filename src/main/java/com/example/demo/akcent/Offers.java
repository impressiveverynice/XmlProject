package com.example.demo.akcent;

import com.example.demo.it4profit.request.it4profit.Price;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
public class Offers {
    @XmlElement(name = "offer")
    private List<Offer> offer;
}

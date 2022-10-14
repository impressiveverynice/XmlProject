package com.example.demo.it4profit.request;

import com.example.demo.it4profit.OLDREQUEST.Product;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
public class Prices {
    @XmlElement(name = "PRICE")
    private List<Price> price;
}

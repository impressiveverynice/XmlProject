package com.example.demo.akcent;

import com.example.demo.it4profit.OLDREQUEST.Images;


import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Prices {
    @XmlElement(name = "Prices")
    List<Price> price;
}

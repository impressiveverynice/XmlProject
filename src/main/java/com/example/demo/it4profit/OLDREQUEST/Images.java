package com.example.demo.it4profit.OLDREQUEST;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class Images {
    @XmlElement(name = "Image")
    private String image;
}

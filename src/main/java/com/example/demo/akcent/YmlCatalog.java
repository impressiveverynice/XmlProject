package com.example.demo.akcent;

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
@XmlRootElement(name = "yml_catalog")
public class YmlCatalog {
    @XmlElement(name = "offers")
    Offers offers;
}

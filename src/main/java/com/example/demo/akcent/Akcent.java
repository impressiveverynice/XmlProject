package com.example.demo.akcent;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "yml_catalog")
@Getter
@Setter
public class Akcent {
    @XmlElement(name = "shop")
    private Shop shop;
}

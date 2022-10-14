package com.example.demo.it4profit.OLDREQUEST;


import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
    @XmlElement(name = "ProductCode")
    private String productCode;
    @XmlElement(name = "Vendor")
    private String vendor;
    @XmlElement(name = "ProductType")
    private String productType;
    @XmlElement(name = "ProductDescription")
    private String productDescription;
    @XmlElement(name = "ProductCard")
    private String productCard;
    @XmlElement(name = "Images")
    private List<Images> image;
//    @XmlElement(name = "Attrlist")
//    private AttrList attrlist;
}

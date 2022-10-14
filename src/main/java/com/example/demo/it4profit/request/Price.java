package com.example.demo.it4profit.request;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class Price {
    @XmlElement(name = "WIC")
    private String wic;
    @XmlElement(name = "DESCRIPTION")
    private String description;
    @XmlElement(name = "VENDOR_NAME")
    private String vendorName;
    @XmlElement(name = "GROUP_NAME")
    private String groupName;
    @XmlElement(name = "VPF_NAME")
    private String vpfName;
    @XmlElement(name = "CURRENCY_CODE")
    private String currencyCode;
    @XmlElement(name = "AVAIL")
    private Integer avail;
    @XmlElement(name = "RETAIL_PRICE")
    private double retailPrice;
    @XmlElement(name = "MY_PRICE")
    private double myPrice;
    @XmlElement(name = "WARRANTYTERM")
    private Integer warrantyTerm;
    @XmlElement(name = "GROUP_ID")
    private Integer groupId;
    @XmlElement(name = "VENDOR_ID")
    private Integer vendorId;
    @XmlElement(name = "SMALL_IMAGE")
    private String smallImage;
    @XmlElement(name = "PRODUCT_CARD")
    private String productCard;
    @XmlElement(name = "EAN")
    private String ean;
}

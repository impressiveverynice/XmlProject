package com.example.demo.it4profit.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
public class Offer {
    @XmlAttribute (name = "id")
    Integer id;
    @XmlElement(name = "price")
    double price;
    @XmlElement(name = "purchase_price")
    String purchasePrice;
    @XmlElement(name = "currencyId")
    String currencyId;
    @XmlElement(name = "categoryId")
    Integer categoryId;
    @XmlElement(name = "url")
    String url;
    @XmlElement(name = "vendorCode")
    String vendorCode;
    @XmlElement(name = "picture")
    List<Pictures> pictures;
    @XmlElement(name = "available")
    Boolean available;
    @XmlElement(name = "quantity")
    Integer quantity;
    @XmlElement(name = "quantity_in_stock")
    String quantityInStock;
    @XmlElement(name = "vendor")
    String vendor;
    @XmlElement(name = "name")
    String name;
    @XmlElement(name = "description")
    String description;
    @XmlElement(name = "param")
    List<Params> params;
}

package com.example.demo.response;

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
    @XmlAttribute(name = "type")
    String type;
    @XmlElement(name = "price")
    Integer price;
    @XmlElement(name = "RETAIL_PRICE")
    String retailPrice;
    @XmlElement(name = "CURRENCY_CODE")
    String currencyCode;
    @XmlElement(name = "GROUP_ID")
    Integer groupID;
    @XmlElement(name = "url")
    String url;
    @XmlElement(name = "vendorId")
    String vendorId;
    @XmlElement(name = "SMALL_IMAGE")
    String smallImage;
    @XmlElement(name = "PRODUCT_CARD")
    String productCard;
    @XmlAttribute(name = "available")
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
    @XmlElement(name = "categoryId")
    String categoryId;
    @XmlElement(name = "param")
    List<Params> params;
}

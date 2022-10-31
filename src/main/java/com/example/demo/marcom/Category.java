package com.example.demo.marcom;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
public class Category {
    @XmlAttribute(name = "id")
    private String categoryId;
    @XmlValue
    private String categoryName;
}

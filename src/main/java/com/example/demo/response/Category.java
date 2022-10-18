package com.example.demo.response;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@XmlRootElement(name = "category")
@ToString
public class Category {
    @XmlAttribute
    private String id;
    @XmlValue
    private String value;

}

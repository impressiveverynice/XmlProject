package com.example.demo.response;


import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@XmlRootElement(name = "currency")
public class Currency {
    @XmlAttribute
    private String id;
    @XmlAttribute
    private Integer rate;
}

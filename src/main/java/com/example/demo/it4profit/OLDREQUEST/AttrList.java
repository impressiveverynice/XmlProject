package com.example.demo.it4profit.OLDREQUEST;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;


@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class AttrList {
    @XmlElement(name = "element")
    private List<Element> element;

    @Getter
    @Setter
    @XmlAccessorType(XmlAccessType.FIELD)
    public class Element{
        @XmlAttribute(name = "Name")
        private String name;
        @XmlAttribute(name = "Value")
        private String value;
    }

}

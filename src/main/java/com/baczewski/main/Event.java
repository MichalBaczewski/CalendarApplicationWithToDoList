package com.baczewski.main;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlType(name = "event")
@XmlAccessorType(XmlAccessType.FIELD)
public class Event {
    @XmlAttribute(name = "date")
    private String date;
    @XmlValue
    private String name;
}

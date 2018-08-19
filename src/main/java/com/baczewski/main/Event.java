package com.baczewski.main;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlType(name = "event")
@XmlAccessorType(XmlAccessType.FIELD)
public class Event {
    //    @XmlAttribute(name = "date")
//    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
//    private LocalDateTime date;
    @XmlAttribute(name = "date")
    private String date;
    @XmlValue
    private String name;
}

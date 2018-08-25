package com.baczewski.main;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlType(name = "event")
@XmlAccessorType(XmlAccessType.FIELD)
public class Event {
    @XmlAttribute(name = "date")
    private String date;
    @XmlAttribute (name = "name")
    private String name;
    @XmlElement(name = "guest")
    private List<Guest> guestList = new ArrayList<>();

    public Event(String date, String name) {
        this.date = date;
        this.name = name;
    }
}

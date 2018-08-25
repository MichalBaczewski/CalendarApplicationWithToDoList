package com.baczewski.main;


import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlType(name = "guest")
@XmlAccessorType(XmlAccessType.FIELD)

public class Guest {
    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute (name = "email")
    private String email;
}

package com.baczewski.main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateParser {
    private final PropertiesLoader propertiesLoader;

    public LocalDateParser(PropertiesLoader propertiesLoader) {
        this.propertiesLoader = propertiesLoader;

    }
    String toDisplayString(String dateInRawString){
        LocalDateTime localDateTime = toLocalDateTime(dateInRawString);
        return toDisplayString(localDateTime);
    }

    String toDisplayString(LocalDateTime localDateTime){
        String outputDateFormat = propertiesLoader.getOutputDateFormat();
        DateTimeFormatter formatter = DateTimeFormatter.
                ofPattern(outputDateFormat);
        return localDateTime.format(formatter);
    }
    public LocalDateTime toLocalDateTime(String string){
        String inputDateFormat = propertiesLoader.getInputDateFormat();
        DateTimeFormatter formatter = DateTimeFormatter.
                ofPattern(inputDateFormat);
        return LocalDateTime.parse(string, formatter);
    }
}

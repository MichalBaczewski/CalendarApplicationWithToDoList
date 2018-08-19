package com.baczewski.main;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EventLineParser {

    public String toLine(Event event){
        return event.getDate() + " ; " +event.getName();
    }

    public Optional<Event> toEvent(String line){
        Pattern compile = Pattern.compile("(.+) ; (.*)");
        Matcher matcher = compile.matcher(line);
        if (matcher.find()) {
            String date = matcher.group(1);
            String name = matcher.group(2);
            return Optional.of(new Event(date, name));
        }
        return Optional.empty();
    }
}

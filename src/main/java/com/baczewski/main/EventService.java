package com.baczewski.main;

import com.baczewski.main.repository.EventRepository;

import java.io.IOException;
import java.util.Optional;


public class EventService {
    private final EventRepository repository;
    private final LocalDateParser localDateParser;
    private final EventLineParser eventLineParser;
    private final PropertiesLoader propertiesLoader;

    EventService(EventRepository repository,
                 LocalDateParser localDateParser, EventLineParser eventLineParser, PropertiesLoader propertiesLoader) {
        this.repository = repository;
        this.localDateParser = localDateParser;
        this.eventLineParser = eventLineParser;
        this.propertiesLoader = propertiesLoader;
    }

    public void printAllEvents() {
//        for (Event event : repository.getAll()) {
//            printEvent(event);
//        }
        repository.getAll().forEach(this::printEvent);
    }

    public void printClosestEvent() {
        Optional<Event> event = repository.getCloserEvent();
        String display = event.map(this::getDisplayEvent)
                .orElse("Nie ma najblizszego wydarzenia");
        System.out.println(display);
    }

    private void printEvent(Event event) {
        System.out.println("Event name:" + event.getName());
        String string = localDateParser.toDisplayString(event.getDate());
        System.out.println("date: " + string);
    }

    private String getDisplayEvent(Event event) {
        String displayString = localDateParser.toDisplayString(event.getDate());
        return "Event name:"
                + event.getName()
                +"\ndate: "
                + displayString;
    }

    public void saveEvent(String string) {
        Optional<Event> eventOptional = eventLineParser.toEvent(string);
        eventOptional.ifPresent(event -> {
            try {
                repository.saveEvent(event);
            } catch (IOException e) {
                System.out.println("Nie udało się zapisać wydarzenia.");
            }
        });
    }
}

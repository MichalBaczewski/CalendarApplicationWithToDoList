package com.baczewski.main;

import com.baczewski.main.repository.EventRepository;
import com.baczewski.main.repository.RepositoryFactory;

import java.io.IOException;

class CalendarApplication {
    public static void main(String[] args) throws IOException {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        EventLineParser eventLineParser = new EventLineParser();
        LocalDateParser localDateParser = new LocalDateParser(propertiesLoader);
        RepositoryFactory eventFactory= new RepositoryFactory(propertiesLoader, localDateParser, eventLineParser);
        EventRepository eventRepository = eventFactory.getRepository();
        EventService eventService = new EventService(eventRepository, localDateParser);
        eventService.printAllEvents();
//        eventRepository.saveEvent(new Event("16062018 13:49", "Nowe wydarzenie"));
//        System.out.println("================");
//        eventService.printAllEvents();

//        eventService.printCloserEvent();

    }
}

package com.baczewski.main.repository;

import com.baczewski.main.Event;
import com.baczewski.main.EventLineParser;
import com.baczewski.main.LocalDateParser;
import com.baczewski.main.PropertiesLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class EventTxtRepository implements EventRepository {
    private PropertiesLoader propertiesLoader;
    private final EventLineParser parser;

    private LocalDateParser localDateParser;


    public EventTxtRepository(PropertiesLoader propertiesLoader,
                              EventLineParser parser, LocalDateParser localDateParser) {
        this.propertiesLoader = propertiesLoader;
        this.parser = parser;
        this.localDateParser = localDateParser;

    }

    @Override
    public List<Event> getAll() {
        try {
            Path path = Paths.get(propertiesLoader.getEventPath());
            Stream<Event> eventStream = Files.lines(path)
                    .map(parser::toEvent)
                    .filter(Optional::isPresent)
                    .map(Optional::get);
            return eventStream
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public Optional<Event> getCloserEvent() {
        LocalDateTime actualDate = LocalDateTime.now();
        LocalDateTime closestDate = LocalDateTime.MAX;
        Event closestEvent = null;

        for (Event event : getAll()) {
            LocalDateTime dateToCompare = localDateParser.toLocalDateTime(event.getDate());
            if (dateToCompare.isAfter(actualDate) && dateToCompare.isBefore(closestDate)) {
                closestDate = dateToCompare;
                closestEvent = event;
            }
        }
        return Optional.ofNullable(closestEvent);
    }

    @Override
    public void saveEvent(Event event) throws IOException {
        Path path = Paths.get(propertiesLoader.getEventPath());
        String line = parser.toLine(event);
        Files.write(path,
                line.getBytes(),
                StandardOpenOption.APPEND);
    }

}

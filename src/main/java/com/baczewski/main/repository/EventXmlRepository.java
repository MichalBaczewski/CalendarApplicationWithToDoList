package com.baczewski.main.repository;

import com.baczewski.main.*;

import javax.xml.bind.JAXB;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

class EventXmlRepository implements EventRepository {

    private final PropertiesLoader propertiesLoader;
    private final LocalDateParser localDateParser;
    private Calendar calendar;

    public EventXmlRepository(PropertiesLoader propertiesLoader,
                              LocalDateParser localDateParser, EventLineParser parser) {
        this.propertiesLoader = propertiesLoader;
        this.localDateParser = localDateParser;
    }
    @Override
    public List<Event> getAll() {
        File xml = new File(propertiesLoader.getEventPath());
        Calendar unmarshal = JAXB.unmarshal(xml, Calendar.class);
        return unmarshal.getEventList();
    }

    @Override
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
        File xml = new File(propertiesLoader.getEventPath());
        Calendar unmarshalCalendar = JAXB.unmarshal(xml, Calendar.class);
        unmarshalCalendar.getEventList().add(event);
        JAXB.marshal(unmarshalCalendar, xml);
    }
}

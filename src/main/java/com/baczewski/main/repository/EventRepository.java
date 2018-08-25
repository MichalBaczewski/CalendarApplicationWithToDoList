package com.baczewski.main.repository;

import com.baczewski.main.Event;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface EventRepository {
        List<Event> getAll();
        Optional<Event> getCloserEvent();
        List<Event> searchEventByGuestEmail(String email);

        void saveEvent(Event event) throws IOException;
}

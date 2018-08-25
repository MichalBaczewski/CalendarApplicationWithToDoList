package com.baczewski.main.emmiter;

import com.baczewski.main.Event;
import com.baczewski.main.Guest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventCreationEmitter {
    private List<EventCreationObserver> eventObservers = new ArrayList<>();
    public void registerObserver(EventCreationObserver observer) {
        eventObservers.add(observer);
    }
    public void notifyObservers(Event createdEvent, Guest creator) {
        for (EventCreationObserver eventCreationObserver : eventObservers) {
            eventCreationObserver.notify(createdEvent, creator);
        }
    }
}

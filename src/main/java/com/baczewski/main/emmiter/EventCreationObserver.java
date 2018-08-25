package com.baczewski.main.emmiter;

import com.baczewski.main.Event;
import com.baczewski.main.Guest;

public interface EventCreationObserver {
    void notify(Event createdEvent, Guest creator);
}

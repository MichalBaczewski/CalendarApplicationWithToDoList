package com.baczewski.main;

import com.baczewski.main.emmiter.EventCreationObserver;

public class PrintConsoleObserver implements EventCreationObserver {

    @Override
    public void notify(Event createdEvent, Guest creator) {
        System.out.println("Stworzyłem wydarzenie "
                + createdEvent.getName()
                + " przez " + creator.getEmail());
    }
}

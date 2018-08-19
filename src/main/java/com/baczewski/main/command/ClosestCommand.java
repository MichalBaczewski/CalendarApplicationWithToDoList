package com.baczewski.main.command;

import com.baczewski.main.EventService;

public class ClosestCommand implements Command {
    private final EventService eventService;

    public ClosestCommand(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    public void run() {
        eventService.printClosestEvent();
    }

    @Override
    public String getHelpMessage() {
        return "Ta komenda wyświetla najbliższe, zbliżajace się wydarzenie.";
    }

    @Override
    public String getActionName() {
        return "closest";
    }
}

package com.baczewski.main.command;

import com.baczewski.main.EventService;

public class PrintAllCommand implements Command {
    private final EventService eventService;

    public PrintAllCommand(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    public void run() {
        eventService.printAllEvents();
    }

    @Override
    public String getHelpMessage() {
        return "Ta komenda wyświetla wszystkie wydarzenia.";
    }

    @Override
    public String getActionName() {
        return "printAll";
    }
}

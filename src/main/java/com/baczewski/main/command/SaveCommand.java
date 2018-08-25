package com.baczewski.main.command;

import com.baczewski.main.Event;
import com.baczewski.main.EventService;
import com.baczewski.main.UserRegistrationService;

import java.util.Scanner;

public class SaveCommand implements Command {
    private final EventService eventService;
    private final UserRegistrationService registrationService;

    public SaveCommand(EventService eventService, UserRegistrationService registrationService) {
        this.eventService = eventService;
        this.registrationService = registrationService;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę wydarzenia:");
        String eventName = scanner.nextLine();
        System.out.println("Podaj date wydarzenia:");
        String eventDate = scanner.nextLine();
        Event event = new Event();
        event.setName(eventName);
        event.setDate(eventDate);
        event.getGuestList().add(registrationService.getLogInUser());
        eventService.saveEvent(event, registrationService.getLogInUser());
    }

    @Override
    public String getHelpMessage() {
        return "Ta komenda zapisuje wydarzenie";
    }

    @Override
    public String getActionName() {
        return "add";
    }
}

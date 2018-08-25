package com.baczewski.main.command;

import com.baczewski.main.EventService;
import com.baczewski.main.Guest;

import java.util.Scanner;

public class SearchCommand implements Command {

    private final EventService eventService;

    public SearchCommand(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    public void run() {
        Scanner s = new Scanner(System.in);
        System.out.println("Podaj email poszukiwanego gościa: ");
        String email = s.nextLine();
        System.out.println("Odnalezione wydarzenia z gosciem: ");
        eventService.searchByGuestEmail(email);
    }

    @Override
    public String getHelpMessage() {
        return "Ta komenda wyszukuje wydarzenia po email gościa";
    }

    @Override
    public String getActionName() {
        return "search";
    }
}

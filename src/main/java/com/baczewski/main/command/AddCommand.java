//package com.baczewski.main.command;
//
//import com.baczewski.main.EventService;
//
//import java.util.Scanner;
//
//public class AddCommand implements Command {
//
//    private final EventService eventService;
//
//    public AddCommand(EventService eventService) {
//        this.eventService = eventService;
//    }
//
//    @Override
//    public void run() {
////        Scanner scanner = new Scanner(System.in);
////        System.out.println("Podaj wydarzenie do dodania w formacie: ddMMyyyy HH:mm ; nazwa wydarzenia:");
////        String line = scanner.nextLine();
////        eventService.saveEvent(line);
////        System.out.println("Pomyślnie dodano wydarzenie.");
//    }
//
//    @Override
//    public String getHelpMessage() {
//        return "Ta komenda wyświetla dostępne komendy.";
//    }
//
//    @Override
//    public String getActionName() {
//        return "add";
//    }
//}

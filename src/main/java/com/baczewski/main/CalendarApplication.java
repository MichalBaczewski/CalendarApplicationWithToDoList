package com.baczewski.main;

import com.baczewski.main.command.CommandRunner;
import com.baczewski.main.repository.EventRepository;
import com.baczewski.main.repository.RepositoryFactory;

import java.io.IOException;
import java.util.Scanner;

class CalendarApplication {
    public static void main(String[] args) throws IOException {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        EventLineParser eventLineParser = new EventLineParser();
        LocalDateParser localDateParser = new LocalDateParser(propertiesLoader);
        RepositoryFactory eventFactory= new RepositoryFactory(propertiesLoader, localDateParser, eventLineParser);
        EventRepository eventRepository = eventFactory.getRepository();
        EventService eventService = new EventService(eventRepository, localDateParser, eventLineParser, propertiesLoader);
        CommandRunner commandRunner = new CommandRunner(eventService);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj imię: ");
        String scName = scanner.nextLine();
        eventService.setName(scName);
        System.out.println("Podaj email: ");
        String scEmail = scanner.nextLine();
        eventService.setEmail(scEmail);
        System.out.println("Podaj komendę (help - pomoc):");
        String s = scanner.nextLine();
        while (true) {
            commandRunner.runCommand(s);
            s = scanner.nextLine();
        }
    }
}

package com.baczewski.main;

import java.util.Scanner;

public class UserRegistrationService {
    private final Guest logInUser;

    public UserRegistrationService() {
        logInUser = logIn();
    }

    Guest logIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę: ");
        String scName = scanner.nextLine();
        System.out.println("Podaj email: ");
        String scEmail = scanner.nextLine();
        Guest guest = new Guest(scName, scEmail);
        return guest;
    }

    public Guest getLogInUser() {
        return logInUser;
    }
}

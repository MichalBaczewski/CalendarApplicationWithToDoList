package com.baczewski.main.command;

import com.baczewski.main.EventService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommandRunner {
    private final Map<String, Command> commandMap = new HashMap<>();

    public CommandRunner (EventService eventService) {
        addCommand(new PrintAllCommand(eventService));
        addCommand(new ClosestCommand(eventService));
        addCommand(new AddCommand(eventService));
        addCommand(new HelpCommand(commandMap));
        addCommand(new ExitCommand());
    }

    public void addCommand(Command command) {
        commandMap.put(command.getActionName().trim().toUpperCase(), command);
    }

    public void removeCommand(Command command) {
        commandMap.remove(command.getActionName().trim().toUpperCase());
    }

    public Optional<Command> getCommand(String actionName) {
        return Optional.ofNullable(commandMap.get(actionName.trim().toUpperCase()));
    }
    public void runCommand(String actionName) {
        getCommand(actionName).ifPresent(Command::run);
    }
}

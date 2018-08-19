package com.baczewski.main.command;

import java.util.Map;

public class HelpCommand implements Command {
    private final Map<String, Command> commandMap;

    public HelpCommand(Map<String, Command> commandMap) {
        this.commandMap = commandMap;
    }

    @Override
    public void run() {
        for (Command value : commandMap.values()) {
            System.out.println(value.getActionName()+ " : " + value.getHelpMessage());
        }
    }

    @Override
    public String getHelpMessage() {
        return "Ta komenda wyświetla listę dostęnych metod.";
    }

    @Override
    public String getActionName() {
        return "help";
    }
}

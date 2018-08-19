package com.baczewski.main.command;

public class ExitCommand implements Command {
    @Override
    public void run() {
        System.exit(0);
    }

    @Override
    public String getHelpMessage() {
        return "Ta komenda zamyka program.";
    }

    @Override
    public String getActionName() {
        return "exit";
    }
}

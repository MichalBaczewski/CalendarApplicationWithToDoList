package com.baczewski.main.command;

public interface Command {
    void run();
    String getHelpMessage();
    String getActionName();
}

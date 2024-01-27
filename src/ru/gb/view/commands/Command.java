package ru.gb.view.commands;

import ru.gb.view.ConsoleUI;

import java.io.IOException;

public abstract class Command {
    private String description;
    private ConsoleUI consoleUI;

    public Command(ConsoleUI consoleUI, String description) {
        this.consoleUI = consoleUI;
        this.description = description;
    }

    public ConsoleUI getConsole() {
        return consoleUI;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute() throws IOException, ClassNotFoundException;
}

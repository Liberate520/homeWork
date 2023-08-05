package com.pamihnenkov.view.commands;

import com.pamihnenkov.view.ConsoleUI;
import com.pamihnenkov.view.View;

public abstract class Command {
    private String description;
    protected ConsoleUI view;

    public Command(ConsoleUI view, String description) {
        this.view = view;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();
}

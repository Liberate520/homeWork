package com.pamihnenkov.view.commands;
import com.pamihnenkov.view.View;

public abstract class Command {
    private final String description;
    protected View view;

    public Command(View view, String description) {
        this.view = view;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();
}

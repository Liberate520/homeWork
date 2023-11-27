package view.commands;

import view.View;

import java.io.IOException;

public abstract class Command {
    private View view;
    private String description;

    public Command(String description, View view) {
        this.description = description;
        this.view = view;
    }

    public String getDescription() {
        return description;
    }

    View getView() {
        return view;
    }

    public abstract void execute() throws IOException, ClassNotFoundException;
}

package view.commands;

import view.View;

public abstract class Command {
    private View view;
    private String description;

    public Command(String descrption, View view) {
        this.description = descrption;
        this.view = view;
    }

    public String getDescription() {
        return description;
    }

    View getView() {
        return view;
    }

    public abstract void execute();
}

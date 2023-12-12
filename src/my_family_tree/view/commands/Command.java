package my_family_tree.view.commands;

import my_family_tree.view.View;

public abstract class Command {
    private String description;
    View view;

    public Command(String description, View view) {
        this.description = description;
        this.view = view;
    }


    public String getDescription(){
        return description;
    }

    public abstract void execute();
}

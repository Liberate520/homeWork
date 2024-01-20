package ru.gb.model.node.commands;

import ru.gb.model.node.TreeItem;

public abstract class Command {
    String description;


    public Command(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public abstract boolean execute();
}

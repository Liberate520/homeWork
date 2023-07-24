package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public abstract class Command {
    ConsoleUI consoleUI;
    private String description;


    public Command(ConsoleUI consoleUI,String description) {
        this.consoleUI = consoleUI;
    }
    public abstract void execute();
    public String getDescription(){
        return description;
    }

}

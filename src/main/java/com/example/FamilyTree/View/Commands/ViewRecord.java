package com.example.FamilyTree.View.Commands;

import com.example.FamilyTree.View.Console;

public class ViewRecord implements Command {
    private Console console;
    private boolean foolMenu = false;

    public ViewRecord(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Вывести семейное дерево для объекта";
    }

    @Override
    public void execute() {
        console.viewRecord();
    }

    @Override
    public boolean getInMenu() {
        return foolMenu;
    }
}
package com.example.FamilyTree.View.Commands;

import com.example.FamilyTree.View.Console;

public class AddRecord implements Command {
    private Console console;
    private boolean foolMenu = true;

    public AddRecord(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Добавить обьект в семейное дерево";
    }

    @Override
    public void execute() {
        console.addRecord();
    }

    @Override
    public boolean getInMenu() {
        return foolMenu;
    }
}
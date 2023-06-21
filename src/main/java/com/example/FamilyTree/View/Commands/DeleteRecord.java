package com.example.FamilyTree.View.Commands;

import com.example.FamilyTree.View.Console;

public class DeleteRecord implements Command {
    private Console console;
    private boolean foolMenu = false;

    public DeleteRecord(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Удалить обьект из семейного дерева";
    }

    @Override
    public void execute() {
        console.deleteRecord();
    }

    @Override
    public boolean getInMenu() {
        return foolMenu;
    }
}
package com.example.FamilyTree.View.Commands;

import com.example.FamilyTree.View.Console;

public class ModifyRecord implements Command {
    private Console console;
    private boolean foolMenu = false;

    public ModifyRecord(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Изменить обьект в семейном дереве";
    }

    @Override
    public void execute() {
        console.modifyRecord();
    }

    @Override
    public boolean getInMenu() {
        return foolMenu;
    }
}
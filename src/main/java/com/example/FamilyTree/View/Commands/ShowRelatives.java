package com.example.FamilyTree.View.Commands;

import com.example.FamilyTree.View.Console;

public class ShowRelatives implements Command{
    private Console console;
    private boolean foolMenu = false;

    public ShowRelatives(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Показать родственную связь между двумя объектами";
    }

    @Override
    public void execute() {
        console.showRelatives();
    }

    @Override
    public boolean getInMenu() {
        return foolMenu;
    }
}

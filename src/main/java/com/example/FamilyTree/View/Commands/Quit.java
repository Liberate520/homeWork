package com.example.FamilyTree.View.Commands;

import com.example.FamilyTree.View.Console;

public class Quit implements Command {
    private Console console;
    private boolean foolMenu = true;

    public Quit(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Закончить работу";
    }

    @Override
    public void execute() {
        console.quit();
    }

    @Override
    public boolean getInMenu() {
        return foolMenu;
    }
}
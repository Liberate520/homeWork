package ru.gb.family_tree.view.comands;

import ru.gb.family_tree.view.Console;

public class GetHumanList {
    private Console console;

    public GetHumanList(Console console) {
        this.console = console;
    }

    public String getDescription() {
        return "Get a list of human";
    }

    public void execute() {
        console.getHumanList();
    }
}

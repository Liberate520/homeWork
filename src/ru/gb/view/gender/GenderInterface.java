package ru.gb.view.gender;

import ru.gb.model.treeItem.Gender;
import ru.gb.view.ConsoleUI;

public abstract class GenderInterface {
    private String option;
    private ConsoleUI console;

    public GenderInterface(String option, ConsoleUI console) {
        this.option = option;
        this.console = console;
    }

    public ConsoleUI getView() {
        return console;
    }

    public String getDescription() {
        return option;
    }

    public abstract Gender execute();
}

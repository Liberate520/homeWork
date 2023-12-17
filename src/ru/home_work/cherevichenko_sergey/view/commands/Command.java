package ru.home_work.cherevichenko_sergey.view.commands;

import ru.home_work.cherevichenko_sergey.view.ConsoleUi;

public abstract class Command {
    private String description;
    private ConsoleUi consoleUi;
    public Command(String description,ConsoleUi consoleUi){
        this.description = description;
        this.consoleUi = consoleUi;
    }
public String getDescription(){
        return description;
}
ConsoleUi getConsoleUi(){
        return consoleUi;
}
public abstract void execute();
}

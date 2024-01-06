package ru.gb.view.commands;

import ru.gb.view.ConsoleUI;

public class AddChild extends Command {
    public AddChild(ConsoleUI consoleUI) {
        super(consoleUI, "Добавить ребенка к члену древа");
    }

    @Override
    public void execute() {
        getConsole().addChild();
    }
}

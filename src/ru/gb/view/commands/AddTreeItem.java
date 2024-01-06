package ru.gb.view.commands;

import ru.gb.view.ConsoleUI;

public class AddTreeItem extends Command{
    public AddTreeItem(ConsoleUI consoleUI) {
        super(consoleUI, "Добавить члена семьи");
    }

    @Override
    public void execute() {
        getConsole().addTreeItem();
    }
}

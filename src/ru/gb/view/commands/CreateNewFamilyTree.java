package ru.gb.view.commands;

import ru.gb.view.ConsoleUI;

public class CreateNewFamilyTree extends Command{
    public CreateNewFamilyTree(ConsoleUI consoleUI) {
        super(consoleUI, "Создать новое пустое семейное древо");
    }

    @Override
    public void execute() {
        getConsole().createEmptyTree();
    }
}

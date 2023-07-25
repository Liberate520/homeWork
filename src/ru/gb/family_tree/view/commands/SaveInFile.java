package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SaveInFile extends Command {
    public SaveInFile(ConsoleUI consoleUI) {
        super(consoleUI, "выполнить сериализацию проекта");
    }

    @Override
    public void execute() {
        consoleUI.saveInFile();
    }
}
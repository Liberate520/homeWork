package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleView;

import java.io.IOException;

public class SaveInFile extends Command{
    public SaveInFile(ConsoleView consoleView) {
        super(consoleView, "выполнить сериализацию проекта");
    }

    @Override
    public void execute() {
        consoleView.saveInFile();
    }
}

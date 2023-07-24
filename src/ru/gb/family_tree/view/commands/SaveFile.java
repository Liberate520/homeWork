package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SaveFile extends Command{
    public SaveFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Запись семейного дерева в файл";
    }

    @Override
    public void execute() {
        consoleUI.saveFile();
    }

}

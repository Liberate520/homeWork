package ru.gb.family_tree.family_tree.view.commands;

import ru.gb.family_tree.family_tree.view.ConsoleUI;

public class SaveTreeToFile extends Command {
    public SaveTreeToFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранение дерева в Файл";
    }
    public void execute(){
        consoleUI.saveTreeToFile();
        System.out.println("Семейное древо сохранено в файл");
    }
}

package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.model.saveload.FileHandler;
import ru.gb.family_tree.view.ConsoleUI;

public class ImportTree extends Command {
    FileHandler fileHandler;

    public ImportTree(ConsoleUI consoleUI, FileHandler fileHandler) {
        super(consoleUI);
        this.fileHandler = fileHandler;
        description = "Импортировать дерево из файла объекта";
    }

    @Override
    public void execute() { consoleUI.importFromObjectFile(); }
}

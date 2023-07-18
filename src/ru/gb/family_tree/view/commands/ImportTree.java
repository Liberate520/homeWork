package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.console_ui.ConsoleUI;

public class ImportTree extends Command {

    public ImportTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Импортировать дерево из файла объекта";
    }

    @Override
    public void execute() { consoleUI.importTree(); }
}

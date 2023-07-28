package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.console_ui.ConsoleUI;

public class ExportTree extends Command {

    public ExportTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Экспортировать дерево в файл объекта";
    }

    @Override
    public void execute() { consoleUI.exportTree(); }
}

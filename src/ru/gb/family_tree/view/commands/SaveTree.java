package ru.gb.family_tree.view.commands;

public class SaveTree extends Command {

    public SaveTree(ConsoleUI consoleUI) {
        super("Сохранить дерево", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().saveTree();
    }
}

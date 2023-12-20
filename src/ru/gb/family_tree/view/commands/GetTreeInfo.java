package ru.gb.family_tree.view.commands;

public class GetTreeInfo extends Command {

    public GetTreeInfo(ConsoleUI consoleUI) {
        super("Показать дерево", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getTreeInfo();
    }

}

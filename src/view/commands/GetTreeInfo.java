package view.commands;

import view.ConsoleUI;

public class GetTreeInfo extends Command{

    public GetTreeInfo(ConsoleUI consoleUI) {
        super("Показать дерево",consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getTreeInfo();
    }
}

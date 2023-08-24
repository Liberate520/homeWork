package View.commands;

import View.ConsoleUI;

public class ShowFamilyTree extends Command{

    public ShowFamilyTree(ConsoleUI consoleUI) {
        super("Показать семейное дерево", consoleUI);
    }

    @Override
    public void execute() {
        super.consoleUI.listInfo();
    }
}

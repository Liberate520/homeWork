package ui.userCommands;

import ui.ConsoleUI;

public class PrintTrees extends Command{
    public PrintTrees(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Распечатать информацию о всех деревьях";
    }

    @Override
    public boolean execute() {
        return getConsoleUI().requestPrint();
    }
}

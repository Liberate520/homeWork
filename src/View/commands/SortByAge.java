package View.commands;

import View.ConsoleUI;

public class SortByAge extends Command{
    public SortByAge(ConsoleUI consoleUI) {
        super("Отсортировать дерево по возрасту", consoleUI);
    }

    @Override
    public void execute() {
        super.consoleUI.sort_age();
    }
}

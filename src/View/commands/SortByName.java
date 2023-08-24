package View.commands;

import View.ConsoleUI;

public class SortByName extends Command{
    public SortByName(ConsoleUI consoleUI) {
        super("Отсортировать дерево по имени", consoleUI);
    }

    @Override
    public void execute() {
        super.consoleUI.sort_name();
    }
}

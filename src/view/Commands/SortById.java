package view.Commands;

import view.ConsoleUI;

public class SortById extends Command {

    public SortById(ConsoleUI consoleUI) {
        super("Сортировка по ID", consoleUI);

    }

    @Override
    public void execute() {
        super.consoleUI.sortById();
    }
}

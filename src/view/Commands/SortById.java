package view.Commands;

import view.ConsoleUI;

public class SortById extends Commands{
    SortById(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать по id";
    }
    @Override
    public void execute() {
        this.consoleUI.sortById();
    }
}

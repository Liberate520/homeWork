package view.operations;

import view.ConsoleUI;

public class PrintAll extends ViewTasker {
    public PrintAll(ConsoleUI consoleUI) {
        super(consoleUI);
    }

    @Override
    public String optionName() {
        return "Показать план            ";
    }

    @Override
    public void execute() {
        getConsole().showAll();
    }
}
package view.operations;

import view.ConsoleUI;

public class PrintAll extends Options{
    public PrintAll(ConsoleUI consoleUI) {
        super(consoleUI);
    }

    @Override
    public String optionName() {
        return "вывести весь список";
    }

    @Override
    public void execute() {
        getConsole().showAll();
    }
}

package view.operations;

import view.ConsoleUI;

public class AddRec extends Options{
    public AddRec(ConsoleUI consoleUI) {
        super(consoleUI);
    }

    @Override
    public String optionName() {
        return "добавить запись";
    }

    @Override
    public void execute() {
        getConsole().addRec();
    }
}

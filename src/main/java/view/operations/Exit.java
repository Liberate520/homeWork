package view.operations;

import view.ConsoleUI;

public class Exit extends Options{
    public Exit(ConsoleUI consoleUI) {
        super(consoleUI);
    }

    @Override
    public String optionName() {
        return "выход";
    }

    @Override
    public void execute() {
        getConsole().end();
    }
}

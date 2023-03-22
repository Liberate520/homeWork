package view.operations;

import view.ConsoleUI;

public class DelRec extends Options{
    public DelRec(ConsoleUI consoleUI) {
        super(consoleUI);
    }

    @Override
    public String optionName() {
        return "удалить запись";
    }

    @Override
    public void execute() {
        getConsole().delRec();
    }
}

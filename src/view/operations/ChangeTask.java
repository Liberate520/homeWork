package view.operations;

import view.ConsoleUI;

public class ChangeTask extends ViewTasker {
    public ChangeTask(ConsoleUI consoleUI) {
        super(consoleUI);
    }

    @Override
    public String optionName() {
        return "Изменить задачу          ";
    }

    @Override
    public void execute() {
        getConsole().changeRec();
    }
}
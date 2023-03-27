package view.operations;

import view.ConsoleUI;

public class DeleteTask extends ViewTasker {
    public DeleteTask(ConsoleUI consoleUI) {
        super(consoleUI);
    }

    @Override
    public String optionName() {
        return "Удалить задачу           ";
    }

    @Override
    public void execute() {
        getConsole().delRec();
    }
}
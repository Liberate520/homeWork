package view.operations;

import view.ConsoleUI;

public class AddTask extends ViewTasker {
    public AddTask(ConsoleUI consoleUI) {
        super(consoleUI);
    }

    @Override
    public String optionName() {
        return "Добавить новую задачу    ";
    }

    @Override
    public void execute() {
        getConsole().addRec();
    }
}
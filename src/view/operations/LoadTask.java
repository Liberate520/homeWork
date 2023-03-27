package view.operations;

import view.ConsoleUI;

public class LoadTask extends ViewTasker {
    public LoadTask(ConsoleUI consoleUI) {
        super(consoleUI);
    }

    @Override
    public String optionName() {
        return "Добавить изменения в файл";
    }

    @Override
    public void execute() {
        getConsole().load();
    }
}
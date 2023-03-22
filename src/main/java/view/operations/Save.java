package view.operations;

import view.ConsoleUI;

public class Save extends Options{
    public Save(ConsoleUI consoleUI) {
        super(consoleUI);
    }

    @Override
    public String optionName() {
        return "сохранение списка";
    }

    @Override
    public void execute() {
        getConsole().save();
    }
}

package view.commands;

import view.ConsoleUI;

public class Finish implements Command {
    private ConsoleUI consoleUI;

    public Finish(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Завершить работу";
    }

    @Override
    public void execute(){
        consoleUI.finish();
    }
}

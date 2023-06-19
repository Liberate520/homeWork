package HW.view.commands;

import HW.view.ConsoleUI;

public class Finish implements Command{
    private ConsoleUI consoleUI;

    public Finish(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Finish work";
    }

    @Override
    public void execute() {
        consoleUI.finish();
    }
}

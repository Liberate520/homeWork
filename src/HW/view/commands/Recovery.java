package HW.view.commands;

import HW.view.ConsoleUI;

public class Recovery implements Command {

    private ConsoleUI consoleUI;

    public Recovery(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Recover file";
    }

    @Override
    public void execute() {
        consoleUI.recovery();
    }
}

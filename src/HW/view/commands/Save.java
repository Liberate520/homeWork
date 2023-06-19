package HW.view.commands;

import HW.view.ConsoleUI;

public class Save implements Command {

    private ConsoleUI consoleUI;

    public Save (ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Save file";
    }

    @Override
    public void execute() {
        consoleUI.saver();
    }
}

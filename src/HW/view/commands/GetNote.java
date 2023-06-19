package HW.view.commands;

import HW.view.ConsoleUI;

public class GetNote implements Command {
    private ConsoleUI consoleUI;

    public GetNote(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Get note";
    }

    @Override
    public void execute() {
        consoleUI.getNote();
    }
}

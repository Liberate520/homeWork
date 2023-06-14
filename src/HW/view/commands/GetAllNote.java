package HW.view.commands;

import HW.view.ConsoleUI;

public class GetAllNote implements Command{
    private ConsoleUI consoleUI;

    public GetAllNote(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Show all notes";
    }

    @Override
    public void execute() {
        consoleUI.getAllNote();
    }
}

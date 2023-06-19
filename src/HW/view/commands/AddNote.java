package HW.view.commands;

import HW.view.ConsoleUI;

public class AddNote implements Command{
    private ConsoleUI consoleUI;

    public AddNote(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }
    @Override
    public String getDescription() {
        return "Add note";
    }

    @Override
    public void execute() {
        consoleUI.addNote();
    }
}

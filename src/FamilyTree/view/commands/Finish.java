package FamilyTree.view.commands;

import FamilyTree.view.ConsoleUI;

public class Finish implements Command{
    private ConsoleUI consoleUI;

    public Finish(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getCommandDescription() {
        return "Закончить работу";
    }

    @Override
    public void execute() {
        consoleUI.finish();
    }
}

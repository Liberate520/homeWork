package FamilyTree.view.command;

import FamilyTree.view.ConsoleUI;

public class Finish implements Command{
    private ConsoleUI consoleUI;
    public Finish(ConsoleUI consoleUI){
        this.consoleUI = consoleUI;
    }
    @Override
    public String getDescription() {
        return "Выход из программы";
    }

    @Override
    public void execute() {
        consoleUI.finish();
    }
}

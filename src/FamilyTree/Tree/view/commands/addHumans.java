package FamilyTree.Tree.view.commands;

import FamilyTree.Tree.view.ConsoleUI;


public class addHumans extends Command{


    public addHumans(ConsoleUI consoleUI) {
        super("Добавить человека", consoleUI);
    }

    @Override
    public String description() {
        return null;
    }

    @Override
    public  void execute() {
    super.getConsoleUI().addHumans();
    }
}

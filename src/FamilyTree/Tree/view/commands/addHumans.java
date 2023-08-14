package FamilyTree.Tree.view.commands;

import FamilyTree.Tree.view.ConsoleUI;


public class addHumans extends Command{

    public addHumans(ConsoleUI consoleUI) {

        super("Добавить человека", consoleUI);
    }

    @Override
    public void execute(String path) {
        super.getConsoleUI().addHumans();
    }

    @Override
    public void execute() {

    }
}



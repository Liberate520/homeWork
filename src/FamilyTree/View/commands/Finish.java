package FamilyTree.View.commands;

import FamilyTree.View.ConsoleUI;

public class Finish extends Command {
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Выйти";
    }

    public void execute(){
        consoleUI.finish();
    }
}

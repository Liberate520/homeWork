package familyTree.view.commands;

import familyTree.view.ConsoleUI;

public class Finish extends Command {
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Exit";
    }

    public void execute(){
        consoleUI.finish();
    }
}

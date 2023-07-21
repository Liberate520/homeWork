package View.Commands;

import View.ConsoleUI;

public class AddParents extends Command {

    public AddParents(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить родителей";
    }

    @Override
    public void execute() {
        consoleUI.addParents();
    }
    
}

package View.Commands;

import View.ConsoleUI;

public class FindItem extends Command {

    public FindItem(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Найти элемент дерева";
    }

    @Override
    public void execute() {
        consoleUI.findItem();
    }
    
}

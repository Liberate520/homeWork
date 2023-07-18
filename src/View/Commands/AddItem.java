package View.Commands;

import View.ConsoleUI;

public class AddItem extends Command {

    public AddItem(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить элемент дерева";
    }

    @Override
    public void execute() {
        consoleUI.addItem();
    }
    
}

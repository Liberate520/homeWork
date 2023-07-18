package View.Commands;

import View.ConsoleUI;

public class DeleteItem extends Command {

    public DeleteItem(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Удалить элемент из дерева";
    }

    @Override
    public void execute() {
        consoleUI.deleteItem();
    }
    
}

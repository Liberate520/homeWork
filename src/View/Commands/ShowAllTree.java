package View.Commands;

import View.ConsoleUI;

public class ShowAllTree extends Command {

    public ShowAllTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать все дерево";
    }

    @Override
    public void execute() {
        consoleUI.showAllTree();
    }
    
}

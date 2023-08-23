package homeWork.view.Commands;

import homeWork.view.ConsoleUI;

public class AddParents extends Command {
    public AddParents(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить родителя";
    }

    public void execute() {
        consoleUI.addParent();
    }
}

package homeWork.view.Commands;

import homeWork.view.ConsoleUI;

public class AddChildren extends Command {
    public AddChildren(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить ребенка";
    }

    public void execute() {
        consoleUI.addChild();
    }
}

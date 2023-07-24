package homeWork.view.Commands;

import homeWork.view.ConsoleUI;

public class AddHuman extends Command {

    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить студента";
    }

    public void execute() {
        consoleUI.addHuman();
    }
}

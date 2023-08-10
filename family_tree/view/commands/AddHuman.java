package homeWork.family_tree.view.commands;

import homeWork.family_tree.view.ConsoleUI;

public class AddHuman extends Command {

    public AddHuman(ConsoleUI consoleUI) {
        super("Добавить нового члена семьи", consoleUI);
    }

    public void execute() {
        getConsoleUI().addHuman();

    }
}

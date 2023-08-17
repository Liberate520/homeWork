package homeWork.family_tree.view.commands;

import homeWork.family_tree.view.ConsoleUI;

public class AddHuman extends Command {

    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI);
    }

    @Override
    public String getDescription() {
        return "Добавление человека в семью. ";
    }

    @Override
    public void execute() {
        getConsoleUI().addHuman();
    }
}

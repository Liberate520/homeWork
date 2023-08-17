package homeWork.family_tree.view.commands;

import homeWork.family_tree.view.ConsoleUI;

public class Save extends Command {
    public Save(ConsoleUI consoleUI) {
        super(consoleUI);
    }

    @Override
    public String getDescription() {
        return "Сохранить семью";
    }

    @Override
    public void execute() {
        getConsoleUI().saveFamily();
    }

}

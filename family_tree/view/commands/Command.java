package homeWork.family_tree.view.commands;

import homeWork.family_tree.view.ConsoleUI;

public abstract class Command implements ICommand {
    private ConsoleUI consoleUI;

    public Command(ConsoleUI consoleUI) {

        this.consoleUI = consoleUI;
    }

    ConsoleUI getConsoleUI() {
        return consoleUI;
    }

}

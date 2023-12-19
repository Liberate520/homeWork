package view.commands;

import view.ConsoleUI;

public class AddWedding extends Command{

    public AddWedding(ConsoleUI consoleUI) {
        super("Поженить людей", consoleUI);
    }

    @Override
    public void execute() {
    getConsoleUI().Wedding();
    }
}

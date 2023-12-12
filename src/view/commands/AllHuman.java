package view.commands;

import view.ConsoleUI;

public class AllHuman extends Command{
    public AllHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести список всех людей.";
    }

    @Override
    public void execute() {
        consoleUI.allHuman();
    }
}

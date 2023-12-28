package view.commands;

import view.ConsoleUI;

public class GetParrents extends Command {
    public GetParrents(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать родителей";
    }

    public void execute() {
        consoleUI.GetParrents();
    }

}
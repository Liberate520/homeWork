package view.commands;

import view.ConsoleUI;

public class AddMather extends Command {
    public AddMather(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить мать";
    }

    public void execute() {
        consoleUI.AddHumanFather();
    }

}
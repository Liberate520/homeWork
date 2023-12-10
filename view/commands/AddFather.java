package view.commands;

import view.ConsoleUI;

public class AddFather extends Command {
    public AddFather(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить отца";
    }

    public void execute() {
        consoleUI.AddHumanFather();
    }

}
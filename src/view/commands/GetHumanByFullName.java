package view.commands;

import view.ConsoleUI;

public class GetHumanByFullName extends Command {
    public GetHumanByFullName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Get human by full name.";
    }

    public void execute(){

        consoleUI.getHumanByFullName();
    }
}

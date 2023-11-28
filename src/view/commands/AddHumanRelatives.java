package view.commands;

import view.ConsoleUI;

public class AddHumanRelatives extends Command{

    public AddHumanRelatives(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить родственную связь";
    }

    public void execute(){
        consoleUI.addHumanRelatives();
    }
}
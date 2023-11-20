package view.commands;

import view.ConsoleUI;

public class AddHuman extends Command{
    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить члена семьи";
    }

    public void execute(){
        consoleUI.addHuman();
    }
}

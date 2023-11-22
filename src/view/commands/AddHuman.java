package view.commands;

import view.ConsoleUI;

public class AddHuman  extends Commands {
    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить человека";
    }

    public void execute(){
        consoleUI.addHuman();
    }
}

package View.commands;

import View.ConsoleUI;

public class AddHuman extends Command{

    public AddHuman(ConsoleUI consoleUI) {
        super("Добавить человека", consoleUI);
    }

    public void execute(){
        super.consoleUI.addBaseCharacter();
    }
}

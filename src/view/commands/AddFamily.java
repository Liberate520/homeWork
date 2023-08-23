package view.commands;

import view.ConsoleUI;

public class AddFamily extends Command{

    public AddFamily(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить члена семьи";
    }

    public void execute(){
        consoleUI.addFamily();
    }
}

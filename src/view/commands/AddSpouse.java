package view.commands;

import view.ConsoleUI;

public class AddSpouse extends Command{

    public AddSpouse(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Добавить cупруга";
    }

    public void execute(){
        consoleUI.addSpouse();
    }
}

package Homework.view.commands;

import Homework.view.ConsoleUI;

public class AddHuman extends Command{
    public AddHuman(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Добавить человека";
    }

    @Override
    public void execute() {
        consoleUI.addHuman();
    }
}

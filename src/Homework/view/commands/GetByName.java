package Homework.view.commands;

import Homework.view.ConsoleUI;

public class GetByName extends Command{
    public GetByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Найти информацию по имени";
    }

    public void execute(){
        consoleUI.getByName();
    }
}

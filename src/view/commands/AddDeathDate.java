package view.commands;

import view.ConsoleUI;

public class AddDeathDate extends Command{
    public AddDeathDate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Установить дату смерти члену семьи по id";
    }

    public void execute(){
        consoleUI.addDeathDate();
    }
}

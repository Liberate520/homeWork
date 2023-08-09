package view.commands;

import view.ConsoleUI;

public class AddPerson extends Command{

    public AddPerson(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Добавить человека в древо.";
    }
    @Override
    public void execute() {
        consoleUI.addPerson();
    }
}

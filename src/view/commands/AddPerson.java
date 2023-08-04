package view.commands;

import view.ConsoleUI;

public class AddPerson extends Command{

    public AddPerson(ConsoleUI consoleUI) {
        super("Добавить в древо", consoleUI);
    }

    @Override
    public void execute(){
        super.getConsoleUI().addPerson();
    }
}

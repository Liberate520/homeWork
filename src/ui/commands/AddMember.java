package ui.commands;

import ui.ConsoleUI;

public class AddMember extends Command{
    public AddMember(ConsoleUI console) {
        super(console);
        description = "Добавить элемент к дереву";
    }

    @Override
    public void execute() {
        console.addMember();
    }


}

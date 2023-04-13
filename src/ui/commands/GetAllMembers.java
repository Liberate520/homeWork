package ui.commands;

import ui.ConsoleUI;

public class GetAllMembers extends Command{

    public GetAllMembers(ConsoleUI console) {
        super(console);
        description = "Показать все элементы дерева";
    }
    @Override
    public void execute() {
        console.getAllMembers();
    }
}

package ui.commands;

import ui.ConsoleUI;

public class RemoveMember extends Command{
    public RemoveMember(ConsoleUI console) {
        super(console);
        description = "Удалить элемент дерева \n";
    }
    @Override
    public void execute() {
        console.removeMember();
    }
}

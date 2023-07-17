package faminly_tree.view.commands;

import faminly_tree.view.ConsoleUI;

public class AddConnection extends Command{
    public AddConnection(ConsoleUI console) {
        super(console);
        description = "Добавить связь ребенок-родитель для имеющихся в дереве людей";
    }
    @Override
    public void execute() {
        console.addConnection();
    }
}
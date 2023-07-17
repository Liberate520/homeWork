package faminly_tree.view.commands;

import faminly_tree.view.ConsoleUI;

public class ShowAllTree extends Command{
    public ShowAllTree(ConsoleUI console) {
        super(console);
        description = "Показать всех людей в семейном древе";
    }

    @Override
    public void execute() {
        console.showAllTree();
    }
}
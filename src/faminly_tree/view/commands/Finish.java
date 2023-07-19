package faminly_tree.view.commands;

import faminly_tree.view.ConsoleUI;

public class Finish extends Command{
    public Finish(ConsoleUI console){
        super(console);
        description = "Завершить работу";
    }
    @Override
    public void execute() {
        console.finish();
    }
}
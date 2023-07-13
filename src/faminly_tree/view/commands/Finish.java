package faminly_tree.view.commands;

import faminly_tree.view.ConsoleUI;

public class Finish extends Command{
    public Finish(ConsoleUI console){
        super(console);
        description = "Завершение работы";
    }
    @Override
    public void execute() {
        console.finish();
    }
}

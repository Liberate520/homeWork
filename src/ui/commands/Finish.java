package ui.commands;

import ui.ConsoleUI;



public class Finish extends Command{

    public Finish(ConsoleUI console) {
        super(console);
        description = "Выйти из меню \n";
    }

    @Override
    public void execute() {
        console.finish();
    }
}

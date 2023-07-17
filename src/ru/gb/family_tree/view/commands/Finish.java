package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class Finish extends Command{
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Закончить работу";
    }

    public void execute(){
        consoleUI.finish();
    }
}

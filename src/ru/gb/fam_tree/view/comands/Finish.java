package ru.gb.fam_tree.view.comands;

import ru.gb.fam_tree.view.ConsoleUI;

public class Finish extends Command {
    public Finish(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Finish work.";
    }
    @Override
    public void execute() {
        consoleUI.finish();
    }
}

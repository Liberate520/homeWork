package ru.gb.family_tree.View.Command;

import ru.gb.family_tree.View.ConsoleUI;

public class Finish extends Command {


    public Finish(ConsoleUI consoleUI) {
        super(consoleUI, "Выход");
    }
    public  void execute(){
        getConsoleUI().finish();
    }
}

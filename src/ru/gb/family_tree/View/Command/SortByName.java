package ru.gb.family_tree.View.Command;

import ru.gb.family_tree.View.ConsoleUI;

public class SortByName extends Command {


    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI, "Сортировать по фамилии");
    }
    public  void execute(){
        getConsoleUI().getByName();
    }
}

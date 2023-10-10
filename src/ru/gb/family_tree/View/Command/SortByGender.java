package ru.gb.family_tree.View.Command;

import ru.gb.family_tree.View.ConsoleUI;

public class SortByGender extends Command {


    public SortByGender(ConsoleUI consoleUI) {
        super(consoleUI, "Сортировать по половому признаку");
    }
    public  void execute(){
        getConsoleUI().getByGender();
    }
}

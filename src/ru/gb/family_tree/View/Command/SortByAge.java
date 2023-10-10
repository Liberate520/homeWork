package ru.gb.family_tree.View.Command;

import ru.gb.family_tree.View.ConsoleUI;

public class SortByAge extends Command {


    public SortByAge(ConsoleUI consoleUI) {
        super(consoleUI, "Сортировать по возрасту");
    }
    public  void execute(){
        getConsoleUI().getByAge();
    }
}

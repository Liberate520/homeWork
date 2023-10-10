package ru.gb.family_tree.View.Command;

import ru.gb.family_tree.View.ConsoleUI;

public class SortByDateOfBirth extends Command {


    public SortByDateOfBirth(ConsoleUI consoleUI) {
        super(consoleUI, "Сортировать по дате рождения");
    }
    public  void execute(){
        getConsoleUI().getByDateOfBirth();
    }
}

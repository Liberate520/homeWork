package ru.gb.Tree.View.Commands;

import ru.gb.Tree.View.ConsoleUI;

public class SortByBirthDate extends Command{
    public SortByBirthDate(ConsoleUI consoleUI) {
        super(consoleUI, "Сортировать по дате рождения");
    }
    public void execute(){
        consoleUI.sortByBirthDate();
    }
}

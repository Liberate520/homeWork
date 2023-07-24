package ui.comands;

import ui.ConsoleView;

public class SortByName extends Command{

    public String getDiscription() {
        return discription;
    }

    public SortByName(ConsoleView consoleView) {
        super(consoleView);
        discription = "Сортировка по имени";
    }


    public void execute() {
        consoleView.sortByName();
    }
}
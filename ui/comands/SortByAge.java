package ui.comands;

import ui.ConsoleView;

public class SortByAge extends Command{

    public String getDiscription() {
        return discription;
    }

    public SortByAge(ConsoleView consoleView) {
        super(consoleView);
        discription = "Сортировка по возрасту";
    }


    public void execute() {
        consoleView.sortByAge();
    }
}

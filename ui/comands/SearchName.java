package ui.comands;

import ui.ConsoleView;

public class SearchName extends Command{

    public String getDiscription() {
        return discription;
    }

    public SearchName(ConsoleView consoleView) {
        super(consoleView);
        discription = "Найти человека по имени";
    }


    public void execute() {
        consoleView.searchName();
    }
}

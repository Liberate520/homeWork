package ui.comands;

import ui.ConsoleView;

public class AddHuman extends Command{

    public String getDiscription() {
        return discription;
    }

    public AddHuman(ConsoleView consoleView) {
        super(consoleView);
        discription = "Добавить человека";
    }


    public void execute() {
        consoleView.creatHuman();
    }
}

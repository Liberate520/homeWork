package ui.comands;

import ui.ConsoleView;

public class GetHumanList  extends Command{

    public String getDiscription() {
        return discription;
    }

    public GetHumanList(ConsoleView consoleView) {
        super(consoleView);
        discription = "Вывести список людей";
    }


    public void execute() {
        consoleView.getHumanList();
    }
}


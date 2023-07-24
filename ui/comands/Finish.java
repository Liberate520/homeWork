package ui.comands;

import ui.ConsoleView;

public class Finish extends Command{

    public String getDiscription() {
        return discription;
    }

    public Finish(ConsoleView consoleView) {
        super(consoleView);
        discription = "Закончить работу";
    }


    public void execute() {
        consoleView.finish();
    }
}

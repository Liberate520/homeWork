package ui.comands;

import ui.ConsoleView;

public class AddChild extends Command{

    public String getDiscription() {
        return discription;
    }

    public AddChild(ConsoleView consoleView) {
        super(consoleView);
        discription = "Создать связь родитель ребенок";
    }


    public void execute() {
        consoleView.addChild();
    }
}
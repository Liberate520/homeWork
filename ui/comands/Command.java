package ui.comands;

import ui.ConsoleView;

public abstract class Command {
    String discription;
    ConsoleView consoleView;

    public Command(ConsoleView consoleView) {
        this.consoleView = consoleView;
    }

    public String getDiscription() {
        return discription;
    }

    public abstract void execute();
}

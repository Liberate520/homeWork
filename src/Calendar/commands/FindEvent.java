package Calendar.commands;

import Calendar.UI.View;

public class FindEvent implements Commands{

    View consoleUI;

    public FindEvent(View consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        consoleUI.getPresenter().findRecord();
    }

    @Override
    public String description() {
        return "найти запись";
    }
}
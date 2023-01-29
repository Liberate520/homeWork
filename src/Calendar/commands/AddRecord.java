package Calendar.commands;

import Calendar.UI.View;

public class AddRecord implements Commands{

    View consoleUI;

    public AddRecord(View consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        consoleUI.getPresenter().addRecord();
    }

    @Override
    public String description() {
        return "добавить запись";
    }
}
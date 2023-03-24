package ui.commands;

import ui.View;

public class AddRecord extends Command{
    public AddRecord(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Add Record";
    }

    @Override
    public void runCommand() {
        getView().addRecord();
    }
}

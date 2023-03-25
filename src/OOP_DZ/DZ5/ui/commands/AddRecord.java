package OOP_DZ.DZ5.ui.commands;

import OOP_DZ.DZ5.ui.View;

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

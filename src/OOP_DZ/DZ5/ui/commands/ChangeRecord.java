package OOP_DZ.DZ5.ui.commands;

import OOP_DZ.DZ5.ui.View;

public class ChangeRecord extends Command{
    public ChangeRecord(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Change Record";
    }

    @Override
    public void runCommand() {
        getView().changeRecord();
    }
}

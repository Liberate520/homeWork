package OOP_DZ.DZ5.ui.commands;

import OOP_DZ.DZ5.ui.View;

public class RemoveRecord extends Command{
    public RemoveRecord(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Remove Record";
    }

    @Override
    public void runCommand() {
        getView().removeRecord();
    }
}

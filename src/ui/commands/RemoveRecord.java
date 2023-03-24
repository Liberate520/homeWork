package ui.commands;

import ui.View;

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

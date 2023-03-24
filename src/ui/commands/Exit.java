package ui.commands;

import ui.View;

public class Exit extends Command{
    public Exit(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Exit";
    }

    @Override
    public void runCommand() {
        getView().exit();
    }
}

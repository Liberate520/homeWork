package OOP_DZ.DZ5.ui.commands;

import OOP_DZ.DZ5.ui.View;

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

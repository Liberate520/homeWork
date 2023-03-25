package OOP_DZ.DZ5.ui.commands;

import OOP_DZ.DZ5.ui.View;

public class InfoOutput extends Command {

    public InfoOutput(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Info Output";
    }

    @Override
    public void runCommand() {
        getView().infoOutput();
    }
}

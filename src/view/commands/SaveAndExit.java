package view.commands;

import view.View;

import java.io.IOException;

public class SaveAndExit  extends Command {

    public SaveAndExit(View view) {
        super("Save and Exit", view);
    }

    public void execute() throws IOException, ClassNotFoundException {
        getView().saveAndExit();
    }
}

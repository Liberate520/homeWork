package view.commands;

import view.View;

import java.io.IOException;

public class Save extends Command {

    public Save(View view) {
        super("Save", view);
    }

    public void execute() throws IOException, ClassNotFoundException {
        getView().save();
    }
}

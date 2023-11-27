package view.commands;

import view.View;

import java.io.IOException;

public class Read  extends Command {

    public Read(View view) {
        super("Read", view);
    }

    public void execute() throws IOException, ClassNotFoundException {
        getView().read();
    }
}

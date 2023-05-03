package ui.Commands;

import ui.View;

import java.io.IOException;

public class AddHuman implements Command {
    public View view;

    public AddHuman(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "добавить человека:";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        view.addHuman();
    }
}

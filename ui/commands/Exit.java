package ui.commands;

import ui.View;

public class Exit implements Command{
    private View view;

    public Exit (View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.exit();

    }

    @Override
    public String description() {
       
        return "Exit";
    }
}


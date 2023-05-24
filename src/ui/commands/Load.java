package ui.commands;

import ui.View;


public class Load implements Command{
    private View view;
    public  Load(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Loaded";
    }

    @Override
    public void execute() {
        view.load();
    }
}

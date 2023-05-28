package ui.commands;

import ui.View;

public class Save implements Command{
    private View view;
    public  Save(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Saved";
    }

    @Override
    public void execute() {
        view.save();
    }
}

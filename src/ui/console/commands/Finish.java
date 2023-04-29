package ui.console.commands;

import ui.View;

public class Finish implements Command{
    private View view;

    public Finish(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Выйти из программы";
    }

    @Override
    public void execute() {
        view.finish();
    }
}

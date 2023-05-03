package ui.commands;

import ui.View;

public class Stop implements Command {
    private View view;

    public Stop(View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Завершить работу";
    }

    @Override
    public void execute() {
        view.finish();
    }
}

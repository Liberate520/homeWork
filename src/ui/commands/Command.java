package ui.commands;

import ui.View;

public abstract class Command implements ICommand {
    private View view;

    public Command(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }
}

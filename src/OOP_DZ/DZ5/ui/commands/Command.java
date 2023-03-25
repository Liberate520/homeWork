package OOP_DZ.DZ5.ui.commands;

import OOP_DZ.DZ5.ui.View;

public abstract class Command implements ICommand {
    private View view;

    public Command(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }
}

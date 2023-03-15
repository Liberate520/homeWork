package ui.Commands;

import ui.*;

public abstract class Command implements Option{
    private View view;

    public Command(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }
}

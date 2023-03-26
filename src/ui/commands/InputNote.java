package ui.commands;

import ui.ConsoleView;

public class InputNote extends MenuCommand {

    public InputNote(ConsoleView view) {
        super(view, "Ввести новую запись");
    }

    @Override
    public void run() {
        view.inputNote();
    }
}

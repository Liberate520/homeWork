package ui.menu.commands;

import ui.menu.Menu;

public class InputNote extends MenuCommand {

    public InputNote(Menu menu) {
        super(menu, "Ввести новую запись");
    }

    @Override
    public void run() {
        super.getView().inputNote();
    }
}

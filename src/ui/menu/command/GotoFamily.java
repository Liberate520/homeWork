package ui.menu.command;

import ui.UI;

public class GotoFamily implements Command {
    private UI view;
    public GotoFamily(UI view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Перейти в меню семьи";
    }

    @Override
    public void exec() {
        view.gotoFamily();
    }
}

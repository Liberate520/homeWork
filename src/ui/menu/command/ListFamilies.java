package ui.menu.command;

import ui.UI;

public class ListFamilies implements Command {
    private UI view;
    public ListFamilies(UI view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Показать семьи";
    }

    @Override
    public void exec() {
        view.listFamilies();
    }
}

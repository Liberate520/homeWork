package ui.menu.command;

import ui.UI;

public class ShowFamilyTrees implements Command {
    private UI view;
    public ShowFamilyTrees(UI view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Показать все записи";
    }

    @Override
    public void exec() {
        view.showFamilyTrees();
    }
}

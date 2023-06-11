package ui.menu.command;

import ui.UI;

public class AddFamily implements Command {
    private UI view;
    public AddFamily(UI view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Добавить семью";
    }

    @Override
    public void exec() {
        view.addFamily();
    }
}

package ui.menu.command;

import model.family.Family;
import model.human.Human;
import ui.UI;

public class AddConnection implements Command {
    private UI view;
    private Family<Human> family;
    public AddConnection(UI view, Family<Human> family) {
        this.view = view;
        this.family = family;
    }

    @Override
    public String getDescription() {
        return "Добавить связь между людьми";
    }

    @Override
    public void exec() {
        view.addConnection(family);
    }
}
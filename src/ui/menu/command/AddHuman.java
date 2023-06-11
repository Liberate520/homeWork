package ui.menu.command;

import model.family.Family;
import model.human.Human;
import ui.UI;

public class AddHuman implements Command {
    private UI view;
    private Family<Human> family;
    public AddHuman(UI view, Family<Human> family) {
        this.view = view;
        this.family = family;
    }

    @Override
    public String getDescription() {
        return "Добавить человека";
    }

    @Override
    public void exec() {
        view.addHumanToFamily(family);
    }
}
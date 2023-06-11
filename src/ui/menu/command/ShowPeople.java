package ui.menu.command;

import model.family.Family;
import model.human.Human;
import ui.UI;

public class ShowPeople implements Command {
    private UI view;
    private Family<Human> family;
    public ShowPeople(UI view, Family<Human> family) {
        this.view = view;
        this.family = family;
    }

    @Override
    public String getDescription() {
        return "Показать людей семьи";
    }

    @Override
    public void exec() {
        view.showPeopleFromFamily(family);
    }
}

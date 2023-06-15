package ui.menu.command;

import ui.UI;

public class ShowPeople implements Command {
    private UI view;
    private String familyID;
    public ShowPeople(UI view, String familyID) {
        this.view = view;
        this.familyID = familyID;
    }

    @Override
    public String getDescription() {
        return "Показать людей семьи";
    }

    @Override
    public void exec() {
        view.showPeopleFromFamily(familyID);
    }
}

package ui.menu.command;

import ui.UI;

public class AddHuman implements Command {
    private UI view;
    private String familyID;
    public AddHuman(UI view, String familyID) {
        this.view = view;
        this.familyID = familyID;
    }

    @Override
    public String getDescription() {
        return "Добавить человека";
    }

    @Override
    public void exec() {
        view.addHumanToFamily(familyID);
    }
}
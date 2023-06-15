package ui.menu.command;

import ui.UI;

public class AddConnection implements Command {
    private UI view;
    private String familyID;
    public AddConnection(UI view, String familyID) {
        this.view = view;
        this.familyID = familyID;
    }

    @Override
    public String getDescription() {
        return "Добавить связь между людьми";
    }

    @Override
    public void exec() {
        view.addConnection(familyID);
    }
}
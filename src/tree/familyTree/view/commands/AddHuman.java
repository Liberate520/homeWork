package tree.familyTree.view.commands;

import tree.familyTree.view.UserUI;

public class AddHuman implements Command {

    private UserUI userUI;

    public AddHuman(UserUI userUI) {
        this.userUI = userUI;
    }
    @Override
    public String getDescription() {
        return "Добавить чекловека";
    }

    @Override
    public void execute() {
        userUI.addHuman();
    }
}

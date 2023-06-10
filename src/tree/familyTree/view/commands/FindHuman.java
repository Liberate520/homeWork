package tree.familyTree.view.commands;

import tree.familyTree.view.UserUI;

public class FindHuman implements Command {
    private UserUI userUI;

    public FindHuman(UserUI userUI) {
        this.userUI = userUI;
    }
    @Override
    public String getDescription() {
        return "Найти человека";
    }

    @Override
    public void execute() {
        userUI.findHuman();
    }
}

package tree.view.commands;

import tree.view.UserUI;

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

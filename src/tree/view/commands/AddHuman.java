package tree.view.commands;

import tree.view.UserUI;

public class AddHuman implements Command {

    private UserUI userUI;

    public AddHuman(UserUI userUI) {
        this.userUI = userUI;
    }
    @Override
    public String getDescription() {
        return "Добавить человека";
    }

    @Override
    public void execute() {
        userUI.addHuman();
    }
}

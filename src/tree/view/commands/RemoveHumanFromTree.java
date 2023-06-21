package tree.view.commands;

import tree.view.UserUI;

import java.io.IOException;

public class RemoveHumanFromTree implements Command {
    private UserUI userUI;

    public RemoveHumanFromTree(UserUI userUI) {
        this.userUI = userUI;
    }
    @Override
    public String getDescription() {
        return "Удалить человека из семейного дерева";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        userUI.removeHumanFromTree();
    }
}

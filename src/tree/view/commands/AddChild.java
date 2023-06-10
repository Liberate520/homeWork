package tree.view.commands;

import tree.view.UserUI;

import java.io.IOException;

public class AddChild implements Command{
    private UserUI userUI;

    public AddChild(UserUI userUI) {
        this.userUI = userUI;
    }
    @Override
    public String getDescription() {
        return "Добавить ребенка";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        userUI.addChild();
    }
}

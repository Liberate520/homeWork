package tree.view.commands;

import tree.view.UserUI;
import java.io.IOException;

public class IsDirectDescendant implements Command {
    private UserUI userUI;

    public IsDirectDescendant(UserUI userUI) {
        this.userUI = userUI;
    }
    @Override
    public String getDescription() {
        return "Определить прямого потомка";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        userUI.isDirectDescendant();
    }
}

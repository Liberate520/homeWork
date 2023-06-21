package tree.view.commands;

import tree.view.UserUI;
import java.io.IOException;

public class AddParent implements Command {
    private UserUI userUI;

    public AddParent(UserUI userUI) {
        this.userUI = userUI;
    }
    @Override
    public String getDescription() {
        return "Добавить родителя ребенку";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        userUI.addParent();
    }
}

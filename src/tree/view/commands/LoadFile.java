package tree.view.commands;

import tree.view.UserUI;
import java.io.IOException;

public class LoadFile implements Command{
    private UserUI userUI;

    public LoadFile(UserUI userUI) {
        this.userUI = userUI;
    }

    @Override
    public String getDescription() {
        return "Загрузить данные";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        userUI.loadFile();
    }
}
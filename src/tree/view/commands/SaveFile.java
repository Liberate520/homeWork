package tree.view.commands;

import tree.view.UserUI;

import java.io.IOException;

public class SaveFile implements Command{
    private UserUI userUI;

    public SaveFile(UserUI userUI) {
        this.userUI = userUI;
    }

    @Override
    public String getDescription() {
        return "Сохранить данные";
    }

    @Override
    public void execute() throws IOException {
        userUI.saveFile();
        System.out.println("Файл сохранен");
    }
}

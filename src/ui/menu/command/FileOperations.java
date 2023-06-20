package ui.menu.command;

import ui.UI;

public class FileOperations implements Command {
    private UI view;
    public FileOperations(UI view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Сохранение/Загрузка";
    }

    @Override
    public void exec() {
        view.fileOperations();
    }
}

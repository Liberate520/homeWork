package ui.menu.command;

import ui.UI;

public class SaveToFile implements Command {
    private UI view;
    public SaveToFile(UI view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Сохранить данные в файл";
    }

    @Override
    public void exec() {
        view.saveToFile();
    }
}

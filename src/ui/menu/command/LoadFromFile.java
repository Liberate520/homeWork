package ui.menu.command;

import ui.UI;

public class LoadFromFile implements Command {
    private UI view;
    public LoadFromFile(UI view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Загрузить данные из файла";
    }

    @Override
    public void exec() {
        view.loadFromFile();
    }
}

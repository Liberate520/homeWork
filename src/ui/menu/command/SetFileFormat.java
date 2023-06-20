package ui.menu.command;

import ui.UI;

public class SetFileFormat implements Command {
    private UI view;
    public SetFileFormat(UI view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Выбрать формат файла для сохранения/загрузки";
    }

    @Override
    public void exec() {
        view.setFileFormat();
    }
}

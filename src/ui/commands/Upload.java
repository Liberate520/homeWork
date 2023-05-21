package ui.commands;

import ui.View.View;

public class Upload implements Command{
    private View view;

    public Upload(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Загрузить семейное дерево из файла";
    }

    @Override
    public void execute() {
        view.upload();
    }
}

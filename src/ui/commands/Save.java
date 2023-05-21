package ui.commands;

import ui.View.View;

public class Save implements Command {
    private View view;

    public Save(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Сохранить семейное дерево в файл";
    }

    @Override
    public void execute() {
        view.save();
    }
}

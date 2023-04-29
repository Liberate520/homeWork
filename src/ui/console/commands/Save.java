package ui.console.commands;

import ui.View;

import java.io.IOException;

public class Save implements Command{
    private View view;
    public Save(View view) {
        this.view=view;
    }

    @Override
    public String getDescription() {
        return "Сохранить текущее семейное дерево";
    }

    @Override
    public void execute() throws IOException {
        view.save();
    }
}

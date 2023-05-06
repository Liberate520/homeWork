package ui.console.commands;

import ui.View;

import java.io.IOException;

public class Load implements Command{
    private View view;

    public Load(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Загружает сохраненное дерево";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        view.load();
    }
}

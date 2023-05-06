package ui.Commands;

import ui.View;

import java.io.IOException;

public class LoadTree implements Command {
    public View view;

    public LoadTree(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "загрузить дерево:";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        view.loadTree();
    }
}

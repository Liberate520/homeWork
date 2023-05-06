package ui.Commands;

import ui.View;

public class PrintTree implements Command {
    public View view;

    public PrintTree(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "распечатать дерево";
    }

    @Override
    public void execute() {
        view.printTree();
    }
}


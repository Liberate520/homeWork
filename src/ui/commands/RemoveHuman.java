package ui.commands;

import ui.View;

public class RemoveHuman implements Command {
    View view;

    public RemoveHuman(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.removeHuman();
    }

    @Override
    public String getDescription() {
        return "Удалить человека из дерева";
    }

}



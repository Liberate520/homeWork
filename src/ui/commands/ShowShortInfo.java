package ui.commands;

import ui.View;

public class ShowShortInfo implements Command {
    View view;

    public ShowShortInfo(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.showShortInfo();
    }

    @Override
    public String getDescription() {
        return "Вывести краткую информацию по генеалогическому дереву";
    }
    
}



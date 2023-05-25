package ui.commands;

import ui.View;

public class ShowGrandFatherInfo implements Command {
    View view;

    public ShowGrandFatherInfo(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.showGrandFatherInfo();

    }

    @Override
    public String getDescription() {
        return "Вывести информацию о дедушке для человека";
    }

}

package ui.commands;

import ui.View;

public class GetHumanList implements Command {
    private View view;

    public GetHumanList(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Посмотреть семейное древо";
    }

    @Override
    public void execute() {
        view.getHumanList();
    }
}

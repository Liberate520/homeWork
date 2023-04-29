package ui.console.commands;

import ui.View;


public class AddMember implements Command {
    private View view;
    public AddMember(View view) {
        this.view=view;
    }

    @Override
    public String getDescription() {
        return "Добавить нового члена семьи";
    }

    @Override
    public void execute() {
        view.addMember();
    }
}

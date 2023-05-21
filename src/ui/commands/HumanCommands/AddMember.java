package ui.commands.HumanCommands;

import ui.View.View;
import ui.View.ViewHuman;
import ui.commands.Command;

public class AddMember implements Command {
    private ViewHuman view;

    public AddMember(View view) {
        this.view = (ViewHuman) view;
    }

    @Override
    public String getDescription() {
        return "Добавить члена семьи";
    }

    @Override
    public void execute() {
        view.addMember();
    }
}

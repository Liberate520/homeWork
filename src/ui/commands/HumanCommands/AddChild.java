package ui.commands.HumanCommands;

import ui.View.View;
import ui.View.ViewHuman;
import ui.commands.Command;

public class AddChild implements Command {
    private ViewHuman view;

    public AddChild(View view) {
        this.view = (ViewHuman) view;
    }

    @Override
    public String getDescription() {
        return "Добавить ребенка";
    }

    @Override
    public void execute() {
        view.addChild();
    }
}

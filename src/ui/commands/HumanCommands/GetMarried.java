package ui.commands.HumanCommands;

import ui.View.View;
import ui.View.ViewHuman;
import ui.commands.Command;

public class GetMarried implements Command {
    private ViewHuman view;

    public GetMarried(View view) {
        this.view = (ViewHuman) view;
    }

    @Override
    public String getDescription() {
        return "Поженить";
    }

    @Override
    public void execute() {
        view.getMarried();
    }
}

package Tree.homeWork.src.ui.commands;

import Tree.homeWork.src.ui.Console;
import Tree.homeWork.src.ui.View;

public class AddHuman implements Command {
    private View view;
    public AddHuman(View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Добавить человека";
    }

    @Override
    public void execute() {
        view.addHuman();
    }
}

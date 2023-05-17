package java_oop_homeWork.src.ui.commands;

import java_oop_homeWork.src.ui.View;

public class AddChild extends ConsoleCommand implements Command {
    public AddChild (View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Ребёнок";
    }

    @Override
    public void execute() {
        view.addChild(view.getIdHuman());
        view.finishAddMenu();
    }
}

package java_oop_homeWork.src.ui.commands;

import java_oop_homeWork.src.ui.View;

public class AddParent extends ConsoleCommand implements Command {
    public AddParent (View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Родитель";
    }

    @Override
    public void execute() {
        view.addParent(view.getIdPerson());
        view.finishAddMenu();
    }
}

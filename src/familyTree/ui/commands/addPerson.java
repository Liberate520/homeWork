package familyTree.ui.commands;

import familyTree.ui.View;

public class addPerson implements Command{
    private View view;

    public addPerson(View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Add Person";
    }

    @Override
    public void execute() {
        view.addPerson();
    }
}

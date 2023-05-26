package familyTree.ui.commands;

import familyTree.ui.View;

public class sortGender implements Command {
    private View view;

    public sortGender(View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Sort tree by Gender";
    }

    @Override
    public void execute() {
        view.sortGender();
    }
}

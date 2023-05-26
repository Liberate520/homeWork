package familyTree.ui.commands;

import familyTree.ui.View;

public class sortName implements Command {
    private View view;

    public sortName(View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Sort tree by Name";
    }

    @Override
    public void execute() {
        view.sortName();
    }
}

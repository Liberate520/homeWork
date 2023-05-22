package familyTree.ui.commands;

import familyTree.ui.View;

public class sortAge implements Command {
    private View view;

    public sortAge(View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Sort tree by Age";
    }

    @Override
    public void execute() {
        view.sortAge();
    }
}

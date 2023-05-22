package familyTree.ui.commands;

import familyTree.ui.View;

public class getChildren implements Command {
    private View view;

    public getChildren(View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return"Get Children";
    }

    @Override
    public void execute() {
        view.getChildren();
    }
}

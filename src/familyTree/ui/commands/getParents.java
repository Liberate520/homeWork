package familyTree.ui.commands;

import familyTree.ui.View;

public class getParents implements Command {
    private View view;

    public getParents(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Get Parents";
    }

    @Override
    public void execute() {
        view.getParents();
    }
}

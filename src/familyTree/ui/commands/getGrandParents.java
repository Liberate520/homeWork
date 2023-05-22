package familyTree.ui.commands;

import familyTree.ui.View;

public class getGrandParents implements Command {
    private View view;

    public getGrandParents(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Get GrandParents";
    }

    @Override
    public void execute() {
        view.getGrandParents();
    }
}

package familyTree.ui.commands;

import familyTree.ui.View;

public class getInfoTree implements Command {
    private View view;

    public getInfoTree(View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Get Info Tree";
    }

    @Override
    public void execute() {
        view.getInfoTree();
    }
}

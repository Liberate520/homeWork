package familyTree.ui.commands;

import familyTree.ui.View;

public class readFile implements Command {
    private View view;

    public readFile (View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Load the Tree";
    }

    @Override
    public void  execute() {
        view.readFile();
    }
}

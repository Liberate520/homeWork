package familyTree.ui.commands;

import familyTree.ui.View;

public class saveFile implements Command {
    private View view;

    public saveFile (View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Save the Tree";
    }

    @Override
    public void execute() {
        view.saveFile();
    }
}
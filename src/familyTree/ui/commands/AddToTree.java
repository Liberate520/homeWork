package familyTree.ui.commands;

import familyTree.ui.View;

public class AddToTree implements Command{

    private View view;
    public AddToTree(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Добавить человека в древо (если древа нет, оно будет создано)";
    }

    @Override
    public void execute() {
        view.addToTree();
    }
}
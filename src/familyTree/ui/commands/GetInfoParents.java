package familyTree.ui.commands;

import familyTree.ui.View;

public class GetInfoParents implements Command{
    private View view;
    public GetInfoParents(View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Информация о родителях";
    }

    @Override
    public void execute() {
        view.getInfoParents();
    }
}
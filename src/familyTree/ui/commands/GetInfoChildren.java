package familyTree.ui.commands;

import familyTree.ui.View;

public class GetInfoChildren implements Command{
    private View view;
    public GetInfoChildren(View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Информация о детях";
    }

    @Override
    public void execute() {
        view.getInfoChildren();
    }
}
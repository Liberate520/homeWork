package familyTree.ui.commands;

import familyTree.ui.View;

public class GetInfoHumanFromTree implements Command{
    private View view;
    public GetInfoHumanFromTree(View view) {
        this.view = view;
    }
    @Override
    public String getDescription() {
        return "Полная информация о конкретном человеке из конкретного древа";
    }

    @Override
    public void execute() {
        view.getInfoHumanFromTree();
    }
}
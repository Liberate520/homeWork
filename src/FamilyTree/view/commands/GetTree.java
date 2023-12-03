package FamilyTree.view.commands;

import FamilyTree.view.View;

public class GetTree extends Command{

    public GetTree(View view) {
        super("Показать дерево.", view);
    }

    public void execute(){ getView().getTree(); }
}

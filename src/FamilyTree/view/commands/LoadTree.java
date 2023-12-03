package FamilyTree.view.commands;

import FamilyTree.view.View;

public class LoadTree extends Command{
    public LoadTree(View view) {
        super("Загрузить дерево из файла.", view);
    }

    public void execute(){ getView().loadTree(); }
}

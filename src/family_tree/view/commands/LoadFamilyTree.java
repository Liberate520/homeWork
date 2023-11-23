package family_tree.view.commands;

import family_tree.view.View;

public class LoadFamilyTree extends Command{
    private String title;
    private View view;

    public LoadFamilyTree(View view) {
        super("Загрузить семейное дерево",view);
    }

    public void execute(){
        getView().loadFamilyTree();
    }
}
package family_tree.view.commands;

import family_tree.view.View;

public class SaveFamilyTree extends Command{
    private String title;
    private View view;

    public SaveFamilyTree(View view) {
        super("Сохранить семейное дерево",view);
    }

    public void execute(){
        getView().saveFamilyTree();
    }
}
package homeWork.src.view.commands;

import homeWork.src.view.View;

public class LoadFamilyTree extends Command{

    public LoadFamilyTree(View view) {
        super("Load Family Tree", view);
    }

    public void execute(){
        getView().loadFamilyTree();
    }
}

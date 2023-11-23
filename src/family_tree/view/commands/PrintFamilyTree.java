package family_tree.view.commands;

import family_tree.view.View;

public class PrintFamilyTree extends Command{
    private String title;
    private View view;

    public PrintFamilyTree(View view) {
        super("Вывести семейное дерево",view);
    }

    public void execute(){
        getView().printFamilyTree();
    }
}

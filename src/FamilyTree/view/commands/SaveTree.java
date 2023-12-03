package FamilyTree.view.commands;

import FamilyTree.view.View;

public class SaveTree extends Command{

    public SaveTree(View view) {
        super("Сохранить дерево в файл.", view);
    }

    public void execute(){ getView().saveTree(); }
}

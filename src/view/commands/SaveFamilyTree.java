package homeWork.src.view.commands;

import homeWork.src.view.View;

public class SaveFamilyTree extends Command{

    public SaveFamilyTree(View view) {
        super("Save Family Tree", view);
    }

    public void execute(){
        getView().save();
    }
}
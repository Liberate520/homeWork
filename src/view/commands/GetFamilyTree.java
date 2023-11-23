package view.commands;

import view.View;

public class GetFamilyTree extends Command {

    public GetFamilyTree(View view) {
        super("Get family tree", view);
    }

    public void execute(){
        getView().getFamilyTree();
    }
}

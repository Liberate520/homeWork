package WorkSeminar.View.CommandsConsol;

import WorkSeminar.View.View;

public class ShowTree extends Commands{

    public ShowTree(View view){
        super("Показать семейное Древо ", view);
    }
    public void execute() {
        getView().showTree();
    }
}

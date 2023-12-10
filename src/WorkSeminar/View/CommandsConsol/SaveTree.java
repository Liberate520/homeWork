package WorkSeminar.View.CommandsConsol;

import WorkSeminar.View.View;

public class SaveTree extends Commands{

    public SaveTree(View view){
        super("Сохранить семейное Древо ", view);
    }
    public void execute() {
        getView().seveTree();}
}

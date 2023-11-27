package WorkSeminar.View.CommandsConsol;

import WorkSeminar.View.View;

public class LoadTree extends Commands{

    public LoadTree(View view){
        super("Загрузить древо ", view);
    }
    public void execute() {
        getView().loadTree();}
}

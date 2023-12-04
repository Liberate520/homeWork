package WorkSeminar.View.CommandsConsol;

import WorkSeminar.View.View;

public class SortTreeByName extends Commands{

    public SortTreeByName(View view){
        super("Отсоритровать древо по именам персонажей ", view);
    }
    public void execute() {
        getView().sortTreeByName();
    }
}

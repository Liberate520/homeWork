package WorkSeminar.View.CommandsConsol;

import WorkSeminar.View.View;

public class SortTreeByName extends Commands{

    public SortTreeByName(View view){
        super("Отсоритровать Древо по именам ", view);
    }
    public void execute() {
        getView().sortTreeByName();
    }
}

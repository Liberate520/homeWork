package WorkSeminar.View.CommandsConsol;

import WorkSeminar.View.View;

public class SortDefaut extends Commands{

    public SortDefaut(View view){
        super("Отсортировать Древо от старшего к младешму ", view);
    }
    public void execute() {
        getView().sortDefaut();
    }
}

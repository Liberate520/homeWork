package WorkSeminar.View.CommandsConsol;

import WorkSeminar.View.View;

public class SortTreeByGender extends Commands{

    public SortTreeByGender(View view){
        super("Отсортировать Древо по гендорному признаку ", view);
    }
    public void execute() {
        getView().sortTreeByGender();}
}

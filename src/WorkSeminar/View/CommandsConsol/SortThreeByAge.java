package WorkSeminar.View.CommandsConsol;

import WorkSeminar.View.View;

public class SortThreeByAge extends Commands{

    public SortThreeByAge(View view){
        super("Отсортировать древо от младешего к старшему ", view);
    }
    public void execute() {
        getView().sortTreeByAge();
        }
    }
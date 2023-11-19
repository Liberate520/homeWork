package homeWork.src.view.commands;

import homeWork.src.view.View;

public class SortBySurname extends Command{

    public SortBySurname(View view) {
        super("Sort by surname", view);
    }

    public void execute(){
        getView().sortBySurname();
    }
}

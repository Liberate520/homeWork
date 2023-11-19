package homeWork.src.view.commands;

import homeWork.src.view.View;

public class SortByBirthdate extends Command{

    public SortByBirthdate(View view) {
        super("Sort by birthdate", view);
    }

    public void execute(){
        getView().sortByBirthdate();
    }
}

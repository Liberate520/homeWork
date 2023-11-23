package view.commands;

import view.View;

public class SortByAge extends Command {

    public SortByAge(View view) {
        super("Sort by age", view);
    }

    public void execute(){
        getView().sortByAge();
    }
}

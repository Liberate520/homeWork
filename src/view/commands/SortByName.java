package view.commands;

import view.View;

public class SortByName extends Command {

    public SortByName(View view) {
        super("Sort by name", view);
    }

    public void execute(){
        getView().sortByName();
    }
}

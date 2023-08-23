package FT_Project.view.Actions;

import FT_Project.view.Console;

public class SortByName extends Action {
    public SortByName(Console console) {
        super(console);
        description = "Отсортировать древо по имени";
    }

    public void execute(){
        console.sortByName();
    }
}

package FT_Project.view.Actions;

import FT_Project.view.Console;

public class SortByAge extends Action{
    public SortByAge(Console console) {
        super(console);
        description = "Отсортировать древо по возрасту";
    }

    public void execute(){
        console.sortByAge();
    }
}

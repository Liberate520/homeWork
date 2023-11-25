package Family_Tree.view.Commands;

import Family_Tree.view.View;

public class SortByBirthday extends Command{

    public SortByBirthday(View view) {
        super("Отсортировать по возрасту", view);
    }

    public void execute(){
        getView().sortByBirthday();
    }
}
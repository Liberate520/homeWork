package family_tree.family_tree.view.commands;

import family_tree.family_tree.view.View;

public class SortByAge extends Command {

    public SortByAge(View view) {
        super("Отсортировать по возрасту", view);
    }

    public void execute(){
        getView().sortByAge();
    }
}

package family_tree.view.commands;

import family_tree.view.View;

public class sortByAge extends Commands {

    public sortByAge(View view) {
        super("Сортировать по возрасту", view);
    }

    public void execute() {
        getView().sortByAge();
    }
}
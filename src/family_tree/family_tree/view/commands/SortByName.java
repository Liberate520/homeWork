package family_tree.family_tree.view.commands;

import family_tree.family_tree.view.ConsoleUI;

public class SortByName extends Command {

    public SortByName(ConsoleUI view) {
        super("Отсортировать по имени", view);
    }

    public void execute(){
        getView().sortByName();
    }
}

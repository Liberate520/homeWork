package family_tree.family_tree.view.commands;

import family_tree.family_tree.view.ConsoleUI;

public class SortByAge extends Command {

    public SortByAge(ConsoleUI view) {
        super("Отсортировать по возрасту", view);
    }

    public void execute(){
        getView().sortByAge();
    }
}

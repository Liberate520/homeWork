package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SortByAge extends Command {

    public SortByAge(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "отсортировать список по возрасту";
    }
    @Override
    public void execute(){
        consoleUI.sortByAge();
    }

}

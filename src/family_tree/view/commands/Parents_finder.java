package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class Parents_finder extends Command{

    public Parents_finder(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Установить родителей;";
    }
    public void execute() {
        consoleUI.parents_finder();
    }
}

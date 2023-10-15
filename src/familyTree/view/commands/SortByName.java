package familyTree.view.commands;

import familyTree.view.ConsoleUI;

public class SortByName extends Command{
    public SortByName(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Sort by name (From A to Z/А to Я)";
    }

    public void execute(){
        consoleUI.sortByName();
    }
}

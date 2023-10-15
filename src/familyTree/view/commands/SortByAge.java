package familyTree.view.commands;

import familyTree.view.ConsoleUI;

public class SortByAge extends Command{
    public SortByAge(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Sort by age (From lowest to highest)";
    }

    public void execute(){
        consoleUI.sortByAge();
    }
}

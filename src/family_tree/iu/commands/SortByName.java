package family_tree.iu.commands;

import family_tree.iu.ConsoleUI;

public class SortByName extends Command{

    public SortByName(ConsoleUI consoleUI){
        super("Sort by Name",consoleUI);
    }

    public void execute(){
        getConsoleUI().sortByName();
    }
}

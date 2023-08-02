package family_tree.iu.commands;

import family_tree.iu.ConsoleUI;

public class SortByBirthDate extends Command{

    public SortByBirthDate(ConsoleUI consoleUI){
        super("Sort by Birthday",consoleUI);
    }

    public void execute(){
        getConsoleUI().sortByBirthDate();
    }
}

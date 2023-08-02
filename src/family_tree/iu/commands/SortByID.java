package family_tree.iu.commands;

import family_tree.iu.ConsoleUI;

public class SortByID  extends Command{
        public SortByID(ConsoleUI consoleUI){
            super("Sort default (by ID)",consoleUI);
        }

        public void execute(){
            getConsoleUI().sortByID();
        }
}

package FamilyTree.FamilyTree.View.Menu;

import FamilyTree.FamilyTree.View.Commands.*;
import FamilyTree.FamilyTree.View.ConsoleUI;


public class SortMenu extends Menu {

    public SortMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new GetNoSortedList(consoleUI));
        commandList.add(new GetSortedByAgeList(consoleUI));
        commandList.add(new GetSortedByChildrenList(consoleUI));
    }

}
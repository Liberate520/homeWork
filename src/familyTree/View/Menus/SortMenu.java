package familyTree.View;
import familyTree.View.Commands.*;
import familyTree.View.

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SortMenu extends Menu {

    public SortMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new GetNoSortedList(consoleUI));
        commandList.add(new GetSortedByAgeList(consoleUI));
        commandList.add(new GetSortedByChildrenList(consoleUI));
    }

}


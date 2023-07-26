package FamilyTree.View.Menu;

import FamilyTree.View.ConsoleUI;
import FamilyTree.View.commands.Finish;
import FamilyTree.View.commands.TreeCommands.*;

public class TreeMenu extends Menu {


    public TreeMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new AddPerson(consoleUI));
        commandList.add(new GetTreeInfo(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByAge(consoleUI));
        commandList.add(new Finish(consoleUI));
    }
}

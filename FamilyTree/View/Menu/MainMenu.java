package FamilyTree.FamilyTree.View.Menu;

import FamilyTree.FamilyTree.View.Commands.*;
import FamilyTree.FamilyTree.View.ConsoleUI;

public class MainMenu extends Menu{
    public MainMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new AddPerson(consoleUI));
        commandList.add(new GetTreeInfo(consoleUI));
        commandList.add(new SetParent(consoleUI));
        commandList.add(new SetSpouse(consoleUI));
        commandList.add(new Restore(consoleUI));
        commandList.add(new SaveTreeToFile(consoleUI));
        commandList.add(new Finish(consoleUI));
    }
}
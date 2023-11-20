package familyTree.View;
import familyTree.View.Commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu extends Menu{
     public MainMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new AddPerson(consoleUI));
        commandList.add(new GetTreeInfo(consoleUI));
        commandList.add(new SetParent(consoleUI));
        commandList.add(new Finish(consoleUI));
    }
}

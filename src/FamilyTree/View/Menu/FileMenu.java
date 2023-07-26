package FamilyTree.View.Menu;


import FamilyTree.View.ConsoleUI;
import FamilyTree.View.commands.*;
import FamilyTree.View.commands.FileCommanda.Load;
import FamilyTree.View.commands.FileCommanda.Save;


public class FileMenu extends Menu {


    public FileMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new Load(consoleUI));
        commandList.add(new Save(consoleUI));
        commandList.add(new Finish(consoleUI));
    }
}

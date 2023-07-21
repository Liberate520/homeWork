package FamilyTree.View.Menu;



import FamilyTree.View.ConsoleUI;
import FamilyTree.View.commands.*;


public class MainMenu extends Menu {


    public MainMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new Tree(consoleUI));
        commandList.add(new Person(consoleUI));
        commandList.add(new File(consoleUI));
        commandList.add(new Finish(consoleUI));
    }
}

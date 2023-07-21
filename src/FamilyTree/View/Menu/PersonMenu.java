package FamilyTree.View.Menu;



import FamilyTree.View.ConsoleUI;
import FamilyTree.View.commands.*;
import FamilyTree.View.commands.PersonCommands.*;


public class PersonMenu extends Menu {


    public PersonMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new ShowAllPersonInfo(consoleUI));
        commandList.add(new ShowChildren(consoleUI));
        commandList.add(new ShowParents(consoleUI));
        commandList.add(new ShowSpouse(consoleUI));
        commandList.add(new AddChildren(consoleUI));
        commandList.add(new AddParents(consoleUI));
        commandList.add(new AddSpouse(consoleUI));
        commandList.add(new Finish(consoleUI));
    }
}
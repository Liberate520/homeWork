package FamilyTree.View.commands.PersonCommands;

import FamilyTree.View.ConsoleUI;
import FamilyTree.View.commands.Command;

public class ShowAllPersonInfo extends Command {

    public ShowAllPersonInfo (ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать полную информацию о человеке";
    }

    public void execute(){
        consoleUI.showAllPersonInfo();
    }
}

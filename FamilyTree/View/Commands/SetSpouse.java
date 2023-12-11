package FamilyTree.FamilyTree.View.Commands;

import FamilyTree.FamilyTree.View.ConsoleUI;
public class SetSpouse extends Command {

    public SetSpouse(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Установить супруга";
    }

    @Override
    public void execute() {
        consoleUI.setSpouse();
    }
}
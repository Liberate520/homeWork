package FamilyTree.View.commands.TreeCommands;

import FamilyTree.View.ConsoleUI;
import FamilyTree.View.commands.Command;

public class SortByName extends Command {
    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать дерево по имени";
    }

    public void execute(){
        consoleUI.sortByName();
    }
}

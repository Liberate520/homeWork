package FamilyTree.View.commands.TreeCommands;

import FamilyTree.View.ConsoleUI;
import FamilyTree.View.commands.Command;

public class SortByAge extends Command {
    public SortByAge(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать дерево по возрасту";
    }

    public void execute(){
        consoleUI.sortByAge();
    }
}

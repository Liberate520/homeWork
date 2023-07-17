package FamilyTree.View.commands;

import FamilyTree.View.ConsoleUI;

public class SortByAge extends Command {
    public SortByAge(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать дерево по возрасту";
    }

    public void execute(){
        consoleUI.sortByAge();
    }
}

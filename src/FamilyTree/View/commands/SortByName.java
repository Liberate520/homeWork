package FamilyTree.View.commands;

import FamilyTree.View.ConsoleUI;

public class SortByName extends Command {
    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать дерево по имени";
    }

    public void execute(){
        consoleUI.sortByName();
    }
}

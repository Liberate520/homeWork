package FamilyTree.FamilyTree.View.Commands;

import FamilyTree.FamilyTree.View.ConsoleUI;
public class GetSortedByChildrenList extends Command{
    public GetSortedByChildrenList(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "сортировка по количеству детей";
    }

    @Override
    public void execute() {
        consoleUI.getSortedByChildren();
    }
}

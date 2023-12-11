package FamilyTree.FamilyTree.View.Commands;

import FamilyTree.FamilyTree.View.ConsoleUI;
public class GetSortedByAgeList extends Command{
    public GetSortedByAgeList(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "сортировка по возрасту";
    }

    @Override
    public void execute() {
        consoleUI.getSortedByAge();
    }
}
package familyTree.View.Commands;

import familyTree.View.ConsoleUI;

public class GetNoSortedList extends Command{
    public GetNoSortedList(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "несортированный список";
    }
    @Override
    public void execute() {
        consoleUI.getNoSortedList();
    }
}

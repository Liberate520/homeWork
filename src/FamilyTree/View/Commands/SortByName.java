package family_tree.FamilyTree.View.Commands;

import family_tree.FamilyTree.View.ConsoleUI;

public class SortByName extends Commands{
    private String description;
    private ConsoleUI consoleUI;

    public SortByName(ConsoleUI consoleUI) {
        super("Сортировать по имени", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().sortByName();

    }
}

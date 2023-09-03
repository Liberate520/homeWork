package family_tree.FamilyTree.View.Commands;

import family_tree.FamilyTree.View.ConsoleUI;

public class SortByAge extends Commands{
    private String description;
    private ConsoleUI consoleUI;

    public SortByAge(ConsoleUI consoleUI) {
        super("Сортировать по возрасту", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().sortByAge();

    }
}

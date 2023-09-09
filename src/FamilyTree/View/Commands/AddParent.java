package family_tree.FamilyTree.View.Commands;

import family_tree.FamilyTree.View.ConsoleUI;

public class AddParent extends Commands{
    private String description;
    private ConsoleUI consoleUI;

    public AddParent(ConsoleUI consoleUI) {
        super("Установить родителя ребенку", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().addParent();
    }
}

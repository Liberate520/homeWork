package family_tree.FamilyTree.View.Commands;

import family_tree.FamilyTree.View.ConsoleUI;

public class Finish extends Commands {
    private String description;
    private ConsoleUI consoleUI;

    public Finish( ConsoleUI consoleUI) {
        super("Выход", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().finish();
    }
}

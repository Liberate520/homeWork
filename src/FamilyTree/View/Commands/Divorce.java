package family_tree.FamilyTree.View.Commands;

import family_tree.FamilyTree.View.ConsoleUI;

public class Divorce extends Commands{
    private String description;
    private ConsoleUI consoleUI;

    public Divorce(ConsoleUI consoleUI) {
        super("Расторгнуть брак", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().divorce();
    }
}

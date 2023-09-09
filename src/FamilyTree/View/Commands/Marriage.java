package family_tree.FamilyTree.View.Commands;

import family_tree.FamilyTree.View.ConsoleUI;

public class Marriage extends Commands{
    private String description;
    private ConsoleUI consoleUI;

    public Marriage(ConsoleUI consoleUI) {
        super("Зарегистрировать брак", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().marriage();
    }
}

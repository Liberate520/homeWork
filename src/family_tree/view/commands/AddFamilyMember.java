package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class AddFamilyMember extends Command{


    public AddFamilyMember(ConsoleUI consoleUI) {
        super("Добавить члена семьи", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addFamilyMember();
    }
}

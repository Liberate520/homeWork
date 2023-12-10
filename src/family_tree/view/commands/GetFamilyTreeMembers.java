package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class GetFamilyTreeMembers extends Command{


    public GetFamilyTreeMembers(ConsoleUI consoleUI) {
        super("Вывести состав семейного дерева", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getFamilyTreeMembers();
    }
}


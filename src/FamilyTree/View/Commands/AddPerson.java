package family_tree.FamilyTree.View.Commands;

import family_tree.FamilyTree.View.ConsoleUI;

public class AddPerson extends Commands{
    private String description;
    private ConsoleUI consoleUI;

    public AddPerson(ConsoleUI consoleUI) {
        super("добавить в дерево элемент(??)", consoleUI);
    }

    @Override
    public void execute(){
        super.getConsoleUI().addPerson();

    }



}

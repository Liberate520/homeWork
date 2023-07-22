package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class AddFamilyMember extends Command{
    public AddFamilyMember(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Добавить члена семьи";
    }
    @Override
    public void execute() {
        consoleUI.addFamilyMember();
    }
}

package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class GetFamilyInfo extends Command{
    public GetFamilyInfo(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Вывести список членов семьи";
    }

    @Override
    public void execute() {
        consoleUI.getFamilyInfo();
    }
}

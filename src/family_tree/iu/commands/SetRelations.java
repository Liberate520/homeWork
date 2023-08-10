package family_tree.iu.commands;

import family_tree.iu.ConsoleUI;

public class SetRelations  extends Command{

    public SetRelations(ConsoleUI consoleUI){
        super("Set Relationship",consoleUI);
    }

    public void execute(){
        getConsoleUI().setRelations();
    }
}

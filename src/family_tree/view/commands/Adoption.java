package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class Adoption extends Command{

    public Adoption (ConsoleUI consoleUI){
        super(consoleUI);
        description = "Усыновить ребенка;";
    }
    public void execute() {
        consoleUI.adoption();
    }
}

package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SetParentChild extends Command{
    public SetParentChild(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Связать двух людей как родителя и ребенка";
    }

    @Override
    public void execute() {
        consoleUI.setParentChild();
    }
}

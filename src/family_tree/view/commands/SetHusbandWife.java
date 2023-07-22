package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SetHusbandWife extends Command{
    public SetHusbandWife(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Связать двух людей как мужа и жену";
    }

    @Override
    public void execute() {
        consoleUI.setHusbandWife();
    }
}

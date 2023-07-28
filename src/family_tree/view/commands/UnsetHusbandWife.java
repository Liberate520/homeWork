package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class UnsetHusbandWife extends Command{
    public UnsetHusbandWife(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Убрать связь муж-жена между двумя людьми";
    }

    @Override
    public void execute() {
        consoleUI.unsetHusbandWife();
    }
}

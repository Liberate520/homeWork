package family_tree.ui.commands;

import family_tree.ui.ConsoleView;

public class SaveTreeByObjectStream extends Command {
    public SaveTreeByObjectStream(ConsoleView consoleView) {
        super(consoleView);
        description = "C помощью класса ObjectOutputStream";
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void execute(String text) {
        consoleView.saveTreeObject();
    }
}


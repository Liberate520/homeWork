package family_tree.ui.commands;

import family_tree.ui.ConsoleView;

public class LoadTreeByObjectStream extends Command {

    public LoadTreeByObjectStream(ConsoleView consoleView) {
        super(consoleView);
        description = "C помощью класса ObjectInputStream";
    }

    @Override
    public void execute(String fileName) {
        consoleView.loadTreeObject(fileName);
    }
}

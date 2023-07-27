package family_tree.ui.commands;

import family_tree.ui.ConsoleView;

public class LoadTreeByByteArrayStream extends Command {

    public LoadTreeByByteArrayStream(ConsoleView consoleView) {
        super(consoleView);
        description = "C помощью класса ByteArrayInputStream";
    }

    @Override
    public void execute(String fileName) {
        consoleView.loadTreeByteArray(fileName);
    }
}

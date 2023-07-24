package family_tree.ui.commands;

import family_tree.ui.ConsoleView;

public class SaveTreeByByteArrayStream extends Command {
    public SaveTreeByByteArrayStream(ConsoleView consoleView) {
        super(consoleView);
        description = "C помощью класса ByteArrayOutputStream";
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void execute(String text) {
        consoleView.saveTreeByteArray();
    }
}

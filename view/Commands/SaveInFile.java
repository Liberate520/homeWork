package homeWork.view.Commands;

import homeWork.view.ConsoleUI;

public class SaveInFile extends Command {

    public SaveInFile(ConsoleUI consoleUI) {
        super(consoleUI);

    }

    @Override
    public void execute() {
        consoleUI.save();

    }
}

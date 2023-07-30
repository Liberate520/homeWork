package homeWork.view.Commands;

import homeWork.view.ConsoleUI;

public class ReadFromFile extends Command {
    public ReadFromFile(ConsoleUI consoleUI) {
        super(consoleUI);
    }

    @Override
    public void execute() {
        consoleUI.readFromFile();
    }
}

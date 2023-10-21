package familyTree.view.commands;

import familyTree.view.ConsoleUI;

public class ReadFile extends Command{
    public ReadFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Read file";
    }

    @Override
    public void execute() {
        consoleUI.readFile();
    }
}

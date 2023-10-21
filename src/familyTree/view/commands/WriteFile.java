package familyTree.view.commands;

import familyTree.view.ConsoleUI;

public class WriteFile extends  Command{
    public WriteFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Write file";
    }

    @Override
    public void execute() {
        consoleUI.writeFile();
    }
}

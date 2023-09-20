package view.commands.allCommands;

import view.ConsoleUI;

public class SaveAsFile extends Command{
    public SaveAsFile(ConsoleUI consoleUI) {
        super("Save Tree as file", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().saveAsFile();
    }
}

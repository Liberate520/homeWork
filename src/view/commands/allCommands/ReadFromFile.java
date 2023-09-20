package view.commands.allCommands;

import view.ConsoleUI;

public class ReadFromFile extends Command{
    public ReadFromFile(ConsoleUI consoleUI) {
        super("Read tree from file", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().readFromFile();
    }
}

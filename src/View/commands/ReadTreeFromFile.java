package View.commands;

import View.ConsoleUI;

public class ReadTreeFromFile extends Command{
    public ReadTreeFromFile(ConsoleUI consoleUI) {
        super("Считать дерево из файла Data", consoleUI);
    }

    @Override
    public void execute() {
        super.consoleUI.readFromFile();
    }
}

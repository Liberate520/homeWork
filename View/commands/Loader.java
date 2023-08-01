package View.commands;

import View.ConsoleUI;

public class Loader extends Command{

    public Loader(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить файл";
    }

    @Override
    public void execute() {
        consoleUI.load();
    }
}

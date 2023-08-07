package View.commands;

import View.*;

public class Finish extends Command {
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Завершение работы";
    }

    public void execute() {
        consoleUI.finish();
    }
}
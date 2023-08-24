package View.commands;

import View.ConsoleUI;

public class Finish extends Command{
    public Finish(ConsoleUI consoleUI) {
        super("Закончить ввод", consoleUI);
    }

    @Override
    public void execute() {
        super.consoleUI.end();
    }
}

package view.commands;

import view.ConsoleUI;

public class Write extends Command{
    public Write(ConsoleUI consoleUI) {
        super("Сохранить в файл.", consoleUI);
    }

    @Override
    public void execute() {
        consoleUI.write();
    }
}

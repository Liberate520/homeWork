package view.commands;

import view.ConsoleUI;

public class Read extends Command{
    public Read(ConsoleUI consoleUI) {
        super("Загрузить из файла.", consoleUI);
    }

    @Override
    public void execute() {
        consoleUI.read();
    }
}

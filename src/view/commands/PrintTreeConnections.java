package view.commands;

import view.ConsoleUI;

public class PrintTreeConnections extends Command{
    public PrintTreeConnections(ConsoleUI consoleUI) {
        super("Вывести список с родственными связями.", consoleUI);
    }

    @Override
    public void execute() {
        consoleUI.printTreeConnections();
    }
}

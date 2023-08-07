package view.commands;

import view.ConsoleUI;

public class PutConnectionTrue extends Command {
    public PutConnectionTrue(ConsoleUI consoleUI) {
        super("Создать двухстороннюю родственную связь.", consoleUI);
    }

    @Override
    public void execute() {
        consoleUI.putConnection(true);
    }
}

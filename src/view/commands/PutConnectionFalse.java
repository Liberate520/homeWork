package view.commands;

import view.ConsoleUI;

public class PutConnectionFalse extends Command {
    public PutConnectionFalse(ConsoleUI consoleUI) {
        super("Создать одностороннюю родственную связь.", consoleUI);
    }

    @Override
    public void execute() {
        consoleUI.putConnection(false);
    }
}

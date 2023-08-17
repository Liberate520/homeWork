package view.commands;

import view.ConsoleUI;

public class ShowConnections extends Command{
    public ShowConnections(ConsoleUI consoleUI) {
        super("Показать родственные связи человека.", consoleUI);
    }

    @Override
    public void execute() {
        consoleUI.showConnections();
    }
}

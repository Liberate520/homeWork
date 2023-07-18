package view.console.commands;

import view.console.ConsoleUI;

public class GetCurrentHumanFullInfo extends Command {
    public GetCurrentHumanFullInfo(ConsoleUI consoleUI) {
        super("отобразить текущего человека", consoleUI);
    }

    public void execute() {
        consoleUI.getCurrentHumanFullInfo();
    }
}
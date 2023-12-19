package view.commands;

import view.ConsoleUI;

public class GetHumanFullInfo extends Command{
    public GetHumanFullInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести информацию о человеке.";
    }

    @Override
    public void execute() {
        consoleUI.getHumanFullInfo();
    }
}

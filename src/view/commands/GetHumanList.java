package view.commands;

import view.ConsoleUI;

public class GetHumanList extends Command{
    public GetHumanList(ConsoleUI consoleUI) {
        super(consoleUI, "ѕолучить список людей семейного дерева");
    }

    @Override
    public void execute() {
        consoleUI.getHumanList();
    }
}
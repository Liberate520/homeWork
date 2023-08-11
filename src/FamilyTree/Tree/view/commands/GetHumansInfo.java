package FamilyTree.Tree.view.commands;

import FamilyTree.Tree.view.ConsoleUI;

public class GetHumansInfo extends Command {

    public GetHumansInfo(ConsoleUI consoleUI) {
        super("Получить список людей древа", consoleUI);
    }

    @Override
    public  void execute() {
        super.getConsoleUI().getHumansInfo();
    }
}

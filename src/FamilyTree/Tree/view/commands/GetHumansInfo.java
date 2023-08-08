package FamilyTree.Tree.view.commands;

import FamilyTree.Tree.view.ConsoleUI;


public class GetHumansInfo extends Command {

    @Override
    public String description() {
        return null;
    }

    public GetHumansInfo(ConsoleUI consoleUI) {
        super("Получить список людей древа", consoleUI);
    }

    @Override
    public  void execute() {
        super.getConsoleUI().getHumansInfo();
    }
}

package family_tree.ui.commands;

import family_tree.ui.ConsoleView;

public class GetItemByNameShort extends Command{

    public GetItemByNameShort(ConsoleView consoleView) {
        super(consoleView);
        description = "Найти по имени - короткий вывод";
    }

    @Override
    public void execute(String text) {
        consoleView.printItemShort();
    }
}

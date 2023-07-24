package family_tree.ui.commands;

import family_tree.ui.ConsoleView;

public class GetItemByNameShort extends Command{
    String description;
    ConsoleView consoleView;

    public GetItemByNameShort(ConsoleView consoleView) {
        super(consoleView);
        description = "Найти по имени - короткий вывод";
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void execute(String text) {
        consoleView.printItemShort();
    }
}

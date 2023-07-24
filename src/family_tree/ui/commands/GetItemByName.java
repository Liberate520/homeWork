package family_tree.ui.commands;

import family_tree.ui.ConsoleView;

public class GetItemByName extends Command{
    String description;
    ConsoleView consoleView;

    public GetItemByName(ConsoleView consoleView) {
        super(consoleView);
        description = "Найти по имени";
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void execute(String text) {
        consoleView.printItem();
    }
}

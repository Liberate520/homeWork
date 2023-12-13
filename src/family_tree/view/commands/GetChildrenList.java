package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class GetChildrenList extends Command{
    public GetChildrenList(ConsoleUI consoleUI) {
        super("Вывести список детей", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getChildrenList();
    }
}

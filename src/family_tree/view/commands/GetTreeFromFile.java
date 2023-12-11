package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class GetTreeFromFile extends Command {
    public GetTreeFromFile(ConsoleUI consoleUI) {
        super("Получить семейное дерево из файла", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getTreeFromFile();
    }
}

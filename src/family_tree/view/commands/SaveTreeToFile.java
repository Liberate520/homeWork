package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SaveTreeToFile extends Command {
    public SaveTreeToFile(ConsoleUI consoleUI) {
        super("Сохранить семейное дерево в файл", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().saveTreeToFile();

    }
}

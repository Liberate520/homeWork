package homeWork.ProjectFamilyTree.View.commands;

import homeWork.ProjectFamilyTree.View.ConsoleUI;

public class SortByName extends Command{
    public SortByName( ConsoleUI consoleUI) {
        super("Отсортировать список по Имени", consoleUI);
    }

    @Override
    public void execute() {
        super.consoleUI.sortByName();
    }
}

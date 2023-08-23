package homeWork.ProjectFamilyTree.View.commands;

import homeWork.ProjectFamilyTree.View.ConsoleUI;

public class SortByAge extends Command{
    public SortByAge(ConsoleUI consoleUI) {
        super("Отсортировать список по возрасту", consoleUI);
    }

    @Override
    public void execute() {
        super.consoleUI.sortByAge();
    }
}

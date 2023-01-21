package homeWork.src.familyTree.commands;

import homeWork.src.familyTree.ui.ConsoleUI;
/*
показать всех членов дерева (сортировка по имени)
 */

public class SortByName implements Commands {
    ConsoleUI consoleUI;

    public SortByName(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        System.out.println(consoleUI.getPresenter().sortFamilyTree("name"));
    }

    @Override
    public String description() {
        return "показать всех членов дерева (сортировка по имени)";
    }
}

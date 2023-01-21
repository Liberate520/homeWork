package homeWork.src.familyTree.commands;

import homeWork.src.familyTree.ui.ConsoleUI;
/*
показать всех членов дерева (сортировка по возрасту)
 */

public class SortByAge implements Commands {
    ConsoleUI consoleUI;

    public SortByAge(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        System.out.println(consoleUI.getPresenter().sortFamilyTree("age"));
    }

    @Override
    public String description() {
        return "показать всех членов дерева (сортировка по возрасту)";
    }
}

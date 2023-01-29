package FT.commands;

import FT.UI.ConsoleUI;
/*
показать всех членов дерева (сортировка по возрасту)
 */

public class FindByAgeSort implements Commands {
    ConsoleUI consoleUI;

    public FindByAgeSort(ConsoleUI consoleUI) {
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
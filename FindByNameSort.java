package commands;

import UI.ConsoleUI;

public class FindByNameSort implements Commands {
    ConsoleUI consoleUI;

    public FindByNameSort(ConsoleUI consoleUI) {
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
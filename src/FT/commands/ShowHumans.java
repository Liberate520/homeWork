package FT.commands;

import FT.UI.ConsoleUI;

public class ShowHumans implements Commands{
    ConsoleUI consoleUI;

    public ShowHumans(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        consoleUI.getPresenter().printFamilyTree();
    }

    @Override
    public String description() {
        return "показать всех членов дерева (без сортировки)";
    }
}
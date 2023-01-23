package FT.commands;

import FT.UI.ConsoleUI;
/*
показать всех членов дерева (без сортировки)
 */

public class Command_1 implements Commands{
    ConsoleUI consoleUI;

    public Command_1(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
//        печатаем FamilyTree
        consoleUI.getPresenter().printFamilyTree();
    }

    @Override
    public String description() {
        return "показать всех членов дерева (без сортировки)";
    }
}
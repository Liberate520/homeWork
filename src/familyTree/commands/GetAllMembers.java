package homeWork.src.familyTree.commands;

import homeWork.src.familyTree.ui.ConsoleUI;
/*
показать всех членов дерева (без сортировки)
 */

public class GetAllMembers implements Commands{
    ConsoleUI consoleUI;

    public GetAllMembers(ConsoleUI consoleUI) {
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

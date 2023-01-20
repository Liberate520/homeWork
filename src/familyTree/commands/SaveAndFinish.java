package homeWork.src.familyTree.commands;

import homeWork.src.familyTree.ui.ConsoleUI;
/*
завершение программы и сохранение FamilyTree
 */
public class SaveAndFinish implements Commands{
    ConsoleUI consoleUI;

    public SaveAndFinish(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
//        сохраняем FamilyTree
        consoleUI.getPresenter().saveFamilyTree();
//        завершаем работу приложения
        System.exit(0);
    }

    @Override
    public String description() {
        return "завершение программы и сохранение FamilyTree";
    }
}

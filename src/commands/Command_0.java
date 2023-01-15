package homeWork.src.commands;

import homeWork.src.ui.ConsoleUI;
/*
завершение программы и сохранение FamilyTree
 */
public class Command_0 implements Commands{
    ConsoleUI consoleUI;

    public Command_0(ConsoleUI consoleUI) {
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

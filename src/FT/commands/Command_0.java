package FT.commands;

import FT.UI.ConsoleUI;
public class Command_0 implements Commands{
    ConsoleUI consoleUI;

    public Command_0(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        consoleUI.getPresenter().saveFamilyTree();
        System.exit(0);
    }

    @Override
    public String description() {
        return "завершение программы и сохранение FamilyTree";
    }
}
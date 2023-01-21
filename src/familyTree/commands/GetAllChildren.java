package homeWork.src.familyTree.commands;

import homeWork.src.familyTree.ui.ConsoleUI;
/*
показать всех детей члена семьи
 */

public class GetAllChildren implements Commands {
    ConsoleUI consoleUI;

    public GetAllChildren(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        String str = consoleUI.getName();
        System.out.println(consoleUI.getPresenter().getAllChildren(str));
    }

    @Override
    public String description() {
        return "показать всех детей члена семьи";
    }
}

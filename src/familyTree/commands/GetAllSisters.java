package homeWork.src.familyTree.commands;

import homeWork.src.familyTree.ui.ConsoleUI;
/*
показать всех сестёр члена семьи
 */

public class GetAllSisters implements Commands {
    ConsoleUI consoleUI;

    public GetAllSisters(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        String str = consoleUI.getName();
        System.out.println(consoleUI.getPresenter().getAllSisters(str));
    }

    @Override
    public String description() {
        return "показать всех сестёр члена семьи";
    }
}

package homeWork.src.familyTree.commands;

import homeWork.src.familyTree.ui.ConsoleUI;
/*
показать всех братьев члена семьи
 */

public class GetAllBrothers implements Commands {
    ConsoleUI consoleUI;

    public GetAllBrothers(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        String str = consoleUI.getName();
        System.out.println(consoleUI.getPresenter().getAllBrothers(str));
    }

    @Override
    public String description() {
        return "показать всех братьев члена семьи";
    }
}

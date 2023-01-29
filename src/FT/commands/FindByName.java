package FT.commands;

import FT.Human;
import FT.UI.ConsoleUI;

public class FindByName implements Commands {
    ConsoleUI consoleUI;

    public FindByName(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        String str = consoleUI.getName();
        if (consoleUI.getPresenter().findMember(str)!=null) {
            System.out.printf("Нашёл\n%s\n", consoleUI.getPresenter().findMember(str));
        }else System.out.printf("%s нет в FamilyTree!\n", str);
    }

    @Override
    public String description() {
        return "найти члена семьи по имени";
    }
}
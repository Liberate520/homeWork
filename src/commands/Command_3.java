package homeWork.src.commands;

import homeWork.src.Human;
import homeWork.src.ui.ConsoleUI;
/*
найти члена семьи по имени
 */

public class Command_3 implements Commands {
    ConsoleUI consoleUI;

    public Command_3(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
//        получаем имя
        String str = consoleUI.getName();
//        находим нового члена FamilyTree
        if (consoleUI.getPresenter().findMember(str)!=null) {
            System.out.printf("Нашёл\n%s\n", consoleUI.getPresenter().findMember(str));
        }else System.out.printf("%s нет в FamilyTree!\n", str);
    }

    @Override
    public String description() {
        return "найти члена семьи по имени";
    }
}

package homeWork.src.commands;

import homeWork.src.ui.ConsoleUI;
/*
показать всех членов дерева (сортировка по возрасту)
 */

public class Command_8 implements Commands {
    ConsoleUI consoleUI;

    public Command_8(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        System.out.println(consoleUI.getPresenter().sortFamilyTree("age"));
    }

    @Override
    public String description() {
        return "показать всех членов дерева (сортировка по возрасту)";
    }
}

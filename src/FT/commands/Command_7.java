package FT.commands;

import FT.UI.ConsoleUI;

public class Command_7 implements Commands {
    ConsoleUI consoleUI;

    public Command_7(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        System.out.println(consoleUI.getPresenter().sortFamilyTree("name"));
    }

    @Override
    public String description() {
        return "показать всех членов дерева (сортировка по имени)";
    }
}
package FamilyTree.Tree.view.commands;

import FamilyTree.Tree.view.ConsoleUI;

public class sortPatronymic extends Command {

    public sortPatronymic(ConsoleUI consoleUI) {
        super("Отсортировать людей по отчеству", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().sortPatronymic();
    }
}

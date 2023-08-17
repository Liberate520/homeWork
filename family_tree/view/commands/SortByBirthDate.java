package homeWork.family_tree.view.commands;

import homeWork.family_tree.view.ConsoleUI;

public class SortByBirthDate extends Command {

    public SortByBirthDate(ConsoleUI consoleUI) {

        super(consoleUI);
    }

    @Override
    public String getDescription() {
        return "Отсортировать по возрасту";
    }

    public void execute() {
        getConsoleUI().sortByBirthDate();

    }
}

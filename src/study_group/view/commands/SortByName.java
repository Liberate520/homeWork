package study_group.view.commands;

import study_group.view.ConsoleUI;

public class SortByName extends Command{
    private String description;
    private ConsoleUI consoleUI;
    @Override
    public void execute() {
        super.getConsoleUI().addStudent();
    }
    public SortByName(ConsoleUI consoleUI) {
        super("Отсортировать список по имени", consoleUI);
    }


}

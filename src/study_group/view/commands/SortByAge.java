package study_group.view.commands;

import study_group.view.ConsoleUI;

public class SortByAge extends Command{
    private String description;
    private ConsoleUI consoleUI;
    @Override
    public void execute() {
        super.getConsoleUI().addStudent();
    }
    public SortByAge(ConsoleUI consoleUI) {
        super("Отсортировать список по имени", consoleUI);
    }


}


package study_group.view.commands;

import study_group.view.ConsoleUI;

public class Finish extends Command{
    private String description;
    private ConsoleUI consoleUI;
    @Override
    public void execute() {
        super.getConsoleUI().addStudent();
    }
    public Finish(ConsoleUI consoleUI) {
        super("Завершить работу", consoleUI);
    }


}

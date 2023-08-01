package study_group.view.commands;

import study_group.view.ConsoleUI;

public class GetStudentListInfo extends Command{
    private String description;
    private ConsoleUI consoleUI;
    @Override
    public void execute() {
        super.getConsoleUI().addStudent();
    }
    public GetStudentListInfo(ConsoleUI consoleUI) {
        super("Добавить студента", consoleUI);
    }


}

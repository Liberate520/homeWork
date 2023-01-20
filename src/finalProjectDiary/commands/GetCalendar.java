package homeWork.src.finalProjectDiary.commands;

import homeWork.src.finalProjectDiary.ui.ConsoleUI;

public class GetCalendar implements Commands{

    ConsoleUI consoleUI;

    public GetCalendar(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
//        печатаем календарь
        consoleUI.getPresenter().printDiary(consoleUI.getDiary());
    }

    @Override
    public String description() {
        return "показать весь календарь";
    }
}

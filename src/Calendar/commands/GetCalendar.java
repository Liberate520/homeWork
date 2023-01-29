package Calendar.commands;

import Calendar.UI.View;

public class GetCalendar implements Commands{

    View consoleUI;

    public GetCalendar(View consoleUI) {
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
package homeWork.src.finalProjectDiary.commands;

import homeWork.src.finalProjectDiary.ui.ConsoleUI;

public class GetDayRecords implements Commands{

    ConsoleUI consoleUI;

    public GetDayRecords(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        consoleUI.getPresenter().getDayRecords();
    }

    @Override
    public String description() {
        return "показать записи на определённый день";
    }
}

package homeWork.src.finalProjectDiary.commands;

import homeWork.src.finalProjectDiary.ui.View;

public class GetDayRecords implements Commands{

    View consoleUI;

    public GetDayRecords(View consoleUI) {
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

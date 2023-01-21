package homeWork.src.finalProjectDiary.commands;

import homeWork.src.finalProjectDiary.ui.View;

public class DelRecord implements Commands{

    View consoleUI;

    public DelRecord(View consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        consoleUI.getPresenter().delRecord();
    }

    @Override
    public String description() {
        return "удалить запись";
    }
}

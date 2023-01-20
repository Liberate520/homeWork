package homeWork.src.finalProjectDiary.commands;

import homeWork.src.finalProjectDiary.ui.ConsoleUI;

public class DelRecord implements Commands{

    ConsoleUI consoleUI;

    public DelRecord(ConsoleUI consoleUI) {
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

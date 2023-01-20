package homeWork.src.finalProjectDiary.commands;

import homeWork.src.finalProjectDiary.ui.ConsoleUI;

public class AddRecord implements Commands{

    ConsoleUI consoleUI;

    public AddRecord(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        consoleUI.getPresenter().addRecord();
    }

    @Override
    public String description() {
        return "добавить запись";
    }
}

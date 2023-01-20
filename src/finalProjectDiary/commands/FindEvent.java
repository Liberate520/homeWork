package homeWork.src.finalProjectDiary.commands;

import homeWork.src.finalProjectDiary.ui.ConsoleUI;

public class FindEvent implements Commands{

    ConsoleUI consoleUI;

    public FindEvent(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        consoleUI.getPresenter().findRecord();
    }

    @Override
    public String description() {
        return "найти запись";
    }
}

package homeWork.src.finalProjectDiary.commands;

import homeWork.src.finalProjectDiary.ui.View;

public class FindEvent implements Commands{

    View consoleUI;

    public FindEvent(View consoleUI) {
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

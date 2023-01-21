package homeWork.src.finalProjectDiary.commands;

import homeWork.src.finalProjectDiary.ui.View;

public class SaveAndFinish implements Commands{

    View consoleUI;

    public SaveAndFinish(View consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
//        сохраняем Diary
        consoleUI.getPresenter().saveDiary();
//        завершаем работу приложения
        System.exit(0);
    }

    @Override
    public String description() {
        return "завершение программы и сохранение календаря в файл";
    }
}

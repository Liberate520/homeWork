package homeWork.src.finalProjectDiary.commands;

import homeWork.src.finalProjectDiary.ui.ConsoleUI;

public class SaveAndFinish implements Commands{

    ConsoleUI consoleUI;

    public SaveAndFinish(ConsoleUI consoleUI) {
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

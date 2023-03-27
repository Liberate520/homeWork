package view.consoleUI.commands;

import view.consoleUI.menu.Menu;
import view.consoleUI.notifications.NoticeType;

public class SaveFile extends Command {
    @Override
    public String getDescription() {
        return "Сохранить изменения";
    }

    @Override
    public void execute(Menu menu) {
        try {
            presenter.saveChanges();
            notifier.add("Файл успешно сохранен!", NoticeType.OK);
        }catch (Exception e){
            notifier.add(e.getMessage(), NoticeType.ERROR);
        }
    }
}

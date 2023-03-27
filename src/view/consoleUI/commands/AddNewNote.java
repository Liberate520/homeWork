package view.consoleUI.commands;

import model.Note;
import view.consoleUI.menu.ChangeNoteMenu;
import view.consoleUI.menu.Menu;
import view.consoleUI.notifications.NoticeType;

public class AddNewNote extends Command {
    @Override
    public String getDescription() {
        return "Добавить запись";
    }

    @Override
    public void execute(Menu menu) {
        Note note = new Note();
        try {
            new ChangeNoteMenu("Меню создания записи", false, note).run();
            presenter.addNote(note);
            notifier.add("Запись успешно добавлена!", NoticeType.OK);
        } catch (Exception e) {
            notifier.add(e.getMessage(), NoticeType.ERROR);
        }
    }
}

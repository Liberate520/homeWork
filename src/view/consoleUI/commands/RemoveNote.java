package view.consoleUI.commands;

import model.Note;
import view.consoleUI.menu.Menu;
import view.consoleUI.notifications.NoticeType;

import java.io.IOException;

public class RemoveNote extends Command {
    Note note;

    public RemoveNote(Note note) {
        this.note = note;
    }

    @Override
    public String getDescription() {
        return "Удалить запись";
    }

    @Override
    public void execute(Menu menu) {
        try {
            presenter.removeNote(note);
            notifier.add("Запись успешно удалена!", NoticeType.OK);
            menu.stop();
        } catch (IOException e) {
            notifier.add(e.getMessage(), NoticeType.ERROR);
        }
    }
}

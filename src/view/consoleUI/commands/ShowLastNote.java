package view.consoleUI.commands;

import model.Note;
import view.consoleUI.menu.Menu;
import view.consoleUI.notifications.NoticeType;

import java.util.List;

/**
 * Команда для выбора последней записи в блокноте
 */
public class ShowLastNote extends Command {
    Note note;

    public ShowLastNote() {
        List<Note> allNotes = presenter.getAllNotes();
        if (!presenter.getAllNotes().isEmpty()) {
            this.note = presenter.getAllNotes()
                    .get(allNotes.size() - 1);
        }
    }

    @Override
    public String getDescription() {
        return "Показать последнюю запись";
    }

    @Override
    public void execute(Menu menu) {
        if (note != null){
            new OpenNote(note).execute(menu);
        } else {
            notifier.add("Невозможно показать последнюю запись, запись отсутствует", NoticeType.ERROR);
        }
    }
}

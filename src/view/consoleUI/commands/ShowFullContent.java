package view.consoleUI.commands;

import model.Note;
import view.consoleUI.menu.Menu;
import view.consoleUI.notifications.NoticeType;

/**
 * Команда для печати полного текста записи
 */
public class ShowFullContent extends Command {
    Note note;

    public ShowFullContent(Note note) {
        this.note = note;
    }

    @Override
    public String getDescription() {
        return "Показать полный текст записи";
    }

    @Override
    public void execute(Menu menu) {
        notifier.add(String.format("Полный текст записи:\n%s", note.getContent()), NoticeType.OK);
    }
}

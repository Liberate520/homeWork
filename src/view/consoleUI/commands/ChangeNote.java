package view.consoleUI.commands;

import model.Note;
import view.consoleUI.menu.ChangeNoteMenu;
import view.consoleUI.menu.Menu;
import view.consoleUI.notifications.NoticeType;

/**
 * Команда для изменения текста записи
 */
public class ChangeNote extends Command {
    Note note;

    public ChangeNote(Note note) {
        this.note = note;
    }

    @Override
    public String getDescription() {
        return "Изменить запись";
    }

    @Override
    public void execute(Menu menu) {
        try {
            new ChangeNoteMenu("Меню изменения записи", false, note).run();
            notifier.add("Запись успешно изменена!\n", NoticeType.OK);
            menu.setTitle(String.format("Меню работы с записью \"%s\"" ,new OpenNote(note).getDescription()));
        } catch (Exception e){
            notifier.add(e.getMessage(), NoticeType.ERROR);
        }
    }
}

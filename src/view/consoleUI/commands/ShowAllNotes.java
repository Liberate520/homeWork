package view.consoleUI.commands;

import model.Note;
import view.consoleUI.menu.FlipMenu;
import view.consoleUI.menu.Menu;
import view.consoleUI.notifications.NoticeType;

import java.util.ArrayList;

/**
 * Команда для печати всех записей в блокноте
 */
public class ShowAllNotes extends Command{
    @Override
    public String getDescription() {
        return "Показать все записи";
    }

    @Override
    public void execute(Menu menu) {
        try {
            if (presenter.getAllNotes().isEmpty()) {
                notifier.add("Список записей пуст.\n", NoticeType.INFO);
                menu.stop();
            } else {
                FlipMenu flipMenu = new FlipMenu("Все записи", false) {
                    @Override
                    protected void fillCommands() {
                        ArrayList<Note> notes = presenter.getAllNotes();
                        for (int i = 0; i < notes.size(); i++) {
                            this.addCommand(new OpenNote(i));
                        }
                    }
                };
                flipMenu.run();
            }

        } catch (Exception e) {
            notifier.add(e.getMessage(), NoticeType.ERROR);
        }
    }
}
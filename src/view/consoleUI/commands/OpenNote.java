package view.consoleUI.commands;

import model.Note;
import view.consoleUI.menu.*;
import view.consoleUI.notifications.NoticeType;

/**
 * Команда для открытия записи
 */
public class OpenNote extends Command{
    Note note;

    public OpenNote(int index) {
        this.note = presenter.getAllNotes().get(index);
    }

    public OpenNote(Note note) {
        this.note = note;
    }

    @Override
    public String getDescription() {
        String noteContent = note.getContent();
        if (noteContent.length() > 25) {
            return noteContent.substring(0, 25) + "<...>";
        }
        return noteContent;
    }

    @Override
    public void execute(Menu menu) {

        if (note != null){
            FlipMenu flipMenu = new FlipMenu(String.format("Меню работы с записью \"%s\"" ,getDescription()), false) {
                @Override
                public void fillCommands() {
                    clearCommands();
                    addCommand(new ShowFullContent(note));
                    addCommand(new ChangeNote(note));
                    addCommand(new RemoveNote(note));
                }
            };

            flipMenu.run();

        } else {
            notifier.add("Эта ошибка не должна была произойти. Ошибка в при открытии записи.", NoticeType.ERROR);
        }
    }
}
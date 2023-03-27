package view.consoleUI.commands;

import view.consoleUI.menu.FlipMenu;
import view.consoleUI.menu.Menu;
import view.consoleUI.notifications.NoticeType;

import java.util.List;

/**
 * Команда для создания и запуска меню открытия файла
 */
public class CreateFileOpeningMenu extends Command {
    @Override
    public String getDescription() {
        return "Открыть файл";
    }

    @Override
    public void execute(Menu menu) {
        try {
            FlipMenu flipMenu = new FlipMenu("Меню открытия файла", false) {
                @Override
                protected void fillCommands() {
                    List<String> list = presenter.getAllFilesNames("src/notepads");
                    for (String string : list) {
                        this.addCommand(new OpenFile("src/notepads", string));
                    }
                }
            };

            flipMenu.run();

        } catch (Exception e) {
            notifier.add("Что-то пошло не так", NoticeType.ERROR);
            notifier.add(e.getMessage(), NoticeType.ERROR);
        }
    }
}

package ui.menu;

import ui.UI;
import ui.menu.command.*;

public class FileOperationsMenu extends Menu {
    public FileOperationsMenu(UI view) {
        super(view, true, "Меню Сохранения/Загрузки\n",
                new SaveToFile(view),
                new LoadFromFile(view),
                new SetFileFormat(view)
        );
    }
}
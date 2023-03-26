package ui;

import java.util.ArrayList;

import ui.commands.Exit;
import ui.commands.InputNote;
import ui.commands.MenuCommand;
import ui.commands.ShowAllNotes;

public class Menu {
    String menuWelcome;
    int itemsCount;
    private ArrayList<MenuCommand> items;

    public Menu(ConsoleView view) {
        items = new ArrayList<>();
        this.menuWelcome = "Введите номер команды:";
        this.addCommand(new ShowAllNotes(view));
        this.addCommand(new InputNote(view));
        this.addCommand(new Exit(view));
        itemsCount = items.size();
    }

    public void addCommand(MenuCommand menuCommand) {
        items.add(menuCommand);
    }

    public String consoleView() {
        StringBuilder consoleView = new StringBuilder();
        int itemNumber = 1;
        consoleView.append(menuWelcome);
        consoleView.append("\n");
        for (MenuCommand item : items) {
            consoleView.append("\t");
            consoleView.append(itemNumber++);
            consoleView.append(". ");
            consoleView.append(item.description);
            consoleView.append("\n");
        }
        return consoleView.toString();
    }

    public void runMenuCommand(int menuItemNumber) {
        items.get(menuItemNumber - 1).run();
    }
}

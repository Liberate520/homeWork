package ui;

import java.util.ArrayList;

import ui.commands.MenuCommand;

public abstract class Menu {
    private ConsoleView view;
    private String menuWelcome;
    private int itemsCount;
    private ArrayList<MenuCommand> items;

    public Menu(ConsoleView view) {
        items = new ArrayList<>();
        this.view = view;
    }

    public void addCommand(MenuCommand menuCommand) {
        items.add(menuCommand);
        itemsCount = items.size();
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
            consoleView.append(item.description());
            consoleView.append("\n");
        }
        return consoleView.toString();
    }

    protected void setWelcome(String welcome) {
        this.menuWelcome = welcome;
    }

    public int getMenuCount() {
        return itemsCount;
    }

    public ConsoleView getView() {
        return view;
    }

    public void runMenuCommand(int menuItemNumber) {
        items.get(menuItemNumber - 1).run();
    }
}

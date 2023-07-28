package ru.gb.family_tree.view.menus;

import ru.gb.family_tree.view.console_ui.ConsoleUI;
import ru.gb.family_tree.view.commands.Command;
import java.util.ArrayList;
import java.util.List;

public abstract class Menu {
    List<Command> commandList;
    ConsoleUI consoleUI;

    public Menu(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        commandList = new ArrayList<>();
    }

    public int countItems() { return commandList.size(); }

    public String getMenu() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < countItems(); i++) {
            sb.append(i + 1).append(". ");
            sb.append(commandList.get(i).description);
            if (i < countItems() - 1) sb.append("\n");
        }
        return sb.toString();
    }

    boolean checkPreviousMenu() {
        return consoleUI.previousMenu() != null;
    }

    public void execute(int index) {
        commandList.get(index).execute();
    }
}
